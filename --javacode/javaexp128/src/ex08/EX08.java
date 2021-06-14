package ex08;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.WeakHashMap;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/6/4 15:32
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
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class EX08 {
    public static void main ( String[] args ) throws IOException {
        String path = FileSystemView.getFileSystemView().getHomeDirectory().getPath();//桌面
        File dir =new File ( path,"test128" );
        if(dir.exists ()){
            System.out.println ("目录一已存在" );
        }else {
            System.out.println ("目录不存在，正在创建中……" );
            dir.mkdir ();
        }
        
        File[] files=new File[3];
        for ( int i = 0 ; i < files.length ; i++ ) {
            String FileName="test"+i+".txt";
            files[i]=new File ( dir,FileName );
            if ( files[i].exists () ) {
                System.out.println (FileName+"已存在" );
            }else {
                System.out.println (FileName+"不存在，正在创建中……" );
                try {
                    files[i].createNewFile ();
                } catch ( IOException e ) {
                    e.printStackTrace ( );
                }
            }
        }
    
        Date date=new Date ();
        String str;
        try {
            FileOutputStream o0=new FileOutputStream ( files[0] );
            str="这是test0，"+new SimpleDateFormat ("今天是yyyy年MM月dd日").format ( date );
            o0.write ( str.getBytes() );
            o0.flush ();
            o0.close ();
        }
        catch ( FileNotFoundException e ) {
            e.printStackTrace ( );
        }
        catch ( IOException e ) {
            e.printStackTrace ( );
        }
        
        try {
            FileWriter o1=new FileWriter ( files[1] );
            str="这是test1，"+new SimpleDateFormat ("现在时间是HH:mm:ss").format ( date );
            o1.write ( str );
            o1.flush ();
            o1.close ();
        }
        catch ( IOException e ) {
            e.printStackTrace ( );
        }
        
        try {
            BufferedWriter o2=new BufferedWriter ( new FileWriter ( files[2] ) );
            str="这是test2，我的名字是刘宇霆，学号1190205128";
            o2.write ( str );
            o2.flush ();
            o2.close ();
        }
        catch ( IOException e ) {
            e.printStackTrace ( );
        }
        
        try {
            RandomAccessFile randomAccessFile =new RandomAccessFile ( files[0],"r" );
            long length=randomAccessFile.length ();
            long position=0;
            randomAccessFile.seek ( position );
            while ( position<length ){
                str=randomAccessFile.readLine ();
                byte b[]=str.getBytes(StandardCharsets.UTF_8 );
                str=new String (b);
                position=randomAccessFile.getFilePointer ();
                System.out.println (str );
            }
        }
        catch ( FileNotFoundException e ) {
            e.printStackTrace ( );
        }
        
        try {
            FileInputStream fileInputStream =new FileInputStream ( files[1] );
            int n=0;
            byte b[] = new byte[0];
            while ( (n =fileInputStream.read (b,0,3))!=-1 ){
                str =new String(b,0,n);
                System.out.print (str );
            }
        }catch ( IOException e ){
        
        }
    }
}
