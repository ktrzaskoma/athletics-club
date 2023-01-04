package pl.edu.pw.elka.bdbt.athleticsclub.model.postoffice;

import pl.edu.pw.elka.bdbt.athleticsclub.model.address.Addresses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Poczty")
public class PostOffices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_poczty")
    private Integer postOfficeNumber;

    @NotNull
    @Column(name = "Kod_poczty")
    private String zipCode;

//    @NotNull
    @Column(name = "Poczta")
    private String postOfficeCity;

    @OneToMany(mappedBy = "postOffice")
    private Set<Addresses> addresses;

    public Integer getPostOfficeNumber() {
        return postOfficeNumber;
    }

    public void setPostOfficeNumber(final Integer postOfficeNumber) {
        this.postOfficeNumber = postOfficeNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPostOfficeCity() {
        return postOfficeCity;
    }

    public void setPostOfficeCity(final String postOfficeCity) {
        this.postOfficeCity = postOfficeCity;
    }


    private Set<Addresses> getAddresses() {
        return addresses;
    }
    private void setAddresses(Set<Addresses> addresses) {
        this.addresses = addresses;
    }
}