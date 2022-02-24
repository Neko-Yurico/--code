package ex04;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print ("请输入图的顶点数量：" );
        Scanner scanner=new Scanner ( System.in );
        int i=scanner.nextInt ();
        Graph g = new Graph(i);
        System.out.println ("请向图中添加一条边（如“3 5 x”为3到5或5到3的边，x换成q为结束添加）" );
        i=scanner.nextInt ();
        int j=scanner.nextInt ();
        g.addEdge ( i , j );
        while ( ! scanner.next ( ).equals ( "q" ) ) {
             i=scanner.nextInt ();
             j=scanner.nextInt ();
             g.addEdge ( i , j );
        }
        System.out.print ("请输入开始顶点：" );
        i=scanner.nextInt ();
        DepthFirstSearch ds = new DepthFirstSearch(g,i);
        System.out.println("与"+i+"顶点相通的所有顶点的总数为："+ds.count());
        System.out.println("与"+i+"顶点相邻的所有顶点为："+g.adj(i));
    }
}
