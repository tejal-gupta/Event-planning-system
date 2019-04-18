import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String username,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull","root","");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from logs where username=? and pass=?");  
ps.setString(1,username);  
ps.setString(2,pass);  
     
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  
