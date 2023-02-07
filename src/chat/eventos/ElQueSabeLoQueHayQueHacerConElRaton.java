package chat.eventos;

import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener{
	@Override
	public void mouseClicked(MouseEvent e) {
		((TextField) e.getSource()).setText("");	
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}





