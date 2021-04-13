package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/13 13:58
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class CircleTest {
    public static void main ( String[] args ) {
        Circle circle ;
        circle =new Circle () ;
        System.out.println ("请输入圆的半径:" );
        Scanner scanner =new Scanner (System .in);
        circle .radius =scanner .nextDouble () ;
        double area=circle .getArea () ;
        System.out.printf ("半径是%5.3f的圆的面积：\n%5.3f\n",circle .radius ,area );
    }
}
