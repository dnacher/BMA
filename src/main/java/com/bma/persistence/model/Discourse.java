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
    @JoinColumn(name = "member")
    private Member member;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "topic")
    private Topic topic;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "assigned_by")
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

    public Member getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Member assignedBy) {
        this.assignedBy = assignedBy;
    }
}
