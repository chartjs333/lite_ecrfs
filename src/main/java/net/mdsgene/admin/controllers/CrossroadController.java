package net.mdsgene.admin.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.map.DefaultedMap;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.univocity.parsers.tsv.TsvWriter;
import com.univocity.parsers.tsv.TsvWriterSettings;

import net.mdsgene.admin.admintool.business.EmailMessage;
//import net.mdsgene.admin.admintool.business.CommonFunctionsHelper;
import net.mdsgene.admin.admintool.business.GeneDecorator;
//import net.mdsgene.admin.admintool.business.NativeSQL;
//import net.mdsgene.admin.admintool.dal.ICategoryDAO;
//import net.mdsgene.admin.admintool.dal.IChartsSymptomDAO;
//import net.mdsgene.admin.admintool.dal.ICrossroadDAO;
import net.mdsgene.admin.admintool.dal.IDiseaseDAO;
import net.mdsgene.admin.admintool.dal.IGeneDAO;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.IPatientsSymptomDAO;
//import net.mdsgene.admin.admintool.dal.IRestorePointDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.dal.ISymptomDAO;
//import net.mdsgene.admin.admintool.entities.Category;
//import net.mdsgene.admin.admintool.entities.ChartsSymptom;
import net.mdsgene.admin.admintool.entities.Disease;
import net.mdsgene.admin.admintool.entities.Gene;
//import net.mdsgene.admin.admintool.entities.PatientsSymptom;
//import net.mdsgene.admin.admintool.entities.Symptom;
//import net.mdsgene.admin.admintool.model.EmailMessage;
//import net.mdsgene.admin.admintool.model.S2D;
//import net.mdsgene.admin.admintool.model.S2deChart;
//import net.mdsgene.admin.controllers.StudiesController.Charts;
//import net.mdsgene.admin.controllers.StudiesController.Overview;
//import net.mdsgene.admin.tags.LinkToTag;

@Controller
public class CrossroadController{
	public static final String N_G = "";
//	@Autowired ICrossroadDAO dao;
	@Autowired IDiseaseDAO diseaseDAO;
	@Autowired IGeneDAO geneDAO;
//	@Autowired IPatientDAO patientDAO;
//	@Autowired IPatientsSymptomDAO patientsSymptomDAO;
//	@Autowired ISequenceVariationDAO svDAO;
//	@Autowired ISymptomDAO symptomDAO;
//	@Autowired ICategoryDAO categoryDAO;
//	@Autowired CommonFunctionsHelper cfh;
//	@PersistenceContext EntityManager em;
//	@Autowired NativeSQL nativeSQL;
//	@Autowired IPatientsSymptomDAO patientsSymptom;
//	@Autowired IChartsSymptomDAO chartsSymptomDAO;
//	@Autowired IRestorePointDAO restorePointDAO;

	public static Map<Integer, List<Integer>> cache_symptom_ids = new HashMap<>();

	//Logger functions
//	BiFunction<String, StringBuilder, Void> log_start = (operation, _sb) -> {_sb.append("\n" + LocalDateTime.now() + " INFO " + operation + " [" ); return null; };
//	BiFunction<String, StringBuilder, Void> log_end =   (operation, _sb) -> {_sb.append( "] " ); return null; };
//
//	Function<Short, String> get_category_status = (from) -> {Category _c = categoryDAO.findOne((int)from); return _c != null ? (_c.isMotor() ? " motor " : " non-motor ") : "status is unknown"; };
//	Function<Short, String> get_category_name = (from) -> {Category _c = categoryDAO.findOne((int)from); return _c != null ? "(" + _c.getName() + ")" : "(unknown)"; };
//	Function<Symptom, String> get_symptom_data = (from) -> {return from != null ? "( symptom: " + from.getName() + ", sign : " + from.getSignName() + ", import_header: " + from.getImportHeader() + ")" : "symptom is null!"; };
//

//	public static enum status_clinical {
//		clinical_status_unknown,
//		clinical_status_uncertain,
//	    clinical_status_affected,
//	    clinical_status_unaffected
//	}

	@GetMapping("/")
	public String index(ModelMap model) {
    // Check if the user is logged in
    if (!isUserLoggedIn()) {
        // Redirect to the sign-in page if the user is not logged in
        return "redirect:/user/sign_in";
    }

    // Add attributes to the model if needed
//		model.addAttribute("total_amount_of_studies", nativeSQL.execute(em, dao.total_amount_of_studies, null, x -> { return x.get(0);}));
//		model.addAttribute("total_amount_of_patients", nativeSQL.execute(em, dao.total_amount_of_patients, null, x -> { return x.get(0);}));
//		model.addAttribute("total_amount_of_mutations", nativeSQL.execute(em, dao.total_amount_of_mutations, null, x -> { return x.get(0);}));

    return "redirect:/survey";
	}

/**
 * Method to check if the user is logged in.
 * This is a placeholder method and should be implemented based on your authentication logic.
 */
private boolean isUserLoggedIn() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication != null && authentication.isAuthenticated();
}
//	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
//	    Set<Object> seen = ConcurrentHashMap.newKeySet();
//	    return t -> seen.add(keyExtractor.apply(t));
//	}

//	  def gene4disease
//    @genes_related_to_launched_diseases = Disease.select(:id, :name, :abbreviation).launched.order(id: :asc).map do |_disease|
//      _reviewed_gene = _disease.genes.select(:id, :name).distinct
//      _included_patients_genes = SequenceVariation.not_benign.joins(:patient, :gene).select("genes.id, genes.name").where(patients: {disease_id: _disease.id}).merge(Patient.affected).distinct
//      [ _disease, (_reviewed_gene + _included_patients_genes).uniq{|_g| _g.id}.sort_by{|_g| _g.name.downcase} ]
//    end
//    redirect_to root_path if @genes_related_to_launched_diseases.empty?
//  end

//	@RequestMapping(value = "/flare.csv")
//    public void findCity(HttpServletResponse response) throws IOException {
//		Map<String, Integer> id = new HashMap<String, Integer>();
//	    Map<String, List<Gene>> genes_related_to_launched_diseases = new TreeMap();
//	    List<Disease> select_launched_disease = diseaseDAO.select_launched_disease();
//
//	    g4d_without_category(id, genes_related_to_launched_diseases, select_launched_disease);
//
//	    int index[] = new int[1]; index[0] = 1000;
//		Set<String> published = new HashSet<>();
//		Set<String> unpublished = new HashSet<>();
//		String _ls = System.lineSeparator();
//		StringBuilder sb = new StringBuilder("id,value").append(_ls).append("mdsgene,").append(_ls);
//		genes_related_to_launched_diseases.entrySet().stream().forEach(x -> {
//			String key = x.getKey();
//			List<Gene> list = genes_related_to_launched_diseases.get(key);
//			if (list.stream().map(x1 -> x1.getName()).filter(x1 -> x1.endsWith("*")).count() > 0) {
//				if (unpublished.size() == 0) { sb.append("mdsgene.unpublished,").append(_ls); }
//				if (!unpublished.contains(key)) { sb.append("mdsgene.unpublished." + key + ",").append(_ls); unpublished.add(key); }
//				list.stream().filter(x1 -> x1.getName().endsWith("*")).forEach(x1 -> {
//					sb.append("mdsgene.unpublished." + key + "." + x1.getName().trim() + "," + x1.getId()).append(_ls);
//					index[0]++;
//				});
//			}
//			if (list.stream().map(x1 -> x1.getName()).filter(x1 -> !x1.endsWith("*")).count() > 0) {
//				if (published.size() == 0) { sb.append("mdsgene.published,").append(_ls); }
//				if (!published.contains(key)) { sb.append("mdsgene.published." + key + ",").append(_ls); published.add(key); }
//				list.stream().filter(x1 -> !x1.getName().endsWith("*")).forEach(x1 -> {
//					sb.append("mdsgene.published." + key + "." +  x1.getName().trim() + "," + x1.getId()).append(_ls);
//					index[0]++;
//				});
//			}
//		});
//		response.setContentType("text/plain; charset=utf-8");
//	    response.getWriter().print(sb.toString());
////		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(sb.toString());
//    }

	@GetMapping("/g4d")
	public String gene4disease(ModelMap model) {
		Map<String, Integer> id = new HashMap<String, Integer>();
		Map<String, List<ImmutableTriple<Disease, Integer, List<Gene>>>> genes_related_to_launched_diseases = new TreeMap();
		List<Disease> select_launched_disease = diseaseDAO.select_launched_disease();
		addUnimplemented(select_launched_disease);
	    g4d(id, genes_related_to_launched_diseases, select_launched_disease);

		model.put("genes_related_to_launched_diseases", genes_related_to_launched_diseases);
		model.put("id", id);
		return "crossroad/gene4disease";
	}

	private void addUnimplemented(List<Disease> select_launched_disease) {
		String abbreviation = "SCA";
		String name = "Spinocerebellar ataxia";

		if (select_launched_disease.stream().filter(_disaese -> _disaese.getAbbreviation().equals(abbreviation)).count() == 0) {
			Disease disease = new Disease();
			disease.setAbbreviation(abbreviation);
			disease.setCreatedAt(Calendar.getInstance().getTime());
			disease.setUpdatedAt(Calendar.getInstance().getTime());
			disease.setLaunched(true);
			disease.setName(name);
			diseaseDAO.save(disease);

			select_launched_disease.add(0, disease);
		}
	}


