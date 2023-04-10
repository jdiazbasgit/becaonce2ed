package com.example.demo.bancoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoentityes.Rol;
import com.example.demo.bancorepositories.RolRepository;

import lombok.Data;

@Data
@Service
public class RolService {

	@Autowired
	private RolRepository repository;

	public void damePapel() {

		Iterable<Rol> papel = getRepository().findAll();
		for (Rol rol : papel) {
			System.out.println(rol.getRol());
		}
	}

	public <S extends Rol> S save(S entity) {
		return getRepository().save(entity);
	}

	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		return getRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {
		return getRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {
		return getRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {
		return getRepository().findAllById(ids);
	}

	public long count() {
		return getRepository().count();
	}

	public void deleteById(Integer id) {
		getRepository().deleteById(id);
	}

	public void delete(Rol entity) {
		getRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		getRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}
}
