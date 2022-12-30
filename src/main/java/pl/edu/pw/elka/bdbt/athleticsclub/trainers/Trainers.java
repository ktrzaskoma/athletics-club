package pl.edu.pw.elka.bdbt.athleticsclub.trainers;

import pl.edu.pw.elka.bdbt.athleticsclub.sportlicenses.SportLicenses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TRENERZY")
public class Trainers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "DATA_ROZPOCZECIA_KARIERY_TRENERSKIEJ")
    private Date coachCareerDateStart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}