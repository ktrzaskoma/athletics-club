package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class FacilityReadModel {

    Integer number;
    String facilityName;
    LocalDate openDate;
    String facilityType;
    Boolean coveredFacility;
    String capacity;
    String athleticsClubFacility;


    public static FacilityReadModel toReadModel(final Facility entity) {
        return new FacilityReadModel(
                entity.getFacilityNumber(),
                entity.getFacilityName(),
                entity.getOpenDate(),
                entity.getFacilityType(),
                entity.getCoveredFacility(),
                entity.getCapacityOfStands(),
                entity.getAthleticsClubFacility().toString());
    }

    @Override
    public String toString() {
        return facilityName + ", " + facilityType + ", pojemność: " + capacity;
    }

}
