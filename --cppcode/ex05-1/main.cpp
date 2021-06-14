#include <iostream>
#include <windows.h>
using namespace std;

class Time{
private:
    int hh;
    int mm;
    int ss;
public:
    Time(int h=0,int m=0,int s=0){
        hh=h;
        mm=m;
        ss=s;
    }
    Time * operator++();
    void PrintTime(){
        cout<<hh<<":"<<mm<<":"<<ss<<endl;
    }
};

Time * Time::operator++() {
    ss=ss+1;
    if (ss==60){
        ss=0;
        mm+=1;
    }
    if (mm==60){
        mm=0;
        hh+=1;
    }
    if (hh==24){
        hh=0;
    }
    return this;
}


int main() {
    Time time(23,59,58);
    while (true){
        system("cls");
        time.PrintTime();
        ++time;
        Sleep(1000);
    }
}
