#include <iostream>

using  namespace  std ;

class  timer{
private:
    int  hh;//Сʱ
    int  mm;//����
    int  ss;//����
public:
    //�������캯��
    timer(int  h,int  m,int  s);//����ʱ�乹�캯��
    void  showtime() const;//��ʾʱ��
};

timer ::timer(int h, int m, int s) {//����ʱ�乹�캯��
    hh = h;
    mm = m;
    ss = s;
    if (h > 23 || h < 0)
    {
        cout << "hʱ������" << endl;
    }
    if (m > 59 || m < 0)
    {
        cout << "mʱ������" << endl;
    }
    if (s > 59 || s < 0)
    {
        cout << "sʱ������" << endl;
    }
}

void  timer ::showtime() const {//��ʾʱ��
    cout << "��ǰ��ʱ��Ϊ��" << hh << ":" << mm << ":" << ss << endl;
}

int  main()
{
    cout << "������ʱ�䣨ʱ �� �룩" <<endl;
    int a,b,c;
    cin >> a >> b >> c;//����ʱ��
    timer t{a,b,c};//�������
    t .showtime();//��ʾʱ��
    return 0;
}
