import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Applicatie extends JFrame implements ActionListener {


    ComponentResizer cr = new ComponentResizer();
    private JPanel JPNL_Top, JPNL_Left, JPNL_Bottom;
    private JLabel JLBLTitle, JLBLIO, JLBL_A_Firewall, JLBL_K_Firewall, JLBL_A_Databases, JLBL_K_Databases, JLBL_A_Webs, JLBL_K_Webs, JLBL_TotKosten, JLBL_GWBesch_Error, JLBL_Beschikbaarheid, JLBLStat, JLBLFirewall, JLBLWebs, JLBLDatabases,
            JLBLAantal, JLBLKosten, JLBL_GWBesch, JLBL_TotK, JLBL_Beschi, JLBL_Euro, JLBL_Procent, JLBL_BeschC, JLBL_Type1, JLBL_Naam2_1, JLBL_Beschik, JLBL_Prijs, JLBL_Type2, JLBL_Naam2, JLBL_Naam_Top, JLBL_Naam_Mid, JLBL_Naam_Bottom,
            JLBL_Type_Top, JLBL_Type_Mid, JLBL_Type_Bottom;
    private JTextField JTXTF_GWBesch, JTXTF_Naam, JTXTF_Beschik, JTXT_Prijs;
    private JButton JBTN_Optimaliseer, JBTN_Ontwerp, JBTN_VerwiA, JBTN_Comp1, JBTN_Comp2, JBTN_Comp3, JBTN_Reset, JBTN_Voegtoe, JBTNExit;
    private JSeparator SEPA_Top, SEPA_Stat1, SEPA_Stat2, SEPA_Left_Top, SEPA_Left_Bottom, SEPA_Left, SEPA_Right;
    private JComboBox ComboBox;
    private JScrollBar Scrollbar;


    public Applicatie() {

        cr.registerComponent(this);
        MotionPanel mp = new MotionPanel(this);

        setBounds(100, 100, 856, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 570));
        setLocation(500, 250);
        setUndecorated(true);
        cr.setSnapSize(new Dimension(10, 10));

// Create Border
        Border border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, null, null, null);

// Create JPanels
        JPNL_Top = new MotionPanel(this);
        JPNL_Top.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        JPNL_Top.setBackground(new Color(169, 169, 169));
        add(JPNL_Top);

        JPNL_Left = new JPanel();
        JPNL_Left.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Left.setBackground(new Color(169, 169, 169));
        add(JPNL_Left);

        JPNL_Bottom = new JPanel();
        JPNL_Bottom.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Bottom.setBackground(new Color(169, 169, 169));
        add(JPNL_Bottom);


// Create JLabel in JPanel Top
        JLBLTitle = new JLabel("Monitoring Tool");
        JLBLTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLBLIO = new JLabel("Infrastructuur overzicht");
        JLBLIO.setFont(new Font("Tahoma", Font.PLAIN, 16));


// Create JLabels in JPanel_Left

        JLBL_A_Firewall = new JLabel();
        JLBL_A_Firewall.setBorder(border1);
        add(JLBL_A_Firewall);

        JLBL_K_Firewall = new JLabel();
        JLBL_K_Firewall.setBorder(border1);
        add(JLBL_K_Firewall);

        JLBL_A_Databases = new JLabel();
        JLBL_A_Databases.setBorder(border1);
        add(JLBL_A_Databases);

        JLBL_K_Databases = new JLabel();
        JLBL_K_Databases.setBorder(border1);
        add(JLBL_K_Databases);

        JLBL_A_Webs = new JLabel();
        JLBL_A_Webs.setBorder(border1);
        add(JLBL_A_Webs);

        JLBL_K_Webs = new JLabel();
        JLBL_K_Webs.setBorder(border1);
        add(JLBL_A_Webs);

        JLBL_TotKosten = new JLabel();
        JLBL_TotKosten.setBorder(border1);
        add(JLBL_TotKosten);

        JLBL_Beschikbaarheid = new JLabel();
        JLBL_Beschikbaarheid.setBorder(border1);
        add(JLBL_Beschikbaarheid);

        JLBL_GWBesch_Error = new JLabel("testje");
        JLBL_GWBesch_Error.setForeground(Color.red);
        add(JLBL_GWBesch_Error);

        JLBLStat = new JLabel("Statistieken");
        JLBLStat.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(JLBLStat);

        JLBLFirewall = new JLabel("Firewall");
        JLBLFirewall.setFont(new Font("Plain", Font.PLAIN, 13));
        add(JLBLFirewall);

        JLBLWebs = new JLabel("Websever(s)");
        JLBLWebs.setFont(new Font("Plain", Font.PLAIN, 13));
        add(JLBLWebs);

        JLBLDatabases = new JLabel("Database server(s)");
        JLBLDatabases.setFont(new Font("Tahoma", Font.PLAIN, 13));
        add(JLBLDatabases);

        JLBLAantal = new JLabel("Aantal");
        add(JLBLAantal);

        JLBLKosten = new JLabel("Kosten");
        add(JLBLKosten);

        JLBL_GWBesch = new JLabel("Gewenste beschikbaarheid in %");
        JLBL_GWBesch.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_GWBesch);

        JLBL_TotK = new JLabel("Totale kosten");
        JLBL_TotK.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(JLBL_TotK);

        JLBL_Beschi = new JLabel("Beschikbaarheid");
        JLBL_Beschi.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        JLBL_Beschi.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(JLBL_Beschi);

        JLBL_Euro = new JLabel("\u20AC");
        JLBL_Euro.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(JLBL_Euro);

        JLBL_Procent = new JLabel("%");
        JLBL_Procent.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(JLBL_Procent);


