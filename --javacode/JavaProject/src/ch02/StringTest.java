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
        String a = new String("hello你好");
        System.out.println(a.length());
        System.out.println(a.contains("he") );
        System.out.println(a.indexOf("l") );
        char[] as = a.toCharArray();
        System.out.println(as.length );
        byte[] abs = a.getBytes(StandardCharsets.UTF_8);
        System.out.println(abs.length );
    }
}
