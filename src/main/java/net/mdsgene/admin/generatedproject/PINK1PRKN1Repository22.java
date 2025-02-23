package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository22 extends JpaRepository<PINK1PRKN122, Long> {
PINK1PRKN122 findBySurveyTwoId(String surveyTwoId);

}