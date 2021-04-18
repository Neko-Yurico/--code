#include<iostream>
using namespace std;
const double PI =3.14159;
class Circle
{
public:
    Circle(double r); //注解：构造函数
    Circle (Circle &);//拷贝构造函数
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
    cout<<"请输入半径"<<endl;
    cin>>r;
    Circle c(r); //注解：构造函数在创建对象时自动调用，建议用这种方法初始化对象
    cout<<"圆周长为"<<c.Circumference()<<",圆面积为"<<c.Area()<<endl;
    Circle d(c); //拷贝
    cout<<"新的圆周长为"<<d.Circumference()<<",新的圆面积为"<<d.Area()<<endl;
    return 0;
}
