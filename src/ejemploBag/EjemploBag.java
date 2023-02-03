package ejemploBag;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class EjemploBag extends Frame {
	public EjemploBag() {
		setSize(500, 500);
		Button b1 = new Button("Uno");
		Button b2 = new Button("Dos");
		Button b3 = new Button("tres");
		setLayout(new GridBagLayout());
		GridBagConstraints restriccionesB1 =new GridBagConstraints();
		GridBagConstraints restriccionesB2 =new GridBagConstraints();
		GridBagConstraints restriccionesB3 =new GridBagConstraints();
		restriccionesB1.gridx =0;
		restriccionesB1.gridy =0;
		restriccionesB1.weightx=1;
		restriccionesB1.weighty=1;		
	    restriccionesB1.fill=GridBagConstraints.BOTH;
		
		
		restriccionesB2.gridx =0;
		restriccionesB2.gridy =1;
		restriccionesB2.weightx=0.5;
		restriccionesB2.weighty=0.5;
		restriccionesB2.gridwidth=2;
		restriccionesB2.fill=GridBagConstraints.BOTH;
		
		
		
		Insets engordar=new Insets(50, 0, 0, 50);
		restriccionesB3.ipadx=20;
		restriccionesB3.ipady=50;
		restriccionesB3.insets=engordar;
		restriccionesB3.gridx =1;
		restriccionesB3.gridy =0;
		restriccionesB3.anchor=GridBagConstraints.NORTHEAST;
		restriccionesB3.fill=GridBagConstraints.BOTH;
		
		
		add(b2,restriccionesB2);
		add(b1,restriccionesB1);
		add(b3,restriccionesB3);
		
	}
}
