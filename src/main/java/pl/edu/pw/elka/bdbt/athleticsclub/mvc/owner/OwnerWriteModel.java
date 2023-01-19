package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerWriteModel {

    @NotBlank(message = "Pole nie może być puste!")
    String name;
    @NotBlank(message = "Pole nie może być puste!")
    String surname;
    @NotBlank(message = "Pole nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirth;
    @PESEL(message = "Podaj poprawny numer PESEL")
    String pesel;
    @NotBlank(message = "Pole nie może być puste!")
    String sex;
    @NotBlank(message = "Pole nie może być puste!")
    @Size(min = 26, max = 26, message = "Pole musi zawierać 26 cyfr!")
    String bankAccountNumber;
    String email;
    @NotBlank(message = "Pole nie może być puste!")
    @Size(min = 9, max = 9)
    String phoneNumber;
    Integer addressNumber;
    Integer number;

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
        entity.setOwnerNumber(entity.getOwnerNumber());
        return entity;
    }

}
