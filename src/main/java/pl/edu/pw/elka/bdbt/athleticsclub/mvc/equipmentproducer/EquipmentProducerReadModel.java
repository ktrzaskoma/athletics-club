package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment.SportEquipment;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentProducerReadModel {

    String brand;
    String model;
    LocalDate productionYear;
    String destiny;
    // TODO: CHECK THIS!
    String sportEquipment;

    public static EquipmentProducerReadModel toReadModel(final EquipmentProducer entity) {
        return new EquipmentProducerReadModel(
                entity.getBrand(),
                entity.getModel(),
                entity.getProductionYear(),
                entity.getDestiny(),
                entity.getSportEquipment().stream().map(SportEquipment::getSportEquipmentNumber).toList().toString()
        );
    }
}
