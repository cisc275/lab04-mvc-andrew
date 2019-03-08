
public class View{
	public int getWidth() {
		return 1;
	}
	public int getHeight() {
		return 1;
	}
	public int getImageWidth() {
		return 1;
	}
	public int getImageHeight() {
		return 1;
	}
	public void update(int x, int y, Direction direct) {
		
	}
}


/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
