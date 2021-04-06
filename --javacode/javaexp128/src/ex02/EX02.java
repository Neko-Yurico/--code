package ex02;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/6 13:15
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class EX02 {
    public static void main ( String[] args ) {
        String str = "市话费：176.8元；通话时间120分钟。长途费：187.98元；通话时间30分钟。网络费：928.66元；在线时间234分钟。";
        String streg = "[^\\d.元分]+";
        String[] ss = str.split ( streg );
        double s1 = 0, s2 = 0;
        for ( String string : ss ) {
            if ( string.endsWith ( "元" ) ) {
                String price = string.substring ( 0 , string.length ( ) - 1 );
                s1 += Double.parseDouble ( price );
            }
            else if ( string.endsWith ( "分" ) ) {
                String length = string.substring ( 0 , string.length ( ) - 1 );
                s2 += Double.parseDouble ( length );
            }
        }
        System.out.println ( "总计费用：" + s1 + "元" );
        System.out.println ( "时长：" + s2 + "分钟" );
    }
}
