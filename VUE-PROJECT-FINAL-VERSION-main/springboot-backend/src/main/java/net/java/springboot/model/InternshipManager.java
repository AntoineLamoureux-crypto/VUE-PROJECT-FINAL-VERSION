package net.java.springboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class InternshipManager extends User{

    @Id
    @GeneratedValue
    private int id;

}
