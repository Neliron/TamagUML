/**
 * La classe qui va gérer les variables lié à l'environnement du tamagotchi, 
 * donc tout ce qui correspond à la vitesse de décrémentation de ses jauges.
 * 
 * @author TORO DAPP BOUCHER
 *
 */
public class Environment {
	/**	Le nom de l'environment */
	private String name;
	/**	L'identifiant de l'environment */
	private int sector;
	/**	La vitesse de décrémentation de la variable hunger */
	private int decreaseHunger;
	/**	La vitesse de décrémentation de la variable morale */
	private int decreaseMorale;
	/**	La vitesse de décrémentation de la variable focus */
	private int decreaseFocus;
	
	/**
	 * Constructeur vide de l'objet Environment
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
	 * Constructeur de l'objet Environment
	 * 
	 * @param draftLand
	 * 		L'id associé à sector.
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
	 * Retourne la variable name
	 * @return
	 * 		Un objet String correspondant au nom du tamagotchi
	 */
	public String getName()
	{
	    return this.name;
	}
	/**
	 * Retourne la variable sector
	 * @return
	 * 		Un objet int correpondant à l'id de l'environment
	 */
	public int getSector()
	{
	    return this.sector;
	}

	/**
	 * Retourne la variable decreaseHunger
	 * @return
	 * 		Un objet int correspondant à la valeur de décrémentation de la variable hunger
	 */
	public int getDecreaseHunger()
	{
	    return this.decreaseHunger;
	}
	
	/**
	 * Retourne la variable decreaseMorale
	 * @return
	 * 		Un objet int correspondant à la valeur de décrémentation de la variable decreaseMorale
	 */
	public int getDecreaseMorale()
	{
	    return this.decreaseMorale;
	}

	/**
	 * Retourne la variable decreaseFocus
	 * @return
	 * 		Un objet int correspondant à la valeur de décrémentation de la variable decreaseFocus
	 */
	public int getDecreaseFocus()
	{
	    return this.decreaseFocus;
	}

}
