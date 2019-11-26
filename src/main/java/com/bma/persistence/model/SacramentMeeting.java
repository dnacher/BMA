package com.bma.persistence.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "sacrament_meeting")
public class SacramentMeeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "sacrament_meeting_hymn",
            joinColumns = @JoinColumn(name = "sacrament_meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "hymn_id"))
    private Set<Hymn> hymns;

    @Column(name = "announcements")
    private String announcements;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name ="sacrament_meeting_id")
    private Set<SustainingRelease>sustainingReleases;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name ="sacrament_meeting_id")
    private Set<Prayer>prayers;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name ="sacrament_meeting_id")
    private Set<Discourse> discourses;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name ="preside")
    private ChurchMember preside;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name ="lead")
    private ChurchMember lead;

    @Column(name = "assistance")
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

    public Set<Hymn> getHymns() {
        return hymns;
    }

    public void setHymns(Set<Hymn> hymns) {
        this.hymns = hymns;
    }

    public String getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(String announcements) {
        this.announcements = announcements;
    }

    public Set<SustainingRelease> getSustainingReleases() {
        return sustainingReleases;
    }

    public void setSustainingReleases(Set<SustainingRelease> sustainingReleases) {
        this.sustainingReleases = sustainingReleases;
    }

    public Set<Prayer> getPrayers() {
        return prayers;
    }

    public void setPrayers(Set<Prayer> prayers) {
        this.prayers = prayers;
    }

    public Set<Discourse> getDiscourses() {
        return discourses;
    }

    public void setDiscourses(Set<Discourse> discourses) {
        this.discourses = discourses;
    }

    public ChurchMember getPreside() {
        return preside;
    }

    public void setPreside(ChurchMember preside) {
        this.preside = preside;
    }

    public ChurchMember getLead() {
        return lead;
    }

    public void setLead(ChurchMember lead) {
        this.lead = lead;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }
}
