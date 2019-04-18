import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;  

public class Registerstu extends HttpServlet {
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("userName");
		String e=request.getParameter("userEmail");
                String p=request.getParameter("userPhone");
                String a=request.getParameter("userAge");
                String g=request.getParameter("userGender");
                String en=request.getParameter("userEnrollno");
		String po=request.getParameter("userPosition");
                String ev=request.getParameter("userEventid");
                
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,e);
                ps.setString(3,p);
                ps.setString(4,a);
                ps.setString(5,g);
                ps.setString(6,en);
		ps.setString(7,po);
                ps.setString(8,ev);
               
               
		int i=ps.executeUpdate();
		if(i>0)
                {    
                   RequestDispatcher rd=request.getRequestDispatcher("homestu.html");  
                   rd.forward(request,response);  
                    
               
                }
		
			
		} catch (Exception e2) {System.out.println(e2);}  
          
                  out.close();  
                   }  
  
		
	

}