//	protected void g4d_without_category(Map<String, Integer> id, Map<String, List<Gene>> genes_related_to_launched_diseases,
//			List<Disease> select_launched_disease) {
//		if (GeneDecorator.lstDisease == null) {
//			GeneDecorator.lstDisease = select_launched_disease;
//		}
//
//		for (Disease _disease : select_launched_disease) {
//	    	List<Gene> _reviewed_gene = geneDAO.reviewed_gene(_disease.getId());
//	    	List<Gene> _included_patients_genes = geneDAO._included_patients_genes(_disease.getId());
//			List<Gene> sorted = Stream.concat(_reviewed_gene.stream(), _included_patients_genes.stream()).//filter(distinctByKey(Gene::getId)).
//					sorted((p1, p2) -> p1.getName() == null? -1 : p1.getName().compareToIgnoreCase(p2.getName())).collect(Collectors.toList());;
//			if (_disease.getAbbreviation().equals("EA")) {
//				for (Disease __disease : select_launched_disease) {
//					if (__disease.getAbbreviation().equals("PxMD")) {
//						_disease = __disease;
//						break;
//					}
//				}
//			}
//
//			String key = _disease.getAbbreviation();
//			List<Gene> value = MapUtils.getObject(genes_related_to_launched_diseases, key, new ArrayList<Gene>());
//			value.addAll(sorted);
//			genes_related_to_launched_diseases.put(key, value);
//			id.put(key, _disease.getId());
//	    };
	    /*
	    for (File file : new File("c:/unpublished/").listFiles()) {
	    	try {
				FileInputStream fis;
				fis = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				try {
				XSSFSheet ws = wb.getSheetAt(1);
				String _name = readParam(ws, 1, 0);
				String _abbreviation = readParam(ws, 1, 1);
				String _gene = readParam(ws, 1, 2);
				if (!N_G.equals(_name) && !N_G.equals(_abbreviation) && !N_G.equals(_gene)) {
					String _key = abbreviationForKey ? _abbreviation : _name + " ("+ _abbreviation + ")";
					List<Gene> value = MapUtils.getObject(genes_related_to_launched_diseases, _key, new ArrayList<Gene>());
					Gene g = new Gene();
					RestTemplate restTemplate = new RestTemplate();

					String _filter = "&fc=" + 0 + "&repeats=" + 0 + "&fn="+file.getAbsolutePath();
			        Integer gIndex = (Integer)restTemplate.getForObject("http://"
			        		+ ChartsData.UNPUBLISHED_DATA_URL
			        		+ "/tfi1?todo=9000"+_filter, Integer.class);
					g.setId(gIndex);
					g.setName(_gene+"*");

					g.setCreatedAt(Calendar.getInstance().getTime());
					if (g.getName() != null && !g.getName().endsWith("-*")) value.add(g);
					genes_related_to_launched_diseases.put(_key, value);
					if (!id.containsKey(_key)) id.put(_key, 0);
				}
				} finally {
					wb.close();
					fis.close();
				}
	    	} catch (Exception ex) {
	    		continue;
	    	}
	    }*/
