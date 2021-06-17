#include <iostream>
#include <fstream>
#include <string>
using namespace std;
class message{
public:
    char msg[1000];
    friend ostream & operator <<(ostream &out,message &s);
    friend istream & operator >>(istream &in,message &s);
};

ostream &operator<<(ostream &out, message &s) {
    out<<s.msg;
    return out;
}

istream &operator>>(istream &in, message &s) {
    in>>s.msg;
    return in;
}

int main() {
    ofstream ofile;
    ifstream ifile;
    ofile.open("d:\\message.txt",ios::app);
    ofile.close();
    message msg{};
    string b;
    cout<<"Read the file:"<<endl;
    ifile.open("d:\\message.txt",ios::in);
    while (!ifile.eof()){
        ifile>>msg;
    }
    cout<<msg<<endl;
    ifile.close();
    cout<<"Please choose whether to save the contents of the original file(y/n):";
    cin>>b;
    cout<<"Please input your message:"<<endl;
    if (b =="y"){
        ofile.open("d:\\message.txt",ios::app);
        cin>>msg;
        ofile<<msg;
        ofile.close();
    } else {
        ofile.open("d:\\message.txt",ios::trunc);
        cin>>msg;
        ofile<<msg;
        ofile.close();
    }
}
