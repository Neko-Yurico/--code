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
//    ��ֵ����obj��n=5,�����
    Base1 base1;
    base1.n=5;
    base1.fun();
//    ��ֵ����Base1��n=5,�����
    Base2 base2;
    base2.n=5;
    base2.fun();
//    ��ֵ����Base2��n=5,�����
}
