package net.java.springboot.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class Student extends User {

    private Department department;

    private int supervisor_ID;
}
