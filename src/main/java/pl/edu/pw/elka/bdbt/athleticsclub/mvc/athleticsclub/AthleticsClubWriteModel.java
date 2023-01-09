package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleticsClubWriteModel {

    String name;
    Date establishedDate;
    String phoneNumber;
    String email;
    String phoneNumber2;
    String webPage;
    Integer addressNumber;
    Integer ownerOfAthleticsClub;

    public static AthleticsClub toAthleticsClub(final AthleticsClubWriteModel athleticsClubWriteModel) {
        var athleticsClubToSave = new AthleticsClub();
        athleticsClubToSave.setClubEmail(athleticsClubWriteModel.email);
        athleticsClubToSave.setEstablishedDate(athleticsClubWriteModel.establishedDate);
        athleticsClubToSave.setClubPhoneNumber(athleticsClubWriteModel.phoneNumber);
        athleticsClubToSave.setClubName(athleticsClubWriteModel.name);
        athleticsClubToSave.setClubPhoneNumber2(athleticsClubWriteModel.phoneNumber2);
        athleticsClubToSave.setClubWebPage(athleticsClubWriteModel.webPage);
        athleticsClubToSave.setClubAddressNumber(new Address());
        athleticsClubToSave.setOwnerOfAthleticsClub(new Owner());
        return athleticsClubToSave;
    }
}
