package pl.edu.pw.elka.bdbt.athleticsclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.PostOffice;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {
    PostOffice save (PostOffice postOffice);
}
