package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PINK1PRKN1Repository11 extends JpaRepository<PINK1PRKN111, Long> {
PINK1PRKN111 findBySurveyTwoId(String surveyTwoId);

}