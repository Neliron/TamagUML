#include <string>
#include <fstream>
#include <iostream>
#include <time.h>
#include "../include/game.h"

using namespace std;

Game::Game()
{
    Creature C("Lucifron", 1);
    Environment E(1);
}

Game::~Game()
{
}

Game::Game(string Name, Type race)
{
    Creature C(Name, race.id);
    Environment E(race.id);
}

bool Game::checkState() // On check la survie de la créature
{
    int lethalLimit = 0;

    if (C.getHunger() <= 0) {lethalLimit++;}
    if (C.getMorale() <= 0) {lethalLimit++;}
    if (C.getFocus() <= 0) {lethalLimit++;}

    if (lethalLimit >= 1) return false;
    else return true;
}

void Game::updateStatus() // On adapte le statut selon le niveau de nos trois jauges
{
    int newStatus = 0;
    int veryBadLimit = 0;

    if (C.getHunger() < 25) {newStatus = 1; veryBadLimit++;}
    if (C.getMorale() < 25) {newStatus = 2; veryBadLimit++;}
    if (C.getFocus() < 25) {newStatus = 3; veryBadLimit++;}
    if (veryBadLimit >= 2) newStatus = 4;

    C.setStatus(newStatus);
}

void Game::increaseHungerValue(int increasingHunger)
{
    C.setHunger(increasingHunger);
}

void Game::increaseMoraleValue(int increasingMorale)
{
    C.setMorale(increasingMorale);
}

void Game::increaseFocusValue(int increasingFocus)
{
    C.setFocus(increasingFocus);
}

void Game::displayGame() // C'est la base du display. A remplacer au fur et à mesure...
{
    cout << "You're " << C.getName() << " and you're now roaming at " << E.getName() << "." << endl;
    cout << "Hunger : " << C.getHunger() << "." << endl;
    cout << "Morale : " << C.getMorale() << "." << endl;
    cout << "Focus : " << C.getFocus() << "." << endl;
    cout << "Status : " << C.getStatus() << "." << endl;
}

void Game::saveGame() // On enregistre le plus important
{
    ofstream file("save.txt", ios::out | ios::trunc);
        if(file)
        {
            file << time(NULL) << endl; // L'heure de la sauvegarde via la fonction time(NULL)
            file << C.getName() << endl; // Le nom de la créature
            file << E.getSector() << endl; // L'identifiant du secteur environnement
            file << C.getHunger() << endl; // La faim
            file << C.getMorale() << endl; // Le moral
            file << C.getFocus() << endl; // Le focus
            file << C.getTotalTimeLapsed() << endl; // Le temps total de jeu de la créature

            file.close();
        }
        else cerr << "We can't open this file... Sawy." << endl; // Mogor !
}

void Game::loadGame() // Pour l'instant ça ne charge que le temps.
{
    ifstream file("save.txt", ios::in);

        if(file)
        {
            int timing;
            file >> timing; // On récupère le temps dans le fichier (il est en première ligne)

            int actualTime = time(NULL); // On récupère l'heure actuelle
            actualTime = actualTime - timing; // On compare les deux...
            cout << actualTime; // On a donc le temps écoulé depuis la sauvegarde !

            file.close();
        }
        else cerr << "We can't open this file... Sawy." << endl; // Mogor !
}


// We'll need this later. C'est la base de l'interpréteur de commandes.

  /*
        int retrievedCommand

        if (retrievedCommand ==) {increaseHungerValue(100);}
        if (retrievedCommand ==) {increaseMoraleValue(100);}
        if (retrievedCommand ==) {increaseFocusValue(100);}
  */


  /*  if (race.id == 1)
        {
            if (status == 0) displayerStatus = "Hunt some puny humans";
            if (status == 1) displayerStatus = "Fight a bunch of angels";
            if (status == 2) displayerStatus = "Pray the mighty Satan";
        }

    if (race.id == 2)
        {
            if (status == 0) displayerStatus = "Reap a few souls";
            if (status == 1) displayerStatus = "Possess a mortal";
            if (status == 2) displayerStatus = "Haunt an old crypt";
        } */
