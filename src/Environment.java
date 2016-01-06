/**
 * 
 * @author TORO DAPP
 *
 */
public class Environment {
	/**	 */
	private String name;
	/**	 */
	private int sector;
	/**	 */
	private int decreaseHunger;
	/**	 */
	private int decreaseMorale;
	/**	 */
	private int decreaseFocus;
	
	/**
	 * 
	 */
	public Environment()
	{
	    this.name = "Satan's Gardens";
	    this.sector = 1;

	    this.decreaseHunger = 1;
	    this.decreaseMorale = 1;
	    this.decreaseFocus = 2;
	}
	
	/**
	 * 
	 * @param draftLand
	 * 
	 */
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

	    }
	
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public String getName()
	{
	    return this.name;
	}
	/**
	 * 
	 * @return
	 * 
	 */
	public int getSector()
	{
	    return this.sector;
	}

	/**
	 * 
	 * @return
	 * 
	 */
	public int getDecreaseHunger()
	{
	    return this.decreaseHunger;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public int getDecreaseMorale()
	{
	    return this.decreaseMorale;
	}

	/**
	 * 
	 * @return
	 * 
	 */
	public int getDecreaseFocus()
	{
	    return this.decreaseFocus;
	}

}
