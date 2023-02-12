package pelotas.hilos;


import pelotas.ventanas.VentanaPelotas;

public class Pintor extends Thread {
	
private VentanaPelotas ventanaPelotas;
	
	public Pintor(VentanaPelotas ventanaPelotas) {
		this.ventanaPelotas = ventanaPelotas;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getVentanaPelotas().repaint();
		}
		
	}

	

	public VentanaPelotas getVentanaPelotas() {
		return ventanaPelotas;
	}

	public void setVentanaPelotas(VentanaPelotas ventanaPelotas) {
		this.ventanaPelotas = ventanaPelotas;
	}

}
