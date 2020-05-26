import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ComponentLijst extends JPanel implements ActionListener {

    private static int key = 0;
    private static int ID = 0;
    private static int index = 0;

    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);
    private JButton JBTN_Select, JBTN_Unselect, JBTN_Select1, JBTN_Unselect1, JBTN_Select2, JBTN_Unselect2,  JBTN_Select3, JBTN_Unselect3, JBTN_Select4,JBTN_Unselect4,  JBTN_Select5, JBTN_Unselect5, JBTN_Select6, JBTN_Unselect6 ;
    private JLabel JLBL_Naam, JLBL_Type, JLBL_Beschikbaarheid, JLBL_Prijs, JLBL_Processorb, JLBL_Diskruimte, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_I_Prijs, JLBL_I_Proccesb,
            JLBL_I_Diskruimte, JLBL_NetworkLoad, JLBL_I_NetworkLoad, JLBL_Placeholder;
    private JSeparator SEPA_Top, SEPA_Midt, SEPA_Midb, SEPA_Bottom;
    private JPanel PNL_Component;

    private PreparedStatement pstmt;
    private Statement stmt;
//    private Connection con = Connectie.getConnection();

    public ArrayList<String> serverslijst = new ArrayList<String>();
    private ArrayList<String> databaseslijst = new ArrayList<String>(100);
    private ArrayList<String> firewalllijst = new ArrayList<String>(100);

    private ArrayList<Componenten> keuzeComponenten, momenteleComponenten;
    private Applicatie applicatie;

    public ComponentLijst(Applicatie applicatie, ArrayList<Componenten> keuzeComponenten,ArrayList<Componenten> momenteleComponenten) throws SQLException {
        if (applicatie.getBoolConnectie()) {
            this.applicatie = applicatie;
            this.keuzeComponenten = keuzeComponenten;
            this.momenteleComponenten = momenteleComponenten;

            // Panel 1
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(0).getNaam());
//        JLBL_Naam = new JLabel((naamOphalen( 1, con)));
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
            JBTN_Unselect.addActionListener(this);
            JBTN_Unselect.setFocusable(false);
            JBTN_Unselect.addActionListener(this);
            PNL_Component.add(JBTN_Unselect);


            JBTN_Select = new JButton("+");
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

            JLBL_I_Type = new JLabel(keuzeComponenten.get(0).getType());
//        JLBL_I_Type = new JLabel(typeOphalen(1, con));
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(0).getBeschikbaarheid()));
//        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 1)[2]);
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(0).getPrijs()));
            //JLBL_I_Prijs = new JLabel(getgegevens(con, 1)[3]);
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);

//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);

//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);

//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);

//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);

//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);

//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);

//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);

//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);

