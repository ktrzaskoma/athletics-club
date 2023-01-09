package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentProducerRepository extends JpaRepository<EquipmentProducer, Integer> {
}