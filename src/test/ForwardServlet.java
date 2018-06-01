package test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.RequestDispatcher;

@WebServlet("/forward-demo")
public class ForwardServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Request:
    // /forward-demo?forward=true
    @Override
			public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				String forward = request.getParameter("forward");
				
				ServletOutputStream out = response.getOutputStream();
				
				 if ("true".equals(forward)) {
			            System.out.println("Forward to ShowMeServlet");
			            // Set data to attribute of the request.
			            request.setAttribute("key", 
			                    "Hi, I'm Tom come from Walt Disney !");
			 
			            RequestDispatcher dispatcher //
			                    = request.getServletContext().getRequestDispatcher("/showMe");
			            dispatcher.forward(request, response);
			 
			            return;
			        }
			      //  ServletOutputStream out = response.getOutputStream();
			        out.println("<h3>Text of ForwardDemoServlet</h3>");
			        out.println("- servletPath=" + request.getServletPath());
			    }
			 
			    @Override
			    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			            throws ServletException, IOException {
			        this.doGet(request, response);
			    }
}
