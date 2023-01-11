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
    String sex;
    Date dateOfEmployment;
    String bankAccount;
    String email;
    String phoneNumber;
    AthleticsClub athleticsClubWorker;
    Salary workerSalary;
    Address workerAddressNumber;


    public static Worker toEntity(WorkerWriteModel writeModel){
        var entity = new Worker();
        entity.setName(writeModel.getName());
        entity.setSurname(writeModel.getLastname());
        entity.setDateOfBirth(writeModel.dateOfBirthday.toLocalDate());
        entity.setPesel(writeModel.getPesel());
        entity.setSex(writeModel.getSex());
        entity.setDateOfEmployment(LocalDate.now());
        entity.setBankAccount(null);
        entity.setEmail(null);
        entity.setPhoneNumber(writeModel.getPhoneNumber());
        entity.setAthleticsClubWorker(writeModel.getAthleticsClubWorker());
        entity.setWorkerSalary(writeModel.getWorkerSalary());
        entity.setWorkerAddressNumber(writeModel.getWorkerAddressNumber());
        return entity;

    }

}
