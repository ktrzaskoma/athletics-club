package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SportEquipmentReadModel {

    Integer number;
    LocalDate dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;

    public static SportEquipmentReadModel toReadModel(final SportEquipment entity) {
        return new SportEquipmentReadModel(
                entity.getSportEquipmentNumber(),
                entity.getDateOfPurchase(),
                entity.getNumberOfEquipment(),
                entity.getValueOfEquipment(),
                entity.getCondition(),
                entity.getInUse());
    }

}
