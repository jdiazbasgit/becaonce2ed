package concierto;

public class EjemploFactory {

	public static void main(String[] args) {
		
		
		PublicoFactory p1= PublicoFactory.of();
		PublicoFactory p2= PublicoFactory.of();
		PublicoFactory p3= PublicoFactory.of();
		PublicoFactory p4= PublicoFactory.of();
		PublicoFactory p5= PublicoFactory.of();
		PublicoFactory p6= PublicoFactory.of();
		PublicoFactory p7= PublicoFactory.of();
		p1.setEntrada("gallinero");
		p2.setEntrada("anfiteatro");
		p3.setEntrada("palco");
		p4.setEntrada("butaca");
		p5.setEntrada("palco");
		
		System.out.println(p1.getEntrada());
		System.out.println(p2.getEntrada());
		System.out.println(p3.getEntrada());
		System.out.println(p4.getEntrada());
		System.out.println(p5.getEntrada());
		
		
		

	}

}
