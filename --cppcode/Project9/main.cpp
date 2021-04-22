#include <iostream>
using namespace std;
//利用define定义需要计算的矩阵的大小
#define m  2 //m行
#define n  2 //n列
class circle{
public:
    circle ();//构造
    circle (int a[m][n]);//构造
    friend circle add(circle a ,int b[m][n]);//友元函数 加算
    void show();//输出
private :
    int p[m][n];//利用二维数组存放多个矩阵的元素
};

circle::circle ()//构造
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            p[i][j]=0;
        }
}

circle::circle (int a[m][n])//构造
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            p[i][j]=a[i][j];
        }
}

circle add(circle a,int b[m][n])//友元函数 加算
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            a.p[i][j]=a.p[i][j]+b[i][j];
        }
    return a;
}

void circle::show()//输出
{
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout<<p[i][j]<<" ";
        }
        cout<<"\n";
    }

}

int main()
{
    int i,j;
    int a[m][n],b[m][n];
    cout<<"请输入第一个"<<m<<"行"<<n<<"列矩阵内容:"<<endl;
    for(int i=0;i<m;i++)//输入第一个矩阵并保存在数组a中
        for(j=0;j<n;j++){
            cin>>a[i][j];
        }
    cout<<"请输入第二个"<<m<<"行"<<n<<"列矩阵内容:"<<endl;
    for(i=0;i<m;i++)//输入第二个矩阵并保存在数组b中
        for(j=0;j<n;j++){
            cin>>b[i][j];
        }
    circle aa;
    circle d(a);
    aa=add(d,b);//求和
    cout<<"两个矩阵之和为："<<endl;
    aa.show();//输出
    return 0;
}

