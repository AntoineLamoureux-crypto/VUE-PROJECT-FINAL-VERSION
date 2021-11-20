package net.java.springboot.repository;

import net.java.springboot.model.InternshipManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipManagerRepository extends JpaRepository<InternshipManager, Integer> {

    InternshipManager findByUsernameAndPassword(String username, String password);

}
