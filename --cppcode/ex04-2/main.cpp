#include<iostream>
#include<cstring>

using namespace std;

class Student{
private:
    string SchoolNumber;
    string Name;
    string Gender;
    string SchoolName;
    string AdmissionTime;
public:
    Student(string="", string="", string="", string="", string="");

    virtual string getInfo(){
        return "SchoolNumber:"+SchoolNumber+"\tName:"+Name+"\tGender:"+Gender+"\tSchoolName:"+SchoolName+
               "\tAdmissionTime:"+AdmissionTime;
    }
};

Student::Student(string a, string b, string c, string d, string e) : SchoolNumber(a), Name(b), Gender(c), SchoolName(d),
                                                                     AdmissionTime(e){}

class Graduate : public Student{
private:
    string GraduationTime;
    string DegreeInfo;
public:
    Graduate(string ="", string="", string ="", string="", string ="", string ="", string="");

    virtual string getInfo(Student &s){
        return s.getInfo()+"\nGraduationTime:"+GraduationTime+"\tDegreeInfo:"+DegreeInfo;
    }
};

Graduate::Graduate(string a, string b, string c, string d, string e, string f, string g) : Student(a, b, c, d, e),
                                                                                           GraduationTime(f),
                                                                                           DegreeInfo(g){}

void printCircumference(Graduate &s, Student &ss){
    cout<<ss.getInfo()<<endl;
}

void printCircumference(Student &s){
    cout<<s.getInfo()<<endl;
}

int main(){
    string rr, ww, hh, gg, qq, ee, tt;
    char zz[1];
    cout<<"Student's Info:SchoolNumber,Name,Gender,SchoolName,AdmissionTime"<<endl;
    cin>>rr>>ww>>hh>>gg>>qq;
    Student student(rr, ww, hh, gg, qq);
    cout<<"is graduate?(y/n)"<<endl;
    cin>>zz;
    if(strcmp(zz, "y")==0){
        cout<<"Student's Info:GraduationTime,DegreeInfo"<<endl;
        cin>>ee>>tt;
        Graduate graduate(rr, ww, hh, gg, qq, ee, tt);
        cout<<"info:";
        printCircumference(graduate, student);
    }else{
        cout<<"info:";
        printCircumference(student);
    }
}
