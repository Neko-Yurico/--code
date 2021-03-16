package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/16 15:46
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class FactorialSum
{
    public static void main(String[] args)
    {
        long s;
        int n;
        System.out.println("计算1!+2!+3!+……+n!");
        System.out.print("请输入n的数值:");
        Scanner reader=new Scanner(System.in);
        //判断输入是否为整数
        while (!reader.hasNextInt())
        {
            System.out.println("请输入正确的n");
            System.out.print("请输入n的数值:");

            reader = new Scanner(System.in);
        }
            n=reader.nextInt();
            s=func(n);
            System.out.printf("%s个数阶乘的和为：%d",n,s);
    }
    //递归求Σn！
    //算法来自于acm社团
    public static long func(int n)
    {
        int sum,fac=1;
        if(n==1){
            return fac;
        }
        else{
            for(int i=2;i<=n;i++)
                fac*=i;
            n=n-1;
            sum=fac;
            sum+=func(n);
            return sum;
        }
    }
}
