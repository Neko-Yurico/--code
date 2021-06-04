#include<iostream>

#define PI 3.14
using namespace std;

class Graphics{
public:
    virtual float printCircumference(){return 0.0;};
};

class Circle:public Graphics{
public:
    Circle(float =0);

    virtual float printCircumference(){return 2*PI*radius;}

protected:
    float radius;
};

Circle::Circle(float r):radius(r){}

class Rectangle:public Graphics{
public:
    Rectangle(float =0,float =0);

    virtual float printCircumference();

protected:
    float height;
    float width;
};

Rectangle::Rectangle(float w,float h):width(w),height(h){}

float Rectangle::printCircumference(){
    return 2*(width+height);
}

class Triangle:public Graphics{
public:
    Triangle(float =0,float =0,float =0);

    virtual float printCircumference();

protected:
    float aa;
    float bb;
    float cc;
};

Triangle::Triangle(float a,float b,float c):aa(a),bb(b),cc(c){}

float Triangle::printCircumference(){
    return aa+bb+cc;
}

class Elliptical:public Graphics{
public:
    Elliptical(float =0,float =0);

    virtual float printCircumference();

protected:
    float aa;
    float bb;
};

Elliptical::Elliptical(float a,float b):aa(a),bb(b){}

float Elliptical::printCircumference(){
    return 2*PI*bb+4*(aa-bb);
}

void printCircumference(Graphics&s){
    cout<<s.printCircumference()<<endl;
}

int main(){
    float rr,ww,hh;
    cout<<"Circle's radius:"<<endl;
    cin>>rr;
    Circle circle(rr);
    cout<<"Circumference:";
    printCircumference(circle);
    cout<<"Rectangle's weight and height:"<<endl;
    cin>>ww>>hh;
    Rectangle rectangle(ww,hh);
    cout<<"Circumference:";
    printCircumference(rectangle);
    rr=0;
    ww=0;
    hh=0;
    cout<<"Triangle's three Edge length:"<<endl;
    cin>>rr>>ww>>hh;
    Triangle triangle(rr,ww,hh);
    cout<<"Circumference:";
    printCircumference(triangle);
    ww=0;
    hh=0;
    cout<<"Elliptical's long half shaft and short half shaft:"<<endl;
    cin>>ww>>hh;
    Elliptical elliptical(ww,hh);
    printCircumference(elliptical);
}
