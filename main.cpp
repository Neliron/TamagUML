#include <iostream>
#include "include/creature.h"
#include "include/environment.h"

using namespace std;

int main()
{

    Creature C("Belzebuth", 1);
    Environment E(2);

    cout << "You are " << C.getName() << " and you currently roam at " << E.getName() << "." << endl;
    cout << "Hunger : " << C.getHunger() << "." << endl;
    cout << "Morale : " << C.getMorale() << "." << endl;
    cout << "Focus : " << C.getFocus() << "." << endl;

    cout << endl;

    return 0;
}
