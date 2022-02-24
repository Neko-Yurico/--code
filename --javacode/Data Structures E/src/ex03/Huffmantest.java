package ex03;

import org.junit.Test;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffmantest {
    @Test
    public void test ( ) {
        Huffman huff = new Huffman ( );
        System.out.println ("请输入需要编码的串：" );
        Scanner scanner=new Scanner ( System.in );
        String data = scanner.next ();
        huff.creatHfmTree ( data );// 构造树
        huff.output ( ); // 显示字符的哈夫曼编码
        // 将目标字符串利用生成好的哈夫曼编码生成对应的二进制编码
        String hufmCode = huff.toHufmCode ( data );
        System.out.println ( "编码:" + hufmCode );
        // 将上述二进制编码再翻译成字符串
        System.out.println ( "解码：" + huff.CodeToString ( hufmCode ) );
    }
}
