package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository15 extends JpaRepository<PINK1PRKN115, Long> {
PINK1PRKN115 findBySurveyTwoId(String surveyTwoId);

}