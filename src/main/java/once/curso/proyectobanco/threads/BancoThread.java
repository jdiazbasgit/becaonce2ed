package once.curso.proyectobanco.threads;

import java.awt.SystemColor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.services.ConfigurationService;
@Data
@Component
public class BancoThread extends Thread {
	
	private ConfigurationService configurationService;
	
	public BancoThread(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}
	
	
	@Override
	public void run() {
		List<Configuration> configuraciones=(List<Configuration>) getConfigurationService().findAll();
		int tiempo=configuraciones.get(0).getLiveTime();
		long tiempoActual=System.currentTimeMillis();
		while(true) {
			if(System.currentTimeMillis()>=tiempoActual+tiempo) {
				tiempoActual=System.currentTimeMillis();
				comprobarTransaccionesautomaticas();
				comprobarPremiosMultas();
			}
		}
	}


	private void comprobarPremiosMultas() {
	}


	private void comprobarTransaccionesautomaticas() {

		
	}



	

}
