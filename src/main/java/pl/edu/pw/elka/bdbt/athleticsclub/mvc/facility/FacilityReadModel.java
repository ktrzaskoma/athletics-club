package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class FacilityReadModel {

    Integer number;
    String facilityName;
    LocalDate openDate;
    String facilityType;
    String coveredFacility;
    String capacity;
    String athleticsClubFacility;
    String facilityAddressNumber;


    public static FacilityReadModel toReadModel(final Facility entity) {
        return new FacilityReadModel(
                entity.getFacilityNumber(),
                entity.getFacilityName(),
                entity.getOpenDate(),
                entity.getFacilityType(),
                resolveCoveredFacility(entity),
                entity.getCapacityOfStands(),
                entity.getAthleticsClubFacility().toString(),
                entity.getFacilityAddressNumber().toString());
    }

    private static String resolveCoveredFacility(Facility entity) {
        return entity.getCoveredFacility() ? "Tak" : "Nie";
    }

    @Override
    public String toString() {
        return facilityName + ", " + facilityType;
    }

}
