
public class Creature {

	private String name;
    private Type race;
    private int hunger;
    private int morale;
    private int focus;
    private int status;
    
    Creature()
    {
        name = "Lucifron";

        race.id = 1;
        race.raceName = "Demon";
        //displayerStatus = "Happy";

        hunger = 100;
        morale = 100;
        focus = 100;
        status = 0;
        
        //totalTimeLapsed = 0;
    }
    
    Creature(String choosedName, int choosedRace)
    {
        name = choosedName;
        if (choosedRace == 1)
        {
            race.raceName = "Demon";
            //displayerStatus = "Happy";
        }

        if (choosedRace == 2)
        {
            race.raceName = "Banshee";
            //displayerStatus = "Calm";
        }
        race.id = choosedRace;

        hunger = 100;
        morale = 100;
        focus = 100;
        status = 0;
        
        //totalTimeLapsed = 0;
    }
    
	void setHunger(int newHunger)
	{
		hunger = hunger + newHunger;
	    if (hunger > 100) hunger = 100;
	    if (hunger < 0) hunger = 0;
	}
	
	void setMorale(int newMorale)
	{
		morale = morale + newMorale;
	    if (morale > 100) morale = 100;
	    if (morale < 0) morale = 0;
	}
	
	void setFocus(int newFocus)
	{
		focus = focus + newFocus;
	    if (focus > 100) focus = 100;
	    if (focus < 0) focus = 0;
	}
	
	void setStatus(int newStatus)
	{
	    status = newStatus;
	}
	
	Type getRace()
	{
	    return this.race;
	}
	
	String getName()
	{
	    return this.name;
	}
	
	int getHunger()
	{
	    return this.hunger;
	}
	
	int getMorale()
	{
	    return this.morale;
	}
	
	int getFocus()
	{
	    return this.focus;
	}
	
	int getStatus()
	{
	    return this.status;
	}
    
	/*void newDisplayerStatus() // Le nom du statut actuel selon la race
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
	}*/
    
}
