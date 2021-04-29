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
        Circle circle;
        System.out.println ( "请输入圆的半径:" );
        Scanner scanner = new Scanner ( System.in );
        double r = scanner.nextDouble ( );
        circle = new Circle ( r );
        double area = circle.getArea ( );
        System.out.printf ( "半径是%5.3f的圆的面积：\n%5.3f\n" , r , area );
    }
}
