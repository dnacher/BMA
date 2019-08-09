package com.bma.persistence.repository;

import com.bma.persistence.model.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {

}
