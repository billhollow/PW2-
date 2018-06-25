package controller.employees;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class EmployeeControllerCreate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{




		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			dp.forward(request, response);
		}
		else{
			PersistenceManager pm2 = PMF.get().getPersistenceManager();
			String query = "select from " + User.class.getName() +
					" where email=='" + uGoogle.getEmail() + "'" +
					" && status==true";
			List<User> uSearch = (List<User>) pm2.newQuery(query).execute();
			if(uSearch.isEmpty()){
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error2.jsp");
				dp.forward(request, response);
			}
			else{
				String query2 = "select from " + Resource.class.getName() +
						" where name=='" + request.getServletPath() + "'" +
						" && status==true";
				List<Resource> rSearch = (List<Resource>)pm2.newQuery(query2).execute();
				if( rSearch.isEmpty()){
					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error3.jsp");
					dp.forward(request, response);
				}
				else{
					String query3 = "select from " + Access.class.getName() +
							" where role==" + uSearch.get(0).getRole() +
							" && resource==" + rSearch.get(0).getId() +
							" && status==true";
					List<Access> aSearch = (List<Access>) pm2.newQuery(query3).execute();
					if(aSearch.isEmpty()){
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error4.jsp");
						dp.forward(request, response);
					}else{


						if(request.getParameter("action").equals("creating")){
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Employees/employeeCreate.jsp");
							dispatcher.forward(request, response);
						}
						else{
							boolean duplicado=false;
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();

							List<Employee> employees = (List<Employee>)pm.newQuery(Employee.class).execute();
							for(int i = 0;i<employees.size() && employees.get(i) != null;i++){
								if(request.getParameter("dni").equals(employees.get(i).getDni()))
									duplicado = true;
							}
							if(duplicado){
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error0.jsp");
								dispatcher.forward(request, response);
							}
							else{
								// create the new employee
								Employee a = new Employee(
										request.getParameter("name"),
										request.getParameter("age"),
										request.getParameter("salary"),
										request.getParameter("address"),
										request.getParameter("dni"),
										request.getParameter("email"));



								// persist the entity
								try { 
									pm.makePersistent(a);
								} finally {
									pm.close();
								}

								//		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeeDisplay.jsp");
								//	 dispatcher.forward(request, response); 
								response.sendRedirect("/employees");
							}
						}
					}
				}
			}
		}
	}
}
