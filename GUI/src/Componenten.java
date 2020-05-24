public class Componenten {
    private int ID;
    private static int teller;
    private int Type_key;
    private String Type;
    private String Naam;
    private double Beschikbaarheid;
    private int Prijs;
    private double Processorbelasting;
    private double Diskruimte;

    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }

    public Componenten(String Type, String Naam, double Beschikbaarheid, int Prijs){
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }



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

    public String getNaam() {
        return Naam;
    }

    public String getType() {
        return Type;
    }

    public double getBeschikbaarheid() {
        return Beschikbaarheid;
    }

    public int getPrijs() {
        return Prijs;
    }

    public String toString() {
        return Type + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }

}


