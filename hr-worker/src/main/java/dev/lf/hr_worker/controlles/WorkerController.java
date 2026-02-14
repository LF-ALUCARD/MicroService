package dev.lf.hr_worker.controlles;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lf.hr_worker.entities.Worker;
import dev.lf.hr_worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "api/workers")
public class WorkerController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		logger.info("PORT = {}", env.getProperty("local.server.port"));
		
		Worker obj = service.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}
}
