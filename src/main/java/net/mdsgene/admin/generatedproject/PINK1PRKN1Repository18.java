package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository18 extends JpaRepository<PINK1PRKN118, Long> {
PINK1PRKN118 findBySurveyTwoId(String surveyTwoId);

}