import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javafx.scene.layout.Border;

public class VentanaGridLayout extends Frame {

	public VentanaGridLayout() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		Button b3 = new Button("tres");
		Button b4 = new Button("cuatro");
		Button b5 = new Button("cinco");
		
		setLayout(new GridLayout(3, 2));
		System.out.println(BorderLayout.NORTH);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		

	}

}
