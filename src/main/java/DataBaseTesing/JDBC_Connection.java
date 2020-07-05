package DataBaseTesing;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_Connection {
//    String host = "localhost";
//    String port = "3306";
public static void main(String[] args) throws ClassNotFoundException, SQLException {


       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:msql://localhost:3306/credicardbanking",
               "root", "Neelraj11");
       System.out.println("DataBase is connected");
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from credential where scenario='zerobalancecard'");
       while (rs.next()) {
           rs.getString("username");
           rs.getString("password");
       }
   }
}

