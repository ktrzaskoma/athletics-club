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
    int capacity;
    AthleticsClub athleticsClubFacility;
    Address facilityAddress;




    public static SportFacilityReadModel toSportFacilityReadModel(final SportFacility sportFacility){
        return new SportFacilityReadModel(
                sportFacility.getFacilityNumber(),
                sportFacility.getFacilityName(),
                sportFacility.getOpenDate(),
                sportFacility.getFacilityType(),
                sportFacility.getCoveredFacility(),
                sportFacility.getCapacityOfStands(),
                sportFacility.getAthleticsClubFacility(),
                sportFacility.getFacilityAddressNumber());
    }

}
