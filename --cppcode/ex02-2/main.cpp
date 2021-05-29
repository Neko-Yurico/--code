#include<iostream>
#include<cmath>
using namespace std;

class Complex{
private:
    double re;
    double im;
public:
    Complex(double real,double image){
        re=real;
        im=image;
    }

    Complex(Complex&other){
        re=other.re;
        im=other.im;
    }

    float mo(){
        return sqrt(re*re+im*im);
    }

    void show(){
        cout<<"("<<re<<","<<im<<")"<<endl;
        cout<<"the mo is:"<<mo();
    }
};

int main(){
    double A,B;
    cout<<"enter the re:";
    cin>>A;
    cout<<endl<<"enter the im:";
    cin>>B;
    Complex C(A,B);
    Complex D(C);
    D.show();
}