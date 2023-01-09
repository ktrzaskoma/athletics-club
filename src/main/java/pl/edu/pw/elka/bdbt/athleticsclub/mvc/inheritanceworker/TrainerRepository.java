package pl.edu.pw.elka.bdbt.athleticsclub.mvc.inheritanceworker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Worker> {
}