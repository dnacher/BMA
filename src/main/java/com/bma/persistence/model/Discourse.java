package com.bma.persistence.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "discourse")
public class Discourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "church_member")
    private ChurchMember churchMember;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "topic")
    private Topic topic;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "assigned_by")
    private ChurchMember assignedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChurchMember getChurchMember() {
        return churchMember;
    }

    public void setMember(ChurchMember churchMember) {
        this.churchMember = churchMember;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ChurchMember getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(ChurchMember assignedBy) {
        this.assignedBy = assignedBy;
    }
}
