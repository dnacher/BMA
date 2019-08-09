package com.bma.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "hymn")
public class Hymn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "piano_number")
    private Integer pianoNumber;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPianoNumber() {
        return pianoNumber;
    }

    public void setPianoNumber(Integer pianoNumber) {
        this.pianoNumber = pianoNumber;
    }
}
