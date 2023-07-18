package once.curso.proyectobanco.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.MappingFKDescription;
import once.curso.proyectobanco.repositories.MappingFKDescriptionCRUDRepository;

@Service
@Data
public class MappingFKDescriptionService {

	@Autowired
	private MappingFKDescriptionCRUDRepository mappingFKDescriptionCRUDRepository;

	@Autowired
	private EntityManager entityManager;

	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionCRUDRepository().findAll();
	}

	public long count() {
		return getMappingFKDescriptionCRUDRepository().count();
	}

	public Iterable<String> getTables() {
		List<String> listado = getMappingFKDescriptionCRUDRepository().getTables();
		System.out.println(listado);
		List<String> listadoFormateado = new ArrayList<String>();
		for (String tabla : listado) {
			String[] porPartes = tabla.split("_");
			String textoModificado = "";
			int j = 1;
			while (j <= porPartes.length) {
				if (j == 1) {
					textoModificado = textoModificado + porPartes[j - 1].toLowerCase();
					j++;					
				}
				if (j <= porPartes.length)
					textoModificado = textoModificado + porPartes[j - 1].substring(0, 1).toUpperCase()
							+ porPartes[j - 1].substring(1);
				j++;
			}
			if(!textoModificado.contains("mappingFkDescriptions"))
			listadoFormateado.add(textoModificado);
		}
		System.out.println(listadoFormateado);
		return listadoFormateado;
	}

}