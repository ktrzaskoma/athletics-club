package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportFacilityWriteModel {

    @NotBlank(message = "Pole nazwa nie może być puste!")
    String facilityName;
    @NotNull(message = "Pole Data otwarcia nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate openDate;
    @NotBlank(message = "Pole Typ obiektu nie może być puste!")
    String facilityType;
    @NotNull(message = "Pole Czy obiekt jest zakryty nie może być puste!")
    Boolean coveredFacility;
    @NotNull(message = "Pole Pojemność trybun nie może być puste!")
    Integer capacity;
    Integer athleticsClubFacility;
    Integer facilityAddress;

    public static SportFacility toEntity(final SportFacilityWriteModel writeModel, final AthleticsClub club, final Address address) {
        var entity = new SportFacility();
        entity.setFacilityName(writeModel.getFacilityName());
        entity.setOpenDate(writeModel.getOpenDate());
        entity.setFacilityType(writeModel.getFacilityType());
        entity.setCoveredFacility(writeModel.getCoveredFacility());
        entity.setCapacityOfStands(writeModel.getCapacity());
        entity.setAthleticsClubFacility(club);
        entity.setFacilityAddressNumber(address);
        return entity;
    }

}
