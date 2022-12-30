package pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFacilitiesRepository extends JpaRepository<SportFacilities, Integer> {
}