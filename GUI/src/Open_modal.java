import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Open_modal extends JDialog implements ActionListener {
    private JList groepLijst;
    private JButton JBTN_Ok, JBTN_Cancel;
    private Boolean boolOk = false;
    private int geselecteerd;
    private JLabel Placeholder;
    private JPanel panel, panel2;
    private JScrollPane SPanel;

    public Open_modal(JFrame frame, ArrayList<String> groep) {
        super(frame, true);
        ArrayList<String> groepNamen = new ArrayList<>();
        for(int i = 1; i < groep.size(); i += 2){
            groepNamen.add(groep.get(i));
        }
        setSize(400, 200);
        setLocation(900, 420);
        setLayout(new BorderLayout());

        groepLijst = new JList(groepNamen.toArray());
        groepLijst.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if(groepLijst.getSelectedIndex() == 0){
                        geselecteerd = Integer.parseInt(groep.get(0));
                    }
                    else{
                        geselecteerd = Integer.parseInt(groep.get(groepLijst.getSelectedIndex() * 2));
                    }
                }
            }
        });

        panel2 = new JPanel();
        add(panel2, BorderLayout.NORTH);

        Placeholder = new JLabel(" ");
        Placeholder.setFont(new Font("", Font.PLAIN, 20));
        panel2.add(Placeholder);

        SPanel = new JScrollPane(groepLijst);
        this.add(SPanel);

        panel = new JPanel();
        add(panel,BorderLayout.SOUTH);

        panel.setLayout(new FlowLayout());

//        panel1.add(groepLijst);


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

    public Boolean getBoolOk() {
        return boolOk;
    }

    public int getGeselecteerd() {
        return geselecteerd;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JBTN_Ok){
            boolOk = true;
        }
        setVisible(false);
    }
}
