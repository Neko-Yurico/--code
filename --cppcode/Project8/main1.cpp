#include<iostream>
using  namespace  std ;
class  A
{
    int  i;
public:
    A(int k=0){ i=k; i++;}
    int  list(){return  i;}
};
int  main()
{
    A  a1,a2,a3;
    cout<<a1.list()<<','<<a2.list()<<','<<a3.list();
    return 0;
}
