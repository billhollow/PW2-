package controller.users;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;


@SuppressWarnings("serial")
public class UserControllerLogin  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		if(user == null){
			response.sendRedirect(us.createLoginURL("/users/login"));	
		}else{
			request.setAttribute("email", user.getEmail());
			System.out.println(user.getEmail());
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/login.jsp");
			dp.forward(request, response);
		}
		

	}
}
