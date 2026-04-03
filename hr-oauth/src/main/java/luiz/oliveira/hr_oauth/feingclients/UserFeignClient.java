package luiz.oliveira.hr_oauth.feingclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import luiz.oliveira.hr_oauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "api/users")
public interface UserFeignClient {

	@GetMapping("login")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
