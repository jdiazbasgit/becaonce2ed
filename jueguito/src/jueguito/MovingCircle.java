package jueguito;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingCircle extends JFrame implements KeyListener {

    int x, y;
    int speed = 5;

    public MovingCircle() {
        addKeyListener(this);
        setTitle("Moving Circle");
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        x = getWidth() / 2;
        y = getHeight() - 50;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += speed;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new MovingCircle();
    }
}
