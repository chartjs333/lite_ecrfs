package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository14 extends JpaRepository<PINK1PRKN114, Long> {
PINK1PRKN114 findBySurveyTwoId(String surveyTwoId);

}