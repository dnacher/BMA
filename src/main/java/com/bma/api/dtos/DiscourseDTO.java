package com.bma.api.dtos;

import java.util.Date;


public class DiscourseDTO {

    private Integer id;

    private MemberDTO member;

    private TopicDTO topic;

    private Date date;

    private MemberDTO assignedBy;

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

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
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
