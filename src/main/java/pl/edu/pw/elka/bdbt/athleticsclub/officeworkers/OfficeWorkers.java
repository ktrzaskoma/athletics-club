package pl.edu.pw.elka.bdbt.athleticsclub.officeworkers;

import pl.edu.pw.elka.bdbt.athleticsclub.workers.Workers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRACOWNICY_BIUROWI")
public class OfficeWorkers {
    @Id
    @Column(name = "NR_PRACOWNIKA")
    private Integer workerNumber;

    @NotNull
    @Column(name = "DZIAL_ZATRUDNIENIA")
    private String department;

    @Column(name = "ZNAJOMOSC_PAKIETU_OFFICE")
    private Boolean officePackageKnowledge;



}