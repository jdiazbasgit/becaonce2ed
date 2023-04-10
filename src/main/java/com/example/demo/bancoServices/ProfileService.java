package com.example.demo.bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoEntityes.Profile;
import com.example.demo.bancoRepositories.ProfileRepository;

import lombok.Data;

@Data
@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public void damePerfil() {
		Iterable<Profile> perfil= getProfileRepository().findAll();
		for (Profile profile : perfil) {
			System.out.println(profile.getName());
			System.out.println(profile.getSecondName());
			System.out.println(profile.getIdentification());
			System.out.println(profile.getEmail());
			System.out.println(profile.getPhone());
			System.out.println(profile.getImage());
			System.out.println(profile.getIdentificationType());
			System.out.println(profile.getUser());
			
		}
	}
	public long count() {
		return getProfileRepository().count();
	}

	public void delete(Profile entity) {
		getProfileRepository().delete(entity);
	}

	public void deleteAll() {
		getProfileRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfileRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfileRepository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getProfileRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getProfileRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {
		return getProfileRepository().findAll();
	}

	public Iterable<Profile> findAllById(Iterable<Integer> ids) {
		return getProfileRepository().findAllById(ids);
	}

	public Optional<Profile> findById(Integer id) {
		return getProfileRepository().findById(id);
	}

	public <S extends Profile> S save(S entity) {
		return getProfileRepository().save(entity);
	}

	public <S extends Profile> Iterable<S> saveAll(Iterable<S> entities) {
		return getProfileRepository().saveAll(entities);
	}
}
