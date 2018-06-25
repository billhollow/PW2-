package controller.employees;
import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import java.util.List;
import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class EmployeeControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			dp.forward(request, response);
		}
		else{
			PersistenceManager pm2 = PMF.get().getPersistenceManager();
			String query10 = "select from " + User.class.getName() +
					" where email=='" + uGoogle.getEmail() + "'" +
					" && status==true";
			List<User> uSearch = (List<User>) pm2.newQuery(query10).execute();
			if(uSearch.isEmpty()){
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error2.jsp");
				dp.forward(request, response);
			}
			else{
				String query11 = "select from " + Resource.class.getName() +
						" where name=='" + request.getServletPath() + "'" +
						" && status==true";
				List<Resource> rSearch = (List<Resource>)pm2.newQuery(query11).execute();
				if( rSearch.isEmpty()){
					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error3.jsp");
					dp.forward(request, response);
				}
				else{
					String query12 = "select from " + Access.class.getName() +
							" where role==" + uSearch.get(0).getRole() +
							" && resource==" + rSearch.get(0).getId() +
							" && status==true";
					List<Access> aSearch = (List<Access>) pm2.newQuery(query12).execute();
					if(aSearch.isEmpty()){
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error4.jsp");
						dp.forward(request, response);
					}else{


						if(request.getParameter("action").equals("deleting")){
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();
							// query for the entities by name
							String query = "select from " + Employee.class.getName();
							List<Employee> employees = (List<Employee>)pm.newQuery(query).execute();
							for(int i = 0;i<employees.size() && employees.get(i) != null;i++){
								if(employees.get(i).getId()== Long.parseLong((request.getParameter("employeeId")))){
									pm.deletePersistent(employees.get(i));
									break;
								}
							}
							pm.close();
							response.sendRedirect("/employees");
						}
						else{
							System.out.println("Error");
						}
					}
				}
			}
		}
	}
}
