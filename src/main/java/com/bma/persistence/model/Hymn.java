package com.bma.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "hymn")
public class Hymn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "piano_number")
    private Integer pianoNumber;

    @Column(name = "name")
    private String title;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "topic")
    private Topic topic;

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
