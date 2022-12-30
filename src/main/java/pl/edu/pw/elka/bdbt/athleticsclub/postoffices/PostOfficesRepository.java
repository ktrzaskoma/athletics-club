package pl.edu.pw.elka.bdbt.athleticsclub.postoffices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficesRepository extends JpaRepository<PostOffices, Integer> {
    PostOffices save (PostOffices postOffices);
}
