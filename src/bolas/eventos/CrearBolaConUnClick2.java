package bolas.eventos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class CrearBolaConUnClick2 extends JPanel {

 // private Point circlePos;
  private  ArrayList<Point> circulo;
  private int xSpeed = 2;
  private int ySpeed = 2;

  public CrearBolaConUnClick2() {
	  
	 circulo = new ArrayList<Point>();
	 circulo.add(new Point(100,100));
	 
	 Timer timer = new Timer(9,new TimerListener());
	 timer.start();
	 addMouseListener(new MouseAdapter() {
		  public void mousePressed(MouseEvent e) {
		    circulo.add(e.getPoint());
		    repaint();
		  }
		});

  }
  
  public void paintComponent(Graphics g) {
	  
	  super.paintComponent(g);
	  g.setColor(Color.RED);
	  for (Point p : circulo) {
	  g.fillOval(p.x, p.y, 10, 10);
	  }
	  }

	  private class TimerListener implements ActionListener {
		  
	  public void actionPerformed(ActionEvent e) {
		  
	  for (int i = 0; i < circulo.size(); i++) {
	  Point p = circulo.get(i);
	  p.x += xSpeed;
	  p.y += ySpeed;
	  if (p.x > getWidth() - 50 || p.x < 0) {
	  xSpeed = -xSpeed;
	  }
	  if (p.y > getHeight() - 50 || p.y < 0) {
	  ySpeed = -ySpeed;
	  }
	  }
	  repaint();
	  }
	  }

	  public static void main(String[] args) {
	  JFrame frame = new JFrame();
	  frame.setSize(200, 200);
	  frame.add(new CrearBolaConUnClick2());
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  }
	  }
		 /*   circlePos = new Point(100, 100);
		    circulo = new Point(150, 150);
		    addMouseListener(new MouseAdapter() {
		      public void mousePressed(MouseEvent e) {
		        circulo = e.getPoint();
		        repaint();
		      }
		    });
    Timer timer = new Timer(50, new TimerListener());
    timer.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.fillOval(circlePos.x, circlePos.y, 50, 50);
    g.fillOval(circulo.x, circulo.y, 50, 50);
  }

  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      circlePos.x += xSpeed;
      circlePos.y += ySpeed;
      if (circlePos.x > getWidth() - 50 || circlePos.x < 0) {
        xSpeed = -xSpeed;
      }
      if (circlePos.y > getHeight() - 50 || circlePos.y < 0) {
        ySpeed = -ySpeed;
      }
      
      circulo.x += xSpeed;
      circulo.y += ySpeed;
      if (circulo.x > getWidth() - 50 || circulo.x < 0) {
        xSpeed = -xSpeed;
      }
      if (circulo.y > getHeight() - 50 || circulo.y < 0) {
        ySpeed = -ySpeed;
      }
      repaint();
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(200, 200);
    frame.add(new CrearBolaConUnClick2());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);*/
  
