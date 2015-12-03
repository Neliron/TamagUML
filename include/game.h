#ifndef GAME_H
#define GAME_H
#include <string>
#include <fstream>
#include <iostream>
#include "creature.h"
#include "environment.h"

using namespace std;

class Game
{
    private:
        Creature C;
        Environment E;

    public:
        Game();
        ~Game();
        Game(string, Type);
        int timeLapsed();
        void increaseHungerValue(int);
        void increaseMoraleValue(int);
        void increaseFocusValue(int);
        void updateStatus();
        bool checkState();
        void displayGame();
        void saveGame();
        void loadGame();
};

#endif // GAME_H
