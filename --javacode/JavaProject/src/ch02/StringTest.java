package ch02;

import java.nio.charset.StandardCharsets;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/30 14:03
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String a = "hello你好";
        System.out.println(a.length());
        System.out.println(a.contains("he") );
        System.out.println(a.indexOf("l") );
        char[] as = a.toCharArray();
        System.out.println(as.length );
        byte[] abs = a.getBytes(StandardCharsets.UTF_8);
        System.out.println(abs.length );
        //
        String s= "wdt=44,g=5";
        char[] s1 = s.toCharArray();
        int inumber = 0;
        for (int i = 0; i < s1.length; i++)
        {
            if (Character.isDigit(s1[i]))
            {
                System.out.printf("在%d处找到字符%c\n",i,s1[i]);
                inumber++;
            }
        }
        System.out.println("共找到"+inumber+"个数字");
        //
    }
}

