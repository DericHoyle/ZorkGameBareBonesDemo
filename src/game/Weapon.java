package game;

public class Weapon extends Equipment {
	//Weapon Name
	private String Name;
	
	//Combat Stats
	private final int Strength;
	private final int Defense;
	private final int Agility;
	private int Durability;
	
	/**
	 * Constructs a weapon object to be used by the Player
	 * 
	 * 
	 * @param name String representing Weapon name (used in prompt)
	 * @param str int representing Weapons Strength stat
	 * @param def int representing Weapon's Defense stat
	 * @param agi int representing Weapon's Agility stat
	 * @param drb int representing Weapon's Durability stat
	 */
	
	public Weapon(String name,int str, int def, int agi, int drb){
		//Set combat stats
		this.Strength = str;
		this.Agility = agi;
		this.Defense = def;
		this.Durability = drb;
		
		//Set name
		this.Name = name;
	}
	
	/**
	 * Return Weapon's Strength stat (used in damage calculation)
	 *  
	 * @return int representing Weapon's Strength stat
	 */
	public int GetStrength(){
		return Strength;
	}
	/**
	 * Returns Weapon's Defense stat (used in damage calculation)
	 * 
	 * @return int representing Weapon's Strength stat
	 */
	public int GetDefense(){
		return Defense;
	}
	
	/**
	 * Returns Weapon's Agility stat (used in damage calculation)
	 * 
	 * @return int representing Weapon's Agility stat
	 */
	public int GetAgility(){
		return Agility;
	}
	
	/**
	 * Reduces Weapon's durability and checks whether or not the Weapon breaks
	 * 
	 * @return true if the Weapon still has a positive durability stat after degradation
	 */
	public boolean Degrade(){
		Durability--; //Reduce Durability by 1
		return ((Durability > 0));
	}
	
	/**
	 * Returns Weapon's Name (used by console prompt)
	 * 
	 * @return String representing Weapon's Name
	 */
	public String getName(){
		return Name;
	}
	
	/**
	 * Return false to indicate that this equipment is a weapon
	 */
	@Override
	public boolean isArmor() {
		return false;
	}
}
