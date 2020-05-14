import java.util.ArrayList;

public class Lijst {
    private int ID;
    private int Type_key;
    private String Type;
    private String Naam;
    private double Beschikbaarheid;
    private int Prijs;
    private Double Processorbelasting;
    private Double Diskruimte;


    private ArrayList<String> Componentlijst = new ArrayList<>();




    public void Voegtoe(String cp) {
        Componentlijst.add(cp);
    }

    public ArrayList<String> getLijst() {
        System.out.println(Componentlijst);
        return Componentlijst;
    }

    public int CountLijst() {
        return Componentlijst.size();
    }
}

