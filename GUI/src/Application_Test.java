import java.sql.*;

public class Application_Test {
    public static void main(String[] args) throws SQLException {
        Lijst c1 = new Lijst();
        Applicatie app1 = new Applicatie(c1);


        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "bramvz";

        try{
            Connection myConn = DriverManager.getConnection(url,user,password);
            Statement myStmt = myConn.createStatement();
            String sql = "Select * FROM componenten.component";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                int TK = rs.getInt("Type_key");
                String type = rs.getString("Type");
                String Naam = rs.getString("Naam");
                double Beschikbaarheid = rs.getDouble("Beschikbaarheid");
                int Prijs = rs.getInt("Prijs");
                double PB = rs.getDouble("Processorbelasting");
                double Diskruimte = rs.getDouble("Diskruimte");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id, TK, type, Naam, Beschikbaarheid, Prijs, PB, Diskruimte);


            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
