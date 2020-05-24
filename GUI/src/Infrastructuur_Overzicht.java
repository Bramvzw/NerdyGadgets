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



        setPreferredSize(new Dimension(1300, 800));
        setBackground(Color.lightGray);






    }




    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xDatabases = 100;
        int yDatabases = 100;
        int xWebserver = 200;
        int yWebserver = 100;
        int xFirewall = 650;


    //    ComponentLijst compo1 = null;
   //    try {
    //        compo1 = new ComponentLijst();
     //   } catch (SQLException throwables) {
      //      throwables.printStackTrace();
     //   }
    //    ArrayList database = compo1.getDatabaseslijst();
    //   ArrayList webserver = compo1.getServerslijst();
     //  ArrayList firewall = compo1.getFirewalllijst();
//


        ArrayList database = new ArrayList();
         database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        ArrayList webservers = new ArrayList();

        webservers.add("data2");
        webservers.add("data2");
        webservers.add("data2");
        webservers.add("data2");




        int databasecount = 0;


        for(Object data : database){

            try {
                Image image = ImageIO.read(new File("src/databases.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                g.drawImage(image, xDatabases, yDatabases, null);

                int s = database.size();

                     int i = database.size();

                yDatabases += 50;
                databasecount++;
                if(databasecount == 5){
                    xDatabases += 50 ;
                    yDatabases = 100;
                    databasecount=0;

                }

                  //   while (i >= 0) {

                   //      int xs = xDatabases +25 ;
                   //      int ys = yDatabases + 25;
                   //      int xend = xWebserver -25;
                   //      int yend = yWebserver -25;

                    //      g.setColor(Color.BLACK);
                     //     int web= webserver.size();
                      //    while (web >= 0){
                     //     g.drawLine(xend, yend,xs, ys);
                      //        xend=xend+50;
                      //        yend=yend+50;
                      //    web --;
                      //    }

                      //    i = i - 1;





                    //  }
                     // s=-1;




           //    Image image2 = ImageIO.read(new File("src/web.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
           //     g.drawImage(image2, xWebserver, yWebserver, null);
            //    yWebserver += 50;



            } catch (IOException e) {
           e.printStackTrace();
            }




            for(Object data2 : database){

                try {
                    Image image2 = ImageIO.read(new File("src/web.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);


                    g.drawImage(image2, xDatabases, yDatabases, null);


                    yDatabases += 50;
                    databasecount++;
                    if(databasecount == 5){
                        xDatabases += 50 ;
                        yDatabases = 100;
                        databasecount=0;

                    }

                } catch (IOException e) {
                    e.printStackTrace();


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









    }}}
