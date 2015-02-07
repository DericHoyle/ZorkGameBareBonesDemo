package game;

/**
 *	Abstract class encompassing both Weapon and Armor objects
 *
 * @author Deric Hoyle
 *
 */
public abstract class Equipment {

	
/**
 * Determines whether a particular equipment is a Weapon or Armor
 *	
 * @return true is the Equipment object is Armor, false if it's a Weapon
 */
public abstract boolean isArmor();
	
}
