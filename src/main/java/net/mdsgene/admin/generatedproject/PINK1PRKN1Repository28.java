package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository28 extends JpaRepository<PINK1PRKN128, Long> {
PINK1PRKN128 findBySurveyTwoId(String surveyTwoId);

}