package ex03;

import java.util.LinkedList;

public class Huffman {
    private String str;// 最初用于压缩的字符串
    private HNode root;// 哈夫曼二叉树的根节点
    private boolean flag;// 最新的字符是否已经存在的标签
    private LinkedList<CharData> charList;// 存储不同字符的队列 相同字符存在同一位置
    private LinkedList<HNode> NodeList;// 存储节点的队列
    
    private class CharData {
        int num = 1; // 字符个数
        char c; // 字符
        
        public CharData(char ch){
            c = ch;
        }
    }
    
    public void creatHfmTree(String str) {
        this.str = str;
        
        NodeList = new LinkedList<HNode>();
        charList = new LinkedList<CharData>();
        
        // 1.统计字符串中字符以及字符的出现次数
        // 以CharData类来统计出现的字符和个数
        getCharNum(str);
        
        // 2.根据第一步的结构，创建节点
        creatNodes();
        
        // 3.对节点权值升序排序
        Sort(NodeList);
        
        // 4.取出权值最小的两个节点，生成一个新的父节点
        // 5.删除权值最小的两个节点，将父节点存放到列表中
        creatTree();
        
        // 6.重复第四五步，就是那个while循环
        // 7.将最后的一个节点赋给根节点
        root = NodeList.get(0);
    }
    
    private void getCharNum(String str) {
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // 从给定的字符串中取出字符
            flag = true;
            
            for (int j = 0; j < charList.size(); j++) {
                CharData data = charList.get(j);
                
                if(ch == data.c){
                    // 字符对象链表中有相同字符则将个数加1
                    data.num++;
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                // 字符对象链表中没有相同字符则创建新对象加如链表
                charList.add(new CharData(ch));
            }
            
        }
        
    }
    private void creatNodes() {
        
        for (int i = 0; i < charList.size(); i++) {
            String data = charList.get(i).c + "";
            int count = charList.get(i).num;
            
            HNode node = new HNode(data, count); // 创建节点对象
            NodeList.add(node); // 加入到节点链表
        }
        
    }
    
    private void creatTree() {
        
        while (NodeList.size() > 1) {// 当节点数目大于一时
            // 4.取出权值最小的两个节点，生成一个新的父节点
            // 5.删除权值最小的两个节点，将父节点存放到列表中
            HNode left = NodeList.poll();
            HNode right = NodeList.poll();
            
            // 在构建哈夫曼树时设置各个结点的哈夫曼编码
            left.code = "0";
            right.code = "1";
            setCode(left);
            setCode(right);
            
            int parentWeight = left.count + right.count;// 父节点权值等于子节点权值之和
            HNode parent = new HNode(parentWeight, left, right);
            
            NodeList.addFirst(parent); // 将父节点置于首位
            Sort(NodeList); // 重新排序，避免新节点权值大于链表首个结点的权值
        }
    }
    
    private void Sort(LinkedList<HNode> nodelist) {
        for (int i = 0; i < nodelist.size() - 1; i++) {
            for (int j = i + 1; j < nodelist.size(); j++) {
                HNode temp;
                if (nodelist.get(i).count > nodelist.get(j).count) {
                    temp = nodelist.get(i);
                    nodelist.set(i, nodelist.get(j));
                    nodelist.set(j, temp);
                }
                
            }
        }
        
    }
    private void setCode(HNode root) {
        
        if (root.lChild != null) {
            root.lChild.code = root.code + "0";
            setCode(root.lChild);
        }
        
        if (root.rChild != null) {
            root.rChild.code = root.code + "1";
            setCode(root.rChild);
        }
    }
    
    private void output(HNode node) {
        
        if (node.lChild == null && node.rChild == null) {
            System.out.println(node.data + ": " + node.code);
        }
        if (node.lChild != null) {
            output(node.lChild);
        }
        if (node.rChild != null) {
            output(node.rChild);
        }
    }
    
    public void output() {
        output(root);
    }
    
    private String hfmCodeStr = "";// 哈夫曼编码连接成的字符串
    
    public String toHufmCode(String str) {
        
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            search(root, c);
        }
        
        return hfmCodeStr;
    }
    private void search(HNode root, String c) {
        if (root.lChild == null && root.rChild == null) {
            if (c.equals(root.data)) {
                hfmCodeStr += root.code; // 找到字符，将其哈夫曼编码拼接到最终返回二进制字符串的后面
            }
        }
        if (root.lChild != null) {
            search(root.lChild, c);
        }
        if (root.rChild != null) {
            search(root.rChild, c);
        }
    }
    // 保存解码的字符串
    String result="";
    boolean target = false; // 解码标记
    public String CodeToString(String codeStr) {
        
        int start = 0;
        int end = 1;
        
        while(end <= codeStr.length()){
            target = false;
            String s = codeStr.substring(start, end);
            matchCode(root, s); // 解码
            // 每解码一个字符，start向后移
            if(target){
                start = end;
            }
            end++;
        }
        
        return result;
    }
    
    private void matchCode(HNode root, String code){
        if (root.lChild == null && root.rChild == null) {
            if (code.equals(root.code)) {
                result += root.data; // 找到对应的字符，拼接到解码字符穿后
                target = true; // 标志置为true
            }
        }
        if (root.lChild != null) {
            matchCode(root.lChild, code);
        }
        if (root.rChild != null) {
            matchCode(root.rChild, code);
        }
        
    }
}
