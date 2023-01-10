package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;

import java.sql.Date;

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

    public static AthleticsClub toEntity(final AthleticsClubWriteModel athleticsClubWriteModel,
                                         final Address address,
                                         final Owner owner) {
        var entity = new AthleticsClub();
        entity.setClubEmail(athleticsClubWriteModel.getEmail());
        entity.setEstablishedDate(athleticsClubWriteModel.getEstablishedDate().toLocalDate());
        entity.setClubPhoneNumber(athleticsClubWriteModel.getPhoneNumber());
        entity.setClubName(athleticsClubWriteModel.getName());
        entity.setClubPhoneNumber2(athleticsClubWriteModel.getPhoneNumber2());
        entity.setClubWebPage(athleticsClubWriteModel.getWebPage());
        entity.setClubAddressNumber(address);
        entity.setOwnerOfAthleticsClub(owner);
        return entity;
    }
}
