package ch02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/3/30 15:52
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class StringSplit {
    public static void main ( String[] args ) {
        String str = "I love this game, yes I do. ";
        String[] ss = str.split ( "[,.]? " );
        for ( String string : ss ) {
            System.out.println ( string );
        }
    }
}
