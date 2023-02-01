import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

@SuppressWarnings("serial")
public class EjemploLayouts extends Frame {

	public EjemploLayouts() {
		this.setSize(800, 800);
		this.setLayout(new GridLayout(2, 2));
		
		Label l1 = new Label("uno");
		Label l2 = new Label("dos");
		l2.setBackground(Color.CYAN);
		Label l3 = new Label("tres");
		Label l4 = new Label("cuatro");

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		p1.setBackground(Color.RED);
		p2.setBackground(Color.GREEN);
		p3.setBackground(Color.YELLOW);
		
		Panel pCentral= new Panel();
		pCentral.setBackground(Color.LIGHT_GRAY);
		pCentral.setLayout(new BorderLayout());
		pCentral.add(l1,BorderLayout.SOUTH);
		Panel pSuperior= new Panel();
		pSuperior.setLayout(new FlowLayout());
		pSuperior.add(l2);
		pCentral.add(pSuperior,BorderLayout.NORTH);
		pCentral.add(l3,BorderLayout.EAST);
		pCentral.add(l4,BorderLayout.WEST);
		
		this.add(pCentral);
		this.add(p1);
		this.add(p2);
		//this.add(p3);
		
		
		
		Panel pFlow= new Panel();
		pFlow.add(new Checkbox());
		pFlow.add(new Checkbox());
		pFlow.add(new Checkbox());
		pFlow.add(new Checkbox());
		pFlow.add(new Checkbox());
		
		pCentral.add(pFlow,BorderLayout.CENTER);
		
		

	}
}
