package pl.edu.pw.elka.bdbt.athleticsclub.model.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.Worker;

@Repository
public interface TrainersRepository extends JpaRepository<Trainers, Worker> {
}