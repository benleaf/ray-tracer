package projection;

import utility.Node2D;
import utility.Node3D;
import utility.Ray;
import utility.Vector3D;
import window.CreateFrame;

public class Perspective extends Projection{

	public Perspective(Node3D eye, Node3D lookAt, double FOV) {
		this.eye = new Node3D(eye);
		this.lookAt = new Node3D(lookAt);
		this.distance = CreateFrame.world.veiwPlane.height/2/Math.tan(Math.toRadians(FOV));
		computeUVW();
	}
	
	public Ray createRay(Node2D point) {

		Node3D node = new Node3D(eye);
		Vector3D vector = u.mult(point.x).add(v.mult(point.y).sub(w.mult(distance)));
		Ray ray = new Ray(node, vector);
		ray.direction.normalize();
		return ray;
	}
}
