package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.Facility;

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
    String inUse;

    public static EquipmentReadModel toReadModel(final Equipment entity) {
        return new EquipmentReadModel(
                entity.getSportEquipmentNumber(),
                entity.getDateOfPurchase(),
                entity.getNumberOfEquipment(),
                entity.getValueOfEquipment(),
                entity.getCondition(),
                resolveInUse(entity));
    }

    private static String resolveInUse(final Equipment entity) {
        return entity.getInUse() ? "Tak" : "Nie";
    }
}
