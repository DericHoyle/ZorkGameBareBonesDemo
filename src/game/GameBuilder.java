package game;

import java.util.Scanner;

public class GameBuilder {
	private Player p; //Player character
	private Scanner input = new Scanner(System.in); //Opens scanner to take user input
	
	public GameBuilder(){ //Empty Constructor (most work will by done through GameBuilder's methods)
	}
	/**
	 * Combat
	 * Runs through a combat scenario between character player p and enemy e, allowing the player to select their action between each combat step
	 * 
	 *
	 * @param e the Enemy character that the player will be fighting, which has most of the methods that the character would 
	 */
	public void Combat(Enemy e){
		System.out.println(p.getName() + " has challenged " + e.getName() + " to combat!"); //Print intro message
		while (true){ //Unconditional Loop (breaks when either character dies or player runs away)
		System.out.println("Select an Action: \n [1] Attack \t [2] Run"); //Presents player with combat options
		String i = input.next(); //Wait for user input
		if (i.contentEquals("1")){ //If player selects option to Attack
			System.out.println(p.getName() + " deals " + e.TakeDamage(p.DealDamage()) + " damage to " + e.getName() + "!"); //Player deals damage to Enemy
			System.out.println(e.getName() + " has " + e.getHealth() + " health remaining!"); //Displays enemy's remaining health
			if (!(p.CurrentWeapon().Degrade())){ //If weapon has fully degraded (each attack degrades once with each attack
				System.out.println(p.CurrentWeapon().getName() + " has been damaged irreparably..."); //Displays status of current weapon
				p.Destroy(p.CurrentWeapon()); //Destroys weapon (currently replaces it with a 'nothing' weapon that has no stats and high durability)
				//TO IMPLEMENT WITH INVENTORY SYSTEM: Allow player to replace weapon with inventory item  
			}
			if (e.IsDead()){ //If Enemy has 0 Health
				System.out.println(p.getName() + " has defeated " + e.getName() + " and has gained " + e.Defeated() + " EXP!"); //Display victory message to player
				if(p.GainExp(e.Defeated())){ //If player has gained enough experience
					System.out.println(p.getName() + " has leveled up!"); //Currently only displays a message, will implement a 'level up' method that allows player to distribute stats.
				}
				break; //Breaks out of loop as enemy is dead
			}
			System.out.println(e.getName() + " deals " + p.TakeDamage(e.DealDamage()) + " damage to " + p.getName() + "!"); //Enemy deals damage to player
			System.out.println(p.getName() + " has " + p.getHealth() + " health remaining!"); //Display's player's remaining health
			if (!(p.CurrentArmor().Degrade())){ //If armor has fully degraded
				System.out.println(p.CurrentArmor().getName() + " has been damaged irreparably..."); //Display status of current armor
				p.Destroy(p.CurrentArmor()); //Destroy current armor (currently replaces it with a 'nothing' armor that has no stats and high durability)
			}
			if (p.IsDead()){ //If player has died 
				System.out.println(p.getName() + " has been defeated..."); //Display defeat message
				break; //Breaks out of loop as player is dead
				//TO IMPLEMENT WITH INVENTORY SYSTEM: Have enemy randomly 'steal' an item from the player's inventory
			}
		}else if (i.contentEquals("2")){ //If player chooses to run
			System.out.println(p.getName() + " has successfully ran away!"); //Displays success of escape (currenly 100%)
			//TO IMPLEMENT WITH LEVEL SYSTEM: Method to determine whether escape was successful based on players level and enemy's strength
			break; //Break combat loop as player ran away
		}else{ //If player input anything else
			System.out.println("Invalid Selection!"); //Prints error message (loop back to beginning)
		}
		}
	}

	/**
	 * NewCharacter
	 * 
	 * Creates a new character for the player and equips them with "starter gear"
	 * 
	 * 
	 */
	
	public void NewCharacter(){
		//Create "Starter Gear" objects
		Weapon hammer = new Weapon("Hammer", 15,0,0,100);
		Weapon sword = new Weapon("Sword", 10,5,5,100);
		Weapon dagger = new Weapon("Dagger", 10, 0, 15, 100);
		Armor cloth = new Armor("Cloth Tunic", 10, 100);
		
		System.out.println("Select Your Name:"); //Gives player instruction to enter their name
		String i = input.next(); //Waits for user input
		p = new Player(i, 25,10,0); //Creates a base character for the player
		p.Equip(cloth); //Equips player with starter armor
		while(true){ //
		System.out.println("Select Your Weapon: [1] Sword [2] Hammer [3] Dagger"); //Prompts player to select a weapon
		String j = input.next(); //Waits for user input
		//Equip chosen weapon to player character
		if (j.contentEquals("1")){ 
			p.Equip(sword);
			break;
		}else if (j.contentEquals("2")){
			p.Equip(hammer);
			break;
		}else if (j.contentEquals("3")){
			p.Equip(dagger);
			break;
		}else{ //If player input is unspecified
			System.out.println("Invalid Selection!"); //Print error message (loop)
		}
		}	
	}
}