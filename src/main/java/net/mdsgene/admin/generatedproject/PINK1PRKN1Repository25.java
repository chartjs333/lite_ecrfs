package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository25 extends JpaRepository<PINK1PRKN125, Long> {
PINK1PRKN125 findBySurveyTwoId(String surveyTwoId);

}