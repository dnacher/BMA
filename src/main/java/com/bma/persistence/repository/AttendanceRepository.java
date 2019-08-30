package com.bma.persistence.repository;

import com.bma.persistence.model.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {

    List<Attendance> findAllByDate(Date date);

}
