package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bancoRepositories.AwardFineTypeRepository;
import bancoRepositories.DescriptionRepository;
import bancoServices.AwardFineConfigurationService;
import bancoServices.AwardFineService;
import bancoServices.AwardFineTypeService;
import bancoServices.ConfigurationService;
import bancoServices.CurrentAcountService;
import bancoServices.DescriptionService;
import bancoServices.FeeService;
import bancoServices.IdentificationTypeService;
import bancoServices.ProfileService;
import lombok.Data;

@SpringBootApplication
@Data
public class ProyectosApplication implements CommandLineRunner{
	
	@Autowired
	private AwardFineService awardFineService;
	
	@Autowired
	private AwardFineConfigurationService awardFineConfigurationService;

	@Autowired
	private AwardFineTypeService awardFineTypeService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	@Autowired
	private CurrentAcountService currentAcountService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private FeeService feeService;
	
	@Autowired
	private IdentificationTypeService identificationTypeService;
	
	@Autowired
	private ProfileService profileService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		getAwardFineService().dameMulta();
		getAwardFineConfigurationService().dameConfiguracionMulta();
		getAwardFineTypeService().dameTipoMulta();
		getConfigurationService().dameConfiguracion();
		getCurrentAcountService().dameDeposito();
		getDescriptionService().dameDescripcion();
		getFeeService().dameTarifa();
		getIdentificationTypeService().dameIdentificacion();
		getProfileService().damePerfil();
		
	}

}
