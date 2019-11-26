package com.bma.api.dtos;

import java.util.Date;

public class PrayerDTO {

    private Integer id;

    private ChurchMemberDTO churchMember;

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

    public void setMember(ChurchMemberDTO churchMember) {
        this.churchMember = churchMember;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
