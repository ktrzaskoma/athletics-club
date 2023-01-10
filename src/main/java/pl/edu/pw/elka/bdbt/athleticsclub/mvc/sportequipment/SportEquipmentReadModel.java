package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportEquipmentReadModel {

    //to może być dzień dzisiejszy, ale trzeba znowu zmienić format daty / ewentualnie sprawdzić czy taki naprawdę potrzebujemy
    Date dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;

    public static SportEquipmentReadModel toReadModel(final SportEquipment entity) {
        return new SportEquipmentReadModel(
                entity.getDateOfPurchase(),
                entity.getNumberOfEquipment(),
                entity.getValueOfEquipment(),
                entity.getCondition(),
                entity.getInUse()
        );
    }


}
