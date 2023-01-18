package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EquipmentReadModel {

    Integer number;
    LocalDate dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;

    public static EquipmentReadModel toReadModel(final Equipment entity) {
        return new EquipmentReadModel(
                entity.getSportEquipmentNumber(),
                entity.getDateOfPurchase(),
                entity.getNumberOfEquipment(),
                entity.getValueOfEquipment(),
                entity.getCondition(),
                entity.getInUse());
    }

}
