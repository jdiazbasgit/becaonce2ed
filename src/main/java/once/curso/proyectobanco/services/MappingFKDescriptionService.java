package once.curso.proyectobanco.services;

import java.util.Optional;

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

	public Optional<MappingFKDescription> findById(Integer id) {
		return getMappingFKDescriptionCRUDRepository().findById(id);
	}

	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionCRUDRepository().findAll();
	}
	
	public Iterable<MappingFKDescription> findAllById(Iterable<Integer> ids) {
		return getMappingFKDescriptionCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getMappingFKDescriptionCRUDRepository().count();
	}

}