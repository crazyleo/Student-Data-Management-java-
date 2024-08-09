package Greet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class Greet extends HttpServlet {
	 
		String driver=null;
		 String url=null;
		 String username=null;
		 String password=null;
		 
		 ServletConfig sc=null;
		 
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 PrintWriter pw=null;
		 Statement st=null;
		 HttpSession hs=null;
		 String sql="select * from result where username = ? and password = ? ";
		 
		 public void init(ServletConfig sc){
				try {
					this.sc=sc;
					ServletContext set =sc.getServletContext();
					driver=set.getInitParameter("driver");
					url=set.getInitParameter("url");
					username=set.getInitParameter("username");
					password=set.getInitParameter("password");
					 
				 Class.forName(driver);		 
				  
				 con=DriverManager.getConnection(url,username,password); 
				}
				catch(Exception e) {
					e.printStackTrace();		
				}}
		 public void service(HttpServletRequest request, HttpServletResponse response){
			 //we are  writing the all main logic
			 //we are  writing the all main logic
				try {
					//fetch from data
					String usn=request.getParameter("usn");
					String pass=request.getParameter("pass");
				 
					//create medium
					ps=con.prepareStatement(sql);
					ps.setString(1, usn);
					ps.setString(2, pass);
					//execute the query
					rs=ps.executeQuery();
					//getting thePrint writer
					pw=response.getWriter();
					
					//feetching and displaying the data
					if(rs.next()==true) 
					{
						String Name=rs.getString(1);
						String UserName=rs.getString(2);
						String Password=rs.getString(3);
						int Mark1=rs.getInt(4);
						int Mark2=rs.getInt(5);
						int Mark3=rs.getInt(6);
						int Mark4=rs.getInt(7);
						int Mark5=rs.getInt(8);
						int Avg=rs.getInt(9);
						
						String z=String.valueOf(Avg);
						
						Cookie ck1=new Cookie("name",Name);
						Cookie ck2=new Cookie("pass",Password);
						Cookie ck3=new Cookie("avg",z);
						
						ck1.setMaxAge(60*60*60);
						ck2.setMaxAge(60*60*60);
						ck3.setMaxAge(60*60*60);
						
						response.addCookie(ck1);
						response.addCookie(ck2);
						response.addCookie(ck3);
						
						
						
						//creating session
						hs=request.getSession(true);
						
						//storing the session
						hs.setAttribute("Mark1",Mark1);
						hs.setAttribute("Mark2",Mark2);
						hs.setAttribute("Mark3",Mark3);
						hs.setAttribute("Mark4",Mark4);
						hs.setAttribute("Mark5",Mark5);
						
						
						pw.println("<html>");
						pw.println("<head>");
						pw.println("<meta charset=\"ISO-8859-1\">");
						pw.println("<title>Student Information</title>");
						pw.println("<style type=\"text/css\">");
						pw.println("body {");
						pw.println("  font-family: Arial, sans-serif;");
						pw.println("  background: linear-gradient(grey);"); // Linear gradient of red and yellow
						pw.println("  margin: 0;");
						pw.println("  padding: 0;");
						pw.println("}");
						pw.println("table {");
						pw.println("  width: 80%;");
						pw.println("  margin: 20px auto;");
						pw.println("  border-collapse: collapse;");
						pw.println("  border-radius: 8px;");
						pw.println("  overflow: hidden;");
						pw.println("  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
						pw.println("  background-color: #fff;"); // White table background color
						pw.println("}");
						pw.println("th {");
						pw.println("  border: 1px solid #ddd;");
						pw.println("  padding: 12px;");
						pw.println("  text-align: center;");
						pw.println("  color: white;");
						pw.println("}");
						pw.println("th {");
						pw.println("  background-color: #3498db;");
						pw.println("}");
						pw.println("tr:hover {");
						pw.println("  background-color: #f0f0f0;");
						pw.println("}");
						pw.println("td {");
						pw.println("  border: 2px solid #000;");
						pw.println("  padding: 12px;");
						pw.println("  text-align: center;");
						pw.println("  background-color: grey;");
						pw.println("  color: black;");
						pw.println("}");
						pw.println("@media screen and (max-width: 600px) {");
						pw.println("  table {");
						pw.println("    width: 100%;");
						pw.println("  }");
						pw.println("}");
						pw.println("</style>");
						pw.println("</head>");
						pw.println("<body>");
						pw.println("<form>");
						pw.println("<div style=\"text-align: center;\">");
						pw.println("<h1>STUDENT DATA</h1>");
						pw.println("<table border=1>");
						pw.println("<tr><th>Name</th><th>UserName</th><th>Password</th><th>Mark1</th><th>Mark2</th><th>Mark3</th><th>Mark4</th><th>Mark5</th><th>Avg</th></tr>");
						pw.println("<tr><td>"+Name+"</td><td>"+UserName+"</td><td>"+Password+"</td><td>"+Mark1+"</td><td>"+Mark2+"</td><td>"+Mark3+"</td><td>"+Mark4+"</td><td>"+Mark5+"</td><td>"+Avg+"</td></tr>");
						pw.println("</table>");
						pw.println("</div>");
						pw.println("</form>");
						pw.println("</body>");
						pw.println("</html>");

					

						//pw.println("successfully logged in "+Name);
						
						//pw.println(Name+"  |  "+UserName+"  |  "+Password+"  |  "+Mark1+"  |  "+Mark2+"  |  "+Avg+"|");
						 
					}
					else {
						response.sendRedirect("/project_2/incorrect.html");
					}
					//servlet chaining
				request.getServletContext()
					.getRequestDispatcher("/Percentage").include(request, response);
				}
				catch(Exception e) {
					e.printStackTrace();
				}}
			
			public void destroy() {
				//closing all the resource
				 try {
					 con.close();
					 ps.close();
					 rs.close();
					 pw.close();		 
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }
			} 

}

