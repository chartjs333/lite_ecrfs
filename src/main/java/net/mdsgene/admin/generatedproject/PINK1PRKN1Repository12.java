package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository12 extends JpaRepository<PINK1PRKN112, Long> {
PINK1PRKN112 findBySurveyTwoId(String surveyTwoId);

}