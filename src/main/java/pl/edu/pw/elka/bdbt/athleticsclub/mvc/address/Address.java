package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.Owner;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.Facility;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;

@Entity
@Table(name = "Adresy")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_adresu")
    private Integer addressNumber;

    @Basic(optional = false)
    @Column(name = "kraj")
    private String country;

    @Basic(optional = false)
    @Column(name = "miasto")
    private String city;

    @Basic(optional = false)
    @Column(name = "kod_pocztowy")
    private String zipCode;

    @Basic(optional = false)
    @Column(name = "ulica")
    private String street;

    @Basic(optional = false)
    @Column(name = "nr_budynku")
    private String buildingNumber;

    @Column(name = "nr_lokalu")
    private String apartmentNumber;


//    mapping column to athletics club
    @OneToOne(mappedBy = "clubAddressNumber")
    private AthleticsClub athleticsClub;

//    mapping column to owners
    @OneToOne(mappedBy = "ownerAddressNumber")
    private Owner owner;

//    mapping column to sport facilities
    @OneToOne(mappedBy = "facilityAddressNumber")
    private Facility facility;

//    mapping column to workers
    @OneToOne(mappedBy = "workerAddressNumber")
    private Worker worker;


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

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

}