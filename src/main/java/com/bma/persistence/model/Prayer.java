package com.bma.persistence.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "prayer")
public class Prayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "church_member")
    private ChurchMember member;

    @Column(name = "date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChurchMember getMember() {
        return member;
    }

    public void setMember(ChurchMember member) {
        this.member = member;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
