package ex04;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/27 11:27
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class EX04 {
    public static void main ( String[] args ) {
        System.out.println ( "请输入一个运算表达式（例如sin-5):" );
        Scanner scanner = new Scanner ( System.in );
        String s = scanner.next ( );
        s = s.trim ( );
        while ( ! s.equals ( "q" ) && ! s.equals ( "Q" ) ) {
            Fx f = new Fx ( s );
            System.out.println ( f.getX ( ) + "\n请输入下一个算数表达式,退出请输入“q”：" );
            s = scanner.next ( );
            s = s.trim ( );
        }
        System.out.println ( "检测到输入为“q”，程序退出结束" );
    }
}
