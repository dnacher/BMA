package com.bma.persistence.repository;

import com.bma.persistence.model.AttendanceEvaluation;
import com.bma.persistence.model.ChurchMember;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceEvaluationRepository extends CrudRepository<AttendanceEvaluation,Integer> {

    AttendanceEvaluation findByChurchMember(ChurchMember churchMember);

}
