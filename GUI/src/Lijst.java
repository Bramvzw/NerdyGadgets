import java.util.ArrayList;

public class Lijst {

    private ArrayList<EenComponent> lijst = new ArrayList<>();

    public void Voegtoe(EenComponent cp) {
        lijst.add(cp);
    }

    public ArrayList<EenComponent> getLijst() {
        return lijst;
    }

    public int CountLijst() {
        return lijst.size();
    }
}