//	}

	protected void g4d(Map<String, Integer> id, Map<String, List<ImmutableTriple<Disease, Integer, List<Gene>>>> genes_related_to_launched_diseases,
			List<Disease> select_launched_disease) {
		if (GeneDecorator.lstDisease == null) {
			GeneDecorator.lstDisease = select_launched_disease;
		}

		Map<String, Integer> width = new DefaultedMap<>(12);
		width.put("CHOR", 5);
		width.put("DYT", 7);
		width.put("EA", 8);
		width.put("PxMD", 4);

		for (Disease _disease : select_launched_disease) {
	    	List<Gene> _reviewed_gene = geneDAO.reviewed_gene(_disease.getId());
	    	List<Gene> _included_patients_genes = geneDAO._included_patients_genes(_disease.getId());
			List<Gene> sorted = Stream.concat(_reviewed_gene.stream(), _included_patients_genes.stream()).//filter(distinctByKey(Gene::getId)).
					sorted((p1, p2) -> p1.getName() == null? -1 : p1.getName().compareToIgnoreCase(p2.getName())).collect(Collectors.toList());;
			String key = _disease.getName() + " ("+ _disease.getAbbreviation() + ")";
			Integer __parent_id = _disease.getParentId();
			boolean found = false;
			if (__parent_id == null) {
				if (sorted.stream().filter(x -> x.getName().equals("PNKD")).count() > 0) {
					Disease __disease = new Disease();
					__disease.setId(_disease.getId());
					__disease.setName("Paroxysmal dyskinesia");
					__disease.setAbbreviation("1");
					__parent_id = _disease.getId();
					key = _disease.getName() + " ("+ _disease.getAbbreviation() + ")";
					found = true;
					List<Gene> _sorted = sorted.stream().filter(x -> Arrays.asList("PNKD", "PRRT2", "SLC2A1").contains(x.getName())).collect(Collectors.toList());
					key = retrieve_parrent_key(key, __parent_id);
					width.put(__disease.getAbbreviation(), 4);
					add_genes(id, genes_related_to_launched_diseases, width, __disease, _sorted , key);
				}
				if (sorted.stream().filter(x -> x.getName().equals("LRRK2")).count() > 0) {
					Disease __disease = new Disease();
					__disease.setId(_disease.getId());
					__disease.setName("Classical Parkinsonism, dominant forms");
					__disease.setAbbreviation("2");
					__parent_id = _disease.getId();
					key = _disease.getName() + " ("+ _disease.getAbbreviation() + ")";
					width.put(__disease.getAbbreviation(), 4);
					found = true;
					List<Gene> _sorted = sorted.stream().filter(x -> Arrays.asList("LRRK2", "SNCA", "VPS35").contains(x.getName())).collect(Collectors.toList());
					key = retrieve_parrent_key(key, __parent_id);
					add_genes(id, genes_related_to_launched_diseases, width, __disease, _sorted , key);
				}
				if (sorted.stream().filter(x -> x.getName().equals("DJ1")).count() > 0) {
					Disease __disease = new Disease();
					__disease.setId(_disease.getId());
					__disease.setName("Early-onset Parkinsonism, recessive forms");
					__disease.setAbbreviation("3");
					__parent_id = _disease.getId();
					key = _disease.getName() + " ("+ _disease.getAbbreviation() + ")";
					width.put(__disease.getAbbreviation(), 4);
					found = true;
					List<Gene> _sorted = sorted.stream().filter(x -> Arrays.asList("DJ1", "Parkin", "PINK1").contains(x.getName())).collect(Collectors.toList());
					key = retrieve_parrent_key(key, __parent_id);
					add_genes(id, genes_related_to_launched_diseases, width, __disease, _sorted , key);
				}
				if (sorted.stream().filter(x -> x.getName().equals("ATP13A2")).count() > 0) {
					Disease __disease = new Disease();
					__disease.setId(_disease.getId());
					__disease.setName("Atypical Parkinsonism");
					__disease.setAbbreviation("4");
					__parent_id = _disease.getId();
					key = _disease.getName() + " ("+ _disease.getAbbreviation() + ")";
					width.put(__disease.getAbbreviation(), 4);
					found = true;
					List<Gene> _sorted = sorted.stream().filter(x -> Arrays.asList("ATP13A2", "DNAJC6", "FBXO7", "SYNJ1", "DCTN1", "VPS13C").contains(x.getName().trim())).collect(Collectors.toList());
					key = retrieve_parrent_key(key, __parent_id);
					add_genes(id, genes_related_to_launched_diseases, width, __disease, _sorted , key);
				}
			}
			if (!found) {
				key = retrieve_parrent_key(key, __parent_id);
				add_genes(id, genes_related_to_launched_diseases, width, _disease, sorted, key);
			}
	    };

	    addUnimplementedGenes(genes_related_to_launched_diseases);

	}

	protected String retrieve_parrent_key(String key, Integer __parent_id) {
		while (__parent_id != null && diseaseDAO.findOne(__parent_id) != null) {
			Disease _parent_disease = diseaseDAO.findOne(__parent_id);
			if (_parent_disease != null) {
				key = _parent_disease.getName() + " ("+ _parent_disease.getAbbreviation() + ")";
				__parent_id = _parent_disease.getParentId();
			}
		}
		return key;
	}

	protected void add_genes(Map<String, Integer> id,
			Map<String, List<ImmutableTriple<Disease, Integer, List<Gene>>>> genes_related_to_launched_diseases,
			Map<String, Integer> width, Disease _disease, List<Gene> sorted, String key) {
		List<ImmutableTriple<Disease, Integer, List<Gene>>> value = MapUtils.getObject(genes_related_to_launched_diseases, key, new ArrayList<ImmutableTriple<Disease, Integer, List<Gene>>>());
		ImmutableTriple<Disease, Integer, List<Gene>> _pair = ImmutableTriple.of(_disease, width.get(_disease.getAbbreviation()), sorted);
		value.add(_pair);
		genes_related_to_launched_diseases.put(key, value);
		id.put(key, _disease.getId());
	}

	private void addUnimplementedGenes(
			Map<String, List<ImmutableTriple<Disease, Integer, List<Gene>>>> genes_related_to_launched_diseases) {

		List<ImmutableTriple<Disease, Integer, List<Gene>>> list = genes_related_to_launched_diseases.get("Spinocerebellar ataxia (SCA)");

		Gene gene = new Gene();
		gene.setCreatedAt(Calendar.getInstance().getTime());
		gene.setUpdatedAt(Calendar.getInstance().getTime());
		gene.setName("TBP");
		list.get(0).getRight().add(gene);

		genes_related_to_launched_diseases.keySet().stream().forEach(_k -> {
			System.out.println(_k);
		});
		list = genes_related_to_launched_diseases.get("Paroxysmal movement disorder (PxMD)");
		gene = new Gene();
		gene.setCreatedAt(Calendar.getInstance().getTime());
		gene.setUpdatedAt(Calendar.getInstance().getTime());
		gene.setName("CACNA1A");

		list = genes_related_to_launched_diseases.get("Dystonia/Parkinsonism (DYT/PARK)");
		gene = new Gene();
		gene.setCreatedAt(Calendar.getInstance().getTime());
		gene.setUpdatedAt(Calendar.getInstance().getTime());
		gene.setName("ATP1A3");
		list.get(0).getRight().add(gene);

		list = genes_related_to_launched_diseases.get("Hereditary spastic paraplegia (HSP)");
		gene = new Gene();
		gene.setCreatedAt(Calendar.getInstance().getTime());
		gene.setUpdatedAt(Calendar.getInstance().getTime());
		gene.setName("SPAST");
		list.get(0).getRight().add(gene);
		gene = new Gene();
		gene.setCreatedAt(Calendar.getInstance().getTime());
		gene.setUpdatedAt(Calendar.getInstance().getTime());
		gene.setName("ATL1");
		list.get(0).getRight().add(gene);
	}

//	private String readParam(XSSFSheet ws, int i, int j) {
//		if (ws.getRow(i).getCell(j) == null) return N_G;
//		String param = null;
//		switch (ws.getRow(i).getCell(j).getCellTypeEnum()) {
//		case FORMULA:
//			try {
//				param = String.valueOf(ws.getRow(i).getCell(j).getNumericCellValue());
//			} catch (Exception ex) {
//				try {
//					param = ws.getRow(i).getCell(j).getStringCellValue();
//				} catch (Exception ex1) {
//
//				}
//			}
//			break;
//		case STRING:
//			param = ws.getRow(i).getCell(j).getStringCellValue();
//			break;
//		case NUMERIC:
//			param = String.valueOf(ws.getRow(i).getCell(j).getNumericCellValue());
//			break;
//		default:
//			break;
//		}
//		param = param == null || param.startsWith("-99") ? N_G : param.split("\\.")[0];
//		return param;
//	}


//	@GetMapping("/methods")
//	public String methods(ModelMap model) {
//		return "methods";
//	}
//
//	@GetMapping("/links")
//	public String links(ModelMap model) {
//		return "links";
//	}
//
//	@GetMapping("/disclaimer")
//	public String disclamer(ModelMap model) {
//		return "disclaimer";
//	}
//
//	@GetMapping("/about")
//	public String about(ModelMap model) {
//		return "about";
//	}

//	@GetMapping("/unpublished")
//	public String unpublished(ModelMap model) {
//		return "unpublished";
//	}
//
//	@GetMapping("/sas_demo")
//	public String sas_demo(ModelMap model) {
//		return "sas_demo";
//	}

//	@InitBinder
//	public void initListBinder(WebDataBinder binder) {
//	    binder.setAutoGrowCollectionLimit(("no".equals(signsSymptomsEnabled)) ? 256 : 1000);
//	}

//	@RequestMapping("/s2de_chart")
//	public String signs_symptoms_edit(ModelMap model, S2deChart _s2deChart, @RequestParam(required=false) String action, @RequestParam(required=false, defaultValue="1") Integer times) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//		S2deChart s2deChart = null;
//
//		while(times-- > 0) s2deChart = signs_symptoms_edit_one_time(_s2deChart, action);
//
//		model.addAttribute("s2de_chart", s2deChart);
//
//		return "s2de_chart";
//	}

	/**
	 * @param _s2deChart
	 * @param action
	 * @return
	 */
