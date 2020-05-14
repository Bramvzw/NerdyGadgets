import java.sql.*;

public class Connectie {
    private static String url = "jdbc:mysql://192.168.1.102:3306";
    private static String driverName = "mysql-connector-java-8.0.20.jar";
    private static String username = "root";
    private static String password = "ictm2m2";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
//        try {
//            Class.forName(driverName);
                try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
//        } catch (ClassNotFoundException ex) {
//            // log an exception. for example:
//            System.out.println("Driver not found.");
//        }
        return con;
    }
}

  /*
  Om een verbinding te maken:

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    con = Connectie.getConnection();
    stmt = con.createStatement();
    rs = stmt.executeQuery(sql);
   */
