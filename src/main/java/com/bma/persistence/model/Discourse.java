package com.bma.persistence.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "DISCOURSE")
public class Discourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER")
    private Member member;

    @Column(name = "TOPIC")
    private String topic;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "ASSIGNED_BY")
    private Member assignedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Member assignedBy) {
        this.assignedBy = assignedBy;
    }
}
