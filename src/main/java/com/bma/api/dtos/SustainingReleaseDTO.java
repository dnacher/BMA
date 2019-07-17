package com.bma.api.dtos;

import java.util.Date;

import com.bma.persistence.model.Calling;

public class SustainingReleaseDTO {

    private Integer id;

    private MemberDTO memberDTO;

    private CallingDTO callingDTO;

    private Date initDate;

    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public CallingDTO getCallingDTO() {
        return callingDTO;
    }

    public void setCallingDTO(CallingDTO callingDTO) {
        this.callingDTO = callingDTO;
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
