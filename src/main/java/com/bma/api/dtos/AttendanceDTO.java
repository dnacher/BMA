package com.bma.api.dtos;

import java.io.Serializable;
import java.util.Date;

public class AttendanceDTO implements Serializable {

    private Integer id;
    private ChurchMemberDTO churchMember;
    private boolean attended;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChurchMemberDTO getChurchMember() {
        return churchMember;
    }

    public void setChurchMember(ChurchMemberDTO churchMember) {
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

    public Integer getAttendanceValue() {
        return (attended) ? 1 : 0;
    }
}
