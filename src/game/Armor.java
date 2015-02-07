package game;

public class Armor extends Equipment{
	
	//Armor's name (used in console prompt)
	private String name;
	
	//Combat Stats
	private final int Strength;
	private int Durability;
	
	/**
	 * Constructs an Armor object to be used by the Player
	 * 
	 * @param name String representing the name of the Armor
	 * @param str int representing Armor's strength stat
	 * @param drb int representing Armor's durability stat
	 */
	public Armor(String name,int str, int drb){
		this.name = name;
		this.Strength = str;
		this.Durability = drb;
	}
	/**
	 * Return Armor's strength stat (used in damage calculation)
	 * 
	 * @return int representing Armor's strength stat
	 */
	public int GetStrength(){
		return Strength; //Return Strength
	}
	/**
	 * Return Armor's name (used in damage calculation)
	 * 
	 * @return Strength representing Armor's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Reduces Armors durability by one and checks whether or not the armor breaks
	 * 
	 * @return true if the Armor still has a positive durability stat after degradation
	 */
	public boolean Degrade(){
		Durability--; //Reduce Durability by 1
		return ((Durability) > 0); //Return true if durability is greater than 0
	}

	/**
	 * Returns true to indicate this is an Armor Object
	 * 
	 */
	
	@Override
	public boolean isArmor() {
		return true;
	}
}
