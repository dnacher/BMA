package com.bma.api.dtos;

import java.util.Date;


public class DiscourseDTO {

    private Integer id;

    private MemberDTO memberDTO;

    private String topic;

    private Date date;

    private MemberDTO assignedBy;

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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MemberDTO getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(MemberDTO assignedBy) {
        this.assignedBy = assignedBy;
    }
}
