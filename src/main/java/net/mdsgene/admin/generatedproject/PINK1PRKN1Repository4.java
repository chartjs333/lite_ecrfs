package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository4 extends JpaRepository<PINK1PRKN14, Long> {
PINK1PRKN14 findBySurveyTwoId(String surveyTwoId);

}