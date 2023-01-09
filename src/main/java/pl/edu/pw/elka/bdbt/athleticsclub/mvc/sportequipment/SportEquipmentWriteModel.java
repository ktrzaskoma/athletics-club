package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer.EquipmentProducer;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility.SportFacility;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportEquipmentWriteModel {

    Date dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;
    AthleticsClub athleticsClubEquipment;
    SportFacility equipmentStorage;
    EquipmentProducer equipmentProducer;

    public static SportEquipment toWriteModel(final SportEquipmentWriteModel equipmentWriteModel) {
        var toSaveModel = new SportEquipment();
        toSaveModel.setCondition(equipmentWriteModel.condition);
        toSaveModel.setDateOfPurchase(equipmentWriteModel.dateOfPurchase);
        toSaveModel.setNumberOfEquipment(equipmentWriteModel.numberOfEquipment);
        toSaveModel.setValueOfEquipment(equipmentWriteModel.valueOfEquipment);
        toSaveModel.setInUse(equipmentWriteModel.inUse);
        toSaveModel.setAthleticsClubEquipment(new AthleticsClub());
        toSaveModel.setEquipmentProducer(new EquipmentProducer());
        toSaveModel.setEquipmentStorage(new SportFacility());
        return toSaveModel;
    }
}
