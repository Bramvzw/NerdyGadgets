import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.text.DecimalFormat;

public class GegevensOphalen {
    public static String[] start(String host){
        String[] string = new String[2];
        String user = "root";
        String password = "ictm2m2";
        int port = 22;
        String output = "Als je dit ziet is er iets misgegaan";

        try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.setTimeout(1000);
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
                    ee.printStackTrace();
                }
            }
            channel.disconnect();
            session.disconnect();
            string[0] = output.substring(170,175);
            DecimalFormat df = new DecimalFormat("##.##");
            string[1] =df.format((Double.parseDouble(output.substring(310,317)) / 2097152));
//            System.out.println("KLAAR");
        }
        catch(Exception e){
            return new String[]{"",""};
        }

        return string;
    }
}
