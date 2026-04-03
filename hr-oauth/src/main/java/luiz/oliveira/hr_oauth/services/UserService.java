package luiz.oliveira.hr_oauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.oliveira.hr_oauth.entities.User;
import luiz.oliveira.hr_oauth.feingclients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient repositor;
	
	public User findByEmail(String email) {
		User user = repositor.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("E-mail not found " + email);
			throw new IllegalArgumentException("E-mail not found");
		}
		
		logger.info("E-mail found: " + email);
		
		return user;
	}
	
}
