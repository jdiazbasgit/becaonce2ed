package bolas.eventos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class    CrearBolaConUnClick extends JFrame {
	
	

public static void main(String[] args) {
	
    JFrame frame = new JFrame("Bola en clic");
    JPanel panel = new JPanel();
    panel.setLayout(null);
    
    panel.addMouseListener(new MouseAdapter() {
    
      public void mouseClicked(MouseEvent e) {
       Point point = e.getPoint();
        JLabel ball = new JLabel("Q");
        
        ball.setSize(new Dimension(20, 20));
        ball.setLocation(point);
        panel.add(ball);
        panel.repaint();
    	 // JLabel ball = new JLabel("CIRCULO");
    	   
    		  
    	  
    	  
    	    
    	    Timer timer = new Timer(10, new ActionListener() {
    	      int x = 0;
    	      int y = 0;
    	      int xSpeed = 2;
    	      int ySpeed = 2;
    	      
    	      public void actionPerformed(ActionEvent e) {
    	        x += xSpeed;
    	        y += ySpeed;
    	        if (x > panel.getWidth() - ball.getWidth() || x < 0) {
    	          xSpeed *= -1;
    	        }
    	        if (y > panel.getHeight() - ball.getHeight() || y < 0) {
    	          ySpeed *= -1;
    	        }
    	        ball.setLocation(x, y);
    	        panel.repaint();
    	      }
    	    });
    	    timer.start();
      }
    });
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}