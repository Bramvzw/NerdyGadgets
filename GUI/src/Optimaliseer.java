import java.util.ArrayList;
import java.util.Scanner;

public class Optimaliseer {
//    Componenten firewall1 = new Componenten(1,"Firewall","FW1",0.99998,4000);
//    Componenten database1 = new Componenten(2,"Database","DB1",0.90, 5100,);
//    Componenten database2 = new Componenten(3,"Database","DB2",0.95, 7700);
//    Componenten database3 = new Componenten(4,"Database","DB3",0.98, 12200);
//    Componenten webserver1 = new Componenten(5,"Webserver","WS1",0.80, 2200);
//    Componenten webserver2 = new Componenten(6,"Webserver","WS2",0.90, 3200);
//    Componenten webserver3 = new Componenten(7,"Webserver","WS3",0.95, 5100);
    ArrayList<Componenten> componenten = new ArrayList<>();

    ComponentArray momenteleComponenten = new ComponentArray();
    ArrayList<Componenten> keuzeComponenten = momenteleComponenten.getComponentenArray();
    ArrayList<Componenten> besteComponenten = new ArrayList<>();

    double besteBeschikbaarheid = 0;
    double besteKosten = 0;

    public static void main(String[] args) {
        Optimaliseer optimaliseer = new Optimaliseer();
        optimaliseer.consoleInput();

    }

    public void consoleInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Gewenste beschikbaarheid:");
        try{
            this.optimaliseer(Double.parseDouble(scan.nextLine()));
        }

        catch(NumberFormatException NFE){
            System.out.println("Gebruik getallen");
        }
        this.consoleInput();
    }

    public int aantalComponenten(ArrayList<Componenten> componenten, String type){
        int i = 0;
        for(Componenten component : componenten){
            if(component.getType().equals(type)){
                i ++;
            }
        }
        return i;
    }

    public void optimaliseer(double gewensteBeschikbaarheid){
        newFW(0, gewensteBeschikbaarheid);
        System.out.print("Beste oplossing:\nComponenten:");
        for(Componenten component : besteComponenten){
//            System.out.print(" " + component.getNaam() + "(" + component.getAantal() + ")");
        }
        System.out.println("\nBeschikbaarheid: " + besteBeschikbaarheid);
        System.out.println("Kosten: " + besteKosten);
    }

    public void newFW(int i, double gewensteBeschikbaarheid){
        while(i < aantalComponenten(keuzeComponenten,"firewall")){ //Dynamisch maken
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
        while(i < aantalComponenten(keuzeComponenten,"DBserver")){ //Dynamisch maken
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
        while(i < aantalComponenten(keuzeComponenten,"webserver")) { //Dynamisch maken
            i ++;
            componenten.add(keuzeComponenten.get(i + 3));
            berekenGegevens(componenten,0, gewensteBeschikbaarheid);
            newWS(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 2)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void berekenGegevens(ArrayList<Componenten> componenten, int i, double gewensteBeschikbaarheid){
        double beschikbaarheid = 0;
        double kosten = 0;
        double laatsteBeschikbaarheid;
        Componenten laatsteComponent = null;
        ArrayList<Componenten> laatsteComponenten = new ArrayList<>();

        while(beschikbaarheid < gewensteBeschikbaarheid && kosten < 100000){
//            componenten.get(i).plusAantal();
            

            beschikbaarheid = 1;
            laatsteBeschikbaarheid = 1;
            kosten = 0;

            for (Componenten component : componenten) {
                if(laatsteComponent == null || component.getClass() != laatsteComponent.getClass()){
                    laatsteComponent = component;
                    for(Componenten component2 : componenten){
                        if(component2.getClass() == laatsteComponent.getClass()){
                            laatsteComponenten.add(component2);
                        }
                    }
                    for(Componenten component3 : laatsteComponenten){
//                        laatsteBeschikbaarheid *= (Math.pow((1 - component3.getBeschikbaaheid()), component3.getAantal()));
//                        kosten += (component3.getKosten() * component3.getAantal());
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
            for(Componenten component : componenten){
//                besteComponenten.add(new Componenten(component.getBeschikbaaheid() + 0,component.getKosten() + 0, component.getNaam() + "", component.getAantal() + 0));
            }
            besteBeschikbaarheid = beschikbaarheid;
            besteKosten = kosten;

        }
//        componenten.get(i).setAantal(0);
    }
}