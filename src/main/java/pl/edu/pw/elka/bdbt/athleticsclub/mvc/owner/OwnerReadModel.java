package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerReadModel {

    Integer number;
    String name;
    String surname;
    LocalDate dateOfBirth;
    String pesel;
    String sex;
    String bankAccountNumber;
    String email;
    String phoneNumber;

    public static OwnerReadModel toReadModel(final Owner entity) {
        return new OwnerReadModel(
                entity.getOwnerNumber(),
                entity.getOwnerName(),
                entity.getOwnerSurname(),
                entity.getOwnerDateOfBirth(),
                entity.getOwnerPESEL(),
                entity.getSex(),
                entity.getBankAccountNumber(),
                entity.getEmail(),
                entity.getOwnerPhoneNumber()
        );
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
