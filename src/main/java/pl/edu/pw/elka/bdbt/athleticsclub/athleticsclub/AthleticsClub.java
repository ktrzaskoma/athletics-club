package pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.owners.Owners;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Klub_lekkoatletyczny")
public class AthleticsClub {
    @Id
    @Column(name = "Nr_klubu")
    private Integer clubNumber;

    @NotNull
    @Column(name = "Nazwa")
    private String clubName;

    @NotNull
    @Column(name = "Data_zalozenia")
    private Date establishedDate;

    @NotNull
    @Column(name = "Nr_telefonu")
    private String clubPhoneNumber1;

    @Column(name = "Nr_telefonu2")
    private String clubPhoneNumber2;

    @Column(name = "Email")
    private String clubEmail;

    @Column(name = "Strona_www")
    private String clubWebPage;

    @OneToMany(mappedBy = "clubNumber")
    private Set<SportFacilities> sportFacilities;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Addresses athleticsClubAddressNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_WLASCICIELA", nullable = false)
    private Owners ownerNumber;




}