package pl.edu.pw.elka.bdbt.athleticsclub.salaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Integer> {
}