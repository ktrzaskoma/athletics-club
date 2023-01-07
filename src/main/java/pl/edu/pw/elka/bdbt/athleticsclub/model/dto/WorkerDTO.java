package pl.edu.pw.elka.bdbt.athleticsclub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class WorkerDTO {

    Integer number;
    String name;
    String surname;
    LocalDate birthday;
    String pesel;
    char sex;
    LocalDate dateOfEmployment;
    String bankAccount;
    String email;
    String phoneNumber;
    String athleticsClubWorker;
    BigDecimal salary;
    Integer addressNumber;


    public static WorkerDTO toWorkerDTO(final Worker worker) {
        return new WorkerDTO(
                worker.getNumber(),
                worker.getName(),
                worker.getSurname(),
                worker.getDateOfBirth(),
                worker.getPesel(),
                worker.getSex(),
                worker.getDateOfEmployment(),
                worker.getBankAccount(),
                worker.getEmail(),
                worker.getPhoneNumber(),
                worker.getAthleticsClubWorker().getClubName(),
                worker.getWorkerSalary().getHourlyRate(),
                worker.getWorkerAddressNumber().getAddressNumber());
    }


}
