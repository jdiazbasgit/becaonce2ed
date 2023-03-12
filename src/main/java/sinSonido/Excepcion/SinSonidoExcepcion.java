package sinSonido.Excepcion;

import org.springframework.stereotype.Component;

import concierto.anotaciones.Conectar;
import lombok.Data;

@Component
@Data
public class SinSonidoExcepcion extends Exception {


		
    public SinSonidoExcepcion() {
    	 System.out.println("concierto arreglado");
	}
	

}
