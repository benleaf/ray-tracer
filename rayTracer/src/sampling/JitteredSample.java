package sampling;

import java.util.Random;

import utility.Node2D;
import window.CreateFrame;

public class JitteredSample extends Sampler{
	
	public Random r;
	
	public JitteredSample( int samples) {
		this.samples = samples;
		r = new Random();
	}
	
	public Node2D sample(int row, int col, int x, int y) {
		Node2D point = new Node2D();
		point.x = x-CreateFrame.world.veiwPlane.width/2+(col+r.nextFloat())/samples;
		point.y = y-CreateFrame.world.veiwPlane.height/2+(row+r.nextFloat())/samples;
		return point;
	}

}
