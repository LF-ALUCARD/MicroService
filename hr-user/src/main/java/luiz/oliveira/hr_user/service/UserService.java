package luiz.oliveira.hr_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import luiz.oliveira.hr_user.entities.User;
import luiz.oliveira.hr_user.repositories.UserRepository;
import luiz.oliveira.hr_user.repositories.filter.UserSpacification;

@Service
public class UserService {

	@Autowired
	private UserRepository repositor;
	
	public List<User> findAll(String nome, String email){
		
		Specification<User> spec = Specification.where(null);
		
		if (nome != null && !nome.isBlank()) {
			spec = spec.and(UserSpacification.nameContains(nome));
		}
		
		if (email != null && !email.isBlank()) {
			spec = spec.and(UserSpacification.emailContains(email));
		}
		
		return repositor.findAll(spec);
	}
	
	public User findById(Long id) {
		return repositor.findById(id).get();
	}
	
	public User findByEmail(String email) {
		return repositor.findByEmail(email);
	}
}
