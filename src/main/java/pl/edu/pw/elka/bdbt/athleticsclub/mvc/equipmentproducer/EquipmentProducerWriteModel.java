package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentProducerWriteModel {

    String brand;
    String model;
    Date productionYear;
    String destiny;

    public static EquipmentProducer toWriteModel(final EquipmentProducerWriteModel writeModel) {
        var toSaveModel = new EquipmentProducer();
        toSaveModel.setBrand(writeModel.brand);
        toSaveModel.setModel(writeModel.model);
        toSaveModel.setProductionYear(writeModel.productionYear);
        toSaveModel.setDestiny(writeModel.destiny);
        toSaveModel.setSportEquipment(Collections.emptySet());
        return toSaveModel;
    }
}
