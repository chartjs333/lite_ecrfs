package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository10 extends JpaRepository<PINK1PRKN110, Long> {
PINK1PRKN110 findBySurveyTwoId(String surveyTwoId);

}