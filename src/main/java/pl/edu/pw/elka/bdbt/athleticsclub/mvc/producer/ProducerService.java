package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProducerService {

    private final ProducerRepository producerRepository;

    List<ProducerReadModel> getProducers() {
        log.info("Finding all entries in DB!");
        return producerRepository.findAll()
                .stream().map(
                        ProducerReadModel::toReadModel
                ).toList();
    }

    void saveProducer(final ProducerWriteModel writeModel) {
        log.info("Saving entry in DB!");
        producerRepository.save(ProducerWriteModel.toEntity(writeModel));
    }

    void deleteProducer(final String idProducer) {
        log.info("Delete entry in DB!");
        producerRepository.deleteById(Integer.valueOf(idProducer));
    }

    ProducerWriteModel editProducer(final String idProducer) {
        log.info("Edit entry in DB!");
        var editEntry = producerRepository.getById(Integer.valueOf(idProducer));
        return new ProducerWriteModel(
                editEntry.getBrand(),
                editEntry.getModel(),
                editEntry.getProductionYear(),
                editEntry.getDestiny(),
                editEntry.getProducerNumber()
        );
    }
}
