package luiz.oliveira.hr_payroll.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import luiz.oliveira.hr_payroll.entities.Payment;
import luiz.oliveira.hr_payroll.service.PaymentService;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		return ResponseEntity.ok().body(service.getPayment(workerId, days));		
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
		return ResponseEntity.ok().body(new Payment("Luiz Felipe", 500.0, days));		
	}
}
