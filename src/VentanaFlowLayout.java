import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class VentanaFlowLayout extends Frame {

	public VentanaFlowLayout() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		Button b3 = new Button("tres");
		Button b4 = new Button("cuatro");
		Button b5 = new Button("cinco");
		Button b6 = new Button("seis");
		Button b7 = new Button("siete");
		Button b8 = new Button("uochono");
		Button b9 = new Button("nueve");
		Button b10 = new Button("diez");
		setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);

	}

}
