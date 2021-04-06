package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/6 14:31
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class LongSplit {
    public static void main ( String[] args ) {
        String str = "市话费：176.8元；通话时间120分钟。长途费：187.98元；通话时间30分钟。网络费：928.66元；在线时间234分钟。";
        Scanner scanner = new Scanner ( str );
        //       scanner .useDelimiter("^[0-9]+\\.[0-9]{1,2}") ;
        scanner.useDelimiter ( "[^0-9.分]" );
        double s1 = 0, s2 = 0;
        while ( scanner.hasNext ( ) ) {
            if ( scanner.hasNextDouble ( ) ) {
                s1 += Double.parseDouble ( scanner.next ( ) );
            }
            else {
                scanner.next ( );
            }
        }
        System.out.println ( "总话费为" + s1 + "元" );
    }
}
