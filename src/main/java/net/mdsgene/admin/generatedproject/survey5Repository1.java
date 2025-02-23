package net.mdsgene.admin.generatedproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface survey5Repository1 extends JpaRepository<survey51, Long> {
    List<survey51> findBySurveyTwoId(String surveyTwoId);
}
