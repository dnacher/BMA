package com.bma.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "attendance_evaluation")
@Entity
public class AttendanceEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //CascadeType is MERGE since the ChurchMember already exist. If we put ALL or PERSIST is going to throw an error
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "church_member")
    private ChurchMember churchMember;

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

    public void setAttended1(Integer attended1) {
        this.attended1 = attended1;
    }

    public Integer getAttended2() {
        return attended2;
    }

    public void setAttended2(Integer attended2) {
        this.attended2 = attended2;
    }

    public Integer getAttended3() {
        return attended3;
    }

    public void setAttended3(Integer attended3) {
        this.attended3 = attended3;
    }

    public Integer getAttended4() {
        return attended4;
    }

    public void setAttended4(Integer attended4) {
        this.attended4= attended4;
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

    public ChurchMember getChurchMember() {
        return churchMember;
    }

    public void setMember(ChurchMember churchMember) {
        this.churchMember = churchMember;
    }
}
