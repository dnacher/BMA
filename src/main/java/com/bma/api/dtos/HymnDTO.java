package com.bma.api.dtos;

public class HymnDTO {

    private Integer id;
    private String title;
    private Integer number;
    private Integer pianoNumber;
    private TopicDTO topic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPianoNumber() {
        return pianoNumber;
    }

    public void setPianoNumber(Integer pianoNumber) {
        this.pianoNumber = pianoNumber;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
    }
}
