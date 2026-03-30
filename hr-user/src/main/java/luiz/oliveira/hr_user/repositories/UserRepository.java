package luiz.oliveira.hr_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import luiz.oliveira.hr_user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	User findByEmail(String email);
}
