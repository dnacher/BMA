package com.bma.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "attendance_evaluation")
@Entity
public class AttendanceEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "church_member")
    private ChurchMember member;

    @Column(name = "attended1")
    private Integer attended1;

    @Column(name = "attended2")
    private Integer attended2;

    @Column(name = "attended3")
    private Integer attended3;

    @Column(name = "attended4")
    private Integer attended4;

    @Column(name = "last_update")
    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttended1() {
        return attended1;
    }

    private void setAttended1(Integer attended1) {
        this.attended1 = attended1;
    }

    public Integer getAttended2() {
        return attended2;
    }

    private void setAttended2(Integer attended2) {
        this.attended2 = attended2;
    }

    public Integer getAttended3() {
        return attended3;
    }

    private void setAttended3(Integer attended3) {
        this.attended3 = attended3;
    }

    public Integer getAttended4() {
        return attended4;
    }

    public void setAttended4(Integer attended4) {
        if(attended2!=null){
            setAttended1(getAttended2());
        }
        if(attended3!=null){
            setAttended2(getAttended3());
        }
        if(attended4!=null){
            setAttended3(getAttended4());
        }
        this.attended4 = attended4;
    }

    public String getAttendanceValueEvaluation(){
        String strValue = "";
        if(this.getAttended1()!=null){
            strValue+=getAttended1();
        }else{
            strValue+="X";
        }
        if(this.getAttended2()!=null){
            strValue+=getAttended2();
        }else{
            strValue+="X";
        }
        if(this.getAttended3()!=null){
            strValue+=getAttended3();
        }else{
            strValue+="X";
        }
        strValue+=getAttended4();
        return  strValue;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ChurchMember getMember() {
        return member;
    }

    public void setMember(ChurchMember member) {
        this.member = member;
    }
}
