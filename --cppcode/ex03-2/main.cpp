#include <iostream>
#include <string>
#include <cmath>

using namespace std;

class student{
private:
    string name;
    int english;
    int computer;
public:
    void set(string a,int b,int c);
    void set(student &other);
    void print();
    int sum;
};
void student::set(string a, int b, int c) {
    name=a;
    english=b;
    computer=c;
    sum=c+b;
}

void student::set(student &other) {
    name=other.name;
    english=other.english;
    computer=other.computer;
    sum=other.english+other.computer;
}

void student::print() {
    cout<<"name="<<name<<" ";
    cout<<"english="<<english<<" ";
    cout<<"computer="<<computer<<" ";
    cout<<"sum="<<sum<<" ";
    cout<<endl;
}

void Sort(student a[], int n)
{
    student student1;
    for(int i = n - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (a[j].sum < a[j + 1].sum) {
                student1.set(a[j]);
                a[j].set(a[j+1]);
                a[j+1].set(student1);
            }
        }
    }
}

int main(){
    string a,num;
    int b,c,i;
    cout<<"please check the number of students:"<<endl;
    cin>>i;
    student s[i];
    cout<<"name+english+computer"<<endl;
    for (int j = 0; j < i; ++j) {
        cout<<"no."<<j+1<<":"<<endl;
        cin>>a>>b>>c;
        s[j].set(a,b,c);
    }
    Sort(s,i);
    for (int j = 0; j < i; ++j) {
        cout<<"no."<<j+1<<":";
        s[j].print();
    }
}