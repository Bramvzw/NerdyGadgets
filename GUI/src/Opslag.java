import java.sql.*;
import java.util.ArrayList;
import java.util.function.BinaryOperator;


public class Opslag {

    public static void main(String[] args) {
        Opslag o = new Opslag();
        ArrayList<Componenten> c = new ArrayList<Componenten>();
        c.add(new Componenten("firewall","naam",99.99,1000));
        o.slaOp(c);
    }
    private Connection con = Connectie.getConnectionLocalhost();
    private PreparedStatement pstmt;
    private Statement stmt;

    public void slaOp(ArrayList<Componenten> componenten) {
        if(checkDatabase()) {
            for (Componenten component : componenten) {
                try {
                    pstmt = con.prepareStatement("INSERT INTO componenten()");
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                    }
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (SQLException SQLe) {
                            SQLe.printStackTrace();
                        }
                    }
                }
            }
        }
        else{
            nieuwDatabase();
            slaOp(componenten);
        }

    }

    public boolean checkDatabase(){
//        try {
//            pstmt = con.prepareStatement("IF (EXISTS (SELECT * \n" +
//                    "                 FROM INFORMATION_SCHEMA.TABLES \n" +
//                    "                 WHERE TABLE_SCHEMA = 'TheSchema' \n" +
//                    "                 AND  TABLE_NAME = 'TheTable'))\n" +
//                    "BEGIN\n" +
//                    "    --Do Stuff\n" +
//                    "END");
//            ResultSet rs = pstmt.executeQuery();
//        }
//        catch(SQLException sqle){
//            sqle.printStackTrace();
//        }
        return false;
    }

    public void nieuwDatabase(){
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("Create database infrastructuur;");
            stmt.executeQuery("CREATE TABLE componenten (Id int, Type varchar(50),Naam varchar(50), Beschikbaarheid double,Prijs int, Host varchar(50))");

            System.out.println("Database created successfully...");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();

            }

        }
    }
}
