#include <string>
#include "../include/game.h"

using namespace std;

Game::Game()
{
    Creature C("Lucifron", 1);
    Environment E(1);
}

Game::Game(string Name, Type race)
{
    Creature C(Name, race.id);
    Environment E(race.id);
}

bool Game::checkState()
{
    int lethalLimit = 0;

    if (C.getHunger() <= 0) {lethalLimit++;}
    if (C.getMorale() <= 0) {lethalLimit++;}
    if (C.getFocus() <= 0) {lethalLimit++;}

    if (lethalLimit >= 1) return false;
    else return true;
}

void Game::updateStatus()
{
    int newStatus = 0;
    int veryBadLimit = 0;

    if (C.getHunger() < 25) {newStatus = 1; veryBadLimit++;}
    if (C.getMorale() < 25) {newStatus = 2; veryBadLimit++;}
    if (C.getFocus() < 25) {newStatus = 3; veryBadLimit++;}
    if (veryBadLimit >= 2) newStatus = 4;
}
