import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ComponentOverzicht extends JPanel implements ActionListener {
    private static int Index = 0;
    private JPanel PNL_Component;
    private JLabel JLBL_Processorb, JLBL_Diskruimte, JLBL_Placeholder, JLBL_I_Proccesb, JLBL_I_Diskruimte, JLBL_NetworkLoad, JLBL_I_OnOff_Line, JLBL_Naam;
    private JSeparator SEPA_Bottom;
    private JButton test;
    private ArrayList<Componenten> database = new ArrayList<>();
    private ArrayList<JPanel> panels = new ArrayList<>();


    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);



    public ComponentOverzicht(Applicatie applicatie, ArrayList<Componenten> keuzeComponenten,ArrayList<Componenten> momentelecomponenten) {
        database = applicatie.getMomenteleComponenten();

        test = new JButton("test");
        test.addActionListener(this);
        add(test);

    }


    public void getComponent() {
        for (int i = 0; i<panels.size(); i ++){
            this.remove(panels.get(i));
            panels.remove(panels.get(i));
        }

        for (Componenten comp : database) {
            PNL_Component = new JPanel();
            PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
            PNL_Component.setPreferredSize(new Dimension(200, 185));
            PNL_Component.setBackground(Color.lightGray);
            PNL_Component.setLayout(new FlowLayout());
            this.add(PNL_Component);

            JLBL_Naam = new JLabel(comp.getNaam());
            JLBL_Naam.setBorder(border2);
            JLBL_Naam.setPreferredSize(new Dimension(130, 20));
            JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
            PNL_Component.add(JLBL_Naam);

            JLBL_Placeholder = new JLabel("  ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_Processorb = new JLabel("Processorbelasting ");
            PNL_Component.add(JLBL_Processorb);

            JLBL_I_Proccesb = new JLabel(Double.toString(comp.getProcessorbelasting()));
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

            JLBL_I_Diskruimte = new JLabel(Double.toString(comp.getDiskruimte()));
            JLBL_I_Diskruimte.setBorder(border1);
            JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Diskruimte);

            SEPA_Bottom = new JSeparator();
            SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
            SEPA_Bottom.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Bottom);


            JLBL_Placeholder = new JLabel("        ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_OnOff_Line = new JLabel();
            if (comp.isBeschikbaar()) {
                JLBL_I_OnOff_Line = new JLabel("Online");
            } else {
                JLBL_I_OnOff_Line = new JLabel("Offline");
            }
            JLBL_I_OnOff_Line.setBorder(border1);
            JLBL_I_OnOff_Line.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_OnOff_Line);

            Index++;

            panels.add(PNL_Component);

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == test) {
            System.out.println(database);
            getComponent();
            this.revalidate();

        }


    }
}
