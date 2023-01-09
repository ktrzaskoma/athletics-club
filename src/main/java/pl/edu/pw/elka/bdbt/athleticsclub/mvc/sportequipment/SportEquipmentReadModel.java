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

    Date dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;

    public static SportEquipmentReadModel toReadModel(final SportEquipment sportEquipment) {
        return new SportEquipmentReadModel(
                sportEquipment.getDateOfPurchase(),
                sportEquipment.getNumberOfEquipment(),
                sportEquipment.getValueOfEquipment(),
                sportEquipment.getCondition(),
                sportEquipment.getInUse()
        );
    }


}
