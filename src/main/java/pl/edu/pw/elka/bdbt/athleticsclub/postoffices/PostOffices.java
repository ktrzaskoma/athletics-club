package pl.edu.pw.elka.bdbt.athleticsclub.postoffices;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "POCZTY")
public class PostOffices {
    @Id
    @Column(name = "NR_POCZTY")
    private Integer postOfficeNumber;

    @NotNull
    @Column(name = "KOD_POCZTY")
    private String zipCode;

    @NotNull
    @Column(name = "POCZTA")
    private String postOfficeCity;

    @OneToMany(mappedBy = "postOfficesNumber")
    private Set<Addresses> adresies = new LinkedHashSet<>();

    public Integer getPostOfficeNumber() {
        return postOfficeNumber;
    }

    public void setPostOfficeNumber(Integer postOfficeNumber) {
        this.postOfficeNumber = postOfficeNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPostOfficeCity() {
        return postOfficeCity;
    }

    public void setPostOfficeCity(String postOfficeCity) {
        this.postOfficeCity = postOfficeCity;
    }

    public Set<Addresses> getAdresies() {
        return adresies;
    }

    public void setAdresies(Set<Addresses> adresies) {
        this.adresies = adresies;
    }

}