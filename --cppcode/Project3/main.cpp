#include<iostream>

using namespace std;

class Circle
{
public:
    void setR(double r) {//���ð뾶
        m_r = r;
    }
    static double getCircleGirth(double  r);
    static double getCircleArea(double  r);

private:
    double m_r;
};


double Circle ::getCircleGirth(double r) {//�����ܳ�
    return 2 * 3.14 * r;
}
double Circle ::getCircleArea(double r) {//�������
    return 3.14 * r * r;
}

int main() {
    Circle myclass{};
    double r;
    cout << "������Բ�İ뾶��" << endl;
    cin >> r;//����뾶
    myclass.setR(r);
    double girth,area;
    girth = myclass.getCircleGirth(r);//�����ܳ�
    area = myclass.getCircleArea(r);//�������
    cout << "Բ���ܳ�" << girth << endl;//����ܳ�
    cout << "Բ�����" << area << endl;//������
    return 0;
}