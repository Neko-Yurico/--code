package ch02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/16 13:48
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class Printtest
{
    public static void main(String[] args)
    {
        System.out.print("不换行");
        System.out.println("自动换行");
        int a = 4;
        double b = 5.0/3;
        System.out.printf("a=%d, b=%f \n",a,b);
        System.out.printf("a=%4d, b=%7.3f \n",a,b);
        System.out.printf("a=%-4d, b=%07.3f \n",a,b);

    }
}
