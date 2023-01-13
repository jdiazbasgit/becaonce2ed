package calendario;

import java.util.Locale;

public class Trabajo {

	public static void main(String[] args) {
		System.out.println(Utilidades.literalFecha(1992,7,19));
		System.out.println(Utilidades.literalFecha());
		System.out.println(Utilidades.literalFecha(2026,8,15,Locale.CHINA));
		System.out.println(Utilidades.literalFecha(2026,8,15,Locale.CHINESE));
		
		String[][] calendario=Utilidades.dameCalendario(7,1992);
		for(int i=0;i<calendario.length;i++) {
			for(int j=0;j<calendario[i].length;j++) {
				if(calendario[i][j].length()==1)
					calendario[i][j]=" "+calendario[i][j]+" ";
					else
						calendario[i][j]=calendario[i][j]+" ";
				System.out.print(calendario[i][j]+" ");
			}
			System.err.println();
		}

	}

}
