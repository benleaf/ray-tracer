package main;

import java.util.Random;

import utility.Color;
import utility.Node2D;
import utility.Node3D;
import utility.Ray;
import utility.Vector3D;
import window.CreateFrame;

public class Tracer {
	Random r = new Random();
	
	final double SIZE = CreateFrame.world.veiwPlane.size;
	final int WIDTH = CreateFrame.world.veiwPlane.width;
	final int HEIGHT = CreateFrame.world.veiwPlane.height;
	
	public void trace(int x, int y) {
		Color color = new Color(0.0F, 0.0F, 0.0F);
		Vector3D sun = new Vector3D(3,1,0);
		double min;
		int numOfSamples = CreateFrame.sampler.samples;
		boolean hit = false;
		
		for(int row = 0; row < numOfSamples; row++) {
			for(int col = 0; col < numOfSamples; col++) {
				Node2D point = CreateFrame.sampler.sample(row, col, x, y);
				Ray ray = CreateFrame.projection.createRay(point);
				Color closest = CreateFrame.world.background;
				min = Double.MAX_VALUE;
				for(int i = 0; i < CreateFrame.world.objects.size(); i++) {
					double rayHit = CreateFrame.world.objects.get(i).hit(ray);
					
					//ray bounce to light source
					if (rayHit != 0.0 && rayHit < min) {
						closest = CreateFrame.world.objects.get(i).color;
						double magOfRay = Math.abs(Math.sqrt((rayHit*rayHit)/
									(ray.direction.x*ray.direction.x+
									ray.direction.y*ray.direction.y+
									ray.direction.z*ray.direction.z)));
						
						Node3D rayHitPoint= new Node3D(
									ray.origin.x+ray.direction.x*magOfRay,
									ray.origin.y+ray.direction.y*magOfRay,
									ray.origin.z+ray.direction.z*magOfRay);
						
						Ray rayToLight = new Ray(rayHitPoint, sun);
						
						for(int j = 0; j < CreateFrame.world.objects.size(); j++) {
							if (CreateFrame.world.objects.get(j).hit(rayToLight) != 0.0) {
								closest = new Color((float) (closest.r*0.2),
									(float) (closest.g*(0.2)), (float) (closest.b*(0.2)));
								break;
							}
						}
						
						min = rayHit;
						hit = true;
					}
					
				}
				color.add(closest);
			}
		}
		color.divide(numOfSamples*numOfSamples);
		if(hit) {
			CreateFrame.image.buffer.setRGB(x, HEIGHT-y-1, color.toInteger());
		}else {
			CreateFrame.image.buffer.setRGB(x, HEIGHT-y-1, 
							CreateFrame.world.background.toInteger());
		}
	}
		
		
}