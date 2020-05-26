import java.util.Objects;

public class Componenten {
    private int ID;
    private static int teller = 1;
    private String Type;
    private String Naam;
    private double Beschikbaarheid;
    private int Prijs;
    private double Processorbelasting;
    private double Diskruimte;
    private String host = "";

    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs, double Processorbelasting, double Diskruimte, String host){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.Processorbelasting = Processorbelasting;
        this.Diskruimte = Diskruimte;
        this.host = host;
    }

    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs, String host){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.host = host;
    }

    public Componenten(String Type, String Naam, double Beschikbaarheid, int Prijs){
        ID=teller;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        teller++;
    }

    public Componenten(Componenten component){
        ID = component.getID() + 0;
        Type = component.getType() + "";
        Naam = component.getNaam() + "";
        Beschikbaarheid = component.getBeschikbaarheid() + 0;
        Prijs = component.getPrijs() + 0;
        Processorbelasting = component.getProcessorbelasting() + 0;
        Diskruimte = component.Diskruimte + 0;
        host = component.getHost() + "";
    }

    public int getID() {
        return ID;
    }

    public double getProcessorbelasting() {
        return Processorbelasting;
    }

    public double getDiskruimte() {
        return Diskruimte;
    }

    public String getHost() {
        return host;
    }

    public Componenten(int ID, int Type_key, String Type, String Naam, double Beschikbaarheid, int Prijs, double Proccesorbelasting, double Diskruimte) {
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.Processorbelasting = Proccesorbelasting;
        this.Diskruimte = Diskruimte;
    }

    public void NewComponent(int ID, int Type_key, String Type, String Naam, double Beschikbaarheid, int Prijs, double Proccesorbelasting, double Diskruimte) {
        this.ID = ID;
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

    public void updateGegevens(){
        if(host != null) {
            String[] gegevens = new String[2];
            String[] cpudisk;

                cpudisk = GegevensOphalen.start(host);
                if(!cpudisk[0].equals("") && !cpudisk[1].equals("")) {
                    Diskruimte = Double.parseDouble(cpudisk[1].replace(",", "."));
                    Processorbelasting = 100 - Double.parseDouble(cpudisk[0]);
                }
            }
        }

    public String toString() {
        return Type + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componenten that = (Componenten) o;
        return ID == that.ID &&
                Double.compare(that.Beschikbaarheid, Beschikbaarheid) == 0 &&
                Prijs == that.Prijs &&
                Double.compare(that.Processorbelasting, Processorbelasting) == 0 &&
                Double.compare(that.Diskruimte, Diskruimte) == 0 &&
                Objects.equals(Type, that.Type) &&
                Objects.equals(Naam, that.Naam) &&
                Objects.equals(host, that.host);
    }
    public boolean equalsZonderActueleGegevens(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componenten that = (Componenten) o;
        return  Double.compare(that.Beschikbaarheid, Beschikbaarheid) == 0 &&
                Prijs == that.Prijs &&
                Objects.equals(Type, that.Type) &&
                Objects.equals(Naam, that.Naam);
    }
}




