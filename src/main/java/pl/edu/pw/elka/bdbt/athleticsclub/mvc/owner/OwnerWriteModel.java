package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerWriteModel {

    String name;
    String surname;
    LocalDate dateOfBirth;
    String pesel;
    String sex;
    String bankAccountNumber;
    String email;
    String phoneNumber;
    Integer addressNumber;

    public static Owner toEntity(final OwnerWriteModel writeModel, final Address address) {
        var entity = new Owner();
        entity.setOwnerName(writeModel.getName());
        entity.setOwnerSurname(writeModel.getSurname());
        entity.setOwnerDateOfBirth(LocalDate.now());
        entity.setOwnerPESEL(writeModel.getPesel());
        entity.setSex(writeModel.getSex());
        entity.setBankAccountNumber(writeModel.getBankAccountNumber());
        entity.setEmail(writeModel.getEmail());
        entity.setOwnerPhoneNumber(writeModel.getPhoneNumber());
        entity.setOwnerAddressNumber(address);
        return entity;
    }

}
