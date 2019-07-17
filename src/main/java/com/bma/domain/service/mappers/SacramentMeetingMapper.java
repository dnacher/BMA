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
        sacramentMeeting.setHymns(hymnMapper.mapToEntityList(dto.getHymnDTOS()));
        sacramentMeeting.setAnnouncements(dto.getAnnouncements());
        sacramentMeeting.setSustainingReleases(sustainingReleaseMapper.mapToEntityList(dto.getSustainingReleaseDTOS()));
        sacramentMeeting.setPrayers(prayerMapper.mapToEntityList(dto.getPrayerDTOS()));
        sacramentMeeting.setDiscourses(this.discourseMapper.mapToEntityList(dto.getDiscourses()));
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
        sacramentMeetingDTO.setHymnDTOS(this.hymnMapper.mapToDTOList(entity.getHymns()));
        sacramentMeetingDTO.setAnnouncements(entity.getAnnouncements());
        sacramentMeetingDTO.setSustainingReleaseDTOS(this.sustainingReleaseMapper.mapToDTOList(entity.getSustainingReleases()));
        sacramentMeetingDTO.setPrayerDTOS(prayerMapper.mapToDTOList(entity.getPrayers()));
        sacramentMeetingDTO.setDiscourses(this.discourseMapper.mapToDTOList(entity.getDiscourses()));
        sacramentMeetingDTO.setPreside(this.memberMapper.mapToDTO(entity.getPreside()));
        sacramentMeetingDTO.setLead(this.memberMapper.mapToDTO(entity.getLead()));
        sacramentMeetingDTO.setAssistance(entity.getAssistance());
        return sacramentMeetingDTO;
    }
}
