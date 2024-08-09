package Greet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class Percentage extends HttpServlet {
	PrintWriter pw=null;
	HttpSession hs=null;
	 
		public void service(HttpServletRequest request, HttpServletResponse response){
			 //we are  writing the all main logic
			try {
				//fetch from data
				response.setContentType("text/html");
			    pw=response.getWriter();
			    
			    hs=request.getSession();
			 
				 
				//feetching and displaying the data
				 
					int Mark1=(int) hs.getAttribute("Mark1");
					int Mark2=(int) hs.getAttribute("Mark2");
					int Mark3=(int) hs.getAttribute("Mark3");
					int Mark4=(int) hs.getAttribute("Mark4");
					int Mark5=(int) hs.getAttribute("Mark5");
					float per=((float)(Mark1+Mark2+Mark3+Mark4+Mark5)/500)*100;
					
					pw.println("<html>");
					pw.println("<head>");
					pw.println("<title>Result Details</title>");
					pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
					pw.println("<style>");
					pw.println("body {");
					pw.println("  font-family: Arial, sans-serif;");
					pw.println("  background: radial-gradient(grey);"); // Grey background with blue radial gradient
					pw.println("  margin: 0;");
					pw.println("  padding: 0;");
					pw.println("}");
					pw.println("h1, h2 {");
					pw.println("  color: #ff3333;");
					pw.println("  text-align: center;");
					pw.println("  margin-top: 30px;");
					pw.println("}");
					pw.println("button {");
					pw.println("  width: 100px;");
					pw.println("  height: 50px;");
					pw.println("  margin: 30px auto;");
					pw.println("  display: block;");
					pw.println("  color: white;");
					pw.println("  background-color: #0073e6;");
					pw.println("  border: none;");
					pw.println("  border-radius: 4px;");
					pw.println("  cursor: pointer;");
					pw.println("}");
					pw.println("table {");
					pw.println("  width: 80%;");
					pw.println("  border-collapse: collapse;");
					pw.println("  margin: 30px auto;");
					pw.println("  background-color: #fff;"); // White table color
					pw.println("}");
					pw.println("th {");
					pw.println("  border: 2px solid #000;");
					pw.println("  padding: 12px;");
					pw.println("  text-align: center;");
					pw.println("}");
					pw.println("td {");
					pw.println("  border: 2px solid #000;");
					pw.println("  padding: 12px;");
					pw.println("  text-align: center;");
					pw.println("  background-color: grey;");
					pw.println("  color: black;");
					pw.println("}");
					pw.println("th {");
					pw.println("  background-color: blue;"); // Blue color for table headings
					pw.println("  color: white;");
					pw.println("}");
					pw.println("tr:hover {");
					pw.println("  background-color: #f5f5f5;");
					pw.println("}");
					pw.println("@media screen and (max-width: 600px) {");
					pw.println("  table {");
					pw.println("    width: 100%;");
					pw.println("  }");
					pw.println("}");
					pw.println("</style>");
					pw.println("</head>");
					pw.println("<body>");
					pw.println("<form action=\"/project_2/data.html\">");
					pw.println("<div style=\"text-align: center;\">");
					pw.println("<h1>RESULT DETAILS</h1>");
					pw.println("<table border=1>");
					pw.println("<tr><th>Subject</th><th>Score</th></tr>");
					pw.println("<tr><td>Tamil</td><td>"+Mark1+"</td></tr>");
					pw.println("<tr><td>Maths</td><td>"+Mark2+"</td></tr>");
					pw.println("<tr><td>Science</td><td>"+Mark3+"</td></tr>");
					pw.println("<tr><td>English</td><td>"+Mark4+"</td></tr>");
					pw.println("<tr><td>Social Science</td><td>"+Mark5+"</td></tr>");
					pw.println("</table>");
					pw.println("<h2>Overall Percentage is "+per+"%</h2>");
					pw.println("<button type=\"submit\">Exit</button>");
					pw.println("</div>");
					pw.println("</form>");
					pw.println("</body>");
					pw.println("</html>");





					 
				 //  pw.println("Mark1= "+Mark1+"\n"+"Mark2= "+ Mark2+"\n"+"The percentage = "+per);		 
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		
		 
		

    
}

