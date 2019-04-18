import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Viewstudent extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter(); 
String eventid=request.getParameter("usereventid");  
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");  
              
PreparedStatement ps=con.prepareStatement("select * from register where eventid=?");
ps.setString(1,eventid);
              
out.println("<html><body><table width=50% border=1>");  
out.println("<caption>Particpant details:</caption>");  
  
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
{  String a = rs.getString("name");
   String b = rs.getString("email");
   String c = rs.getString("phone");
   String d = rs.getString("age");
   String e = rs.getString("gender");
   String f = rs.getString("enrollno");
   String g = rs.getString("position");
   String h = rs.getString("eventid");
   
out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td></tr>");  
                  
}  
  
out.println("</table></body></html>");  
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  
  
}  
}  