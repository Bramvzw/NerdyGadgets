import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Applicatie extends JFrame implements ActionListener {

    public static void main(String[] args) {
        try {
            new Applicatie();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private Infrastructuur_Overzicht IO;
    private Opslag OP = new Opslag();
    private JPanel JPNL_Top, JPNL_Left;
    private JLabel JLBLTitle, JLBLIO, JLBL_A_Firewall, JLBL_K_Firewall, JLBL_A_Databases, JLBL_K_Databases, JLBL_A_Webs, JLBL_K_Webs, JLBL_TotKosten, JLBL_Error, JLBL_Beschikbaarheid, JLBLStat, JLBLFirewall, JLBLWebs, JLBLDatabases,
            JLBL_Aantal, JLBLKosten, JLBL_GWBesch, JLBL_TotK, JLBL_Beschi, JLBL_Euro, JLBL_Procent, CustomTitle, StandaardTitle;
    private JTextField JTXTF_GWBesch;
    private JButton JBTN_Optimaliseer, JBTN_VerwiA, JBTN_OpenCL, JBTN_CO, JBTN_Opslaan, JBTN_Open, JBTN_IO;
    private JSeparator SEPA_Top, SEPA_Stat1, SEPA_Stat2, SEPA_Mid1, SEPA_Mid2, SEPA_Bottom;
    private JScrollPane StandaardC, COJ;
    private ComponentOverzicht CO;
    private Boolean boolConnectie = false;

    private ArrayList<Componenten> keuzeComponenten =  new ComponentArray(this).getComponentenArray();
    static ArrayList<Componenten> momenteleComponenten = new ArrayList<>();
    private ArrayList<Componenten> oudeMomenteleComponenten = new ArrayList<>();


    public Applicatie() throws SQLException, IOException {
        //Update timer starten
        if(boolConnectie) {
            new Thread(this::timerUpdate).start();
        }

        setBounds(100, 100, 900, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1160, 750));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create Border
        Border border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, null, null, null);

        // Create JPanels
        JPNL_Top = new JPanel();
        JPNL_Top.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        JPNL_Top.setBackground(new Color(169, 169, 169));
        add(JPNL_Top);

        JPNL_Left = new JPanel();
        JPNL_Left.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        JPNL_Left.setBackground(new Color(169, 169, 169));
        add(JPNL_Left);

        IO = new Infrastructuur_Overzicht(momenteleComponenten);

        StandaardC = new JScrollPane(new ComponentLijst(this, keuzeComponenten, momenteleComponenten));
        CO = new ComponentOverzicht(this, keuzeComponenten, momenteleComponenten);
        COJ = new JScrollPane(CO);




        // Create JLabel in JPanel Top
        JLBLTitle = new JLabel("Monitoring Tool");
        JLBLTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLBLIO = new JLabel("Infrastructuur overzicht");
        JLBLIO.setFont(new Font("Tahoma", Font.PLAIN, 16));

        CustomTitle = new JLabel("Componenten overzicht");
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
        JBTN_OpenCL.setBackground(Color.white);

        JBTN_CO = new JButton("Componenten overzicht");
        JBTN_CO.addActionListener(this);
        JBTN_CO.setFocusable(false);
        JBTN_CO.setBackground(Color.white);

        JBTN_IO = new JButton("Infrastructuur overzicht");
        JBTN_IO.setFocusable(false);
        JBTN_IO.addActionListener(this);
        JBTN_IO.setBackground(Color.white);
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

        //Opslaan button
        JBTN_Opslaan = new JButton();
        try {
            Image opslaan = ImageIO.read(new File("Images\\save-icon.png"));
            JBTN_Opslaan.setIcon(new ImageIcon(opslaan));
        } catch (IOException ex) {}
        JBTN_Opslaan.setBackground(Color.lightGray);
        JBTN_Opslaan.setFocusable(false);
        JBTN_Opslaan.setFocusTraversalKeysEnabled(false);
        JBTN_Opslaan.setFocusPainted(false);
        JBTN_Opslaan.setRolloverEnabled(false);
        JBTN_Opslaan.setRequestFocusEnabled(false);
        JBTN_Opslaan.setFont(new Font("Tahoma", Font.BOLD, 12));
        JBTN_Opslaan.setMargin(new Insets(0, 0, 0, 0));
        JBTN_Opslaan.setBorderPainted(false);
        JBTN_Opslaan.setOpaque(false);
        JBTN_Opslaan.addActionListener(this);



        //Openen button
        JBTN_Open = new JButton();
        try {
            Image opslaan = ImageIO.read(new File("Images\\open-icon.png"));
            JBTN_Open.setIcon(new ImageIcon(opslaan));
        } catch (IOException ex) {}
        JBTN_Open.setBackground(Color.lightGray);
        JBTN_Open.setFocusPainted(false);
        JBTN_Open.setFocusTraversalKeysEnabled(false);
        JBTN_Open.setFocusable(false);
        JBTN_Open.setOpaque(false);
        JBTN_Open.setFont(new Font("Tahoma", Font.BOLD, 12));
        JBTN_Open.setMargin(new Insets(0, 0, 0, 0));
        JBTN_Open.setDefaultCapable(false);
        JBTN_Open.setBorderPainted(false);
        JBTN_Open.addActionListener(this);

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
                                        .addComponent(COJ, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                                .addComponent(IO, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                                                .addGroup(groupLayout.createSequentialGroup()
                                                        .addGap(200)
                                                        .addComponent(StandaardC, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                .addGap(15)
                                                .addComponent(COJ, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
                                .addComponent(JBTN_CO, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(JLBL_A_Firewall, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5)
                                                .addComponent(JLBL_K_Firewall, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_A_Webs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5)
                                                .addComponent(JLBL_K_Webs, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_JPNL_Left.createSequentialGroup()
                                                .addComponent(JLBL_A_Databases, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5)
                                                .addComponent(JLBL_K_Databases, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(JBTN_Optimaliseer, GroupLayout.PREFERRED_SIZE, 25, 30)
                                .addGap(4)
                                .addComponent(JBTN_VerwiA, GroupLayout.PREFERRED_SIZE, 25, 30)
                                .addGap(11)
                                .addComponent(SEPA_Mid1, GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                                .addGap(17)
                                .addComponent(JBTN_IO, GroupLayout.PREFERRED_SIZE, 55, 60)
                                .addGap(40)
                                .addComponent(JBTN_OpenCL, GroupLayout.PREFERRED_SIZE, 55, 60)
                                .addGap(40)
                                .addComponent(JBTN_CO, GroupLayout.PREFERRED_SIZE, 55, 60)
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
                                .addGap(200)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(JLBLTitle, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE))

                        .addComponent(SEPA_Top, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                        .addGroup(gl_JPNL_Top.createSequentialGroup()
                                .addGap(10)
                                .addComponent(JLBL_Error, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, 600)
                                .addComponent(JLBLIO, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                .addGap(300))
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
                                                .addComponent(JLBLTitle, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
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

        //Panels zichtbaar maken
        IO.setVisible(true);
        JBTN_IO.setBackground(Color.gray);
        COJ.setVisible(false);
        StandaardC.setVisible(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.repaint();

        //Optimaliseer knop activeer proces
        if (e.getSource() == JBTN_Optimaliseer) {
            try {
                double GewBeschik = Double.parseDouble(JTXTF_GWBesch.getText());
                if (GewBeschik > 0.0 && GewBeschik < 100.0) {
                    String str = JTXTF_GWBesch.getText();
//                    JLBL_Beschikbaarheid.setText(" " + str);
                    JLBL_Error.setText("");
                    GewBeschik /= 100;
                    veranderComponenten(momenteleComponenten,new Optimaliseer().optimaliseer(GewBeschik, keuzeComponenten));
//                    momenteleComponenten = new Optimaliseer().optimaliseer(GewBeschik, keuzeComponenten);
                } else {
                    JLBL_Error.setText("De gewenste beschikbaarheid moet tussen 0.1% en 99.99% liggen");
                }
            } catch (NumberFormatException nfe) {
                JLBL_Error.setText("Alleen getallen kunnen worden ingevoerd!");
            }
        }

        //Infrastructuur overzicht knop activeer proces
        if (e.getSource() == JBTN_IO) {
            JBTN_IO.setBackground(Color.gray);
            JBTN_OpenCL.setBackground(Color.white);
            JBTN_CO.setBackground(Color.white);
            IO.setVisible(true);
            COJ.setVisible(false);
            StandaardC.setVisible(false);
            JLBLIO.setText("Infrastructuur overzicht");
        }

        //Componentlijst knop activeer proces
        if (e.getSource() == JBTN_OpenCL) {
            JBTN_OpenCL.setBackground(Color.gray);
            JBTN_IO.setBackground(Color.white);
            JBTN_CO.setBackground(Color.white);
            IO.setVisible(false);
            COJ.setVisible(false);
            StandaardC.setVisible(true);
            JLBLIO.setText("Componentenlijst");

        }

        //Component overzicht knop activeer proces
        if (e.getSource() == JBTN_CO) {
            JBTN_CO.setBackground(Color.gray);
            JBTN_OpenCL.setBackground(Color.white);
            JBTN_IO.setBackground(Color.white);
            COJ.setVisible(true);
            IO.setVisible(false);
            StandaardC.setVisible(false);
            JLBLIO.setText("Component overzicht");
        }

        //Verwijder alles knop activeer proces
        if (e.getSource() == JBTN_VerwiA) {
            Bevestiging_popup BP = new Bevestiging_popup(this);
            BP.setVisible(true);
            JLBL_K_Databases.setText("");
            JLBL_A_Databases.setText("");
            JLBL_A_Webs.setText("");
            JLBL_K_Webs.setText("");
            JLBL_A_Firewall.setText("");
            JLBL_K_Firewall.setText("");
            JLBL_TotKosten.setText("");
            JLBL_Beschikbaarheid.setText("");
            if(BP.isBoolOk()){
                momenteleComponenten.clear();
                this.repaint();
            }
        }

        //Open opgeslagen infrastructuren knop activeer proces
        if (e.getSource() == JBTN_Open) {
            Open_modal OM = new Open_modal(this,OP.ophalenGroepNamen());

            if(OM.getBoolOk()){
                veranderComponenten(momenteleComponenten, OP.ophalenComponenten(OM.getGeselecteerd()));
            }
        }

        //Opslaan infrastructuur knop activeer proces
        if (e.getSource() == JBTN_Opslaan) {
            Opslaan_modal OM = new Opslaan_modal(this,momenteleComponenten);

            if(OM.getBoolOk()){
                OP.slaOp(momenteleComponenten, OM.getNaam());
            }
        }

        //Bijwerk activeer proces
        if (!momenteleComponenten.equals(oudeMomenteleComponenten)) {
            updateComponenten();
        }

    }

    //Componentenlijst veranderen methode
    public void veranderComponenten(ArrayList<Componenten> oudComponenten, ArrayList<Componenten> nieuwComponenten){
        oudComponenten.clear();
        for(Componenten component : nieuwComponenten){
            oudComponenten.add(component);
        }
    }

    //Momentele componeten update methode
    public void updateComponenten(){
        veranderComponenten(momenteleComponenten,Optimaliseer.sorteer(momenteleComponenten));
        veranderComponenten(oudeMomenteleComponenten,momenteleComponenten);
        IO.setcomponenten(momenteleComponenten);
        String[] componentTypes = {"firewall", "DBserver", "webserver"};
        double beschikbaarheid = 1;
        double laatsteBeschikbaarheid = 1;
        double kosten = 0;
        int aantalFirewalls = 0;
        int aantalDatabases = 0;
        int aantalWebservers = 0;
        double kostenFirewalls = 0;
        double kostenDatabases = 0;
        double kostenWebservers = 0;

        for (String type : componentTypes) {
            for (Componenten component : momenteleComponenten) {
                if (component.getType().equals(type)) {
                    laatsteBeschikbaarheid *= (1 - (component.getBeschikbaarheid() / 100));
                    kosten += component.getPrijs();
                    if (type.equals("firewall")) {
                        aantalFirewalls++;
                        kostenFirewalls += component.getPrijs();
                    }
                    if (type.equals("DBserver")) {
                        aantalDatabases++;
                        kostenDatabases += component.getPrijs();
                    }
                    if (type.equals("webserver")) {
                        aantalWebservers++;
                        kostenWebservers += component.getPrijs();
                    }
                }
            }
            beschikbaarheid *= (1 - laatsteBeschikbaarheid);
            laatsteBeschikbaarheid = 1;
        }
        beschikbaarheid *= 100;
        DecimalFormat df = new DecimalFormat("0.000");
        JLBL_Beschikbaarheid.setText(df.format(beschikbaarheid));
        JLBL_TotKosten.setText(Double.toString(kosten));
        JLBL_A_Firewall.setText(Integer.toString(aantalFirewalls));
        JLBL_A_Databases.setText(Integer.toString(aantalDatabases));
        JLBL_A_Webs.setText(Integer.toString(aantalWebservers));
        JLBL_K_Firewall.setText(Double.toString(kostenFirewalls));
        JLBL_K_Databases.setText(Double.toString(kostenDatabases));
        JLBL_K_Webs.setText(Double.toString(kostenWebservers));
        CO.getComponent();
    }

    public ArrayList<Componenten> getMomenteleComponenten() {
        return momenteleComponenten;
    }

    //Update timer methode
    public void timerUpdate(){
        while(true){
            if(momenteleComponenten.size() != 0){
                try {
                    for (Componenten component : momenteleComponenten) {
                        component.updateGegevens();
                        component.testConnectie();
                        CO.getComponent();
                    }
                }
                catch (Exception e){

                }
            }
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public void waarschuwingConnectie(){
        new JOptionPane().showMessageDialog(this,"Waarschuwing! U heeft geen connectie met de database");
        keuzeComponenten = new ArrayList<>();
    }

    public void setBoolConnectie(Boolean boolConnectie) {
        this.boolConnectie = boolConnectie;
    }

    public boolean getBoolConnectie() {
        return boolConnectie;
    }

}




