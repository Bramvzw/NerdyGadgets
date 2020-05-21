import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Infrastructuur_Overzicht extends JPanel {

    int servers = 5;
    int databases=5;
    int firwalls=1;






    public Infrastructuur_Overzicht(Lijst lijst) throws SQLException {

        setBackground(Color.lightGray);

    }




    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xDatabases = 100;
        int yDatabases = 100;
        int xWebserver = 200;
        int yWebserver = 100;
        int xFirewall = 650;

        ArrayList<String> firewall = new ArrayList<>();
        ArrayList<String> database = new ArrayList<>();
        ArrayList<String> webserver = new ArrayList<>();

        firewall.add("firewall");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        webserver.add("web");
        webserver.add("web");
        webserver.add("web");
        webserver.add("web");
        webserver.add("web");


        for(String data : database){

            try {
                Image image = ImageIO.read(new File("src/databases.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                g.drawImage(image, xDatabases, yDatabases, null);


                  /*drawing lines
                  *  int i= database.size();
                   while (i > 0){
                      int xs = databases + 10;
                      int ys = yDatabases + 10;
                      int xend = xWebserver;
                      int yend = yWebserver;

                       g.setColor(Color.BLACK);

                       g.drawLine(xs, ys, xend, yend);

                      i= i-1;

                   }*/

                yDatabases += 50;

                Image image2 = ImageIO.read(new File("src/web.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                g.drawImage(image2, xWebserver, yWebserver, null);
                yWebserver += 50;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //   while( databases > 0){

        //      try {
        //          Image image = ImageIO.read(new File("src/databases.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        //          g.drawImage(image, xDatabases, yDatabases, null);
        //         databases=databases-1;
        //          yDatabases =yDatabases+ 100;
        //         xDatabases =xDatabases+ 100;
        //     } catch (IOException e) {
        //         e.printStackTrace();
//
        //     }

        //   }



        //    System.out.println(mylijst.getDatabaseslijst() + "from io");

    }

    //ArrayList<String> servers = ComponentLijst









    }
