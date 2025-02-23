package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.generatedproject.PINK1PRKN11;
import net.mdsgene.admin.generatedproject.PINK1PRKN1Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PINK1PRKN11ServiceImpl implements PINK1PRKN11Service {
    @Autowired
    PINK1PRKN1Repository1 pink1prkn1Repository1;

    @Autowired
    ECRFService ecrfService;
    public Page<PINK1PRKN11> findAll(Pageable pageable) {
        return pink1prkn1Repository1.findAll(pageable);
    }

    public void createEcrs(UserSurveys surveyDetails) {
        ecrfService.createEcrs(surveyDetails);
    }

    public String[] getECRFsStatusColors(String surveyTwoID) {
        return ecrfService.getECRFsStatusColors(surveyTwoID);
    }
}