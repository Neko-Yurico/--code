#include <iostream>
#include <cstring>
using namespace  std;

class StudentID{
public:
    StudentID(int id=0)          // 带缺省参数的构造函数
    {
        value=id;
        cout <<"Assigning student id " <<value <<endl;
    }
    ~StudentID()
    {
        cout <<"Destructing id " <<value <<endl;
    }
private:
    int value;
};

class Student{
public:
    Student(char* pName="no name",int ssID=0):id(ssID)
    {
        cout <<"Constructing student " <<pName <<endl;
        strncpy(name,pName,sizeof(name));
        name[sizeof(name)-1]='\n';
    }
    ~Student()
    {cout<<"Deconstructing student  "<<name<<endl;}
protected:
    char name[20];
    StudentID(id);                  // 对象成员
};

int main()
{
    Student s("wang",9901);
    Student t("li");
    return 0;
}
