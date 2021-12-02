package ex01;

public class CircleArray{
    private int maxSize;//表示数组的最大容量
    private int front;//指向队列的第一个元素，初始值为0
    private int rear;//指向队列的最后一个元素的后一个位置，初始值为0
    private int[] arr;//该数据用于存放数据，模拟队列
    //构造器
    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //让rear后移，必须考虑取模
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //显示队列的所有数据
    public void showQueue(){
        //编列
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        //
        for(int i = front;i < front + size();i++){
            if(arr[i % maxSize] == 0){
                continue;
            }
            System.out.printf("%d\t\t",arr[i % maxSize]);
        }
        System.out.println();
    }
    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，没有数据~~");
        }
        return arr[front];
    }
}
