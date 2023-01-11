package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerWriteModel {

    @NotBlank(message = "Pole Imię nie może być puste!")
    String name;
    @NotBlank(message = "Pole Nazwisko nie może być puste!")
    String surname;
    @NotNull(message = "Pole Data urodzenia nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirth;
    String pesel;
    @NotBlank(message = "Pole Płeć nie może być puste!")
    String sex;
    String bankAccountNumber;
    String email;
    @NotBlank(message = "Pole Numer telefonu nie może być puste!")
    String phoneNumber;
    Integer addressNumber;

    public static Owner toEntity(final OwnerWriteModel writeModel, final Address address) {
        var entity = new Owner();
        entity.setOwnerName(writeModel.getName());
        entity.setOwnerSurname(writeModel.getSurname());
        entity.setOwnerDateOfBirth(writeModel.getDateOfBirth());
        entity.setOwnerPESEL(writeModel.getPesel());
        entity.setSex(writeModel.getSex());
        entity.setBankAccountNumber(writeModel.getBankAccountNumber());
        entity.setEmail(writeModel.getEmail());
        entity.setOwnerPhoneNumber(writeModel.getPhoneNumber());
        entity.setOwnerAddressNumber(address);
        return entity;
    }

}
