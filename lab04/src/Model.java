//Andrew Thompson
//CISC275081L Lab04


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
public class Model{
	int xloc = 0;
    int yloc = 0;
    int xIncr = 1;
    int yIncr = 8;
    int frameWidth=0;
    int frameHeight=0;
    int imgWidth=0;
    int imgHeight=0;
    Direction currentDirection = Direction.SOUTHEAST;
    Direction[] directs = {Direction.EAST, Direction.NORTHEAST, Direction.NORTH, Direction.NORTHWEST, Direction.WEST, Direction.SOUTHWEST, Direction.SOUTH, Direction.SOUTHEAST};
    
    //Constructor that takes the image and screen dimensions and assigns values
	Model(int w, int h, int iW, int iH){
		frameWidth = w;
		frameHeight = h;
		imgWidth = iW;
		imgHeight = iH;
	}
	
	//updateLocationAndDirection() updates the position and direction of the model
	//and turns it around if it goes off the screen
	public void updateLocationAndDirection(){
		if(xloc+xIncr >= (frameWidth-imgWidth) || xloc+xIncr < -1*imgWidth/4) {
    		xIncr*=-1;
		}
		if(yloc+yIncr >= (frameHeight-imgHeight) || yloc+yIncr < -1*imgHeight/4) {
    		yIncr*=-1;
		}
		xloc+=xIncr;
		yloc+=yIncr;
		double direcAngle = Math.atan2(-yIncr, xIncr);
		int octant = (int)Math.round( 8 * direcAngle / (2*Math.PI) + 8 ) % 8;
		currentDirection = directs[octant];
		//System.out.println(xIncr+" "+yIncr+": "+currentDirection+" "+octant);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	//getX() returns the x location of the model
	public int getX() {
		return xloc;
	}
	
	//getY() returns the y location of the model
	public int getY() {
		return yloc;
	}
	
	//getDirect() returns the cardinal direction of the model
	public Direction getDirect() {
		return currentDirection;
	}
}




