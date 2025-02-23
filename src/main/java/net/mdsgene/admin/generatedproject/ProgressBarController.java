package net.mdsgene.admin.generatedproject;

import net.mdsgene.admin.ui.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProgressBarController {
    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    PINK1PRKN1Repository1 pink1prkn1Repository1;

    @Autowired
    PINK1PRKN1Repository2 pink1prkn1Repository2;

    @Autowired
    PINK1PRKN1Repository3 pink1prkn1Repository3;

    @Autowired
    PINK1PRKN1Repository4 pink1prkn1Repository4;

    @Autowired
    PINK1PRKN1Repository5 pink1prkn1Repository5;

    @Autowired
    PINK1PRKN1Repository6 pink1prkn1Repository6;

    @Autowired
    PINK1PRKN1Repository7 pink1prkn1Repository7;

    @Autowired
    PINK1PRKN1Repository8 pink1prkn1Repository8;

    @Autowired
    PINK1PRKN1Repository9 pink1prkn1Repository9;

    @Autowired
    PINK1PRKN1Repository10 pink1prkn1Repository10;

    @Autowired
    PINK1PRKN1Repository11 pink1prkn1Repository11;

    @Autowired
    PINK1PRKN1Repository12 pink1prkn1Repository12;

    @Autowired
    PINK1PRKN1Repository13 pink1prkn1Repository13;

    @Autowired
    PINK1PRKN1Repository14 pink1prkn1Repository14;

    @Autowired
    PINK1PRKN1Repository15 pink1prkn1Repository15;

    @Autowired
    PINK1PRKN1Repository16 pink1prkn1Repository16;

    @Autowired
    PINK1PRKN1Repository17 pink1prkn1Repository17;

    @Autowired
    PINK1PRKN1Repository18 pink1prkn1Repository18;

    @Autowired
    PINK1PRKN1Repository19 pink1prkn1Repository19;

    @Autowired
    PINK1PRKN1Repository20 pink1prkn1Repository20;

    @Autowired
    PINK1PRKN1Repository21 pink1prkn1Repository21;

    @Autowired
    PINK1PRKN1Repository22 pink1prkn1Repository22;

    @Autowired
    PINK1PRKN1Repository23 pink1prkn1Repository23;

    @Autowired
    PINK1PRKN1Repository24 pink1prkn1Repository24;

    @Autowired
    PINK1PRKN1Repository25 pink1prkn1Repository25;

    @Autowired
    PINK1PRKN1Repository26 pink1prkn1Repository26;

    @Autowired
    PINK1PRKN1Repository27 pink1prkn1Repository27;

    @Autowired
    PINK1PRKN1Repository28 pink1prkn1Repository28;

    @Autowired
    PINK1PRKN1Repository29 pink1prkn1Repository29;

    @Autowired
    PINK1PRKN1Repository30 pink1prkn1Repository30;


    // create endpoints for progress Informed Consent
    @GetMapping("/progress/informed-consent/{survey-id}")
    public String getInformedConsentProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN11 bySurveyTwoId = pink1prkn1Repository1.findBySurveyTwoId(s);
        //calculate progress value based on the annotations
        if(bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            //IC_EX	complete/not complete	complete if "yes" is selected
            if (bySurveyTwoId.getIc_ex() != null && bySurveyTwoId.getIc_ex().equals("1")) {
                return "completed";
            } else if (bySurveyTwoId.getIc_ex() != null && bySurveyTwoId.getIc_ex().equals("2")) {
                return "not completed";
            }
        } else {
            return "";
        }
        return "";
    }

    //create endpoints for progress Inclusion/ Exclusion Criteria
    @GetMapping("/progress/inclusion-exclusion/{survey-id}")
    public Integer getInclusionExclusionProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN12 bySurveyTwoId = pink1prkn1Repository2.findBySurveyTwoId(s);
        //calculate progress value based on the annotations
        if(bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (getInclusionExclusionStatus(surveyId).equals("not completed")) {
                return 0;
            }
            if(bySurveyTwoId.getIn_cat() != null && bySurveyTwoId.getIn_cat().equals("-")) {
                return 0;
            }
            //check if display only if
            //"individual with PD and at least one pathogenic variant in PRKN"
            //is checked in item
            //"individual with PD and at least one pathogenic variant in PINK1"
            return inclusionExclutionPercent(bySurveyTwoId);
        }
        return 0;
    }

    private static int inclusionExclutionPercent(PINK1PRKN12 bySurveyTwoId) {
        if (bySurveyTwoId.getIn_cat() != null &&
                (bySurveyTwoId.getIn_cat().equals("individual with PD and at least one pathogenic variant in PRKN") ||
                        bySurveyTwoId.getIn_cat().equals("individual with PD and at least one pathogenic variant in PINK1"))) {
            //check if all the required fields are filled
//                in_mitopd_age
//                in_mitopd_dx
//                in_mitopd_pathvar
//                in_mitopd_ic
//                ex_mitopd_symptomatic
//                ex_mitopd_ex
            // calculate progress value based on the logic all fields are 100% complete and calculate overall progress otherwise
            int progress = 0;
            //bySurveyTwoId.getIn_mitopd_age()
            if (bySurveyTwoId.getIn_prknpd_age() != null) {
                progress += 20;
            }
            //bySurveyTwoId.getIn_mitopd_dx()
            if (bySurveyTwoId.getIn_prknpd_dx() != null) {
                progress += 20;
            }
            //bySurveyTwoId.getIn_mitopd_pathvar()
            if (bySurveyTwoId.getIn_prknpd_pathvar() != null) {
                progress += 20;
            }
            //bySurveyTwoId.getIn_mitopd_ic()
            if (bySurveyTwoId.getIn_prknpd_ic() != null) {
                progress += 20;
            }
            //bySurveyTwoId.getEx_mitopd_symptomatic()
            if (bySurveyTwoId.getEx_mitopd_symptomatic() != null) {
                progress += 10;
            }
            //bySurveyTwoId.getEx_mitopd_ex()
            if (bySurveyTwoId.getEx_mitopd_ex() != null) {
                progress += 10;
            }
            return progress;
        } else //display only if "individual with iPD" is checked in item "in_cat"
            if (bySurveyTwoId.getIn_cat() != null && bySurveyTwoId.getIn_cat().equals("individual with iPD")) {
                //check if all the required fields are filled
                //in_ipd_age
                //in_ipd_dx
                //in_ipd_ic
                //in_ipd_match

                //ex_ipd_symptomatic
                //ex_ipd_monogenic
                //ex_ipd_ex
                // calculate progress value based on the logic all fields are 100% complete and calculate overall progress otherwise
                int progress = 0;
                if (bySurveyTwoId.getIn_ipd_age() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getIn_ipd_dx() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getIn_ipd_ic() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getIn_ipd_match() != null && !bySurveyTwoId.getIn_ipd_match().trim().isEmpty()) {
                    progress += 20;
                }
                if (bySurveyTwoId.getEx_ipd_symptomatic() != null) {
                    progress += 5;
                }
                if (bySurveyTwoId.getEx_ipd_monogenic() != null) {
                    progress += 5;
                }
                if (bySurveyTwoId.getEx_ipd_ex() != null) {
                    progress += 10;
                }
                return progress;
            } else //display only if "unaffected individual with at least one pathogenic variant in PRKN" is checked in item "in_cat";display only if "unaffected individual with at least one pathogenic variant in PINK1" is checked in item "in_cat"

            if (bySurveyTwoId.getIn_cat() != null &&
                    (bySurveyTwoId.getIn_cat().equals("unaffected individual with at least one pathogenic variant in PRKN") ||
                            bySurveyTwoId.getIn_cat().equals("unaffected individual with at least one pathogenic variant in PINK1"))) {
                //check if all the required fields are filled
                //in_unaff_age
                //in_unaff_pathvar
                //in_unaff_ic
                //ex_unaff_neuro
                //ex_unaff_mri_neuro
                //ex_unaff_ex
                // calculate progress value based on the logic all fields are 100% complete and calculate overall progress otherwise
                int progress = 0;
                if (bySurveyTwoId.getIn_prknunaff_age() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getIn_prknunaff_pathvar() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getIn_prknunaff_ic() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getEx_unaff_neuro() != null) {
                    progress += 20;
                }
                if (bySurveyTwoId.getEx_unaff_mri_neuro() != null) {
                    progress += 10;
                }
                if (bySurveyTwoId.getEx_unaff_ex() != null) {
                    progress += 10;
                }
                return progress;
            } else //display only if "healthy control" is checked in item "in_cat"
                if (bySurveyTwoId.getIn_cat() != null && bySurveyTwoId.getIn_cat().equals("healthy control")) {
                    //check if all the required fields are filled
                    //in_hc_age
                    //in_hc_ic
                    //in_hc_match
                    //ex_hc_neuro
                    //ex_hc_monogenic
                    //ex_hc_mri_neuro
                    //ex_hc_ex
                    // calculate progress value based on the logic all fields are 100% complete and calculate overall progress otherwise
                    int progress = 0;
                    if (bySurveyTwoId.getIn_hc_age() != null) {
                        progress += 20;
                    }
                    if (bySurveyTwoId.getIn_hc_ic() != null) {
                        progress += 20;
                    }
                    if (bySurveyTwoId.getIn_hc_match() != null && !bySurveyTwoId.getIn_hc_match().trim().isEmpty()) {
                        progress += 20;
                    }
                    if (bySurveyTwoId.getEx_hc_neuro() != null) {
                        progress += 10;
                    }
                    if (bySurveyTwoId.getEx_hc_monogenic() != null) {
                        progress += 10;
                    }
                    if (bySurveyTwoId.getEx_hc_mri_neuro() != null) {
                        progress += 10;
                    }
                    if (bySurveyTwoId.getEx_hc_ex() != null) {
                        progress += 10;
                    }
                    return progress;
                } else {
                    return 0;
        }
    }

    //create endpoints for progress inclusion-exclusion-status
    @GetMapping("/progress/inclusion-exclusion-status/{survey-id}")
    public String getInclusionExclusionStatus(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN12 bySurveyTwoId = pink1prkn1Repository2.findBySurveyTwoId(s);
        //calculate progress value based on the annotations
        if(bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if(bySurveyTwoId.getIn_cat() != null && !bySurveyTwoId.getIn_cat().equals("-")) {
                return (inclusionExclutionPercent(bySurveyTwoId) < 100 ? "not completed" : "");
            }
        }
        return "";
    }

    //create endpoints for progress Medical History / Demographics
    @GetMapping("/progress/medical-history/{survey-id}")
    public Integer getMedicalHistoryProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN18 bySurveyTwoId = pink1prkn1Repository8.findBySurveyTwoId(s);
        PINK1PRKN17 bySurveyTwoId10 = pink1prkn1Repository7.findBySurveyTwoId(s);

        int totalFields = 25; // Общее количество полей, которые нужно проверить
        int completedFields = 0; // Количество заполненных полей

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getCond_cat_1() != null && !bySurveyTwoId.getCond_cat_1().trim().isEmpty() && !bySurveyTwoId.getCond_cat_1().trim().equals("-")) {
                if (bySurveyTwoId.getCond_cat_1().equals("Allergy/Immunologic – Please note drug allergies") && bySurveyTwoId.getCond_cat_1_dr_all() != null && !bySurveyTwoId.getCond_cat_1_dr_all().trim().isEmpty()) {
                    completedFields++;
                } else if (bySurveyTwoId.getCond_cat_1().equals("Other") && bySurveyTwoId.getCond_cat_1_oth() != null && !bySurveyTwoId.getCond_cat_1_oth().trim().isEmpty()) {
                    completedFields++;
                } else {
                    completedFields++;
                }

                if (bySurveyTwoId.getCond_dat_1_year() != null && !bySurveyTwoId.getCond_dat_1_year().trim().isEmpty()) {
                    completedFields++;
                }
                if (bySurveyTwoId.getCond_dat_1_month() != null && !bySurveyTwoId.getCond_dat_1_month().trim().isEmpty()) {
                    completedFields++;
                }
                if (bySurveyTwoId.getCond_dat_1_day() != null && !bySurveyTwoId.getCond_dat_1_day().trim().isEmpty()) {
                    completedFields++;
                }
                if (bySurveyTwoId.getCond_dx_1() != null && !bySurveyTwoId.getCond_dx_1().trim().isEmpty()) {
                    completedFields++;
                }
                if (bySurveyTwoId.getCond_res_1() != null && !bySurveyTwoId.getCond_res_1().trim().isEmpty()) {
                    completedFields++;
                }
                if (bySurveyTwoId.getCond_res_1() != null && bySurveyTwoId.getCond_res_1().equals("1")) {
                    if (bySurveyTwoId.getCond_res_dat_1_year() != null && !bySurveyTwoId.getCond_res_dat_1_year().trim().isEmpty()) {
                        completedFields++;
                    }
                    if (bySurveyTwoId.getCond_res_dat_1_month() != null && !bySurveyTwoId.getCond_res_dat_1_month().trim().isEmpty()) {
                        completedFields++;
                    }
                    if (bySurveyTwoId.getCond_res_dat_1_day() != null && !bySurveyTwoId.getCond_res_dat_1_day().trim().isEmpty()) {
                        completedFields++;
                    }
                } else {
                    completedFields += 3; // Если cond_res_1 не равен 1, считаем три поля автоматически заполненными
                }
            }
        }

        if (bySurveyTwoId10 != null && !bySurveyTwoId10.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId10.getGender() != null && !bySurveyTwoId10.getGender().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getYob() != null && !bySurveyTwoId10.getYob().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getHand() != null && !bySurveyTwoId10.getHand().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_hislat() != null && !bySurveyTwoId10.getEth_hislat().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_ashj() != null && !bySurveyTwoId10.getEth_ashj().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_basq() != null && !bySurveyTwoId10.getEth_basq().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_afber() != null && !bySurveyTwoId10.getEth_afber().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_amind() != null && !bySurveyTwoId10.getEth_amind().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_asia() != null && !bySurveyTwoId10.getEth_asia().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_black() != null && !bySurveyTwoId10.getEth_black().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_pacis() != null && !bySurveyTwoId10.getEth_pacis().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_white() != null && !bySurveyTwoId10.getEth_white().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId10.getEth_other() != null && !bySurveyTwoId10.getEth_other().trim().isEmpty()) {
                completedFields++;
                if (bySurveyTwoId10.getEth_other() != null && bySurveyTwoId10.getEth_other().equals("1")) {
                    if (bySurveyTwoId10.getEth_other_spec() != null && !bySurveyTwoId10.getEth_other_spec().trim().isEmpty()) {
                        completedFields++;
                    }
                } else {
                    completedFields++;
                }
            }
        }

        // Вычисляем процент прогресса
        int progress = (int) ((completedFields / (double) totalFields) * 100);
        return progress;
    }

    //create endpoints for progress Vital Signs
    @GetMapping("/progress/vital-signs/{survey-id}")
    public Integer getVitalSignsProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN114 bySurveyTwoId = pink1prkn1Repository14.findBySurveyTwoId(s);
        int totalFields = 10; // Общее количество полей, которые нужно проверить
        int completedFields = 0; // Количество заполненных полей
        //vital_weight
        //vital_height
        //vital_temp
        //vital_arm
        //vital_bp_sup_lower
        //vital_bp_sup_upper
        //vital_hr_sup
        //vital_bp_sta_1
        //vital_bp_sta_lower
        //vital_bp_sta_upper
        //vital_hr_sta
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getVital_weight() != null && !bySurveyTwoId.getVital_weight().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_height() != null && !bySurveyTwoId.getVital_height().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_temp() != null && !bySurveyTwoId.getVital_temp().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_arm() != null && !bySurveyTwoId.getVital_arm().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_bp_sup_lower() != null && !bySurveyTwoId.getVital_bp_sup_lower().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_bp_sup_upper() != null && !bySurveyTwoId.getVital_bp_sup_upper().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_hr_sup() != null && !bySurveyTwoId.getVital_hr_sup().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_bp_sta_lower() != null && !bySurveyTwoId.getVital_bp_sta_lower().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_bp_sta_upper() != null && !bySurveyTwoId.getVital_bp_sta_upper().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getVital_hr_sta() != null && !bySurveyTwoId.getVital_hr_sta().trim().isEmpty()) {
                completedFields++;
            }
        }


        // Вычисляем процент прогресса
        int progress = (int) ((completedFields / (double) totalFields) * 100);
        return progress;
    }

    //create endpoints for progress Neurological Exam / Diagnosis
    @GetMapping("/progress/neurological-exam/{survey-id}")
    public Integer getNeurologicalExamProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN115 bySurveyTwoId = pink1prkn1Repository15.findBySurveyTwoId(s);
        int totalFields = 14; // Общее количество полей, которые нужно проверить
        int completedFields = 0; // Количество заполненных полей
