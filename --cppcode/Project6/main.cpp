#include<iostream>
using namespace std;

class Tx
{
public:
    Tx(int i, int j);
    ~Tx( );
    void display( );
private:
    int num1, num2;
};
Tx::Tx(int i, int j=10)
{
    num1=i;
    num2=j;
    cout<<"constructing:"<<num1<<","<<num2<<endl;
}
void Tx::display( )
{ cout<<"display:"<<num1<<","<<num2<<endl; }

Tx::~Tx( )
{
    cout<<"destructing:"<<num1<<","<<num2<<endl;
}
int main( )
{
    Tx t1(22,11);
    Tx t2(20);
    t1.display( );
    t2.display( );
    return 0;
}

