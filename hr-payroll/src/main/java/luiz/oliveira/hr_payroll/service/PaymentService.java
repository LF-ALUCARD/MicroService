package luiz.oliveira.hr_payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import luiz.oliveira.hr_payroll.entities.Payment;
import luiz.oliveira.hr_payroll.entities.Worker;

@Service
public class PaymentService {

	@Value("$hr-worker.host")
	private String workerHost;

	@Autowired
	private RestTemplate rest;

	public Payment getPaymet(Long workerId, Integer days) {
		Map<String, String> url = new HashMap<>();
		url.put("id", ""+workerId);

		Worker worker = rest.getForObject(workerHost + "/worker/{id}", Worker.class, url);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
