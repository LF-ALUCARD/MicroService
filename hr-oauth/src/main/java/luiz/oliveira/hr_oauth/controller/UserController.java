package luiz.oliveira.hr_oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import luiz.oliveira.hr_oauth.entities.User;
import luiz.oliveira.hr_oauth.services.UserService;

@RestController
@RequestMapping("api/auth")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("login")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User user = service.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}
}
