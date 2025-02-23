package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository7 extends JpaRepository<PINK1PRKN17, Long> {
PINK1PRKN17 findBySurveyTwoId(String surveyTwoId);

}