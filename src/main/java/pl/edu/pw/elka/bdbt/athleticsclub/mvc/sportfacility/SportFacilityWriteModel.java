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
    //na pewno format daty jest okej, to samo, myślę, że datę można domyślnie ustawić na dzień, w którym tworzy się ten wpis, bez formularza
    Date openDate;
    String facilityType;
    Boolean coveredFacility;
    Integer capacity;
    AthleticsClub athleticsClubFacility;
    Address facilityAddress;

    public static SportFacility toEntity(SportFacilityWriteModel writeModel) {
        var entity = new SportFacility();
        entity.setFacilityName(writeModel.getFacilityName());
        entity.setOpenDate(writeModel.getOpenDate().toLocalDate());
        entity.setFacilityType(writeModel.getFacilityType());
        entity.setCoveredFacility(writeModel.getCoveredFacility());
        entity.setCapacityOfStands(writeModel.getCapacity());
        //to się pewnie wywali -> writeModel.getAthleticsClubFacility()
        entity.setAthleticsClubFacility(new AthleticsClub());
        //to się pewnie wywali -> writeModel.getAthleticsClubFacility()
        entity.setFacilityAddressNumber(new Address());
        return entity;
    }

}
