import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.sql.*;

public class ComponentLijst extends JPanel {

    private JButton JBTN_Select, JBTN_Unselect;
    private JLabel JLBL_Naam, JLBL_Type, JLBL_Beschikbaarheid, JLBL_Prijs, JLBL_Processorb, JLBL_Diskruimte, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_I_Prijs, JLBL_I_Proccesb, JLBL_I_Diskruimte, JLBL_Placeholder;
    private JSeparator SEPA_Top, SEPA_Midt, SEPA_Midb, SEPA_Bottom;
    private JPanel Component;
    private Connection con;


    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);


    public ComponentLijst() throws SQLException {


        for (int i = 0; i < CountRows(); i++) {
            AddComponent();
        }
    }

    public void AddComponent() throws SQLException {
        Component = new JPanel();
        Component.setLayout(new BoxLayout(Component, BoxLayout.Y_AXIS));
        Component.setPreferredSize(new Dimension(200, 160));
        Component.setBackground(Color.lightGray);
        Component.setLayout(new FlowLayout());
        add(Component);

        JLBL_Naam = new JLabel(setNaam());
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        Component.add(JLBL_Placeholder);


        JBTN_Unselect = new JButton("-");
        JBTN_Unselect.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect.setFocusable(false);
        Component.add(JBTN_Unselect);

        JBTN_Select = new JButton("+");
        JBTN_Select.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select.setPreferredSize(new Dimension(20, 20));
        JBTN_Select.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select.setFocusable(false);
        Component.add(JBTN_Select);


        JLBL_Type = new JLabel("Type");
        Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel("");
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel("");
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel("");
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel("");
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Diskruimte");
        Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("                ");
        Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel("");
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Diskruimte);
    }

    public int CountRows() throws SQLException {
        String Rows;
        int rows = 0;
        Statement myStmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "bramvz");
            myStmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM componenten.component;";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {

                rows = rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (myStmt !=
                    null) { myStmt.close(); }
        }
        return rows;
    }



    public String setNaam() throws SQLException {
        String value = null;
        Statement myStmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "bramvz");
            myStmt = con.createStatement();
            String query = "Select * FROM componenten.component WHERE ID = 1";
            ResultSet rs = myStmt.executeQuery("Select * FROM componenten.component WHERE ID = 1");

                while (rs.next()) {

                    value = rs.getString("Naam");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (myStmt !=
                    null) { myStmt.close(); }
        }
        return value;
    }
}