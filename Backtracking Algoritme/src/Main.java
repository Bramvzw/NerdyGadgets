import java.util.ArrayList;

public class Main {
    FW firewall1 = new FW(0.99998,4000,"FW1");
    DB database1 = new DB(0.90, 5100, "DB1");
    DB database2 = new DB(0.95, 7700, "DB2");
    DB database3 = new DB(0.98, 12200, "DB3");
    WS webserver1 = new WS(0.80, 2200, "WS1");
    WS webserver2 = new WS(0.90, 3200, "WS2");
    WS webserver3 = new WS(0.95, 5100, "WS3");
    ArrayList<Aandeel> aandelen = new ArrayList<>();

    ArrayList<Aandeel> keuzeAandelen = new ArrayList<>() {{
        add(firewall1);
        add(database1);
        add(database2);
        add(database3);
        add(webserver1);
        add(webserver2);
        add(webserver3);
    }};

    ArrayList<Aandeel> besteAandelen = new ArrayList<>();

    double besteBeschikbaarheid = 0;
    double besteKosten = 50000;

    public static void main(String[] args) {
        Main main = new Main();
        main.zoekBesteOplossing();
    }


    public void zoekBesteOplossing(){
        newFW(0);
        System.out.print("Beste oplossing:\nAandelen:");
        for(Aandeel aandeel : besteAandelen){
            System.out.print(" " + aandeel.getNaam() + "(" + aandeel.getAantal() + ")");
        }
        System.out.println("\nBeschikbaarheid: " + besteBeschikbaarheid);
        System.out.println("Kosten: " + besteKosten);
    }

    public void newFW(int i){
        while(i < 1){
            i ++;
            aandelen.add(keuzeAandelen.get(i - 1));
            newDB(0);
            newFW(i);
        }
        if(!(aandelen.size() == 0)) {
            aandelen.remove(aandelen.size() - 1);
        }
    }

    public void newDB(int i){
        while(i < 3){
            i ++;
            aandelen.add(keuzeAandelen.get(i));
            newWS(0);
            newDB(i);
        }
        if(!(aandelen.size() == 1)) {
            aandelen.remove(aandelen.size() - 1);
        }
    }

    public void newWS(int i){
        while(i < 3) {
            i ++;
            aandelen.add(keuzeAandelen.get(i + 3));
            berekenGegevens(aandelen,0);
            newWS(i);
        }
        if(!(aandelen.size() == 2)) {
            aandelen.remove(aandelen.size() - 1);
        }

    }

    public void berekenGegevens(ArrayList<Aandeel> aandelen,int i){
        double beschikbaarheid = 0;
        double kosten = 0;
        double laatsteBeschikbaarheid;
        Aandeel laatsteAandeel = null;
        ArrayList<Aandeel> laatsteAandelen = new ArrayList<>();

        while(beschikbaarheid < 0.9999 && kosten < 50000){
            aandelen.get(i).plusAantal();

            beschikbaarheid = 1;
            laatsteBeschikbaarheid = 1;
            kosten = 0;

            for (Aandeel aandeel : aandelen) {
                if(laatsteAandeel == null || aandeel.getClass() != laatsteAandeel.getClass()){
                    laatsteAandeel = aandeel;
                    for(Aandeel aandeel2 : aandelen){
                        if(aandeel2.getClass() == laatsteAandeel.getClass()){
                            laatsteAandelen.add(aandeel2);
                        }
                    }
                    for(Aandeel aandeel3 : laatsteAandelen){
                        laatsteBeschikbaarheid *= (Math.pow((1 - aandeel3.getBeschikbaaheid()), aandeel3.getAantal()));
                        kosten += (aandeel3.getKosten() * aandeel3.getAantal());
                    }
                    beschikbaarheid *= (1 - laatsteBeschikbaarheid);
                    laatsteBeschikbaarheid = 1;
                    laatsteAandelen.clear();
                }
            }

            if(i < (aandelen.size()) - 1) {
                berekenGegevens(aandelen, i + 1);
            }
        }

        if(beschikbaarheid > 0.9999 && kosten < besteKosten){
            besteAandelen.clear();
            for(Aandeel aandeel : aandelen){
                besteAandelen.add(new Aandeel(aandeel.getBeschikbaaheid() + 0,aandeel.getKosten() + 0, aandeel.getNaam() + "", aandeel.getAantal() + 0));
            }
            besteBeschikbaarheid = beschikbaarheid;
            besteKosten = kosten;

        }
        aandelen.get(i).setAantal(0);
    }
}