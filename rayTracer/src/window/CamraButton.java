package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CamraButton extends JButton implements ActionListener{
	
	private Window window;
	private int index;
	private float value;

	public CamraButton(String text, Window window,int index, float value) {
		this.setText(text);
		this.window = window;
		this.index = index;
		this.value = value;
		this.addActionListener(this);
		
	}
		

	public void actionPerformed(ActionEvent e) {
		window.setCamra(index, value);
	}

}
