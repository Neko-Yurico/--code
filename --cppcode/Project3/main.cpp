#include<iostream>

using namespace std;

class Circle
{
public:
    void setR(double r) {//设置半径
        m_r = r;
    }
    static double getCircleGirth(double  r);
    static double getCircleArea(double  r);

private:
    double m_r;
};


double Circle ::getCircleGirth(double r) {//计算周长
    return 2 * 3.14 * r;
}
double Circle ::getCircleArea(double r) {//计算面积
    return 3.14 * r * r;
}

int main() {
    Circle myclass{};
    double r;
    cout << "请输入圆的半径：" << endl;
    cin >> r;//输入半径
    myclass.setR(r);
    double girth,area;
    girth = myclass.getCircleGirth(r);//计算周长
    area = myclass.getCircleArea(r);//计算面积
    cout << "圆的周长" << girth << endl;//输出周长
    cout << "圆的面积" << area << endl;//输出面积
    return 0;
}