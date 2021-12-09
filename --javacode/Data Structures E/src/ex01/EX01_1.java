package ex01;

import java.util.Scanner;
import java.util.Stack;

public class EX01_1 {
    public static void main ( String[] args ) {
        System.out.println ( "请输入一个十进制整数：" );
        Scanner scanner=new Scanner ( System.in );
        int num=scanner.nextInt ();
        int inum=num;
        Stack stack=new Stack ();
        int flag=0;
        while ( num!=0 ){
            flag=num%2;
            stack.push ( flag );
            num/=2;
        }
        System.out.print ("("+inum+")D 转换为二进制为：\n(" );
        while ( !stack.empty () ){
            System.out.print (stack.peek () );
            stack.pop ();
        }
        System.out.println (")B" );
    }
}
