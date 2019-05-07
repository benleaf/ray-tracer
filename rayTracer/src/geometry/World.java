package geometry;

import java.util.ArrayList;

import scean.VeiwPlane;
import utility.Color;
import utility.Node3D;
import utility.Normal;

public class World {
	public VeiwPlane veiwPlane;
	public ArrayList<GeometricObject> objects;
	public Color background;
	
	public World(int width, int height, double size) {
		veiwPlane = new VeiwPlane(width, height, size);
		background = new Color(1.0F, 1.0F, 1.0F);
		
		objects = new ArrayList<GeometricObject>();
		objects.add(new Sphear(new Node3D(0.0, 0.0, 0.0), 50, new Color(1.0F,0.0F,0.0F)));
		objects.add(new Sphear(new Node3D(-150.0, 0.0, 0.0), 50, new Color(0.0F,1.0F,0.0F)));
		objects.add(new Sphear(new Node3D(150.0, 0.0, 0.0), 50, new Color(0.0F,0.0F,1.0F)));
		
		objects.add(new Plane(new Node3D(0.0, 0.0, 0.0), 
					new Normal(0.0, 1.0, 0.0), new Color(0.5F,0.5F,1.0F)));
		
	}
}
