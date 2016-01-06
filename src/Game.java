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
 * 
 * @author TORO DAPP
 *
 */
public class Game {
	/**
	 * 
	 */
	private Creature creature;
	/** */
    private Environment environment;
    /** */
    private Engine engine;
    //private int totalTimeLapsed;
    
    /**
     * 
     */
    public Game()
    {
        this.creature = new Creature("Lucifron", 1);
        this.environment = new Environment(1);
    }
    
    /**
     * 
     */
    public Game(String Name, int raceId)
    {
    	this.creature = new Creature(Name, raceId);
    	this.environment = new Environment(raceId);
    }
    

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
    /** */
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
     * 
     */
    public void updateStatus()
    {
        int newStatus = 0;
        int veryBadLimit = 0;

        if (this.creature.getHunger() < 25) {
        	newStatus = 1;
        	veryBadLimit++;
        }
        if (this.creature.getMorale() < 25) {
        	newStatus = 2; 
        	veryBadLimit++;
        }
        if (this.creature.getFocus() < 25) {
        	newStatus = 3;
        	veryBadLimit++;
        }
        if (veryBadLimit > 1) 
        	newStatus = 4;

        this.creature.setStatus(newStatus);
    }
    
    /** 
     * Boucle qui décrémente les attributs d'une créature toute les secondes.  
     */
    public void gameLoop()
    {
    	Thread loop = new Thread(new Runnable(){
			@Override
			public void run(){
				while(!false) {
					creature.modifyHunger(-environment.getDecreaseHunger());
					creature.modifyMorale(-environment.getDecreaseMorale());
					creature.modifyFocus(-environment.getDecreaseFocus());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		loop.start();
    	return;
    }
    
    /** */
    public void saveGame(String name)
    {
    	Date today = new Date();
    	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    	String todayString = formater.format(today);
    	
    	try {
			FileWriter fw = new FileWriter (name);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter saveFile = new PrintWriter (bw); 
			
			saveFile.println(creature.getName());
			saveFile.println(creature.getHunger());
			saveFile.println(creature.getMorale());
			saveFile.println(creature.getFocus());
			saveFile.println(creature.getRaceId());
			saveFile.println(creature.getStatus());
			
			saveFile.println(environment.getSector());
			
			saveFile.println(todayString);
			
			saveFile.close();	
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
		
    	return;
    }
    /** */
    public void loadGame(String name)
    {
    	creature = new Creature();
    	Date today = new Date();
    	String loadDate ;
    	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    	
    	try{
			InputStream ips=new FileInputStream(name); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			creature.setName(br.readLine());
			creature.setHunger(Integer.parseInt(br.readLine()));
			creature.setMorale(Integer.parseInt(br.readLine()));
			creature.setFocus(Integer.parseInt(br.readLine()));
			creature.setRaceId(Integer.parseInt(br.readLine()));
			creature.setStatus(Integer.parseInt(br.readLine()));
			
			environment = new Environment(Integer.parseInt(br.readLine()));
			
			loadDate = br.readLine();
	    	try {
	    		
	    		Date date = formater.parse(loadDate);
	    		
	    		if (date.compareTo(today) == -1) {
	        		System.out.println("OK"); // Traitement sur les effets du temps.
	        	} else {
	        		System.out.println("Fichier corrompu"); // Date en avance , pas normal...
	        	}
	    	} catch (ParseException e) {
	    		e.printStackTrace();
	    	}

			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
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
