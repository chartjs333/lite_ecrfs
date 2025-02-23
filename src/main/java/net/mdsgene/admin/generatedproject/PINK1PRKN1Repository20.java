package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository20 extends JpaRepository<PINK1PRKN120, Long> {
PINK1PRKN120 findBySurveyTwoId(String surveyTwoId);

}