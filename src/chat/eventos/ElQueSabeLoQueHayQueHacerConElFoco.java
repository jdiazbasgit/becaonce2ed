package chat.eventos;

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ElQueSabeLoQueHayQueHacerConElFoco implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		((TextField) e.getSource()).setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {

	}

}