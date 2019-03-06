package jdbchibernate;

import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JDBCDemo {
  public static void main(String[] args) {
    try {
      //MySql
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "demo", "1234");
      Statement stat = con.createStatement();
      System.out.println("Created DB Connection....");
      stat.executeUpdate("CREATE TABLE USERS (username char(20), login char(20), email char(40))");
      stat.executeUpdate("INSERT INTO USERS VALUES ('Karol', 'karolus','karolus@portal.com')");
      stat.executeUpdate("INSERT INTO USERS VALUES ('Maja', 'majka','majka12345@goole.com')");
      ResultSet result = stat.executeQuery("SELECT username, login, email FROM USERS;");
      while (result.next()) {
        System.out.println(result.getString(1) + " " + result.getString(2)+" "+result.getString(3));
      }
      stat.executeUpdate("DROP TABLE USERS");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    System.out.println("DB Connection closed ....");
  }
}
