package ch02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/13 13:56
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class Circle {
    private static final double PI = 3.14;
    double radius;

    public Circle (double d) {
        radius = d;
    }

    double getArea(){
        return PI * radius * radius;
    }
}
