package luiz.oliveira.hr_payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.oliveira.hr_payroll.entities.Payment;
import luiz.oliveira.hr_payroll.entities.Worker;
import luiz.oliveira.hr_payroll.feingclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
				
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
