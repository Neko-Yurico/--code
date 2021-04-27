package ex04;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/27 11:33
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class Fx {
    private double x;
    private double y;
    private int ch=0;

    public Fx ( String x ) throws InputMismatchException {
        double num = 0;
        Scanner scanner =new Scanner (x) ;
        scanner .useDelimiter ("[^0123456789.-]+") ;
        while (scanner .hasNext ()){
            num = scanner .nextDouble ();
            if(x.startsWith ("abs")||x.startsWith ("Abs") ){
                this.x = getXabs (num) ;
                this.ch=1;
                this.y=num;
            }
            else if(x.startsWith ("sqrt")||x.startsWith ("Sqrt") ){
                this.x = getXsqrt (num) ;
                this.ch=2;
                this.y=num;
            }
            else if(x.startsWith ("log")||x.startsWith ("Log") ){
                this.x = getXlog (num) ;
                this.ch=3;
                this.y=num;
            }
            else if(x.startsWith ("sin")||x.startsWith ("Sin") ){
                this.x = getXsin (num) ;
                this.ch=4;
                this.y=num;
            }
            else if(x.startsWith ("cos")||x.startsWith ("Cos") ){
                this.x = getXcos (num) ;
                this.ch=5;
                this.y=num;
            }
            else if ( isDigit ( x )){
                x = x.trim ();
                this.x=Double.parseDouble ( x );
                this.ch=6;
                this.y=this.x;
            }
            else {
                this.x=0;
                this.ch=7;
                this.y=0;
            }
        }
        if ( !isDigit ( x ) && this.ch==0)  {
            this.x=0;
            this.ch=7;
            this.y=0;
        }
    }

    private boolean isDigit ( String x ) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return x.matches(reg);
    }

    double getXabs ( double x ) {
        return abs ( x );
    }

    double getXsqrt ( double x ) {
        return sqrt ( x );
    }

    double getXlog ( double x ) {
        return log ( x );
    }

    double getXsin ( double x ) {
        return sin ( x );
    }

    double getXcos ( double x ) {
        return cos ( x );
    }

    String getX (){
        String f = "";
        switch (this.ch) {
            case 1:
                f="abs("+this.y+")=";
                break;
            case 2:
                f="sqrt("+this.y+")=";
                break;
            case 3:
                f="log("+this.y+")=";
                break;
            case 4:
                f="sin("+this.y+")=";
                break;
            case 5:
                f="cos("+this.y+")=";
                break;
            case 6:
                f="("+this.y+")=";
                break;
            case 7:
                f="出现了未知的错误,可能是公式哪里写错了？";
                break;
        }
        f= f + this.x;
        return f;
    }

}
