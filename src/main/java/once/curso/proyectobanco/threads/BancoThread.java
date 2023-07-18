package once.curso.proyectobanco.threads;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.entities.TransactionProgramer;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.ConfigurationService;
import once.curso.proyectobanco.services.CurrentAccountService;
import once.curso.proyectobanco.services.TransactionProgramerService;
import once.curso.proyectobanco.services.TransactionService;
import once.curso.proyectobanco.services.UserService;
@Data
public class BancoThread extends Thread {
	
	private ConfigurationService configurationService;
	
	private TransactionProgramerService transactionProgramerService;
	
	private CurrentAccountService currentAccountService;
	
	private TransactionService transactionService; 
	
	private UserService  userService;
	
	public BancoThread(ConfigurationService configurationService,CurrentAccountService currentAccountService, TransactionProgramerService transactionProgramerService,UserService  userService, TransactionService transactionService) {
		this.configurationService = configurationService;
		this.currentAccountService = currentAccountService;
		this.transactionProgramerService = transactionProgramerService;
		this.userService = userService;
		this.transactionService = transactionService;
	}
	
	
	@Override
	public void run() {
		List<Configuration> configuraciones=(List<Configuration>) getConfigurationService().findAll();
		int tiempo=configuraciones.get(0).getLiveTime();
		long tiempoActual=System.currentTimeMillis();
		GregorianCalendar fecha = new GregorianCalendar();
		while(true) {
			if(System.currentTimeMillis()>=tiempoActual+tiempo) {
				tiempoActual=System.currentTimeMillis();
				comprobarTransaccionesautomaticas(fecha);
				comprobarPremiosMultas(fecha);
				try {
					Thread.sleep(tiempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fecha.add(Calendar.DAY_OF_MONTH, 1);
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
					System.out.println(t.getDateStart().get(Calendar.DAY_OF_MONTH) + " - " + fecha.get(Calendar.DAY_OF_MONTH) + " - " +  t.getTimingType().getId());
					if(t.getDateStart().get(Calendar.DAY_OF_MONTH)==fecha.get(Calendar.DAY_OF_MONTH) && t.getTimingType().getId()==2) {
						Transaction transaction = new Transaction(0, fecha, t.getCurrent(), t.getDescription(), t.getCurrentAccount());
						getTransactionService().save(transaction);
					}
					
				});
			});
		});

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

}




















