package com.bma.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "hymn")
public class Hymn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "piano_number")
    private Integer pianoNumber;

    @Column(name = "topic")
    private String topic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
