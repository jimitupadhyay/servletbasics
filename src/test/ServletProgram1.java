package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
		
@WebServlet(
		urlPatterns = "/hello",
		initParams = {
                @WebInitParam(name = "emailSupport1", value = "asd@asd.asd"),
                @WebInitParam(name = "emailSupport2", value = "qaz@qaz.qaz")
        }
		) //PATH ANNOTION
public class ServletProgram1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private String emailSupport1;
	
	public ServletProgram1()
	{
		
	}
	
	//This method is called once after Servlet object is created
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		//Get the value of the initialization parameter of the servlet
		this.emailSupport1  = config.getInitParameter("emailSupport1");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		//Get the initialized string value in different way
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		
		//ServletOutputStream class is used to send data to web-browser
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>1. doGet Method - This is Title</title></head>");
		out.println("<body><h1>This is doGet Method</h1></body>");
		out.println("<p>FIrst Value is "+ this.emailSupport1 +"</p>");
		out.println("<p>Second Value is "+emailSupport2+"<p>");
		out.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		this.doGet(request, response);
	}
	
}

