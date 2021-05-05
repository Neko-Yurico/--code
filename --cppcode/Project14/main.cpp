#include<iostream>
using namespace std;
class base
{ public:
    base()
    {cout<<"this is base class!\n";}
};
class base2
{ public:
    base2()
    {cout<<"this is base2 class!\n";}
};
class level1:public base2,virtual public base
{ public:
    level1():base2(),base()
    {cout<<"this is level1 class!\n";}
};
class level2:public base2,virtual public base
{ public:
    level2()
    {cout<<"this is level2 class!\n";}
};
class toplevel:public level1,virtual public level2
{ public:
    toplevel():level1(),level2()
    {cout<<"this is toplevel class!\n";}
};
int main()
{  toplevel topobj; }
