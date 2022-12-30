package pl.edu.pw.elka.bdbt.athleticsclub.owners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<Owners, Integer> {
}