//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 2
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(1).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect1 = new JButton("-");
            JBTN_Unselect1.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect1.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect1.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect1.addActionListener(this);
            JBTN_Unselect1.setFocusable(false);
            PNL_Component.add(JBTN_Unselect1);


            JBTN_Select1 = new JButton("+");
            JBTN_Select1.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select1.setPreferredSize(new Dimension(20, 20));
            JBTN_Select1.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select1.addActionListener(this);
            JBTN_Select1.setFocusable(false);
            PNL_Component.add(JBTN_Select1);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(1).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(1).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(1).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 3
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(2).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect2 = new JButton("-");
            JBTN_Unselect2.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect2.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect2.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect2.addActionListener(this);
            JBTN_Unselect2.setFocusable(false);
            PNL_Component.add(JBTN_Unselect2);


            JBTN_Select2 = new JButton("+");
            JBTN_Select2.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select2.setPreferredSize(new Dimension(20, 20));
            JBTN_Select2.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select2.addActionListener(this);
            JBTN_Select2.setFocusable(false);
            PNL_Component.add(JBTN_Select2);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(2).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(2).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(2).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 4
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(3).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect3 = new JButton("-");
            JBTN_Unselect3.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect3.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect3.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect3.addActionListener(this);
            JBTN_Unselect3.setFocusable(false);
            PNL_Component.add(JBTN_Unselect3);


            JBTN_Select3 = new JButton("+");
            JBTN_Select3.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select3.setPreferredSize(new Dimension(20, 20));
            JBTN_Select3.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select3.addActionListener(this);
            JBTN_Select3.setFocusable(false);
            PNL_Component.add(JBTN_Select3);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(3).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(3).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(3).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 5
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(4).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect4 = new JButton("-");
            JBTN_Unselect4.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect4.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect4.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect4.addActionListener(this);
            JBTN_Unselect4.setFocusable(false);
            PNL_Component.add(JBTN_Unselect4);


            JBTN_Select4 = new JButton("+");
            JBTN_Select4.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select4.setPreferredSize(new Dimension(20, 20));
            JBTN_Select4.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select4.addActionListener(this);
            JBTN_Select4.setFocusable(false);
            PNL_Component.add(JBTN_Select4);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(4).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(4).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(4).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 6
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(5).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect5 = new JButton("-");
            JBTN_Unselect5.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect5.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect5.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect5.addActionListener(this);
            JBTN_Unselect5.setFocusable(false);
            PNL_Component.add(JBTN_Unselect5);


            JBTN_Select5 = new JButton("+");
            JBTN_Select5.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select5.setPreferredSize(new Dimension(20, 20));
            JBTN_Select5.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select5.addActionListener(this);
            JBTN_Select5.setFocusable(false);
            PNL_Component.add(JBTN_Select5);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(5).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(5).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(5).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);

            // Panel 7
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(keuzeComponenten.get(6).getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);


            JBTN_Unselect6 = new JButton("-");
            JBTN_Unselect6.setFont(new Font("", Font.BOLD, 14));
            JBTN_Unselect6.setPreferredSize(new Dimension(20, 20));
            JBTN_Unselect6.setMargin(new Insets(0, 0, 1, 1));
            JBTN_Unselect6.addActionListener(this);
            JBTN_Unselect6.setFocusable(false);
            PNL_Component.add(JBTN_Unselect6);


            JBTN_Select6 = new JButton("+");
            JBTN_Select6.setFont(new Font("", Font.BOLD, 14));
            JBTN_Select6.setPreferredSize(new Dimension(20, 20));
            JBTN_Select6.setMargin(new Insets(0, 0, 1, 0));
            JBTN_Select6.addActionListener(this);
            JBTN_Select6.setFocusable(false);
            PNL_Component.add(JBTN_Select6);


            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(keuzeComponenten.get(6).getType());
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

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(keuzeComponenten.get(6).getBeschikbaarheid()));
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

            JLBL_I_Prijs = new JLabel(Integer.toString(keuzeComponenten.get(6).getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Midb = new JSeparator();
            SEPA_Midb.setPreferredSize(new Dimension(190, 1));
            SEPA_Midb.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Midb);

//        JLBL_Processorb = new JLabel("Processorbelasting ");
//        PNL_Component.add(JLBL_Processorb);
//
//        JLBL_I_Proccesb = new JLabel();
//        JLBL_I_Proccesb.setBorder(border1);
//        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Proccesb);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
//        PNL_Component.add(JLBL_Diskruimte);
//
//        JLBL_Placeholder = new JLabel("");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_Diskruimte = new JLabel();
//        JLBL_I_Diskruimte.setBorder(border1);
//        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_Diskruimte);
//
//        SEPA_Bottom = new JSeparator();
//        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
//        SEPA_Bottom.setForeground(Color.darkGray);
//        PNL_Component.add(SEPA_Bottom);
//
//        JLBL_NetworkLoad = new JLabel("Networkload");
//        PNL_Component.add(JLBL_NetworkLoad);
//
//        JLBL_Placeholder = new JLabel("             ");
//        PNL_Component.add(JLBL_Placeholder);
//
//        JLBL_I_NetworkLoad = new JLabel();
//        JLBL_I_NetworkLoad.setBorder(border1);
//        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
//        PNL_Component.add(JLBL_I_NetworkLoad);
        }
    }

