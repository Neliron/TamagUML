
public class Environment {
	
	private String name;
	private int sector;

	private int decreaseHunger;
	private int decreaseMorale;
	private int decreaseFocus;
	
	public Environment()
	{
	    this.name = "Satan's Gardens";
	    this.sector = 1;

	    this.decreaseHunger = 1;
	    this.decreaseMorale = 1;
	    this.decreaseFocus = 2;
	}
	
	public Environment(int draftLand) // Environnements actuels du jeu
	{
	    switch (draftLand)
	    {
	    case 1 :
	    	this.name = "Satan's Gardens"; // Pour les démons
	    	this.sector = 1;

	    	this.decreaseHunger = 1;
	    	this.decreaseMorale = 1;
	    	this.decreaseFocus = 2;
	        break;

	    case 2 :
	    	this.name = "Heights of Limbo"; // Pour les banshees
	    	this.sector = 2;

	    	this.decreaseHunger = 1;
	    	this.decreaseMorale = 2;
	    	this.decreaseFocus = 1;
	        break;

	    case 3 :
	    	this.name = "Burning Grounds";
	    	this.sector = 3;

	    	this.decreaseHunger = 2;
	    	this.decreaseMorale = 1;
	    	this.decreaseFocus = 1;
	        break;
	        
	    case 4 :
	    	this.name = "Magma Mines";
	    	this.sector = 4;

	    	this.decreaseHunger = 2;
	    	this.decreaseMorale = 2;
	    	this.decreaseFocus = 2;
	        break;
	    }
	
	}
	
	String getName()
	{
	    return this.name;
	}

	int getSector()
	{
	    return this.sector;
	}

	int getDecreaseHunger()
	{
	    return this.decreaseHunger;
	}

	int getDecreaseMorale()
	{
	    return this.decreaseMorale;
	}

	int getDecreaseFocus()
	{
	    return this.decreaseFocus;
	}

}
