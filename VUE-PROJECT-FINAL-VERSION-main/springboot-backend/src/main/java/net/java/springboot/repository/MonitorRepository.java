package net.java.springboot.repository;

import net.java.springboot.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Integer> {

    Monitor findByUsernameAndPassword(String username, String password);

}