// Create JLabel in JPanel Bottom
        JLBL_BeschC = new JLabel("Beschikbare componenten");
        JLBL_BeschC.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_BeschC);

        JLBL_Type1 = new JLabel("Type");
        JLBL_Type1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_Type1);

        JLBL_Naam2_1 = new JLabel("Naam");
        JLBL_Naam2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_Naam2_1);

        JLBL_Beschik = new JLabel("Beschikbaarheid in %");
        JLBL_Beschik.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_Beschik);

        JLBL_Prijs = new JLabel("Prijs in \u20AC");
        JLBL_Prijs.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(JLBL_Prijs);

        JLBL_Type2 = new JLabel("Type");
        add(JLBL_Type2);

        JLBL_Naam2 = new JLabel("Naam");
        add(JLBL_Naam2);

        JLBL_Naam_Top = new JLabel();
        JLBL_Naam_Top.setBorder(border1);
        add(JLBL_Naam_Top);

        JLBL_Naam_Mid = new JLabel();
        JLBL_Naam_Mid.setBorder(border1);
        add(JLBL_Naam_Mid);

        JLBL_Naam_Bottom = new JLabel();
        JLBL_Naam_Bottom.setBorder(border1);
        add(JLBL_Naam_Bottom);

        JLBL_Type_Top = new JLabel();
        JLBL_Type_Top.setBorder(border1);
        add(JLBL_Type_Top);

        JLBL_Type_Mid = new JLabel();
        JLBL_Type_Mid.setBorder(border1);
        add(JLBL_Type_Mid);

        JLBL_Type_Bottom = new JLabel();
        JLBL_Type_Bottom.setBorder(border1);
        add(JLBL_Type_Bottom);

// Create JTextField in Jpanel Top
        /**
         * None
         */


// Create JTextFields in JPanel_Left
        JTXTF_GWBesch = new JTextField();
        JTXTF_GWBesch.setColumns(10);
        JTXTF_GWBesch.addActionListener(this);
        add(JTXTF_GWBesch);


// Create JTextFields in JPanel Bottom
        JTXTF_Naam = new JTextField();
        JTXTF_Naam.setColumns(10);
        add(JTXTF_Naam);

        JTXTF_Beschik = new JTextField();
        JTXTF_Beschik.setColumns(10);
        add(JTXTF_Beschik);

        JTXT_Prijs = new JTextField();
        JTXT_Prijs.setColumns(10);
        add(JTXT_Prijs);


// Create JButtons in JPanel Top
        /**
         * none
         */


// Create JButtons in JPanel Left
        JBTN_Optimaliseer = new JButton("Optimaliseer");
        JBTN_Optimaliseer.addActionListener(this);
        add(JBTN_Optimaliseer);

        JBTN_Ontwerp = new JButton("Ontwerp");
        add(JBTN_Ontwerp);

        JBTN_VerwiA = new JButton("Verwijder Alles");
        JBTN_VerwiA.setFont(new Font("Tahoma", Font.BOLD, 10));
        add(JBTN_VerwiA);

// Create JButtons in JPanel Bottom
        JBTN_Comp1 = new JButton();
        JBTN_Comp1.setIcon(new ImageIcon("Images/Firewall-ico.png"));
        JBTN_Comp1.setBackground(new Color(249, 249, 249));
        add(JBTN_Comp1);

        JBTN_Comp2 = new JButton();
        JBTN_Comp2.setIcon(new ImageIcon("Images/Database-ico.png"));
        JBTN_Comp2.setBackground(new Color(249, 249, 249));
        add(JBTN_Comp2);

        JBTN_Comp3 = new JButton("");
        JBTN_Comp3.setIcon(new ImageIcon("Images/Webserver-ico.png"));
        JBTN_Comp3.setBackground(new Color(249, 249, 249));
        add(JBTN_Comp3);

        JBTN_Reset = new JButton("Reset");
        add(JBTN_Reset);

        JBTN_Voegtoe = new JButton("Voeg toe");
        add(JBTN_Voegtoe);


