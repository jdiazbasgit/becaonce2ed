package concierto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Teatro {

	public static void main(String[] args) throws IOException {
		Instrumento tambor = new Instrumento("pom,pom,pom");
		Instrumento trompeta = new Instrumento("tuuu, tuuu, tuuu");
		Instrumento guitarra = new Instrumento("tlan, tlan, tlan");
		Instrumento flauta = new Instrumento("pii, pii,pii");
		Musico Solista = new Solista(guitarra);
		//soSeta.tocar();

		Set<Instrumento> instrumentos = new HashSet<>();
		instrumentos.add(new Instrumento("nuevo sonido"));
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		instrumentos.add(flauta);
		instrumentos.add(trompeta);
		instrumentos.add(guitarra);
		instrumentos.add(tambor);
		
		Musico hombreOrquesta = new HombreOrquesta(instrumentos);
		hombreOrquesta.tocar();

		/*
		 * InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		 * String entrada = new BufferedReader(inputStreamReader).readLine(); Ventana
		 * ventana= new Ventana(); ventana.setVisible(true); if (entrada.equals("p"))
		 * ventana.setTitle(soSeta.getInstrumento().sonar()); else
		 * ventana.setTitle("has escrito "+entrada.toUpperCase()+" y tiene "+entrada.
		 * length()+" letras");
		 */

		/*
		 * GregorianCalendar fecha= new GregorianCalendar(2023,0,1);
		 * System.out.println(fecha.get(Calendar.WEEK_OF_YEAR));
		 */

	}

}
