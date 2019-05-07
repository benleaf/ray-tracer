package utility;

public class Node3D {
	public double x, y, z;
	
	public Node3D() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Node3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Node3D(Node3D point) {
		x = point.x;
		y = point.y;
		z = point.z;
	}
	
	public Node3D add(Node3D point) {
		return new Node3D(x+point.x, y+point.y, z+point.z);
	}
	
	public Node3D sub(Node3D point) {
		return new Node3D(x-point.x, y-point.y, z-point.z);
	}
	
	public Vector3D subVec(Node3D point) {
		return new Vector3D(x-point.x, y-point.y, z-point.z);
	}
	
	public double dot(Node3D point) {
		return x*point.x + y*point.y + z*point.z;
	}
	
	public double dot(Vector3D vector) {
		return x*vector.x + y*vector.y + z*vector.z;
	}
	
	public double dot(Normal normal) {
		return x*normal.x + y*normal.y + z*normal.z;
	}
}
