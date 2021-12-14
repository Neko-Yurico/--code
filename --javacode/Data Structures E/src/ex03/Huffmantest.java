package ex03;

import org.junit.Test;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffmantest {
//    @Test
//    public void test1 ( ) {
//        List< HuffmanTree.BinaryTreeNode< String > > binaryTreeNodes = new ArrayList<> ( );
//        // A5,B15,C40,D30,E10
//        binaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "A" , "5" ) );
//        binaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "B" , "15" ) );
//        binaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "C" , "40" ) );
//        binaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "D" , "30" ) );
//        binaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "E" , "10" ) );
//        HuffmanTree< String > huffmanTree = HuffmanTree.build ( binaryTreeNodes );
//        HuffmanTree.BinaryTreeNode< String > root = huffmanTree.getRoot ( );
//        System.out.println ( root );
//    }
//
//    @Test
//    public void test2 ( ) {
//        PriorityQueue< HuffmanTree.BinaryTreeNode< String > > priorityQueueBinaryTreeNodes = new PriorityQueue<> ( ( o1 , o2 ) -> new BigDecimal ( o1.weight ).subtract ( new BigDecimal ( o2.weight ) ).intValue ( ) );
//        priorityQueueBinaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "A" , "5" ) );
//        priorityQueueBinaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "B" , "15" ) );
//        priorityQueueBinaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "C" , "40" ) );
//        priorityQueueBinaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "D" , "30" ) );
//        priorityQueueBinaryTreeNodes.add ( new HuffmanTree.BinaryTreeNode<> ( "E" , "10" ) );
//        HuffmanTree< String > huffmanTree = HuffmanTree.build ( priorityQueueBinaryTreeNodes );
//        HuffmanTree.BinaryTreeNode< String > root = huffmanTree.getRoot ( );
//        System.out.println ( root );
//    }
//
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