//	private S2deChart signs_symptoms_edit_one_time(S2deChart _s2deChart, String action) {
//		S2deChart s2deChart = (_s2deChart != null ? _s2deChart : new S2deChart());
//		List<ChartsSymptom> chartSymptoms = new ArrayList<ChartsSymptom>();
//
//		List<Gene> genes = geneDAO.findAll().stream()/*.filter(x -> ONE_CHART_GENES_FOR_EDIT.contains(x.getName()) || TWO_CHART_GENES.contains(x.getName()))*/.collect(Collectors.toList());
//		s2deChart.setGenes(genes);
//
//		if(!CollectionUtils.isEmpty(s2deChart.getSelectedSymptoms())) {
//			s2deChart.getSelectedSymptoms().stream().forEach(_s -> {
//				ChartsSymptom __cs = new ChartsSymptom();
//				__cs.setCreatedAt(Calendar.getInstance().getTime());
//				__cs.setGene(s2deChart.getSelectedGene());
//				__cs.setMotor(s2deChart.isMotor());
//				__cs.setSymptom(_s);
//				__cs.setSymptomOrder(0);
//				chartsSymptomDAO.save(__cs);
//			});
//		}
//
//		if (action != null) {
//			if (action.startsWith("delete_symptom")) {
//				chartsSymptomDAO.delete(Integer.valueOf(action.substring("delete_symptom".length())));
//				chartSymptoms = read_all_charts_symptoms_and_order_them(s2deChart);
//			}
//			if (action.startsWith("motor_non_motor_symptom")) {
//				ChartsSymptom _a = chartsSymptomDAO.findOne(Integer.valueOf(action.substring("motor_non_motor_symptom".length())));
//				if(_a != null) {
//					_a.setMotor(!_a.isMotor()); chartsSymptomDAO.save(_a);
//				}
//				chartSymptoms = read_all_charts_symptoms_and_order_them(s2deChart);
//			}
//			Integer _id = null;
//			if (action.startsWith("down_symptom"))     {
//				chartSymptoms = read_all_charts_symptoms_and_order_them(s2deChart);
//				_id=Integer.valueOf(action.substring("down_symptom".length()));
//			}
//			if (action.startsWith("up_symptom"))     {
//				chartSymptoms = read_all_charts_symptoms_and_order_them(s2deChart);
//				_id=Integer.valueOf(action.substring("up_symptom".length()));
//			}
//
//			if (_id != null) {
//				Integer __id = _id;
//				List<ChartsSymptom> _chartSymptoms = chartSymptoms;
//				//normalize an array
//				IntStream.rangeClosed(0, chartSymptoms.size() - 1).forEach(order -> { ChartsSymptom _cs = _chartSymptoms.get(order); _cs.setSymptomOrder(order); });
//				// exchange elements order
//				IntStream.rangeClosed(0, chartSymptoms.size() - 1).forEach(order -> {
//					ChartsSymptom _cs = _chartSymptoms.get(order);
//					if(_cs.getId() == __id && action.startsWith("down_symptom")) {
//						boolean last_element = (order == (_chartSymptoms.size() -1));
//						if (!last_element) {
//							_cs.setSymptomOrder(order+1);
//							_chartSymptoms.get(order+1).setSymptomOrder(order);
//						}
//					} else if(_cs.getId() == __id && action.startsWith("up_symptom")) {
//						boolean first_element = (order == 0);
//						if (!first_element) {
//							_cs.setSymptomOrder(order-1);
//							_chartSymptoms.get(order-1).setSymptomOrder(order);
//							chartsSymptomDAO.save(_chartSymptoms.get(order-1));
//						}
//					}
//					chartsSymptomDAO.save(_cs);
//				});
//			}
//
//		}
//
//
//		// read all symptoms are not presented in the chart
//		if (s2deChart.getSelectedGene() != null) {
//			s2deChart.setIgnoreMotors(ONE_CHART_GENES_FOR_EDIT.contains(s2deChart.getSelectedGene().getName()));
//			chartSymptoms = read_all_charts_symptoms_and_order_them(s2deChart);
//			// read symptoms ids
//			Set<Integer> _symptom_ids = chartSymptoms.stream().filter(x -> x.getSymptom() != null).map(x -> x.getSymptom().getId()).collect(Collectors.toSet());
//			// read all symptoms which are not presenting the chart
//			List<Symptom> notSelectedSymptoms = chartsSymptomDAO.charts_symptom_ids_by_gene_id(s2deChart.getSelectedGene().getId()).stream().filter(x -> x != null && !_symptom_ids.contains(x)).
//					map(x -> symptomDAO.findOne(x)).
//					filter(x -> {Category _c = categoryDAO.findOne((int) x.getCategory()); return _c != null && (s2deChart.isIgnoreMotors() || _c.isMotor() == s2deChart.isMotor());}).collect(Collectors.toList());
//
//			// set in the model not presented symptoms
//			s2deChart.setNotSelectedSymptoms(notSelectedSymptoms);
//		}
//
//		if (s2deChart.getSelectedGene() != null) chartSymptoms = chartSymptoms.stream().sorted((o1, o2) -> Integer.compare(o1.getSymptomOrder(), o2.getSymptomOrder())).collect(Collectors.toList());
//		s2deChart.setChartSymptoms(chartSymptoms);
//		return s2deChart;
//	}

//	private List<ChartsSymptom> read_all_charts_symptoms_and_order_them(S2deChart s2deChart) {
//		List<ChartsSymptom> chartSymptoms;
//		if (!s2deChart.isIgnoreMotors()) {
//			chartSymptoms = chartsSymptomDAO.charts_symptoms_by_gene_id(s2deChart.getSelectedGene().getId(), s2deChart.isMotor()).stream().sorted((o1, o2) -> Integer.compare(o1.getSymptomOrder(), o2.getSymptomOrder())).collect(Collectors.toList());
//		} else {
//			chartSymptoms = chartsSymptomDAO.charts_symptoms_by_gene_id(s2deChart.getSelectedGene().getId(), true).stream().collect(Collectors.toList());
//			List<ChartsSymptom> chartSymptoms2 = chartsSymptomDAO.charts_symptoms_by_gene_id(s2deChart.getSelectedGene().getId(), false).stream().collect(Collectors.toList());
//			chartSymptoms.addAll(chartSymptoms2);
//			chartSymptoms = chartSymptoms.stream().sorted((o1, o2) -> Integer.compare(o1.getSymptomOrder(), o2.getSymptomOrder())).collect(Collectors.toList());
//		}
//		return chartSymptoms;
//	}

