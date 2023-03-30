package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.repositories.ChargeRepository;

@Service
@Data
public class ChargeService {

	@Autowired
	private ChargeRepository chargeRepository;
	
	public void dameCargos() {
		
		Iterable<Charge> cargos= getChargeRepository().findAll();
		for (Charge charge : cargos) {
			System.out.println(charge.getDescription());
		}
	}
	
	public String[] dameCargosQueEmpiecenPor(String filtro){
		return getChargeRepository().dameCargosQueEmpiecenPor(filtro);
	}
	
}






