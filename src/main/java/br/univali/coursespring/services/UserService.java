package br.univali.coursespring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.univali.coursespring.entities.User;
import br.univali.coursespring.repositories.UserRepository;
import br.univali.coursespring.services.exceptions.DatabaseException;
import br.univali.coursespring.services.exceptions.ResourceNotFoundExceptoin;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExceptoin(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptoin(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(long id, User obj) {
			try {
				
				User entity = userRepository.getReferenceById(id);
				updateData(entity, obj);
				return userRepository.save(entity);
			}	
			catch (EntityNotFoundException e) {
				throw new ResourceNotFoundExceptoin(id);
			}	
	}


	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
