package ex04;

public class MinSpanTree {
    int[][] matrix;// 矩阵
    int MAX_WEIGHT = Integer.MAX_VALUE;
    int size;// 顶点个数
    
    public void prim(){
        int[] tempWeight = new int[size];// 临时存放顶点权值的数组，每次循环都要从中获取到最小权值和顶点下标
        int minWeight;//最小权值
        int minId;//最小权值顶点
        int sum = 0;//权值总和
        //先初始化将第一行的顶点权值存放到临时权值数组中
        for(int i =0;i<size;i++){
            tempWeight[i] = matrix[0][i];
        }
        System.out.println("从顶点0开始查找");
        for(int i=1;i<size;i++){
            //每次循环都找出临时顶点权值的最小的权值
            minWeight = MAX_WEIGHT;
            minId = 0;
            for(int j=1;j<size;j++){
                if(tempWeight[j] >0 && tempWeight[j]<minWeight){
                    minWeight = tempWeight[j];
                    minId = j;
                }
            }
            //找到目标顶点minId,他的权值为minweight。
            System.out.println("找到顶点:"+minId+" 权值为："+minWeight);
            sum+=minWeight;
            //根据找到的顶点minid，将这一行的所有相关联的顶点权值添加到临时权值数组中
            tempWeight[minId] = 0;
            for(int j = 1;j<size;j++){
                if(tempWeight[j] != 0&& matrix[minId][j]<tempWeight[j]){
                    tempWeight[j] = matrix[minId][j];
                }
            }
        }
        System.out.println("最小权值总和为："+sum);
    }
    
    private void createGraph(int index) {
        size = index;
        matrix = new int[index][index];
        matrix[0] = new int[]{ 0 , 10 , MAX_WEIGHT , MAX_WEIGHT , MAX_WEIGHT , 11 , MAX_WEIGHT , MAX_WEIGHT , MAX_WEIGHT };
        matrix[1] = new int[]{ 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
        matrix[2] = new int[]{ MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
        matrix[3] = new int[]{ MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, 24, 16, 21 };
        matrix[4] = new int[]{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
        matrix[5] = new int[]{ 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
        matrix[6] = new int[]{ MAX_WEIGHT, 16, MAX_WEIGHT, 24, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
        matrix[7] = new int[]{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
        matrix[8] = new int[]{ MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };
    }
    public static void main(String[] args) {
        MinSpanTree graph = new MinSpanTree();
        graph.createGraph(9);
        graph.prim();
    }
}
