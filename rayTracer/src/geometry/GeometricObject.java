package geometry;


import utility.Color;
import utility.Node3D;
import utility.Ray;
import utility.Vector3D;

public abstract class GeometricObject {
	public Color color;
	public abstract double hit(Ray ray);
}
