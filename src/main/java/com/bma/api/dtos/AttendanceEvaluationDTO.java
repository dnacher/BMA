package com.bma.api.dtos;

import java.io.Serializable;
import java.util.Date;

public class AttendanceEvaluationDTO implements Serializable {

    private Integer id;
    private ChurchMemberDTO member;
    private Integer attended1;
    private Integer attended2;
    private Integer attended3;
    private Integer attended4;
    private Date lastUpdate;
    private String attendance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChurchMemberDTO getMember() {
        return member;
    }

    public void setMember(ChurchMemberDTO member) {
        this.member = member;
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
        this.attended4 = attended4;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getOldestAttendanceValue(){
        if(this.getAttended3()!=null){
            return 3;
        }else if(this.getAttended2()!=null){
            return 2;
        }else if(this.getAttended1()!=null){
            return 1;
        }else{
            return 0;
        }
    }

    public void setAttendedValue(Integer newValue){
        Integer i = this.getOldestAttendanceValue();
        switch (i){
            case 3:
                attended4 = attended3;
            case 2:
                attended3 = attended2;
            case 1:
                attended2 = attended1;
            case 0:
                attended1 = newValue;
        }
        this.getAttendanceValueEvaluation();
    }

    public void getAttendanceValueEvaluation(){
        String strValue = "";
        strValue+= (this.getAttended1() != null) ? getAttended1(): "X";
        strValue+= (this.getAttended2() != null) ? getAttended2(): "X";
        strValue+= (this.getAttended3() != null) ? getAttended3(): "X";
        strValue+= (this.getAttended4() != null) ? getAttended4(): "X";
        this.attendance= strValue;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
