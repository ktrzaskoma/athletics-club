package pl.edu.pw.elka.bdbt.athleticsclub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.WorkerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

//  sorting data by given parameters
    public String feature1() {
        return String.valueOf(
                workerRepository
                        .findAll()
                        .stream()
                        .filter(entry -> entry.getDateOfEmployment().getYear() > 2000 && entry.getSex() == 'M')
                        .count()
        );
    }


}
