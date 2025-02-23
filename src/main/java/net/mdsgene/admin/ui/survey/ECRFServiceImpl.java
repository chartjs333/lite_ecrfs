package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.admintool.dal.IUserDAO;
import net.mdsgene.admin.admintool.entities.User;
import net.mdsgene.admin.generatedproject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ECRFServiceImpl implements ECRFService {

    private final PINK1PRKN1Repository1 pink1PRKN1Repository1;
    private final PINK1PRKN1Repository2 pink1PRKN1Repository2;
    private final PINK1PRKN1Repository3 pink1PRKN1Repository3;
    private final PINK1PRKN1Repository4 pink1PRKN1Repository4;
    private final PINK1PRKN1Repository5 pink1PRKN1Repository5;
    private final PINK1PRKN1Repository6 pink1PRKN1Repository6;
    private final PINK1PRKN1Repository7 pink1PRKN1Repository7;
    private final PINK1PRKN1Repository8 pink1PRKN1Repository8;
    private final PINK1PRKN1Repository9 pink1PRKN1Repository9;
    private final PINK1PRKN1Repository10 pink1PRKN1Repository10;
    private final PINK1PRKN1Repository11 pink1PRKN1Repository11;
    private final PINK1PRKN1Repository12 pink1PRKN1Repository12;
    private final PINK1PRKN1Repository13 pink1PRKN1Repository13;
    private final PINK1PRKN1Repository14 pink1PRKN1Repository14;
    private final PINK1PRKN1Repository15 pink1PRKN1Repository15;
    private final PINK1PRKN1Repository16 pink1PRKN1Repository16;
    private final PINK1PRKN1Repository17 pink1PRKN1Repository17;
    private final PINK1PRKN1Repository18 pink1PRKN1Repository18;
    private final PINK1PRKN1Repository19 pink1PRKN1Repository19;
    private final PINK1PRKN1Repository20 pink1PRKN1Repository20;
    private final PINK1PRKN1Repository21 pink1PRKN1Repository21;
    private final PINK1PRKN1Repository22 pink1PRKN1Repository22;
    private final PINK1PRKN1Repository23 pink1PRKN1Repository23;
    private final PINK1PRKN1Repository24 pink1PRKN1Repository24;
    private final PINK1PRKN1Repository25 pink1PRKN1Repository25;
    private final PINK1PRKN1Repository26 pink1PRKN1Repository26;
    private final PINK1PRKN1Repository27 pink1PRKN1Repository27;
    private final PINK1PRKN1Repository28 pink1PRKN1Repository28;
    private final PINK1PRKN1Repository29 pink1PRKN1Repository29;
    private final PINK1PRKN1Repository30 pink1PRKN1Repository30;

    private final IUserDAO userRepository;

    private final SurveyRepository surveyRepository;

    @Autowired
    public ECRFServiceImpl(
            PINK1PRKN1Repository1 pink1PRKN1Repository1,
            PINK1PRKN1Repository2 pink1PRKN1Repository2,
            PINK1PRKN1Repository3 pink1PRKN1Repository3,
            PINK1PRKN1Repository4 pink1PRKN1Repository4,
            PINK1PRKN1Repository5 pink1PRKN1Repository5,
            PINK1PRKN1Repository6 pink1PRKN1Repository6,
            PINK1PRKN1Repository7 pink1PRKN1Repository7,
            PINK1PRKN1Repository8 pink1PRKN1Repository8,
            PINK1PRKN1Repository9 pink1PRKN1Repository9,
            PINK1PRKN1Repository10 pink1PRKN1Repository10,
            PINK1PRKN1Repository11 pink1PRKN1Repository11,
            PINK1PRKN1Repository12 pink1PRKN1Repository12,
            PINK1PRKN1Repository13 pink1PRKN1Repository13,
            PINK1PRKN1Repository14 pink1PRKN1Repository14,
            PINK1PRKN1Repository15 pink1PRKN1Repository15,
            PINK1PRKN1Repository16 pink1PRKN1Repository16,
            PINK1PRKN1Repository17 pink1PRKN1Repository17,
            PINK1PRKN1Repository18 pink1PRKN1Repository18,
            PINK1PRKN1Repository19 pink1PRKN1Repository19,
            PINK1PRKN1Repository20 pink1PRKN1Repository20,
            PINK1PRKN1Repository21 pink1PRKN1Repository21,
            PINK1PRKN1Repository22 pink1PRKN1Repository22,
            PINK1PRKN1Repository23 pink1PRKN1Repository23,
            PINK1PRKN1Repository24 pink1PRKN1Repository24,
            PINK1PRKN1Repository25 pink1PRKN1Repository25,
            PINK1PRKN1Repository26 pink1PRKN1Repository26,
            PINK1PRKN1Repository27 pink1PRKN1Repository27,
            PINK1PRKN1Repository28 pink1PRKN1Repository28,
            PINK1PRKN1Repository29 pink1PRKN1Repository29,
            PINK1PRKN1Repository30 pink1PRKN1Repository30,
            IUserDAO userRepository, SurveyRepository surveyRepository
    ) {
        this.pink1PRKN1Repository1 = pink1PRKN1Repository1;
        this.pink1PRKN1Repository2 = pink1PRKN1Repository2;
        this.pink1PRKN1Repository3 = pink1PRKN1Repository3;
        this.pink1PRKN1Repository4 = pink1PRKN1Repository4;
        this.pink1PRKN1Repository5 = pink1PRKN1Repository5;
        this.pink1PRKN1Repository6 = pink1PRKN1Repository6;
        this.pink1PRKN1Repository7 = pink1PRKN1Repository7;
        this.pink1PRKN1Repository8 = pink1PRKN1Repository8;
        this.pink1PRKN1Repository9 = pink1PRKN1Repository9;
        this.pink1PRKN1Repository10 = pink1PRKN1Repository10;
        this.pink1PRKN1Repository11 = pink1PRKN1Repository11;
        this.pink1PRKN1Repository12 = pink1PRKN1Repository12;
        this.pink1PRKN1Repository13 = pink1PRKN1Repository13;
        this.pink1PRKN1Repository14 = pink1PRKN1Repository14;
        this.pink1PRKN1Repository15 = pink1PRKN1Repository15;
        this.pink1PRKN1Repository16 = pink1PRKN1Repository16;
        this.pink1PRKN1Repository17 = pink1PRKN1Repository17;
        this.pink1PRKN1Repository18 = pink1PRKN1Repository18;
        this.pink1PRKN1Repository19 = pink1PRKN1Repository19;
        this.pink1PRKN1Repository20 = pink1PRKN1Repository20;
        this.pink1PRKN1Repository21 = pink1PRKN1Repository21;
        this.pink1PRKN1Repository22 = pink1PRKN1Repository22;
        this.pink1PRKN1Repository23 = pink1PRKN1Repository23;
        this.pink1PRKN1Repository24 = pink1PRKN1Repository24;
        this.pink1PRKN1Repository25 = pink1PRKN1Repository25;
        this.pink1PRKN1Repository26 = pink1PRKN1Repository26;
        this.pink1PRKN1Repository27 = pink1PRKN1Repository27;
        this.pink1PRKN1Repository28 = pink1PRKN1Repository28;
        this.pink1PRKN1Repository29 = pink1PRKN1Repository29;
        this.pink1PRKN1Repository30 = pink1PRKN1Repository30;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
    }

    public void deleteECRF(String surveyTwoID) {
        PINK1PRKN11 bySurveyTwoId = pink1PRKN1Repository1.findBySurveyTwoId(surveyTwoID);
        if (bySurveyTwoId != null) {
            pink1PRKN1Repository1.delete(bySurveyTwoId);
        }

        this.deleteOtherECRF(surveyTwoID);
    }

    public void deleteECRFs(List<String> surveyTwoID) {
        surveyTwoID.forEach(this::deleteECRF);
    }

    private void deleteOtherECRF(String surveyTwoId){
        PINK1PRKN12 ecrf2 = this.pink1PRKN1Repository2.findBySurveyTwoId(surveyTwoId);
        if (ecrf2 != null) {
            this.pink1PRKN1Repository2.delete(ecrf2);
        }
        PINK1PRKN13 ecrf3 = this.pink1PRKN1Repository3.findBySurveyTwoId(surveyTwoId);
        if (ecrf3 != null) {
            this.pink1PRKN1Repository3.delete(ecrf3);
        }
        PINK1PRKN14 ecrf4 = this.pink1PRKN1Repository4.findBySurveyTwoId(surveyTwoId);
        if (ecrf4 != null) {
            this.pink1PRKN1Repository4.delete(ecrf4);
        }
        PINK1PRKN15 ecrf5 = this.pink1PRKN1Repository5.findBySurveyTwoId(surveyTwoId);
        if (ecrf5 != null) {
            this.pink1PRKN1Repository5.delete(ecrf5);
        }
        PINK1PRKN16 ecrf6 = this.pink1PRKN1Repository6.findBySurveyTwoId(surveyTwoId);
        if (ecrf6 != null) {
            this.pink1PRKN1Repository6.delete(ecrf6);
        }
        PINK1PRKN17 ecrf7 = this.pink1PRKN1Repository7.findBySurveyTwoId(surveyTwoId);
        if (ecrf7 != null) {
            this.pink1PRKN1Repository7.delete(ecrf7);
        }
        PINK1PRKN18 ecrf8 = this.pink1PRKN1Repository8.findBySurveyTwoId(surveyTwoId);
        if (ecrf8 != null) {
            this.pink1PRKN1Repository8.delete(ecrf8);
        }
        PINK1PRKN19 ecrf9 = this.pink1PRKN1Repository9.findBySurveyTwoId(surveyTwoId);
        if (ecrf9 != null) {
            this.pink1PRKN1Repository9.delete(ecrf9);
        }
        PINK1PRKN110 ecrf10 = this.pink1PRKN1Repository10.findBySurveyTwoId(surveyTwoId);
        if (ecrf10 != null) {
            this.pink1PRKN1Repository10.delete(ecrf10);
        }
        PINK1PRKN111 ecrf11 = this.pink1PRKN1Repository11.findBySurveyTwoId(surveyTwoId);
        if (ecrf11 != null) {
            this.pink1PRKN1Repository11.delete(ecrf11);
        }
        PINK1PRKN112 ecrf12 = this.pink1PRKN1Repository12.findBySurveyTwoId(surveyTwoId);
        if (ecrf12 != null) {
            this.pink1PRKN1Repository12.delete(ecrf12);
        }
        PINK1PRKN113 ecrf13 = this.pink1PRKN1Repository13.findBySurveyTwoId(surveyTwoId);
        if (ecrf13 != null) {
            this.pink1PRKN1Repository13.delete(ecrf13);
        }
        PINK1PRKN114 ecrf14 = this.pink1PRKN1Repository14.findBySurveyTwoId(surveyTwoId);
        if (ecrf14 != null) {
            this.pink1PRKN1Repository14.delete(ecrf14);
        }
        PINK1PRKN115 ecrf15 = this.pink1PRKN1Repository15.findBySurveyTwoId(surveyTwoId);
        if (ecrf15 != null) {
            this.pink1PRKN1Repository15.delete(ecrf15);
        }
        PINK1PRKN116 ecrf16 = this.pink1PRKN1Repository16.findBySurveyTwoId(surveyTwoId);
        if (ecrf16 != null) {
            this.pink1PRKN1Repository16.delete(ecrf16);
        }
        PINK1PRKN117 ecrf17 = this.pink1PRKN1Repository17.findBySurveyTwoId(surveyTwoId);
        if (ecrf17 != null) {
            this.pink1PRKN1Repository17.delete(ecrf17);
        }
        PINK1PRKN118 ecrf18 = this.pink1PRKN1Repository18.findBySurveyTwoId(surveyTwoId);
        if (ecrf18 != null) {
            this.pink1PRKN1Repository18.delete(ecrf18);
        }
        PINK1PRKN119 ecrf19 = this.pink1PRKN1Repository19.findBySurveyTwoId(surveyTwoId);
        if (ecrf19 != null) {
            this.pink1PRKN1Repository19.delete(ecrf19);
        }
        PINK1PRKN120 ecrf20 = this.pink1PRKN1Repository20.findBySurveyTwoId(surveyTwoId);
        if (ecrf20 != null) {
            this.pink1PRKN1Repository20.delete(ecrf20);
        }
        PINK1PRKN121 ecrf21 = this.pink1PRKN1Repository21.findBySurveyTwoId(surveyTwoId);
        if (ecrf21 != null) {
            this.pink1PRKN1Repository21.delete(ecrf21);
        }
        PINK1PRKN122 ecrf22 = this.pink1PRKN1Repository22.findBySurveyTwoId(surveyTwoId);
        if (ecrf22 != null) {
            this.pink1PRKN1Repository22.delete(ecrf22);
        }
        PINK1PRKN123 ecrf23 = this.pink1PRKN1Repository23.findBySurveyTwoId(surveyTwoId);
        if (ecrf23 != null) {
            this.pink1PRKN1Repository23.delete(ecrf23);
        }
        PINK1PRKN124 ecrf24 = this.pink1PRKN1Repository24.findBySurveyTwoId(surveyTwoId);
        if (ecrf24 != null) {
            this.pink1PRKN1Repository24.delete(ecrf24);
        }
        PINK1PRKN125 ecrf25 = this.pink1PRKN1Repository25.findBySurveyTwoId(surveyTwoId);
        if (ecrf25 != null) {
            this.pink1PRKN1Repository25.delete(ecrf25);
        }
        PINK1PRKN126 ecrf26 = this.pink1PRKN1Repository26.findBySurveyTwoId(surveyTwoId);
        if (ecrf26 != null) {
            this.pink1PRKN1Repository26.delete(ecrf26);
        }
        PINK1PRKN127 ecrf27 = this.pink1PRKN1Repository27.findBySurveyTwoId(surveyTwoId);
        if (ecrf27 != null) {
            this.pink1PRKN1Repository27.delete(ecrf27);
        }
        PINK1PRKN128 ecrf28 = this.pink1PRKN1Repository28.findBySurveyTwoId(surveyTwoId);
        if (ecrf28 != null) {
            this.pink1PRKN1Repository28.delete(ecrf28);
        }
        PINK1PRKN129 ecrf29 = this.pink1PRKN1Repository29.findBySurveyTwoId(surveyTwoId);
        if (ecrf29 != null) {
            this.pink1PRKN1Repository29.delete(ecrf29);
        }
        PINK1PRKN130 ecrf30 = this.pink1PRKN1Repository30.findBySurveyTwoId(surveyTwoId);
        if (ecrf30 != null) {
            this.pink1PRKN1Repository30.delete(ecrf30);
        }
    }

    private void updateOtherECRF(String oldSurveyTwoId, String newSurveyTwoId, User user) {
        PINK1PRKN12 ecrf2 = this.pink1PRKN1Repository2.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf2 != null) {
            ecrf2.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository2.save(ecrf2);
        }
        PINK1PRKN13 ecrf3 = this.pink1PRKN1Repository3.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf3 != null) {
            ecrf3.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository3.save(ecrf3);
        }
        PINK1PRKN14 ecrf4 = this.pink1PRKN1Repository4.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf4 != null) {
            ecrf4.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository4.save(ecrf4);
        }
        PINK1PRKN15 ecrf5 = this.pink1PRKN1Repository5.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf5 != null) {
            ecrf5.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository5.save(ecrf5);
        }
        PINK1PRKN16 ecrf6 = this.pink1PRKN1Repository6.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf6 != null) {
            ecrf6.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository6.save(ecrf6);
        }
        PINK1PRKN17 ecrf7 = this.pink1PRKN1Repository7.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf7 != null) {
            ecrf7.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository7.save(ecrf7);
        }
        PINK1PRKN18 ecrf8 = this.pink1PRKN1Repository8.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf8 != null) {
            ecrf8.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository8.save(ecrf8);
        }
        PINK1PRKN19 ecrf9 = this.pink1PRKN1Repository9.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf9 != null) {
            ecrf9.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository9.save(ecrf9);
        }
        PINK1PRKN110 ecrf10 = this.pink1PRKN1Repository10.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf10 != null) {
            ecrf10.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository10.save(ecrf10);
        }
        PINK1PRKN111 ecrf11 = this.pink1PRKN1Repository11.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf11 != null) {
            ecrf11.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository11.save(ecrf11);
        }
        PINK1PRKN112 ecrf12 = this.pink1PRKN1Repository12.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf12 != null) {
            ecrf12.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository12.save(ecrf12);
        }
        PINK1PRKN113 ecrf13 = this.pink1PRKN1Repository13.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf13 != null) {
            ecrf13.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository13.save(ecrf13);
        }
        PINK1PRKN114 ecrf14 = this.pink1PRKN1Repository14.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf14 != null) {
            ecrf14.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository14.save(ecrf14);
        }
        PINK1PRKN115 ecrf15 = this.pink1PRKN1Repository15.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf15 != null) {
            ecrf15.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository15.save(ecrf15);
        }
        PINK1PRKN116 ecrf16 = this.pink1PRKN1Repository16.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf16 != null) {
            ecrf16.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository16.save(ecrf16);
        }
        PINK1PRKN117 ecrf17 = this.pink1PRKN1Repository17.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf17 != null) {
            ecrf17.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository17.save(ecrf17);
        }
        PINK1PRKN118 ecrf18 = this.pink1PRKN1Repository18.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf18 != null) {
            ecrf18.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository18.save(ecrf18);
        }
        PINK1PRKN119 ecrf19 = this.pink1PRKN1Repository19.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf19 != null) {
            ecrf19.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository19.save(ecrf19);
        }
        PINK1PRKN120 ecrf20 = this.pink1PRKN1Repository20.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf20 != null) {
            ecrf20.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository20.save(ecrf20);
        }
        PINK1PRKN121 ecrf21 = this.pink1PRKN1Repository21.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf21 != null) {
            ecrf21.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository21.save(ecrf21);
        }
        PINK1PRKN122 ecrf22 = this.pink1PRKN1Repository22.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf22 != null) {
            ecrf22.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository22.save(ecrf22);
        }
        PINK1PRKN123 ecrf23 = this.pink1PRKN1Repository23.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf23 != null) {
            ecrf23.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository23.save(ecrf23);
        }
        PINK1PRKN124 ecrf24 = this.pink1PRKN1Repository24.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf24 != null) {
            ecrf24.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository24.save(ecrf24);
        }
        PINK1PRKN125 ecrf25 = this.pink1PRKN1Repository25.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf25 != null) {
            ecrf25.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository25.save(ecrf25);
        }
        PINK1PRKN126 ecrf26 = this.pink1PRKN1Repository26.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf26 != null) {
            ecrf26.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository26.save(ecrf26);
        }
        PINK1PRKN127 ecrf27 = this.pink1PRKN1Repository27.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf27 != null) {
            ecrf27.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository27.save(ecrf27);
        }
        PINK1PRKN128 ecrf28 = this.pink1PRKN1Repository28.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf28 != null) {
            ecrf28.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository28.save(ecrf28);
        }
        PINK1PRKN129 ecrf29 = this.pink1PRKN1Repository29.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf29 != null) {
            ecrf29.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository29.save(ecrf29);
        }
        PINK1PRKN130 ecrf30 = this.pink1PRKN1Repository30.findBySurveyTwoId(oldSurveyTwoId);
        if (ecrf30 != null) {
            ecrf30.setSurveyTwoId(newSurveyTwoId);
            this.pink1PRKN1Repository30.save(ecrf30);
        }
    }

