package pl.edu.pw.elka.bdbt.athleticsclub.model.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<Owners, Integer> {
}