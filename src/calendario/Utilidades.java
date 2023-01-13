package calendario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Utilidades {

	public static String literalFecha(int year, int month, int day) {
		String resultado = "";

		GregorianCalendar fecha = new GregorianCalendar(year, month - 1, day);

		resultado = fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) + ", " + day + " de "
				+ fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " de " + year;

		return resultado;
	}

	public static String literalFecha(int year, int month, int day, Locale locale) {
		String resultado = "";

		GregorianCalendar fecha = new GregorianCalendar(year, month - 1, day);

		resultado = fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale) + ", " + day + " de "
				+ fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, locale) + " de " + year;

		return resultado;
	}

	public static String literalFecha() {
		String resultado = "";

		GregorianCalendar fecha = new GregorianCalendar();

		resultado = fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) + ", "
				+ fecha.get(Calendar.DAY_OF_MONTH) + " de "
				+ fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " de "
				+ fecha.get(Calendar.YEAR);

		return resultado;
	}

	public static String[][] dameCalendario(int month, int year) {
		String[][] resultado = null;
		GregorianCalendar diaUno = new GregorianCalendar(year, month - 1, 1);
		int diaSemanaDiaUno=diaUno.get(Calendar.DAY_OF_WEEK);
		int semanaDeMas=0;
		if(diaSemanaDiaUno==1 || (diaSemanaDiaUno>5 && diaSemanaDiaUno<=7))
			semanaDeMas=1;
		int numeroSemanas = diaUno.getActualMaximum(Calendar.WEEK_OF_MONTH);
		resultado = new String[numeroSemanas + 2+semanaDeMas][7];
		for(int i=0;i<resultado.length;i++) {
			for(int j=0;j<resultado[i].length;j++) {
				resultado[i][j]=" ";
			}
			System.err.println();
		}
		resultado[0][0] = "L";
		resultado[0][1] = "M";
		resultado[0][2] = "X";
		resultado[0][3] = "J";
		resultado[0][4] = "V";
		resultado[0][5] = "S";
		resultado[0][6] = "D";
		int ultimoDiaMes=diaUno.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1;i<=ultimoDiaMes;i++) {
			GregorianCalendar fechaDelDia= new GregorianCalendar(year,month-1,i);
			int fila=fechaDelDia.get(Calendar.WEEK_OF_MONTH);
			int diaSemana=fechaDelDia.get(Calendar.DAY_OF_WEEK);
			int columna=7;
			if(diaSemana<=7 && diaSemana>1)
				columna=diaSemana-1;
			resultado[fila+semanaDeMas][columna-1]=String.valueOf(i);
		}

		return resultado;
	}
}










