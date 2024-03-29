package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer.Producer;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.Facility;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentWriteModel {

    @NotNull(message = "Pole Data zakupu nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfPurchase;
    @NotNull(message = "Pole Liczba sprzętu nie może być puste!")
    Integer numberOfEquipment;
    @NotNull(message = "Pole Wartość sprzętu nie może być puste!")
    BigDecimal valueOfEquipment;
    @NotBlank(message = "Pole Stan nie może być puste!")
    String condition;
    @NotNull(message = "Zaznacz odpowiedź!")
    Boolean inUse;
    Integer athleticsClubEquipment;
    Integer equipmentStorage;
    Integer equipmentProducer;
    Integer number;

    public static Equipment toEntity(final EquipmentWriteModel writeModel, final AthleticsClub club,
                                     final Facility facility, final Producer producer) {
        var entity = new Equipment();
        entity.setDateOfPurchase(writeModel.getDateOfPurchase());
        entity.setCondition(writeModel.getCondition());
        entity.setNumberOfEquipment(writeModel.getNumberOfEquipment());
        entity.setValueOfEquipment(writeModel.getValueOfEquipment());
        entity.setInUse(writeModel.getInUse());
        entity.setAthleticsClubEquipment(club);
        entity.setEquipmentProducer(producer);
        entity.setEquipmentStorage(facility);
        if (Objects.nonNull(writeModel.getNumber())) {
            entity.setNumberOfEquipment(writeModel.getNumber());
        }
        return entity;
    }
}
