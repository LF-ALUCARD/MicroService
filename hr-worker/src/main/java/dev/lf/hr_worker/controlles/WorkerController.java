package dev.lf.hr_worker.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private WorkerRepository service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker obj = service.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}
}
