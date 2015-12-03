#include <string>
#include <fstream>
#include <iostream>
#include "include/creature.h"
#include "include/environment.h"
#include "include/game.h"

using namespace std;

int main()
{
    Game G;
    G.increaseHungerValue(-110); // Test pour voir si on tombe en dessous de zéro
    G.saveGame();
    G.loadGame(); // Attention. Le temps écoulé entre la sauvegarde et son chargement sera = 0
    // Pour voir le temps s'écouler, mettre la sauvegarde, puis au deuxième essai la passer en comments

    return 0;
}
