#include <iostream>

using namespace std;

class ISubject{
public:
    virtual void action() = 0;
};

class RealClass : public ISubject {
public:
    void action() override {
        cout << "original action" << endl;
    }
};

class Proxy : public ISubject{
private:
    RealClass subject;
public:
    void action() override{
        subject.action();
        cout << "proxy action" << endl;
    }
};

int main(int argc, char* argv[]){
    Proxy subject;
    subject.action();
    return 0;
}