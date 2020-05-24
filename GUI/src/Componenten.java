import java.util.Objects;

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

    public void setBeschikbaarheidFactor(){
        Beschikbaarheid = Beschikbaarheid / 100;
    }

    public String toString() {
        return Type + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componenten that = (Componenten) o;
        return  ID == that.ID &&
                Type_key == that.Type_key &&
                Double.compare(that.Beschikbaarheid, Beschikbaarheid) == 0 &&
                Prijs == that.Prijs &&
                Double.compare(that.Processorbelasting, Processorbelasting) == 0 &&
                Double.compare(that.Diskruimte, Diskruimte) == 0 &&
                Objects.equals(Type, that.Type) &&
                Objects.equals(Naam, that.Naam);
    }
}


