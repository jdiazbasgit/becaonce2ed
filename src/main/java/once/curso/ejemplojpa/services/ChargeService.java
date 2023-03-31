





package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.repositories.ChargeRepository;

@Service//es una @Component con caracteristicas de service y me mete en el armario con amigos, puedo usarlos o no usarlos
@Data
public class ChargeService {//no tiene herencia de nada

	@Autowired //@autowire busca en el armario y la clase Charge esta en el aramario por que le hemos puesto @Repository
	
	private ChargeRepository chargeRepository;//
	
	public void dameCargos() {//crearemos un metodo que se llame dameCargos, nos devolveran los cargos
		
		//en Iterable todos los metodos del CRUD me los ha dado automaticamente
		//findAll me da un objeto iterable, es un objeto que se puede recorrer es una interface que tienen todas la colecciones
		
		
		Iterable<Charge> cargos= getChargeRepository().findAll();
		for (Charge charge : cargos) {//haremos un forEach
			System.out.println(charge.getDescription());//aqui le digo que nos de la descripcion del cargo
		}
	}
	
	public String[] dameCargosQueEmpiecenPor(String filtro){//aqui le diremos al MAIN
		return getChargeRepository().dameCargosQueEmpiecenPor(filtro);
	}
	public <S extends Charge> S save(S entity) {
		return getChargeRepository().save(entity);
	}

	public <S extends Charge> Iterable<S> saveAll(Iterable<S> entities) {
		return getChargeRepository().saveAll(entities);
	}

	public Optional<Charge> findById(Integer id) {
		return getChargeRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChargeRepository().existsById(id);
	}

	public Iterable<Charge> findAll() {
		return getChargeRepository().findAll();
	}

	public Iterable<Charge> findAllById(Iterable<Integer> ids) {
		return getChargeRepository().findAllById(ids);
	}

	public long count() {
		return getChargeRepository().count();
	}

	public void deleteById(Integer id) {
		getChargeRepository().deleteById(id);
		
	}

	public void delete(Charge entity) {
		getChargeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChargeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Charge> entities) {
		getChargeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChargeRepository().deleteAll();
	}
	
}






