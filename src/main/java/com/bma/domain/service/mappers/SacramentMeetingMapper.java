package com.bma.domain.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.api.dtos.SacramentMeetingDTO;
import com.bma.persistence.model.SacramentMeeting;

@Component
public class SacramentMeetingMapper implements AbstractMapper<SacramentMeeting, SacramentMeetingDTO> {


    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private HymnMapper hymnMapper;

    @Autowired
    private SustainingReleaseMapper sustainingReleaseMapper;

    @Autowired
    private DiscourseMapper discourseMapper;

    @Autowired
    private PrayerMapper prayerMapper;

    @Override
    public SacramentMeeting mapToEntity(SacramentMeetingDTO dto) {
        SacramentMeeting sacramentMeeting = new SacramentMeeting();
        sacramentMeeting.setId(dto.getId());
        sacramentMeeting.setDate(dto.getDate());
        sacramentMeeting.setHymns(hymnMapper.mapToEntitySet(dto.getHymns()));
        sacramentMeeting.setAnnouncements(dto.getAnnouncements());
        sacramentMeeting.setSustainingReleases(sustainingReleaseMapper.mapToEntitySet(dto.getSustainingReleases()));
        sacramentMeeting.setPrayers(prayerMapper.mapToEntitySet(dto.getPrayers()));
        sacramentMeeting.setDiscourses(this.discourseMapper.mapToEntitySet(dto.getDiscourses()));
        sacramentMeeting.setPreside(memberMapper.mapToEntity(dto.getPreside()));
        sacramentMeeting.setLead(memberMapper.mapToEntity(dto.getLead()));
        sacramentMeeting.setAssistance(dto.getAssistance());
        return sacramentMeeting;
    }

    @Override
    public SacramentMeetingDTO mapToDTO(SacramentMeeting entity) {
        SacramentMeetingDTO sacramentMeetingDTO = new SacramentMeetingDTO();
        sacramentMeetingDTO.setId(entity.getId());
        sacramentMeetingDTO.setDate(entity.getDate());
        sacramentMeetingDTO.setHymns(this.hymnMapper.mapToDTOSet(entity.getHymns()));
        sacramentMeetingDTO.setAnnouncements(entity.getAnnouncements());
        sacramentMeetingDTO.setSustainingReleases(this.sustainingReleaseMapper.mapToDTOSet(entity.getSustainingReleases()));
        sacramentMeetingDTO.setPrayers(prayerMapper.mapToDTOSet(entity.getPrayers()));
        sacramentMeetingDTO.setDiscourses(this.discourseMapper.mapToDTOSet(entity.getDiscourses()));
        sacramentMeetingDTO.setPreside(this.memberMapper.mapToDTO(entity.getPreside()));
        sacramentMeetingDTO.setLead(this.memberMapper.mapToDTO(entity.getLead()));
        sacramentMeetingDTO.setAssistance(entity.getAssistance());
        return sacramentMeetingDTO;
    }
}
