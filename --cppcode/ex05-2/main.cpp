#include<iostream>
#include<string>
using namespace std;
class animal {
public:
    animal(){
        cout << "Enter the sex:\n";
        cin >> sex;
    };
    virtual void soar() {};
    void eat() {cout << "animal eat" << endl;};

protected:
    string sex;
};
class tiger :public animal {
public:
    void soar() {
        cout << sex << " tiger soar" << endl;
    }
    void eat() {
        cout << sex << " tiger eat" << endl;
    }
};
class sheep :public animal {
public:
    void soar() {
        cout << sex << " sheep soar" << endl;
    }
    void eat() {
        cout << sex << " sheep eat" << endl;
    }
};
int main() {
    tiger t1, t2;
    sheep s1, s2;
    animal *animal[4] = { &t1, &s1, &t2, &s2 };
    for (int i = 0; i < 4; i++) {
        animal[i]->soar();
        animal[i]->eat();
    }
    return 0;
}
