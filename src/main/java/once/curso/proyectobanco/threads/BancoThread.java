package once.curso.proyectobanco.threads;

import java.awt.SystemColor;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.TransactionProgramer;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.ConfigurationService;
import once.curso.proyectobanco.services.CurrentAccountService;
import once.curso.proyectobanco.services.TransactionProgramerService;
import once.curso.proyectobanco.services.UserService;
@Data
public class BancoThread extends Thread {
	
	private ConfigurationService configurationService;
	
	private TransactionProgramerService transactionProgramerService;
	
	private CurrentAccountService currentAccountService;
	
	private UserService  userService;
	
	public BancoThread(ConfigurationService configurationService,CurrentAccountService currentAccountService, TransactionProgramerService transactionProgramerService,UserService  userService) {
		this.configurationService = configurationService;
		this.currentAccountService = currentAccountService;
		this.transactionProgramerService = transactionProgramerService;
		this.userService = userService;
	}
	
	
	@Override
	public void run() {
		List<Configuration> configuraciones=(List<Configuration>) getConfigurationService().findAll();
		int tiempo=configuraciones.get(0).getLiveTime();
		long tiempoActual=System.currentTimeMillis();
		while(true) {
			GregorianCalendar fecha = new GregorianCalendar();
			if(System.currentTimeMillis()>=tiempoActual+tiempo) {
				tiempoActual=System.currentTimeMillis();
				comprobarTransaccionesautomaticas(fecha);
				comprobarPremiosMultas(fecha);
			}
		}
	}


	private void comprobarPremiosMultas(GregorianCalendar fecha) {
	}


	private void comprobarTransaccionesautomaticas(GregorianCalendar fecha) {

		List<User> users = (List<User>) getUserService().findAll();
		users.stream().forEach(u->{
			List<CurrentAccount> currentAccounts = getCurrentAccountService().getCurrentAccountsByUser(u.getUser());
			currentAccounts.stream().forEach(c->{
				List<TransactionProgramer> transactionProgramers = getTransactionProgramerService().getTransactionsByCurrentAccount(c.getId());
				transactionProgramers.stream().forEach(t->{
					
				});
			});
		});

	}



	

}




















