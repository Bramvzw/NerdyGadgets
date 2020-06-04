import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Opslaan_modal extends JDialog implements ActionListener {
    private JTextField JTXTF_Naam;
    private JButton JBTN_Ok, JBTN_Cancel;
    private Boolean boolOk = false;
    private JLabel Placeholder;
    private JPanel panel, panel1, panel2;
    private ArrayList<Componenten> momenteleComponenten;


    public Opslaan_modal(JFrame frame, ArrayList<Componenten> momenteleComponenten) {
        super(frame, true);
        this.momenteleComponenten = momenteleComponenten;
        setSize(400, 200);
        setLocation(900, 420);
        setLayout(new BorderLayout());

        panel2 = new JPanel();
        add(panel2, BorderLayout.NORTH);

        Placeholder = new JLabel(" ");
        Placeholder.setFont(new Font("", Font.PLAIN, 20));
        panel2.add(Placeholder);

        panel1 = new JPanel();
        add(panel1, BorderLayout.CENTER);

        panel = new JPanel();
        add(panel,BorderLayout.SOUTH);

        panel.setLayout(new FlowLayout());

        JTXTF_Naam = new JTextField(10);
        panel1.add(JTXTF_Naam);

        JBTN_Ok = new JButton("Ok");
        JBTN_Ok.addActionListener(this);
        JBTN_Ok.setFocusable(false);
        panel.add(JBTN_Ok);

        JBTN_Cancel = new JButton("Cancel");
        JBTN_Cancel.addActionListener(this);
        JBTN_Cancel.setFocusable(false);
        panel.add(JBTN_Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // wanneer naam-veld of geen componenten in infrastructuur staan foutmedling geven
        if(e.getSource() == JBTN_Ok){
            if(JTXTF_Naam.getText().isEmpty()){
                new JOptionPane().showMessageDialog(this,"Voer een naam in");
            }
            else if(momenteleComponenten.size() <= 0){
                new JOptionPane().showMessageDialog(this,"Voer een component in");
            }
            else {
                boolOk = true;
                setVisible(false);
            }
        }
        if(e.getSource() == JBTN_Cancel){
            setVisible(false);
        }
    }

    public Boolean getBoolOk() {
        return boolOk;
    }

    public String getNaam() {
        return JTXTF_Naam.getText();
    }
}

