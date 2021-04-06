package ch02;

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
        String[] ss = str.split("\\D*=") ;
        for (String string : ss )
        {
            System.out.println(string);
        }
    }
}
