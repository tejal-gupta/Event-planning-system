import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Createevent extends HttpServlet {
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String t=request.getParameter("eventtitle");
		String id=request.getParameter("eventid");
                String ty=request.getParameter("eventtype");
                String de=request.getParameter("eventdesc");
                String da=request.getParameter("eventdate");
                String ti=request.getParameter("eventtime");
		String du=request.getParameter("eventdur");
                String op=request.getParameter("eventoption");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");
		PreparedStatement ps=con.prepareStatement("insert into event values(?,?,?,?,?,?,?,?)");
		ps.setString(1,t);
		ps.setString(2,id);
                ps.setString(3,ty);
                ps.setString(4,de);
                ps.setString(5,da);
                ps.setString(6,ti);
		ps.setString(7,du);
                ps.setString(8,op);
		
		int i=ps.executeUpdate();
		if(i>0)
                {RequestDispatcher rd=request.getRequestDispatcher("home.html");  
                rd.forward(request,response);}
		
			
		}
                catch (Exception e2)
                {System.out.println(e2);}
		
		out.close();
	}

}
