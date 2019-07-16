package com.bma.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SACRAMENT_MEETING")
public class SacramentMeeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "HYMN")
    private List<Hymn> hymns;

    @Column(name = "ANNOUNCEMENTS")
    private String Announcements;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="SUSTAINING_RELEASE")
    private List<SustainingRelease>sustainingReleases;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="PRAYER")
    private List<Prayer>prayers;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="DISCOURSES")
    private List<Discourse> discourses;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="PRESIDE")
    private Member preside;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="LEAD")
    private Member lead;

    @Column(name = "ASSISTANCE")
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

    public List<Hymn> getHymns() {
        return hymns;
    }

    public void setHymns(List<Hymn> hymns) {
        this.hymns = hymns;
    }

    public String getAnnouncements() {
        return Announcements;
    }

    public void setAnnouncements(String announcements) {
        Announcements = announcements;
    }

    public List<SustainingRelease> getSustainingReleases() {
        return sustainingReleases;
    }

    public void setSustainingReleases(List<SustainingRelease> sustainingReleases) {
        this.sustainingReleases = sustainingReleases;
    }

    public List<Prayer> getPrayers() {
        return prayers;
    }

    public void setPrayers(List<Prayer> prayers) {
        this.prayers = prayers;
    }

    public List<Discourse> getDiscourses() {
        return discourses;
    }

    public void setDiscourses(List<Discourse> discourses) {
        this.discourses = discourses;
    }

    public Member getPreside() {
        return preside;
    }

    public void setPreside(Member preside) {
        this.preside = preside;
    }

    public Member getLead() {
        return lead;
    }

    public void setLead(Member lead) {
        this.lead = lead;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }
}
