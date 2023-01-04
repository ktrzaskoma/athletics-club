package pl.edu.pw.elka.bdbt.athleticsclub.model.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Integer> {
    Addresses save (Addresses addresses);

}
