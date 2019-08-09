package com.bma.api.dtos;

import java.util.Date;
import java.util.Set;

public class SacramentMeetingDTO {

    private Integer id;

    private Date date;

    private Set<HymnDTO> hymns;

    private String Announcements;

    private Set<SustainingReleaseDTO> sustainingReleases;

    private Set<PrayerDTO> prayers;

    private Set<DiscourseDTO> discourses;

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

    public Set<HymnDTO> getHymns() {
        return hymns;
    }

    public void setHymns(Set<HymnDTO> hymns) {
        this.hymns = hymns;
    }

    public String getAnnouncements() {
        return Announcements;
    }

    public void setAnnouncements(String announcements) {
        Announcements = announcements;
    }

    public Set<SustainingReleaseDTO> getSustainingReleases() {
        return sustainingReleases;
    }

    public void setSustainingReleases(Set<SustainingReleaseDTO> sustainingReleases) {
        this.sustainingReleases = sustainingReleases;
    }

    public Set<PrayerDTO> getPrayers() {
        return prayers;
    }

    public void setPrayers(Set<PrayerDTO> prayers) {
        this.prayers = prayers;
    }

    public Set<DiscourseDTO> getDiscourses() {
        return discourses;
    }

    public void setDiscourses(Set<DiscourseDTO> discourses) {
        this.discourses = discourses;
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
