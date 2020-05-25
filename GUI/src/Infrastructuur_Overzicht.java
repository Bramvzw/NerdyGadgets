import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;




public class Infrastructuur_Overzicht extends JPanel {





    private ArrayList<Componenten> database = new ArrayList<>();



    public Infrastructuur_Overzicht(ArrayList<Componenten> component , Applicatie app)  {
        setBackground(Color.lightGray);
        database= app.getMomenteleComponenten();
        System.out.println(database.size());
        System.out.println();



    }
    public void setcomponenten(ArrayList<Componenten> a){
        this.database= a;
        System.out.println(database.size());

  repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);




        int xDatabase = 50;
       int xWebserver = 250;
        int xFirewall = 150;

        int yDatabase = 50;
        int yWebserver = 50;
        int dCount = 0;
        int wCount = 0;




        for (Componenten s : database) {
            try {
                Image image = ImageIO.read(new File("Images/Database.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                if (s.getType().equals("DBserver")) { // draw database
                    if (dCount == 4) {
                        xDatabase += 50;
                        yDatabase = 200;

                    }
                    g.drawImage(image, xDatabase, yDatabase, null);
                    g.drawString(s.getNaam(), xDatabase + 5, yDatabase + 60);
                    yDatabase += 100;
                    dCount++;


                } else if (s.getType().equals("webserver")) {
                    if (wCount == 4) {
                        xWebserver += 100;
                        yWebserver = 200;

                    }
                    Image image2 = ImageIO.read(new File("Images/Webserver.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    g.drawImage(image2, xWebserver, yWebserver, null);
                    g.drawString(s.getNaam(), xWebserver + 5, yWebserver +60);
                    yWebserver += 100;
                    wCount++;

                } else {
                    Image image3 = ImageIO.read(new File("Images/FireWall.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    g.drawImage(image3, xFirewall, 80, null);
                    g.drawString(s.getNaam(), xFirewall + 30, 170);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


    }





