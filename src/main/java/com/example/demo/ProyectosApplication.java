package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bancoServices.AwardFineConfigurationService;
import com.example.demo.bancoServices.AwardFineService;
import com.example.demo.bancoServices.AwardFineTypeService;
import com.example.demo.bancoServices.ConfigurationService;
import com.example.demo.bancoServices.CurrentAcountService;
import com.example.demo.bancoServices.DescriptionService;
import com.example.demo.bancoServices.FeeService;
import com.example.demo.bancoServices.IdentificationTypeService;
import com.example.demo.bancoServices.ProfileService;
import com.example.demo.bancoServices.RolService;
import com.example.demo.bancoServices.TransactionAwardFineService;
import com.example.demo.bancoServices.TransactionService;
import com.example.demo.bancoServices.TypeAccountService;
import com.example.demo.bancoServices.UserService;

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
