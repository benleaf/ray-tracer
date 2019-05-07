package sampling;

import utility.Node2D;

public abstract class Sampler {
	
	public int samples;
	
	public abstract Node2D sample(int row, int col, int x, int y);
}
