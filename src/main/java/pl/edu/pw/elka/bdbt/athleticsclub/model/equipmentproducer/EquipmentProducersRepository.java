package pl.edu.pw.elka.bdbt.athleticsclub.model.equipmentproducer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentProducersRepository extends JpaRepository<EquipmentProducers, Integer> {
}