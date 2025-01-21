package com.cosume.cosumeRest.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

// ManytoMany annotation  with Student and Course class

@Entity
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
	
   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*
	 * @JoinTable( name = "student_course", // Name of the join table joinColumns
	 * = @JoinColumn(name = "student_id"), // Foreign key in join table pointing to
	 * Student inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key
	 * in join table pointing to Course )
	 */
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
        )
    private Set<Course> courses = new HashSet<>();

}

