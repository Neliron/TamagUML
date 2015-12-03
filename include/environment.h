#ifndef ENVIRNOMENT_H
#define ENVIRNOMENT_H
#include <string>
#include "creature.h"

using namespace std;

class Environment
{
    private:
        string name;
        int sector;

        int decreaseHunger;
        int decreaseMorale;
        int decreaseFocus;

    public :
        Environment();
        ~Environment();
        Environment(int);
        string getName();
        int getSector();
        int getDecreaseHunger();
        int getDecreaseMorale();
        int getDecreaseFocus();
};

#endif // ENVIRNOMENT_H
