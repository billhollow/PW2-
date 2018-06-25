package controller.employees;
import java.io.IOException;
import javax.servlet.http.*;
import java.util.List;
import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import com.google.appengine.api.users.UserServiceFactory;
import controller.PMF;

@SuppressWarnings("serial")
public class EmployeeControllerIndex extends HttpServlet {
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


						PersistenceManager pm = PMF.get().getPersistenceManager();
						// create the persistence manager instance
						// query for the entities by name
						String query4 = "select from " + Employee.class.getName();
						List<Employee> employees2 = (List<Employee>)pm.newQuery(query4).execute();
						// pass the list to the jsp
						pm.close();
						request.setAttribute("employees", employees2);
						// forward the request to the jsp
						RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/WEB-INF/Views/Employees/employeeDisplay.jsp");
						dispatcher2.forward(request, response); 

					}
				}
			}
		}
	}
}
