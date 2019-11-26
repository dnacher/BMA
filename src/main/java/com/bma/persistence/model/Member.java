package com.bma.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "church_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "fullname")
    private String fullname;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "calling")
    private Calling calling;

    @Column(name = "organization")
    @Enumerated(EnumType.STRING)
    private Organization organization;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Calling getCalling() {
        return calling;
    }

    public void setCalling(Calling calling) {
        this.calling = calling;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
