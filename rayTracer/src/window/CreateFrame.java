package window;

import javax.swing.ImageIcon;

import geometry.World;
import main.Tracer;
import projection.Perspective;
import projection.Projection;
import sampling.JitteredSample;
import sampling.Sampler;
import utility.Image;
import utility.Node3D;


public class CreateFrame {
	
	public static World world;
	public static Image image;
	public static Tracer tracer;
	public static Sampler sampler;
	public static Projection projection;
	Window window;
	int width;
	int height;
	
	public CreateFrame(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	public ImageIcon generateFrame(
					float vectorX, 
					float vectorY, 
					float vectorZ, 
					float posX, 
					float posY,
					float posZ, 
					float FOV) {
		
		long start = System.nanoTime();
			
		world = new World(width, height, 1.0);
		image = new Image("image.PNG");
		tracer = new Tracer();
		sampler = new JitteredSample(1);
		
		projection = new Perspective(
					new Node3D(vectorX, vectorY, vectorZ),
					new Node3D(posX, posY, posZ),
					FOV);
	
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tracer.trace(x, y);
			}
		}
		
		long end = System.nanoTime();
		System.out.println("Loop Time: " + (end-start)/1000000000.0F);
		
		return new ImageIcon(image.buffer);
	}
}
