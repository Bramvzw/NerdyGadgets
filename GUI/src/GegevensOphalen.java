import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

public class GegevensOphalen { // ophalen van de actuele gegevens
    public static String[] start(String host) {
        String[] string = new String[2];
        int[] substring = new int[]{170, 175, 310, 317};
        String user, password;
        if (host.equals("192.168.1.11") || host.equals("192.168.1.12")) {
            user = "student";
            password = "Welkom01!";
        } else {
            user = "root";
            password = "ictm2m2";
        }
        int port = 22;
        String output = "";

        try { // Connectie maken met een VM
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.setTimeout(1000);
            session.connect();

            // Commando uitvoeren en resultaten ophalen van VM
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("iostat -c; df /dev/mapper/ubuntu--vg-ubuntu--lv");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            // Resulaten opslaan
            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    output = new String(tmp, 0, i);
                }
                if (channel.isClosed()) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
            // Connectie afsluiten
            channel.disconnect();
            session.disconnect();
            if (host.equals("192.168.1.104")) {
                for (int i = 0; i < substring.length; i++) {
                    substring[i] += 5;
                }
            }
            if (host.equals("192.168.1.106")) {
                for (int i = 0; i < substring.length; i++) {
                    substring[i] += 7;
                }
            }
            if (host.equals("192.168.1.11") || host.equals("192.168.1.12")) {
                for (int i = 0; i < substring.length; i++) {
                    substring[i] += 3;
                }
            }

            string[0] = output.substring(substring[0], substring[1]);
            DecimalFormat df = new DecimalFormat("##.##");
            string[1] = df.format((Double.parseDouble(output.substring(substring[2], substring[3])) / 2097152));
        } catch (Exception e) {
            return new String[]{"", ""};
        }
        return string;
    }

    // Controle op werking connectie
    public static boolean testConnectie(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            if (address.isReachable(5000)) {
                return true;
            } else {
                return false;
            }
        } catch (UnknownHostException uhe) {
            return false;
        } catch (IOException ioe) {
            return false;
        }
    }
}
