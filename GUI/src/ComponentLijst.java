import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class ComponentLijst extends JPanel implements ActionListener {
    private static int key = 0;
    private static int lock = 1;
    private static int door = 0;
    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);
    private JButton JBTN_Select, JBTN_Unselect, JBTN_ID;
    private JLabel JLBL_Naam, JLBL_Type, JLBL_Beschikbaarheid, JLBL_Prijs, JLBL_Processorb, JLBL_Diskruimte, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_I_Prijs, JLBL_I_Proccesb, JLBL_I_Diskruimte, JLBL_Placeholder;
    private JSeparator SEPA_Top, SEPA_Midt, SEPA_Midb, SEPA_Bottom;
    private JPanel PNL_Component;

    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection con = Connectie.getConnection();

    private Lijst lijst;
    private String[] Component = new String[8];
    String[][] ComponentLijst = new String[CountRows(con)][];

    public ComponentLijst() throws SQLException {
        for (int i = 0; i < CountRows(con); i++) {
            AddComponent();
        }
        con.close();
    }

    public void setID() {
        JBTN_ID = new JButton("+");
        for (int i = 0; i < 8; i++) {
            String j = Integer.toString(i);
            JBTN_ID.setName(String.valueOf(j));
        }
        JBTN_ID.addActionListener(this);
    }

    public void AddComponent() throws SQLException {
        key++;
        System.out.println(key);

        String[] gegevens = getgegevens(con,key);

        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 160));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        add(PNL_Component);

        JLBL_Naam = new JLabel(gegevens[6]);
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect = new JButton("-");
        JBTN_Unselect.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect.setFocusable(false);
        PNL_Component.add(JBTN_Unselect);

        JBTN_Select = new JButton("+");
        JBTN_Select.setName("ID");
        JBTN_Select.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select.setPreferredSize(new Dimension(20, 20));
        JBTN_Select.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select.addActionListener(this);
        JBTN_Select.setFocusable(false);
        PNL_Component.add(JBTN_Select);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(gegevens[5]);
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(gegevens[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(gegevens[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel(gegevens[7]);
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel(gegevens[8]);
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);
    }


    public int CountRows(Connection con) throws SQLException {
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
            if (stmt !=
                    null) {
                stmt.close();
            }
        }
        return rows;
    }


    public String[] getgegevens(Connection con, int ID) throws SQLException {
        String[] gegevens = new String[9];
        try {
            pstmt = con.prepareStatement("Select * FROM component WHERE componentID=?;");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                gegevens[0] = Integer.toString(rs.getInt("componentID"));
                gegevens[1] = Integer.toString(rs.getInt("apparaatID"));
                gegevens[2] = rs.getString("beschikbaarheidspercentage");
                gegevens[3] = "€ " + Integer.toString(rs.getInt("prijs"));
                gegevens[4] = rs.getString("ipadres");
                gegevens[5] = typeOphalen(ID,gegevens[1], con);
                gegevens[6] = naamOphalen(ID,gegevens[1], con);

                String[] cpudisk = GegevensOphalen.start(gegevens[4]);
                gegevens[7] = cpudisk[0];
                gegevens[8] = cpudisk[1];

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
        return gegevens;
    }

    public String[][] getComponentLijst1() throws SQLException {
        for (int j = 0; j < CountRows(con); j++) {
            for (int i = 0; i <= 7; i++) {
                Component[i] = getgegevens(con,lock)[i];
            }
            System.out.println(Arrays.toString(Component));
            System.out.println(j);
            ComponentLijst[j] = Component;
            lock++;
            System.out.println(Arrays.deepToString(ComponentLijst));
        }
        return ComponentLijst;
    }


    public String typeOphalen(int ID, String apparaatID, Connection con) throws SQLException {
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM firewall WHERE apparaatID=?;");
            pstmt.setInt(1, Integer.parseInt(apparaatID));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                string = rs.getString("soort");
            }
            rs.close();

            pstmt = con.prepareStatement("Select * FROM DBserver WHERE apparaatID=?;");
            pstmt.setInt(1, Integer.parseInt(apparaatID));
            ResultSet rs2 = pstmt.executeQuery();
            if(rs2.next()) {
                string = rs2.getString("soort");
            }
            rs2.close();

            pstmt = con.prepareStatement("Select * FROM webserver WHERE apparaatID=?;");
            pstmt.setInt(1, Integer.parseInt(apparaatID));
            ResultSet rs3 = pstmt.executeQuery();
            if(rs3.next()) {
                string = rs3.getString("soort");
            }
            rs3.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if (pstmt !=
//                    null) {
//                pstmt.close();
//            }
//        }

        return string;
    }

    public String naamOphalen(int ID, String apparaatID, Connection con) throws SQLException {
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM hardware WHERE apparaatID=?;");
            pstmt.setInt(1, Integer.parseInt(apparaatID));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                string = rs.getString("modelnaam");
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        finally {
//            if (pstmt !=
//                    null) {
//                pstmt.close();
//            }
//        }

        return string;
    }






    @Override
    public void actionPerformed(ActionEvent e) {

        if (JBTN_Select.getText().equals("+")){
            try {
                getComponentLijst1();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

