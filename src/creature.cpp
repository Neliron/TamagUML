#include <iostream>
#include "../include/creature.h"

using namespace std;

Creature::Creature()
{
    name = "Lucifron";

    race.id = 1;
    race.raceName = "Demon";

    hunger = 100;
    morale = 100;
    focus = 100;
    status = 0;

    cout << name;
}

Creature::~Creature()
{
    //dtor
}

Creature::Creature(string choosedName, Type choosedRace)
{
    name = choosedName;
    race = choosedRace;

    hunger = 100;
    morale = 100;
    focus = 100;
    status = 0;
}

void Creature::setHunger(int newHunger)
{
    hunger = hunger + newHunger;
}

void Creature::setMorale(int newMorale)
{
    morale = morale + newMorale;
}

void Creature::setFocus(int newFocus)
{
    focus = focus + newFocus;
}

void Creature::setStatus(int newStatus)
{
    status = newStatus;
}
