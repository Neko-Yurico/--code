package ex03;

import java.util.Arrays;
import java.util.Scanner;

public class CreatBitTree {
    
    static class Tree{
        char val;
        Tree left;
        Tree right;
        Tree(char val, Tree left, Tree right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        Tree(){
        }
        Tree(char val){
            this.val = val;
            this.left = null;
            this.right =null;
        }
    }//树
    
    public static Tree CreatBitTree ( char[] preOrder , char[] inOrder ){
        //preOrder是先序序列
        //inOrder是中序序列
        if(preOrder == null || preOrder.length == 0){
            return null;
        }
        Tree root = new Tree(preOrder[0]);
        //找到inOrder中的root的位置
        int inOrderIndex = 0;
        for (char i = 0; i < inOrder.length; i++){
            if(inOrder[i] == root.val){
                inOrderIndex = i;
            }
        }
        //preOrder的左子树和右子树部分
        char[] preOrderLeft = Arrays.copyOfRange( preOrder, 1, 1 + inOrderIndex);
        char[] preOrderRight = Arrays.copyOfRange(preOrder, 1+inOrderIndex, preOrder.length);
        //inOrder的左子树和右子树部分
        char[] inOrderLeft = Arrays.copyOfRange(inOrder, 0, inOrderIndex);
        char[] inOrderRight = Arrays.copyOfRange(inOrder, inOrderIndex+1, inOrder.length);
        //递归建立左子树和右子树
        Tree leftChild = CreatBitTree ( preOrderLeft, inOrderLeft);
        Tree rightChild = CreatBitTree ( preOrderRight, inOrderRight);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }//用前序和中序生成树
    
    public static void postOrderTraversal ( Tree root){
        if(root.left != null){
            postOrderTraversal ( root.left);
        }
        if(root.right != null){
            postOrderTraversal ( root.right);
        }
        System.out.print(root.val + " ");
    }//后根遍历
    public static void main(String[] args) {
        System.out.print ("请输入前根序列：" );
        Scanner scanner=new Scanner ( System.in );
        String input =scanner.next ();
        char[] preOrder = input.toCharArray();
        System.out.print ("请输入中根序列：" );
        input =scanner.next ();
        char[] inOrder = input.toCharArray();
        Tree root = CreatBitTree( preOrder, inOrder);
        System.out.println ("后根遍历为：" );
        postOrderTraversal ( root );
    }
}
