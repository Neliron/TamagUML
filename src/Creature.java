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
    	this("Lucifron", 1);
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
     * @param value
     * 		La valeur qui modifie la jauge.
     */
	public void modifyHunger(int value)
	{
		this.hunger += value;
	    if (this.hunger > 100) this.hunger = 100;
	    if (this.hunger < 0) this.hunger = 0;
	}
	
	/**
	 * Met à jour la jauge de moral.
	 * 
	 * @param value
	 * 		La valeur qui modifie la jauge.
	 */
	public void modifyMorale(int value)
	{
		this.morale += value;
	    if (this.morale > 100) this.morale = 100;
	    if (this.morale < 0) this.morale = 0;
	}
	
	/**
	 * Met à jour la jauge de concentration.
	 * 
	 * @param value
	 * 		La valeur qui modifie la jauge.
	 */
	public void modifyFocus(int value)
	{
		this.focus += value;
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
	 * 		Le nouveau nom du tamagochi
	 */
	public void setName(String name)
	{
		this.name = name;
		return;
	}
	
	/**
	 * Change la valeur de hunger.
	 * 
	 * @param hunger
	 * 		La nouvelle valeur de hunger
	 */
	public void setHunger(int hunger)
	{
	    this.hunger = hunger;
	    return;
	}
	
	/**
	 * Change la valeur de morale.
	 * 
	 * @param morale
	 * 		La nouvelle valeur de morale
	 */
	public void setMorale(int morale)
	{
		 this.morale = morale;
		 return;
	}
	
	/**
	 * Change la valeur de focus.
	 * 
	 * @param focus
	 * 		La nouvelle valeur de focus
	 */
	public void setFocus(int focus)
	{
		 this.focus = focus;
		 return;
	}
	
	/**
	 * 	Renvoie la valeur de raceId.
	 * 
	 * @return
	 * 		Un int qui correspond à la valeur raceId du tamagochi
	 */
	public int getRaceId()
	{
	    return this.raceId;
	}
	
	/**
	 * Renvoie le nom du tamagochi.
	 * 
	 * @return
	 * 		un String qui correspond au nom du tamagochi
	 */
	public String getName()
	{
	    return this.name;
	}
	
	/**
	 * Renvoie la valeur de hunger.
	 * 
	 * @return
	 * 		Un int qui correspond à la valeur de hunger 
	 */
	public int getHunger()
	{
	    return this.hunger;
	}
	
	/**
	 * Renvoie la valeur de morale.
	 * 
	 * @return
	 * 		Un int qui correspond à la valeur de morale
	 */
	public int getMorale()
	{
	    return this.morale;
	}
	
	/**
	 * Renvoie la valeur de focus.
	 * 
	 * @return
	 * 		Un int qui correspond à la valeur de focus.
	 */
	public int getFocus()
	{
	    return this.focus;
	}
	
	/**
	 * Renvoie la valeur de status
	 * 
	 * @return
	 * 		Un int qui correspond à la valeur de status.
	 */
	public int getStatus()
	{
	    return this.status;
	}
}
