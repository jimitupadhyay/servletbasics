package test;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

@WebServlet(
		urlPatterns =  {"/login"}
		)
public class LoginServlet  extends HttpServlet {
				
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session = request.getSession();
		
		User user = new User("jimit", 24);
		
		session.setAttribute("key", user);
		
		out.println("<a href='dashboard'>Click to login</a>");
		
	}
}
