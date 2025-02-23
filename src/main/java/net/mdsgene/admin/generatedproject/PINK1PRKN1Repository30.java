package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository30 extends JpaRepository<PINK1PRKN130, Long> {
PINK1PRKN130 findBySurveyTwoId(String surveyTwoId);

}