package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Trainer;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Worker;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Worker> {
}