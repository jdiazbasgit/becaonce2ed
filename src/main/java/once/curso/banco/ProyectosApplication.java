package once.curso.banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.banco.bancoservices.AwardFineConfigurationService;
import once.curso.banco.bancoservices.AwardFineService;
import once.curso.banco.bancoservices.AwardFineTypeService;
import once.curso.banco.bancoservices.ConfigurationService;
import once.curso.banco.bancoservices.CurrentAcountService;
import once.curso.banco.bancoservices.DescriptionService;
import once.curso.banco.bancoservices.FeeService;
import once.curso.banco.bancoservices.IdentificationTypeService;
import once.curso.banco.bancoservices.ProfileService;
import once.curso.banco.bancoservices.RolService;
import once.curso.banco.bancoservices.TransactionAwardFineService;
import once.curso.banco.bancoservices.TransactionService;
import once.curso.banco.bancoservices.TypeAccountService;
import once.curso.banco.bancoservices.UserService;

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
