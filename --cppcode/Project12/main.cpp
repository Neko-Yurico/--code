#include<iostream>

using namespace std;

class base{
protected:
    int k1;
    int n1;
public:
    base(){
        n1=0;
        k1=1;
    }
    void fun1(){cout<<n1<<k1<<endl;}
};

class d1:public base {
protected:
    int k2;
    int n2;
public:
    d1() {
        n2 = 10;
        k1 = 11;
    }
    void fun2() {
        cout << n1 << k1 << endl;
        cout << n2 << k2 << endl;
    }
};

class d2:public d1{
private:
    int n3;
protected:
    int k3;
public:
    d2(){
        n3=20;
        k3=21;
    }
    void fun3(){
        cout<<n1<<k1<<endl;
        cout<<n2<<k2<<endl;
        cout<<n3<<k3<<endl;
    }
};