//        n_exam_mental
//        n_exam_mental_abn display only if "abnormal" is checked in item "n_exam_mental"
//        n_exam_cranial
//        n_exam_cranial_abn display only if "abnormal" is checked in item "n_exam_cranial"
//        n_exam_motor
//        n_exam_motor_abn display only if "abnormal" is checked in item "n_exam_motor"
//        n_exam_sens
//        n_exam_sens_abn display only if "abnormal" is checked in item "n_exam_sens"
//        n_exam_coor
//        n_exam_coor_abn display only if "abnormal" is checked in item "n_exam_coor"
//        n_exam_reflex
//        n_exam_reflex_abn display only if "abnormal" is checked in item "n_exam_reflex"
//        n_exam_gait
//        n_exam_gait_abn display only if "abnormal" is checked in item "n_exam_gait"
//        normal=1; abnormal=2; not tested=3; unable to test=4
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getN_exam_mental() != null && bySurveyTwoId.getN_exam_mental().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_mental_abn() != null && !bySurveyTwoId.getN_exam_mental_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_mental() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_cranial() != null && bySurveyTwoId.getN_exam_cranial().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_cranial_abn() != null && !bySurveyTwoId.getN_exam_cranial_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_cranial() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_motor() != null && bySurveyTwoId.getN_exam_motor().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_motor_abn() != null && !bySurveyTwoId.getN_exam_motor_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_motor() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_sens() != null && bySurveyTwoId.getN_exam_sens().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_sens_abn() != null && !bySurveyTwoId.getN_exam_sens_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_sens() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_coor() != null && bySurveyTwoId.getN_exam_coor().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_coor_abn() != null && !bySurveyTwoId.getN_exam_coor_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_coor() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_reflex() != null && bySurveyTwoId.getN_exam_reflex().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_reflex_abn() != null && !bySurveyTwoId.getN_exam_reflex_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_reflex() != null) {
                completedFields += 2;
            }
            if (bySurveyTwoId.getN_exam_gait() != null && bySurveyTwoId.getN_exam_gait().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getN_exam_gait_abn() != null && !bySurveyTwoId.getN_exam_gait_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getN_exam_gait() != null) {
                completedFields += 2;
            }
        }

        // Вычисляем процент прогресса
        int progress
                = (int) ((completedFields / (double) totalFields) * 100);
        return progress;
    }

    //create endpoints for progress mds-updrs
    @GetMapping("/progress/mds-updrs/{survey-id}")
    public Integer getMdsUpdrsProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN116 bySurveyTwoId16 = pink1prkn1Repository16.findBySurveyTwoId(s);
        String fillingStatus16 = bySurveyTwoId16.getFillingStatus();
        PINK1PRKN117 bySurveyTwoId17 = pink1prkn1Repository17.findBySurveyTwoId(s);
        String fillingStatus17 = bySurveyTwoId17.getFillingStatus();
        PINK1PRKN118 bySurveyTwoId18 = pink1prkn1Repository18.findBySurveyTwoId(s);
        String fillingStatus18 = bySurveyTwoId18.getFillingStatus();
        PINK1PRKN119 bySurveyTwoId19 = pink1prkn1Repository19.findBySurveyTwoId(s);
        String fillingStatus19 = bySurveyTwoId19.getFillingStatus();
        //convert all filling statuses to integers if they are numbers otherwise return 0
        int fillingStatus16Int = 0;
        int fillingStatus17Int = 0;
        int fillingStatus18Int = 0;
        int fillingStatus19Int = 0;
        try {
            fillingStatus16Int = Integer.parseInt(fillingStatus16);
        } catch (NumberFormatException e) {
            fillingStatus16Int = 0;
        }
        try {
            fillingStatus17Int = Integer.parseInt(fillingStatus17);
        } catch (NumberFormatException e) {
            fillingStatus17Int = 0;
        }
        try {
            fillingStatus18Int = Integer.parseInt(fillingStatus18);
        } catch (NumberFormatException e) {
            fillingStatus18Int = 0;
        }
        try {
            fillingStatus19Int = Integer.parseInt(fillingStatus19);
        } catch (NumberFormatException e) {
            fillingStatus19Int = 0;
        }
        //calculate progress value based on the annotations
        // Вычисляем процент прогресса
        int progress = (int) (((fillingStatus16Int + fillingStatus17Int + fillingStatus18Int + fillingStatus19Int) / (double) 4));
        return progress;
    }

    //create endpoints for progress mo-ca
    @GetMapping("/progress/mo-ca/{survey-id}")
    public Integer getMoCaProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN121 bySurveyTwoId = pink1prkn1Repository21.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getMoca_ex() != null && bySurveyTwoId.getMoca_ex().equals("1")) {
            return 0;
        }

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            int fillingStatus = 0;
            try {
                fillingStatus = Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                fillingStatus = 0;
            }
            return fillingStatus;
        }
        return 0;
    }

    //create endpoints for UPSIT progress
    @GetMapping("/progress/upsit/{survey-id}")
    public Integer getUpsitProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN123 bySurveyTwoId = pink1prkn1Repository23.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getUpsit_ex() != null && !bySurveyTwoId.getUpsit_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getUpsit_ex() != null && !bySurveyTwoId.getUpsit_ex().equals("2")){
            return 0;
        }
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }


        //create endpoints for if moca_ex=no, please display "not completed" in progress report
    @GetMapping("/progress/mo-ca-ex/{survey-id}")
    public String getMoCaExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN121 bySurveyTwoId = pink1prkn1Repository21.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getMoca_ex() != null && bySurveyTwoId.getMoca_ex().equals("1")) {
            return "not completed";
        } else {
            return "";
        }
    }

    //create endpoint for cognitive categorization progress
    @GetMapping("/progress/cognitive-categorization/{survey-id}")
    public Integer getCognitiveCategorizationProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN122 bySurveyTwoId = pink1prkn1Repository22.findBySurveyTwoId(s);
        int totalFields = 5; // Общее количество полей, которые нужно проверить
        int completedFields = 0; // Количество заполненных полей    }
