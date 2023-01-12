package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class WorkerReadModel {

    Integer number;
    String name;
    String surname;
    LocalDate birthday;
    String pesel;
    String sex;
    LocalDate dateOfEmployment;
    String bankAccount;
    String email;
    String phoneNumber;


    public static WorkerReadModel toReadModel(final Worker entity) {
        return new WorkerReadModel(
                entity.getNumber(),
                entity.getName(),
                entity.getSurname(),
                entity.getDateOfBirth(),
                entity.getPesel(),
                entity.getSex(),
                entity.getDateOfEmployment(),
                entity.getBankAccount(),
                entity.getEmail(),
                entity.getPhoneNumber());
    }

    @Override
    public String toString() {
        return name + ", " + surname + ", " + pesel;
    }
}
