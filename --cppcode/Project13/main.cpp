#include<iostream>
using namespace std;
class Base1
{ public:
    int n;
    void fun(){cout<<"Base1, n="<<n<<endl;}
};
class Base2
{ public:
    int n;
    void fun(){cout<<"Base2, n="<<n<<endl;}
};
class Derive: public Base1, public Base2
{ public:
    int n;
    void fun(){cout<<"Derive, n="<<n<<endl;}
};
int main()
{ Derive obj;
    obj.n=5;
    obj.fun();
//    赋值对象obj的n=5,并输出
    Base1 base1;
    base1.n=5;
    base1.fun();
//    赋值基类Base1的n=5,并输出
    Base2 base2;
    base2.n=5;
    base2.fun();
//    赋值基类Base2的n=5,并输出
}
