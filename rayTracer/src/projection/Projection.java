package projection;

import utility.Node2D;
import utility.Node3D;
import utility.Ray;
import utility.Vector3D;

public abstract class Projection {
	public Node3D eye;//point that rays originate from
	public Node3D lookAt;//point on view plane that ray passes through
	public double distance;//distance between eye and view plane
	public Vector3D u, v, w;
	
	public abstract Ray createRay(Node2D point);
	
	public void computeUVW() {
		w = eye.subVec(lookAt);
		w.normalize();
		
		Vector3D up = new Vector3D(0.00424, 1.0, 0.00764);
		
		u = up.cross(w);
		u.normalize();
		
		v = w.cross(u);
		v.normalize();
		
	}
}

