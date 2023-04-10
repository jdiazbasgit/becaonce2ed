package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.proyectoBancojpa.services.AwardFineConfigurationService;
import once.curso.proyectoBancojpa.services.AwardFineService;
import once.curso.proyectoBancojpa.services.AwardFineTypeService;

@SpringBootApplication
@Data
public class ProyectosApplication implements CommandLineRunner{
	
	@Autowired 
	AwardFineService AwardFineService;
	
	@Autowired
	AwardFineConfigurationService AwardFineConfigurationService;
	
	@Autowired
	AwardFineTypeService awardFineTypeService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		getAwardFineService().dameTipoPremiosMultas();
		getAwardFineConfigurationService().damePremiosMultasConfiguraciones();
		getAwardFineTypeService().dameAwardFineType();
	}
}
