package geometry;

import utility.Color;
import utility.Node3D;
import utility.Normal;
import utility.Ray;

public class Plane extends GeometricObject {
	Node3D point;
	Normal normal;
	
	public Plane(Node3D point, Normal normal, Color color) {
		this.point = new Node3D(point);
		this.normal = new Normal(normal);
		this.color = new Color(color);
	}
	
	public double hit(Ray ray) {
		double t = (point.sub(ray.origin).dot(normal)/ray.direction.dot(normal));
		if(t > 10E-9) {
			return t;
		}else {
			return 0.0;
		}
	}	
}