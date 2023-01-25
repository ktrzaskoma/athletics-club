package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment.Equipment;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.Facility;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.training.Training;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Klub_lekkoatletyczny")
public class AthleticsClub {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_klubu")
    private Integer clubNumber;

    @Basic(optional = false)
    @Column(name = "nazwa")
    private String clubName;

    @Basic(optional = false)
    @Column(name = "data_zalozenia")
    private LocalDate establishedDate;

    @Basic(optional = false)
    @Column(name = "nr_telefonu")
    private String clubPhoneNumber;

    @Column(name = "email")
    private String clubEmail;

    @Column(name = "nr_telefonu2")
    private String clubPhoneNumber2;

    @Column(name = "strona_www")
    private String clubWebPage;


    @ManyToOne
    @JoinColumn(name = "nr_adresu")
    private Address clubAddressNumber;

    @OneToOne
    @JoinColumn(name = "nr_wlasciciela")
    private Owner ownerOfAthleticsClub;

    @OneToMany(mappedBy = "athleticsClubFacility", orphanRemoval = true)
    private Set<Facility> sportFacilities;

    @OneToMany(mappedBy = "athleticsClubEquipment", orphanRemoval = true)
    private Set<Equipment> equipment;

    @OneToMany(mappedBy = "athleticsClubTraining", orphanRemoval = true)
    private Set<Training> trainings;

    @OneToMany(mappedBy = "athleticsClubWorker")
    private Set<Worker> workers;


    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getClubPhoneNumber() {
        return clubPhoneNumber;
    }

    public void setClubPhoneNumber(String clubPhoneNumber) {
        this.clubPhoneNumber = clubPhoneNumber;
    }

    public String getClubPhoneNumber2() {
        return clubPhoneNumber2;
    }

    public void setClubPhoneNumber2(String clubPhoneNumber2) {
        this.clubPhoneNumber2 = clubPhoneNumber2;
    }

    public String getClubEmail() {
        return clubEmail;
    }

    public void setClubEmail(String clubEmail) {
        this.clubEmail = clubEmail;
    }

    public String getClubWebPage() {
        return clubWebPage;
    }

    public void setClubWebPage(String clubWebPage) {
        this.clubWebPage = clubWebPage;
    }

    public Address getClubAddressNumber() {
        return clubAddressNumber;
    }

    public void setClubAddressNumber(Address clubAddressNumber) {
        this.clubAddressNumber = clubAddressNumber;
    }

    public Owner getOwnerOfAthleticsClub() {
        return ownerOfAthleticsClub;
    }

    public void setOwnerOfAthleticsClub(Owner ownerOfAthleticsClub) {
        this.ownerOfAthleticsClub = ownerOfAthleticsClub;
    }

    private Set<Facility> getSportFacilities() {
        return sportFacilities;
    }

    private void setSportFacilities(Set<Facility> sportFacilities) {
        this.sportFacilities = sportFacilities;
    }

    private Set<Equipment> getSportEquipments() {
        return equipment;
    }

    private void setSportEquipments(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    private Set<Training> getTrainings() {
        return trainings;
    }

    private void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    private Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return clubName;
    }
}