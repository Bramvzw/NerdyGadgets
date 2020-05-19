import java.io.InputStream;
import java.util.logging.Logger;
import com.jcraft.jsch.*;
import com.jcraft.jsch.Session;
import java.util.logging.Level;

import java.sql.*;
import java.util.Properties;

public class Connectie {
    private static String url = "jdbc:mysql://192.168.1.102:3306/nerdygadgets";
    private static String driverName = "mysql-connector-java-8.0.20.jar";
    private static String username = "root";
    private static String password = "ictm2m2";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
//        try {
//            Class.forName(driverName);
        Logger LOGGER = Logger.getLogger(Connectie.class.getName());
        int assigned_port = 1;
        try {

            String SshUser = "root";            // SSH loging username
            String SshPassword = "ictm2m2";     // SSH login password
            String SshHost = "192.168.1.102";   // hostname or ip or SSH server
            int nSshPort = 22;                  // remote SSH host port number
            String RemoteHost = "192.168.1.102";

            JSch jsch = new JSch();
            Session session = jsch.getSession(SshUser, SshHost, 22);
            session.setPassword(SshPassword);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(1000);

            session.connect();
            assigned_port = session.setPortForwardingL(3306, RemoteHost, 3306);

//            Class.forName("com.mysql.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
            finally {
                session.disconnect();
            }
        }
        catch (JSchException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (assigned_port == 0) {
            LOGGER.log(Level.SEVERE, "Port forwarding failed !");
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
