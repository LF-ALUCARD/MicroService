package luiz.oliveira.hr_payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.oliveira.hr_payroll.entities.Payment;
import luiz.oliveira.hr_payroll.entities.Worker;
import luiz.oliveira.hr_payroll.feingclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPaymet(Long workerId, Integer days) {
		Map<String, String> url = new HashMap<>();
		url.put("id", ""+workerId);

		Worker worker = workerFeignClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
