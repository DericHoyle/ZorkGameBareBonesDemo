package game;

public class Game {
	
public static void main(String[] args) {
	GameBuilder gb = new GameBuilder();
	gb.NewCharacter();
	gb.Combat(new Enemy("Ogre",25,10,20,1,10));
}
}