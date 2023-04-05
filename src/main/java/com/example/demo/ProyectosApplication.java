package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bancoRepositories.AwardFineTypeRepository;
import bancoServices.AwardFineConfigurationService;
import bancoServices.AwardFineService;
import bancoServices.AwardFineTypeService;
import lombok.Data;

@SpringBootApplication
@Data
public class ProyectosApplication implements CommandLineRunner{
	
	@Autowired
	private AwardFineService awardFineService;
	
	@Autowired
	private AwardFineConfigurationService awardFineConfigurationService;

	@Autowired
	private AwardFineTypeService AwardFineTypeService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		getAwardFineService().dameMulta();
		getAwardFineConfigurationService().dameConfiguracionMulta();
		getAwardFineTypeService().dameTipoMulta();
		
	}

}
