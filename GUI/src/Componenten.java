import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

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
    private boolean beschikbaar = false;

    //Component constructor voor toevoegen van component uit database
    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs, double Processorbelasting, double Diskruimte, String host, Boolean beschikbaar){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.Processorbelasting = Processorbelasting;
        this.Diskruimte = Diskruimte;
        this.host = host;
        this.beschikbaar = beschikbaar;
    }

    //Component constructor voor ophalen van component uit database met IP zonder actuele gegegevens maar wel met werkende connectie
    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs, String host, Boolean beschikbaar){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.host = host;
        this.beschikbaar = beschikbaar;
    }

    //Component constructor voor opslaan van component met IP
    public Componenten(int ID, String Type, String Naam, double Beschikbaarheid, int Prijs, String host){
        this.ID = ID;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.host = host;
    }

    //Component constructor voor opslaan van component zonder actuele gegevens en IP
    public Componenten(String Type, String Naam, double Beschikbaarheid, int Prijs, String host, boolean beschikbaar, Double processorbelasting, Double diskruimte){
        ID=teller;
        this.Type = Type;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
        this.host = host;
        this.beschikbaar = beschikbaar;
        this.Processorbelasting = processorbelasting;
        this.Diskruimte = diskruimte;
        teller++;
    }

    //Component constructor voor op
    public Componenten(Componenten component){
        ID = component.getID() + 0;
        Type = component.getType() + "";
        Naam = component.getNaam() + "";
        Beschikbaarheid = component.getBeschikbaarheid() + 0;
        Prijs = component.getPrijs() + 0;
        Processorbelasting = component.getProcessorbelasting() + 0;
        Diskruimte = component.Diskruimte + 0;
        host = component.getHost() + "";
        beschikbaar = component.isBeschikbaar();

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

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public void testConnectie(){
        if(host!= null && !host.isEmpty()){
            beschikbaar = GegevensOphalen.testConnectie(host);
        }
        else{
            beschikbaar = false;
        }
   }

    public void updateGegevens(){
        if(host != null) {
            String[] cpudisk;

            cpudisk = GegevensOphalen.start(host);
            if(!cpudisk[0].equals("") && !cpudisk[1].equals("")) {
                Diskruimte = Double.parseDouble(cpudisk[1].replace(",", "."));
                Processorbelasting = (100 - Double.parseDouble(cpudisk[0]));
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




