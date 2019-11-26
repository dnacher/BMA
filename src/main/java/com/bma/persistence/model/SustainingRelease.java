package com.bma.persistence.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "sustaining_release")
public class SustainingRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member")
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "calling")
    private Calling calling;

    @Column(name = "init_date")
    private Date initDate;

    @Column(name = "end_date")
    private Date endDate;

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

    public Calling getCalling() {
        return calling;
    }

    public void setCalling(Calling calling) {
        this.calling = calling;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
