package ch02;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/6 13:38
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class splitpractice {
    public static void main(String[] args) {
        String str = "T=12.3 H=058 L=007";
/*
       String[] ss = str.split("\\D*=") ;
       System.out.println("找到"+ss.length +"个字符");
       for (int i=1;i< ss.length ;i++ ) {
           System.out.println(ss[i]);
           }
 */
        Scanner scanner =new Scanner(str) ;
        scanner .useDelimiter("[^\\d.]+") ;
        double s=0;
        while (scanner .hasNext() ){
            s += Double.parseDouble(scanner.next());
        }
        System.out.println("数据总和为"+s);
    }
}
