package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleticsClubRepository extends JpaRepository<AthleticsClub, Integer> {

    AthleticsClub save (AthleticsClub athleticsClub);


}
