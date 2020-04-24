package OptimalisatieFunctie;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    FW firewall1 = new FW(0.99998,4000,"FW1");
    DB database1 = new DB(0.90, 5100, "DB1");
    DB database2 = new DB(0.95, 7700, "DB2");
    DB database3 = new DB(0.98, 12200, "DB3");
    WS webserver1 = new WS(0.80, 2200, "WS1");
    WS webserver2 = new WS(0.90, 3200, "WS2");
    WS webserver3 = new WS(0.95, 5100, "WS3");
    ArrayList<Component> componenten = new ArrayList<>();

    ArrayList<Component> keuzeComponenten = new ArrayList<>() {{
        add(firewall1);
        add(database1);
        add(database2);
        add(database3);
        add(webserver1);
        add(webserver2);
        add(webserver3);
    }};

    ArrayList<Component> besteComponenten = new ArrayList<>();

    double besteBeschikbaarheid = 0;
    double besteKosten = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.consoleInput();

    }

    public void consoleInput(){
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        System.out.println("Gewenste beschikbaarheid:");
        try{
            main.optimaliseer(Double.parseDouble(scan.nextLine()));
        }

        catch(NumberFormatException NFE){
            System.out.println("Gebruik getallen");
        }
        main.consoleInput();
    }

    public void optimaliseer(){
        newFW(0);
        System.out.print("Beste oplossing:\nComponenten:");
        for(Component component : besteComponenten){
            System.out.print(" " + component.getNaam() + "(" + component.getAantal() + ")");
        }
        System.out.println("\nBeschikbaarheid: " + besteBeschikbaarheid);
        System.out.println("Kosten: " + besteKosten);
    }

    public void newFW(int i){
        while(i < 1){
            i ++;
            componenten.add(keuzeComponenten.get(i - 1));
            newDB(0);
            newFW(i);
        }
        if(!(componenten.size() == 0)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void newDB(int i){
        while(i < 3){
            i ++;
            componenten.add(keuzeComponenten.get(i));
            newWS(0);
            newDB(i);
        }
        if(!(componenten.size() == 1)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void newWS(int i){
        while(i < 3) {
            i ++;
            componenten.add(keuzeComponenten.get(i + 3));
            berekenGegevens(componenten,0);
            newWS(i);
        }
        if(!(componenten.size() == 2)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void berekenGegevens(ArrayList<Component> componenten, int i){
        double beschikbaarheid = 0;
        double kosten = 0;
        double laatsteBeschikbaarheid;
        Component laatsteComponent = null;
        ArrayList<Component> laatsteComponenten = new ArrayList<>();

        while(beschikbaarheid < 0.9999 && kosten < 50000){
            componenten.get(i).plusAantal();

            beschikbaarheid = 1;
            laatsteBeschikbaarheid = 1;
            kosten = 0;

            for (Component component : componenten) {
                if(laatsteComponent == null || component.getClass() != laatsteComponent.getClass()){
                    laatsteComponent = component;
                    for(Component component2 : componenten){
                        if(component2.getClass() == laatsteComponent.getClass()){
                            laatsteComponenten.add(component2);
                        }
                    }
                    for(Component component3 : laatsteComponenten){
                        laatsteBeschikbaarheid *= (Math.pow((1 - component3.getBeschikbaaheid()), component3.getAantal()));
                        kosten += (component3.getKosten() * component3.getAantal());
                    }
                    beschikbaarheid *= (1 - laatsteBeschikbaarheid);
                    laatsteBeschikbaarheid = 1;
                    laatsteComponenten.clear();
                }
            }

            if(i < (componenten.size()) - 1) {
                berekenGegevens(componenten, i + 1);
            }
        }

        if(beschikbaarheid > 0.9999 && kosten < besteKosten){
            besteComponenten.clear();
            for(Component component : componenten){
                besteComponenten.add(new Component(component.getBeschikbaaheid() + 0,component.getKosten() + 0, component.getNaam() + "", component.getAantal() + 0));
            }
            besteBeschikbaarheid = beschikbaarheid;
            besteKosten = kosten;

        }
        componenten.get(i).setAantal(0);
    }

    public void optimaliseer(double gewensteBeschikbaarheid){
        newFW(0, gewensteBeschikbaarheid);
        System.out.print("Beste oplossing:\nComponenten:");
        for(Component component : besteComponenten){
            System.out.print(" " + component.getNaam() + "(" + component.getAantal() + ")");
        }
        System.out.println("\nBeschikbaarheid: " + besteBeschikbaarheid);
        System.out.println("Kosten: " + besteKosten);
    }

    public void newFW(int i, double gewensteBeschikbaarheid){
        while(i < 1){
            i ++;
            componenten.add(keuzeComponenten.get(i - 1));
            newDB(0, gewensteBeschikbaarheid);
            newFW(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 0)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void newDB(int i, double gewensteBeschikbaarheid){
        while(i < 3){
            i ++;
            componenten.add(keuzeComponenten.get(i));
            newWS(0, gewensteBeschikbaarheid);
            newDB(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 1)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void newWS(int i, double gewensteBeschikbaarheid){
        while(i < 3) {
            i ++;
            componenten.add(keuzeComponenten.get(i + 3));
            berekenGegevens(componenten,0, gewensteBeschikbaarheid);
            newWS(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 2)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void berekenGegevens(ArrayList<Component> componenten, int i, double gewensteBeschikbaarheid){
        double beschikbaarheid = 0;
        double kosten = 0;
        double laatsteBeschikbaarheid;
        Component laatsteComponent = null;
        ArrayList<Component> laatsteComponenten = new ArrayList<>();

        while(beschikbaarheid < gewensteBeschikbaarheid && kosten < 100000){
            componenten.get(i).plusAantal();

            beschikbaarheid = 1;
            laatsteBeschikbaarheid = 1;
            kosten = 0;

            for (Component component : componenten) {
                if(laatsteComponent == null || component.getClass() != laatsteComponent.getClass()){
                    laatsteComponent = component;
                    for(Component component2 : componenten){
                        if(component2.getClass() == laatsteComponent.getClass()){
                            laatsteComponenten.add(component2);
                        }
                    }
                    for(Component component3 : laatsteComponenten){
                        laatsteBeschikbaarheid *= (Math.pow((1 - component3.getBeschikbaaheid()), component3.getAantal()));
                        kosten += (component3.getKosten() * component3.getAantal());
                    }
                    beschikbaarheid *= (1 - laatsteBeschikbaarheid);
                    laatsteBeschikbaarheid = 1;
                    laatsteComponenten.clear();
                }
            }

            if(i < (componenten.size()) - 1) {
                berekenGegevens(componenten, i + 1, gewensteBeschikbaarheid);
            }
        }

        if(beschikbaarheid > gewensteBeschikbaarheid && (kosten < besteKosten || besteKosten == 0)){
            besteComponenten.clear();
            for(Component component : componenten){
                besteComponenten.add(new Component(component.getBeschikbaaheid() + 0,component.getKosten() + 0, component.getNaam() + "", component.getAantal() + 0));
            }
            besteBeschikbaarheid = beschikbaarheid;
            besteKosten = kosten;

        }
        componenten.get(i).setAantal(0);
    }
}