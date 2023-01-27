package banco.cuentas;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TonteriaDeHilo {

	public static void main(String[] args) {
		/*System.out.println("Empezamos.......");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("estamos en clase");
		
		String nombre=null;
		
		if (true) {
			try {
				System.out.println(nombre.length());
			} catch (Exception e) {
				System.out.println("el nombre es nulo");
				//e.printStackTrace();
			}
			try {
				ApplicationContext cts = new ClassPathXmlApplicationContext("archivo a abrir");
			} catch (BeansException e) {
				System.out.println("el achivo no existe");
				e.printStackTrace();
			} 
		}*/
		
		MiHilo hilo1= new MiHilo(1000, "un segundo");
		MiHilo hilo2= new MiHilo(2000, "dos segundo");
		MiHilo hilo3= new MiHilo(3000, "tres segundo");
		MiHilo hilo4= new MiHilo(4000, "cuatro segundo");
		MiHilo hilo5= new MiHilo(5000, "cinco segundo");
		
		for(int i=0;i<100;i++) {
			int tiempo=(int)(Math.random()*10000);
			MiHilo hilo= new MiHilo(tiempo, "estoy en "+i+" y tardo "+tiempo);
			hilo.start();
		}
	}

}
