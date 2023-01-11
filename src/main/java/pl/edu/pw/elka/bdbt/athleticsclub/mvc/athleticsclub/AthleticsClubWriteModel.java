package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleticsClubWriteModel {

    @NotBlank(message = "Pole Nazwa nie może być puste!")
    String name;
    @NotBlank(message = "Pole Data założenia nie może być puste!")
    Date establishedDate;
    @NotBlank(message = "Pole Numer telefonu nie może być puste!")
    String phoneNumber;
    @NotBlank(message = "Pole Email nie może być puste!")
    String email;
    String phoneNumber2;
    String webPage;
    @NotBlank(message = "Pole Numer adresu nie może być puste!")
    Integer addressNumber;
    @NotBlank(message = "Pole Właściciel klubu nie może być puste!")
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
