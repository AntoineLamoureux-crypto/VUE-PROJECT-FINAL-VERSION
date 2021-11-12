package net.java.springboot.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class Supervisor extends User {

    private Department department;

}
