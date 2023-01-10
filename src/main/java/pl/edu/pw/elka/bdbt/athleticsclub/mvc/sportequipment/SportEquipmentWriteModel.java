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

    //to samo co w ReadModelu
    Date dateOfPurchase;
    Integer numberOfEquipment;
    BigDecimal valueOfEquipment;
    String condition;
    Boolean inUse;
    AthleticsClub athleticsClubEquipment;
    SportFacility equipmentStorage;
    EquipmentProducer equipmentProducer;

    public static SportEquipment toEntity(final SportEquipmentWriteModel writeModel) {
        var toSaveModel = new SportEquipment();
        toSaveModel.setCondition(writeModel.getCondition());
        //nie trzeba to pobierać z formularza
        toSaveModel.setDateOfPurchase(writeModel.getDateOfPurchase());
        toSaveModel.setNumberOfEquipment(writeModel.getNumberOfEquipment());
        toSaveModel.setValueOfEquipment(writeModel.getValueOfEquipment());
        toSaveModel.setInUse(writeModel.getInUse());
        //
        toSaveModel.setAthleticsClubEquipment(new AthleticsClub());
        //
        toSaveModel.setEquipmentProducer(new EquipmentProducer());
        //
        toSaveModel.setEquipmentStorage(new SportFacility());
        return toSaveModel;
    }
}
