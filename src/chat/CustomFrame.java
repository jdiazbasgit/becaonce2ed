package chat;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class CustomFrame {
  public static void main(String[] args) {
    Frame frame = new Frame("Custom Frame");
    frame.setLayout(new BorderLayout());

    Panel panelNorth = new Panel();
    panelNorth.add(new Button("North"));
    Panel panelSouth = new Panel();
    panelSouth.add(new Button("South"));
    Panel panelWest = new Panel();
    panelWest.add(new Button("West"));
    Panel panelCenter = new Panel();
    panelCenter.add(new Button("Center"));

    frame.add(panelNorth, BorderLayout.NORTH);
    frame.add(panelSouth, BorderLayout.SOUTH);
    frame.add(panelWest, BorderLayout.WEST);
    frame.add(panelCenter, BorderLayout.CENTER);

    frame.setSize(800, 600);
    frame.setVisible(true);
  }
}
