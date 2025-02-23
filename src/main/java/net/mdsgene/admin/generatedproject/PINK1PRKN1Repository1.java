package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository1 extends JpaRepository<PINK1PRKN11, Long> {
PINK1PRKN11 findBySurveyTwoId(String surveyTwoId);

}