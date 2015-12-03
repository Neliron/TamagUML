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

    totalTimeLapsed = 0;
    displayerStatus = "Happy";
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
        displayerStatus = "Happy";
    }

    if (choosedRace == 2)
    {
        race.raceName = "Banshee";
        displayerStatus = "Calm";
    }
    race.id = choosedRace;

    hunger = 100;
    morale = 100;
    focus = 100;
    status = 0;

    totalTimeLapsed = 0; // Nouvelle créature. Le temps est à zéro.
}

void Creature::setHunger(int newHunger)
{
    hunger = hunger + newHunger;
    if (hunger > 100) hunger = 100;
    if (hunger < 0) hunger = 0;
}

void Creature::setMorale(int newMorale)
{
    morale = morale + newMorale;
    if (morale > 100) morale = 100;
    if (morale < 0) morale = 0;
}

void Creature::setFocus(int newFocus)
{
    focus = focus + newFocus;
    if (focus > 100) focus = 100;
    if (focus < 0) focus = 0;
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

string Creature::getStatus()
{
    return displayerStatus;
}

int Creature::getTotalTimeLapsed()
{
    return totalTimeLapsed;
}

void Creature::newDisplayerStatus() // Le nom du statut actuel selon la race
{
    if (race.id == 1)
        {
            if (status == 0) displayerStatus = "Happy";
            if (status == 1) displayerStatus = "Hungry";
            if (status == 2) displayerStatus = "Hateful";
            if (status == 3) displayerStatus = "Afraid";
            if (status == 4) displayerStatus = "Agonising";
        }

    if (race.id == 2)
        {
            if (status == 0) displayerStatus = "Calm";
            if (status == 1) displayerStatus = "Weakened";
            if (status == 2) displayerStatus = "Sad";
            if (status == 3) displayerStatus = "Wrathful";
            if (status == 4) displayerStatus = "Desperate";
        }
}