// Create Separator in Jpanel Top
        SEPA_Top = new JSeparator();
        SEPA_Top.setForeground(Color.BLACK);
        add(SEPA_Top);


// Create Seperators in JPanel_Left
        SEPA_Stat1 = new JSeparator();
        SEPA_Stat2 = new JSeparator();
        add(SEPA_Stat2);

        SEPA_Left_Top = new JSeparator();
        SEPA_Left_Top.setForeground(Color.BLACK);
        add(SEPA_Left_Top);

        SEPA_Left_Bottom = new JSeparator();
        SEPA_Left_Bottom.setForeground(Color.BLACK);
        add(SEPA_Left_Bottom);


// Create Separators in Jpanel Bottom
        SEPA_Left = new JSeparator();
        SEPA_Left.setOrientation(SwingConstants.VERTICAL);
        add(SEPA_Left);

        SEPA_Right = new JSeparator();
        SEPA_Right.setOrientation(SwingConstants.VERTICAL);
        add(SEPA_Right);


// Overig:

// Create ComboBox
        ComboBox = new JComboBox();
        add(ComboBox);


// Create JButton Exit in JPanel Top
        JBTNExit = new JButton("X");
        JBTNExit.setFocusPainted(false);
        JBTNExit.setFocusTraversalKeysEnabled(false);
        JBTNExit.setRolloverEnabled(false);
        JBTNExit.setRequestFocusEnabled(false);
        JBTNExit.setOpaque(false);
        JBTNExit.setContentAreaFilled(false);
        JBTNExit.setBorderPainted(false);
        JBTNExit.setInheritsPopupMenu(true);
        JBTNExit.setIgnoreRepaint(true);
        JBTNExit.setMargin(new Insets(10, 10, 10, 10));
        JBTNExit.addActionListener(new CloseListener());
        add(JBTNExit);


// Create Overig in Jpanel in Left
        /**
         * none
         */


// Create Scrollbar in Jpanel Bottom
        Scrollbar = new JScrollBar();
        Scrollbar.setOrientation(JScrollBar.HORIZONTAL);
        add(Scrollbar);


