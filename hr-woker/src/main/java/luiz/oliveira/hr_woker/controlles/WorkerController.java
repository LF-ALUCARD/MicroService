package luiz.oliveira.hr_woker.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import luiz.oliveira.hr_woker.entities.Worker;
import luiz.oliveira.hr_woker.services.WorkerService;

@RestController
@RequestMapping("api/worker")
public class WorkerController {

	@Autowired
	private WorkerService service;
	
	@GetMapping()
	public ResponseEntity<List<Worker>> findAll(@RequestParam(required = false) String name){
		return ResponseEntity.ok().body(service.findAll(name));
	}
	
}
