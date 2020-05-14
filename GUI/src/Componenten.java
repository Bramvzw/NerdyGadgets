public class Componenten {
    private int ID;
    private int Type_key;
    private String Type;
    private String Naam;
    private double Beschikbaarheid;
    private int Prijs;
    private double Processorbelasting;
    private double Diskruimte;

    public Componenten(int ID, int Type_key, String Type, String Naam, double Beschikbaarheid, int Prijs, double Proccesorbelasting, double Diskruimte) {
        this.ID = ID;
        this.Type_key = Type_key;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.Processorbelasting = Proccesorbelasting;
        this.Diskruimte = Diskruimte;
    }

    public void NewComponent(int ID, int Type_key, String Type, String Naam, double Beschikbaarheid, int Prijs, double Proccesorbelasting, double Diskruimte) {



        this.ID = ID;
        this.Type_key = Type_key;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.Processorbelasting = Proccesorbelasting;
        this.Diskruimte = Diskruimte;


    }




    public String toString() {
        return Type + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }
}


