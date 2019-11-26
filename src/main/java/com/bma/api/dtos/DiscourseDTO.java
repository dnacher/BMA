package com.bma.api.dtos;

import java.util.Date;


public class DiscourseDTO {

    private Integer id;

    private ChurchMemberDTO churchMember;

    private TopicDTO topic;

    private Date date;

    private ChurchMemberDTO assignedBy;

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

    public ChurchMemberDTO getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(ChurchMemberDTO assignedBy) {
        this.assignedBy = assignedBy;
    }
}
