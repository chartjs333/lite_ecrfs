package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository24 extends JpaRepository<PINK1PRKN124, Long> {
PINK1PRKN124 findBySurveyTwoId(String surveyTwoId);

}