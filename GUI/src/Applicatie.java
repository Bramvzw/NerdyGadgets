import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Applicatie extends JFrame implements ActionListener {


    ComponentResizer cr = new ComponentResizer();
    private JPanel JPNL_Top, JPNL_Left, IO, VCT;
    private JLabel JLBLTitle, JLBLIO, JLBL_A_Firewall, JLBL_K_Firewall, JLBL_A_Databases, JLBL_K_Databases, JLBL_A_Webs, JLBL_K_Webs, JLBL_TotKosten, JLBL_Error, JLBL_Beschikbaarheid, JLBLStat, JLBLFirewall, JLBLWebs, JLBLDatabases,
            JLBL_Aantal, JLBLKosten, JLBL_GWBesch, JLBL_TotK, JLBL_Beschi, JLBL_Euro, JLBL_Procent, CustomTitle, StandaardTitle;
    private JTextField JTXTF_GWBesch;
    private JButton JBTN_Optimaliseer, JBTN_VerwiA, JBTN_OpenCL, JBTN_VCT, JBTN_Opslaan, JBTN_Open, JBTN_IO, JBTNExit;
    private JSeparator SEPA_Top, SEPA_Stat1, SEPA_Stat2, SEPA_Mid1, SEPA_Mid2, SEPA_Bottom;
    private JScrollPane StandaardC, CustomC;

    private Lijst lijst;
    private static int AantalFirewalls = 0;
    private static int AantalDBs = 0;
    private static int AantalWSs = 0;
    private int KostenFirewalls = 0;
    private int KostenDBs = 0;
    private int KostenWSs = 0;


    public Applicatie(Lijst lijst) throws SQLException {
        this.lijst = lijst;
        cr.registerComponent(this);
        MotionPanel mp = new MotionPanel(this);

        setBounds(100, 100, 900, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1040, 570));
        setLocation(500, 250);
        setUndecorated(true);
        cr.setSnapSize(new Dimension(10, 10));

// Create Border
        Border border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, null, null, null);
        Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);

// Create JPanels
        JPNL_Top = new MotionPanel(this);
        JPNL_Top.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        JPNL_Top.setBackground(new Color(169, 169, 169));
        add(JPNL_Top);

        JPNL_Left = new JPanel();
        JPNL_Left.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Left.setBackground(new Color(169, 169, 169));
        add(JPNL_Left);

        IO = new Infrastructuur_Overzicht(lijst);


        StandaardC = new JScrollPane(new ComponentLijst());
        StandaardC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CustomC = new JScrollPane(new ComponentLijst());
        CustomC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        VCT = new VoegComponentToe();




// Create JLabel in JPanel Top
        JLBLTitle = new JLabel("Monitoring Tool");
        JLBLTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLBLIO = new JLabel("Infrastructuur overzicht");
        JLBLIO.setFont(new Font("Tahoma", Font.PLAIN, 16));

        CustomTitle = new JLabel("Custom Componenten");
        CustomTitle.setFont(new Font("", Font.BOLD, 16));

        StandaardTitle = new JLabel("Standaard Componenten");
        StandaardTitle.setFont(new Font("", Font.PLAIN, 16));


