package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository2 extends JpaRepository<PINK1PRKN12, Long> {
PINK1PRKN12 findBySurveyTwoId(String surveyTwoId);

}