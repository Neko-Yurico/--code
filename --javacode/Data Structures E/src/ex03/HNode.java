package ex03;

public class HNode {
    
    public String code = "";// 节点的哈夫曼编码
    public String data = "";// 节点的数据
    public int count;// 节点的权值
    public HNode lChild;
    public HNode rChild;
    
    public HNode() {
    }
    
    public HNode(String data, int count) {
        this.data = data;
        this.count = count;
    }
    
    public HNode(int count, HNode lChild, HNode rChild) {
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    
    public HNode(String data, int count, HNode lChild, HNode rChild) {
        this.data = data;
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    
}
