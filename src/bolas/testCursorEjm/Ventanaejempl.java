package bolas.testCursorEjm;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventanaejempl extends JFrame {
    public Ventanaejempl() {
        // Establecer el título de la ventana
        this.setTitle("Mi ventana");

        // Establecer el icono de la ventana
        ImageIcon icono = new ImageIcon("ruta/al/icono.png");
        this.setIconImage(icono.getImage());

        // Crear el objeto GridBagLayout y asignarlo al JFrame
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        // Crear dos objetos JPanel y darles color
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        // Crear un objeto GridBagConstraints y configurarlo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.75; // JPanel 1 ocupa 3/4 del espacio disponible
        gbc.weighty = 1.0; // JPanel 1 se extiende verticalmente

        // Agregar el primer JPanel al JFrame usando add() y el objeto GridBagConstraints
        this.add(panel1, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.25; // JPanel 2 ocupa 1/4 del espacio disponible
        gbc.weighty = 1.0; // JPanel 2 se extiende verticalmente
        gbc.insets.left = 10;
        this.add(panel2, gbc);

        // Configurar la ventana
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventanaejempl();
    }
}

