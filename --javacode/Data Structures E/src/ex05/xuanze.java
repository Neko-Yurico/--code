package ex05;

import java.util.Arrays;

public class xuanze {
    public static void main(String[] args) {
        int[] num ={72,6,57,88,60,42,83,73,48,85};
        for (int i = 0; i < num.length; i++) {
            int minIndex = i;
            for (int j = i; j < num.length; j++) {
                if (num[j]<num[minIndex]){
                    minIndex = j;
                }
            }
            int temp = num[i];
            num[i] = num[minIndex];
            num[minIndex] = temp;
        }
        System.out.println( Arrays.toString( num));
    }
}
