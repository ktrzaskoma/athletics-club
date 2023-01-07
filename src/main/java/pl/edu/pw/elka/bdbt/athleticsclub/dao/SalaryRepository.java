package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}