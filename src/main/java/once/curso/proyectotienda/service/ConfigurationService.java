package once.curso.proyectotienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitiies.Configuration;
import once.curso.proyectotienda.repository.configurationRepository;

@Data
@Service
public class ConfigurationService {
	
	@Autowired
	private configurationRepository configurationRepository;
	
	public void dameConfiguraciones() {
		
		Iterable<Configuration > dameConfiguraciones = getConfigurationRepository().findAll();
		for (Configuration configuration : dameConfiguraciones) {
			System.out.println(configuration.getId());
			System.out.println(configuration.stockAlarm);
		}
		
	}

}
