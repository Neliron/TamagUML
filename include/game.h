#ifndef GAME_H
#define GAME_H
#include <string>
#include "creature.h"
#include "environment.h"

using namespace std;

class Game
{
    private:
        Creature C;
        Environment E;

        Game();
        ~Game();
        Game(string, Type);
        int timeLapsed();
        int totalTimeLapsed();
        int increaseHungerValue();
        int increaseMoralValue();
        int increaseFocusValue();
        void updateStatus();
        bool checkState();
};

#endif // GAME_H
