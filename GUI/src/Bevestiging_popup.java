import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bevestiging_popup extends JDialog implements ActionListener {
    private JLabel label, Placeholder;
    private JButton ok, cancel;
    private JPanel panel, panel1, panel2;


    public Bevestiging_popup() {
        setSize(400, 200);
        setLocation(900,420);
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

        label = new JLabel("Alles verwijderen?");
        label.setFont(new Font("", Font.PLAIN, 16));
        panel1.add(label);

        ok = new JButton("OK");
        ok.addActionListener(this);
        ok.setFocusable(false);
        panel.add(ok);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        panel.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok) {
            this.setVisible(false);
            // Verwijder alles
        }
        if (e.getSource() == cancel) {
            this.setVisible(false);
        }
    }
}
