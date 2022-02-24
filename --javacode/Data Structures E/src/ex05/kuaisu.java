package ex05;

import java.util.Arrays;

public class kuaisu {
    public static void quickSort(int[] a,int left,int right) {
        if(left<right) {
            int temp=qSort(a,left,right);
            quickSort(a,left,temp-1);
            quickSort(a,temp+1,right);
        }
    }
    public static int qSort(int[] a,int left,int right) {
        int temp=a[left];//定义基准数，默认为数组的第一个元素
        while(left<right) {//循环执行的条件
            //因为默认的基准数是在最左边，所以首先从右边开始比较进入while循环的判断条件
            //如果当前arr[right]比基准数大，则直接将右指针左移一位，当然还要保证left<right
            while(left<right && a[right]>temp) {
                right--;
            }
            //跳出循环说明当前的arr[right]比基准数要小，那么直接将当前数移动到基准数所在的位置，并且左指针向右移一位（left++）
            //这时当前数（arr[right]）所在的位置空出，需要从左边找一个比基准数大的数来填充。
            if(left<right) {
                a[left++]=a[right];
            }
            //下面的步骤是为了在左边找到比基准数大的数填充到right的位置。
            //因为现在需要填充的位置在右边，所以左边的指针移动，如果arr[left]小于或者等于基准数，则直接将左指针右移一位
            while(left<right && a[left]<=temp) {
                left++;
            }
            //跳出上一个循环说明当前的arr[left]的值大于基准数，需要将该值填充到右边空出的位置，然后当前位置空出。
            if(left<right) {
                a[right--]=a[left];
            }
        }
        //当循环结束说明左指针和右指针已经相遇。并且相遇的位置是一个空出的位置，
        //这时候将基准数填入该位置，并返回该位置的下标，为分区做准备。
        a[left]=temp;
        return left;
    }
    public static void main(String[] args) {
        int[] a= {72,6,57,88,60,42,83,73,48,85};
        quickSort(a,0,9);
        System.out.println(Arrays.toString(a));
    }
}

