import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Viewevent extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();    
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");  
              
PreparedStatement ps=con.prepareStatement("select * from event");  
              
out.println("<html><body><table width=50% border=1>");  
out.println("<caption>Result:</caption>");  
  
ResultSet rs=ps.executeQuery();  
              
/* Printing column names */  
ResultSetMetaData rsmd=rs.getMetaData();  
int total=rsmd.getColumnCount();  
out.println("<tr>");  
for(int i=1;i<=total;i++)  
{  
out.println("<th>"+rsmd.getColumnName(i)+"</th>");  
}  
  
out.println("</tr>");  
              
/* Printing result */  
  
while(rs.next())  
{  String a = rs.getString("eventtitle");
   String b = rs.getString("eventid");
   String c = rs.getString("eventtype");
   String d = rs.getString("eventdesc");
   String e = rs.getString("eventdate");
   String f = rs.getString("eventtime");
   String g = rs.getString("eventdur");
   String h = rs.getString("eventoption");
   
out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td></tr>");  
                  
}  
  
out.println("</table></body></html>");  
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  
  
}  
}  