//    public int CountRows(Connection con) throws SQLException {
//        int rows = 0;
//        try {
//            stmt = con.createStatement();
//            String sql = "SELECT COUNT(*) FROM component;";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                rows = rs.getInt(1);
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (stmt !=
//                    null) {
//                stmt.close();
//            }
//        }
//        return rows;
//    }

    public ArrayList<String> getDatabaseslijst() {
        this.databaseslijst=databaseslijst;
        return databaseslijst;
    }

    public void setDatabaseslijst(ArrayList<String> databaseslijst) {
        this.databaseslijst = databaseslijst;
    }

    public ArrayList<String> getServerslijst() {
        return serverslijst;
    }

    public ArrayList<String> getFirewalllijst() {
        return firewalllijst;
    }

    public void setServerslijst(ArrayList<String> serverslijst) {
        this.serverslijst = serverslijst;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object command1 = e.getSource();
        if (command1.equals(JBTN_Select)) {
            firewalllijst.add("pfsense");
            System.out.println("firewall is added");
            System.out.println("webservers : "+serverslijst);
            System.out.println("databases : "+databaseslijst);
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(0)));
        }
        if (command1.equals(JBTN_Select1)){
            System.out.println("+1 database added van type HAL9001DB");
            databaseslijst.add("HAL9001DB");
            System.out.println("aantaldatabases : " + databaseslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(1)));
        }
        if (command1.equals(JBTN_Select2)){
            System.out.println("+1 database added van type HAL9002DB");
            databaseslijst.add("HAL9002DB");
            System.out.println("aantaldatabases : "+ databaseslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(2)));
        }
        if (command1.equals(JBTN_Select3)){
            System.out.println("+1 database added va type HAL9003DB");
            databaseslijst.add("HAL9003DB");
            System.out.println("aantaldatabases : " + databaseslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(3)));
        }
        if (command1.equals(JBTN_Select4)){
            System.out.println("+1 WB added van type HAL9001WB");
            serverslijst.add("HAL9001WB");
            System.out.println( "aantalwebservers : " + serverslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(4)));
        }
        if (command1.equals(JBTN_Select5)){
            System.out.println("+1 WB added van type HAL9002WB");
            serverslijst.add("HAL9002WB");
            System.out.println( "aantalwebservers : " + serverslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(5)));
        }
        if (command1.equals(JBTN_Select6)){
            System.out.println("+1 WB added van type HAL9003WB ");
            serverslijst.add("HAL9003WB");
            System.out.println( "aantalwebservers : " + serverslijst.size());
            momenteleComponenten.add( new Componenten(keuzeComponenten.get(6)));
        }
        if (command1.equals( JBTN_Unselect)){
            System.out.println("firewall is verwijderd");
            firewalllijst.remove("firewall");

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(0))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals( JBTN_Unselect1)){
            System.out.println("-1 (een database is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9001DB");
            System.out.println("aantaldatabases : " + databaseslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(1))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals(JBTN_Unselect2)){
            System.out.println("-1 (een database is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9002DB");
            System.out.println("aantaldatabases : " + databaseslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(2))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals(JBTN_Unselect3)){
            System.out.println("-1 (een database is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9003DB");
            System.out.println("aantaldatabases : " + databaseslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(3))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals(JBTN_Unselect4)){
            System.out.println("-1 (een webserver is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9001WB");
            System.out.println("aantaldatabases : " + serverslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(4))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals(JBTN_Unselect5)){
            System.out.println("-1 (een webserver is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9002WB");
            System.out.println("aantaldatabases : " + serverslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(5))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        if (command1.equals(JBTN_Unselect6)){
            System.out.println("-1 (een webserver is uit de lijst verwijderd)");
            databaseslijst.remove("HAL9003WB");
            System.out.println("aantaldatabases : " + serverslijst.size());

            Boolean verwijderd = false;
            for(Componenten component : momenteleComponenten){
                if(!verwijderd && component.equalsZonderActueleGegevens(keuzeComponenten.get(6))){
                    momenteleComponenten.remove(component);
                    verwijderd = true;
                    applicatie.updateComponenten();
                }
            }
        }
        applicatie.updateComponenten();
    }
}

