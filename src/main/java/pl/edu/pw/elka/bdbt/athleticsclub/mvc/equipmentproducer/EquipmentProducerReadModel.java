package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment.SportEquipment;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentProducerReadModel {

    String brand;
    String model;
    Date productionYear;
    String destiny;
    String sportEquipment;

    public static EquipmentProducerReadModel toReadModel(final EquipmentProducer equipmentProducer) {
        return new EquipmentProducerReadModel(
                equipmentProducer.getBrand(),
                equipmentProducer.getModel(),
                equipmentProducer.getProductionYear(),
                equipmentProducer.getDestiny(),
                equipmentProducer.getSportEquipment().stream().map(SportEquipment::getSportEquipmentNumber).toList().toString()
        );
    }
}
