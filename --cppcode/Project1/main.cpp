//
// Created by Yurico on 2021/4/1.
//

#include <iostream>

using  namespace  std ;

class  timer{
private:
    int  hh;//小时
    int  mm;//分钟
    int  ss;//秒钟
public:
    //声明构造函数
    void  set(int  h,int  m,int  s);//设置时间构造函数
    void  showtime() const;//显示时间
};

void  timer ::set(int h, int m, int s) {//设置时间构造函数
    hh = h;
    mm = m;
    ss = s;
    if (h > 23 || h < 0)
    {
        cout << "h时间有误" << endl;
    }
    if (m > 59 || m < 0)
    {
        cout << "m时间有误" << endl;
    }
    if (s > 59 || s < 0)
    {
        cout << "s时间有误" << endl;
    }
}

void  timer ::showtime() const {//显示时间
    cout << "当前的时间为：" << hh << ":" << mm << ":" << ss << endl;
}

int  main()
{
    cout << "请输入时间（时 分 秒）" <<endl;
    int a,b,c;
    cin >> a >> b >> c;//输入时间
    timer t{};//定义对象
    t .set(a,b,c);//设置时间
    t .showtime();//显示时间
    return 0;
}

