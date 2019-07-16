package com.bma.api.dtos;

import java.util.Date;
import java.util.List;

public class SacramentMeetingDTO {

    private Integer id;

    private Date date;

    private List<HymnDTO> hymnDTOS;

    private String Announcements;

    private List<SustainingReleaseDTO> sustainingReleaseDTOS;

    private List<PrayerDTO> prayerDTOS;

    private List<DiscourseDTO> discours;

    private MemberDTO preside;

    private MemberDTO lead;

    private Integer assistance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<HymnDTO> getHymnDTOS() {
        return hymnDTOS;
    }

    public void setHymnDTOS(List<HymnDTO> hymnDTOS) {
        this.hymnDTOS = hymnDTOS;
    }

    public String getAnnouncements() {
        return Announcements;
    }

    public void setAnnouncements(String announcements) {
        Announcements = announcements;
    }

    public List<SustainingReleaseDTO> getSustainingReleaseDTOS() {
        return sustainingReleaseDTOS;
    }

    public void setSustainingReleaseDTOS(List<SustainingReleaseDTO> sustainingReleaseDTOS) {
        this.sustainingReleaseDTOS = sustainingReleaseDTOS;
    }

    public List<PrayerDTO> getPrayerDTOS() {
        return prayerDTOS;
    }

    public void setPrayerDTOS(List<PrayerDTO> prayerDTOS) {
        this.prayerDTOS = prayerDTOS;
    }

    public List<DiscourseDTO> getDiscours() {
        return discours;
    }

    public void setDiscours(List<DiscourseDTO> discours) {
        this.discours = discours;
    }

    public MemberDTO getPreside() {
        return preside;
    }

    public void setPreside(MemberDTO preside) {
        this.preside = preside;
    }

    public MemberDTO getLead() {
        return lead;
    }

    public void setLead(MemberDTO lead) {
        this.lead = lead;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }
}
