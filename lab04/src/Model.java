
public class Model{
	int xloc = 0;
    int yloc = 0;
    int xIncr = 8;
    int yIncr = 2;
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
    Direction currentDirection = Direction.SOUTHEAST;
    Direction[] directs = {Direction.EAST, Direction.NORTHEAST, Direction.NORTH, Direction.NORTHWEST, Direction.WEST, Direction.SOUTHWEST, Direction.SOUTH, Direction.SOUTHEAST};
    
    Model(){
    	frameWidth = 10;
    	frameHeight = 10;
    	imgWidth = 2;
    	imgHeight = 2;
    }
	Model(int w, int h, int iW, int iH){
		frameWidth = w;
		frameHeight = h;
		imgWidth = iW;
		imgHeight = iH;
	}
	public void updateLocationAndDirection(){
		if(xloc+xIncr >= (frameWidth-imgWidth) || xloc+xIncr < -1*imgWidth/4) {
    		xIncr*=-1;
		}
		if(yloc+yIncr >= (frameHeight-imgHeight) || yloc+yIncr < -1*imgHeight/4) {
    		yIncr*=-1;
		}
		xloc+=xIncr;
		yloc+=yIncr;
		double direcAngle = Math.atan2(xIncr, -yIncr);
		int octant = (int)Math.round( 8 * direcAngle / (2*Math.PI) + 8 ) % 8;
		currentDirection = directs[octant];
		System.out.println(xIncr+" "+yIncr+": "+currentDirection+" "+octant);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
	}
	public Direction getDirect() {
		return currentDirection;
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
