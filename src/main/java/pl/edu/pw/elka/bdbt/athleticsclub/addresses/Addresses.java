package pl.edu.pw.elka.bdbt.athleticsclub.addresses;

import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.owners.Owners;
import pl.edu.pw.elka.bdbt.athleticsclub.postoffices.PostOffices;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;
import pl.edu.pw.elka.bdbt.athleticsclub.workers.Workers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Adresy")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_adresu")
    private Integer addressNumber;

    @NotNull
    @Column(name = "Kraj")
    private String country;

    @NotNull
    @Column(name = "Miasto")
    private String city;

    @NotNull
    @Column(name = "Ulica")
    private String street;

    @NotNull
    @Column(name = "Nr_budynku")
    private String buildingNumber;

    @Column(name = "Nr_lokalu")
    private String apartmentNumber;

//    getting column from PostOffice
    @ManyToOne
    @JoinColumn(name = "Nr_poczty", nullable = false)
    private PostOffices postOffice;

//    mapping column to athletics club
    @OneToOne(mappedBy = "clubAddressNumber")
    private AthleticsClub athleticsClub;

//    mapping column to owners
    @OneToOne(mappedBy = "ownerAddressNumber")
    private Owners owners;

//    mapping column to sport facilities
    @OneToOne(mappedBy = "facilityAddressNumber")
    private SportFacilities sportFacilities;

//    mapping column to workers
    @OneToOne(mappedBy = "workerAddressNumber")
    private Workers workers;



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

    public PostOffices getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(PostOffices postOfficeNumber) {
        this.postOffice = postOfficeNumber;
    }
}