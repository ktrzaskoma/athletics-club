package pl.edu.pw.elka.bdbt.athleticsclub.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Poczty")
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_poczty")
    private Integer postOfficeNumber;

    @Basic(optional = false)
    @Column(name = "kod_poczty")
    private String zipCode;

    @NotNull
    @Column(name = "poczta")
    private String postOfficeCity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postOffice")
    private Set<Address> addressSet;

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


    private Set<Address> getAddressSet() {
        return addressSet;
    }
    private void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }
}