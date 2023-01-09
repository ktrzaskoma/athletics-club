package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleticsClubReadModel {

    String name;
    LocalDate establishedDate;
    String phoneNumber;
    String email;
    String phoneNumber2;
    String webPage;
    Integer addressNumber;
    Integer ownerOfAthleticsClub;

    public static AthleticsClubReadModel toReadModel(final AthleticsClub athleticsClub) {
        return new AthleticsClubReadModel(
                athleticsClub.getClubName(),
                athleticsClub.getEstablishedDate(),
                athleticsClub.getClubPhoneNumber(),
                athleticsClub.getClubEmail(),
                athleticsClub.getClubPhoneNumber2(),
                athleticsClub.getClubWebPage(),
                athleticsClub.getClubAddressNumber().getAddressNumber(),
                athleticsClub.getOwnerOfAthleticsClub().getOwnerNumber()
        );
    }


}
