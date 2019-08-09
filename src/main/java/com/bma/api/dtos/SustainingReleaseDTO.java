package com.bma.api.dtos;

import java.util.Date;

public class SustainingReleaseDTO {

    private Integer id;

    private MemberDTO member;

    private CallingDTO calling;

    private Date initDate;

    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public CallingDTO getCalling() {
        return calling;
    }

    public void setCalling(CallingDTO calling) {
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
