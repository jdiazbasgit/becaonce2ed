
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.Data;
import once.curso.proyectojpa.services.CardTypeService;
import once.curso.proyectojpa.services.CategoryService;
import once.curso.proyectojpa.services.ConfigurationService;
import once.curso.proyectojpa.services.DocumentTypeService;
import once.curso.proyectojpa.services.ExistingProductService;
import once.curso.proyectojpa.services.OrganizationService;
import once.curso.proyectojpa.services.ProfileService;
import once.curso.proyectojpa.services.RolService;
import once.curso.proyectojpa.services.SoldProductService;
import once.curso.proyectojpa.services.SubCategoryService;
import once.curso.proyectojpa.services.UserService;
import once.curso.proyectojpa.services.UsersService;

<<<<<<< HEAD
@Data
@SpringBootApplication
public class ProyectosApplication implements CommandLineRunner {

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ConfigurationService configurationservice;

	@Autowired
	private DocumentTypeService documentTypeService;

	@Autowired
	private ExistingProductService existingProductService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private RolService rolService;

	@Autowired
	private SoldProductService soldProductService;

	@Autowired
	private UserService userService;

	@Autowired
	private SubCategoryService subCategoryService;

	@Autowired
	private UsersService usersService;
=======
import bancoRepositories.AwardFineTypeRepository;
import bancoServices.AwardFineConfigurationService;
import bancoServices.AwardFineService;
import bancoServices.AwardFineTypeService;
import lombok.Data;
>>>>>>> 1316d9adc5a0aaa3e9eea623031cc82c69f5bdf6

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
<<<<<<< HEAD

		getCardTypeService().dameTipos();
		getCategoryService().dameCategorias();
		getConfigurationservice().dameConfiguraciones();
		getDocumentTypeService().dameTipoDocumentos();
		getExistingProductService().dameProductosExistentes();
		getOrganizationService().dameOrganizaciones();
		getProfileService().dameperfiles();
		getRolService().dameRoles();
		getSoldProductService().dameProductosVendidos();
		getSubCategoryService().damesubCat();
		getUserService().dameUsuario();
		getUsersService().dameClientes();
	}
=======
		
		getAwardFineService().dameMulta();
		getAwardFineConfigurationService().dameConfiguracionMulta();
		getAwardFineTypeService().dameTipoMulta();
		
	}

>>>>>>> 1316d9adc5a0aaa3e9eea623031cc82c69f5bdf6
}
