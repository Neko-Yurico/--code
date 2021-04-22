#include<iostream>
using  namespace  std ;
class  A
{
    static  int  i;          // 定义静态数据成员
public:
    A(){i++;}
    int  list(){return  i;}
};
int  A::i=0;
int  main()
{
    A  a1,a2,a3;
    cout<<a1.list()<<','<<a2.list()<<','<<a3.list();
    return 0;
}


