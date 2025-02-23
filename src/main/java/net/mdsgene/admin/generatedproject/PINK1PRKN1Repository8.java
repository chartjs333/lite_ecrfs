package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository8 extends JpaRepository<PINK1PRKN18, Long> {
PINK1PRKN18 findBySurveyTwoId(String surveyTwoId);

}