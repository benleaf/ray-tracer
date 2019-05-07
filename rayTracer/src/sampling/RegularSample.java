package sampling;

import utility.Node2D;
import window.CreateFrame;

public class RegularSample extends Sampler {
	public RegularSample(int samples) {
		this.samples = samples;
	}

	@Override
	public Node2D sample(int row, int col, int x, int y) {
		Node2D point = new Node2D();
		point.x = x-CreateFrame.world.veiwPlane.width/2+(col+0.5)/samples;
		point.y = y-CreateFrame.world.veiwPlane.height/2+(row+0.5)/samples;
		return point;
	}
}
