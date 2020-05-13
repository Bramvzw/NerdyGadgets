import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class GegevensOphalen {
    String user = "root";
    String password = "ictm2m2";
    String host = "192.168.1.102";
    int port = 22;
    String output = "Als je dit ziet is er iets misgegaan";

    public GegevensOphalen(){
        start(user, password, host, port);
    }

    public GegevensOphalen(String user, String password, String host, int port) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;

        start(user, password, host, port);
    }

    public static String start(String user, String password, String host, int port){
        String output = "Als je dit ziet is er iets misgegaan";

        try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
//            System.out.println("Connectie succesvol gemaakt");

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand("iostat -c; df /dev/mapper/ubuntu--vg-ubuntu--lv");
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0){
                        break;
                    }
                    output = new String(tmp, 0, i);
                }
                if(channel.isClosed()){
//                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{
                    Thread.sleep(1000);
                }
                catch(Exception ee){
                }
            }
            channel.disconnect();
            session.disconnect();
//            System.out.println(output);
//            System.out.println("KLAAR");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //output.replace("Linux 4.15") //TODO: -alle console outputs vergelijken -onnodige output weghalen -datbase online krijgen -vanuit database elk component langsgaan -voor elk component de output ophalen en in applicatie zetten

        return output;
    }
}
