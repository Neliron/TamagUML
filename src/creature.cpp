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
}

Creature::~Creature()
{
    //dtor
}

Creature::Creature(string choosedName, int choosedRace)
{
    name = choosedName;
    if (choosedRace == 1)
    {
        race.raceName = "Demon";
    }

    if (choosedRace == 2)
    {
        race.raceName = "Banshee";
    }
    race.id = choosedRace;

    cout << race.raceName << endl;

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

Type Creature::getRace()
{
    return race;
}

string Creature::getName()
{
    return name;
}

int Creature::getHunger()
{
    return hunger;
}

int Creature::getMorale()
{
    return morale;
}

int Creature::getFocus()
{
    return focus;
}

int Creature::getStatus()
{
    return status;
}
