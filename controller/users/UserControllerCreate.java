package controller.users;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class UserControllerCreate extends HttpServlet {
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




						if(request.getParameter("action").equals("creating")){
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();
							// query for the entities by name
							String query = "select from " + Role.class.getName();
							List<Role> roles = (List<Role>)pm.newQuery(query).execute();
							request.setAttribute("roles", roles);
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/userCreate.jsp");
							dispatcher.forward(request, response);
						}
						else{
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();
							String query = "select from " + Role.class.getName();
							List<Role> roles = (List<Role>)pm.newQuery(query).execute();
							User a = new User();
							for(int i = 0;i<roles.size();i++){
								if(roles.get(i).getName().equals(request.getParameter("role"))){
									a = new User(request.getParameter("email"),roles.get(i).getId());
									a.setStatus(Boolean.valueOf(request.getParameter("status")));
									break;
								}
							}
							try { 
								pm.makePersistent(a);
							} finally {
								pm.close();
							}

							response.sendRedirect("/users");

						}
					}
				}
			}
		}
	}
}
