package pl.edu.pw.elka.bdbt.athleticsclub.model.worker.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.Worker;
import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerRepository workerRepo;

    @Override
    public void registerWorker(Worker worker) {
        workerRepo.save(worker);
    }
}
