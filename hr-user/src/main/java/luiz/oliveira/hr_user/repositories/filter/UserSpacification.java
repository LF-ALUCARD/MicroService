package luiz.oliveira.hr_user.repositories.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import luiz.oliveira.hr_user.entities.User;

@Component
public class UserSpacification {

	public static Specification<User> nameContains(String name){
		return (root, query, cb) -> 
		name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
	}
	
	public static Specification<User> emailContains(String email){
		return (root, query, cb) ->
		email == null ? null : cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
	}
}
