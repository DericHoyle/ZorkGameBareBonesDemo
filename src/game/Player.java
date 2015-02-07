package game;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String Name; //Character Name
	
	//Character Stats
	private int Health;
	private int baseHealth; //To be implemented later (used to reset health inbetween combat scenarios)
	private int Strength;
	private int Agility;
	private int EXP = 0; //Level System Currently Not Implemented
	
	//Character Equipment Slots (The equipment he will use these in combat)
	private List<Armor> ArmorSlot = Arrays.asList(new Armor[1]);
	private List<Weapon> WeaponSlot = Arrays.asList(new Weapon[1]);
	
	/**
	 * Constructs Player Object
	 * @param name The String to represent the player's name (used in messages/prompts)
	 * @param hp int that represents player's life total
	 * @param str int that represents player's strength
	 * @param agi int that represents player's agility
	 */
	public Player(String name,int hp,int str,int agi){
		this.Name = name;
		this.Health = hp;
		this.baseHealth = hp;
		this.Strength = str;
		this.Agility = agi;
	}
	
	/**
	 * Places Equpment object (armor or weapon) in player's appropriate equip slot
	 * 
	 * @param e Weapon or Armor to be 'equipped'
	 */
	public void Equip(Equipment e){
		if (e.isArmor()){
			ArmorSlot.set(0,(Armor) e);
		}else{
			WeaponSlot.set(0,(Weapon) e);
		}		
	}
	
	/**
	 * Computes the amount of damage the player deals based off their stats and their weapon's stats
	 * 
	 * @return Amount of damage that the player deals after calculations with appropriate stats have been done
	 */
	public int DealDamage(){
		int critmod = 1; //Intitialized a critical hit modifier for when the player scores a critical hit
		if ((Math.floor((Math.random() * 100) + 1)) < (Agility + WeaponSlot.get(0).GetAgility())){ //If combined agility stat is higher than the random number between 1 and 100
			critmod = 2; //Sets critical hit modifier to 2
		}
		return ((Strength + WeaponSlot.get(0).GetStrength())*critmod); //Return damage from combined strength stat and crit modfier
	}

	/**
	 * Computes the amount of damage a player takes
	 * 
	 * @param OppDamage int representing the amount of damage that the Enemy's attack deals before mitigation
	 * @return int representing the amount of damage after mitigation
	 */
	public int TakeDamage(int OppDamage){
		 if ((Math.floor((Math.random() * 100) + 1)) < Agility){ //If player dodges attack (based on RNG between 1-100 and player's combined Agility)
			 return 0; //Return 0, as player dodged attack
		 }else{
			int Damage = ((OppDamage - ArmorSlot.get(0).GetStrength() - WeaponSlot.get(0).GetDefense())); //Calculate Mitigated Damage
			if (Damage < 0){ //If Damage is fully mitigated by armor and weapon defense
				 return 0; //Return 0, as damage is fully mitigated
			}
			Health = Health - Damage; //Reduce health by mitigated damage
			return Damage; //Return mitigated damage
		 }
	}
	
	/**
	 * Checks if player's life total has hit 0
	 * 
	 * @return true if health is less than or equal to 0
	 */
	public boolean IsDead(){
		return (Health <= 0);
	}
	/**
	 * Returns player's current health total
	 * 
	 * @return Health if player's current health total is greater then zero, or 0 if the player's current health is less than or equal to 0
	 */
	public int getHealth(){
		if(Health > 0){
			return Health;
		}else{
			return 0;
		}
	}

	/**
	 * Returns equipped weapon
	 * 
	 * @return Weapon currently in player's WeaponSlot
	 */
	public Weapon CurrentWeapon(){
		return WeaponSlot.get(0);
	}
	
	/**
	 * Returns equipped armor
	 * 
	 * @return Armor currently in player's ArmorSlot
	 */
	
	public Armor CurrentArmor(){
		return ArmorSlot.get(0);
	}
	
	/**
	 * Replaces current equipment with a "nothing" equipment with zero stats and high durability
	 * 
	 * @param e Armor or Weapon to replace (used to determine which piece of equipment needs to be replaced)
	 */
	public void Destroy (Equipment e){
		if(e.isArmor()){ //If equipment is Armor
			this.Equip(new Armor("Undergarments", 0,1000000)); //Equip "nothing" armor
		}
		this.Equip(new Weapon("Nothing", 0, 0, 0,1000000)); //Equip "nothing" weapon
	}
	
	/**
	 * Returns current player's name
	 * 
	 * @return String representing player's name
	 */
	public String getName(){
		return Name;
	}
	
	/**
	 * Increases player's experience total
	 * 
	 * @param exp int representing the experience granted to the player
	 * @return true if the player's total exp excedes the threshold to level up
	 */
	public boolean GainExp(int exp){
		EXP = EXP + exp;
		return (EXP >= 100);
 	}
	
}
