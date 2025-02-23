package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository21 extends JpaRepository<PINK1PRKN121, Long> {
PINK1PRKN121 findBySurveyTwoId(String surveyTwoId);

}