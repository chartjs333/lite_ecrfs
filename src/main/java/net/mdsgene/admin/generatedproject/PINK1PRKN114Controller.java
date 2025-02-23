package net.mdsgene.admin.generatedproject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/PINK1PRKN114")
public class PINK1PRKN114Controller {

    @Autowired
PINK1PRKN1Repository14 pink1prkn1repository;


    @GetMapping("/{surveyTwoId}")
    public String PINK1PRKN1(@PathVariable("surveyTwoId") String surveyTwoId,
                         @RequestParam("centerId") String centerId,
                         @RequestParam("projectId") String projectId, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId) && ExcelToSurvey.checkKey(surveyTwoId)) {
PINK1PRKN114  data_to_fill_in =pink1prkn1repository.findBySurveyTwoId(surveyTwoId);
           if (data_to_fill_in==null) {
              data_to_fill_in = new PINK1PRKN114();
              data_to_fill_in.setSurveyTwoId(surveyTwoId);
             pink1prkn1repository.save(data_to_fill_in);
            }
                map.addAttribute("formObj", data_to_fill_in);
                map.addAttribute("centerId", centerId);
                map.addAttribute("projectId", projectId);
        return "PINK1PRKN114";
        }else {
        return "redirect:/";
       }
    }


    @PostMapping("/{surveyTwoId}")
    public String PINK1PRKN1(@PathVariable("surveyTwoId") String surveyTwoId, @ModelAttribute("formObj")PINK1PRKN114 formObj, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId) && ExcelToSurvey.checkKey(surveyTwoId)) {
            PINK1PRKN114 data_to_fill_in =pink1prkn1repository.findBySurveyTwoId(surveyTwoId);
            formObj.setId(data_to_fill_in.getId());
            pink1prkn1repository.save(formObj);
map.addAttribute("collected", "Your data has been saved.");
        return "PINK1PRKN114";
        } else{
        return "PINK1PRKN114";
        }
}
}
