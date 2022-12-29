package pl.edu.pw.elka.bdbt.athleticsclub.postoffices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PostOffices {

    @Id
    @Column(name = "Nr_poczty")
    private Integer Id;

    @Column(name = "Kod_poczty")
    @NotNull
    private String zipCode;

    @Column(name = "Poczta")
    @NotNull
    private String postOfficeCity;


}
