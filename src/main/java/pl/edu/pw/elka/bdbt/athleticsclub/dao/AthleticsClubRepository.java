package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.AthleticsClub;

@Repository
public interface AthleticsClubRepository extends JpaRepository<AthleticsClub, Integer> {

    AthleticsClub save (AthleticsClub athleticsClub);


}
