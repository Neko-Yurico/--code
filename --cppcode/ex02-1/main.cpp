#include <iostream>
#include <string>

using namespace std;

class student{
private:
    string number;
    string name;
    int math;
    int english;
    int computer;
public:
    int average();

    int sum();

    void print();

    string get_reg_num();

    void set_stu_inf(string a,string b,int c,int d,int e);
};

int student::average(){
    return (sum())/3;
}

int student::sum(){
    return math+computer+english;
}

void student::print(){
    cout<<"number="<<get_reg_num()<<" ";
    cout<<"name="<<name<<" ";
    cout<<"math="<<math<<" ";
    cout<<"english="<<english<<" ";
    cout<<"computer="<<computer<<" ";
    cout<<"average="<<average()<<" ";
    cout<<"sum="<<sum()<<" ";
    cout<<endl;
}

string student::get_reg_num(){
    return number;
}

void student::set_stu_inf(string a,string b,int c,int d,int e){
    number=a;
    name=b;
    math=c;
    english=d;
    computer=e;
}

int main(){
    string a,b,num;
    int c,d,e,i,as=0,ms=0,aa;
    cout<<"please check the number of students:"<<endl;
    cin>>i;
    student s[i];
    cout<<"num+name+math+english+computer"<<endl;
    for(int j=0;j<i;++j){
        cout<<"no."<<j+1<<":"<<endl;
        cin>>a>>b>>c>>d>>e;
        s[j].set_stu_inf(a,b,c,d,e);
        as+=s[j].sum();
        if(s[j].sum()>ms){
            ms=s[j].sum();
        }
    }
    aa=as/i;
    cout<<"highest score:"<<ms<<" average score:"<<aa<<endl;
    cout<<"check the number:"<<endl;
    cin>>num;
    for(int j=0;j<i;++j){
        if(num==s[j].get_reg_num()){
            s[j].print();
        }
    }
}