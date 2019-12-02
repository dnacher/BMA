package com.bma.endpoint.controller;
import com.bma.api.dtos.AttendanceDTO;
import com.bma.domain.service.AttendanceService;
import com.bma.email.EmailEvaluation;
import com.bma.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public EmailEvaluation emailEvaluation;

    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @PostMapping(value = "/")
    public AttendanceDTO saveAttendance(@RequestBody AttendanceDTO attendanceDTO){
       return this.attendanceService.saveAttendance(attendanceDTO);
    }

    @PostMapping(value = "/mul")
    public List<AttendanceDTO> saveAttendances(@RequestBody List<AttendanceDTO> attendanceDTOS){
        List<AttendanceDTO> finalList = this.attendanceService.saveAttendances(attendanceDTOS);
        emailEvaluation.createEmailObject();
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<AttendanceDTO> updateAttendances(@RequestBody List<AttendanceDTO> attendanceDTOS){
        List<AttendanceDTO> finalList = new ArrayList<>();
        attendanceDTOS.forEach(attendanceDTO -> {
            finalList.add(this.attendanceService.updateAttendance(attendanceDTO));
        });
        emailEvaluation.createEmailObject();
        return finalList;
    }

    @PostMapping(value = "/testEmail")
    public void testEmail(){
        emailEvaluation.createEmailObject();
    }

    @PostMapping(value = "/creates")
    public List<AttendanceDTO> createOrGetAttendance() {
        return this.attendanceService.createOrGetAttendance();
    }

    @GetMapping(value = "/")
    public List<AttendanceDTO> getAttendance(){
        return this.attendanceService.getAttendances();
    }

    @GetMapping(value = "/{id}")
    public AttendanceDTO getAttendanceById(@PathVariable Integer id){
        return this.attendanceService.getAttendanceById(id);
    }
    
    @PutMapping(value = "/{id}")
    public AttendanceDTO updateAttendance(@PathVariable Integer id, @RequestBody AttendanceDTO attendanceDTO){
        String msg = String.format("The Attendance Id %s is different from the Url Id",attendanceDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,attendanceDTO.getId(),msg);
        return this.attendanceService.saveAttendance(attendanceDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteAttendance(@PathVariable Integer id, AttendanceDTO attendanceDTO){
        String msg = String.format("The Attendance Id %s is different from the Url Id",attendanceDTO.getId());
        Utils.validateUrlIdEqualsBodyId(id,attendanceDTO.getId(),msg);
        this.attendanceService.deleteAttendance(attendanceDTO);
    }
}
