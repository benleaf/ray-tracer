package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import window.CreateFrame;

public class Image {
	public BufferedImage buffer;
	public File image;
	
	public Image(String filename) {
		image = new File(filename);
		buffer = new BufferedImage(CreateFrame.world.veiwPlane.width,
CreateFrame.world.veiwPlane.height, BufferedImage.TYPE_INT_RGB);
		
	}
}
