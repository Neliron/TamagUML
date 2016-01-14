import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La classe qui va g�rer la boucle du jeu
 * et qui donc met en relation l'environnement et le tamagotchi 
 * en appliquant les contraintes de l'environnement sur le tamagotchi.
 * 
 * @author TORO DAPP BOUCHER
 * 
 *
 */
public class Game {
	/** Le tamagotchi du joueur. */
	private Creature creature;
	/** L'environnement dans lequel �volue le tamagochi.*/
    private Environment environment;
    /** Le moteur graphique du jeu.*/
    private Engine engine;
    /** Garde en m�moire le fichier dans lequel le tamagochi est sauvegard�.*/
    private String savePath;
    
    /** Constructeur vide de game, initialise une partie vide remplie par loadGame() */
    public Game()
    {
    	this("Lucifron", 1, "save1.txt");
    }
    /**
     * Second constructeur de Game.
     * 
     * @param path
     * 		Le chemin vers l'emplacement de sauvegarde.
     */
    public Game(String path) {
    	this.loadGame(path);
    	this.savePath = path;
    	this.engine = new Engine(this.creature);
    	this.engine.getFrame().addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			saveGame(savePath);
    		}
    	});
    	this.gameLoop();
    }
    
    /**
     * Troisi�me constructeur de Game, permet de lancer une nouvelle partie.
     * 
     * @param name
     * 		Le nom du tamagochi
     * @param raceId
     * 		Le type de tamagochi, démon ou spectre.
     * @param path
     * 		Le chemin vers l'emplacement de sauvegarde.
     */
    public Game(String name, int raceId, String path)
    {
    	this.creature = new Creature(name, raceId);
    	this.environment = new Environment(raceId);
    	this.engine = new Engine(this.creature);
    	this.savePath = path;
    	this.engine.getFrame().addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			saveGame(savePath);
    		}
    	});
    	this.gameLoop();
    }
    
    /**
     * Renvoi le tamagochi correspondant � la partie en cours.
     * 
     * @return
     * 		Un objet Creature qui correspond au tamagochi de la partie en cours. 
     *  
     */
	public Creature getCreature() {
		return creature;
	}
	
	/**
	 * Remplace la creature pr�sente dans la partie en cours.
	 * 
	 * @param creature
	 * 		La nouvelle creature de la partie.
	 */
	public void setCreature(Creature creature) {
		this.creature = creature;
	}
	
	/**
	 * Renvoi l'environnement du tamagochi dans la partie en cours.
	 * 
	 * @return
	 * 		Un objet Environment correspondant � la partie en cours.
	 */
	public Environment getEnvironment() {
		return environment;
	}
	/**
	 * Modifie l'environnement de la partie en cours.
	 * 
	 * @param environment
	 * 		Le nouvel environnement de la partie en cours.
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
    /** 
     *	V�rifie l'�tat de la cr�ature
     *
     *	@return
     *		False si il est mort, true sinon. 
     */
    public boolean checkState()
    {
        if (this.creature.getHunger() <= 0) 
        	return false;
        if (this.creature.getMorale() <= 0) 
        	return false;
        if (this.creature.getFocus() <= 0) 
        	return false;

        return true;
    }
    
    /** 
     * Boucle qui d�cr�mente les attributs d'une cr�ature toute les secondes.  
     */
    public void gameLoop()
    {
    	Thread loop = new Thread(new Runnable(){
			@Override
			public void run(){
				while(checkState()) {
					creature.modifyHunger(-environment.getDecreaseHunger());
					creature.modifyMorale(-environment.getDecreaseMorale());
					creature.modifyFocus(-environment.getDecreaseFocus());
					creature.updateStatus();
					engine.update();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		loop.start();
    }
    
    /**
     * Sauvegarde la partie en cours
     * 
     * @param name
     * 		Le nom du fichier de sauvegarde.
     *
     */
    public void saveGame(String name)
    {
    	Date today = new Date();
    	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	String todayString = formater.format(today);
    	
    	try {
			FileWriter fw = new FileWriter (name);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter saveFile = new PrintWriter (bw); 
			
			saveFile.println(this.creature.getName());
			saveFile.println(this.creature.getHunger());
			saveFile.println(this.creature.getMorale());
			saveFile.println(this.creature.getFocus());
			saveFile.println(this.creature.getRaceId());
			saveFile.println(this.creature.getStatus());
			
			saveFile.println(this.environment.getSector());
			
			saveFile.println(todayString);
			
			saveFile.close();	
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
		
    	return;
    }
    
    /**
     * Charge une partie sauvegard� pour la reprendre.
     * 
     * @param name
     * 		Le nom du fichier de sauvegarde.
     *
     */
    public void loadGame(String name)
    {
    	this.creature = new Creature();
    	Date today = new Date();
    	String loadDate;
    	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
    	try{
			InputStream ips=new FileInputStream(name); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String test = br.readLine();
			if (test != null) {
				this.creature.setName(test);
				this.creature.setHunger(Integer.parseInt(br.readLine()));
				this.creature.setMorale(Integer.parseInt(br.readLine()));
				this.creature.setFocus(Integer.parseInt(br.readLine()));
				this.creature.setRaceId(Integer.parseInt(br.readLine()));
				this.creature.setStatus(Integer.parseInt(br.readLine()));
				
				this.environment = new Environment(Integer.parseInt(br.readLine()));
				
				loadDate = br.readLine();
		    	try {
		    		Date date = formater.parse(loadDate);
		    		
		    		if (date.compareTo(today) == -1) {
		    			float nbHours = ((today.getTime() -  date.getTime()) /3600000);
		    			System.out.println(nbHours);
		    			this.creature.modifyHunger((int) (-3*nbHours));
		    			this.creature.modifyMorale((int) (-3*nbHours));
		    			this.creature.modifyFocus((int) (-3*nbHours));
		        		
		        	} else {
		        		System.out.println("Fichier corrompu"); // Date en avance , pas normal...
		        	}
		    	} catch (ParseException e) {
		    		e.printStackTrace();
		    	}
			}
			else
				new LoadGameMenu();

			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
    }
}
