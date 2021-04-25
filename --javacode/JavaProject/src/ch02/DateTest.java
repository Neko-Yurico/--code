package ch02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/25 13:51
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class DateTest {
    public static void main ( String[] args ) throws InterruptedException {
        while ( true ) {
            Date date = new Date ( );
            System.out.println ( date );
            SimpleDateFormat sdf = new SimpleDateFormat ( "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n现在是yyyy年MM月dd日 E\naHH时mm分ss秒\n\n\n" );
            //清奇脑回路源于`https://blog.csdn.net/ywh22122/article/details/98765764`
            String f = sdf.format ( new Date ( ) );
            System.out.println ( f );
            Thread.sleep ( 1000 );
        }
    }
}
