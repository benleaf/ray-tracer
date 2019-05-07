package projection;

import utility.Node2D;
import utility.Ray;
import window.CreateFrame;

public class Orthographic extends Projection {
	
	final double SIZE = CreateFrame.world.veiwPlane.size;
	final int WIDTH = CreateFrame.world.veiwPlane.width;
	final int HEIGHT = CreateFrame.world.veiwPlane.height;
	
	public Ray createRay(Node2D point) {
		Ray ray = new Ray();
		ray.origin.x = SIZE*point.x;
		ray.origin.y = SIZE*point.y;
		ray.origin.z = 3000;
		
		ray.direction.x = 0.0;
		ray.direction.y = 0.0;
		ray.direction.z = -1.0;
		
		return ray;
	}
}
