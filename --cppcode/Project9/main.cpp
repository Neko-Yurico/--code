#include <iostream>
using namespace std;
//����define������Ҫ����ľ���Ĵ�С
#define m  2 //m��
#define n  2 //n��
class circle{
public:
    circle ();//����
    circle (int a[m][n]);//����
    friend circle add(circle a ,int b[m][n]);//��Ԫ���� ����
    void show();//���
private :
    int p[m][n];//���ö�ά�����Ŷ�������Ԫ��
};

circle::circle ()//����
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            p[i][j]=0;
        }
}

circle::circle (int a[m][n])//����
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            p[i][j]=a[i][j];
        }
}

circle add(circle a,int b[m][n])//��Ԫ���� ����
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            a.p[i][j]=a.p[i][j]+b[i][j];
        }
    return a;
}

void circle::show()//���
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
    cout<<"�������һ��"<<m<<"��"<<n<<"�о�������:"<<endl;
    for(int i=0;i<m;i++)//�����һ�����󲢱���������a��
        for(j=0;j<n;j++){
            cin>>a[i][j];
        }
    cout<<"������ڶ���"<<m<<"��"<<n<<"�о�������:"<<endl;
    for(i=0;i<m;i++)//����ڶ������󲢱���������b��
        for(j=0;j<n;j++){
            cin>>b[i][j];
        }
    circle aa;
    circle d(a);
    aa=add(d,b);//���
    cout<<"��������֮��Ϊ��"<<endl;
    aa.show();//���
    return 0;
}

