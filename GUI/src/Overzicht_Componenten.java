import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Overzicht_Componenten extends JDialog implements ActionListener {

    public Overzicht_Componenten() {
        setTitle("Overzicht Componenten");
        setSize(800, 400);
        setLayout(new FlowLayout());
        setLocation(500,250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
