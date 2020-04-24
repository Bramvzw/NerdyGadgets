import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Applicatie implements ActionListener {

    // JFrame
    JFrame frame = new JFrame();
    ComponentResizer cr = new ComponentResizer();




    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Applicatie window = new Applicatie();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Applicatie() {
        initialize();
    }

    private void initialize() {

// Set properties JFrame
        cr.registerComponent(frame);
        MotionPanel mp = new MotionPanel(frame);

        frame.setBounds(100, 100, 856, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(900, 570));
        frame.setLocation(500, 250);
        frame.setUndecorated(true);
        cr.setSnapSize(new Dimension(10, 10));

        Border border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, null, null, null);



// Create JPanel Top
        JPanel JPNL_Top = new MotionPanel(frame);
        JPNL_Top.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        JPNL_Top.setBackground(new Color(169,169,169));

// Create JPanel Left-side
        JPanel JPNL_Left = new JPanel();
        JPNL_Left.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Left.setBackground(new Color(169,169,169));

// Create JPanel Bottom
        JPanel JPNL_Bottom = new JPanel();
        JPNL_Bottom.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Bottom.setBackground(new Color(169,169,169));

// Create JLabel in Jpanel Top
        JLabel JLBLTitle = new JLabel("Monitoring Tool");
        JLBLTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel JLBLIO = new JLabel("Infrastructuur overzicht");
        JLBLIO.setFont(new Font("Tahoma", Font.PLAIN, 16));


// Create JLabels in JPanel_Left
        JLabel JLBL_A_Firewall = new JLabel();
        JLBL_A_Firewall.setBorder(border1);

        JLabel JLBL_K_Firewall = new JLabel();
        JLBL_K_Firewall.setBorder(border1);

        JLabel JLBL_A_Databases = new JLabel();
        JLBL_A_Databases.setBorder(border1);

        JLabel JLBL_K_Databases = new JLabel();
        JLBL_K_Databases.setBorder(border1);

        JLabel JLBL_A_Webs = new JLabel();
        JLBL_A_Webs.setBorder(border1);

        JLabel JLBL_K_Webs = new JLabel();
        JLBL_K_Webs.setBorder(border1);

        JLabel JLBL_TotKosten = new JLabel();
        JLBL_TotKosten.setBorder(border1);

        JLabel JTXTF_Beschikbaarheid = new JLabel();
        JTXTF_Beschikbaarheid.setBorder(border1);


        JLabel JLBLStat = new JLabel("Statistieken");
        JLBLStat.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel JLBLFirewall = new JLabel("Firewall");
        JLBLFirewall.setFont(new Font("Plain", Font.PLAIN, 13));

        JLabel JLBLWebs = new JLabel("Websever(s)");
        JLBLWebs.setFont(new Font("Plain", Font.PLAIN, 13));


        JLabel JLBLDatabases = new JLabel("Database server(s)");
        JLBLDatabases.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel JLBLAantal = new JLabel("Aantal");

        JLabel JLBLKosten = new JLabel("Kosten");

        JLabel JLBL_GWBesch = new JLabel("Gewenste beschikbaarheid in %");
        JLBL_GWBesch.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_TotK = new JLabel("Totale kosten");
        JLBL_TotK.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel JLBL_Beschi = new JLabel("Beschikbaarheid");
        JLBL_Beschi.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        JLBL_Beschi.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel JLBL_Euro = new JLabel("\u20AC");
        JLBL_Euro.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel JLBL_Procent = new JLabel("%");
        JLBL_Procent.setFont(new Font("Tahoma", Font.BOLD, 13));


// Create JLabel in JPanel Bottom
        JLabel JLBL_BeschC = new JLabel("Beschikbare componenten");
        JLBL_BeschC.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_Type1 = new JLabel("Type");
        JLBL_Type1.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_Naam2_1 = new JLabel("Naam");
        JLBL_Naam2_1.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_Beschik = new JLabel("Beschikbaarheid in %");
        JLBL_Beschik.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_Prijs = new JLabel("Prijs in \u20AC");
        JLBL_Prijs.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel JLBL_Type2 = new JLabel("Type");
        JLabel JLBL_Naam2 = new JLabel("Naam");

        JLabel JTXTF_Naam_Top = new JLabel();
        JTXTF_Naam_Top.setBorder(border1);

        JLabel JTXTF_Naam_Mid = new JLabel();
        JTXTF_Naam_Mid.setBorder(border1);

        JLabel JTXTF_Naam_Bottom = new JLabel();
        JTXTF_Naam_Bottom.setBorder(border1);

        JLabel JTXTF_Type_Top = new JLabel();
        JTXTF_Type_Top.setBorder(border1);

        JLabel JTXTF_Type_Mid = new JLabel();
        JTXTF_Type_Mid.setBorder(border1);

        JLabel JTXTF_Type_Bottom = new JLabel();
        JTXTF_Type_Bottom.setBorder(border1);


// Create JTextField in Jpanel Top
        /**
         * None
         */


// Create JTextFields in JPanel_Left
        JTextField JTXTF_GWBesch = new JTextField();
        JTXTF_GWBesch.setColumns(10);


// Create JTextFields in JPanel Bottom
        JTextField JTXTF_Naam = new JTextField();
        JTXTF_Naam.setColumns(10);

        JTextField JTXTF_Beschik = new JTextField();
        JTXTF_Beschik.setColumns(10);

        JTextField JTXT_Prijs = new JTextField();
        JTXT_Prijs.setColumns(10);






// Create JButtons in JPanel Top
        /**
         * none
         */


// Create JButtons in JPanel Left
        JButton JBTN_Optimaliseer = new JButton("Optimaliseer");
        JButton JBTN_Ontwerp = new JButton("Ontwerp");
        JButton JBTN_VerwiA = new JButton("Verwijder Alles");
        JBTN_VerwiA.setFont(new Font("Tahoma", Font.BOLD, 10));


// Create JButtons in JPanel Bottom
        JButton JBTN_Comp1 = new JButton();
        JBTN_Comp1.setIcon(new ImageIcon("Images/Firewall-ico.png"));
        JBTN_Comp1.setBackground(new Color(249,249,249));

        JButton JBTN_Comp2 = new JButton();
        JBTN_Comp2.setIcon(new ImageIcon("Images/Database-ico.png"));
        JBTN_Comp2.setBackground(new Color(249,249,249));


        JButton JBTN_Comp3 = new JButton("");
        JBTN_Comp3.setIcon(new ImageIcon("Images/Webserver-ico.png"));
        JBTN_Comp3.setBackground(new Color(249,249,249));


        JButton JBTN_Reset = new JButton("Reset");
        JButton JBTN_Voegtoe = new JButton("Voeg toe");


// Create Separator in Jpanel Top
        JSeparator SEPA_Top = new JSeparator();
        SEPA_Top.setForeground(Color.BLACK);


// Create Seperators in JPanel_Left
        JSeparator SEPA_Stat1 = new JSeparator();
        JSeparator SEPA_Stat2 = new JSeparator();

        JSeparator SEPA_Left_Top = new JSeparator();
        SEPA_Left_Top.setForeground(Color.BLACK);

        JSeparator SEPA_Left_Bottom = new JSeparator();
        SEPA_Left_Bottom.setForeground(Color.BLACK);


// Create Separators in Jpanel Bottom
        JSeparator SEPA_Left = new JSeparator();
        SEPA_Left.setOrientation(SwingConstants.VERTICAL);

        JSeparator SEPA_Right = new JSeparator();
        SEPA_Right.setOrientation(SwingConstants.VERTICAL);


// Overig:

// Create JButton Exit in JPanel Top
        JButton JBTNExit = new JButton("X");
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


// Create Overig in Jpanel in Left
        /**
         * none
         */


// Create Scrollbar in Jpanel Bottom
        JComboBox ComboBox = new JComboBox();

        JScrollBar Scrollbar = new JScrollBar();
        Scrollbar.setOrientation(JScrollBar.HORIZONTAL);


// Group Jpanel JPNL_Top
        GroupLayout gl_JPNL_Top = new GroupLayout(JPNL_Top);
        gl_JPNL_Top.setHorizontalGroup(
                gl_JPNL_Top.createParallelGroup(Alignment.TRAILING)
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
                gl_JPNL_Top.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGroup(gl_JPNL_Top.createParallelGroup(Alignment.LEADING)
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
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(JPNL_Top, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPNL_Bottom, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addComponent(JPNL_Left, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
        );

        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(JPNL_Top, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                                .addComponent(JPNL_Bottom, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(JPNL_Left, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                .addGap(95))))
        );


// Group JPanel JPNL_Left Horizontaal
        GroupLayout gl_JPNL_Left = new GroupLayout(JPNL_Left);
        gl_JPNL_Left.setHorizontalGroup(
                gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(JLBLWebs, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JLBLFirewall, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SEPA_Stat1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                                .addGap(110)
                                                                .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(13)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(11)
                                                .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Euro, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addComponent(JLBL_Beschi, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(JTXTF_Beschikbaarheid, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(JLBL_Procent, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        );
        gl_JPNL_Left.setVerticalGroup(
                gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(23)
                                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(SEPA_Stat2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLBLDatabases, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
                                .addGap(11)
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_TotK, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_TotKosten, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Euro)))
                                .addGap(4)
                                .addGroup(gl_JPNL_Left.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Beschi, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JTXTF_Beschikbaarheid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_Procent)))
                                .addGap(16))
        );
        JPNL_Left.setLayout(gl_JPNL_Left);

// Group JPanel JPNL_Bottom
        GroupLayout gl_JPNL_Bottom = new GroupLayout(JPNL_Bottom);
        gl_JPNL_Bottom.setHorizontalGroup(
                gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(8)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(JLBL_Type1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addGap(25))
                                        .addComponent(ComboBox, 0, 72, Short.MAX_VALUE))
                                .addGap(14)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
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
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addComponent(JLBL_Prijs, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                .addGap(31))
                                        .addComponent(JTXT_Prijs, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addGap(12)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JTXTF_Type_Mid, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JTXTF_Naam_Mid, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JLBL_Naam2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JTXTF_Naam_Bottom, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JTXTF_Type_Top, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(Scrollbar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JTXTF_Type_Bottom, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(7)
                                                .addComponent(JLBL_Type2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(SEPA_Right, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(89)
                                                .addComponent(JTXTF_Naam_Top, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                .addGap(17))
        );
        gl_JPNL_Bottom.setVerticalGroup(
                gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(2)
                                .addComponent(JLBL_BeschC, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
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
                                .addComponent(ComboBox, GroupLayout.PREFERRED_SIZE,20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(2)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(JLBL_Naam2_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JLBL_Beschik, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                .addGap(1)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addComponent(JTXTF_Naam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTXTF_Beschik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(15)
                                .addGroup(gl_JPNL_Bottom.createParallelGroup(Alignment.LEADING)
                                        .addComponent(JBTN_Reset)
                                        .addComponent(JBTN_Voegtoe)))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(3)
                                .addComponent(JLBL_Prijs, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(JTXT_Prijs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(33)
                                .addComponent(JTXTF_Type_Mid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(33)
                                .addComponent(JTXTF_Naam_Mid, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addComponent(JLBL_Naam2)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(51)
                                .addComponent(JTXTF_Naam_Bottom, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(15)
                                .addComponent(JTXTF_Type_Top, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(70)
                                .addComponent(Scrollbar, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(51)
                                .addComponent(JTXTF_Type_Bottom, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                        .addComponent(JLBL_Type2)
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(1)
                                .addComponent(SEPA_Right, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_JPNL_Bottom.createSequentialGroup()
                                .addGap(15)
                                .addComponent(JTXTF_Naam_Top, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        );
        JPNL_Bottom.setLayout(gl_JPNL_Bottom);
        frame.getContentPane().setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
