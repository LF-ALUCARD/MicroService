package luiz.oliveira.hr_woker.controlles;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@GetMapping()
	public ResponseEntity<List<Worker>> findAll(@RequestParam(required = false) String name){
		return ResponseEntity.ok().body(service.findAll(name));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
}