//        cogn_source
//                cogn_decline
//        cogn_functional
//                cogn_dx
//        cogn_conf
//                cogn_conf
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getCogn_source() != null && !bySurveyTwoId.getCogn_source().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getCogn_decline() != null && !bySurveyTwoId.getCogn_decline().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getCogn_functional() != null && !bySurveyTwoId.getCogn_functional().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getCogn_dx() != null && !bySurveyTwoId.getCogn_dx().trim().isEmpty()) {
                completedFields++;
            }
            if (bySurveyTwoId.getCogn_conf() != null && !bySurveyTwoId.getCogn_conf().trim().isEmpty()) {
                completedFields++;
            }
        }

        // Вычисляем процент прогресса
        int progress = (int) ((completedFields / (double) totalFields) * 100);
        return progress;
    }

    //create endpoint for UPSIT_ex progress
    @GetMapping("/progress/upsit-ex/{survey-id}")
    public String getUpsitExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN123 bySurveyTwoId = pink1prkn1Repository23.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getUpsit_ex() != null && !bySurveyTwoId.getUpsit_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getUpsit_ex() != null && !bySurveyTwoId.getUpsit_ex().equals("2")){
            return "not completed";
        }
        return "";
    }

    //create endpoint for rbdq progress
    @GetMapping("/progress/rbdq/{survey-id}")
    public Integer getRbdqProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN124 bySurveyTwoId = pink1prkn1Repository24.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getRbdq_ex() != null && bySurveyTwoId.getRbdq_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getRbdq_ex() != null && bySurveyTwoId.getRbdq_ex().equals("2")) {
            return 0;
        }

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }

    //create endpoint for rbdq-ex progress
    @GetMapping("/progress/rbdq-ex/{survey-id}")
    public String getRbdqExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN124 bySurveyTwoId = pink1prkn1Repository24.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getRbdq_ex() != null && bySurveyTwoId.getRbdq_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getRbdq_ex() != null && bySurveyTwoId.getRbdq_ex().equals("2")) {
            return "not completed";
        }
        return "";
    }

    //create endpoint for QUIP progress
    @GetMapping("/progress/quip/{survey-id}")
    public Integer getQuipProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN125 bySurveyTwoId = pink1prkn1Repository25.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getQuip_ex() != null && bySurveyTwoId.getQuip_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getQuip_ex() != null && bySurveyTwoId.getQuip_ex().equals("2")) {
            return 0;
        }
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }

    //create endpoint for QUIP-ex progress
    @GetMapping("/progress/quip-ex/{survey-id}")
    public String getQuipExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN125 bySurveyTwoId = pink1prkn1Repository25.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getQuip_ex() != null && bySurveyTwoId.getQuip_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getQuip_ex() != null && bySurveyTwoId.getQuip_ex().equals("2")) {
            return "not completed";
        }
        return "";
    }

    //create endpoint for ess
    @GetMapping("/progress/ess/{survey-id}")
    public Integer getEssProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN126 bySurveyTwoId = pink1prkn1Repository26.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getEss_ex() != null && bySurveyTwoId.getEss_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getEss_ex() != null && bySurveyTwoId.getEss_ex().equals("2")) {
            return 0;
        }

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }

    //create endpoint for ess-ex
    @GetMapping("/progress/ess-ex/{survey-id}")
    public String getEssExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN126 bySurveyTwoId = pink1prkn1Repository26.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getEss_ex() != null && bySurveyTwoId.getEss_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getEss_ex() != null && bySurveyTwoId.getEss_ex().equals("2")) {
            return "not completed";
        }
        return "";
    }

    //create endpoint for GDS progress
    @GetMapping("/progress/gds/{survey-id}")
    public Integer getGdsProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN127 bySurveyTwoId = pink1prkn1Repository27.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getGds_ex() != null && bySurveyTwoId.getGds_ex().equals("1")) {
            return 0;
        }

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }

    //create endpoint for GDS-ex progress
    @GetMapping("/progress/gds-ex/{survey-id}")
    public String getGdsExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN127 bySurveyTwoId = pink1prkn1Repository27.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getGds_ex() != null && bySurveyTwoId.getGds_ex().equals("1")) {
            return "not completed";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getGds_ex() != null && !bySurveyTwoId.getGds_ex().equals("0")) {
            return "";
        }
        return "";
    }

    //create endpoint for STAIS-S, STAIS-T progress
    @GetMapping("/progress/stais/{survey-id}")
    public Integer getStaisSProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN128 bySurveyTwoId = pink1prkn1Repository28.findBySurveyTwoId(s);
        int progress = 0;
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                progress = Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                progress = 0;
            }
        }
        PINK1PRKN129 bySurveyTwoId2 = pink1prkn1Repository29.findBySurveyTwoId(s);
        if(bySurveyTwoId2 != null && !bySurveyTwoId2.getSurveyTwoId().isEmpty()) {
            try {
                progress += Integer.parseInt(bySurveyTwoId2.getFillingStatus());
            } catch (NumberFormatException e) {
                progress += 0;
            }
        }

        if (bySurveyTwoId != null && bySurveyTwoId.getStais_ex() != null && bySurveyTwoId.getStais_ex().equals("1") &&
                bySurveyTwoId2 != null && bySurveyTwoId2.getStait_ex() != null && bySurveyTwoId2.getStait_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getStais_ex() != null && bySurveyTwoId.getStais_ex().equals("2") &&
                bySurveyTwoId2 != null && bySurveyTwoId2.getStait_ex() != null && bySurveyTwoId2.getStait_ex().equals("2")){
            return 0;
        }

        return progress/2;
    }

    //create endpoint for STAI-S-EX, STAI-S-T progress
    @GetMapping("/progress/stais-ex/{survey-id}")
    public String getStaisExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN128 bySurveyTwoId = pink1prkn1Repository28.findBySurveyTwoId(s);
        PINK1PRKN129 bySurveyTwoId2 = pink1prkn1Repository29.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getStais_ex() != null && bySurveyTwoId.getStais_ex().equals("1") &&
                bySurveyTwoId2 != null && bySurveyTwoId2.getStait_ex() != null && bySurveyTwoId2.getStait_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getStais_ex() != null && bySurveyTwoId.getStais_ex().equals("2") &&
                bySurveyTwoId2 != null && bySurveyTwoId2.getStait_ex() != null && bySurveyTwoId2.getStait_ex().equals("2")){
            return "not completed";
        }
        return "";
    }

    //create endpoint for SCOPA AUT progress
    @GetMapping("/progress/scopa-aut/{survey-id}")
    public Integer getScopaAutProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN130 bySurveyTwoId = pink1prkn1Repository30.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getScopaaut_ex() != null && bySurveyTwoId.getScopaaut_ex().equals("1")) {
        } else if (bySurveyTwoId != null && bySurveyTwoId.getScopaaut_ex() != null && bySurveyTwoId.getScopaaut_ex().equals("2")) {
            return 0;
        }

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                return Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }

    //create endpoint for scopa-aut-ex
    @GetMapping("/progress/scopa-aut-ex/{survey-id}")
    public String getScopaAutExProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN130 bySurveyTwoId = pink1prkn1Repository30.findBySurveyTwoId(s);
        if (bySurveyTwoId != null && bySurveyTwoId.getScopaaut_ex() != null && bySurveyTwoId.getScopaaut_ex().equals("1")) {
            return "";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getScopaaut_ex() != null && bySurveyTwoId.getScopaaut_ex().equals("2")) {
            return "not completed";
        }
        return "";
    }


    //create endpoints for progress physical-examination
    @GetMapping("/progress/physical-examination/{survey-id}")
    public Integer getPhysicalExaminationProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN113 bySurveyTwoId = pink1prkn1Repository13.findBySurveyTwoId(s);
        int totalFields = 20; // Общее количество полей, которые нужно проверить
        int completedFields = 0; // Количество заполненных полей

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            //exam_skin	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_skin_abn	display only if "abnormal" is checked in item "exam_skin"	n.a.
            //exam_head	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_head_abn	display only if "abnormal" is checked in item "exam_head"	n.a.
            //exam_eyes	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_eyes_abn	display only if "abnormal" is checked in item "exam_eyes"	n.a.
            //exam_ears	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_ears_abn	display only if "abnormal" is checked in item "exam_ears"	n.a.
            //exam_lungs	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_lungs_abn	display only if "abnormal" is checked in item "exam_lungs"	n.a.
            //exam_cardio	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_cardio_abn	display only if "abnormal" is checked in item "exam_cardio"	n.a.
            //exam_abd	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_abd_abn	display only if "abnormal" is checked in item "exam_abd"	n.a.
            //exam_musc	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_musc_abn	display only if "abnormal" is checked in item "exam_musc"	n.a.
            //exam_neuro	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_neuro_abn	display only if "abnormal" is checked in item "exam_neuro"	n.a.
            //exam_psych	n.a.	normal=1; abnormal=2; cannot assess=3
            //exam_psych_abn	display only if "abnormal" is checked in item "exam_psych"	n.a.
            if (bySurveyTwoId.getExam_skin() != null && bySurveyTwoId.getExam_skin().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_skin_abn() != null && !bySurveyTwoId.getExam_skin_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_skin() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_head() != null && bySurveyTwoId.getExam_head().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_head_abn() != null && !bySurveyTwoId.getExam_head_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_head() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_eyes() != null && bySurveyTwoId.getExam_eyes().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_eyes_abn() != null && !bySurveyTwoId.getExam_eyes_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if(bySurveyTwoId.getExam_eyes() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_ears() != null && bySurveyTwoId.getExam_ears().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_ears_abn() != null && !bySurveyTwoId.getExam_ears_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if(bySurveyTwoId.getExam_ears() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_lungs() != null && bySurveyTwoId.getExam_lungs().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_lungs_abn() != null && !bySurveyTwoId.getExam_lungs_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_lungs() != null){
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_cardio() != null && bySurveyTwoId.getExam_cardio().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_cardio_abn() != null && !bySurveyTwoId.getExam_cardio_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_cardio() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_abd() != null && bySurveyTwoId.getExam_abd().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_abd_abn() != null && !bySurveyTwoId.getExam_abd_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_abd() != null){
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_musc() != null && bySurveyTwoId.getExam_musc().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_musc_abn() != null && !bySurveyTwoId.getExam_musc_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if(bySurveyTwoId.getExam_musc() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_neuro() != null && bySurveyTwoId.getExam_neuro().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_neuro_abn() != null && !bySurveyTwoId.getExam_neuro_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_neuro() != null) {
                completedFields+=2;
            }
            if(bySurveyTwoId.getExam_psych() != null && bySurveyTwoId.getExam_psych().equals("2")) {
                completedFields++;
                if (bySurveyTwoId.getExam_psych_abn() != null && !bySurveyTwoId.getExam_psych_abn().trim().isEmpty()) {
                    completedFields++;
                }
            } else if (bySurveyTwoId.getExam_psych() != null) {
                completedFields+=2;
            }
        }

        // Вычисляем процент прогресса
        int progress
                = (int) ((completedFields / (double) totalFields) * 100);
        return progress;
    }

    //create endpoints for progress LEDD concomitant medical log
    @GetMapping("/progress/ledd-concomitant-medical-log/{survey-id}")
    public Integer getConcomitantTreatmentsProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN110 bySurveyTwoId = pink1prkn1Repository10.findBySurveyTwoId(s);

        int fillingStatus1Int = 0;
        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            try {
                fillingStatus1Int = Integer.parseInt(bySurveyTwoId.getFillingStatus());
            } catch (NumberFormatException e) {
                fillingStatus1Int = 0;
            }
        }

        PINK1PRKN111 bySurveyTwoId11 = pink1prkn1Repository11.findBySurveyTwoId(s);
        int fillingStatus2Int = 0;
        if (bySurveyTwoId11 != null && !bySurveyTwoId11.getSurveyTwoId().isEmpty()) {
            try {
                fillingStatus2Int = Integer.parseInt(bySurveyTwoId11.getFillingStatus());
            } catch (NumberFormatException e) {
                fillingStatus2Int = 0;
            }
        }

        // Вычисляем процент прогресса
        return  (int) (((fillingStatus1Int + fillingStatus2Int) / (double) 2));
    }

    //create endpoints for mr-brain
    @GetMapping("/progress/mri-brain/{survey-id}")
    public String getMriBrainProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN16 bySurveyTwoId = pink1prkn1Repository6.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getIm_mri() != null && !bySurveyTwoId.getIm_mri().equals("1")) {
                return "available";
            } if (bySurveyTwoId.getIm_mridev() != null && !bySurveyTwoId.getIm_mridev().trim().isEmpty()) {
                return "not available";
            }
        }

        return "";
    }

    //create endpoint for datscan
    @GetMapping("/progress/dat-scan/{survey-id}")
    public String getDatScanProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN16 bySurveyTwoId = pink1prkn1Repository6.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getIm_dat() != null && !bySurveyTwoId.getIm_dat().equals("1")) {
                return "available";
            } if (bySurveyTwoId.getIm_dat() != null && !bySurveyTwoId.getIm_dat().trim().isEmpty()) {
                return "not available";
            }
        }

        return "";
    }

    //create endpoint for urine
    @GetMapping("/progress/urine/{survey-id}")
    public String getUrineProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);
        //quantity/ not collected
        //"10ml" if "collected", "not collected" if "not collected", display entry in "collected quantity" if "smaller amount collected" is selected in "EDTA Blood 10ml"; if "smaller amount collected" is selected, but not entry in "collected quantity", display "quantity is missing"
        if (bySurveyTwoId != null && bySurveyTwoId.getBiom_urine() != null && bySurveyTwoId.getBiom_urine().equals("1")) {
            return "collected 10ml";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getBiom_urine() != null && bySurveyTwoId.getBiom_urine().equals("2")) {
            return "not collected";
        } else if (bySurveyTwoId != null && bySurveyTwoId.getBiom_urine() != null && bySurveyTwoId.getBiom_urine().equals("3")) {
            if(bySurveyTwoId.getBiom_urine_q() != null && !bySurveyTwoId.getBiom_urine_q().trim().isEmpty()) {
                return "collected " + bySurveyTwoId.getBiom_urine_q();
            } else if (bySurveyTwoId.getBiom_urine_q() != null && bySurveyTwoId.getBiom_urine_q().equals("3")) {
                return "quantity is missing";
            }
            return "smaller amount collected";
        }
        return "not collected";
    }




    //create endpoint EDTA blood 10ml
    @GetMapping("/progress/edta-blood/{survey-id}")
    public String getEdtaBloodProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
