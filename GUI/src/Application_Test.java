import java.io.IOException;
import java.sql.*;

public class Application_Test {
    public static void main(String[] args) throws SQLException, IOException {
        Lijst l1 = new Lijst();
        Applicatie app1 = new Applicatie(l1);

    }
}
