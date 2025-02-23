package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository5 extends JpaRepository<PINK1PRKN15, Long> {
PINK1PRKN15 findBySurveyTwoId(String surveyTwoId);

}