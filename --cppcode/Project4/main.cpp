#include<iostream>
using namespace std;

class SwimmingPool{
private:
    float length;
    float width;
public:
    SwimmingPool(float a,float b);//设置长宽的值
    void put_pool() const;//打印泳池长宽
    void aisle() const;//计算输出过道价格
};

SwimmingPool::SwimmingPool(float a,float b)//设置长宽的值
{
    length=a;
    width=b;
}
void SwimmingPool::put_pool() const//打印泳池长宽
{
    cout<<"泳池长为："<<length<<" 泳池宽为："<<width<<endl;
}
void SwimmingPool::aisle() const//计算输出过道价格
{
    float l,w,s1,s2;
    l=length+4;
    w=width+4;
    s1=length*width;
    s2=l*w;
    cout<<"泳池面积为："<<s1<<endl;
    cout<<"过道面积为："<<s2<<'\t';
    cout<<"费用："<<(s2-s1)*30<<endl;
}
int main()
{
    float a,b;
    cout<<"请输入泳池长宽："<<endl;
    cin>>a>>b;
    SwimmingPool A(a,b);
    A.put_pool();
    A.aisle();
}

