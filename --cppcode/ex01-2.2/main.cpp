#include <iostream>
using namespace std;
int  max(int a=0,int b=0,int c=0){
    if(b>a)a=b;
    if(c>a)a=c;
    return a;
}
double  max(double a=0,double b=0,double c=0){
    if(b>a)a=b;
    if(c>a)a=c;
    return a;
}
long  max(long a=0,long b=0,long c=0){
    if(b>a)a=b;
    if(c>a)a=c;
    return a;
}
int main(){
    int i1,i2,i3,i;
    double d1,d2,d3,d;
    long g1,g2,g3,g;
    cout<<"请输入三个int:"<<endl;
    cin>>i1>>i2>>i3;
    cout<<"请输入三个double:"<<endl;
    cin>>d1>>d2>>d3;
    cout<<"请输入三个long:"<<endl;
    cin>>g1>>g2>>g3;
    i=max(i1,i2,i3);
    d=max(d1,d2,d3);
    g=max(g1,g2,g3);
    cout <<"i_max="<<i<<endl;
    cout <<"d_max="<<d<<endl;
    cout <<"g_max="<<g<<endl;
    return 0;
}