package net.mdsgene.admin.generatedproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PINK1PRKN1Controller {

    @GetMapping("/informed-consent/{surveyId}")
    public RedirectView informedConsent(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN127/" + surveyId);
    }

    @GetMapping("/in-ex/{surveyId}")
    public RedirectView inEx(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN126/" + surveyId);
    }

    @GetMapping("/biomaterials/{surveyId}")
    public RedirectView biomaterials(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN11/" + surveyId);
    }

    @GetMapping("/csf/{surveyId}")
    public RedirectView csf(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN125/" + surveyId);
    }

    @GetMapping("/imaging/{surveyId}")
    public RedirectView imaging(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN12/" + surveyId);
    }

    @GetMapping("/med-history/{surveyId}")
    public RedirectView medHistory(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN13/" + surveyId);
    }

    @GetMapping("/fh/{surveyId}")
    public RedirectView fh(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN14/" + surveyId);
    }

    @GetMapping("/demographics/{surveyId}")
    public RedirectView demographics(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN15/" + surveyId);
    }

    @GetMapping("/ledd/{surveyId}")
    public RedirectView ledd(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN16/" + surveyId);
    }

    @GetMapping("/treatments/{surveyId}")
    public RedirectView treatments(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN17/" + surveyId);
    }

    @GetMapping("/exam/{surveyId}")
    public RedirectView exam(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN18/" + surveyId);
    }

    @GetMapping("/vital-signs/{surveyId}")
    public RedirectView vitalSigns(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN19/" + surveyId);
    }

    @GetMapping("/pd-history/{surveyId}")
    public RedirectView pdHistory(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN120/" + surveyId);
    }

    @GetMapping("/mdsupdrs-i/{surveyId}")
    public RedirectView mdsupdrsI(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN21/" + surveyId);
    }

    @GetMapping("/mdsupdrs-pat-i-ii/{surveyId}")
    public RedirectView mdsupdrsPatIandII(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN22/" + surveyId);
    }

    @GetMapping("/mdsupdrs-iii/{surveyId}")
    public RedirectView mdsupdrsIII(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN23/" + surveyId);
    }

    @GetMapping("/mdsupdrs-iv/{surveyId}")
    public RedirectView mdsupdrsIV(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN24/" + surveyId);
    }

    @GetMapping("/moca/{surveyId}")
    public RedirectView moca(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN25/" + surveyId);
    }

    @GetMapping("/upsit/{surveyId}")
    public RedirectView upsit(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN26/" + surveyId);
    }

    @GetMapping("/rbd/{surveyId}")
    public RedirectView rbd(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN27/" + surveyId);
    }

    @GetMapping("/quip/{surveyId}")
    public RedirectView quip(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN28/" + surveyId);
    }

    @GetMapping("/ess/{surveyId}")
    public RedirectView ess(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN29/" + surveyId);
    }

    @GetMapping("/gds/{surveyId}")
    public RedirectView gds(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN30/" + surveyId);
    }

    @GetMapping("/stai-s/{surveyId}")
    public RedirectView staiS(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN31/" + surveyId);
    }

    @GetMapping("/stai-t/{surveyId}")
    public RedirectView staiT(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN32/" + surveyId);
    }

    @GetMapping("/scopa-aut/{surveyId}")
    public RedirectView scopaAut(@PathVariable String surveyId) {
        return new RedirectView("/PINK1PRKN33/" + surveyId);
    }
}
