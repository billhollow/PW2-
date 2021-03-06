package controller.accesses;
import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import java.util.List;
import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class AccessControllerUpdate extends HttpServlet {
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



						if(request.getParameter("action").equals("updating")){
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();
							//llenando de roles
							String query2 = "select from " + Role.class.getName();
							List<Role> roles = (List<Role>)pm.newQuery(query2).execute();
							request.setAttribute("roles", roles);
							//llenando de recursos
							String query3 = "select from " + Resource.class.getName();
							List<Resource> resources = (List<Resource>)pm.newQuery(query3).execute();
							request.setAttribute("resources", resources);

							String query = "select from " + Access.class.getName();
							List<Access> accesses = (List<Access>)pm.newQuery(query).execute();
							for(int i = 0;i<accesses.size() && accesses.get(i) != null;i++){
								if(accesses.get(i).getId()== Long.parseLong((request.getParameter("accessId")))){
									request.setAttribute("access", accesses.get(i));
									RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Accesses/accessUpdate.jsp");
									dispatcher.forward(request, response);
									break;
								}
							}
							pm.close();
						}
						else{
							Access aux = new Access();
							// create the persistence manager instance
							PersistenceManager pm = PMF.get().getPersistenceManager();

							String query2 = "select from " + Role.class.getName();
							List<Role> roles = (List<Role>)pm.newQuery(query2).execute();
							String query3 = "select from " + Resource.class.getName();
							List<Resource> resources = (List<Resource>)pm.newQuery(query3).execute();
							String query = "select from " + Access.class.getName();
							List<Access> accesses = (List<Access>)pm.newQuery(query).execute();
							for(int i = 0;i<accesses.size() && accesses.get(i) != null;i++){
								if(accesses.get(i).getId()== Long.parseLong((request.getParameter("accessId")))){
									aux = accesses.get(i);
									for(int j = 0;j<roles.size();j++){
										if(roles.get(j).getName().equals(request.getParameter("role"))){
											aux.setRole(roles.get(j).getId());
											break;
										}
									}
									for(int j = 0;j<resources.size();j++){
										if(resources.get(j).getName().equals(request.getParameter("resource"))){
											aux.setResource(resources.get(j).getId());
											break;
										}
									}
									break;
								}
							}
							aux.setStatus(Boolean.valueOf(request.getParameter("status")));
							pm.close();
							response.sendRedirect("/accesses");
						}
					}
				}
			}
		}
	}
}
