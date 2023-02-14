package chat;

import java.awt.Button;
import java.awt.Frame;


public class EjemploBounds extends Frame {
	
	public EjemploBounds() {
		setLayout(null);
		Button b= new Button("ejemplo bounds");
		b.setBounds(400, 400, 50, 20);
		setSize(500,500);
		this.add(b);
	}

}
