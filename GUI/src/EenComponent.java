public class EenComponent {
    private int Index;
    private String Naam;
    private double Beschikbaarheid;
    private double Prijs;


    public EenComponent(int Index, String Naam, double Beschikbaarheid, double Prijs) {
        this.Index = Index;
        this.Naam = Naam;
        this.Beschikbaarheid = Beschikbaarheid;
        this.Prijs = Prijs;
    }

    public String toString() {
        return Index + " " + Naam + " " + Beschikbaarheid + " " + Prijs;
    }
}


