#include<iostream>
#define PI 3.14
using namespace std;
class Shape
{
public:
    virtual float printArea() const {return 0.0;};
};
class Circle:public Shape
{
public:
    Circle(float =0);
    virtual float printArea() const {return PI*radius*radius;}
protected:
    float radius;
};
Circle::Circle(float r):radius(r)
{
}
class Rectangle:public Shape
{
public:
    Rectangle(float =0,float =0);
    virtual float printArea() const;
protected:
    float height;
    float width;
};
Rectangle::Rectangle(float w,float h):width(w),height(h){
}
float Rectangle::printArea()const
{
    return width*height;
}
class Triangle:public Shape
{
public:
    Triangle(float =0,float =0);
    virtual float printArea() const;
protected:
    float height;
    float width;
};
Triangle::Triangle(float w,float h):width(w),height(h){
}
float Triangle::printArea()const
{
    return 0.5*width*height;
}
void printArea(const Shape&s)
{
    cout<<s.printArea()<<endl;
}
int main()
{
    float rr,ww,hh;
    cout<<"������Բ�İ뾶��"<<endl;
    cin>>rr;
    Circle circle(rr);
    cout<<"Բ�����Ϊ��";
    printArea(circle);
    cout<<"��������εĳ���"<<endl;
    cin>>ww>>hh;
    Rectangle rectangle(ww,hh);
    cout<<"�������Ϊ��";
    printArea(rectangle);
    ww=0;
    hh=0;
    cout<<"������ֱ��������ֱ�Ǳߵĳ���"<<endl;
    cin>>ww>>hh;
    Triangle triangle(ww,hh);
    cout<<"ֱ�����������Ϊ��";
    printArea(triangle);
}