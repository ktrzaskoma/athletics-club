package pl.edu.pw.elka.bdbt.athleticsclub.addresses;

import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;
import pl.edu.pw.elka.bdbt.athleticsclub.postoffices.PostOffices;
import pl.edu.pw.elka.bdbt.athleticsclub.owners.Owners;
import pl.edu.pw.elka.bdbt.athleticsclub.workers.Workers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ADRESY")
public class Addresses {
    @Id
    @Column(name = "NR_ADRESU")
    private Integer addressNumber;

    @NotNull
    @Column(name = "KRAJ")
    private String country;

    @NotNull
    @Column(name = "MIASTO")
    private String city;

    @NotNull
    @Column(name = "ULICA")
    private String street;

    @NotNull
    @Column(name = "NR_BUDYNKU")
    private String buildingNumber;

    @Column(name = "NR_LOKALU")
    private String apartmentNumber;


    @ManyToOne
    @JoinColumn(name = "NR_POCZTY", nullable = false)
    private PostOffices postOfficesNumber;

    @OneToMany(mappedBy = "addressNumber")
    private Set<Owners> owners = new LinkedHashSet<>();

    @OneToMany(mappedBy = "addressNumber")
    private Set<SportFacilities> sportFacilities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "addressNumber")
    private Set<Workers> workers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "addressNumber")
    private Set<AthleticsClub> athleticsClubs = new LinkedHashSet<>();

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public PostOffices getNrPoczty() {
        return postOfficesNumber;
    }

    public void setNrPoczty(PostOffices nrPostOffices) {
        this.postOfficesNumber = nrPostOffices;
    }

    public Set<Owners> getWlascicieles() {
        return owners;
    }

    public void setWlascicieles(Set<Owners> owners) {
        this.owners = owners;
    }

    public Set<SportFacilities> getObiektySportowes() {
        return sportFacilities;
    }

    public void setObiektySportowes(Set<SportFacilities> sportFacilities) {
        this.sportFacilities = sportFacilities;
    }

    public Set<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Workers> pracownicies) {
        this.workers = pracownicies;
    }

    public Set<AthleticsClub> getAthleticClubs() {
        return athleticsClubs;
    }

    public void setAthleticClubs(Set<AthleticsClub> athleticsClubs) {
        this.athleticsClubs = athleticsClubs;
    }

}