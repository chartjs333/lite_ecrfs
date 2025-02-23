package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository9 extends JpaRepository<PINK1PRKN19, Long> {
PINK1PRKN19 findBySurveyTwoId(String surveyTwoId);

}