import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ComponentOverzicht extends JPanel {
    private static int Index = 0;
    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);
    private JPanel PNL_Component;
    private JLabel JLBL_Processorb, JLBL_Beschikbaarheid, JLBL_Type, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_Diskruimte, JLBL_Placeholder, JLBL_I_Proccesb, JLBL_I_Diskruimte, JLBL_Prijs, JLBL_I_Prijs, JLBL_I_OnOff_Line, JLBL_Naam;
    private JSeparator SEPA_Bottom;
    private JButton test;
    private ArrayList<Componenten> database;
    private ArrayList<JPanel> panels = new ArrayList<>();

    Border border_g = BorderFactory.createLineBorder(Color.green);
    Border border_r = BorderFactory.createLineBorder(Color.red);

    // ArrayList database vullen met de momentele componeten
    public ComponentOverzicht(Applicatie applicatie, ArrayList<Componenten> keuzeComponenten, ArrayList<Componenten> momentelecomponenten) {
        database = applicatie.getMomenteleComponenten();
    }

    // Arraylist panels legen
    public void getComponent() {
        for (int i = 0; i < panels.size(); i++) {
            this.remove(panels.get(i));
        }
        panels.clear();

        // Panels aanmaken voor momentele componenten
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

            JLBL_I_Proccesb = new JLabel(Double.toString(comp.getProcessorbelasting()) + " %");
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

            JLBL_I_Diskruimte = new JLabel(Double.toString(comp.getDiskruimte()) + " GB");
            JLBL_I_Diskruimte.setBorder(border1);
            JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Diskruimte);

            SEPA_Bottom = new JSeparator();
            SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
            SEPA_Bottom.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Bottom);

            JLBL_Type = new JLabel("Type");
            PNL_Component.add(JLBL_Type);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Type = new JLabel(comp.getType());
            JLBL_I_Type.setBorder(border1);
            JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Type);

            SEPA_Bottom = new JSeparator();
            SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
            SEPA_Bottom.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Bottom);

            JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
            PNL_Component.add(JLBL_Beschikbaarheid);

            JLBL_Placeholder = new JLabel("     ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Beschikbaarheid = new JLabel(Double.toString(comp.getBeschikbaarheid()) + " %");
            JLBL_I_Beschikbaarheid.setBorder(border1);
            JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Beschikbaarheid);

            SEPA_Bottom = new JSeparator();
            SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
            SEPA_Bottom.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Bottom);

            JLBL_Prijs = new JLabel("Prijs");
            PNL_Component.add(JLBL_Prijs);

            JLBL_Placeholder = new JLabel("                            ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_Prijs = new JLabel("€ " + Integer.toString(comp.getPrijs()));
            JLBL_I_Prijs.setBorder(border1);
            JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_Prijs);

            SEPA_Bottom = new JSeparator();
            SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
            SEPA_Bottom.setForeground(Color.darkGray);
            PNL_Component.add(SEPA_Bottom);

            JLBL_Placeholder = new JLabel("        ");
            PNL_Component.add(JLBL_Placeholder);

            JLBL_I_OnOff_Line = new JLabel();
            if (comp.isBeschikbaar()) {
                JLBL_I_OnOff_Line = new JLabel("Online"); // controle of het component offline of online is
                JLBL_I_OnOff_Line.setBorder(border_g);
            } else {
                JLBL_I_OnOff_Line = new JLabel("Offline");
                JLBL_I_OnOff_Line.setBorder(border_r);

            }
            JLBL_I_OnOff_Line.setPreferredSize(new Dimension(70, 15));
            PNL_Component.add(JLBL_I_OnOff_Line);

            Index++;
            panels.add(PNL_Component); // toevoegen aan ArrayList panels met het net aangemaakte panel en daarop de gegevens van het component
        }
    }
}
