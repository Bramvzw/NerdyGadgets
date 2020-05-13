import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ComponentLijst extends JPanel implements ActionListener {

    private static int key = 0;
    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);
    private JButton JBTN_Select, JBTN_Unselect, JBTN_ID;
    private JLabel JLBL_Naam, JLBL_Type, JLBL_Beschikbaarheid, JLBL_Prijs, JLBL_Processorb, JLBL_Diskruimte, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_I_Prijs, JLBL_I_Proccesb, JLBL_I_Diskruimte, JLBL_Placeholder;
    private JSeparator SEPA_Top, SEPA_Midt, SEPA_Midb, SEPA_Bottom;
    private JPanel Component;
    private Lijst lijst;

    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection con;



    public ComponentLijst() throws SQLException {
        for (int i = 0; i < CountRows(); i++) {
            AddComponent();
        }

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

        Component = new JPanel();
        Component.setLayout(new BoxLayout(Component, BoxLayout.Y_AXIS));
        Component.setPreferredSize(new Dimension(200, 160));
        Component.setBackground(Color.lightGray);
        Component.setLayout(new FlowLayout());
        add(Component);

        JLBL_Naam = new JLabel(getgegevens(key)[3]);
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

        setID();

        JBTN_Select = new JButton("+");
        JBTN_Select.setName("ID");
        JBTN_Select.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select.setPreferredSize(new Dimension(20, 20));
        JBTN_Select.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select.addActionListener(this);
        JBTN_Select.setFocusable(false);
        Component.add(JBTN_Select);


        JLBL_Type = new JLabel("Type");
        Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(getgegevens(key)[2]);
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

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(key)[4]);
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

        JLBL_I_Prijs = new JLabel(getgegevens(key)[5]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel(getgegevens(key)[6]);
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

        JLBL_I_Diskruimte = new JLabel(getgegevens(key)[7]);
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        Component.add(JLBL_I_Diskruimte);
    }



    public int CountRows() throws SQLException {
        int rows = 0;
        try {
            con = Connectie.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM componenten.component;";
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

    public String[] getgegevens(int ID) throws SQLException {
        String[] gegevens = new String[10];
        try {
            con = Connectie.getConnection();
            pstmt = con.prepareStatement("Select * FROM componenten.component WHERE ID=?;");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                gegevens[0] = Integer.toString(rs.getInt("ID"));
                gegevens[1] = Integer.toString(rs.getInt("Type_key"));
                gegevens[2] = rs.getString("Type");
                gegevens[3] = rs.getString("Naam");
                gegevens[4] = Double.toString(rs.getDouble("Beschikbaarheid")) + "%";
                gegevens[5] = "€ " + Integer.toString(rs.getInt("Prijs"));
                gegevens[6] = Double.toString(rs.getDouble("Processorbelasting"));
                gegevens[7] = Double.toString(rs.getDouble("Diskruimte"));


            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }
        return gegevens;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (JBTN_ID.getName().equals("2"))
            System.out.println("test");

    }

}

