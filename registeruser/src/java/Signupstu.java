import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Signupstu extends HttpServlet {
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
                String p=request.getParameter("pass");
		
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");
		PreparedStatement ps=con.prepareStatement("insert into logstu values(?,?)");
		ps.setString(1,n);
		ps.setString(2,p);
               
                
		int i=ps.executeUpdate();
		if(i>0)
                { 
		RequestDispatcher rd=request.getRequestDispatcher("homestu.html");  
                rd.forward(request,response);  }	
		}
                catch (Exception e2)
                {System.out.println(e2);}
		
		out.close();
	}

}
