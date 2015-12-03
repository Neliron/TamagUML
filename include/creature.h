#ifndef CREATURE_H
#define CREATURE_H
#include <string>

using namespace std;

struct Type
{
    int id;
    string raceName;
};

class Creature
{
    private:
        string name;
        Type race;
        int hunger;
        int morale;
        int focus;
        int status;

    public:
        Creature();
        ~Creature();
        Creature(string, int);
        void setHunger(int);
        void setMorale(int);
        void setFocus(int);
        void setStatus(int);
        Type getRace();
        string getName();
        int getHunger();
        int getMorale();
        int getFocus();
        int getStatus();
};



#endif // CREATURE_H
