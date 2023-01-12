package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Year;
import java.util.Collections;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentProducerWriteModel {

    @NotBlank(message = "Pole Marka nie może być puste!")
    String brand;
    @NotBlank(message = "Pole Model nie może być puste!")
    String model;
    @NotNull(message = "Pole Data produkcji nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate productionYear;
    String destiny;

    public static EquipmentProducer toEntity(final EquipmentProducerWriteModel writeModel) {
        var entity = new EquipmentProducer();
        entity.setBrand(writeModel.getBrand());
        entity.setModel(writeModel.getModel());
        entity.setProductionYear(writeModel.getProductionYear());
        entity.setDestiny(writeModel.getDestiny());
        //to do refaktoru, bo tu trzeba podać listę
        entity.setSportEquipment(Collections.emptySet());
        return entity;
    }
}
