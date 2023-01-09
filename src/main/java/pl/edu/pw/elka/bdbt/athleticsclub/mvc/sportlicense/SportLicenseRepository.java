package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportLicenseRepository extends JpaRepository<SportLicense, Integer> {
}