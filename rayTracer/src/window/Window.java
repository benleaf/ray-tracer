package window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	JPanel buttonGrid = new JPanel();
	JLabel lable = new JLabel();
	CreateFrame frame;
	
	
	private float vectorX ;
	private float vectorY;
	private float vectorZ;
	private float posX;
	private float posY;
	private float posZ;
	private float FOV;
	
	public Window(int width, int height) {
		vectorX = -200;
		vectorY = 200;
		vectorZ = 200; 
		posX = 0;
		posY = 0;
		posZ = 0;
		FOV = 15;
		
		frame = new CreateFrame(width, height);
		
		this.setLayout(new BorderLayout());
		buttonGrid.setLayout(new GridLayout(7,3));
		this.add(buttonGrid, BorderLayout.SOUTH);
		
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ray Tracer");
		
		String[] buttonNames = {"vectorX","vectorY","vectorZ","posX","posY","posZ","FOV"};
		
		for(int i = 0; i < 7; i++) {
			buttonGrid.add(new CamraButton(buttonNames[i],this,i,30), BorderLayout.EAST);
			buttonGrid.add(new CamraButton("-"+buttonNames[i],this,i,-30), BorderLayout.EAST);
		}
			
		
		
		this.setVisible(true);
		setImage();
	}
	
	public void setImage() {
		this.remove(lable);
		lable.setIcon(frame.generateFrame(vectorX, vectorY, vectorZ, posX, posY, posZ, FOV));
		this.add(lable, BorderLayout.CENTER);
		this.repaint();
		this.pack();
	}
	
	public void setCamra(int index, float value) {
		switch(index) {
			case 0:
				vectorX += value;
				break;
			case 1:
				vectorY += value;
				break;
			case 2:
				vectorZ += value;
				break;
			case 3:
				posX += value;
				break;
			case 4:
				posY += value;
				break;
			case 5:
				posZ += value;
				break;
			default:
				FOV += value;
				break;
		}
		setImage();
	}
}