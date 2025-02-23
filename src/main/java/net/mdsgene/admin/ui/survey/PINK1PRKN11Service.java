package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.generatedproject.PINK1PRKN11;
import net.mdsgene.admin.generatedproject.PINK1PRKN1Repository1;
import net.mdsgene.admin.ui.survey.UserSurveys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface PINK1PRKN11Service {

    public Page<PINK1PRKN11> findAll(Pageable pageable);

    public void createEcrs(UserSurveys surveyDetails);

    public String[] getECRFsStatusColors(String surveyTwoID);
}