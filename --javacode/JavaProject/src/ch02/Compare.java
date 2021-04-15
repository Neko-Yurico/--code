package ch02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/15 21:30
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class Compare
{
    public static void main ( String[] args ) {
        String s1 =new String ("hello") ;
        String s2="Hello";
        String s3="helloPi";
        String s4="happy";
        System.out.println ( s1.compareTo ( s2 ) );//如果第一个字符和参数的第一个字符不等，结束比较，返回他们之间的差值。
        System.out.println ( s1.compareTo ( s4 ) );//如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符作比较，以此类推。
        System.out.println ( s1.compareTo ( s3 ) );//比较的字符或被比较的字符有一方全比较完，已经被比较的字符完全相同时，这时就比较字符的长度。
    }
}
