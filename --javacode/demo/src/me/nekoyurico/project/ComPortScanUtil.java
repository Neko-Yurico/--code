package me.nekoyurico.project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/6/14 11:13
 * ========================
 * ,---.   .--.    .-''-.  .--.   .--.      ,-----.                      ____     __   ___    _ .-------.   .-./`)     _______      ,-----.
 * |    \  |  |  .'_ _   \ |  | _/  /     .'  .-,  '.                    \   \   /  /.'   |  | ||  _ _   \  \ .-.')   /   __  \   .'  .-,  '.
 * |  ,  \ |  | / ( ` )   '| (`' ) /     / ,-.|  \ _ \                    \  _. /  ' |   .'  | || ( ' )  |  / `-' \  | ,_/  \__) / ,-.|  \ _ \
 * |  |\_ \|  |. (_ o _)  ||(_ ()_)     ;  \  '_ /  | :                    _( )_ .'  .'  '_  | ||(_ o _) /   `-'`"`,-./  )      ;  \  '_ /  | :
 * |  _( )_\  ||  (_,_)___|| (_,_)   __ |  _`,/ \ _/  |                ___(_ o _)'   '   ( \.-.|| (_,_).' __ .---. \  '_ '`)    |  _`,/ \ _/  |
 * | (_ o _)  |'  \   .---.|  |\ \  |  |: (  '\_/ \   ;  _ _     _ _  |   |(_,_)'    ' (`. _` /||  |\ \  |  ||   |  > (_)  )  __: (  '\_/ \   ;
 * |  (_,_)\  | \  `-'    /|  | \ `'   / \ `"/  \  ) /--( ' )---(_I_)-|   `-'  /     | (_ (_) _)|  | \ `'   /|   | (  .  .-'_/  )\ `"/  \  ) /
 * |  |    |  |  \       / |  |  \    /   '. \_/``".'  (_{;}_) (_(=)_) \      /       \ /  . \ /|  |  \    / |   |  `-'`-'     /  '. \_/``".'
 * '--'    '--'   `'-..-'  `--'   `'-'      '-----'   --(_,_)---(_I_)-  `-..-'         ``-'`-'' ''-'   `'-'  '---'    `._____.'     '-----'
 *    d8888b.  .d88b.  db   d8b   db
 *  * 88  `8D .8P  Y8. 88   I8I   88
 *  * 88oooY' 88    88 88   I8I   88
 *  * 88~~~b. 88    88 Y8   I8I   88
 *  * 88   8D `8b  d8' `8b d8'8b d8'
 *  * Y8888P'  `Y88P'   `8b8' `8d8'
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class ComPortScanUtil {
    public static String[] getComPorts() {
        List<String> ports = new ArrayList<>();
        try {
            String command = "reg query HKEY_LOCAL_MACHINE\\HARDWARE\\DEVICEMAP\\SERIALCOMM";
            Process process = Runtime.getRuntime().exec(command);
            InputStream in = process.getInputStream();
            BufferedReader br = new BufferedReader( new InputStreamReader ( in));
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (line == null || "".equals(line)) {
                    continue;
                }
                if (index != 0) {
                    String[] strs = line.replaceAll(" +", ",").split(",");
                    String comPort = strs[strs.length - 1];
                    ports.add(comPort);
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] portlist = ports.toArray ( new String[ports.size ()] );
        return portlist;
    }
    
}
