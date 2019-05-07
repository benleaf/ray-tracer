package utility;

public class Ray {
	public Node3D origin;
	public Vector3D direction;
	
	public Ray() {
		origin = new Node3D();
		direction = new Vector3D();
	}
	
	public Ray(Node3D origin, Vector3D direction) {
		this.origin = new Node3D(origin);
		this.direction = new Vector3D(direction);
	}
}
