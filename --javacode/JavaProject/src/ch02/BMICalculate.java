package ch02;

import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/23 13:42
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class BMICalculate
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入身高(m)：");
        double height = scanner.nextDouble();
        System.out.print("请输入体重(kg)：");
        double weight = scanner.nextDouble();
        double bmi = weight / (height * height);
        if(bmi < 18.5)
        {
            System.out.println("过轻");
        }
        else if ((bmi < 25) && !(bmi < 18.5))
        {
            System.out.println("正常");
        }
        else if ((bmi < 28) && !(bmi < 25))
        {
            System.out.println("过重");
        }
        else if ((bmi < 32) && !(bmi < 28))
        {
            System.out.println("肥胖");
        }
        else
        {
            System.out.println("非常肥胖");
        }
    }
}
