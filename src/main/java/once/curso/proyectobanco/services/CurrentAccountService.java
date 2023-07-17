package once.curso.proyectobanco.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import once.curso.proyectobanco.dtos.CurrentAccountCreateDto;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.repositories.CurrentAccountCRUDRepository;
import once.curso.proyectobanco.repositories.DescriptionCRUDRepository;
import once.curso.proyectobanco.repositories.FeeCRUDRepository;
import once.curso.proyectobanco.repositories.TransactionCRUDRepository;
import once.curso.proyectobanco.repositories.TypeAccountCRUDRepository;
import once.curso.proyectobanco.repositories.UserCRUDRepository;

@Data
@Service
public class CurrentAccountService {
	@Autowired
	private CurrentAccountCRUDRepository currentAccountCRUDRepository;
	@Autowired
	private FeeCRUDRepository feeCRUDRepository;
	@Autowired
	private TypeAccountCRUDRepository typeAccountCRUDRepository;
	@Autowired
	private UserCRUDRepository userCRUDRepository;
	@Autowired
	private DescriptionCRUDRepository descriptionCRUDRepository;
	@Autowired
	private TransactionCRUDRepository transactionCRUDRepository;
	
	public Iterable<CurrentAccount>dameCuentas() {
		return getCurrentAccountCRUDRepository().findAll();
	
	}

	public <S extends CurrentAccount> S save(S entity) {
		return getCurrentAccountCRUDRepository().save(entity);
		
	}

	public <S extends CurrentAccount> Iterable<S> saveAll(Iterable<S> entities) {
		return getCurrentAccountCRUDRepository().saveAll(entities);
	}

	public Optional<CurrentAccount> findById(Integer id) {
		return getCurrentAccountCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getCurrentAccountCRUDRepository().existsById(id);
	}

	public Iterable<CurrentAccount> findAll() {
		return getCurrentAccountCRUDRepository().findAll();
	}
		
		public Page<CurrentAccount> findAll(Pageable pageable){
			return getCurrentAccountCRUDRepository().findAll(pageable);
		}
	

	public Iterable<CurrentAccount> findAllById(Iterable<Integer> ids) {
		return getCurrentAccountCRUDRepository().findAllById(ids);
	}

	public List<CurrentAccount> getCurrentAccountsByUser(String userName){
		return getCurrentAccountCRUDRepository().getCurrentAccountsByUser(userName);
	}
	public long count() {
		return getCurrentAccountCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getCurrentAccountCRUDRepository().deleteById(id);
	}

	public void delete(CurrentAccount entity) {
		getCurrentAccountCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCurrentAccountCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CurrentAccount> entities) {
		getCurrentAccountCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCurrentAccountCRUDRepository().deleteAll();
	}
	@Transactional
	public boolean createCurrentAccount(CurrentAccountCreateDto currentAccountCreateDto){
		CurrentAccount ca = new CurrentAccount();
		ca.setNumber(Integer.parseInt(getCurrentAccountCRUDRepository().getLastCurrentAccount())+1);
		ca.setCreationDate(Calendar.getInstance());
		ca.setFee((getFeeCRUDRepository().findAll()).iterator().next());
		ca.setTypeAccount(getTypeAccountCRUDRepository().findById(currentAccountCreateDto.getTypeAccount()).get());
		ca.setUser(getUserCRUDRepository().loadUserByUsername(currentAccountCreateDto.getUser()));
		Transaction t = new Transaction();
		t.setCurrent(0);
		t.setDate(Calendar.getInstance());
		t.setDescription(getDescriptionCRUDRepository().findById(15).get());
		t.setCurrentAccount(getCurrentAccountCRUDRepository().save(ca));		
		return getTransactionCRUDRepository().existsById((getTransactionCRUDRepository().save(t)).getId());
	}

	 
	
}
