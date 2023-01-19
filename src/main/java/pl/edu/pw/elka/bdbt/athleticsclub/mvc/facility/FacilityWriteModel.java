package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacilityWriteModel {

    @NotBlank(message = "Pole nie może być puste!")
    String facilityName;
    @NotBlank(message = "Pole nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate openDate;
    @NotBlank(message = "Pole nie może być puste!")
    String facilityType;
    @NotBlank(message = "Pole nie może być puste!")
    Boolean coveredFacility;
    @NotBlank(message = "Pole nie może być puste!")
    String capacity;
    Integer athleticsClubFacility;
    Integer facilityAddress;
    Integer number;

    public static Facility toEntity(final FacilityWriteModel writeModel, final AthleticsClub club, final Address address) {
        var entity = new Facility();
        entity.setFacilityName(writeModel.getFacilityName());
        entity.setOpenDate(writeModel.getOpenDate());
        entity.setFacilityType(writeModel.getFacilityType());
        entity.setCoveredFacility(writeModel.getCoveredFacility());
        entity.setCapacityOfStands(Integer.valueOf(writeModel.getCapacity()));
        entity.setAthleticsClubFacility(club);
        entity.setFacilityAddressNumber(address);
        if(Objects.nonNull(writeModel.getNumber())){
            entity.setFacilityNumber(writeModel.getNumber());
        }
        return entity;
    }

}
