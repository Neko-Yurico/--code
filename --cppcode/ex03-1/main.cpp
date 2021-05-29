#include <iostream>

using namespace std;

class circle{
public:
    circle();

    circle(int a[2][2]);

    friend circle add(circle a,circle b);

    void show();

private :
    int p[2][2];
};

circle::circle(){
    for(int i=0;i<2;i++)
        for(int j=0;j<2;j++){
            p[i][j]=0;
        }
}

circle::circle(int a[2][2]){
    for(int i=0;i<2;i++)
        for(int j=0;j<2;j++){
            p[i][j]=a[i][j];
        }
}

circle add(circle a,circle b){
    circle c;
    for(int i=0;i<2;i++)
        for(int j=0;j<2;j++){
            c.p[i][j]=a.p[i][j]+b.p[i][j];
        }
    return c;
}

void circle::show(){
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            cout<<p[i][j]<<" ";
        }
        cout<<"\n";
    }

}

int main(){
    int i,j;
    int a[2][2],b[2][2];
    cout<<"first circle:"<<endl;
    for(int i=0;i<2;i++)
        for(j=0;j<2;j++){
            cin>>a[i][j];
        }
    cout<<"second circle:"<<endl;
    for(i=0;i<2;i++)
        for(j=0;j<2;j++){
            cin>>b[i][j];
        }
    circle aa;
    circle d(a),e(b);
    aa=add(d,e);
    cout<<"sum:"<<endl;
    aa.show();
    return 0;
}
