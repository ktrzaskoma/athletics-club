package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

//  sorting data by given parameters
    public String getMenWorkersEmployedAfter2000() {
        return String.valueOf(
                workerRepository
                        .findAll()
                        .stream()
                        .filter(entry -> entry.getDateOfEmployment().getYear() > 2000 && entry.getSex() == 'M')
                        .count()
        );
    }


}
