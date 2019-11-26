package com.bma.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "attendance")
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "church_member")
    private ChurchMember churchMember;

    @Column(name = "attended")
    private boolean attended;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChurchMember getChurchMember() {
        return churchMember;
    }

    public void setChurchMember(ChurchMember churchMember) {
        this.churchMember = churchMember;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
