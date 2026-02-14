package dev.lf.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lf.hr_payroll.entities.Payment;
import dev.lf.hr_payroll.entities.Worker;
import dev.lf.hr_payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
