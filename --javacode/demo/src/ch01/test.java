package ch01;

import java.util.Timer;
import java.util.TimerTask;

public class test {
    public static void main ( String[] args ) {
        for(int i = 0;i < 5;i++){
            System.out.println (i);
            try {
                Thread.sleep ( 1000 );
            }
            catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
    
        }
    }
    
}
    


