//package net.mdsgene.admin.controllers;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.vaadin.shared.ui.grid.Range;
//
//import net.mdsgene.admin.admintool.business.CommonFunctionsHelper;
//import net.mdsgene.admin.admintool.business.SequenceVariationValidator;
//import net.mdsgene.admin.admintool.dal.IDiseaseDAO;
//import net.mdsgene.admin.admintool.dal.IFamilyDAO;
//import net.mdsgene.admin.admintool.dal.IGeneDAO;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.entities.Study;
//import net.mdsgene.admin.admintool.model.Paginator;
//import net.mdsgene.admin.admintool.dal.IStudyDAO;
//import net.mdsgene.admin.admintool.entities.Patient;
//import net.mdsgene.admin.admintool.entities.PatientsSymptom;
//import net.mdsgene.admin.tags.ArrayLinksTag;
//import net.mdsgene.admin.tags.LinkToTag;
//
//@Controller
//public class PatientsController extends BaseController{
//	@Autowired ISequenceVariationDAO sequenceVariationDAO;
//	@Autowired IDiseaseDAO diseaseDAO;
//	@Autowired IGeneDAO geneDAO;
//	@Autowired IStudyDAO studyDAO;
//	@Autowired IPatientDAO patientDAO;
//	@Autowired IFamilyDAO familyDAO;
//	@Autowired CommonFunctionsHelper cfh;
//	@Autowired EntityManager em;
//
//	@GetMapping("/patients")
//	public String show(ModelMap model, @RequestParam(name="disease")int disease_id, @RequestParam(name="gene") int gene_id, @RequestParam(name="study") int study_id,
//			@RequestParam(name="p",required=false) Integer p) {
//		final int page = (p == null) ? 1 : p;
//		model.addAttribute("study", studyDAO.findOne(study_id));
//		model.addAttribute("gene", geneDAO.findOne(gene_id));
//		model.addAttribute("disease", diseaseDAO.select_launched_disease().stream().filter(x -> x.getId() == disease_id).findFirst().orElse(null));
//
//		int limit = page > 0 ? 10 : 10000;
//		int offset = page > 0 ? (page-1)*10 : 0;
//		Paginator paginator = new Paginator();
//		paginator.limit_value = 3;
//		paginator.current_page = page;
//		paginator.setTotalCount(patientDAO.indexSelected(study_id, disease_id, gene_id, 10000, 0).size());
//		paginator.setTotalPages(paginator.getTotalCount()/limit + (paginator.getTotalCount()%limit > 0 ? 1 : 0));
//		paginator.setAppender("&disease=" + disease_id + "&gene=" + gene_id + "&study=" + study_id);
//		model.addAttribute("paginator", paginator);
//
//		List<Patient> patients = patientDAO.indexSelected(study_id, disease_id, gene_id, limit, offset).stream().map(x -> patientDAO.findOne(x)).collect(Collectors.toList());
//		model.addAttribute("study_link_to",cfh.createStudyLinkTo(em, studyDAO, study_id, disease_id, gene_id).href("http://www.ncbi.nlm.nih.gov/pubmed/" + ((Study)(model.get("study"))).getPubmedId()));
//		model.addAttribute("patients", patients);
//		patients.forEach(x -> {
//
//			int[] index = new int[1];
//			List<PatientsSymptom> filter_symptoms_sas = x.getPatientsSymptoms().stream().filter(x1 -> x1.getSymptom() != null && x1.getSymptom().getName() != null && x1.isPresent()).collect(Collectors.toList());
//			ArrayLinksTag<LinkToTag> array = new ArrayLinksTag<>();
//			filter_symptoms_sas.forEach(x1 -> {
//				LinkToTag link = new LinkToTag();
//				link.myIndex(++index[0]).body(x1.getSymptom().getName()).linkGroupsCount(filter_symptoms_sas.size());
//				array.add(link);
//			});
//			model.addAttribute("study_symptoms_sas_" + x.getId(),array);
//
//			index[0] = 0;
//			List<PatientsSymptom> filter_symptoms_isas = x.getPatientsSymptoms().stream().filter(x1 -> x1.getSymptom() != null && x1.getSymptom().getName() != null && x1.getInitial() != null && x1.getInitial() == true).collect(Collectors.toList());
//			ArrayLinksTag<LinkToTag> array2 = new ArrayLinksTag<>();
//			filter_symptoms_isas.
//			/*sorted((o1, o2) -> o1.getSymptom().getName().compareTo(o2.getSymptom().getName())).*/forEach(x1 -> {
//				LinkToTag link = new LinkToTag();
//				link.myIndex(++index[0]).body(x1.getSymptom().getName()).linkGroupsCount(filter_symptoms_isas.size());
//				array2.add(link);
//			});
//			model.addAttribute("study_symptoms_isas_" + x.getId(),array2);
//
//			List<Object[]> mutations = sequenceVariationDAO.fetch_mutations(x.getId());
//			if (mutations.size() > 1 && mutations.stream().filter(sv -> (sv[0] != null && ((Short)sv[0]) == SequenceVariationValidator.genotype.comp_het.getGenotype())).findFirst().isPresent()) {
//				model.addAttribute("fetch_mutations_" + x.getId(), new ArrayLinksTag<LinkToTag>());
//				mutations.forEach(m -> {
//					((ArrayLinksTag<LinkToTag>)model.get("fetch_mutations_" + x.getId())).add(new LinkToTag().body(String.valueOf(m[1])).href("sequence_variations/" + m[2]));
//				});
//			} else {
//				model.addAttribute("fetch_mutations_" + x.getId(), new ArrayLinksTag());
//				mutations.forEach(m -> {
//					((ArrayLinksTag<LinkToTag>)model.get("fetch_mutations_" + x.getId())).add(
//							new LinkToTag().body(".".equals(String.valueOf(m[1])) ? "" : String.valueOf(m[1])).href("sequence_variations/" + m[2]).
//							postfix(m[0] != null && Range.between(1, 4).contains(((Short)m[0])) ?
//									": " + Arrays.asList(SequenceVariationValidator.genotype.values()).stream().filter(genotype -> genotype.getGenotype() == ((Short)m[0])).findFirst().get().name() : "n.g."));
//				});
//			}
//		});
//
//
//		return "patients/index";
//	}
//}