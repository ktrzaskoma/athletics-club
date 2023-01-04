package pl.edu.pw.elka.bdbt.athleticsclub.model.sportlicense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportLicensesRepository extends JpaRepository<SportLicenses, Integer> {
}