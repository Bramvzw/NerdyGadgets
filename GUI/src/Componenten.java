public class Componenten {
    private int Index;
    private String Naam;
    private double Beschikbaarheid;
    private double Prijs;


    public Componenten(int Index, double Beschikbaarheid, double Prijs) {
        this.Index = Index;
        if (this.Index == 1) {
            this.Naam = "Firewall";
        } else if (this.Index == 2) {
            this.Naam = "Webserver";
        } else if (this.Index == 3) {
            this.Naam = "Database server";
        }
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }

    public Componenten(int Index, String Naam, double Beschikbaarheid, double Prijs) {
        this.Index = Index;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }

    public double getPrijs() {
        return Prijs;
    }

    public String toString() {
        return Index + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }
}


