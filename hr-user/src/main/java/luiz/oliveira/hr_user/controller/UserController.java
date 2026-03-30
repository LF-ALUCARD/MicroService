package luiz.oliveira.hr_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import luiz.oliveira.hr_user.entities.User;
import luiz.oliveira.hr_user.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
		List<User> list = service.findAll(nome, email);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping("login")
	public ResponseEntity<User> findById(@RequestParam String email){
		return ResponseEntity.ok().body(service.findByEmail(email));
	}
}
