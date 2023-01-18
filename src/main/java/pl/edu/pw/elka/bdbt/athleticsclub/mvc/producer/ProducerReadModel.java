package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment.SportEquipment;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProducerReadModel {

    Integer number;
    String brand;
    String model;
    LocalDate productionYear;
    String destiny;

    public static ProducerReadModel toReadModel(final Producer entity) {
        return new ProducerReadModel(
                entity.getProducerNumber(),
                entity.getBrand(),
                entity.getModel(),
                entity.getProductionYear(),
                entity.getDestiny()
        );
    }

    @Override
    public String toString() {
        return brand + ", " + model;
    }
}
