import java.sql.*;
import java.util.ArrayList;

public class ComponentArray {
    private ArrayList<Componenten> componentenArray;
    private PreparedStatement pstmt;
    private Statement stmt;
    private Boolean boolConnectie = false;
    private Connection con = Connectie.getConnection(this);

    //CompononentArray constructor
    public ComponentArray(Applicatie app){
        if(boolConnectie) {
            componentenArray = new ArrayList<>();
            String[] gegevens;
            for (int i = 1; i <= CountRows(con); i++) {
                gegevens = getgegevens(con, i); //Ophalen gegevens component
                if (!gegevens[7].isEmpty() || !gegevens[8].isEmpty()) {
                    componentenArray.add(new Componenten(Integer.parseInt(gegevens[0]), gegevens[5], gegevens[6], Double.parseDouble(gegevens[2]), Integer.parseInt(gegevens[3]), (100 - Double.parseDouble(gegevens[7])), Double.parseDouble(gegevens[8]), gegevens[4], Boolean.parseBoolean(gegevens[9])));
                }
                else if(gegevens[4] != null && !gegevens[4].isEmpty()){
                    componentenArray.add(new Componenten(Integer.parseInt(gegevens[0]), gegevens[5], gegevens[6], Double.parseDouble(gegevens[2]), Integer.parseInt(gegevens[3]), gegevens[4], Boolean.parseBoolean(gegevens[9])));
                }

                else {
                    componentenArray.add(new Componenten(Integer.parseInt(gegevens[0]), gegevens[5], gegevens[6], Double.parseDouble(gegevens[2]), Integer.parseInt(gegevens[3]), gegevens[4]));
                }
            }
            app.setBoolConnectie(true); //Aangeven werkende connectie
        }
        else{
            app.waarschuwingConnectie(); //Aangeven foute connectie
        }
    }

    public ArrayList<Componenten> getComponentenArray() {
        return componentenArray;
    }

    public int CountRows(Connection con) { //Methode voor tellen van alle rows in database component
        int rows = 0;
        try {
            stmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM component;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                rows = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch(SQLException SQLe){
                    SQLe.printStackTrace();
                }
            }
        }
        return rows;
    }

    public String[] getgegevens(Connection con, int ID){ //Ophalen gegevens van component
        String[] gegevens = new String[10];

        try {
            pstmt = con.prepareStatement("Select * FROM component WHERE componentID=?;");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                gegevens[0] = Integer.toString(rs.getInt("componentID"));
                gegevens[1] = Integer.toString(rs.getInt("apparaatID"));
                gegevens[2] = rs.getString("beschikbaarheidspercentage");
                gegevens[3] = Integer.toString(rs.getInt("prijs"));
                if(!(rs.getString("ipadres") == null)) {
                    gegevens[4] = rs.getString("ipadres");
                }
                else{
                    gegevens[4] = "";
                }
                gegevens[5] = typeOphalen(ID, con);
                gegevens[6] = naamOphalen(ID, con);
                String[] cpudisk;
                if(!(gegevens[4].equals(""))) {
                    cpudisk = GegevensOphalen.start(gegevens[4]); //Ophalen actuele gegevens van component
                    gegevens[8] = cpudisk[1].replace(",", ".");
                    gegevens[7] = cpudisk[0];
                    gegevens[9] = Boolean.toString(GegevensOphalen.testConnectie(gegevens[4])); //Ophalen connectie status component
                }
                else{
                    gegevens[7] = "";
                    gegevens[8] = "";
                }
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                }
                catch (SQLException SQLe){
                    SQLe.printStackTrace();
                }
            }
        }
        return gegevens;
    }

    public String typeOphalen(int apparaatID, Connection con) throws SQLException { //Methode voor ophalen van type van component
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM firewall WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                string = rs.getString("rol");
            }
            rs.close();

            pstmt = con.prepareStatement("Select * FROM DBserver WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs2 = pstmt.executeQuery();
            if (rs2.next()) {
                string = rs2.getString("rol");
            }
            rs2.close();

            pstmt = con.prepareStatement("Select * FROM webserver WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs3 = pstmt.executeQuery();
            if (rs3.next()) {
                string = rs3.getString("rol");
            }
            rs3.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }

        return string;
    }

    public String naamOphalen(int apparaatID, Connection con) throws SQLException { //Methode voor ophalen van naam van component
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM hardware WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                string = rs.getString("type");
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }

        return string;
    }

    public void setBoolConnectie(Boolean boolConnectie) {
        this.boolConnectie = boolConnectie;
    }
}
