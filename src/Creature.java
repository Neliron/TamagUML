
public class Creature {

	private String name;
    private Type race;
    private int hunger;
    private int morale;
    private int focus;
    private int status;
    
    public Creature()
    {
        this.name = "Lucifron";

        this.race.id = 1;
        this.race.raceName = "Demon";
        //displayerStatus = "Happy";

        this.hunger = 100;
        this.morale = 100;
        this.focus = 100;
        this.status = 0;
        
        //totalTimeLapsed = 0;
    }
    
   public Creature(String choosedName, int choosedRace)
    {
    	this.name = choosedName;
        if (choosedRace == 1)
        {
        	this.race.raceName = "Demon";
            //displayerStatus = "Happy";
        }

        if (choosedRace == 2)
        {
        	this.race.raceName = "Banshee";
            //displayerStatus = "Calm";
        }
        this.race.id = choosedRace;

        this.hunger = 100;
        this.morale = 100;
        this.focus = 100;
        this.status = 0;
        
        //totalTimeLapsed = 0;
    }
    
	public void setHunger(int newHunger)
	{
		this.hunger = this.hunger + newHunger;
	    if (this.hunger > 100) this.hunger = 100;
	    if (this.hunger < 0) this.hunger = 0;
	}
	
	public void setMorale(int newMorale)
	{
		this.morale = this.morale + newMorale;
	    if (this.morale > 100) this.morale = 100;
	    if (this.morale < 0) this.morale = 0;
	}
	
	public void setFocus(int newFocus)
	{
		this.focus = this.focus + newFocus;
	    if (this.focus > 100) this.focus = 100;
	    if (this.focus < 0) this.focus = 0;
	}
	
	public void setStatus(int newStatus)
	{
		this.status = newStatus;
	}
	
	public Type getRace()
	{
	    return this.race;
	}
	
	public String getName()
	{
	    return this.name;
	}
	
	public int getHunger()
	{
	    return this.hunger;
	}
	
	public int getMorale()
	{
	    return this.morale;
	}
	
	public int getFocus()
	{
	    return this.focus;
	}
	
	public int getStatus()
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