//
//	@RequestMapping("/s2de")
//	public String signs_symptoms_edit(ModelMap model, S2D s2d, String infer) throws IOException {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//
//		if (s2d != null && !org.apache.commons.lang3.StringUtils.isEmpty(s2d.getMoveToCategory())) {
//			if ((s2d.getSelectedSs() != null && !s2d.getSelectedSs().isEmpty())) {
//				Optional<Category> findFirst = categoryDAO.findAll().stream().filter(x -> x.getName().trim().equals(s2d.getMoveToCategory().trim())).findFirst();
//				if (findFirst.isPresent()) {                                            log_start.apply("move symptom(s)",_log); boolean _log_category[] = new boolean[1]; _log_category[0] = true;
//					s2d.getSelectedSs().forEach(sympt -> {
//						int category_id = findFirst.get().getId();
//						Symptom s = symptomDAO.findOne(sympt.intValue());
//						if (s != null) {                                                if(_log_category[0]) { _log.append(" from the category ").append(get_category_name.apply(s.getCategory())).append(" to the category ").append("(" + findFirst.get().getName() + ")"); _log_category[0] = false;}
//							s.setCategory((short) category_id);
//							symptomDAO.save(s);										    _log.append(get_symptom_data.apply(s));
//						}
//					});                                                                 log_end.apply("move symptom(s)",_log);
//				} else {
//					Optional<Symptom>[] findMergeTarget = new Optional[1];
//					findMergeTarget[0] = Optional.empty();
//					if ("merge".equals(s2d.getMoveToCategory())) {
//						findMergeTarget[0] = symptomDAO.symptoms_order_by_name().stream().filter(x -> x.getImportHeader().equals(s2d.getMergeToKey())).findFirst();
//					}
//					List<String> __rename_from_import_header = new ArrayList<>();
//					List<String> __rename_to_import_header = new ArrayList<>();
//					List<String> __delete_sympt = new ArrayList<>();
//
//					List<Symptom> __merge_sympt = new ArrayList<>();
//					Set<ChartsSymptom> __merge_chart_symptoms = new HashSet<>();
//					Symptom[] __merge_target = new Symptom[1];
//
//					//if operation is 'just rename'
//					//read information about symptom (names, sign names, import headers) to the cache
//					//so it will be possible to find duplicates
//					Map<String, Integer> __symptom_names = new HashMap<>();
//					Map<String, Integer> __symptom_sign_names = new HashMap<>();
//					Map<String, Integer> __symptom_import_headers = new HashMap<>();
//					List<String> __errors = new ArrayList<>();
//					model.addAttribute("errors", __errors);
//					if ("just rename".equals(s2d.getMoveToCategory())) {
//						symptomDAO.findAll().stream().forEach(__s -> {
//							__symptom_names.put(__s.getName(), __s.getId());
//							__symptom_sign_names.put(__s.getSignName(), __s.getId());
//							__symptom_import_headers.put(__s.getImportHeader(), __s.getId());
//						});
//					}
//					log_start.apply(s2d.getMoveToCategory() + " symptom(s)",_log);
//					s2d.getSelectedSs().stream().forEach(sympt -> {
//						Symptom s = symptomDAO.findOne(sympt.intValue());
//						if (s != null && "just rename".equals(s2d.getMoveToCategory())) {
//
//							String __name = s2d.getRows().get(sympt.intValue()).getName();
//							String __sign_name = s2d.getRows().get(sympt.intValue()).getSignName();
//							String __import_header = s2d.getRows().get(sympt.intValue()).getImportHeader();
//
//							boolean failed = false;
//							if (__symptom_names.containsKey(__name) && __symptom_names.get(__name) != sympt.intValue()) { failed = true; String _err = "Symptom with the name: " + __name + " already exist";
//								__errors.add(_err); _log.append("Error: " + _err); } // add as an error
//							if (__symptom_sign_names.containsKey(__sign_name) && __symptom_sign_names.get(__sign_name) != sympt.intValue()) { failed = true; String _err = "Symptom with the sign name: " + __sign_name + " already exist";
//								__errors.add(_err); _log.append("Error: " + _err); } // add as an error
//							if (__symptom_import_headers.containsKey(__import_header) && __symptom_import_headers.get(__import_header) != sympt.intValue()) { failed = true; String _err = "Symptom with the import header: " + __import_header + " already exist";
//								__errors.add(_err); _log.append("Error: " + _err); } // ad as an error
//
//							if ( !failed ) { //rename the symptom
//								s.setName(__name);
//								s.setSignName(__sign_name);
//								__rename_from_import_header.add(s.getImportHeader());
//								__rename_to_import_header.add(__import_header);
//								s.setImportHeader(__import_header);
//								try {
//									symptomDAO.save(s);                                     _log.append(get_symptom_data.apply(s));
//								} catch (Exception ex) {
//									ex.printStackTrace();
//								}
//							}
//						} else if (s != null && "delete".equals(s2d.getMoveToCategory())) {
//							s.getPatientsSymptoms().stream().forEach(_ps -> {
//								patientsSymptom.delete(_ps.getId());
//							});
//							List<ChartsSymptom> find_by_symptom_id = chartsSymptomDAO.find_by_symptom_id(s.getId());
//							for(ChartsSymptom cs : find_by_symptom_id) chartsSymptomDAO.delete(cs);
//							__delete_sympt.add(s.getImportHeader());
//							symptomDAO.delete(s.getId());                                   _log.append(get_symptom_data.apply(s));
//						} else if (s != null && "merge".equals(s2d.getMoveToCategory())) {
//							boolean[] present = new boolean[1];
//							Boolean[] initial = new Boolean[1];
//							for(PatientsSymptom __ps : s.getPatientsSymptoms()) {
//								if(__ps.isPresent()) present[0] = true;
//								if(__ps.getInitial() != null) initial[0] = (initial[0] != null ? (__ps.getInitial() || initial[0]) : __ps.getInitial());
//							}
//							s.getPatientsSymptoms().stream().forEach(_ps -> {
//								_ps.setSymptom(findMergeTarget[0].get());
//								_ps.setPresent(present[0]);
//								_ps.setInitial(initial[0]);
//								patientsSymptom.save(_ps);
//								System.out.print(".");
//							});
//							if (findMergeTarget[0].get().getId() != s.getId()) {
//								//find all gene_id's for whom should be created position in the chart
//								__merge_chart_symptoms.addAll(chartsSymptomDAO.find_by_symptom_id(s.getId()));
//								__merge_sympt.add(s);
//							} else {
//								__merge_target[0] = s;
//							}
//						}
//					});
//
//					if (__merge_target[0] != null) { 										 _log.append("to symptom ").append(get_symptom_data.apply(__merge_target[0]));
//						Map<Gene, ChartsSymptom> _result = new HashMap<>();
//						//group by gene_id and symptom_id
//						Map<String, Integer> gene_symptom_map = new HashMap<>();
//						__merge_chart_symptoms.stream().forEach(_cs -> {
//							Integer _a = gene_symptom_map.get(_cs.getGene().getId() + "_" + _cs.getSymptom().getId());
//							if (_a == null) _a = _cs.getSymptomOrder(); else _a = Math.min(_a , _cs.getSymptomOrder());
//							gene_symptom_map.put(_cs.getGene().getId() + "_" + _cs.getSymptom().getId(), _a);
//							chartsSymptomDAO.delete(_cs.getId());
//
//							ChartsSymptom cs = new ChartsSymptom();
//							cs.setCreatedAt(Calendar.getInstance().getTime());
//							cs.setUpdatedAt(Calendar.getInstance().getTime());
//							cs.setGene(_cs.getGene());
//							cs.setMotor(is_motor(__merge_target[0].getCategory()));
//							cs.setSymptom(__merge_target[0]);
//							cs.setSymptomOrder(_cs.getSymptomOrder());
//
//							if (!_result.containsKey(_cs.getGene()) || _result.get(_cs.getGene()).getSymptomOrder() > _cs.getSymptomOrder()) {
//								_result.put(_cs.getGene(), cs);
//							}
//						});
//						__merge_sympt.stream().forEach(_s -> {
//							symptomDAO.delete(_s); 												_log.append(" << ").append(get_symptom_data.apply(_s));
//						});
//
//
//						_result.values().stream().forEach(cs -> chartsSymptomDAO.save(cs));
//
//					}
//
//
//					if (__merge_target[0] != null) {
//						//this part will merge information into Excel
//						Pair<String[],String[]> merge_from_to = Pair.of(__merge_sympt.stream().map(_s -> _s.getImportHeader()).collect(Collectors.toList()).toArray(new String[0]),
//								new String[] {__merge_target[0].getImportHeader()});
//						write_excel_processing_log_file("merge", merge_from_to, false);
////						List<String> _errors_by_merge = new UploadController().process_tsv(null, merge_from_to, "merge", true);
////						if (!_errors_by_merge.isEmpty()) __errors.addAll(_errors_by_merge);
//					}
//
//					if(!__delete_sympt.isEmpty()) {
//						//this part will delete information into Excel
//						Pair<String[], String[]> delete_of = Pair.of(__delete_sympt.toArray(new String[0]), null);
//						write_excel_processing_log_file("delete", delete_of, false);
////						List<String> _errors_by_delete = new UploadController().process_tsv(null, delete_of, "delete", true);
////						if (!_errors_by_delete.isEmpty()) __errors.addAll(_errors_by_delete);
//
//					}
//					if(!__rename_from_import_header.isEmpty()) {
//						//this part will rename information into Excel
//						Pair<String[], String[]> rename_from_ti = Pair.of(__rename_from_import_header.toArray(new String[0]),
//																		  __rename_to_import_header.toArray(new String[0]));
//						write_excel_processing_log_file("rename", rename_from_ti, false);
////						List<String> _errors_by_rename = new UploadController().process_tsv(null, rename_from_ti, "rename", true);
////						if (!_errors_by_rename.isEmpty()) __errors.addAll(_errors_by_rename);
//					}
//
//					log_end.apply(s2d.getMoveToCategory() + " symptom(s)",_log);
//				}
//			}
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	private void write_excel_processing_log_file(String command, Pair<String[], String[]> values, boolean test) throws IOException {
//		TsvWriterSettings settings = new TsvWriterSettings(); //many options here. Check the documentation
//		//settings.getFormat().setDelimiter('\t');
//		String fileName = userDefinedDbBackupPath + "\\" + (test ? ("commands_for_excel_test_" + serverPort + ".log") : ("commands_for_excel_" + serverPort + ".log"));
//		TsvWriter writer = new TsvWriter(new FileWriter(fileName, new File(fileName).exists() ? true : false), settings);
//		List<String> _lst = new ArrayList<>();
//		_lst.add(command);
//		_lst.add(Calendar.getInstance().getTime().toString());
//		_lst.add("left");
//		_lst.add(StringUtils.join(values.getLeft(), "|||"));
//		_lst.add("right");
//		_lst.add(values.getRight() != null ? StringUtils.join(values.getRight(), "|||") : "");
//		writer.writeRow(_lst);
//		writer.close();
//	}

//	private void update_the_log_file(ModelMap model, StringBuilder _log) {
//		try {
//		    Files.write(Paths.get(userDefinedDbBackupPath + "\\log_" + serverPort + ".txt"), _log.toString().getBytes(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//
//		    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(userDefinedDbBackupPath + "\\log_" + serverPort + ".txt"),"utf-8"));
//		    List<String> lines = new ArrayList<>();
//		    String line;
//		    while ((line = br.readLine()) != null) {
//		       lines.add(line);
//		    }
//		    model.addAttribute("log",lines);
//			//model.addAttribute("log",Files.readAllLines(Paths.get(userDefinedDbBackupPath + "\\log_" + serverPort + ".txt")));
//		}catch (IOException e) {
//		    e.printStackTrace();
//		}
//	}

//	private void build_s2d_symptoms_view_model(ModelMap model, StringBuilder _log) {
//		S2D s2de = null;
//		model.addAttribute("s2d", s2de = new S2D());
//		List<Symptom> symptoms_order_by_name = symptomDAO.symptoms_order_by_name();
////		for (Symptom s : symptoms_order_by_name) {
////			s.setSignName(s.getName());
////		}
//
//		model.addAttribute("all_ss", symptoms_order_by_name);
//		s2d_show(s2de);
//		s2de.setRows(new ArrayList<>());
//		for (Map<String, List<Symptom>> symptLst : s2de.getGrouped_ss()) {
//			for (List<Symptom> s1 : symptLst.values()) {
//				for (Symptom s : s1) {
//					while(s2de.getRows().size() <= s.getId()) {
//						s2de.getRows().add(new Symptom());
//					}
//					s2de.getRows().remove(s.getId());
//					s2de.getRows().add(s.getId(), s);
//				}
//			}
//		}
//
//
//		//read restore points
//		model.addAttribute("available_restore_points", restorePointDAO.findAll());
//		if (_log != null) update_the_log_file(model, _log);
//
//		cache_symptom_ids = new HashMap<>();
//		System.out.println("Cache is updated");
//	}

	// check if it is a motor symptom
//	private boolean is_motor(short category) {
//		return categoryDAO.findAll().stream().anyMatch(x -> x.isMotor() && x.getId() == category);
//	}

//	@GetMapping("/s2d")
//	public String signs_symptoms(ModelMap model, S2D s2d, String infer) {
//		if(s2d == null) model.addAttribute("s2d", new S2D());
//		else model.addAttribute("s2d", s2d);
//
//		model.addAttribute("all_ss", symptomDAO.symptoms_order_by_sign_name());
//		if(((List)model.get("all_ss")).isEmpty()) return "crossroad/index";
//
//		if ((s2d.getSelectedSs() != null && !s2d.getSelectedSs().isEmpty()) && infer != null && infer.equals("t")) {
//			if (s2d.getAao() == null || s2d.getAao() > 150) s2d.setAao(150);
////			DiagnosesData diagnosesData = new DiagnosesData(this,s2d.getSelectedSs(), s2d.getAao(), cfh);
//			DiagnosesData diagnosesData = new DiagnosesData(this,getSelectedSsPlusSymptomsWithDuplicatedNames(s2d.getSelectedSs()), s2d.getAao(), cfh);
//			model.addAttribute("possible_diagnoses", diagnosesData.possible_diagnoses());
//			List<LinkToTag> impossible_diagnoses = diagnosesData.impossible_diagnoses();
//			model.addAttribute("imp_d", impossible_diagnoses);
//			return "crossroad/diagnoses";
//		} else if (s2d.getGrouped_ss() == null){
//			s2d_show_sign_name(s2d);
//		}
//		return ("no".equals(signsSymptomsEnabled)) ? "sas_demo" : "s2d";
//		//return "sas_demo";
//	}

//	@RequestMapping("/s2de_rename")
//	public String signs_symptoms_rename_category(ModelMap model, String new_category_name, String original_category_name, Boolean motor_signs_symptom) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//		if (new_category_name != null && original_category_name != null) {
//			log_start.apply("rename category", _log);
//			boolean anyMatch = categoryDAO.findAll().stream().anyMatch(x -> x.getName().equals(new_category_name.trim()));
//			if (anyMatch) {
//				String _error = "Category with the name (" + new_category_name + ") already exists.";
//				model.addAttribute("errors", Arrays.asList(new String[] {_error}));
//				_log.append(_error);
//			} else {
//				for (Category category : categoryDAO.findAll()) {
//					if (original_category_name.equals(category.getName())) {
//						_log.append(" from: ").append(get_category_name.apply((short) category.getId())); _log.append(get_category_status.apply((short) category.getId()));
//						category.setMotor(BooleanUtils.isTrue(motor_signs_symptom));
//						category.setName(new_category_name);
//						category.setUpdatedAt(Calendar.getInstance().getTime());
//						categoryDAO.save(category); _log.append(" to: ").append(get_category_name.apply((short) category.getId())); _log.append(get_category_status.apply((short) category.getId()));
//						break;
//					}
//				}
//			}
//			log_end.apply("rename category", _log);
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	@RequestMapping("/s2de_new_category")
//	public String signs_symptoms_new_category(ModelMap model, String new_category_name, Boolean motor_signs_symptom) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//		if (new_category_name != null) {
//			log_start.apply("new category", _log);
//			boolean anyMatch = categoryDAO.findAll().stream().anyMatch(x -> x.getName().equals(new_category_name.trim()));
//			if (anyMatch) {
//				String _error = "Category with the name (" + new_category_name + ") already exists.";
//				model.addAttribute("errors", Arrays.asList(new String[] {_error}));
//				_log.append(_error);
//			} else {
//				Category category = new Category();
//				category.setMotor(BooleanUtils.isTrue(motor_signs_symptom));
//				category.setName(new_category_name);
//				category.setUpdatedAt(Calendar.getInstance().getTime());
//				Category _save = categoryDAO.save(category); _log.append(get_category_name.apply((short) category.getId())); _log.append(get_category_status.apply((short) _save.getId()));
//			}
//			log_end.apply("new category", _log);
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}
//	@RequestMapping("/s2de_delete_category")
//	public String delete_category(ModelMap model, String delete_category_for_sure, String old_category_name) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();;
//		if (delete_category_for_sure != null && delete_category_for_sure.equals("I'm sure")) {
//			_log = new StringBuilder();
//			log_start.apply("delete category", _log);
//			for (Category category : categoryDAO.findAll()) {
//				if (old_category_name.equals(category.getName())) {
//					_log.append(get_category_name.apply((short) category.getId()));
//					categoryDAO.delete(category);
//					break;
//				}
//			}
//			log_end.apply("delete category", _log);
//		} else {
//			model.addAttribute("errors", Arrays.asList(new String[] {"Category with the name (" + old_category_name + ") will not be deleted."}));
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	@RequestMapping("/s2de_new_symptom")
//	public String signs_symptoms_new_symptom(ModelMap model, String new_symptom_name, String new_import_header_name, String original_symptom_name) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//
//		//check if the parameters are valid
//		if (new_symptom_name != null && original_symptom_name != null) {
//			// check if the symptom with this name already exist
//			boolean anyMatch = symptomDAO.findAll().stream().anyMatch(x -> x.getName().equals(new_symptom_name.trim()));
//			// check if the symptom with this import header already exist
//			boolean anyImportHeader = symptomDAO.findAll().stream().anyMatch(x -> x.getImportHeader().equals(new_import_header_name.trim()));
//			if (anyMatch || anyImportHeader) {
//				if (anyMatch) model.addAttribute("errors", Arrays.asList(new String[] {"Symptom with the name (" + new_symptom_name + ") already exists."}));
//				if (anyImportHeader) model.addAttribute("errors", Arrays.asList(new String[] {"Import header with the name (" + new_import_header_name + ") already exists."}));
//			} else {
//				log_start.apply("new symptom", _log);
//				// loop over all symptoms
//				for (Symptom symptom : symptomDAO.findAll()) {
//					// find symptom with the name correspondent to the name of the symptom should be duplicated
//					if (original_symptom_name.equals(symptom.getName())) { _log.append(" from: ").append(get_symptom_data.apply(symptom));
//						// create symptom copy
//						Symptom symptom2 = new Symptom();
//						BeanUtils.copyProperties(symptom, symptom2);
//						symptom2.setName(new_symptom_name);
//						symptom2.setSignName(new_symptom_name);
//						symptom2.setImportHeader(new_import_header_name);
//						symptom2.setId(0);
//						symptom2.setPatientsSymptoms(new HashSet<PatientsSymptom>());
//						symptomDAO.save(symptom2); _log.append(" to: ").append(get_symptom_data.apply(symptom2));
//
//						// create patient symptoms copy
//						for (PatientsSymptom p : symptom.getPatientsSymptoms()) {
//							PatientsSymptom p2 = new PatientsSymptom();
//							BeanUtils.copyProperties(p, p2);
//							p2.setId(0);
//							p2.setSymptom(symptom2);
//							p2.setCreatedAt(Calendar.getInstance().getTime());
//							p2.setUpdatedAt(Calendar.getInstance().getTime());
//							patientsSymptomDAO.save(p2);
//							symptom2.getPatientsSymptoms().add(p2);
//						}
//
//						//update information into the charts symptoms
//						// has to be finished tomorrow!!!
//						for (ChartsSymptom __cs : chartsSymptomDAO.findAll()) {
//							if (__cs.getSymptom().getId() == symptom.getId()) {
//								ChartsSymptom cs = new ChartsSymptom();
//								BeanUtils.copyProperties(__cs, cs);
//								cs.setId(0);
//								cs.setCreatedAt(Calendar.getInstance().getTime());
//								cs.setUpdatedAt(Calendar.getInstance().getTime());
//								cs.setSymptom(symptom2);
//								chartsSymptomDAO.save(cs);
//							}
//						}
//						break;
//					}
//				}
//				log_end.apply("new symptom", _log);
//			}
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	@GetMapping("/s2de_up")
//	public String category_up(ModelMap model, @RequestParam String category_name) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder(); log_start.apply("order category", _log);
//		boolean down = false;					  _log.append(category_name + " moved one step up");
//		move_category(category_name, down);		  log_end.apply("order category", _log);
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	@GetMapping("/s2de_down")
//	public String category_down(ModelMap model, @RequestParam String category_name) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder(); log_start.apply("order category", _log);
//		boolean down = true;					  _log.append(category_name + " moved one step down");
//		move_category(category_name, down);		  log_end.apply("order category", _log);
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	private int closest(int of, List<Category> in, boolean down) {
//	    int min = Integer.MAX_VALUE;
//	    int closest = of;
//	    boolean found = false;
//
//	    for (Category vi : in) {
//	    	int v = vi.getId();
//	    	if (down && v <= of) continue;
//	    	if (!down && v >= of) continue;
//	        final int diff = Math.abs(v - of);
//
//	        if (diff < min) {
//	            min = diff;
//	            closest = v;
//	            found = true;
//	        }
//	    }
//
//	    return found ? closest : -1;
//	}

//	private void move_category(String category_name, boolean down) {
//
//		if (category_name != null) {
//			List<Category> in = categoryDAO.findAll();
//			for (Category category : in) {
//				if (category_name.equals(category.getName())) {
//					int closest = closest(category.getId(), in, down);
//					if (closest != -1) {
//						Category a = categoryDAO.findOne(closest);
//						Category b = category;
//
//						List<Symptom> in2 = symptomDAO.findAll();
//						for (Symptom s : in2) {
//							if (s.getCategory() == a.getId()) {
//								s.setCategory((short) b.getId());
//								symptomDAO.save(s);
//							} else {
//								if (s.getCategory() == b.getId()) {
//									s.setCategory((short) a.getId());
//									symptomDAO.save(s);
//								}
//							}
//						}
//
//						Pair<String,String> name = Pair.of(a.getName(), b.getName()); a.setName(name.getRight()); b.setName(name.getLeft());
//						Pair<Boolean, Boolean> motor = Pair.of(a.isMotor(), b.isMotor()); a.setMotor(motor.getRight()); b.setMotor(motor.getLeft());
//						Pair<Date,Date> created_at = Pair.of(a.getCreatedAt(), b.getCreatedAt()); a.setCreatedAt(created_at.getRight()); b.setCreatedAt(created_at.getLeft());
//						Pair<Date,Date> updated_at = Pair.of(a.getUpdatedAt(), b.getUpdatedAt()); a.setUpdatedAt(updated_at.getRight()); b.setUpdatedAt(updated_at.getLeft());
//
//						categoryDAO.save(a);
//						categoryDAO.save(b);
//					}
//
//					break;
//				}
//			}
//		}
//	}


	/**
	 * this function will get the list of the duplicated symptoms.
	 * Plus it will additionally add the ids of the symptoms which are not presented in a list, but which names are equals to the selected symptoms.
	 *
	 * @param selectedSs
	 * @return
	 */
//	private List<Integer> getSelectedSsPlusSymptomsWithDuplicatedNames(List<Integer> selectedSs) {
//		selectedSs.stream().filter(_s -> !cache_symptom_ids.containsKey(_s)).forEach(_s -> {
//			Symptom s = symptomDAO.findOne(_s);
//			if (s != null) {
//				List<Symptom> lst = symptomDAO.findBySignName(s.getSignName());
//				if (lst != null && !lst.isEmpty()) {
//					List<Integer> collect = lst.stream().map(_s1 -> _s1.getId()).collect(Collectors.toList());
//					cache_symptom_ids.put(_s, collect);
//				}
//			}
//		});
//		List<Integer> selectedAndDuplicatedNames = new ArrayList<>();
//		selectedSs.forEach(_s -> {
//			selectedAndDuplicatedNames.addAll(cache_symptom_ids.get(_s));
//		});
//		return selectedAndDuplicatedNames;
//	}

//	private void s2d_show(S2D s2d) {
//		Map<String, String> _h = new HashMap<>();
//		 List<Symptom> allSymptoms = symptomDAO.findAll();
//
//		 List<Map<String, List<Symptom>>> grouped_ss = categoryDAO.findAll().stream().sorted((o1,o2)-> Integer.compare(o1.getId(), o2.getId())).map(x -> new Object[] {x.getName(), x.getId()}).map(x -> {
//			 Map<String, List<Symptom>> _grouped_ss = new HashMap<>();
//			 String _k = (String) x[0];
//			 Integer _v = (Integer) x[1];
//			 Set<String> _kk = new HashSet<>();
//			 // this part will filter symptoms by the categories
//			 // at the same time it will sort the symptoms
//			 List<Symptom> _t =
//					 allSymptoms.stream().filter(x1 -> x1.getCategory() == _v).sorted((o1, o2) -> rim(o1.getName()).compareTo(rim(o2.getName())))/*.map(x1 -> ImmutablePair.of(x1, (String)null))*/.collect(Collectors.toList());
//			 //if (!_t.isEmpty()) {
//				 _t = _t.stream().filter(x1 -> {if (_kk.contains(x1.getName())) { return false; } else  { _kk.add(x1.getName()); return true; } } ).collect(Collectors.toList());
//				 _grouped_ss.put(_k, _t);
//			 //}
//			 return _grouped_ss;
//		 }).collect(Collectors.toList());
//		 s2d.setGrouped_ss(grouped_ss);
//	}

	/**
	 * this function will remove initial minus
	 * it is usable for sort the symptoms in the list
	 */
//	private String rim(String str) {
//		if (str != null && str.startsWith("-")) return str.replaceFirst("\\-", "");
//		return str;
//	}

	/**
	 * this function does the same thing what is doing the above function.
	 * Just with the one minor difference it process all the things with the signName (not with the name)
	 * @param s2d
	 */
//	private void s2d_show_sign_name(S2D s2d) {
//		Map<String, String> _h = new HashMap<>();
//		 List<Symptom> allSymptoms = symptomDAO.findAll();
//
//		 List<Map<String, List<Symptom>>> grouped_ss = categoryDAO.findAll().stream().sorted((o1,o2)-> Integer.compare(o1.getId(), o2.getId())).map(x -> new Object[] {x.getName(), x.getId()}).map(x -> {
//			 Map<String, List<Symptom>> _grouped_ss = new HashMap<>();
//			 String _k = (String) x[0];
//			 Integer _v = (Integer) x[1];
//			 Set<String> _kk = new HashSet<>();
//			 List<Symptom> _t =
//					 allSymptoms.stream().filter(x1 -> x1.getCategory() == _v && !StringUtils.isEmpty(x1.getSignName())).sorted((o1, o2) -> rim(o1.getSignName()).compareTo(rim(o2.getSignName())))/*.map(x1 -> ImmutablePair.of(x1, (String)null))*/.collect(Collectors.toList());
//			 if (!_t.isEmpty()) {
//				 _t = _t.stream().filter(x1 -> {if (_kk.contains(x1.getSignName())) { return false; } else  { _kk.add(x1.getSignName()); return true; } } ).collect(Collectors.toList());
//				 _grouped_ss.put(_k, _t);
//			 }
//			 return _grouped_ss;
//		 }).collect(Collectors.toList());
//		 s2d.setGrouped_ss(grouped_ss);
//	}

//	@RequestMapping("/backup_db")
//	public String backup_db_facade(ModelMap model, @RequestParam String restore_point_name) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//		try {
//			log_start.apply("database backup", _log);
//			String error = super.backupDB(restore_point_name); _log.append(" restore point name (" + restore_point_name + ")");
//			if (error != null) {
//				List<String> __errors = new ArrayList<>();
//				__errors.add(error); _log.append("Error: " + error);
//				model.addAttribute("errors", __errors);
//			}
//		} catch (Exception e) {
//			String _error = "Can't create restore point. Error message : (" + e.getMessage() + ").";
//			_log.append(_error);
//			model.addAttribute("errors", new ArrayList<String>().add(_error));
//		}
//		log_end.apply("database backup", _log);
//        build_s2d_symptoms_view_model(model, _log);
//		return "redirect:/s2de";
//	}

//	@RequestMapping("/restore_db")
	/**
	 * This function is not implemented, may be it will be implemented sometimes later?
	 * @param model
	 * @param restore_db_for_sure
	 * @param restore_point_id
	 * @return
	 */
//	public String restore_db_facade(ModelMap model, @RequestParam String restore_db_for_sure, @RequestParam Integer restore_point_id) {
//		if ("no".equals(signsSymptomsEnabled)) throw new RuntimeException("not yet implemented");
//
//		StringBuilder _log = new StringBuilder();
//		if (restore_db_for_sure != null && restore_db_for_sure.equals("I'm sure")) {
//			try {
//				String error = super.restoreDB(restore_point_id);
//				if (error != null) {
//					List<String> __errors = new ArrayList<>();
//					__errors.add(error);
//					model.addAttribute("errors", __errors);
//				}
//			} catch (Exception e) {
//				List<String> __errors = new ArrayList<>();
//				model.addAttribute("errors", __errors.add("Can't create restore point. Error message : (" + e.getMessage() + ")."));
//			}
//		} else {
//			model.addAttribute("errors", Arrays.asList(new String[] {"Database will not be restored."}));
//		}
//        build_s2d_symptoms_view_model(model, _log);
//		return "s2de";
//	}

//	_selected_ss = params.select{|_k, _v| _v.eql? '1' and not _k.eql?(:aao)}.keys.map!{|_k| _k.to_i}
/*

if params.has_key? :infer and not _selected_ss.keep_if{|_p| @all_ss.has_key? _p}.empty?
  _selected = "ARRAY[#{_selected_ss.join ','}]"
  _aao = params.fetch :aao, String.new
  _aao_ordering = String.new
  if _aao =~ /^[[:space:]]*[0-9]{1,3}[[:space:]]*$/
    _aao = _aao.to_i
    _aao = 150 if _aao > 150 # Fool-tolerance
    _aao_ordering << "(#{_aao} BETWEEN (COALESCE(min_aao,0)-#{INACCURACY_OF_AAO}) AND (COALESCE(max_aao,150)+#{INACCURACY_OF_AAO})) DESC NULLS LAST, "
  end
  _having_cond = "ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) && " + _selected
  _raw_pd = Patient.affected.joins(:disease, :genes, :patients_symptoms)
                   .where(diseases: {launched: true}, patients_symptoms: {present: true})
                   .merge(SequenceVariation.not_benign).group("genes.id, diseases.id")
                   .select("COUNT(DISTINCT patients.id) AS nof_patients, ARRAY_AGG(DISTINCT patients.id) AS who, (#{_having_cond}) AS sympt_intersect, MIN(patients.age_at_onset) as min_aao, MAX(patients.age_at_onset) as max_aao, diseases.id AS di_id, diseases.abbreviation AS di_name, genes.id AS ge_id, genes.name AS ge_name, ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) AS sym_ids")
                   .having _having_cond
  @possible_diagnoses = Symptom.find_by_sql "SELECT nof_patients, who, min_aao, max_aao, intersec, rcot_patient, rcot_database, di_id, di_name, ge_id, ge_name FROM (SELECT us.nof_patients, us.who, us.min_aao, us.max_aao, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(us.sym_ids) INTERSECT SELECT UNNEST(#{_selected})) t (elem)) AS intersec, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(us.sym_ids) EXCEPT SELECT UNNEST(#{_selected})) t (elem)) AS rcot_patient, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(#{_selected}) EXCEPT SELECT UNNEST(us.sym_ids)) t (elem)) AS rcot_database, us.di_id, us.di_name, us.ge_id, us.ge_name FROM (#{_raw_pd.to_sql}) us) g ORDER BY #{_aao_ordering}CAST((SELECT COUNT(patients_symptoms.*) FROM patients_symptoms WHERE patients_symptoms.present = 't' AND patients_symptoms.symptom_id IN (SELECT UNNEST(g.intersec)) AND patients_symptoms.patient_id IN (SELECT UNNEST(g.who))) AS float)/CAST(nof_patients AS float) DESC, ARRAY_LENGTH(intersec,1) DESC, ARRAY_LENGTH(rcot_patient,1) ASC, ARRAY_LENGTH(rcot_database,1) ASC"
  @impossible_diagnoses = Patient.affected.joins(:disease, :genes, :patients_symptoms)
                                 .where(diseases: {launched: true},
                                        patients_symptoms: {present: true})
                                 .merge(SequenceVariation.not_benign)
                                 .group("genes.id, diseases.id")
                                 .select("diseases.id AS di_id, diseases.abbreviation AS di_name, genes.id AS ge_id, genes.name AS ge_name")
                                 .having "NOT (ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) && #{_selected})"
  render "diagnoses"
else
  @grouped_ss = Symptom.categories.each_with_object(Hash.new) do |(_k, _v), _h|
    _t = Symptom.where(category: _v).order(name: :asc).select(:id, :name).all
    _h[_k.humanize] = _t unless _t.empty?
  end
end
*/
}
