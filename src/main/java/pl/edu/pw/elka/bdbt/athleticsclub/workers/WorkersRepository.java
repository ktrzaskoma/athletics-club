package pl.edu.pw.elka.bdbt.athleticsclub.workers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> {
}