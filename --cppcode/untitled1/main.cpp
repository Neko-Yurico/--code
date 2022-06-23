#include <iostream>
class base{
private:
    int n1;
protected:
    int k1;
public:
    base(){
        n1=0;
        k1=0;
    }
    void fun1(){
        std::cout<<n1<<k1<<std::endl;
    }
};
class d1: public base{
private:
    int n2;
protected:
    int k2;
public:
    d1(){
        n2=10;
        k1=11;
    }
    void fun2(){
        std::cout<<n1<<k1<<std::endl;
        std::cout<<n2<<k2<<std::endl;
    }
};
class d2: public d1{
private:
    int n3;
protected:
    int k3;
public:
    d2(){
        n3=20;
        k3=21;
    }
    void fun2(){
        std::cout<<n1<<k1<<std::endl;
        std::cout<<n3<<k3<<std::endl;
    }
};
