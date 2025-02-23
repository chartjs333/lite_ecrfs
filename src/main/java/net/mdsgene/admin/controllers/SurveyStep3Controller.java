//package net.mdsgene.admin.controllers;
//
//import java.lang.reflect.InvocationTargetException;
//
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import net.mdsgene.admin.admintool.dal.IScreeningQuestionsDAO;
//import net.mdsgene.admin.admintool.dal.ISurveyStep3DAO;
//import net.mdsgene.admin.admintool.entities.ScreeningQuestion;
//import net.mdsgene.admin.admintool.entities.SurveyStep3;
//
//@Controller
//public class SurveyStep3Controller extends BaseController{
//	@Autowired ISurveyStep3DAO surveyStep3DAO;
//
//	@GetMapping("/step3/{surveyTwoId}")
//	public String step3(@PathVariable("surveyTwoId") String surveyTwoId, ModelMap map) {
//		if (!StringUtils.isEmpty(surveyTwoId)) {
//			SurveyStep3 данные_для_заполнения = surveyStep3DAO.findBySurveyTwoId(surveyTwoId);//gp2SurveyDAO.findAll().stream().filter(_данные -> surveyTwoId.equals(_данные.getSurveyTwoId())).findFirst().orElse(null);
//			map.addAttribute("gsfs", данные_для_заполнения);
//		}
//		return "step3";
//	}
//
//	@PostMapping("/step3/{surveyTwoId}")
//	public String step3(@PathVariable("surveyTwoId") String surveyTwoId, SurveyStep3 sq, ModelMap map) throws IllegalAccessException, InvocationTargetException {
//		if (!StringUtils.isEmpty(surveyTwoId)) {
//			SurveyStep3 данные_для_заполнения = surveyStep3DAO.findBySurveyTwoId(surveyTwoId);//screeningQuestionsDAO.findAll().stream().filter(_данные -> surveyTwoId.equals(_данные.getSurveyTwoId())).findFirst().orElse(null);
//			sq.setId(данные_для_заполнения.getId());
//			org.apache.commons.beanutils.BeanUtils.copyProperties(данные_для_заполнения, sq);
//			map.addAttribute("gsfs", данные_для_заполнения);
//			surveyStep3DAO.save(данные_для_заполнения);
//		}
//		map.addAttribute("collected", "Your data has been saved.");
//		return "step3";
//	}
//
//}