package calendario;

import java.util.Locale;
import java.util.Scanner;

public class Trabajo {

	public static void main(String[] args) {
		System.out.println(Utilidades.literalFecha(2023, 9, 14));
		System.out.println(Utilidades.literalFecha());
		System.out.println(Utilidades.literalFecha(2023, 9, 14, Locale.CHINESE));
		
		
		

        int mes = 1;
        int ano = 2023;
		/*Scanner input = new Scanner(System.in);
        System.out.print("Ingresa el mes (en número): ");
        int mes = input.nextInt();
        System.out.print("Ingresa el año: ");
        int ano = input.nextInt();
        input.close();*/
		
		
		String[][] calendario=Utilidades.dameCalendario(mes, ano);
				for (int i = 0; i < calendario.length; i++) {
					for (int j=0; j < calendario[i].length; j++) {
						if (calendario[i][j].length()==1)
							calendario[i][j]= " "+calendario[i][j]+" ";
						else
							calendario[i][j]= calendario[i][j]+" ";
						
						System.out.print(calendario[i][j]+" ");
					}
					System.err.println();
				}
	}

}
