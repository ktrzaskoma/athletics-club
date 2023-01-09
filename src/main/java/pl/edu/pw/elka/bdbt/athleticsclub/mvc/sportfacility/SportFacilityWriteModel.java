package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportFacilityWriteModel {

    String facilityName;
    Date openDate;
    String facilityType;
    Boolean coveredFacility;
    int capacity;
    AthleticsClub athleticsClubFacility;
    Address facilityAddress;

    public static SportFacility toSportFacility(SportFacilityWriteModel toSaveModel){
        var sportFacilityToSave = new SportFacility();
        sportFacilityToSave.setFacilityName(toSaveModel.facilityName);
        sportFacilityToSave.setOpenDate(toSaveModel.openDate.toLocalDate());
        sportFacilityToSave.setFacilityType(toSaveModel.facilityType);
        sportFacilityToSave.setCoveredFacility(toSaveModel.coveredFacility);
        sportFacilityToSave.setCapacityOfStands(toSaveModel.capacity);
        sportFacilityToSave.setAthleticsClubFacility(toSaveModel.athleticsClubFacility);
        sportFacilityToSave.setFacilityAddressNumber(toSaveModel.facilityAddress);
        return sportFacilityToSave;
    }



}
