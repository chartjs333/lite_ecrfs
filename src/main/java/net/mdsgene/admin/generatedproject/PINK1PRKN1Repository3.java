package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository3 extends JpaRepository<PINK1PRKN13, Long> {
PINK1PRKN13 findBySurveyTwoId(String surveyTwoId);

}