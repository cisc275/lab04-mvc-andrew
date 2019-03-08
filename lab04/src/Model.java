
public class Model{
	Model(int w, int h, int iW, int iH){
		
	}
	public void updateLocationAndDirection(){
		
	}
	public int getX() {
		return 1;
	}
	public int getY() {
		return 1;
	}
	public Direction getDirect() {
		return Direction.NORTH;
	}
}



/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