//    @Transactional
//    @Override
//    public void assignECRFByPatIDs(AssignECRFRequest request) {
//        Long userId = request.getAssignTo();
//
//        Arrays.stream( request.getSurveyTwoId().split(","))
//                .filter(StringUtils::isNotBlank)
//                .forEach(pat -> this.assignECRF(pat, userId));
//
//    }
//
//    @Override
//    public List<String> getPatId() {
//        return eCRF1REpository.getDistinctPatID();
//    }
//
//    @Override
//    public DataTableResponse getECRFReport(DataTableRequest dataTable) throws ParseException {
//        eCRFSpecification specification = new eCRFSpecification();
//        String value = dataTable.getSearch().getValue();
//        if (StringUtils.isNotBlank(value)) {
//            var criteria = new SearchCriteria("patID", value, SearchOperation.LIKE);
//            specification.add(criteria);
//        }
//
//        for (DataTableColumnSpecs col : dataTable.getColumns()) {
//            String searchValue = col.getSearch().getValue();
//            if (StringUtils.isNotBlank(searchValue)) {
//                if (col.getName().equals("patID")) {
//                    specification.setPatIds(Arrays.stream(searchValue.split(",")).collect(Collectors.toList()));
//                }else if(col.getName().equals("userWithAddress")){
//                    specification.setUserIds(Arrays.stream(searchValue.split(",")).collect(Collectors.toList()));
//                }
//            }
//        }
//
//        DataTableOrder order = dataTable.getOrder().stream().findFirst().orElse(null);
//
//        Pageable sortedByName = PageRequest.of(dataTable.getStart(), dataTable.getLength());
//        if (order != null) {
//            DataTableColumnSpecs dataTableColumnSpecs = dataTable.getColumns().get(order.getColumn());
//            if (dataTableColumnSpecs != null) {
//                String data = dataTableColumnSpecs.getData();
//                if (data.equals("checkbox") || data.equals("action")) {
//                    data = "id";
//                }
//                Sort.Direction dir = (order.getDir().equals("asc")) ? Sort.Direction.ASC : Sort.Direction.DESC;
//                Sort by = Sort.by(new Sort.Order(dir, data));
//                int pageNumber = DataTableUtils.getPageNumber(dataTable);
//                sortedByName = PageRequest.of(pageNumber, dataTable.getLength(), by);
//            }
//        }
//
//        Page<PINK1PRKN11> all = eCRF1REpository.findAll(specification, sortedByName);
//        List<EcrfDataTable> dataTablesData = mapECRFDataToDataTable(all.getContent());
//        long totalRecord = eCRF1REpository.count();
//        long filteredRecord = eCRF1REpository.count(specification);
//        DataTableResponse<EcrfDataTable> response = new DataTableResponse<>();
//        response.setData(dataTablesData);
//        response.setDraw(dataTable.getDraw());
//        response.setRecordsFiltered(filteredRecord);
//        response.setRecordsTotal(totalRecord);
//
//        return response;
//    }
//
//    private List<EcrfDataTable> mapECRFDataToDataTable(List<PINK1PRKN11> eCRFs) throws ParseException {
//        List<EcrfDataTable> dataTablesData = new ArrayList<>();
//        for (PINK1PRKN11 eCRF : eCRFs) {
//            EcrfDataTable ecrfDataTable = new EcrfDataTable();
//            ecrfDataTable.setId(eCRF.getId());
//            ecrfDataTable.setCheckbox(eCRF.getSurveyTwoId());
//            ecrfDataTable.setAction(eCRF.getSurveyTwoId());
//            ecrfDataTable.setPatID(eCRF.getPatID());
//            ecrfDataTable.setFillingStatus(eCRF.getFillingStatus());
//
//            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(eCRF.getCreatedAt());
//            ecrfDataTable.setCreatedAt(format);
//
//            String fullName = eCRF.getUser().getFirstName() + " " + eCRF.getUser().getSurname();
//            String address = eCRF.getUser().getCountry();
//
//            ecrfDataTable.setUserWithAddress(fullName + "(" + address + ")");
//
//            dataTablesData.add(ecrfDataTable);
//        }
//
//        return dataTablesData;
//    }

    private String createSurveyTwoId(String userId) {
        return userId + "-" + Calendar.getInstance().getTime().getTime();
    }

    @Override
    public void createEcrs(UserSurveys surveyDetails) {
        String surveyTwoId = surveyDetails.getSurveyId();
        //check if survey two id is already present
        PINK1PRKN11 bySurveyTwoId = pink1PRKN1Repository1.findBySurveyTwoId(surveyTwoId);
        if (bySurveyTwoId == null) {
            createOtherECRF(surveyTwoId);
        }
    }

    public void createOtherECRF(String surveyTwoId) {
        // Для PINK1PRKN11
        PINK1PRKN11 ecrf1 = this.pink1PRKN1Repository1.findBySurveyTwoId(surveyTwoId);
        if (ecrf1 == null) {
            ecrf1 = new PINK1PRKN11();
            ecrf1.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository1.save(ecrf1);
        }

        // Для PINK1PRKN12
        PINK1PRKN12 ecrf2 = this.pink1PRKN1Repository2.findBySurveyTwoId(surveyTwoId);
        if (ecrf2 == null) {
            ecrf2 = new PINK1PRKN12();
            ecrf2.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository2.save(ecrf2);
        }

        // Для PINK1PRKN13
        PINK1PRKN13 ecrf3 = this.pink1PRKN1Repository3.findBySurveyTwoId(surveyTwoId);
        if (ecrf3 == null) {
            ecrf3 = new PINK1PRKN13();
            ecrf3.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository3.save(ecrf3);
        }

        // Для PINK1PRKN14
        PINK1PRKN14 ecrf4 = this.pink1PRKN1Repository4.findBySurveyTwoId(surveyTwoId);
        if (ecrf4 == null) {
            ecrf4 = new PINK1PRKN14();
            ecrf4.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository4.save(ecrf4);
        }

        // Для PINK1PRKN15
        PINK1PRKN15 ecrf5 = this.pink1PRKN1Repository5.findBySurveyTwoId(surveyTwoId);
        if (ecrf5 == null) {
            ecrf5 = new PINK1PRKN15();
            ecrf5.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository5.save(ecrf5);
        }

        // Для PINK1PRKN16
        PINK1PRKN16 ecrf6 = this.pink1PRKN1Repository6.findBySurveyTwoId(surveyTwoId);
        if (ecrf6 == null) {
            ecrf6 = new PINK1PRKN16();
            ecrf6.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository6.save(ecrf6);
        }

        // Для PINK1PRKN17
        PINK1PRKN17 ecrf7 = this.pink1PRKN1Repository7.findBySurveyTwoId(surveyTwoId);
        if (ecrf7 == null) {
            ecrf7 = new PINK1PRKN17();
            ecrf7.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository7.save(ecrf7);
        }

        // Для PINK1PRKN18
        PINK1PRKN18 ecrf8 = this.pink1PRKN1Repository8.findBySurveyTwoId(surveyTwoId);
        if (ecrf8 == null) {
            ecrf8 = new PINK1PRKN18();
            ecrf8.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository8.save(ecrf8);
        }

        // Для PINK1PRKN19
        PINK1PRKN19 ecrf9 = this.pink1PRKN1Repository9.findBySurveyTwoId(surveyTwoId);
        if (ecrf9 == null) {
            ecrf9 = new PINK1PRKN19();
            ecrf9.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository9.save(ecrf9);
        }

        // Для PINK1PRKN110
        PINK1PRKN110 ecrf10 = this.pink1PRKN1Repository10.findBySurveyTwoId(surveyTwoId);
        if (ecrf10 == null) {
            ecrf10 = new PINK1PRKN110();
            ecrf10.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository10.save(ecrf10);
        }

        // Для PINK1PRKN111
        PINK1PRKN111 ecrf11 = this.pink1PRKN1Repository11.findBySurveyTwoId(surveyTwoId);
        if (ecrf11 == null) {
            ecrf11 = new PINK1PRKN111();
            ecrf11.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository11.save(ecrf11);
        }

        // Для PINK1PRKN112
        PINK1PRKN112 ecrf12 = this.pink1PRKN1Repository12.findBySurveyTwoId(surveyTwoId);
        if (ecrf12 == null) {
            ecrf12 = new PINK1PRKN112();
            ecrf12.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository12.save(ecrf12);
        }

        // Для PINK1PRKN113
        PINK1PRKN113 ecrf13 = this.pink1PRKN1Repository13.findBySurveyTwoId(surveyTwoId);
        if (ecrf13 == null) {
            ecrf13 = new PINK1PRKN113();
            ecrf13.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository13.save(ecrf13);
        }

        // Для PINK1PRKN114
        PINK1PRKN114 ecrf14 = this.pink1PRKN1Repository14.findBySurveyTwoId(surveyTwoId);
        if (ecrf14 == null) {
            ecrf14 = new PINK1PRKN114();
            ecrf14.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository14.save(ecrf14);
        }

        // Для PINK1PRKN115
        PINK1PRKN115 ecrf15 = this.pink1PRKN1Repository15.findBySurveyTwoId(surveyTwoId);
        if (ecrf15 == null) {
            ecrf15 = new PINK1PRKN115();
            ecrf15.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository15.save(ecrf15);
        }

        // Для PINK1PRKN116
        PINK1PRKN116 ecrf16 = this.pink1PRKN1Repository16.findBySurveyTwoId(surveyTwoId);
        if (ecrf16 == null) {
            ecrf16 = new PINK1PRKN116();
            ecrf16.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository16.save(ecrf16);
        }

        // Для PINK1PRKN117
        PINK1PRKN117 ecrf17 = this.pink1PRKN1Repository17.findBySurveyTwoId(surveyTwoId);
        if (ecrf17 == null) {
            ecrf17 = new PINK1PRKN117();
            ecrf17.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository17.save(ecrf17);
        }

        // Для PINK1PRKN118
        PINK1PRKN118 ecrf18 = this.pink1PRKN1Repository18.findBySurveyTwoId(surveyTwoId);
        if (ecrf18 == null) {
            ecrf18 = new PINK1PRKN118();
            ecrf18.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository18.save(ecrf18);
        }

        // Для PINK1PRKN119
        PINK1PRKN119 ecrf19 = this.pink1PRKN1Repository19.findBySurveyTwoId(surveyTwoId);
        if (ecrf19 == null) {
            ecrf19 = new PINK1PRKN119();
            ecrf19.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository19.save(ecrf19);
        }

        // Для PINK1PRKN120
        PINK1PRKN120 ecrf20 = this.pink1PRKN1Repository20.findBySurveyTwoId(surveyTwoId);
        if (ecrf20 == null) {
            ecrf20 = new PINK1PRKN120();
            ecrf20.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository20.save(ecrf20);
        }

        // Для PINK1PRKN121
        PINK1PRKN121 ecrf21 = this.pink1PRKN1Repository21.findBySurveyTwoId(surveyTwoId);
        if (ecrf21 == null) {
            ecrf21 = new PINK1PRKN121();
            ecrf21.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository21.save(ecrf21);
        }

        // Для PINK1PRKN122
        PINK1PRKN122 ecrf22 = this.pink1PRKN1Repository22.findBySurveyTwoId(surveyTwoId);
        if (ecrf22 == null) {
            ecrf22 = new PINK1PRKN122();
            ecrf22.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository22.save(ecrf22);
        }

        // Для PINK1PRKN123
        PINK1PRKN123 ecrf23 = this.pink1PRKN1Repository23.findBySurveyTwoId(surveyTwoId);
        if (ecrf23 == null) {
            ecrf23 = new PINK1PRKN123();
            ecrf23.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository23.save(ecrf23);
        }

        // Для PINK1PRKN124
        PINK1PRKN124 ecrf24 = this.pink1PRKN1Repository24.findBySurveyTwoId(surveyTwoId);
        if (ecrf24 == null) {
            ecrf24 = new PINK1PRKN124();
            ecrf24.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository24.save(ecrf24);
        }

        // Для PINK1PRKN125
        PINK1PRKN125 ecrf25 = this.pink1PRKN1Repository25.findBySurveyTwoId(surveyTwoId);
        if (ecrf25 == null) {
            ecrf25 = new PINK1PRKN125();
            ecrf25.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository25.save(ecrf25);
        }
        // Для PINK1PRKN126
        PINK1PRKN126 ecrf26 = this.pink1PRKN1Repository26.findBySurveyTwoId(surveyTwoId);
        if (ecrf26 == null) {
            ecrf26 = new PINK1PRKN126();
            ecrf26.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository26.save(ecrf26);
        }
        // Для PINK1PRKN127
        PINK1PRKN127 ecrf27 = this.pink1PRKN1Repository27.findBySurveyTwoId(surveyTwoId);
        if (ecrf27 == null) {
            ecrf27 = new PINK1PRKN127();
            ecrf27.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository27.save(ecrf27);
        }
        // Для PINK1PRKN128
        PINK1PRKN128 ecrf28 = this.pink1PRKN1Repository28.findBySurveyTwoId(surveyTwoId);
        if (ecrf28 == null) {
            ecrf28 = new PINK1PRKN128();
            ecrf28.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository28.save(ecrf28);
        }
        // Для PINK1PRKN129
        PINK1PRKN129 ecrf29 = this.pink1PRKN1Repository29.findBySurveyTwoId(surveyTwoId);
        if (ecrf29 == null) {
            ecrf29 = new PINK1PRKN129();
            ecrf29.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository29.save(ecrf29);
        }
        // Для PINK1PRKN130
        PINK1PRKN130 ecrf30 = this.pink1PRKN1Repository30.findBySurveyTwoId(surveyTwoId);
        if (ecrf30 == null) {
            ecrf30 = new PINK1PRKN130();
            ecrf30.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository30.save(ecrf30);
        }
    }

    @Override
    public String[] getECRFsStatusColors(String surveyTwoId) {
        String[] statusColors = new String[30];

        // Для PINK1PRKN11
        PINK1PRKN11 ecrf1 = this.pink1PRKN1Repository1.findBySurveyTwoId(surveyTwoId);
        if (ecrf1 == null) {
            ecrf1 = new PINK1PRKN11();
            ecrf1.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository1.save(ecrf1);
        }
        statusColors[0] = ecrf1.getStatusColor();

        // Для PINK1PRKN12
        PINK1PRKN12 ecrf2 = this.pink1PRKN1Repository2.findBySurveyTwoId(surveyTwoId);
        if (ecrf2 == null) {
            ecrf2 = new PINK1PRKN12();
            ecrf2.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository2.save(ecrf2);
        }
        statusColors[1] = ecrf2.getStatusColor();

        // Для PINK1PRKN13
        PINK1PRKN13 ecrf3 = this.pink1PRKN1Repository3.findBySurveyTwoId(surveyTwoId);
        if (ecrf3 == null) {
            ecrf3 = new PINK1PRKN13();
            ecrf3.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository3.save(ecrf3);
        }
        statusColors[2] = ecrf3.getStatusColor();

        // Для PINK1PRKN14
        PINK1PRKN14 ecrf4 = this.pink1PRKN1Repository4.findBySurveyTwoId(surveyTwoId);
        if (ecrf4 == null) {
            ecrf4 = new PINK1PRKN14();
            ecrf4.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository4.save(ecrf4);
        }
        statusColors[3] = ecrf4.getStatusColor();

        // Для PINK1PRKN15
        PINK1PRKN15 ecrf5 = this.pink1PRKN1Repository5.findBySurveyTwoId(surveyTwoId);
        if (ecrf5 == null) {
            ecrf5 = new PINK1PRKN15();
            ecrf5.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository5.save(ecrf5);
        }
        statusColors[4] = ecrf5.getStatusColor();

        // Для PINK1PRKN16
        PINK1PRKN16 ecrf6 = this.pink1PRKN1Repository6.findBySurveyTwoId(surveyTwoId);
        if (ecrf6 == null) {
            ecrf6 = new PINK1PRKN16();
            ecrf6.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository6.save(ecrf6);
        }
        statusColors[5] = ecrf6.getStatusColor();

        // Для PINK1PRKN17
        PINK1PRKN17 ecrf7 = this.pink1PRKN1Repository7.findBySurveyTwoId(surveyTwoId);
        if (ecrf7 == null) {
            ecrf7 = new PINK1PRKN17();
            ecrf7.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository7.save(ecrf7);
        }
        statusColors[6] = ecrf7.getStatusColor();

        // Для PINK1PRKN18
        PINK1PRKN18 ecrf8 = this.pink1PRKN1Repository8.findBySurveyTwoId(surveyTwoId);
        if (ecrf8 == null) {
            ecrf8 = new PINK1PRKN18();
            ecrf8.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository8.save(ecrf8);
        }
        statusColors[7] = ecrf8.getStatusColor();

        // Для PINK1PRKN19
        PINK1PRKN19 ecrf9 = this.pink1PRKN1Repository9.findBySurveyTwoId(surveyTwoId);
        if (ecrf9 == null) {
            ecrf9 = new PINK1PRKN19();
            ecrf9.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository9.save(ecrf9);
        }
        statusColors[8] = ecrf9.getStatusColor();

        // Для PINK1PRKN110
        PINK1PRKN110 ecrf10 = this.pink1PRKN1Repository10.findBySurveyTwoId(surveyTwoId);
        if (ecrf10 == null) {
            ecrf10 = new PINK1PRKN110();
            ecrf10.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository10.save(ecrf10);
        }
        statusColors[9] = ecrf10.getStatusColor();

        // Для PINK1PRKN111
        PINK1PRKN111 ecrf11 = this.pink1PRKN1Repository11.findBySurveyTwoId(surveyTwoId);
        if (ecrf11 == null) {
            ecrf11 = new PINK1PRKN111();
            ecrf11.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository11.save(ecrf11);
        }
        statusColors[10] = ecrf11.getStatusColor();

        // Для PINK1PRKN112
        PINK1PRKN112 ecrf12 = this.pink1PRKN1Repository12.findBySurveyTwoId(surveyTwoId);
        if (ecrf12 == null) {
            ecrf12 = new PINK1PRKN112();
            ecrf12.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository12.save(ecrf12);
        }
        statusColors[11] = ecrf12.getStatusColor();

        // Для PINK1PRKN113
        PINK1PRKN113 ecrf13 = this.pink1PRKN1Repository13.findBySurveyTwoId(surveyTwoId);
        if (ecrf13 == null) {
            ecrf13 = new PINK1PRKN113();
            ecrf13.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository13.save(ecrf13);
        }
        statusColors[12] = ecrf13.getStatusColor();

        // Для PINK1PRKN114
        PINK1PRKN114 ecrf14 = this.pink1PRKN1Repository14.findBySurveyTwoId(surveyTwoId);
        if (ecrf14 == null) {
            ecrf14 = new PINK1PRKN114();
            ecrf14.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository14.save(ecrf14);
        }
        statusColors[13] = ecrf14.getStatusColor();

        // Для PINK1PRKN115
        PINK1PRKN115 ecrf15 = this.pink1PRKN1Repository15.findBySurveyTwoId(surveyTwoId);
        if (ecrf15 == null) {
            ecrf15 = new PINK1PRKN115();
            ecrf15.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository15.save(ecrf15);
        }
        statusColors[14] = ecrf15.getStatusColor();

        // Для PINK1PRKN116
        PINK1PRKN116 ecrf16 = this.pink1PRKN1Repository16.findBySurveyTwoId(surveyTwoId);
        if (ecrf16 == null) {
            ecrf16 = new PINK1PRKN116();
            ecrf16.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository16.save(ecrf16);
        }
        statusColors[15] = ecrf16.getStatusColor();

        // Для PINK1PRKN117
        PINK1PRKN117 ecrf17 = this.pink1PRKN1Repository17.findBySurveyTwoId(surveyTwoId);
        if (ecrf17 == null) {
            ecrf17 = new PINK1PRKN117();
            ecrf17.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository17.save(ecrf17);
        }
        statusColors[16] = ecrf17.getStatusColor();

        // Для PINK1PRKN118
        PINK1PRKN118 ecrf18 = this.pink1PRKN1Repository18.findBySurveyTwoId(surveyTwoId);
        if (ecrf18 == null) {
            ecrf18 = new PINK1PRKN118();
            ecrf18.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository18.save(ecrf18);
        }
        statusColors[17] = ecrf18.getStatusColor();

        // Для PINK1PRKN119
        PINK1PRKN119 ecrf19 = this.pink1PRKN1Repository19.findBySurveyTwoId(surveyTwoId);
        if (ecrf19 == null) {
            ecrf19 = new PINK1PRKN119();
            ecrf19.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository19.save(ecrf19);
        }
        statusColors[18] = ecrf19.getStatusColor();

        // Для PINK1PRKN120
        PINK1PRKN120 ecrf20 = this.pink1PRKN1Repository20.findBySurveyTwoId(surveyTwoId);
        if (ecrf20 == null) {
            ecrf20 = new PINK1PRKN120();
            ecrf20.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository20.save(ecrf20);
        }
        statusColors[19] = ecrf20.getStatusColor();

        // Для PINK1PRKN121
        PINK1PRKN121 ecrf21 = this.pink1PRKN1Repository21.findBySurveyTwoId(surveyTwoId);
        if (ecrf21 == null) {
            ecrf21 = new PINK1PRKN121();
            ecrf21.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository21.save(ecrf21);
        }
        statusColors[20] = ecrf21.getStatusColor();

        // Для PINK1PRKN122
        PINK1PRKN122 ecrf22 = this.pink1PRKN1Repository22.findBySurveyTwoId(surveyTwoId);
        if (ecrf22 == null) {
            ecrf22 = new PINK1PRKN122();
            ecrf22.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository22.save(ecrf22);
        }
        statusColors[21] = ecrf22.getStatusColor();

        // Для PINK1PRKN123
        PINK1PRKN123 ecrf23 = this.pink1PRKN1Repository23.findBySurveyTwoId(surveyTwoId);
        if (ecrf23 == null) {
            ecrf23 = new PINK1PRKN123();
            ecrf23.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository23.save(ecrf23);
        }
        statusColors[22] = ecrf23.getStatusColor();

        // Для PINK1PRKN124
        PINK1PRKN124 ecrf24 = this.pink1PRKN1Repository24.findBySurveyTwoId(surveyTwoId);
        if (ecrf24 == null) {
            ecrf24 = new PINK1PRKN124();
            ecrf24.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository24.save(ecrf24);
        }
        statusColors[23] = ecrf24.getStatusColor();

        // Для PINK1PRKN125
        PINK1PRKN125 ecrf25 = this.pink1PRKN1Repository25.findBySurveyTwoId(surveyTwoId);
        if (ecrf25 == null) {
            ecrf25 = new PINK1PRKN125();
            ecrf25.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository25.save(ecrf25);
        }
        statusColors[24] = ecrf25.getStatusColor();

        // Для PINK1PRKN126
        PINK1PRKN126 ecrf26 = this.pink1PRKN1Repository26.findBySurveyTwoId(surveyTwoId);
        if (ecrf26 == null) {
            ecrf26 = new PINK1PRKN126();
            ecrf26.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository26.save(ecrf26);
        }
        statusColors[25] = ecrf26.getStatusColor();

        // Для PINK1PRKN127
        PINK1PRKN127 ecrf27 = this.pink1PRKN1Repository27.findBySurveyTwoId(surveyTwoId);
        if (ecrf27 == null) {
            ecrf27 = new PINK1PRKN127();
            ecrf27.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository27.save(ecrf27);
        }
        statusColors[26] = ecrf27.getStatusColor();

        // Для PINK1PRKN128
        PINK1PRKN128 ecrf28 = this.pink1PRKN1Repository28.findBySurveyTwoId(surveyTwoId);
        if (ecrf28 == null) {
            ecrf28 = new PINK1PRKN128();
            ecrf28.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository28.save(ecrf28);
        }
        statusColors[27] = ecrf28.getStatusColor();

        // Для PINK1PRKN129
        PINK1PRKN129 ecrf29 = this.pink1PRKN1Repository29.findBySurveyTwoId(surveyTwoId);
        if (ecrf29 == null) {
            ecrf29 = new PINK1PRKN129();
            ecrf29.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository29.save(ecrf29);
        }
        statusColors[28] = ecrf29.getStatusColor();

        // Для PINK1PRKN130
        PINK1PRKN130 ecrf30 = this.pink1PRKN1Repository30.findBySurveyTwoId(surveyTwoId);
        if (ecrf30 == null) {
            ecrf30 = new PINK1PRKN130();
            ecrf30.setSurveyTwoId(surveyTwoId);
            this.pink1PRKN1Repository30.save(ecrf30);
        }
        statusColors[29] = ecrf30.getStatusColor();

        // сконвертировать цвета в соответствии с цветами, предложенными заказчиком
        for (int i = 0; i < statusColors.length; i++) {
            if (statusColors[i] != null) {
                switch (statusColors[i]) {
                    case "green":
                        statusColors[i] = "#4d6b5b"; // зелёный
                        break;
                    case "red":
                        statusColors[i] = "#b74444"; // красный
                        break;
                    case "blue":
                        statusColors[i] = "#23527c"; // синий
                        break;
                    case "yellow":
                        statusColors[i] = "orange"; // оставляем для "Missing items"
                        break;
                    default:
                        statusColors[i] = "orange"; // для остальных значений
                        break;
                }
            }
        }

        return statusColors;
    }

}