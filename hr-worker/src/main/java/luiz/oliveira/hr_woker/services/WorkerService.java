package luiz.oliveira.hr_woker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import luiz.oliveira.hr_woker.config.WorkerSpecification;
import luiz.oliveira.hr_woker.entities.Worker;
import luiz.oliveira.hr_woker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repositor;

	public List<Worker> findAll(String nome) {

		Specification<Worker> spec = Specification.where(null);
		spec = spec.and(WorkerSpecification.nameContains(nome));

		return repositor.findAll(spec);
	}

	public Worker findById(Long id) {
		return repositor.findById(id).get();
	}
}
