import java.sql.*;

public class Application_Test {
    public static void main(String[] args) throws SQLException {
        Lijst l1 = new Lijst();
        Applicatie app1 = new Applicatie(l1);
    }
}
