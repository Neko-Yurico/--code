package ex03;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 哈夫曼树简单实现
 */
public class HuffmanTree<E> {
    /**
     * 外部保存根节点的引用
     */
    private BinaryTreeNode<E> root;

    /**
     * 内部节点
     *
     * @param <E> 节点数据类型
     */
    public static class BinaryTreeNode<E> {
        //节点数据
        E data;
        //节点权重
        String weight;
        //左子结点
        BinaryTreeNode<E> left;
        //右子节点
        BinaryTreeNode<E> right;

        public BinaryTreeNode(E data, String weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", weight='" + weight + '\'' +
                   '}';
        }
    }

    
    /**
     * 根据指定的普通node节点集合构建哈夫曼树
     *
     * @param binaryTreeNodes node节点集合,采用普通list集合
     * @param <E>         节点数据类型
     * @return 哈夫曼树
     */
    public static <E> HuffmanTree<E> build( List<BinaryTreeNode<E>> binaryTreeNodes) {
        //比较器
        Comparator<BinaryTreeNode<E>> comparator = ( o1, o2) -> new BigDecimal( o1.weight).subtract( new BigDecimal( o2.weight)).intValue();
        while (binaryTreeNodes.size() > 1) {
            //手动对集合的节点按照权值大小从大到小进行排序
            binaryTreeNodes.sort(comparator);
            //移除并获取权值最小的两个节点
            BinaryTreeNode<E> left = binaryTreeNodes.remove(0);
            BinaryTreeNode<E> right = binaryTreeNodes.remove(0);
            //生成新节点，新节点的权值为两个子节点的权值之和
            BinaryTreeNode<E> parent = new BinaryTreeNode<>(null, new BigDecimal(left.weight).add(new BigDecimal(right.weight)).toString());
            //让新节点作为两个权值最小节点的父节点
            parent.left = left;
            parent.right = right;
            //将新节点加入到集合中
            binaryTreeNodes.add(parent);
        }
        //采用循环不断地执行上面的步骤，直到list集合中只剩下一个节点，最后剩下的这个节点就是哈夫曼树的根节点
        HuffmanTree<E> huffmanTree = new HuffmanTree<>();
        huffmanTree.root = binaryTreeNodes.remove(0);
        return huffmanTree;
    }

    /**
     * 根据指定的最小堆构建哈夫曼树
     *
     * @param binaryTreeNodes node节点集合,采用最小堆
     * @param <E>         节点数据类型
     * @return 哈夫曼树
     */
    public static <E> HuffmanTree<E> build( PriorityQueue<BinaryTreeNode<E>> binaryTreeNodes) {
        while (binaryTreeNodes.size() > 1) {
            //移除并获取权值最小的两个节点
            BinaryTreeNode<E> left = binaryTreeNodes.poll();
            BinaryTreeNode<E> right = binaryTreeNodes.poll();
            //生成新节点，新节点的权值为两个子节点的权值之和
            BinaryTreeNode<E> parent = new BinaryTreeNode<>(null, new BigDecimal(left.weight).add(new BigDecimal ( right.weight)).toString());
            //让新节点作为两个权值最小节点的父节点
            parent.left = left;
            parent.right = right;
            //将新节点加入到最小堆中,自动排序
            binaryTreeNodes.add(parent);
        }
        //采用循环不断地执行上面的步骤，直到list集合中只剩下一个节点，最后剩下的这个节点就是哈夫曼树的根节点
        HuffmanTree<E> huffmanTree = new HuffmanTree<>();
        huffmanTree.root = binaryTreeNodes.poll();
        return huffmanTree;
    }

    /**
     * 获取根节点
     *
     * @return 根节点或者null-表示空树
     */
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

}