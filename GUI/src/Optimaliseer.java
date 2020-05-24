import java.util.*;

public class Optimaliseer {
    ArrayList<Componenten> componenten = new ArrayList<>();
    ArrayList<Componenten> keuzeComponenten;
    ArrayList<Componenten> besteComponenten = new ArrayList<>();

    double besteBeschikbaarheid = 0;
    double besteKosten = 0;


    public ArrayList optimaliseer(double gewensteBeschikbaarheid, ArrayList<Componenten> keuzeComponenten){
        this.keuzeComponenten = keuzeComponenten;
        for(Componenten component : keuzeComponenten){
            component.setBeschikbaarheidFactor();
        }

        newFW(0, gewensteBeschikbaarheid);

        besteComponenten = sorteer(besteComponenten);
        return besteComponenten;
    }

    public void newFW(int i, double gewensteBeschikbaarheid){
        while(i < aantalComponentenType(keuzeComponenten,"firewall")){
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
        while(i < aantalComponentenType(keuzeComponenten,"DBserver")){
            i ++;
            componenten.add(keuzeComponenten.get(i - 1+ aantalComponentenType(keuzeComponenten,"firewall")));
            newWS(0, gewensteBeschikbaarheid);
            newDB(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 1)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void newWS(int i, double gewensteBeschikbaarheid){
        while(i < aantalComponentenType(keuzeComponenten,"webserver")) {
            i ++;
            componenten.add(keuzeComponenten.get(i - 1 + aantalComponentenType(keuzeComponenten,"firewall") + aantalComponentenType(keuzeComponenten,"DBserver")));
            berekenGegevens(componenten,0, gewensteBeschikbaarheid, componenten.size(),componenten.get(componenten.size() - 1).getNaam());
            newWS(i, gewensteBeschikbaarheid);
        }
        if(!(componenten.size() == 2)) {
            componenten.remove(componenten.size() - 1);
        }
    }

    public void berekenGegevens(ArrayList<Componenten> componenten, int i, double gewensteBeschikbaarheid, int grootte, String componentNaam){
        double beschikbaarheid = 0;
        double kosten = 0;
        double laatsteBeschikbaarheid;
        boolean overgeslagen = false;
        String[] componentTypes = {"firewall", "DBserver","webserver"};

        while(beschikbaarheid < gewensteBeschikbaarheid && kosten < 100000){
            if((aantalComponentenNaam(componenten, componenten.get(i).getNaam()) == 1) && !overgeslagen){
                overgeslagen = true;
            }
            else {
                componenten.add(componenten.get(i));
            }

            beschikbaarheid = 1;
            laatsteBeschikbaarheid = 1;
            kosten = 0;

            for(String type : componentTypes){
                for(Componenten component : componenten){
                    if(component.getType().equals(type)){
                        laatsteBeschikbaarheid *= (1 - component.getBeschikbaarheid());
                        kosten += component.getPrijs();
                    }
                }
                beschikbaarheid *= (1 - laatsteBeschikbaarheid);
                laatsteBeschikbaarheid = 1;
            }

            if(!(componenten.get(i).getNaam().equals(componentNaam))) {
                berekenGegevens(componenten, i + 1, gewensteBeschikbaarheid, componenten.size(), componentNaam);
            }
        }

        if(beschikbaarheid > gewensteBeschikbaarheid && (kosten < besteKosten || besteKosten == 0)){
            besteComponenten.clear();
            for(Componenten component : componenten){
                besteComponenten.add(new Componenten(component.getType() + "",component.getNaam() + "", component.getBeschikbaarheid() + 0, component.getPrijs() + 0));
            }
            besteBeschikbaarheid = beschikbaarheid;
            besteKosten = kosten;

        }
        while(componenten.size() > grootte){
            componenten.remove(componenten.size() - 1);
        }
    }

    public int aantalComponentenType(ArrayList<Componenten> componenten, String type){
        int i = 0;
        for(Componenten component : componenten){
            if(component.getType().equals(type)){
                i ++;
            }
        }
        return i;
    }

    public int aantalComponentenNaam(ArrayList<Componenten> componenten, String naam){
        int i = 0;
        for(Componenten component : componenten){
            if(component.getNaam().equals(naam)){
                i ++;
            }
        }
        return i;
    }


    public ArrayList<Componenten> sorteer(ArrayList<Componenten> componenten){
        ArrayList<Componenten> gesorteerd = new ArrayList<>();
        for(Componenten component : componenten){
            if(component.getType().equals("firewall")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("DBserver") && component.getNaam().equals("HAL9001DB")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("DBserver") && component.getNaam().equals("HAL9002DB")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("DBserver") && component.getNaam().equals("HAL9003DB")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("webserver") && component.getNaam().equals("HAL9001W")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("webserver") && component.getNaam().equals("HAL9002W")){
                gesorteerd.add(component);
            }
        }

        for(Componenten component : componenten){
            if(component.getType().equals("webserver") && component.getNaam().equals("HAL9003W")){
                gesorteerd.add(component);
            }
        }

        return gesorteerd;
    }
}