//            biom_edta
//            biom_edta_q display only if "collected" is checked in item "biom_edta"
            //quantity/ not collected
            if (bySurveyTwoId.getBiom_edta() != null && bySurveyTwoId.getBiom_edta().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_edta() != null && bySurveyTwoId.getBiom_edta().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_edta() != null && bySurveyTwoId.getBiom_edta().equals("3")) {
                if (bySurveyTwoId.getBiom_edta_q() != null && !bySurveyTwoId.getBiom_edta_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_edta_q();
                } else return "quantity is missing";
            }
        }

        return "not collected";
    }



    //create endpoint EDTA blood (Plasma) 16ml
    @GetMapping("/progress/edta-blood-plasma/{survey-id}")
    public String getEdtaBloodPlasmaProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_plasma() != null && bySurveyTwoId.getBiom_plasma().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_plasma() != null && bySurveyTwoId.getBiom_plasma().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_plasma() != null && bySurveyTwoId.getBiom_plasma().equals("3")) {
                if (bySurveyTwoId.getBiom_plasma_q() != null && !bySurveyTwoId.getBiom_plasma_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_plasma_q();
                } else return "quantity is missing";
            }
        }

        return "not collected";
    }

    //create end point Serum blood 16ml
    @GetMapping("/progress/serum-blood-plasma/{survey-id}")
    public String getSerumBloodPlasmaProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_serum() != null && bySurveyTwoId.getBiom_serum().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_serum() != null && bySurveyTwoId.getBiom_serum().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_serum() != null && bySurveyTwoId.getBiom_serum().equals("3")) {
                if (bySurveyTwoId.getBiom_serum_q() != null && !bySurveyTwoId.getBiom_serum_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_serum_q();
                } else return "quantity is missing";
            }
        }

        return "not collected";
    }

    //create endpoint PAXgene-blood-plasma
    @GetMapping("/progress/paxgene-blood-plasma/{survey-id}")
    public String getPaxgeneBloodPlasmaProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_pax() != null && bySurveyTwoId.getBiom_pax().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_pax() != null && bySurveyTwoId.getBiom_pax().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_pax() != null && bySurveyTwoId.getBiom_pax().equals("3")) {
                if (bySurveyTwoId.getBiom_pax_q() != null && !bySurveyTwoId.getBiom_pax_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_pax_q();
                } else return "quantity is missing";
            }
        }

        return "not collected";
    }

    //create endpoint for PBMCs
    @GetMapping("/progress/pbmcs/{survey-id}")
    public String getPbmcsProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN14 bySurveyTwoId = pink1prkn1Repository4.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_pbmcs() != null && bySurveyTwoId.getBiom_pbmcs().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_pbmcs() != null && bySurveyTwoId.getBiom_pbmcs().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_pbmcs() != null && bySurveyTwoId.getBiom_pbmcs().equals("3")) {
                if (bySurveyTwoId.getBiom_pbmcs_q() != null && !bySurveyTwoId.getBiom_pbmcs_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_pbmcs_q();
                } else return "quantity is missing";
            }
        }

        return "not collected";
    }

    //create endpoint for Routine safety lab before LP
    @GetMapping("/progress/routine-safety-lab-before-lp/{survey-id}")
    public String getRoutineSafetyLabBeforeLpProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN15 bySurveyTwoId = pink1prkn1Repository5.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_csf_lab_rs() != null && bySurveyTwoId.getBiom_csf_lab_rs().equals("1")) {
                return "collected";
            } else if (bySurveyTwoId.getBiom_csf_lab_rs() != null && bySurveyTwoId.getBiom_csf_lab_rs().equals("1")) {
                return "not collected";
            }
        }
        return "not collected";
    }

    //create endpoint for Lumbar Puncture
    @GetMapping("/progress/lumbar-puncture/{survey-id}")
    public String getLumbarPunctureProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN15 bySurveyTwoId = pink1prkn1Repository5.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_csf() != null && bySurveyTwoId.getBiom_csf().equals("1")) {
                return "collected 5ml";
            } else if (bySurveyTwoId.getBiom_csf() != null && bySurveyTwoId.getBiom_csf().equals("2")) {
                return "not collected";
            } else if (bySurveyTwoId.getBiom_csf() != null && bySurveyTwoId.getBiom_csf().equals("3")) {
                if (bySurveyTwoId.getBiom_csf_q() != null && !bySurveyTwoId.getBiom_csf_q().trim().isEmpty()) {
                    return "collected " + bySurveyTwoId.getBiom_csf_q();
                } else return "quantity is missing";
            }
        }
        return "not collected";
    }

    //create endpoint for Adverse Experience
    @GetMapping("/progress/adverse-experience/{survey-id}")
    public String getAdverseExperienceProgress(@PathVariable("survey-id") String surveyId) {
        String s = retrieveSurveyId(surveyId);
        PINK1PRKN15 bySurveyTwoId = pink1prkn1Repository5.findBySurveyTwoId(s);

        if (bySurveyTwoId != null && !bySurveyTwoId.getSurveyTwoId().isEmpty()) {
            if (bySurveyTwoId.getBiom_csf_ae() != null && bySurveyTwoId.getBiom_csf_ae().equals("1")) {
                return "";
            } else if (bySurveyTwoId.getBiom_csf_ae() != null && bySurveyTwoId.getBiom_csf_ae().equals("3")) {
                return "not completed";
            }
        }
        return "";
    }

    private String retrieveSurveyId(String surveyId) {
        return surveyRepository.getOne(Long.valueOf(surveyId)).getSurveyId();
    }

}
