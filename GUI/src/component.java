import java.util.ArrayList;

public  class  component {

    private String type;
    private int beschikbaarheid;
    private int prijs;
    private int processorbelasting;
    private int diskruimte;
    static ArrayList<Object> componentlijst = new ArrayList<>();




    public component(String type, int beschikbaarheid, int prijs, int processorbelasting, int diskruimte)
    {
        this.type = type;
        this.beschikbaarheid = beschikbaarheid;
        this.prijs = prijs;
        this.processorbelasting = processorbelasting;
        this.diskruimte = diskruimte;
    }




    public static void adding(component comp1) {
        componentlijst.add(comp1);

    }




    public String getType() {
        return type;
    }




    public void setType(String type) {
        this.type = type;
    }




    public int getBeschikbaarheid() {
        return beschikbaarheid;
    }




    public void setBeschikbaarheid(int beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }




    public int getPrijs() {
        return prijs;
    }




    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }




    public int getProcessorbelasting() {
        return processorbelasting;
    }




    public void setProcessorbelasting(int processorbelasting) {
        this.processorbelasting = processorbelasting;
    }




    public int getDiskruimte() {
        return diskruimte;
    }




    public void setDiskruimte(int diskruimte) {
        this.diskruimte = diskruimte;
    }



    @Override
    public String toString() {
        return "component [type=" + type + ", beschikbaarheid=" + beschikbaarheid + ", prijs=" + prijs
                + ", processorbelasting=" + processorbelasting + ", diskruimte=" + diskruimte + ", componentlijst="
                + componentlijst + "]";
    }





}