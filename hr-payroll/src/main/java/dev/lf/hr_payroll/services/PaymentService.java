package dev.lf.hr_payroll.services;

import org.springframework.stereotype.Service;

import dev.lf.hr_payroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		
		return new Payment("Maria", 400.0, days);		
	}
	
}
