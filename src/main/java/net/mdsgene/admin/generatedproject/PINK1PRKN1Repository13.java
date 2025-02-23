package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository13 extends JpaRepository<PINK1PRKN113, Long> {
PINK1PRKN113 findBySurveyTwoId(String surveyTwoId);

}