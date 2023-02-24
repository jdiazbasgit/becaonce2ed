package chat;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class EjemploTamano extends Frame {

	
	public EjemploTamano() {
		setLayout(new FlowLayout());
		TextArea t= new TextArea("scsdfgsd",20,20,TextArea.SCROLLBARS_NONE);
		add(t);
	}
}
