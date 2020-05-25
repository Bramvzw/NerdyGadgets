public class Componenten {
    private int ID;
    private static int teller = 1;
    private int Type_key;
    private String Type;
    private String Naam;
    private double Beschikbaarheid;
    private int Prijs;
    private double Processorbelasting;
    private double Diskruimte;
    private String host;

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
        ID = teller;
        teller ++;
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

}


