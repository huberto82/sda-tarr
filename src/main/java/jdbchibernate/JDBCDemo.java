package jdbchibernate;

import java.sql.*;

public class JDBCDemo {
  public static void main(String[] args) {
    try {
      //MySql
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/kratka?serverTimezone=UTC", "root", "");
      Statement stat = con.createStatement();
      System.out.println("Created DB Connection....");
      System.out.println("Dealut values for statement properties");
      System.out.print("Transaction isolation: ");
      switch(con.getTransactionIsolation()){
        case Connection.TRANSACTION_NONE:
          System.out.println("NONE");
          break;
        case Connection.TRANSACTION_READ_UNCOMMITTED:
          System.out.println("READ_UNCOMITTED");
          break;
        case Connection.TRANSACTION_READ_COMMITTED:
          System.out.println("READ_COMMITED");
          break;
        case Connection.TRANSACTION_REPEATABLE_READ:
          System.out.println("REAPEATABLE_READ");
          break;
        case Connection.TRANSACTION_SERIALIZABLE:
          System.out.println("SERIALIZABLE");
          break;
      }

      System.out.println("Autocommit state: " + con.getAutoCommit());

      System.out.print("Scrollability: ");
      switch (stat.getResultSetType()){
        case ResultSet.TYPE_FORWARD_ONLY:
          System.out.println("FORWARD_ONLY");
          break;
        case ResultSet.TYPE_SCROLL_INSENSITIVE:
          System.out.println("SCROLL_INTENSITIVE");
          break;
        case ResultSet.TYPE_SCROLL_SENSITIVE:
          System.out.println("SCROLL_SENSITIVE");
          break;
      }

      System.out.print("Concurrency: ");
      switch(stat.getResultSetConcurrency()){
        case ResultSet.CONCUR_READ_ONLY:
          System.out.println("READ_ONLY");
          break;
        case ResultSet.CONCUR_UPDATABLE:
          System.out.println("UPDATABLE");
          break;
      }

      System.out.print("Holdability: ");
      switch(stat.getResultSetHoldability()){
        case ResultSet.CLOSE_CURSORS_AT_COMMIT:
          System.out.println("CLOSE CURSOR");
          break;
        case ResultSet.HOLD_CURSORS_OVER_COMMIT:
          System.out.println("HOLD CURSOR");
          break;
      }

      stat.executeUpdate("CREATE TABLE USERS (username char(20), login char(20), email char(40))");
      stat.executeUpdate("INSERT INTO USERS VALUES ('Karol', 'karolus','karolus@portal.com')");
      stat.executeUpdate("INSERT INTO USERS VALUES ('Maja', 'majka','majka12345@goole.com')");
      ResultSet result = stat.executeQuery("SELECT username, login, email FROM USERS;");
      while (result.next()) {
        System.out.println(result.getString(1) + " " + result.getString(2)+" "+result.getString(3));
      }
      stat.executeUpdate("DROP TABLE USERS");
      con.close();
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
