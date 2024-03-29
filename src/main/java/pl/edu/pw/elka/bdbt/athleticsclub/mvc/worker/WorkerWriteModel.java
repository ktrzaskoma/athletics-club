package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicense;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerWriteModel {

    @NotBlank(message = "Pole nie może być puste!")
    String name;
    @NotBlank(message = "Pole nie może być puste!")
    String lastname;
    @NotNull(message = "Pole nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirthday;
    @NotBlank(message = "Pole nie może być puste!")
    @Size(min = 11, max = 11, message = "Numer PESEL powinien mieć 11 cyfr!")
    String pesel;
    @NotBlank(message = "Pole nie może być puste!")
    String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfEmployment;
    @Size(min = 26, max = 26, message = "Numer konta powinien mieć 26 cyfr!")
    String bankAccount;
    String email;
    @NotBlank(message = "Pole nie może być puste!")
    String phoneNumber;
    Integer athleticsClubWorker;
    Integer workerAddressNumber;
    String monthlySalary;
    SportLicense sportLicense;
    Integer number;


    public static Worker toEntity(
            final WorkerWriteModel writeModel,
            final AthleticsClub athleticsClub,
            final SportLicense sportLicense,
            final Address address) {
        var entity = new Worker();
        entity.setName(writeModel.getName());
        entity.setSurname(writeModel.getLastname());
        entity.setDateOfBirth(writeModel.getDateOfBirthday());
        entity.setPesel(writeModel.getPesel());
        entity.setSex(writeModel.getSex());
        entity.setDateOfEmployment(LocalDate.now());
        entity.setBankAccount(writeModel.getBankAccount());
        entity.setEmail(writeModel.getEmail());
        entity.setPhoneNumber(writeModel.getPhoneNumber());
        if (Objects.nonNull(athleticsClub)) {
            entity.setAthleticsClubWorker(athleticsClub);
        }
        if (Objects.nonNull(address)) {
            entity.setWorkerAddressNumber(address);
        }
        entity.setMonthlySalary(writeModel.getMonthlySalary());
        if (Objects.nonNull(sportLicense)) {
            entity.setLicense(sportLicense);
        }
        if (Objects.nonNull(writeModel.getNumber())) {
            entity.setNumber(writeModel.getNumber());
        }
        return entity;
    }


}
