//#include <iostream>
//#include <fstream>
//#include <string>
//using namespace std;
//class message{
//public:
//    char msg;
//    friend ostream & operator <<(ostream &out,message &s);
//    friend istream & operator >>(istream &in,message &s);
//};
//
//ostream &operator<<(ostream &out, message &s) {
//    out<<s.msg;
//    return out;
//}
//
//istream &operator>>(istream &in, message &s) {
//    in>>s.msg;
//    return in;
//}
//
//int main() {
//    message msg;
//    string b;
//    cout<<"Please choose whether to save the contents of the original file(y/n):";
//    cin>>b;
//    if (b =="y"){
//        ifstream ifs("D:\\message.txt",ios::ate);
//        cout<<"read the file:"<<endl;
//        ifs>>msg;
//        while (!ifs.eof()){
//            cout<<msg;
//            ifs>>msg;
//        }
//        cout<<"\n";
//        ifs.close();
//        ofstream ofs("D:\\message.txt",ios::ate);
//        cout<<"please input the message:"<<endl;
//        cin>>msg;
//        ofs<<msg;
//        ofs.close();
//    } else {
//        ifstream ifs("D:\\message.txt",ios::trunc);
//        cout<<"read the file:"<<endl;
//        ifs>>msg;
//        while (!ifs.eof()){
//            cout<<msg;
//            ifs>>msg;
//        }
//        cout<<"\n";
//        ifs.close();
//        ofstream ofs("D:\\message.txt",ios::trunc);
//        cout<<"please input the message:"<<endl;
//        cin>>msg;
//        ofs<<msg;
//        ofs.close();
//    }
//
//}
