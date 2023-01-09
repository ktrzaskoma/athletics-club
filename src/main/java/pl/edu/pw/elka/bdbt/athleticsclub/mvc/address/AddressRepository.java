package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address save (Address address);

}
