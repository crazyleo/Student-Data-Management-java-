package Greet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class Validation extends HttpServlet {
	 
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			//fetch from data
			String usn=req.getParameter("usn");
			String pass=req.getParameter("pass");
			
			//validation
			if(usn.length()>3&&pass.length()==0) {
				res.sendRedirect("/project_2/invalid.html");
			}
			else {
				//servlet chaining
				req.getServletContext().getRequestDispatcher("/Greet").forward(req, res);
	}
	 
}
		catch(Exception e) {
			e.printStackTrace();
			
			}
		}}

