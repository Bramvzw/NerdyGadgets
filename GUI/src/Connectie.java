import java.io.InputStream;
import java.util.logging.Logger;
import com.jcraft.jsch.*;
import com.jcraft.jsch.Session;

import javax.swing.*;
import java.util.logging.Level;

import java.sql.*;
import java.util.Properties;

public class Connectie {
    private static String url, driverName, username, password;
    private static Connection con;

    public static Connection getConnection(ComponentArray CA) {
        // gegevens van een gebruiker aangeven
        url = "jdbc:mysql://192.168.1.102:3306/nerdygadgets";
        driverName = "mysql-connector-java-8.0.20.jar";
        username = "root";
        password = "ictm2m2";


        // Opzetten van de SSH connectie
        Logger LOGGER = Logger.getLogger(Connectie.class.getName());
        int assigned_port = 1;
        try {

            String SshUser = "root";            // SSH loging username
            String SshPassword = "ictm2m2";     // SSH login password
            String SshHost = "192.168.1.102";   // hostname or ip or SSH server
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
            // Connectie aanmaken met de gegevens van de gebruiker
            try {
                con = DriverManager.getConnection(url, username, password);
                CA.setBoolConnectie(true);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
            finally {
                session.disconnect();
            }
        }
        catch (JSchException e) {

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (assigned_port == 0) {
            LOGGER.log(Level.SEVERE, "Port forwarding failed !");
        }
        return con;
    }

    public static Connection getConnectionLocalhost() {
        url = "jdbc:mysql://localhost:3306";
        driverName = "mysql-connector-java-8.0.20.jar";
        username = "root";
        password = "";


        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            // Foutmelding printen wanneer er geen connectie is met de localdatabase
            System.out.println("Let op! U heeft geen connectie met de lokale database (Zet XAMPP & MySQL aan)");
        }
        return con;
    }
}
