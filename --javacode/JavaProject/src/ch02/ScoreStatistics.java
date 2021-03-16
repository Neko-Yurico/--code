package ch02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/16 15:07
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class ScoreStatistics
{
    public static void main(String[] args)
    {
        //原始数据
        int[] scores = {72,89,65,58,87,91,53,82,71,93,76,68};
        //求均值
        double sum = 0;
        for (int score : scores) {
            sum = sum + score;
        }
        //输出
        System.out.println("平均成绩为" + sum/scores.length );
        System.out.printf("平均成绩为%.1f",sum/scores.length);
    }

}