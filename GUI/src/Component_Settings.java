import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Component_Settings extends JDialog implements ActionListener {


    public Component_Settings(JFrame jf) {
        super(jf, true);
        setTitle("Standaard Componenten - Settings");
        setSize(400, 280);
        setLayout(new FlowLayout());
        setLocation(500,250);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
