package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository16 extends JpaRepository<PINK1PRKN116, Long> {
PINK1PRKN116 findBySurveyTwoId(String surveyTwoId);

}