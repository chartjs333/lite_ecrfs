package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository6 extends JpaRepository<PINK1PRKN16, Long> {
PINK1PRKN16 findBySurveyTwoId(String surveyTwoId);

}