package ex05;

import java.util.Arrays;

public class maopao {
    public static void main(String[] args) {
        int a[] = new int[]{72,6,57,88,60,42,83,73,48,85};
        int temp;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j+1]<a[j]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println( Arrays.toString( a ));
    }
}
