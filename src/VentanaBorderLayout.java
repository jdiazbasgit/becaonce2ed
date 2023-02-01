import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

import javafx.scene.layout.Border;

public class VentanaBorderLayout extends Frame {

	public VentanaBorderLayout() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		Button b3 = new Button("tres");
		Button b4 = new Button("cuatro");
		Button b5 = new Button("cinco");
		
		setLayout(new BorderLayout(20,20));
		System.out.println(BorderLayout.NORTH);
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		add(b3, BorderLayout.EAST);
		add(b4,BorderLayout.WEST);
		add(b5,BorderLayout.CENTER);
		

	}

}
