package chat;

import java.awt.Toolkit;

import javax.tools.Tool;

@SuppressWarnings("unused")
public class VerEjemploTamano {

	public static void main(String[] args) {
		EjemploTamano v= new EjemploTamano();
		v.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		v.setVisible(true);
	}

}
