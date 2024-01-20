package com.example.taskmanager.Passport;

import com.example.taskmanager.Person.Person;
import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String country;

    @OneToOne(mappedBy = "passport")
    private Person person;

    public Passport() {
    }
    public Passport(Long id, String number, String country, Person person) {
        this.id = id;
        this.number = number;
        this.country = country;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
