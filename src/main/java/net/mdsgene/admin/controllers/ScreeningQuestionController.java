//package net.mdsgene.admin.controllers;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import net.mdsgene.admin.admintool.dal.IScreeningQuestionsDAO;
//import net.mdsgene.admin.admintool.entities.ScreeningQuestion;
//
//@Controller
//public class ScreeningQuestionController extends BaseController{
//	@Autowired IScreeningQuestionsDAO screeningQuestionsDAO;
//
//	@GetMapping("/sq/{surveyTwoId}")
//	public String sq(@PathVariable("surveyTwoId") String surveyTwoId, ModelMap map) {
//		if (!StringUtils.isEmpty(surveyTwoId)) {
//			ScreeningQuestion данные_для_заполнения = screeningQuestionsDAO.findBySurveyTwoId(surveyTwoId);//gp2SurveyDAO.findAll().stream().filter(_данные -> surveyTwoId.equals(_данные.getSurveyTwoId())).findFirst().orElse(null);
//			map.addAttribute("gsfs", данные_для_заполнения);
//		}
//		return "sq";
//	}
//
//	@PostMapping("/sq/{surveyTwoId}")
//	public String sq(@PathVariable("surveyTwoId") String surveyTwoId, ScreeningQuestion sq, ModelMap map) {
//		if (!StringUtils.isEmpty(surveyTwoId)) {
//			ScreeningQuestion данные_для_заполнения = screeningQuestionsDAO.findBySurveyTwoId(surveyTwoId);//screeningQuestionsDAO.findAll().stream().filter(_данные -> surveyTwoId.equals(_данные.getSurveyTwoId())).findFirst().orElse(null);
//			данные_для_заполнения.setAgreeToIdentifyModifiers(sq.getAgreeToIdentifyModifiers());
//			данные_для_заполнения.setAgreeToResequenceTheMutation(sq.getAgreeToResequenceTheMutation());
//			данные_для_заполнения.setAgreeToRunChip(sq.getAgreeToRunChip());
//			данные_для_заполнения.setCasesToShare(sq.getCasesToShare());
//			данные_для_заполнения.setNameOfInvestigator(sq.getNameOfInvestigator());
//			данные_для_заполнения.setNeedNewIrb(sq.getNeedNewIrb());
//			данные_для_заполнения.setShareDna(sq.getShareDna());
//			данные_для_заполнения.setSpecify(sq.getSpecify());
//			данные_для_заполнения.setSurveyTwoId(sq.getSurveyTwoId());
//			данные_для_заполнения.setWhenToShare(sq.getWhenToShare());
//			map.addAttribute("gsfs", данные_для_заполнения);
//			screeningQuestionsDAO.save(данные_для_заполнения);
//		}
//		map.addAttribute("collected", "Your data has been saved.");
//		return "sq";
//	}
//
//}