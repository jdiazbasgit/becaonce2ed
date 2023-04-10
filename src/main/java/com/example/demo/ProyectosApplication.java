package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bancoservices.AwardFineConfigurationService;
import com.example.demo.bancoservices.AwardFineService;
import com.example.demo.bancoservices.AwardFineTypeService;
import com.example.demo.bancoservices.ConfigurationService;
import com.example.demo.bancoservices.CurrentAcountService;
import com.example.demo.bancoservices.DescriptionService;
import com.example.demo.bancoservices.FeeService;
import com.example.demo.bancoservices.IdentificationTypeService;
import com.example.demo.bancoservices.ProfileService;
import com.example.demo.bancoservices.RolService;
import com.example.demo.bancoservices.TransactionAwardFineService;
import com.example.demo.bancoservices.TransactionService;
import com.example.demo.bancoservices.TypeAccountService;
import com.example.demo.bancoservices.UserService;

import lombok.Data;

@SpringBootApplication
@Data
public class ProyectosApplication implements CommandLineRunner {

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

	@Autowired
	private RolService rolService;

	@Autowired
	private TransactionAwardFineService transactionAwardFineService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private TypeAccountService typeAccountService;
	
	@Autowired
	private UserService userService;

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
		getRolService().damePapel();
		getTransactionAwardFineService().dameMultaPorTransaccion();
		getTransactionService().dameTransaccion();
		getTypeAccountService().dameTipoDeCuenta();
		getUserService().dameUsuario();

	}

}
