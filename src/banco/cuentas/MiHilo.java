package banco.cuentas;

public class MiHilo extends Thread {
	
	private int tiempo;
	private String texto;
	
	public MiHilo( int tiempo, String texto) {
		this.tiempo=tiempo;
		this.texto=texto;
			
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(getTiempo());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getTexto());
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
