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

 
	/*
	 * private ArrayList<Point> circulo; private int xSpeed = 2; private int ySpeed
	 * = 2;
	 * 
	 * public CrearBolaConUnClick2() {
	 * 
	 * circulo = new ArrayList<Point>(); circulo.add(new Point(100,100));
	 * 
	 * Timer timer = new Timer(9,new TimerListener()); timer.start();
	 * addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent e)
	 * { circulo.add(e.getPoint()); repaint(); } });
	 * 
	 * }
	 * 
	 * public void paintComponent(Graphics g) {
	 * 
	 * super.paintComponent(g); g.setColor(Color.RED); for (Point p : circulo) {
	 * g.fillOval(p.x, p.y, 10, 10); } }
	 * 
	 * private class TimerListener implements ActionListener {
	 * 
	 * public void actionPerformed(ActionEvent e) {
	 * 
	 * for (int i = 0; i < circulo.size(); i++) { Point p = circulo.get(i); p.x +=
	 * xSpeed; p.y += ySpeed; if (p.x > getWidth() - 50 || p.x < 0) { xSpeed =
	 * -xSpeed; } if (p.y > getHeight() - 50 || p.y < 0) { ySpeed = -ySpeed; } }
	 * repaint(); } }
	 * 
	 * public static void main(String[] args) { JFrame frame = new JFrame();
	 * frame.setSize(200, 200); frame.add(new CrearBolaConUnClick2());
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
	 * } }
	 */
private ArrayList<Point> circulo;
private ArrayList<Integer> numChoques;
private int xSpeed = 2;
private int ySpeed = 2;

public CrearBolaConUnClick2() {
  circulo = new ArrayList<Point>();
  numChoques = new ArrayList<Integer>();
  circulo.add(new Point(100, 100));
  numChoques.add(0);

  Timer timer = new Timer(9, new TimerListener());
  timer.start();
  addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
      circulo.add(e.getPoint());
      numChoques.add(0);
      repaint();
    }
  });
}

public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.setColor(Color.RED);
  for (int i = 0; i < circulo.size(); i++) {
    Point p = circulo.get(i);
    int choques = numChoques.get(i);
    if (choques < 3) {
      g.fillOval(p.x, p.y, 10, 10);
    }
  }
}

private class TimerListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < circulo.size(); i++) {
      Point p = circulo.get(i);
      int choques = numChoques.get(i);
      p.x += xSpeed;
      p.y += ySpeed;
      if (p.x > getWidth() - 50 || p.x < 0) {
        xSpeed = -xSpeed;
        choques++;
      }
      if (p.y > getHeight() - 50 || p.y < 0) {
        ySpeed = -ySpeed;
        choques++;
      }
      numChoques.set(i, choques);
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