// Group Jpanel JPNL_Top
        GroupLayout gl_JPNL_Top = new GroupLayout(JPNL_Top);
        gl_JPNL_Top.setHorizontalGroup(
                gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGap(398)
                                .addComponent(JLBLTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(253)
                                .addComponent(JBTNExit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(7))
                        .addComponent(SEPA_Top, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGap(474)
                                .addComponent(JLBLIO, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(197))
        );

        gl_JPNL_Top.setVerticalGroup(
                gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGroup(gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(JLBLTitle, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JBTNExit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(6)
                                .addComponent(SEPA_Top, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addComponent(JLBLIO, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        );

        JPNL_Top.setLayout(gl_JPNL_Top);
        GroupLayout groupLayout = new GroupLayout(this.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JPNL_Top, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPNL_Bottom, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addComponent(JPNL_Left, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
        );

        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(JPNL_Top, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                                .addComponent(JPNL_Bottom, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(JPNL_Left, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                .addGap(95))))
        );


// Group JPanel JPNL_Left Horizontaal
        GroupLayout gl_JPNL_Left = new GroupLayout(JPNL_Left);
        gl_JPNL_Left.setHorizontalGroup(
                gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBLWebs, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBLFirewall, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SEPA_Stat1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(110)
                                                                .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(13)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBLKosten, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBL_K_Firewall, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBL_K_Webs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(JLBL_A_Firewall, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(JLBLStat, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(JLBLAantal, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(SEPA_Stat2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBLDatabases, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                .addGap(13)
                                .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addComponent(SEPA_Left_Top, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(4)
                                .addComponent(JLBL_GWBesch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(45)
                                .addComponent(JTXTF_GWBesch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(43)
                                .addComponent(JBTN_Optimaliseer, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(43)
                                .addComponent(JBTN_Ontwerp, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(43)
                                .addComponent(JBTN_VerwiA, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addComponent(SEPA_Left_Bottom, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addComponent(JLBL_TotK, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(11)
                                                .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Euro, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBL_Beschi, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(JLBL_Beschikbaarheid, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(JLBL_Procent, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        );
        gl_JPNL_Left.setVerticalGroup(
                gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(23)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(JLBLWebs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(JLBLFirewall, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(23)
                                                                .addComponent(SEPA_Stat1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(27)
                                                                .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(JLBLKosten)
                                                .addGap(1)
                                                .addComponent(JLBL_K_Firewall, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5)
                                                .addComponent(JLBL_K_Webs, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(27)
                                                .addComponent(JLBL_A_Firewall, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBLStat, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(JLBLAantal)))
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(SEPA_Stat2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBLDatabases, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
                                .addGap(11)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(SEPA_Left_Top, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(JLBL_GWBesch, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)))
                                .addGap(4)
                                .addComponent(JTXTF_GWBesch, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addComponent(JBTN_Optimaliseer, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(1)
                                .addComponent(JBTN_Ontwerp, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(1)
                                .addComponent(JBTN_VerwiA, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(21)
                                .addComponent(SEPA_Left_Bottom, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_TotK, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Euro)))
                                .addGap(4)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Beschi, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Beschikbaarheid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Procent)))
                                .addGap(16))
        );
        JPNL_Left.setLayout(gl_JPNL_Left);

// Group JPanel JPNL_Bottom
        GroupLayout gl_JPNL_Bottom = new GroupLayout(JPNL_Bottom);
        gl_JPNL_Bottom.setHorizontalGroup(
                gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(8)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(16)
                                                .addComponent(JLBL_BeschC, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addComponent(JBTN_Comp1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6)
                                                .addComponent(JBTN_Comp2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(JBTN_Comp3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                                .addGap(6)
                                .addComponent(SEPA_Left, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                .addGap(9)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(JLBL_Type1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addGap(25))
                                        .addComponent(ComboBox, 0, 72, Short.MAX_VALUE))
                                .addGap(14)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(2)
                                                .addComponent(JLBL_Naam2_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addGap(80)
                                                .addComponent(JLBL_Beschik, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                .addGap(8))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addComponent(JTXTF_Naam, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                .addGap(14)
                                                .addComponent(JTXTF_Beschik, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                .addGap(17))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(25)
                                                .addComponent(JBTN_Reset, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                .addGap(18)
                                                .addComponent(JBTN_Voegtoe, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                                .addGap(8)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addComponent(JLBL_Prijs, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addGap(31))
                                        .addComponent(JTXT_Prijs, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addGap(12)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JLBL_Type_Mid, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JLBL_Naam_Mid, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JLBL_Naam2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JLBL_Naam_Bottom, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JLBL_Type_Top, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(Scrollbar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JLBL_Type_Bottom, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JLBL_Type2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(SEPA_Right, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JLBL_Naam_Top, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                .addGap(17))
        );
        gl_JPNL_Bottom.setVerticalGroup(
                gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(2)
                                .addComponent(JLBL_BeschC, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JBTN_Comp1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JBTN_Comp2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JBTN_Comp3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(2)
                                .addComponent(SEPA_Left, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(3)
                                .addComponent(JLBL_Type1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(ComboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(2)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(JLBL_Naam2_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Beschik, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                .addGap(1)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JTXTF_Naam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTXTF_Beschik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(15)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JBTN_Reset)
                                        .addComponent(JBTN_Voegtoe)))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(3)
                                .addComponent(JLBL_Prijs, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(JTXT_Prijs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(33)
                                .addComponent(JLBL_Type_Mid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(33)
                                .addComponent(JLBL_Naam_Mid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addComponent(JLBL_Naam2)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(51)
                                .addComponent(JLBL_Naam_Bottom, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(15)
                                .addComponent(JLBL_Type_Top, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(70)
                                .addComponent(Scrollbar, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(51)
                                .addComponent(JLBL_Type_Bottom, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addComponent(JLBL_Type2)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(1)
                                .addComponent(SEPA_Right, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(15)
                                .addComponent(JLBL_Naam_Top, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        );
        JPNL_Bottom.setLayout(gl_JPNL_Bottom);
        this.getContentPane().setLayout(groupLayout);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == JBTN_Optimaliseer) {
                double GewBeschik = Double.parseDouble(JTXTF_GWBesch.getText());
                if (GewBeschik >= 0.1 && GewBeschik < 100.0) {
                    String str = JTXTF_GWBesch.getText();
                    JLBL_Beschikbaarheid.setText(" " + str);
                } else {
                    JLBL_GWBesch_Error.setText("De gewenste beschikbaarheid moet tussen 0.1% en 99.99% liggen");
                }
            }
        } catch (NumberFormatException nfe) {
            JLBL_GWBesch_Error.setText("Alleen getallen kunnen worden ingevoerd!");
        }
        
    }
}

/** TO DO:
 * verticaal schalen buttons veranderen?
 * Exit-button highlight
 * Infrastructuur overzicht kunnen selecteren
 * Webserver icon goed zetten



/** DONE:
 * Minimum size zetten
 * Kruisje werkend met maken met Actionlistener
 * Type omhoog zetten
 *Resize Type ComboBox
 * OOV knoppen goed zetten
 * GUI veranderen naar undecorated
 * Icons zetten bij new button (Standaard Componenten)
 */
