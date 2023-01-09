package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFacilityRepository extends JpaRepository<SportFacility, Integer> {
}