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

    private ArrayList<Componenten> compo1 = new ArrayList<>();



    public Infrastructuur_Overzicht(ArrayList<Componenten> component , Applicatie app)  {

       compo1= app.getMomenteleComponenten();

        System.out.println(compo1.size());
        System.out.println(compo1);
        System.out.println(compo1);

 //compo1.add(new Componenten("firewall", "firewall",99.998,1000));






    }
    public void setcomponenten(ArrayList<Componenten> a){
        this.compo1= a;
        System.out.println(compo1.size());



              repaint();
    }



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        compo1.size();
      //  int xDatabases = 100;
     //   int yDatabases = 100;
      //  int xWebserver = 200;
     //   int yWebserver = 100;
      //  int xFirewall = 650;


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







       /*
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









        }*/


        ArrayList database = new ArrayList();
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data1");
        database.add("data2");
        database.add("data2");
        database.add("data2");
        database.add("data2");
        database.add("data2");
        database.add("data3");

        int xDatabase = 50;
       // int xWebserver = 250;
        //int xFirewall = 150;

        int yDatabase = 50;
        int yWebserver = 50;
        int dCount = 0;
        int wCount = 0;


        for (Object s : database) {
            try {
                Image image = ImageIO.read(new File("Images/Database.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                if (s.equals("data1")==true) {
                    if (dCount == 4) {
                        xDatabase += 100;
                        yDatabase = 50;
                        dCount = 0;
                    }
                    g.drawImage(image, xDatabase, yDatabase, null);
                    g.drawString("name2", xDatabase + 10, yDatabase + 60);
                    yDatabase += 100;
                    dCount++;


                }
                int  xWebserver = xDatabase + 100;
                Image image2 = ImageIO.read(new File("Images/Webserver.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                if (s.equals("data2")==true) {
                    if (wCount == 4) {
                        xWebserver += 100;
                        yWebserver = 50;
                        wCount = 0;

                    }


                    g.drawImage(image2, xWebserver , yWebserver, null);
                    g.drawString("name2", xWebserver + 10, yWebserver + 60);
                    yWebserver += 100;
                    wCount++;

                }  if(s.equals("data3")==true){ // firewall

                    Image image3 = ImageIO.read(new File("Images/FireWall.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    int xFirewall = xWebserver + 100;
                    g.drawImage(image3, xFirewall, 150, null);
                    g.drawString("name3", xFirewall + 10, 85);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }















    }





