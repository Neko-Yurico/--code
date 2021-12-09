package ex02;

import java.util.Scanner;

public class seqstring implements IString {
    
    //实现方法
    private char[] strvalue;   //字符数组存放串值
    private int curlen;         //当前串的长度
    public seqstring (){
        strvalue=new char[0];
        curlen=0;
    }//构造方法1，构造空串
    public seqstring ( String str){
        strvalue=str.toCharArray();
        curlen=strvalue.length;
    }//构造方法2，以字符串常量构造串对象
    public seqstring ( char[] value){
        strvalue=new char[value.length];
        for(int i=0;i<value.length;i++){
            strvalue[i]=value[i];
        }
        curlen=value.length;
    }//构造方法3，以字符数组构造串对象
    public void clear(){
        curlen=0;
    }//将一个已经存在的字符串置成空串
    public boolean isEmpty(){
        return curlen==0;
    }//判断字符串是否为空
    public int length(){
        return curlen;
    }//返回字符串长度
    public char charAt(int index){
        if(index<0||index>=curlen){
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }//返回字符串中序号为index的字符
    public void allocate(int newcapacity){
        char[]temp=strvalue;
        strvalue=new char[newcapacity];
        for(int i=0;i<temp.length;i++)
            strvalue[i]=temp[i];
    }//扩充字符串存储空间容量，参数指定容量
    public IString substring(int begin,int end){
        if(begin<0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        if(end>curlen)
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度");
        if(begin>end)
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        if(begin==0&&end==curlen)
            return this;
        else{
            char[]buffer=new char[end-begin];
            for(int i=0;i<buffer.length;i++)
                buffer[i]=this.strvalue[i+begin];
            return new seqstring ( buffer);
        }
    }//截取从begin到end-1的子串并返回
    public IString insert(int offset,IString str){
        if(offset<0||offset>this.curlen)
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        int len=str.length();
        int newcount=len+curlen;
        if(newcount>strvalue.length){
            allocate(newcount);
        }
        for(int i=curlen-1;i>=offset;i--){
            strvalue[len+i]=strvalue[i];
        }
        for(int i=0;i<len;i++)
            strvalue[i+offset]=str.charAt(i);
        curlen=newcount;
        return this;
    }//在第offset字符之前插入str
    public seqstring delete( int begin, int end){
        for(int i=0;i<curlen-end;i++)
            strvalue[begin+i]=strvalue[end+i];
        curlen=curlen-(end-begin);
        return this;
    }//删除从begin从end-1为止的字串
    public int compareTo(IString str){
        int len1=curlen;
        int len2=str.length();
        int n=Math.min(len1, len2);
        char[]s1=strvalue;
        char[] s2=new char[str.length()];
        for(int i=0;i<str.length();i++)
            s2[i]=str.charAt(i);
        int k=0;
        while(k<n){
            char ch1=s1[k];
            char ch2=s2[k];
            if(ch1!=ch2){
                return ch1-ch2;
            }
            k++;
        }
        return len1-len2;
    }//将当前串与str比较
    public IString concat(IString str){
        return insert(curlen,str);
    }//添加指定串str到当前串尾
    public void myprint(){
        for(int i=0;i<curlen;i++){
            System.out.print(strvalue[i]);
        }
        System.out.println();
    }//打印
    
    
    //main函数
    public static void main(String[] args){
        seqstring T=new seqstring ("hello world!");
        System.out.print("串T=");
        T.myprint();
        System.out.print ("请输入需要插入的串S：" );
        Scanner scanner = new Scanner( System.in);
        String s = scanner.next();
        seqstring S=new seqstring (s);
        System.out.print("插入的串S=");
        S.myprint();
        System.out.print ("请输入需要插入的位置：" );
        int i = scanner.nextInt ();
        System.out.println("串T在第"+i+"个字符前插入S后,T=");
        T.insert(i,S).myprint();
        System.out.print ("请输入串S需要删除的位置（例:“2 3”为删除第2到第3个字符）：" );
        i=scanner.nextInt ();
        int j=scanner.nextInt ();
        System.out.println("串S删除第"+i+"到第"+j+"个字符后：");
        S.delete(i-1, j).myprint();
    }
    
}