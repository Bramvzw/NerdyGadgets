import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class JCBox {
    ImageIcon imageIcon[] = {new ImageIcon("Images/Firewall-ico.png"), new ImageIcon("Images/Database-ico.png"),
            new ImageIcon("Images/Webserver-ico.png")};
    Integer array[] = {1, 2, 3, 4, 5};
    String names[] = {"img1", "img2", "img3", "img4", "img5"};

    public JCBox() {
        ComboBoxRenderar rendrar = new ComboBoxRenderar();
        JComboBox box = new JComboBox(array);
        box.setRenderer(rendrar);
    }

    public class ComboBoxRenderar extends JLabel implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list,
                                                      Object value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            int offset = ((Integer) value).intValue() - 1;

            ImageIcon icon = imageIcon[offset];
            String name = names[offset];

            setIcon(icon);
            setText(name);

            return this;
        }
    }
}
