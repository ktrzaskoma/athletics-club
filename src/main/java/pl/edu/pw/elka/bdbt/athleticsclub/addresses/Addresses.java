package pl.edu.pw.elka.bdbt.athleticsclub.addresses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Adresy")
public class Addresses {

    @Id
    @Column(name = "Nr_adresu")
    private Integer Id;

    @Column(name = "Kraj")
    @NotNull
    private String country;

    @Column(name = "Miasto")
    @NotNull
    private String city;

    @Column(name = "Ulica")
    @NotNull
    private String street;

    @Column(name = "Nr_budynku")
    @NotNull
    private String buildingNumber;

    @Column(name = "Nr_lokalu")
    private String apartmentNumber;
}
