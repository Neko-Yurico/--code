#include<iostream>
using namespace std;

class SwimmingPool{
private:
    float length;
    float width;
public:
    SwimmingPool(float a,float b);//���ó����ֵ
    void put_pool() const;//��ӡӾ�س���
    void aisle() const;//������������۸�
};

SwimmingPool::SwimmingPool(float a,float b)//���ó����ֵ
{
    length=a;
    width=b;
}
void SwimmingPool::put_pool() const//��ӡӾ�س���
{
    cout<<"Ӿ�س�Ϊ��"<<length<<" Ӿ�ؿ�Ϊ��"<<width<<endl;
}
void SwimmingPool::aisle() const//������������۸�
{
    float l,w,s1,s2;
    l=length+4;
    w=width+4;
    s1=length*width;
    s2=l*w;
    cout<<"Ӿ�����Ϊ��"<<s1<<endl;
    cout<<"�������Ϊ��"<<s2<<'\t';
    cout<<"���ã�"<<(s2-s1)*30<<endl;
}
int main()
{
    float a,b;
    cout<<"������Ӿ�س���"<<endl;
    cin>>a>>b;
    SwimmingPool A(a,b);
    A.put_pool();
    A.aisle();
}

