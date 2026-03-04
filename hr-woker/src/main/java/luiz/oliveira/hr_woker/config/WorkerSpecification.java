package luiz.oliveira.hr_woker.config;

import org.springframework.data.jpa.domain.Specification;

import luiz.oliveira.hr_woker.entities.Worker;

public class WorkerSpecification {

	public static Specification<Worker> nameContains(String name){
		return (root, query, cb) ->
				name == null ? null :
				cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
	}
}
