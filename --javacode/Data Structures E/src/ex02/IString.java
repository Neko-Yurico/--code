package ex02;

public interface IString {  //串的抽象数据类型使用java接口描述
    public void clear ( );
    
    public boolean isEmpty ( );
    
    public int length ( );
    
    public char charAt ( int index );   //取字符操作
    
    public IString substring ( int begin , int end );   //截取字符操作
    
    public IString insert ( int offset , IString str );  //插入操作
    
    public IString delete ( int begin , int end );   //删除操作
    
    public IString concat ( IString str );   //连接操作
    
    public int compareTo ( IString str );
    
    public void myprint ( );  //输出操作
    
}
