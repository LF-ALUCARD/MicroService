package dev.lf.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lf.hr_worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
