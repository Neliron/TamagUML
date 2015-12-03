#include <iostream>
#include "../include/environment.h"

using namespace std;

Environment::Environment()
{
    name = "Satan's Gardens";
    sector = 1;

    decreaseHunger = 1;
    decreaseMorale = 1;
    decreaseFocus = 2;
}

Environment::~Environment()
{
    //dtor
}

Environment::Environment(int draftLand)
{
    switch (draftLand)
    {
    case 1 :
        name = "Satan's Gardens";
        sector = 1;

        decreaseHunger = 1;
        decreaseMorale = 1;
        decreaseFocus = 2;
        break;

    case 2 :
        name = "Heights of Limbo";
        sector = 2;

        decreaseHunger = 1;
        decreaseMorale = 2;
        decreaseFocus = 1;
        break;

    case 3 :
        name = "Burning Grounds";
        sector = 3;

        decreaseHunger = 2;
        decreaseMorale = 1;
        decreaseFocus = 1;
        break;
    }
}

string Environment::getName()
{
    return name;
}

int Environment::getSector()
{
    return sector;
}

int Environment::getDecreaseHunger()
{
    return decreaseHunger;
}

int Environment::getDecreaseMorale()
{
    return decreaseMorale;
}

int Environment::getDecreaseFocus()
{
    return decreaseFocus;
}
