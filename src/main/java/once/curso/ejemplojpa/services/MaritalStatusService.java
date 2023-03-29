package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.MaritalEstatus;
import once.curso.ejemplojpa.repositories.MaritalStatusRepository;


@Data
@Service
public class MaritalStatusService {
	
	@Autowired
	private MaritalStatusRepository	maritalStatusRepository;
	
	public void dameEstados() {
		
		Iterable<MaritalEstatus> estados = getMaritalStatusRepository().findAll();
		for (MaritalEstatus maritalEstatus : estados) {
		System.out.println(maritalEstatus.getDescription());	
			
		}
				
	}
	public String[] dameEstados(String filtro) {
		
		return getMaritalStatusRepository().dameEstados(filtro);
		
	}
}
