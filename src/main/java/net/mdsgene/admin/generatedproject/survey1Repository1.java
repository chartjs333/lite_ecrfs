package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;@Repository
public interface  survey1Repository1 extends JpaRepository<survey11, Long> {
survey11 findBySurveyTwoId(String surveyTwoId);

}