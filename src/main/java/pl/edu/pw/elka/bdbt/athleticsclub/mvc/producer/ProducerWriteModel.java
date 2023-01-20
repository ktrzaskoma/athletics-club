package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProducerWriteModel {

    @NotBlank(message = "Pole nie może być puste!")
    String brand;
    @NotBlank(message = "Pole nie może być puste!")
    String model;
    @NotBlank(message = "Pole nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate productionYear;
    String destiny;
    Integer number;

    public static Producer toEntity(final ProducerWriteModel writeModel) {
        var entity = new Producer();
        entity.setBrand(writeModel.getBrand());
        entity.setModel(writeModel.getModel());
        entity.setProductionYear(writeModel.getProductionYear());
        entity.setDestiny(writeModel.getDestiny());
        if (Objects.nonNull(writeModel.getNumber())) {
            entity.setProducerNumber(writeModel.getNumber());
        }
        return entity;
    }
}
