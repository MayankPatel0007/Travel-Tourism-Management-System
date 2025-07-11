package travel.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","2005");
            s=c.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}