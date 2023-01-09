package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.salary.Salary;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerWriteModel {

    String name;
    String lastname;
    Date dateOfBirthday;
    String pesel;
    char sex;
    Date dateOfEmployment;
    String bankAccount;
    String email;
    String phoneNumber;
    AthleticsClub athleticsClubWorker;
    Salary workerSalary;
    Address workerAddressNumber;


    public static Worker toWorker(WorkerWriteModel toSaveModel){
        var workerToSave = new Worker();
        workerToSave.setName(toSaveModel.name);
        workerToSave.setSurname(toSaveModel.lastname);
        workerToSave.setDateOfBirth(toSaveModel.dateOfBirthday.toLocalDate());
        workerToSave.setPesel(toSaveModel.pesel);
        workerToSave.setSex(toSaveModel.sex);
        workerToSave.setDateOfEmployment(LocalDate.now());
        workerToSave.setBankAccount(null);
        workerToSave.setEmail(null);
        workerToSave.setPhoneNumber(toSaveModel.phoneNumber);
        workerToSave.setAthleticsClubWorker(toSaveModel.athleticsClubWorker);
        workerToSave.setWorkerSalary(toSaveModel.workerSalary);
        workerToSave.setWorkerAddressNumber(toSaveModel.workerAddressNumber);
        return workerToSave;

    }

}
