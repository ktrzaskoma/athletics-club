package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

        List<Worker> findAllByOrderByWorkerSalaryAsc();
}