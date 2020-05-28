import java.sql.*;
import java.util.ArrayList;


public class Opslag {

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
        }
        return id + 1;
    }

    public int volgendeComponentID() {
        int id = 0;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM infrastructuur.componenten;");
            while(rs.next()){
                id = rs.getInt("MAX(GroepID)");
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
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
    }

    public ArrayList<Componenten> ophalenComponenten(int GroepID){
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
        }
        return componenten;
    }

    public ArrayList<String> ophalenGroepNamen(){
        ArrayList<String> groepNamen = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT GroepID, GroepNaam FROM infrastructuur.componenten;");
            while(rs.next()){
                if(rs.getString("GroepNaam") != null) {
                    groepNamen.add(Integer.toString(rs.getInt("GroepID")));
                    groepNamen.add(rs.getString("GroepNaam"));
                }
            }
        }

        catch(Exception se){
            se.printStackTrace();
        }
        return groepNamen;
    }

    public void openCon(){
        con = Connectie.getConnectionLocalhost();
    }

    public void sluitCon(){
        try{
            if(con!=null) {
                con.close();
            }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
}
