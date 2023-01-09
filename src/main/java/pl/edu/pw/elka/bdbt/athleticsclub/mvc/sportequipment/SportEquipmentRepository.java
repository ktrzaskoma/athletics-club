package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEquipmentRepository extends JpaRepository<SportEquipment, Integer> {
}