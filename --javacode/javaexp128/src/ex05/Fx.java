package ex05;

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
class FxException extends Exception {
    String message;

    FxException ( int a ) {
        if ( a == 1 ) {
            message = "sqrt()内应是非零负数";
        }
        if ( a == 0 ) {
            message = "出现了未知的错误,可能是公式错误或函数未收录";
        }
        if ( a == 2 ) {
            message = "不支持的运算方法";
        }
        if ( a == 3 ) {
            message = "log()内应是正数";
        }
    }

    public String getMessage ( ) {
        return message;
    }
}

public class Fx {
    private double x;
    private double y;
    private int ch = 0;

    public Fx ( String x ) throws InputMismatchException, FxException {
        double num;
        Scanner scanner = new Scanner ( x );
        scanner.useDelimiter ( "[^0123456789.-]+" );
        while ( scanner.hasNext ( ) ) {
            num = scanner.nextDouble ( );
            if ( x.startsWith ( "abs" ) || x.startsWith ( "Abs" ) ) {
                this.x = getXabs ( num );
                this.ch = 1;
                this.y = num;
            }
            else if ( x.startsWith ( "sqrt" ) || x.startsWith ( "Sqrt" ) ) {
                if ( num < 0 ) {
                    throw ( new FxException ( 1 ) );
                }
                this.x = getXsqrt ( num );
                this.ch = 2;
                this.y = num;
            }
            else if ( x.startsWith ( "log" ) || x.startsWith ( "Log" ) ) {
                if ( num <= 0 ) {
                    throw ( new FxException ( 3 ) );
                }
                this.x = getXlog ( num );
                this.ch = 3;
                this.y = num;
            }
            else if ( x.startsWith ( "sin" ) || x.startsWith ( "Sin" ) ) {
                this.x = getXsin ( num );
                this.ch = 4;
                this.y = num;
            }
            else if ( x.startsWith ( "cos" ) || x.startsWith ( "Cos" ) ) {
                this.x = getXcos ( num );
                this.ch = 5;
                this.y = num;
            }
            else if ( x.startsWith ( "tan" ) ) {
                this.x = 0;
                this.ch = 8;
                this.y = 0;
            }
            else if ( isDigit ( x ) ) {
                x = x.trim ( );
                this.x = Double.parseDouble ( x );
                this.ch = 6;
                this.y = this.x;
            }
            else {
                this.x = 0;
                this.ch = 7;
                this.y = 0;
            }
        }
        if ( ! isDigit ( x ) && this.ch == 0 ) {
            this.x = 0;
            this.ch = 7;
            this.y = 0;
        }
    }

    private boolean isDigit ( String x ) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return x.matches ( reg );
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

    String getX ( ) throws FxException {
        if ( this.ch == 7 ) {
            throw ( new FxException ( 0 ) );
        }
        else if ( this.ch == 8 ) {
            throw ( new FxException ( 2 ) );
        }
        String f = switch ( this.ch ) {
            case 1 -> "abs(" + this.y + ")=";
            case 2 -> "sqrt(" + this.y + ")=";
            case 3 -> "log(" + this.y + ")=";
            case 4 -> "sin(" + this.y + ")=";
            case 5 -> "cos(" + this.y + ")=";
            case 6 -> "(" + this.y + ")=";
            default -> "";
        };
        f = f + this.x;
        return f;
    }

}
