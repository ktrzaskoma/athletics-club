package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleticsClubReadModel {

    Integer number;
    String name;
    LocalDate establishedDate;
    String phoneNumber;
    String email;
    String phoneNumber2;
    String webPage;
    Integer addressNumber;
    Integer ownerOfAthleticsClub;

    public static AthleticsClubReadModel toReadModel(final AthleticsClub entity) {
        return new AthleticsClubReadModel(
                entity.getClubNumber(),
                entity.getClubName(),
                entity.getEstablishedDate(),
                entity.getClubPhoneNumber(),
                entity.getClubEmail(),
                entity.getClubPhoneNumber2(),
                entity.getClubWebPage(),
                entity.getClubAddressNumber().getAddressNumber(),
                entity.getOwnerOfAthleticsClub().getOwnerNumber()
        );
    }

    @Override
    public String toString() {
        return name;
    }
}