// Create JLabels in JPanel_Left
        JLBL_A_Firewall = new JLabel();
        JLBL_A_Firewall.setBorder(border1);

        JLBL_K_Firewall = new JLabel();
        JLBL_K_Firewall.setBorder(border1);

        JLBL_A_Databases = new JLabel();
        JLBL_A_Databases.setBorder(border1);

        JLBL_K_Databases = new JLabel();
        JLBL_K_Databases.setBorder(border1);

        JLBL_A_Webs = new JLabel();
        JLBL_A_Webs.setBorder(border1);

        JLBL_K_Webs = new JLabel();
        JLBL_K_Webs.setBorder(border1);

        JLBL_TotKosten = new JLabel();
        JLBL_TotKosten.setBorder(border1);

        JLBL_Beschikbaarheid = new JLabel();
        JLBL_Beschikbaarheid.setBorder(border1);


        JLBLStat = new JLabel("Statistieken");
        JLBLStat.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLBLFirewall = new JLabel("Firewall");
        JLBLFirewall.setFont(new Font("Plain", Font.PLAIN, 13));

        JLBLWebs = new JLabel("Websever(s)");
        JLBLWebs.setFont(new Font("Plain", Font.PLAIN, 13));


        JLBLDatabases = new JLabel("Database server(s)");
        JLBLDatabases.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_Aantal = new JLabel("Aantal");
        JLBL_Aantal.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBLKosten = new JLabel("Kosten");
        JLBLKosten.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_TotK = new JLabel("Totale kosten");
        JLBL_TotK.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_Beschi = new JLabel("Beschikbaarheid");
        JLBL_Beschi.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        JLBL_Beschi.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_Euro = new JLabel("\u20AC");
        JLBL_Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_Procent = new JLabel("%");
        JLBL_Procent.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLBL_GWBesch = new JLabel("Gewenste beschikbaarheid in %");
        add(JLBL_GWBesch);

        JLBL_Error = new JLabel("");
        JLBL_Error.setForeground(Color.red);
        add(JLBL_Error);

// Create JTextField in Jpanel Top
        /**
         * None
         */


// Create JTextFields in JPanel_Left
        JTXTF_GWBesch = new JTextField();
        JTXTF_GWBesch.setColumns(10);
        JTXTF_GWBesch.addActionListener(this);
        add(JTXTF_GWBesch);

// Create JButtons in JPanel Top
        /**
         * none
         */


// Create JButtons in JPanel Left
        JBTN_Optimaliseer = new JButton("Optimaliseer");
        JBTN_Optimaliseer.setFocusable(false);
        JBTN_Optimaliseer.addActionListener(this);
        add(JBTN_Optimaliseer);

        JBTN_VerwiA = new JButton("Verwijder Alles");
        JBTN_VerwiA.addActionListener(this);
        JBTN_VerwiA.setFocusable(false);
        add(JBTN_VerwiA);

        JBTN_OpenCL = new JButton("Open Componentenlijst");
        JBTN_OpenCL.addActionListener(this);
        JBTN_OpenCL.setFocusable(false);

        JBTN_VCT = new JButton("Voeg component toe");
        JBTN_VCT.addActionListener(this);
        JBTN_VCT.setFocusable(false);

        JBTN_IO = new JButton("Infrastructuur overzicht");
        JBTN_IO.setFocusable(false);
        JBTN_IO.addActionListener(this);
        add(JBTN_IO);


// Create Separator in Jpanel Top
        SEPA_Top = new JSeparator();
        SEPA_Top.setForeground(Color.BLACK);
        add(SEPA_Top);


// Create Seperators in JPanel_Left
        SEPA_Stat1 = new JSeparator();
        SEPA_Stat2 = new JSeparator();
        add(SEPA_Stat2);

        SEPA_Mid1 = new JSeparator();
        SEPA_Mid1.setForeground(Color.BLACK);

        SEPA_Mid2 = new JSeparator();
        SEPA_Mid2.setForeground(Color.BLACK);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setForeground(Color.BLACK);
        add(SEPA_Bottom);


// Overig:

