import java.util.ArrayList;

public class Lijst {
    private int Index;
    private String Naam;
    private double Beschikbaarheid;
    private double Prijs;

    private ArrayList<Componenten> Componentlijst = new ArrayList<>();




    public void Voegtoe(Componenten cp) {
        Componentlijst.add(cp);
    }

    public ArrayList<Componenten> getLijst() {
        System.out.println(Componentlijst);
        return Componentlijst;
    }

    public int CountLijst() {
        return Componentlijst.size();
    }
}

