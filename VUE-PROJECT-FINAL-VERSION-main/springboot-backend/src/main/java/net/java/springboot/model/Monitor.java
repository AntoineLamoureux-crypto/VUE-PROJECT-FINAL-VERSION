package net.java.springboot.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class Monitor extends User {

    private String enterpriseName;

    private String jobTitle;
}
