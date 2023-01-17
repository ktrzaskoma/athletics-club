package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleticsClubWriteModel {

    @NotBlank(message = "Pole Nazwa nie może być puste!")
    String name;
    @NotNull(message = "Pole Data założenia nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate establishedDate;
    @NotBlank(message = "Pole Numer telefonu nie może być puste!")
    String phoneNumber;
    String email;
    String phoneNumber2;
    String webPage;
    Integer addressNumber;
    Integer ownerOfAthleticsClub;
    Integer number;

    public static AthleticsClub toEntity(final AthleticsClubWriteModel athleticsClubWriteModel,
                                         final Address address,
                                         final Owner owner) {
        var entity = new AthleticsClub();
        entity.setClubEmail(athleticsClubWriteModel.getEmail());
        entity.setEstablishedDate(athleticsClubWriteModel.getEstablishedDate());
        entity.setClubPhoneNumber(athleticsClubWriteModel.getPhoneNumber());
        entity.setClubName(athleticsClubWriteModel.getName());
        entity.setClubPhoneNumber2(athleticsClubWriteModel.getPhoneNumber2());
        entity.setClubWebPage(athleticsClubWriteModel.getWebPage());
        entity.setClubAddressNumber(address);
        entity.setOwnerOfAthleticsClub(owner);
        if (Objects.nonNull(athleticsClubWriteModel.getNumber())) {
            entity.setClubNumber(athleticsClubWriteModel.number);
        }
        return entity;
    }
}
