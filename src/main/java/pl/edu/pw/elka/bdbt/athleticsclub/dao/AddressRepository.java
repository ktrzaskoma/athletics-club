package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address save (Address address);

}
