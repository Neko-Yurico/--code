#include <iostream>
using namespace std;
template <typename T>
T max(T a,T b,T c){
    if(b>a)a=b;
    if(c>a)a=c;
    return a;
}
int main(){
    int i1,i2,i3,i;
    double d1,d2,d3,d;
    long g1,g2,g3,g;
    cout<<"3int:"<<endl;
    cin>>i1>>i2>>i3;
    cout<<"3double:"<<endl;
    cin>>d1>>d2>>d3;
    cout<<"3long:"<<endl;
    cin>>g1>>g2>>g3;
    i=max(i1,i2,i3);
    d=max(d1,d2,d3);
    g=max(g1,g2,g3);
    cout <<"i_max="<<i<<endl;
    cout <<"d_max="<<d<<endl;
    cout <<"g_max="<<g<<endl;
    return 0;
}