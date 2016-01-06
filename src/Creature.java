/**
 * 
 * @author TORO DAPP
 *
 */
public class Creature {
	/** Le nom du tamagochi. */
	private String name;
	/**	La race du tamagochi identifiée avec un ID */
    public int raceId;
    /**	La jauge de faim du tamagochi */
    private int hunger;
    /**	La jauge de moral du tamagochi */
    private int morale;
    /**	La jauge de concentration du tamagochi */
    private int focus;
    /**	Le statut du tamagochi */
    private int status;
    
    /**	 
     * Constructeur vide d'un objet Creature
     */
    public Creature()
    {
        this.name = "Lucifron";

        this.raceId = 1;
        //displayerStatus = "Happy";

        this.hunger = 100;
        this.morale = 100;
        this.focus = 100;
        this.status = 0;
        
        //totalTimeLapsed = 0;
    }
    
    /**
     * Second constructeur d'un objet Creature
     * 
     * @param choosedName
     * 		Le nom du tamagochi
     * @param choosedRace
     * 		L'id de la race du tamagochi
     */
    public Creature(String choosedName, int choosedRace)
    {
    	this.name = choosedName;
        this.raceId = choosedRace;

        this.hunger = 100;
        this.morale = 100;
        this.focus = 100;
        this.status = 0;
        
        //totalTimeLapsed = 0;
    }
    
    /**
     * Met à jour la jauge de faim.
     * 
     * @param newHunger
     * 		La valeur qui modifie la jauge.
     */
	public void modifyHunger(int newHunger)
	{
		this.hunger += newHunger;
	    if (this.hunger > 100) this.hunger = 100;
	    if (this.hunger < 0) this.hunger = 0;
	}
	
	/**
	 * Met à jour la jauge de moral.
	 * 
	 * @param newMorale
	 * 		La valeur qui modifie la jauge.
	 */
	public void modifyMorale(int newMorale)
	{
		this.morale += newMorale;
	    if (this.morale > 100) this.morale = 100;
	    if (this.morale < 0) this.morale = 0;
	}
	
	/**
	 * Met à jour la jauge de concentration.
	 * 
	 * @param newFocus
	 * 		La valeur qui modifie la jauge.
	 */
	public void modifyFocus(int newFocus)
	{
		this.focus += newFocus;
	    if (this.focus > 100) this.focus = 100;
	    if (this.focus < 0) this.focus = 0;
	}
	
	/**
	 * Remplace l'ID de la race du tamagochi.
	 * 
	 * @param raceId
	 * 		Le nouvel ID.
	 */
	public void setRaceId(int raceId)
	{
		this.raceId = raceId;
		return;
	}
	/**
	 * Remplace le statut du tamagochi.
	 * 
	 * @param newStatus
	 * 		Le nouveau tamagochi.
	 */
	public void setStatus(int newStatus)
	{
		this.status = newStatus;
		return;
	}
	
	/**
	 * Change le nom du tamagochi.
	 * 
	 * @param name
	 * 		
	 */
	public void setName(String name)
	{
		this.name = name;
		return;
	}
	
	/**
	 * 
	 * @param hunger
	 * 
	 */
	public void setHunger(int hunger)
	{
	    this.hunger = hunger;
	    return;
	}
	
	/**
	 * 
	 * @param morale
	 * 
	 */
	public void setMorale(int morale)
	{
		 this.morale = morale;
		 return;
	}
	
	/**
	 * 
	 * @param focus
	 * 
	 */
	public void setFocus(int focus)
	{
		 this.focus = focus;
		 return;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public int getRaceId()
	{
	    return this.raceId;
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
	public int getHunger()
	{
	    return this.hunger;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public int getMorale()
	{
	    return this.morale;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public int getFocus()
	{
	    return this.focus;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
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
