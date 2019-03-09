
public class Model{
	int xloc = 0;
    int yloc = 0;
    int xIncr = 8;
    int yIncr = 2;
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
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
		if(xloc >= (frameWidth-imgWidth) || xloc < -1*imgWidth/4) {
    		xIncr*=-1;
		}
		if(yloc >= (frameHeight-imgHeight) || yloc < -1*imgHeight/4) {
    		xIncr*=-1;
		}
		xloc+=xIncr;
		yloc+=yIncr;
		
	}
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
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
