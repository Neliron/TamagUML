/**
 * 
 * @author TORO DAPP
 *
 */
public class Game {
	/**
	 * 
	 */
	private Creature C;
	/** */
    private Environment E;
    //private int totalTimeLapsed;
    
    /**
     * 
     */
    public Game()
    {
        this.C = new Creature("Lucifron", 1);
        this.E = new Environment(1);
    }
    /** */
    public Game(String Name, int raceId)
    {
    	this.C = new Creature(Name, raceId);
    	this.E = new Environment(raceId);
    }
    /** */
    public boolean checkState()
    {
       
        if (this.C.getHunger() <= 0) 
        	return false;
        if (this.C.getMorale() <= 0) 
        	return false;
        if (this.C.getFocus() <= 0) 
        	return false;

        return true;
    }
    /** */
    public void updateStatus()
    {
        int newStatus = 0;
        int veryBadLimit = 0;

        if (this.C.getHunger() < 25) {
        	newStatus = 1;
        	veryBadLimit++;
        }
        if (this.C.getMorale() < 25) {
        	newStatus = 2; 
        	veryBadLimit++;
        }
        if (this.C.getFocus() < 25) {
        	newStatus = 3;
        	veryBadLimit++;
        }
        if (veryBadLimit > 1) 
        	newStatus = 4;

        this.C.setStatus(newStatus);
    }
    /** */
    public void displayGame() // C'est la base du display. A remplacer au fur et à mesure...
    {
        System.out.println("You're " + this.C.getName() + " and you're now roaming at " + this.E.getName() + ".");
        System.out.println("Hunger : " + this.C.getHunger() + ".");
        System.out.println("Morale : " + this.C.getHunger() + ".");
        System.out.println("Focus : " + this.C.getHunger() + ".");
        System.out.println("Status : " + this.C.getHunger() + ".");
    }
    /** */
    public void saveGame()
    {
    	return;
    }
    /** */
    public void loadGame()
    {
    	return;
    	
    }
    
    /* void Game::saveGame() // On enregistre le plus important
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

            if(file) {
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

      
            int retrievedCommand

            if (retrievedCommand ==) {increaseHungerValue(100);}
            if (retrievedCommand ==) {increaseMoraleValue(100);}
            if (retrievedCommand ==) {increaseFocusValue(100);}
      


        if (race.id == 1)
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

}
