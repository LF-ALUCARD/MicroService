package luiz.oliveira.hr_payroll.feingclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import luiz.oliveira.hr_payroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/api/worker")
public interface WorkerFeignClient {

	@GetMapping("{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
