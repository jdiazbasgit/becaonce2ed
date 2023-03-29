package once.curso.ejemplojpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entities.Charge;
import once.curso.ejemplojpa.repositories.ChargeCRUDRepository;

@Service
@Data
public class ChargeService {

	@Autowired
	private ChargeCRUDRepository chargeCRUDRepository;
	
	public void dameCargos() {
		
		Iterable<Charge> cargos= getChargeCRUDRepository().findAll();
		for (Charge charge : cargos) {
			System.out.println(charge.getDescription());
		}
	}
	
	public String[] dameCargosQueEmpiecenPor(String filtro){
		return getChargeCRUDRepository().dameCargosQueEmpiecenPor(filtro);
	}
	
}






