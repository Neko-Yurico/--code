package ch02;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/25 15:22
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class LocaltimeWork {
    public static void main ( String[] args ) throws InterruptedException {
        while ( true ) {
            LocalDate ld = LocalDate.now ( );
            System.out.println ( "现在是" + ld.getYear ( ) + "年" + ld.getMonthValue ( ) + "月" + ld.getDayOfMonth ( ) + "日" );
            System.out.println ( ld.getDayOfWeek ( ) );
            LocalTime lt = LocalTime.now ( );
            System.out.println ( lt.getHour ( ) + "时" + lt.getMinute ( ) + "分" + lt.getSecond ( ) + "秒" );
            Thread.sleep ( 1000 );
        }
    }
}
