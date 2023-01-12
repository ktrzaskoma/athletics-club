package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SportFacilityReadModel {

    Integer number;
    String facilityName;
    LocalDate openDate;
    String facilityType;
    Boolean coveredFacility;
    Integer capacity;


    public static SportFacilityReadModel toReadModel(final SportFacility entity){
        return new SportFacilityReadModel(
                entity.getFacilityNumber(),
                entity.getFacilityName(),
                entity.getOpenDate(),
                entity.getFacilityType(),
                entity.getCoveredFacility(),
                entity.getCapacityOfStands());

    }

    @Override
    public String toString() {
        return facilityName + ", " + facilityType;
    }

}
