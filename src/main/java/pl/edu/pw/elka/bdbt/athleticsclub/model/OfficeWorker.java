package pl.edu.pw.elka.bdbt.athleticsclub.model;

import javax.persistence.*;

@Entity
@Table(name = "Pracownicy_biurowi")
@PrimaryKeyJoinColumn(name = "nr_pracownika")
public class OfficeWorker extends Worker {

    @Basic(optional = false)
    @Column(name = "dzial_zatrudnienia")
    private String department;

    @Column(name = "znajomosc_pakietu_office")
    private Boolean officePackageKnowledge;



}