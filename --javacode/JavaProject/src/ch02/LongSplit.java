package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/6 14:31
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class LongSplit {
    public static void main(String[] args) {
        String str="市话费：176.8元；通话时间120分钟。长途费：187.98元；通话时间30分钟。网络费：928.66元；在线时间234分钟。";
        Scanner scanner =new Scanner(str) ;
        scanner .useDelimiter("^[0-9]+\\.[0-9]{1,2}") ;
        double s1=0;
        while (scanner.hasNext() ){
            double price=scanner.nextDouble() ;
            s1 += price ;
        }
        System.out.println("总话费为"+s1);
//        System.out.println("总时长为"+s2);
    }
}
