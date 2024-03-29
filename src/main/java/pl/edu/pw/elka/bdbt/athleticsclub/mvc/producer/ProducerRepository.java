package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}