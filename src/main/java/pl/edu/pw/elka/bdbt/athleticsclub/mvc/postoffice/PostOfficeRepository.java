package pl.edu.pw.elka.bdbt.athleticsclub.mvc.postoffice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {
    PostOffice save (PostOffice postOffice);
}
