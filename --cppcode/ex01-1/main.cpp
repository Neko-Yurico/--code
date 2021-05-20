#include<iostream>
using namespace std;
float compare(float *a,float &b)
{
    if (*a>b) return *a;
    else return b;
}
int main()
{
    float x,y;
    cout<<"请输入两个数:"<<endl;
    cin>>x>>y;
    cout<<"The max="<<compare(&x,y)<<endl;
    return 0;
}