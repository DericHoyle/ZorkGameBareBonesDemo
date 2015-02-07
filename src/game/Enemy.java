package game;

public class Enemy {

	//Enemy's Name
	private String Name;
	
	//Enemy's Stats
	private int Health;
	private final int Armor;
	private final int Attack;
	private final int Agility;
	private final int ExpYield; //Currently not implemented
	
	/**
	 * Constructs an Enemy object
	 * 
	 * @param name String representing Enemy's name
	 * @param health int representing Enemy's health stat
	 * @param armor int representing Enemy's armor stat
	 * @param attack int representing Enemy's attack stat
	 * @param agility int representing Enemy's agility stat
	 * @param exp int representing Enemy's experience yield
	 */
	public Enemy(String name,int health, int armor, int attack, int agility, int exp){
		//Enemy Name
		this.Name = name;
		
		//Enemy Combat Stats
		this.Health = health;
		this.Armor = armor;
		this.Attack = attack;
		this.Agility = agility;
		
		//Enemy Experience Yield (Not Yet Supported)
		this.ExpYield = exp;
	}
	
	/**
	 * Computes the amount of damage the Enemy takes
	 * 
	 * @param OppDamage int representing the amount of damage that the Player's attack deals before mitigation
	 * @return int representing the amount of damage after mitigation
	 */
	public int TakeDamage(int OppDamage){
		if ((Math.floor((Math.random() * 100) + 1)) < Agility){ //If Character Dodges (Calculated by RNG and Enemy's Agility Stat)
			 return 0; //Enemy Takes No Damage (dodges)
			 //TODO: Implement a way so this function returns status flags so the GB knows when they dodge
		 }else{
			 int damage = ((OppDamage - Armor)); //Decrement damage based on Enemy's armor
			 if (damage < 0){ //If damage is fully mitigated
				 return 0; //Return 0, to prevent negative damage
			 }
			 Health = Health - damage; //Decrease health by mitigated damage
			 return damage; //Return Mitigated Damage (for prompt)
		 }
	}
	
	/**
	 * Checks if Enemy has zero health
	 *  
	 * @return true if Enemy has less than zero health, false otherwise
	 */
	
	public boolean IsDead(){
		return (Health <= 0); //Return true if the Enemy's health total is less than 0
	}
	
	/**
	 * Returns current health value
	 * 
	 * @return int reperesenting Enemy's current health value
	 */
	public int getHealth(){
		if(Health > 0){
			return Health; //Return current Health total if it's above 0
		}else{
			return 0; //Return zero to prevent negative health values
		}
	}
	
	/**
	 * Computes the amount of damage the Enemy deals based off its combat stats
	 * 
	 * @return int representing the Amount of damage that the Enemy deals after calculations with appropriate stats have been done
	 */
	public int DealDamage(){
		int critflag = 1; //Initialize Critical Flag (used to calculate final damage output)
		if ((Math.floor((Math.random() * 100) + 1)) < Agility){
			critflag = 2; //Set "Critical Hit" flag (calculated by RNG and enemy's agility Stat)
		}
		return Attack*critflag; //Return Critical-modified Damage
	}
	/**
	 * Return the Enemy's Name (currently used in console prompts)
	 * 
	 * @return
	 */
	public String getName(){
		return Name;
	}
	
	/**
	 * Returns Enemy's Experience Yield
	 * 
	 * @return int representing Enemy's experience yield
	 */
	
	public int Defeated(){
		return ExpYield;
	}

}
