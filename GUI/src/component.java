import java.util.ArrayList;

public  class  component {

    private String type;
    private float beschikbaarheid;
    private float prijs;
    private float processorbelasting;
    private float diskruimte;

    ArrayList<Object> componentlijst = new ArrayList<>();




    public component(String type, int beschikbaarheid, int prijs, int processorbelasting, int diskruimte)
    {
        this.type = type;
        this.beschikbaarheid = beschikbaarheid;
        this.prijs = prijs;
        this.processorbelasting = processorbelasting;
        this.diskruimte = diskruimte;
    }
    public component(String type, int beschikbaarheid, int prijs, int processorbelasting )
    {
        this.type = type;
        this.beschikbaarheid = beschikbaarheid;
        this.prijs = prijs;
        this.processorbelasting = processorbelasting;
    }
    public component(String type, int beschikbaarheid, int prijs   )
    {
        this.type = type;
        this.beschikbaarheid = beschikbaarheid;
        this.prijs = prijs;
    }


    public   void printarray() {

    }



    public String getType() {
        return type;
    }




    public void setType(String type) {
        this.type = type;
    }




    public float getBeschikbaarheid() {
        return beschikbaarheid;
    }




    public void setBeschikbaarheid(float beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }




    public float getPrijs() {
        return prijs;
    }




    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }




    public float getProcessorbelasting() {
        return processorbelasting;
    }




    public void setProcessorbelasting(float processorbelasting) {
        this.processorbelasting = processorbelasting;
    }




    public float getDiskruimte() {
        return diskruimte;
    }




    public void setDiskruimte(float diskruimte) {
        this.diskruimte = diskruimte;
    }



    @Override
    public String toString() {
        return "component [type=" + type + ", beschikbaarheid=" + beschikbaarheid + ", prijs=" + prijs
                + ", processorbelasting=" + processorbelasting + ", diskruimte=" + diskruimte + "]";
    }





}
