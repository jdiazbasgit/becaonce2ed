package once.curso.ejemplojpa.services;

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
	
}






