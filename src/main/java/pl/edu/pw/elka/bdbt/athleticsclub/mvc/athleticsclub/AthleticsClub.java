package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment.SportEquipment;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility.SportFacility;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.training.Training;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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


    @OneToOne
    @JoinColumn(name = "nr_adresu")
    private Address clubAddressNumber;

    @OneToOne
    @JoinColumn(name = "nr_wlasciciela")
    private Owner ownerOfAthleticsClub;

    @OneToMany(mappedBy = "athleticsClubFacility")
    private Set<SportFacility> sportFacilities;

    @OneToMany(mappedBy = "athleticsClubEquipment")
    private Set<SportEquipment> sportEquipments;

    @OneToMany(mappedBy = "athleticsClubTraining")
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

    private Set<SportFacility> getSportFacilities() {
        return sportFacilities;
    }

    private void setSportFacilities(Set<SportFacility> sportFacilities) {
        this.sportFacilities = sportFacilities;
    }

    private Set<SportEquipment> getSportEquipments() {
        return sportEquipments;
    }

    private void setSportEquipments(Set<SportEquipment> sportEquipments) {
        this.sportEquipments = sportEquipments;
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

    private void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}