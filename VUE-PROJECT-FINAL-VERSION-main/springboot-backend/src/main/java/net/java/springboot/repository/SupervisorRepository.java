package net.java.springboot.repository;

import net.java.springboot.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {

    Supervisor findByUsernameAndPassword(String username, String password);

}
