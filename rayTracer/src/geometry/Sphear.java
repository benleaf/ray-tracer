package geometry;

import utility.Color;
import utility.Node3D;
import utility.Ray;

public class Sphear extends GeometricObject{
	public Node3D center;
	public double radius;
	
	public Sphear(Node3D center, double radius, Color color) {
		this.center = new Node3D(center);
		this.radius = radius;
		this.color = new Color(color);
	}

	public double hit(Ray ray) {
		double a = ray.direction.dot(ray.direction);
		double b = 2*ray.origin.sub(center).dot(ray.direction);
		double c = ray.origin.sub(center).dot(ray.origin.sub(center))-radius*radius;
		
		double discriminant = b*b-4*a*c;
		
		if (discriminant < 0.0) {
			return 0.0;
		}else {
			//finds where the ray intersected with the sphear
			double intersectA = (-b - Math.sqrt(discriminant))/(2*a);
			double intersectB = (-b + Math.sqrt(discriminant))/(2*a);
			if (intersectA > 10E-9) {
				return intersectA;
			}else if(intersectB > 10E-9){
				return intersectB;
			}else {
				return 0.0;
			}
		}
	}
}
