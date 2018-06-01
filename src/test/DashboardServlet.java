package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
			
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{
		
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session  = request.getSession();
		
		User userInfo = (User) session.getAttribute("key");
		
		if(userInfo == null) {
			
			response.sendRedirect(this.getServletContext().getContextPath() + "/login");
			
			return;
			
		}
		
		out.println("<br/> User name is => "+ userInfo.getName());
		out.println("<br/> User age is => "+ userInfo.getAge());
		
	}
	
}
