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

    String number;
    String name;
    String surname;
    LocalDate birthday;
    String pesel;
    String sex;
    LocalDate dateOfEmployment;
    String bankAccount;
    String email;
    String phoneNumber;
    BigDecimal monthlySalary;

    public static WorkerReadModel toReadModel(final Worker entity) {
        return new WorkerReadModel(
                entity.getNumber().toString(),
                entity.getName(),
                entity.getSurname(),
                entity.getDateOfBirth(),
                entity.getPesel(),
                entity.getSex(),
                entity.getDateOfEmployment(),
                entity.getBankAccount(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getMonthlySalary());
    }

    @Override
    public String toString() {
        return name + ", " + surname;
    }
}
