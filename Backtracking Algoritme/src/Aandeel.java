public class Aandeel {
    private double beschikbaaheid;
    private double kosten;
    private int aantal;
    private String naam;

    public Aandeel(double beschikbaaheid, double kosten, String naam){
        this.beschikbaaheid = beschikbaaheid;
        this.kosten = kosten;
        aantal = 0;
        this.naam = naam;
    }

    public Aandeel(double beschikbaaheid, double kosten, String naam, int aantal){
        this.beschikbaaheid = beschikbaaheid;
        this.kosten = kosten;
        this.aantal = aantal;
        this.naam = naam;
    }

    public double getBeschikbaaheid() {
        return beschikbaaheid;
    }

    public double getKosten() {
        return kosten;
    }

    public int getAantal() {
        return aantal;
    }

    public String getNaam() {
        return naam;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    void plusAantal(){
        aantal ++;
    }
}
