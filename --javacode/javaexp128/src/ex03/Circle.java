package ex03;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/20 14:25
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class Circle {
    private static final double PI = 3.1415926;
    private final double radius;
    private final double posX;
    private final double posY;

    public Circle (double radius,double posX ,double posY) {
        this.radius = radius;
        this.posX=posX;
        this.posY=posY;
    }
    double getArea(){
        return PI * radius * radius;
    }
    double getPosX(){
        return this.posX;
    }
    double getPosY(){
        return this.posY;
    }
    double getDistance(Circle cc){
        return sqrt((pow((cc.posX-this.posX),2))+(pow((cc.posY-this.posY ),2)));
    }
}