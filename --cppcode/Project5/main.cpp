#include<iostream>
using namespace std;
const double PI =3.14159;
class Circle
{
public:
    Circle(double r); //ע�⣺���캯��
    Circle (Circle &);//�������캯��
    double Circumference();
    double Area();
private:
    double radius;
};
double Circle::Circumference()
{
    return 2*PI*radius;
}
double Circle::Area()
{
    return PI*radius*radius;
}
Circle::Circle(double r)
{
    radius=r;
}

Circle::Circle(Circle &other) {
    radius =other.radius;
}

int main()
{
    double r;
    cout<<"������뾶"<<endl;
    cin>>r;
    Circle c(r); //ע�⣺���캯���ڴ�������ʱ�Զ����ã����������ַ�����ʼ������
    cout<<"Բ�ܳ�Ϊ"<<c.Circumference()<<",Բ���Ϊ"<<c.Area()<<endl;
    Circle d(c); //����
    cout<<"�µ�Բ�ܳ�Ϊ"<<d.Circumference()<<",�µ�Բ���Ϊ"<<d.Area()<<endl;
    return 0;
}
