package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Worker;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

        List<Worker> findAllByOrderByWorkerSalaryAsc();


}