// Create JButton Exit in JPanel Top
        JBTNExit = new JButton("X");
        JBTNExit.setFocusable(false);
        JBTNExit.setFocusTraversalKeysEnabled(false);
        JBTNExit.setFocusPainted(false);
        JBTNExit.setRolloverEnabled(false);
        JBTNExit.setRequestFocusEnabled(false);
        JBTNExit.setFont(new Font("Tahoma", Font.BOLD, 12));
        JBTNExit.setMargin(new Insets(0, 0, 0, 0));
        JBTNExit.setBorderPainted(false);
        JBTNExit.setOpaque(false);
        JBTNExit.addActionListener(new CloseListener());
        JBTNExit.setBackground(Color.red);
        add(JBTNExit);

        JBTN_Opslaan = new JButton("");
        JBTN_Opslaan.setFocusable(false);
        JBTN_Opslaan.setFocusTraversalKeysEnabled(false);
        JBTN_Opslaan.setFocusPainted(false);
        JBTN_Opslaan.setRolloverEnabled(false);
        JBTN_Opslaan.setRequestFocusEnabled(false);
        JBTN_Opslaan.setFont(new Font("Tahoma", Font.BOLD, 12));
        JBTN_Opslaan.setMargin(new Insets(0, 0, 0, 0));
        JBTN_Opslaan.setBorderPainted(false);
        JBTN_Opslaan.setOpaque(false);

        JBTN_Open = new JButton("+");
        JBTN_Open.setFocusPainted(false);
        JBTN_Open.setFocusTraversalKeysEnabled(false);
        JBTN_Open.setFocusable(false);
        JBTN_Open.setOpaque(false);
        JBTN_Open.setFont(new Font("Tahoma", Font.BOLD, 12));
        JBTN_Open.setMargin(new Insets(0, 0, 0, 0));
        JBTN_Open.setDefaultCapable(false);
        JBTN_Open.setBorderPainted(false);


// Create Overig in Jpanel in Left
        /**
         * none
         */
