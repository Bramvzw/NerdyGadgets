import java.sql.*;
import java.util.ArrayList;
import java.util.function.BinaryOperator;


public class Opslag {

    public static void main(String[] args) {
        Opslag o = new Opslag();
        ArrayList<Componenten> c = new ArrayList<Componenten>();
        c.add(new Componenten("firewall","naam",99.99,1000));
        o.slaOp(c,"groep1");
        o.ophalenComponten(1);
    }
    private Connection con = Connectie.getConnectionLocalhost();
    private PreparedStatement pstmt;
    private Statement stmt;

    public void slaOp(ArrayList<Componenten> componenten, String groepNaam) {
        nieuwDatabase();
        int groepID =  volgendeGroepID();
        for (Componenten component : componenten) {
            try {
            pstmt = con.prepareStatement("INSERT INTO infrastructuur.componenten VALUES (?,?,?,?,?,?,?,?);");
            pstmt.setInt(1, component.getID());
            pstmt.setString(2, component.getType());
            pstmt.setString(3, component.getNaam());
            pstmt.setDouble(4, component.getBeschikbaarheid());
            pstmt.setInt(5, component.getPrijs());
            pstmt.setString(6, component.getHost());
            pstmt.setInt(7, groepID);
            pstmt.setString(8, groepNaam);
            pstmt.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    }
                    catch(SQLException SQLe) {
                        SQLe.printStackTrace();
                    }
                }
                try{
                    if(con!=null)
                        con.close();
                }
                catch(SQLException se){
                    se.printStackTrace();

                }
            }
        }

    }

    public int volgendeGroepID() {
        int id = 0;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(GroepID) FROM infrastructuur.componenten;");
            while(rs.next()){
                id = rs.getInt("MAX(GroepID)");
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do

        }
        return id + 1;
    }

    public void nieuwDatabase(){
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS infrastructuur;");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS infrastructuur.componenten (" +
                    "    Id int NOT NULL," +
                    "    Type varchar(50)," +
                    "    Naam varchar(50)," +
                    "    Beschikbaarheid double," +
                    "    Prijs int," +
                    "    Host varchar(50)," +
                    "    GroepID int NOT NULL," +
                    "    GroepNaam varchar(50)," +
                    "    PRIMARY KEY (Id, GroepID));");
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

        }
    }

    public ArrayList<Componenten> ophalenComponten(int GroepID){
        ArrayList<Componenten> componenten = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("Select * FROM infrastructuur.componenten WHERE GroepID=?;");
            pstmt.setInt(1, GroepID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                componenten.add(new Componenten(rs.getInt("id"),rs.getString("Type"), rs.getString("Naam"), rs.getDouble("Beschikbaarheid"), rs.getInt("Prijs"),rs.getString("Host")));
            }
            rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (pstmt !=
                    null) {
                try {
                    pstmt.close();
                }
                catch(SQLException sqle){
                    sqle.printStackTrace();
                }
            }
        }
        return componenten;
    }
}
