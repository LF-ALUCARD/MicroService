package dev.lf.hr_payroll.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lf.hr_payroll.entities.Payment;
import dev.lf.hr_payroll.services.PaymentService;

@RestController
@RequestMapping(value = "api/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		
		return ResponseEntity.ok().body(service.getPayment(workerId, days));
	}
}
