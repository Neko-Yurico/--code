package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/16 14:04
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class ScannerTest {
    public static void main(String[] args)
    {
        System.out.println("请连续输入值：");
        Scanner scanner=new Scanner(System.in);
        int sum=0;
        int m=0;
        while (scanner.hasNextInt())
        {
            int p=scanner.nextInt();
            sum+=p;
            m=m+1;
        }
        System.out.printf("共输入了%d个数，和为%d。 \n",m,sum);
        System.out.printf("平均值为%.1f",1.0*sum/m);

    }
}
