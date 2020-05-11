public class StandaardComponent {
    private int Index;
    private String Naam;
    private double Beschikbaarheid;
    private double Prijs;


    public StandaardComponent(int Index, double Beschikbaarheid, double Prijs) {
        this.Index = Index;
        if(Index == 1) {
            this.Naam = "Firewall";
        } else if (Index == 2) {
            this.Naam = "Database Server";
        } else if (Index == 3) {
            this.Naam = "Webserver";
        }
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }

    public String toString() {
        return Index + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }
}