// Group Jpanel JPNL_Top
        GroupLayout groupLayout = new GroupLayout(this.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JPNL_Top, GroupLayout.PREFERRED_SIZE, 884, Short.MAX_VALUE)
                                        .addComponent(JPNL_Left, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                        .addGap(208)
                                        .addComponent(IO, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                        .addComponent(StandaardC, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(208)
                                        .addComponent(CustomC, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE))
                                        .addComponent(VCT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JPNL_Top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(95)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(IO, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                                .addGap(40)
                                                .addComponent(StandaardC, GroupLayout.DEFAULT_SIZE, 200, 200 )
                                                .addGap(50)
                                                .addComponent(CustomC, GroupLayout.DEFAULT_SIZE, 200, 300)
                                                .addComponent(VCT, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                                .addGap(1))
                                        .addComponent(JPNL_Left, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)))
        );


        GroupLayout gl_JPNL_Left = new GroupLayout(JPNL_Left);
        gl_JPNL_Left.setHorizontalGroup(
                gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(33)
                                                .addComponent(JTXTF_GWBesch, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_GWBesch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(43)
                                .addComponent(JBTN_Optimaliseer, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(43)
                                .addComponent(JBTN_VerwiA, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(2)
                                .addComponent(SEPA_Mid1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(27)
                                .addComponent(JBTN_IO, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(27)
                                .addComponent(JBTN_OpenCL, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(27)
                                .addComponent(JBTN_VCT, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(2)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(SEPA_Mid2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(64)
                                                .addComponent(JLBLStat, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBLFirewall, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBLDatabases, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBLWebs, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SEPA_Stat2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SEPA_Stat1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBL_Aantal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(JLBLKosten, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_A_Firewall, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9)
                                                .addComponent(JLBL_K_Firewall, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9)
                                                .addComponent(JLBL_K_Webs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9)
                                                .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(2)
                                .addComponent(SEPA_Bottom, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(12)
                                .addComponent(JLBL_TotK, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(11)
                                                .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Euro, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(12)
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
                                .addGap(2)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                .addComponent(JTXTF_GWBesch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_GWBesch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)))
                                .addGap(5)
                                .addComponent(JBTN_Optimaliseer, GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                                .addGap(4)
                                .addComponent(JBTN_VerwiA, GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                                .addGap(11)
                                .addComponent(SEPA_Mid1, GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                                .addGap(17)
                                .addComponent(JBTN_IO, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                .addGap(16)
                                .addComponent(JBTN_OpenCL, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                .addGap(16)
                                .addComponent(JBTN_VCT, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                .addGap(16)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SEPA_Mid2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(8))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_JPNL_Left.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                                .addComponent(JLBLStat, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
                                .addGap(3)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(11)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addComponent(JLBLFirewall, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                                .addGap(24)
                                                                                .addComponent(JLBLDatabases, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                                .addComponent(JLBLWebs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(51)
                                                                .addComponent(SEPA_Stat2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(9))
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(23)
                                                                .addComponent(SEPA_Stat1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBL_Aantal)
                                                        .addComponent(JLBLKosten))
                                                .addGap(1)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBL_A_Firewall, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBL_K_Firewall, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                                .addGap(7)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBL_K_Webs, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                                .addGap(7)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
                                .addGap(17)
                                .addComponent(SEPA_Bottom, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBL_TotK, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBL_Euro))
                                .addGap(4)
                                .addGroup(gl_JPNL_Left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBL_Beschi, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBL_Beschikbaarheid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBL_Procent))
                                .addGap(14))
        );
        JPNL_Left.setLayout(gl_JPNL_Left);
        GroupLayout gl_JPNL_Top = new GroupLayout(JPNL_Top);
        gl_JPNL_Top.setHorizontalGroup(
                gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGap(8)
                                .addComponent(JBTN_Opslaan, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(JBTN_Open, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(440)
                                .addComponent(JLBLTitle, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                                .addComponent(JBTNExit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addComponent(SEPA_Top, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGap(10)
                                .addComponent(JLBL_Error, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(JLBLIO, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                .addGap(181))
        );
        gl_JPNL_Top.setVerticalGroup(
                gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGroup(gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                                .addGap(8)
                                                .addComponent(JBTN_Opslaan, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                                .addGap(8)
                                                .addComponent(JBTN_Open, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(JLBLTitle, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JBTNExit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(6)
                                .addComponent(SEPA_Top, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addGroup(gl_JPNL_Top.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                                .addGap(16)
                                                .addComponent(JLBL_Error))
                                        .addComponent(JLBLIO, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        );
        JPNL_Top.setLayout(gl_JPNL_Top);
        this.getContentPane().setLayout(groupLayout);


        IO.setVisible(true);
        JBTN_IO.setBackground(Color.gray);
        VCT.setVisible(false);
        StandaardC.setVisible(false);
        CustomC.setVisible(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();

        if (e.getSource() == JBTN_Optimaliseer) {
            try {
                double GewBeschik = Double.parseDouble(JTXTF_GWBesch.getText());
                if (GewBeschik > 0.1 && GewBeschik < 100.0) {
                    String str = JTXTF_GWBesch.getText();
                    JLBL_Beschikbaarheid.setText(" " + str);
                    JLBL_Error.setText("");
                } else {
                    JLBL_Error.setText("De gewenste beschikbaarheid moet tussen 0.1% en 99.99% liggen");
                }
            } catch (NumberFormatException nfe) {
                JLBL_Error.setText("Alleen getallen kunnen worden ingevoerd!");
            }
        }

        if(e.getSource() == JBTN_VerwiA) {

        }

        if(e.getSource() == JBTN_IO) {
            JBTN_IO.setBackground(Color.gray);
            JBTN_OpenCL.setBackground(Color.white);
            JBTN_VCT.setBackground(Color.white);
            IO.setVisible(true);
            VCT.setVisible(false);
            StandaardC.setVisible(false);
            CustomC.setVisible(false);
            JLBLIO.setText("Infrastructuur overzicht");
        }

        if(e.getSource() == JBTN_OpenCL) {
            JBTN_OpenCL.setBackground(Color.gray);
            JBTN_IO.setBackground(Color.white);
            JBTN_VCT.setBackground(Color.white);
            IO.setVisible(false);
            VCT.setVisible(false);
            StandaardC.setVisible(true);
            CustomC.setVisible(true);
            JLBLIO.setText("Componentenlijst");

        }

        if(e.getSource() == JBTN_VCT) {
            JBTN_VCT.setBackground(Color.gray);
            JBTN_OpenCL.setBackground(Color.white);
            JBTN_IO.setBackground(Color.white);
            VCT.setVisible(true);
            IO.setVisible(false);
            StandaardC.setVisible(false);
            CustomC.setVisible(false);
            JLBLIO.setText("Componenten toevoegen");
        }

        if (e.getSource() == JBTN_VerwiA) {
            Bevestiging_popup BP = new Bevestiging_popup();
            BP.setVisible(true);
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
