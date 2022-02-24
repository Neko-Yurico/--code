package ex01;

import java.util.*;

public class EX01_2 {
    public static void main ( String[] args ) {
        System.out.println("请输入杨辉三角的行数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CircleArray circleArray = new CircleArray ( n + 2 );
        circleArray.addQueue(0);
        circleArray.addQueue(1);
        for ( int i=0;i<n-1;i++ ){
            System.out.print ("\t");
        }
        System.out.println(1);
        for(int i = 2;i <= n;i++){
            circleArray.addQueue(0);
            for(int j = 0;j < i;j++){
                int a,b,c;
                a = circleArray.getQueue();
                b = circleArray.headQueue();
                c = a + b;
                circleArray.addQueue(c);
            }
            for ( int j=0;j<n-i;j++ ){
                System.out.print ("\t");
            }
            circleArray.showQueue();
        }
    }
}
/*
class SeqQueue < T > {
    private Object element[];
    private int front,rear;
    public SeqQueue(int length){
        if (length<64){length=64;}
        this.element=new Object[Math.abs ( length )];
        this.front=this.rear=0;
    }
    public SeqQueue(){this(64);}


    public boolean isEmpty(){
        return this.front==this.rear;
    }


    public void enqueue(T x){
        if (x==null){
            return;
        }
        if ( this.front==(this.rear+1)%this.element.length ){
            Object[] temp = this.element;
            this.element=new Object[temp.length*2];
            int i=this.front ,j=0;
            while ( i!=this.rear ){
                this.element[j]=temp[i];
                i=(i+1)%temp.length;
                j++;
            }
            this.front=0;
            this.rear=j;
        }
        this.element[this.rear]=x;
        this.rear=(this.rear+1)%this.element.length;
    }
    public T frontqueue(){
        if (isEmpty ()){
            return null;
        }
        T temp = (T) this.element[this.front];
        return temp;
    }
    public T dequeue(){
        if ( isEmpty () ){
            return null;
        }
        T temp = (T) this.element[this.front];
        this.front=(this.front+1)%this.element.length;
        return temp;
    }


}*/