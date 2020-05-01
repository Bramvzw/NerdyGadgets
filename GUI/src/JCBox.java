import javax.swing.*;

public class JCBox {
    private String Value;

    //    private ImageIcon Icon;

    public JCBox(String Value) {
        this.Value = Value;
//        this.Icon = Icon;
    }

    public String getValue() {
        return Value;
    }

    public String toString() {
        return  getValue();
    }
}
