package jdbchibernate;

import java.sql.*;

public class ConcurUpdatableResultSet {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //MySql
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/kratka?serverTimezone=UTC", "root", "")){
            System.out.println("Creating statement with scroll sensitive and updateble");
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stat.executeUpdate("CREATE TABLE USERS (id int(11) not null primary key, username char(20), login char(20), email char(40))");
            stat.executeUpdate("INSERT INTO USERS VALUES (1, 'Karol', 'karolus','karolus@portal.com')");
            stat.executeUpdate("INSERT INTO USERS VALUES (2, 'Maja', 'majka','majka12345@goole.com')");
            ResultSet set = stat.executeQuery("SELECT * FROM USERS");
            System.out.println("Printing all rows in set");
            printSet(set);
            System.out.println("Modify column email in first row ");
            set.beforeFirst();
            while (set.next()){
                if (set.getInt("id") == 1) {
                    set.updateString("email", "karolek@karolkowo.pl");
                    set.updateRow();
                }
            }
            System.out.println("Moving cursor before first row.");
            set.beforeFirst();
            System.out.println("Printing all rows in set");
            printSet(set);
            set.beforeFirst();
            System.out.println("Inserting new row after row with id = 2");
            while(set.next()){
                if (set.getInt("id") == 2) {
                    set.moveToInsertRow();
                    set.updateInt("id", 3);
                    set.updateString("username", "kazik");
                    set.updateString("login","kaziuk");
                    set.updateString("email", "kaziutek@bagiety.io");
                    set.insertRow();
                }
            }
            set.beforeFirst();
            System.out.println("Set after inserting");
            printSet(set);
            set.beforeFirst();
            System.out.println("Deleting last row");
            while (set.next()){
                if (set.getInt("id") == 3) {
                    set.deleteRow();
                }
            }
            System.out.println("Set after deleting");
            set.beforeFirst();
            printSet(set);
            stat.executeUpdate("DROP TABLE USERS");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printSet(ResultSet set) throws SQLException {
        System.out.println("********************************");
        while(set.next()){
            System.out.println(set.getString("username") +"  " + set.getString("login") +" "+ set.getString("email"));
        }
        System.out.println("********************************");
    }


}
