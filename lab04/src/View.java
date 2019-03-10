
import java.util.HashMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel{
	HashMap<Direction,BufferedImage> movePics = new HashMap<>();
	String cd = System.getProperty("user.dir").replace("\\","/");
	
	final int frameCount = 10;
    int picNum = 0;
    BufferedImage[] pics;
    final static int frameWidth = 500;//500
    final static int frameHeight = 300;//300
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    int xloc = 0;
    int yloc = 0;
	
	Direction[] directs = {Direction.EAST, Direction.NORTHEAST, Direction.NORTH, Direction.NORTHWEST, Direction.WEST, Direction.SOUTHWEST, Direction.SOUTH, Direction.SOUTHEAST};
	View(){
		for(Direction tempDir: directs) {
			BufferedImage buffImg;
	    	try {
	    		buffImg = ImageIO.read(new File(cd+"/images/orc/orc_forward_"+tempDir.getName()+".png"));
		    	movePics.put(tempDir, buffImg);
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	public void paint(Graphics g) {
		picNum = (picNum+1)%frameCount;
    	g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
	}
	
	public int getWidth() {
		return frameWidth;
	}
	public int getHeight() {
		return frameHeight;
	}
	public int getImageWidth() {
		return imgWidth;
	}
	public int getImageHeight() {
		return imgHeight;
	}
	public void update(int x, int y, Direction direct) {
		xloc = x;
		yloc = y;
		pics = new BufferedImage[10];
		for(int i = 0; i < frameCount; i++)
    		pics[i] = movePics.get(direct).getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
		this.paint(this.getComponentGraphics(null));
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
