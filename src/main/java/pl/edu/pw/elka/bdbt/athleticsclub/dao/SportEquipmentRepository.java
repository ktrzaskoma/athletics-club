package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.SportEquipment;

@Repository
public interface SportEquipmentRepository extends JpaRepository<SportEquipment, Integer> {
}