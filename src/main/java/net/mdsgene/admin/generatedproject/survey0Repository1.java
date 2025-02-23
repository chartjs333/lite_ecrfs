package net.mdsgene.admin.generatedproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;@Repository
public interface  survey0Repository1 extends JpaRepository<survey01, Long> {
survey01 findBySurveyTwoId(String surveyTwoId);

}