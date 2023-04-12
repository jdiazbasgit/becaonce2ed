package once.curso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ObtenerTablaVentana extends JFrame {
	private int xMouse;
    private int yMouse;
    private static final int DURATION = 400; // Duración de la transición en milisegundos
    private static final int INTERVAL = 20; // Intervalo entre actualizaciones de la transición en milisegundos
    private static final float MAX_OPACITY = 1.0f; // Opacidad máxima de la ventana
	public ObtenerTablaVentana() {
		// Título de la ventana
		super("Mi ventana");

		// Loop Musica
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(ObtenerTablaVentana.class.getResourceAsStream("samurai.wav"));
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			// Thread.sleep(10000); // Espera 10 segundos
			// clip.stop();
			// clip.close();
			// inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Configuración de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 400));
		setLocationRelativeTo(null); // Centrar ventana en la pantalla
		

		// Creación del panel principal
		JPanel panel = new JPanel(new BorderLayout());
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setBackground(Color.BLACK);
		
		// Establecer la opacidad inicial de la ventana en cero
        setOpacity(0.0f);
        
        // Crear un temporizador para la transición de opacidad
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            private float opacity = 0.0f;
            private final long startTime = System.currentTimeMillis();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime > DURATION) {
                    // La transición ha finalizado, establecer la opacidad máxima
                    setOpacity(MAX_OPACITY);
                    ((Timer) e.getSource()).stop();
                } else {
                    // Actualizar la opacidad de la ventana
                    opacity = (float) elapsedTime / DURATION;
                    setOpacity(opacity > MAX_OPACITY ? MAX_OPACITY : opacity);
                }
            }
        });
        
        // Comenzar la transición de opacidad        
        timer.start();

		// Creación del panel para la imagen
		JPanel panelImagen = new JPanel(new BorderLayout());
		JLabel imagen = new JLabel();
		imagen.setPreferredSize(new Dimension(500, 200));
		ImageIcon icono = new ImageIcon("src\\main\\java\\once\\curso\\imagen.gif");
		imagen.setIcon(icono);
		panelImagen.add(imagen, BorderLayout.CENTER);

		// Arrastrable
		panelImagen.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelImagen.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen() - xMouse;
				int y = e.getYOnScreen() - yMouse;
				setLocation(x, y);
			}
		});

		// Creación del panel para el JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		// scrollPane.setPreferredSize(new Dimension(500, 150));

		// Creación del panel para el JTextField
		JTextField textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		// textField.setPreferredSize(new Dimension(500, 50));

		// Agregamos los paneles al panel principal
		panel.add(panelImagen, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(textField, BorderLayout.SOUTH);
		
		

		// Agregamos el panel principal a la ventana
		add(panel);

		// Hacemos visible la ventana
		setVisible(true);
		textField.requestFocus();
	}

	public static void main(String[] args) {
		new ObtenerTablaVentana();
	}
}
