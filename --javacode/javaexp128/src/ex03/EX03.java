package ex03;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/20 14:38
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class EX03 {
    public static void main ( String[] args ) {
        Circle c1 = new Circle (1,0,0) ;
        Circle c2 = new Circle (2,3,4) ;
        System.out.printf ( "c1位于（%.1f，%.1f）,面积为%.3f\n",c1.getPosX (),c1.getPosY (),c1.getArea ());
        System.out.printf ( "c2位于（%.1f，%.1f）,面积为%.3f\n",c2.getPosX (),c2.getPosY (),c2.getArea ());
        System.out.printf("c1和c2的圆心距离为%.1f",c1.getDistance (c2));
    }
}
