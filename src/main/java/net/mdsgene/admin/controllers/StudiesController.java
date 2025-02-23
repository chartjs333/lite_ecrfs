package net.mdsgene.admin.controllers;

import net.mdsgene.admin.admintool.entities.Disease;
import net.mdsgene.admin.admintool.entities.Gene;
import net.mdsgene.admin.controllers.ChartsData.ПараметрыФильтра;
import org.apache.commons.collections4.map.DefaultedMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//import net.mdsgene.admin.admintool.business.CommonFunctionsHelper;
//import net.mdsgene.admin.admintool.business.SequenceVariationValidator;
//import net.mdsgene.admin.admintool.dal.IAuthorDAO;
//import net.mdsgene.admin.admintool.dal.ICategoryDAO;
//import net.mdsgene.admin.admintool.dal.IChartsSymptomDAO;
//import net.mdsgene.admin.admintool.dal.IDiseaseDAO;
//import net.mdsgene.admin.admintool.dal.IGeneAliasDAO;
//import net.mdsgene.admin.admintool.dal.IGeneDAO;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.dal.IStudyDAO;
//import net.mdsgene.admin.admintool.dal.ISymptomDAO;
//import net.mdsgene.admin.admintool.dal.ISystematicReviewDAO;

@Controller
public class StudiesController {
//	@Autowired IDiseaseDAO diseaseDAO;
//	@Autowired IGeneDAO geneDAO;
//	@Autowired IStudyDAO studyDAO;
//	@Autowired IPatientDAO patientDAO;
//	@Autowired IGeneAliasDAO geneAliasDAO;
//	@Autowired ISystematicReviewDAO systematicReviewDAO;
//	@Autowired ISequenceVariationDAO sequenceVariationDAO;
//	@Autowired IAuthorDAO authorDAO;
//	@Autowired ISymptomDAO symptomDAO;
//	@Autowired ICategoryDAO categoryDAO;
//	@PersistenceContext private EntityManager em;
//	@Autowired CommonFunctionsHelper cfh;
//	@Autowired IChartsSymptomDAO chartsSymptomDAO;
//	@Autowired UploadController uploadController;


	public Map<String, String> colors_LRRK2 = new HashMap<String, String>() { {
		put(map3_1("Ala211Val: het"), "#91e8e1");
		put(map3_1("Arg1441Cys: het"),"#154789");
		put(map3_1("Arg1441Gly: het"),"#434348");
		put(map3_1("Arg1441His: het"),"#f7a35c");
		put(map3_1("Arg1441Ser: het"),"#187422");
		put(map3_1("Arg1514Gln: het"),"#604a7b");
		put(map3_1("Asn1437His: het"),"#e4d354");
		put(map3_1("Asp2175His: het"),"#2b908f");
		put(map3_1("Gln923His: het"),"#f45b5b");
		put(map3_1("Gly2019Ser: het"),"#ac202d");//);
		put(map3_1("Gly2019Ser: hom, het"),"#8B0000");//"#434348");
		put(map3_1("Gly2385Arg: het"),"#2E60A2");
		put(map3_1("Ile1371Val: het"),"#F7A35C");
		put(map3_1("Ile1991Val: het"),"#187422");
		put(map3_1("Ile2012Thr: het"),"#604A7B");
		put(map3_1("Ile2020Thr: het"),"#2B908F");
		put(map3_1("Leu2439Ile: het"),"#F45B5B");
		put(map3_1("Lys616Arg: het"), "#91E8E1");
		put(map3_1("Met1869Thr: het"),"#AC202D");
		put(map3_1("Pro755Leu: het"), "#FF4500");//"#434348");
		put(map3_1("Thr2356Ile: het"),"#1B4789");
		put(map3_1("Tyr1699Cys: het"),"#F7FF5C");
	} };
//	@Value("${spring.datasource.url}")
//	protected String springDatasourceUrl;
	List<String> more_colors;
	public static final int CHART_IGNORE_DB = -100;
	public static final int CHART_LIKE_IT_IS_IN_DB_IGNORE_MOTORS = -99;
	public static final int CHART_LIKE_IT_IS_IN_DB_MOTOR = -1;
	public static final int CHART_LIKE_IT_IS_IN_DB_NON_MOTOR = -2;
	public static Map<String, String> all_countries = all_countries();
	public static Map<String, String> all_countries_code_to_country = all_countries_code_to_country();
//	public Overview overview = new Overview();





	public static class Design {

        private int width;
		private String style;
		private boolean aria_haspopup;
		private String htmlClass;
		private String title;
		private String text;

		public Design(int width, String style, boolean aria_haspopup, String htmlClass, String title, String text) {
			this.setWidth(width);
			this.setStyle(style);
			this.setAria_haspopup(aria_haspopup);
			this.setHtmlClass(htmlClass);
			this.setTitle(title);
			this.setText(text);
        }

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public String getStyle() {
			return style;
		}

		public void setStyle(String style) {
			this.style = style;
		}

		public boolean isAria_haspopup() {
			return aria_haspopup;
		}

		public void setAria_haspopup(boolean aria_haspopup) {
			this.aria_haspopup = aria_haspopup;
		}

		public String getHtmlClass() {
			return htmlClass;
		}

		public void setHtmlClass(String htmlClass) {
			this.htmlClass = htmlClass;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}


	}

	public static class Overview implements java.io.Serializable {

		public Boolean unpublished_gene;
		public Boolean figures_available;
		public boolean benigns_available;
		public String  empty_data_msg;
		public boolean hide_filters;
		public boolean short_version;
		public boolean benign_studies;
		public Gene gene;
		public Disease disease;
		private Integer fc;
		private Integer fc1;
		private Integer fc2;
		private String filterForAAE;
		private String filterForYLC;
		public List<String> filtered_mutations;
		private String filter_mutations_placeholder;
		private String humanized_filter;
		public int total_count = 0;
		private int total_pages = 0;
		public int current_page = 0;
		public int limit_value = 0;
//		public int ccctct;
		private List<String> mu;
		private List<List<String>> studies;
		private String sizeVersion;


		public boolean isStepThreeFile=false;
		public List<List<String>> wholeData;
		private List<TreeSet<String>> wholeDataListofSets;
		private Map<String, ArrayList<String>> filterForTableColumns;
		private List<String> listOfCenter = new ArrayList<>();
		private List<String> selectedValues = new ArrayList<>();
		private Map<String, ArrayList<String>> mapOfOptionsList;
		private List<Object[]> listOfCityObjects;


		private List<Design> designs;
		public boolean filter_by_aao;
		public boolean filter_by_aae;
		public boolean filter_by_ylc;
		private String aao;
		private String aae;
		private String ylc;
		private List<String> aaoRange;
		private List<String> aaeRange;
		private List<String> ylcRange;

		public List<String> filter_criterion;
		public List<String> filter_criterion1;
		private String paginationAppender;
		private List<String> country;
		private boolean plot;
		int repeats;
		private String mutations;


		public List<Object[]> getListOfCityObjects() { return listOfCityObjects; }
		public void setListOfCityObjects(List<Object[]> listOfCityObjects) { this.listOfCityObjects = listOfCityObjects; }
		public List<String> getYlcRange() { return ylcRange; }
		public void setYlcRange(List<String> ylcRange) { this.ylcRange = ylcRange; }
		public String getYlc() { return ylc; }
		public void setYlc(String ylc) { this.ylc = ylc; }
		public String getFilterForYLC() { return filterForYLC; }
		public void setFilterForYLC(String filterForYLC) { this.filterForYLC = filterForYLC; }
		public String getFilterForAAE() { return filterForAAE; }
		public void setFilterForAAE(String filterForAAE) { this.filterForAAE = filterForAAE; }
		public Integer getFc() {
			return fc;
		}
		public void setFc(Integer fc) {
			this.fc = fc;
		}
		public Integer getFc1() {
			return fc1;
		}
		public void setFc1(Integer fc1) {
			this.fc1 = fc1;
		}
		public Integer getFc2() {
			return fc2;
		}
		public void setFc2(Integer fc2) {
			this.fc2 = fc2;
		}
		public String getAao() {
			return aao;
		}
		public void setAao(String aao) {
			this.aao = aao;
		}
		public String getAae() { return aae; }
		public void setAae(String aae) { this.aae = aae; }
		public List<String> getMu() {
			return mu;
		}
		public void setMu(List<String> mu) {
			this.mu = mu;
		}
		public List<Design> getDesigns() {
			return designs;
		}
		public void setDesigns(List<Design> designs) {
			this.designs = designs;
		}
		public List<List<String>> getStudies() {
			return studies;
		}
		public List<List<String>> getWholeData() {
			return wholeData;
		}
		public void setStudies(List<List<String>> studies) {
			this.studies = studies;
		}
		public void setWholeData(List<List<String>> wholeData) {
			this.wholeData = wholeData;
		}

		public String getSizeVersion() {
			return sizeVersion;
		}
		public void setSizeVersion(String sizeVersion) {
			this.sizeVersion = sizeVersion;
		}

		public Map<String, ArrayList<String>> getMapOfOptionsList() {
			return mapOfOptionsList;
		}

		public void setMapOfOptionsList(Map<String, ArrayList<String>> mapOfOptionsList) {
			this.mapOfOptionsList = mapOfOptionsList;
		}

		public List<TreeSet<String>> getWholeDataListofSets() {
			return wholeDataListofSets;
		}

		public void setWholeDataListofSets(List<TreeSet<String>> wholeDataListofSets) {
			this.wholeDataListofSets = wholeDataListofSets;
		}

		public List<String> getSelectedValues() {
			return selectedValues;
		}

		public void setSelectedValues(List<String> selectedValues) {
			this.selectedValues = selectedValues;
		}

		public List<String> getListOfCenter() {
			return listOfCenter;
		}

		public void setListOfCenter(List<String> listOfCenter) {
			this.listOfCenter = listOfCenter;
		}

		public Map<String, ArrayList<String>> getFilterForTableColumns() {
			return filterForTableColumns;
		}

		public void setFilterForTableColumns(Map<String, ArrayList<String>> filterForTableColumns) {
			this.filterForTableColumns = filterForTableColumns;
		}
		public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
		public Disease getDisease() {
			return disease;
		}

		public void setDisease(Disease disease) {
			this.disease = disease;
		}

		public Gene getGene() {
			return gene;
		}

		public void setGene(Gene gene) {
			this.gene = gene;
		}
		public String getFilter_mutations_placeholder() {
			return filter_mutations_placeholder;
		}
		public void setFilter_mutations_placeholder(String filter_mutations_placeholder) {
			this.filter_mutations_placeholder = filter_mutations_placeholder;
		}
		public String getPaginationAppender() {
			return paginationAppender;
		}
		public void setPaginationAppender(String paginationAppender) {
			this.paginationAppender = paginationAppender;
		}
		public boolean isPlot() {
			return plot;
		}
		public void setPlot(boolean plot) {
			this.plot = plot;
		}
		public String getHumanized_filter() {
			return humanized_filter;
		}
		public void setHumanized_filter(String humanized_filter) {
			this.humanized_filter = humanized_filter;
		}
		public int getRepeats() {
			return repeats;
		}
		public void setRepeats(int repeats) {
			this.repeats = repeats;
		}
		public List<String> getAaoRange() {
			return aaoRange;
		}
		public void setAaoRange(List<String> aaoRange) {
			this.aaoRange = aaoRange;
		}
		public List<String> getAaeRange() { return aaeRange; }
		public void setAaeRange(List<String> aaeRange) { this.aaeRange = aaeRange; }
		public List<String> getCountry() {
			return country;
		}
		public void setCountry(List<String> country) {
			this.country = country;
		}
		public void setMessage(String string) {
			// TODO Auto-generated method stub

		}

	}

	public static class Charts {
		List<?> lstRepeatsCount;
		List<?> lstAAOCount;
		List<?> lstDYTorPARKatOneSet;
		List<?> lstBodyPartAffectedByDYT;
		List<?> lstCranocervicalDystonia;

		public List<?> getLstRepeatsCount() {
			return lstRepeatsCount;
		}
		public void setLstRepeatsCount(List<?> lstRepeatsCount) {
			this.lstRepeatsCount = lstRepeatsCount;
		}
		public List<?> getLstAAOCount() {
			return lstAAOCount;
		}
		public void setLstAAOCount(List<?> lstAAOCount) {
			this.lstAAOCount = lstAAOCount;
		}
		public List<?> getLstDYTorPARKatOneSet() {
			return lstDYTorPARKatOneSet;
		}
		public void setLstDYTorPARKatOneSet(List<?> lstDYTorPARKatOneSet) {
			this.lstDYTorPARKatOneSet = lstDYTorPARKatOneSet;
		}
		public List<?> getLstBodyPartAffectedByDYT() {
			return lstBodyPartAffectedByDYT;
		}
		public void setLstBodyPartAffectedByDYT(List<?> lstBodyPartAffectedByDYT) {
			this.lstBodyPartAffectedByDYT = lstBodyPartAffectedByDYT;
		}
		public List<?> getLstCranocervicalDystonia() {
			return lstCranocervicalDystonia;
		}
		public void setLstCranocervicalDystonia(List<?> lstCranocervicalDystonia) {
			this.lstCranocervicalDystonia = lstCranocervicalDystonia;
		}

		// the methods above should be removed
		List<?> lstRace;
		public List<?> lstEthnicity;
		public List<?> lstDiagnosedWithPD;
		public List<?> lstFamilyHistory;
		public List<?> lstDataAlreadyBeenPublished;
		private List<?> lstAao;
		private List<?> lstAvailabilityOfClinicalScales;
		private List<?> lstAvailabilityOfOtherData;
		private List<?> lstAvailabilityOfBiospecimen;
		private List<?> lstEthicsApproval;
		private List<?> lstSubjectsPerGene;
		private List<?> lstFrequencyOfMutations;
		private List<?> lstTypeOfMutations;
		private List<?> lstDigenicCases;

		public List<?> getLstEthicsApproval() {
			return lstEthicsApproval;
		}
		public void setLstEthicsApproval(List<?> lstEthicsApproval) {
			this.lstEthicsApproval = lstEthicsApproval;
		}
		public List<?> getLstAvailabilityOfOtherData() {
			return lstAvailabilityOfOtherData;
		}
		public void setLstAvailabilityOfOtherData(List<?> lstAvailabilityOfOtherData) {
			this.lstAvailabilityOfOtherData = lstAvailabilityOfOtherData;
		}
		public List<?> getLstAao() {
			return lstAao;
		}
		public void setLstAao(List<?> lstAao) {
			this.lstAao = lstAao;
		}
		public List<?> getLstDataAlreadyBeenPublished() {
			return lstDataAlreadyBeenPublished;
		}
		public void setLstDataAlreadyBeenPublished(List<?> lstDataAlreadyBeenPublished) {
			this.lstDataAlreadyBeenPublished = lstDataAlreadyBeenPublished;
		}
		public List<?> getLstRace() {
			return lstRace;
		}
		public void setLstRace(List<?> lstRace) {
			this.lstRace = lstRace;
		}
		public List<?> getLstEthnicity() {
			return lstEthnicity;
		}
		public void setLstEthnicity(List<?> lstEthnicity) {
			this.lstEthnicity = lstEthnicity;
		}
		public List<?> getLstDiagnosedWithPD() {
			return lstDiagnosedWithPD;
		}
		public void setLstDiagnosedWithPD(List<?> lstDiagnosedWithPD) {
			this.lstDiagnosedWithPD = lstDiagnosedWithPD;
		}
		public List<?> getLstFamilyHistory() {
			return lstFamilyHistory;
		}
		public void setLstFamilyHistory(List<?> lstFamilyHistory) {
			this.lstFamilyHistory = lstFamilyHistory;
		}
		public List<?> getLstAvailabilityOfClinicalScales() {
			return lstAvailabilityOfClinicalScales;
		}
		public void setLstAvailabilityOfClinicalScales(List<?> lstAvailabilityOfClinicalScales) {
			this.lstAvailabilityOfClinicalScales = lstAvailabilityOfClinicalScales;
		}
		public List<?> getLstAvailabilityOfBiospecimen() {
			return lstAvailabilityOfBiospecimen;
		}
		public void setLstAvailabilityOfBiospecimen(List<?> lstAvailabilityOfBiospecimen) {
			this.lstAvailabilityOfBiospecimen = lstAvailabilityOfBiospecimen;
		}
		public List<?> getLstSubjectsPerGene() {
			return lstSubjectsPerGene;
		}
		public void setLstSubjectsPerGene(List<?> lstSubjectsPerGene) {
			this.lstSubjectsPerGene = lstSubjectsPerGene;
		}
		public List<?> getLstFrequencyOfMutations() {
			return lstFrequencyOfMutations;
		}
		public void setLstFrequencyOfMutations(List<?> lstFrequencyOfMutations) {
			this.lstFrequencyOfMutations = lstFrequencyOfMutations;
		}
		public List<?> getLstTypeOfMutations() {
			return lstTypeOfMutations;
		}
		public void setLstTypeOfMutations(List<?> lstTypeOfMutations) {
			this.lstTypeOfMutations = lstTypeOfMutations;
		}
		public List<?> getLstDigenicCases() {
			return lstDigenicCases;
		}
		public void setLstDigenicCases(List<?> lstDigenicCases) {
			this.lstDigenicCases = lstDigenicCases;
		}

	}

//	@GetMapping("/update/benign/genes")
//	public String updateBenignGenes(ModelMap model) {
//		File[] list = new File(BaseController.BENIGN_FILES_FOLDER).listFiles();
//		for(File f : list) f.delete();
//		if (new File(BaseController.BENIGN_FILES_FOLDER).listFiles().length == 0) {
//			uploadController.process_tsv(null, null, null, 1, "benign list");
//		}
//		return "redirect:/g4d";
//	}

	@GetMapping("/d/{selected_disease_id}/gu/{selected_gene_id}")
	public String overviewUnpublished(ModelMap model,
			@PathVariable("selected_disease_id") Integer selected_disease_id,
			@PathVariable("selected_gene_id") Integer selected_gene_id,
			@RequestParam(name="fc",required = false) Integer fc,
			@RequestParam(name="aao",required = false) String aao,
			@RequestParam(name="aae",required = false) String aae,
			@RequestParam(name="ylc",required = false) String ylc,
			@RequestParam(name="mu",required = false) List<String> mut_restrict,
			@RequestParam(name="fc1",required = false) Integer fc1,
			@RequestParam(name="fc2",required = false) Integer fc2,
			@RequestParam(name="filterForAAE",required = false) String filterForAAE,
			@RequestParam(name="filterForYLC",required = false) String filterForYLC,
			@RequestParam(name="country",required = false) List<String> country,
			@RequestParam(name="p",required = false) Integer p,
			@RequestParam(name="action",required = false) String action,
			@RequestParam(name="selectedValues",required = false) List<String> selectedValues,
			java.security.Principal principal){
		// please delete all files in the cache by uploading a new gene otherwise this part will be wrong

if(principal == null || StringUtils.isEmpty(principal.getName())) return "redirect:/user/sign_in";
		boolean benign_data = false;
		ПараметрыФильтра параметрыФильтра = new ПараметрыФильтра(fc, fc1, aao, country);
		Overview overview = new Overview();

		// Creating AAE range
		List<String> aaeRangeList = new ArrayList<>();
		for (int i = 0; i < 120; i++){
			aaeRangeList.add(Integer.toString(i));
		}
		overview.setAaeRange(aaeRangeList);


		if (filterForAAE != null) {
			overview.setFilterForAAE(filterForAAE);
		}
		if (aae != null){
			overview.setAae(aae);
		}

		// Creating YLC range
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		List<String> ylcRangeList = new ArrayList<>();
		for (int i = 1991; i < currentYear; i++){
			ylcRangeList.add(Integer.toString(i));
		}
		overview.setYlcRange((ylcRangeList));

		if (filterForYLC != null) {
			overview.setFilterForYLC(filterForYLC);
		}
		if (ylc != null){
			overview.setYlc(ylc);
		}


		if (selectedValues != null){
			//this if statement concates the strings from selected values, that had ',' and because of that comma the values came in wrong way
//			for (int i = 0; i < selectedValues.size(); i++){
//				selectedValues.set(i, selectedValues.get(i).replace("%2c", ","));
//			}

			if (selectedValues.size() > 1){
				int k = selectedValues.size();
				for (int i = 0; i < k-1; i++){
					if (selectedValues.get(i).contains("#") && !selectedValues.get(i+1).contains("#")){
						selectedValues.set(i, selectedValues.get(i) + ", " + selectedValues.get(i+1));
						selectedValues.remove(i+1);
						i=i-1;
						k=k-1;
					}
				}
			}

			overview.setSelectedValues(selectedValues);
		}

		//casting into a map from filter, where keys are titles, and values are list of selected parameters
		if (selectedValues != null){
			Map<String, ArrayList<String>> map = new HashMap<>();
			for (String string: selectedValues){
				String[] arrSplit = string.split("#");
				if (map.containsKey(arrSplit[0])){
					map.get(arrSplit[0]).add(arrSplit[1]);
				}
				else {
					map.put(arrSplit[0], new ArrayList<>());
					ArrayList<String> list = map.get(arrSplit[0]);
					list.add(arrSplit[1]);
				}
			}
			overview.setFilterForTableColumns(map);
		}

		overview.unpublished_gene = true;
		if (benign_data) {
			overview.figures_available = false;
			overview.hide_filters = true;
			overview.benign_studies = true;
		} else {
			//unpublished data
			overview.figures_available = true;
			overview.hide_filters = false;
			overview.benign_studies = false;
		}

		IOverview proxy = new UnpublishedData();
		overview.setMu(mut_restrict);
		proxy.readGeneDiseaseNames(overview, fc, aao, selected_gene_id, selected_disease_id);
        proxy.readFilters(overview, selected_gene_id, fc, fc1, fc2, aao, mut_restrict, country);

        Function<List<String>, List<String>> обработка_данных = ("plot".equals(action)) ? null : (_данныe) -> {
        	if ("ethnicity*".equals(_данныe.get(0)) || "data_already_been_published*".equals(_данныe.get(0))) {
        		_данныe = _данныe.stream().map((_значение) -> "n.a.".equals(_значение) ? "not specified" : _значение).collect(Collectors.toList());
        	}
        	if ("race_all*".equals(_данныe.get(0))) {
        		_данныe = _данныe.stream().map((_значение) -> {
        			switch (StringUtils.remove(_значение, " ")) {
						case "AI": return "American Indian";
						case "AS": return "Asian";
						case "BK/AA": return "Black or African American";
						case "PI/NH": return "Pacific Islander or native Hawaian";
						case "W": return "White";
						default: return _значение;
					}
        		}).collect(Collectors.toList());
        	}
        	if ("country_of_origin*".equals(_данныe.get(0))) {
        		_данныe = _данныe.stream().map((_значение) ->
        			all_countries_code_to_country.getOrDefault(StringUtils.remove(_значение, " "), _значение)
        		).collect(Collectors.toList());
        	}
			return _данныe;
		};

        proxy.readPublications(overview, p, параметрыФильтра, selected_gene_id, обработка_данных);
        proxy.buildPaginationAppender(overview, fc, aao, mut_restrict, country);

		model.addAttribute("overview", overview);

		model.addAttribute("available_countries", all_countries);

//	    model.addAttribute("country", overview.country == null || overview.country.isEmpty() ? null : overview.country.stream().map(x -> all_countries().get(x)).collect(Collectors.joining(",")));


        if ("plot".equals(action)) {
        	IChartsData cd = new ChartsData();
        	Charts charts = new Charts();

			cd.readRepeatsCount(charts, параметрыФильтра, selected_gene_id, selected_disease_id, overview.repeats, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
			cd.readAAOCount(charts, параметрыФильтра, selected_gene_id, selected_disease_id, overview.repeats, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());


//			cd.readDYTorPARKatOneSet(charts, fc, selected_gene_id, selected_disease_id, overview.repeats);
//			if (charts.lstDYTorPARKatOneSet.size() == 3) {
//				String web_attr = "dyt_or_park";
//				List<?> web_param = charts.lstDYTorPARKatOneSet;
//				String prefix = "dyt_or_park_";
//				Object[] data = new Object[] {new Object[] {"DYT", web_param.get(0)}, new Object[] {"PARK", web_param.get(1)}};
//				int missing_data_index = 2;
//
//				if (overview.total_count != 0) {
//					model.addAttribute(web_attr, data);
//					Float missing = Float.valueOf(web_param.get(missing_data_index).toString());
//					model.addAttribute(prefix + "missing", missing);
//					model.addAttribute(prefix + "missing_percent", overview.total_count == 0 ? "0.00" : new DecimalFormat("0.00").format(missing*100/overview.total_count).replace(",", "."));
//				}
//			}

			for (int паркинсон = 0; паркинсон < 2; паркинсон++) {
				cd.readSubjectsPerGene(charts, параметрыФильтра, overview.getMu(), паркинсон > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());//ввв - возраст возникновения заболевания
				Supplier<Boolean> условия_действительности_данных_для_субект_про_ген = () -> { return charts.lstSubjectsPerGene != null; };
				Supplier<Object[][]> обработка_данных_полученных_с_сервера_для_субект_про_ген = () -> {
//					List<Object> _result = new ArrayList<>();
					int count = 0;
					for (Object el : charts.lstSubjectsPerGene) {
						if (!"-99".equals(((List<?>)el).get(0).toString())) {
							count++;
						}
					}
					Object[][] _result = new Object[count][2];
					int index = 0;
					for (Object el : charts.lstSubjectsPerGene) {
						if (!"-99".equals(((List<?>)el).get(0).toString())) {
							_result[index][0] = ((List<?>)el).get(0);
							_result[index][1] = ((List<?>)el).get(1);
							index++;
						}
					}
					return _result;
				};
				Float колличество_пациентов_с_неизвестным_субект_про_ген = 0f;
				String название_графика  = (паркинсон == 0 ? "subjects_per_gene" : "subjects_per_gene_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_субект_про_ген, название_графика,
						обработка_данных_полученных_с_сервера_для_субект_про_ген, колличество_пациентов_с_неизвестным_субект_про_ген);


				int общее_колличество_пациентов_с_известным_субект_про_ген = 0;
				for (Object el : charts.lstSubjectsPerGene) {
					if (!"-99".equals(((List<?>)el).get(0).toString())) {
						общее_колличество_пациентов_с_известным_субект_про_ген =  общее_колличество_пациентов_с_известным_субект_про_ген + Integer.valueOf(((List<?>)el).get(1).toString());
					}
				}
				название_графика  = (паркинсон == 0 ? "subjects_per_gene_total" : "subjects_per_gene_total_healthy");
				model.addAttribute(название_графика, общее_колличество_пациентов_с_известным_субект_про_ген);
			}


			for (int паркинсон = 0; паркинсон < 2; паркинсон++) {
				//считываем информацию по рассе
				cd.readRace(charts, параметрыФильтра, overview.getMu(), паркинсон > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				//если информация присутствует
				Supplier<Boolean> условия_действительности_данных_для_рассы = () -> { return charts.lstRace.size() == 6; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_для_рассы = () -> {
				   Object[] рассы = new Object[] {new Object[] {"American Indian", charts.lstRace.get(0)},
							  new Object[] {"Asian", charts.lstRace.get(1)},
							  new Object[] {"Black or African American", charts.lstRace.get(2)},
							  new Object[] {"Pacific Islander<br/> or native Hawaian", charts.lstRace.get(3)},
							  new Object[] {"White", charts.lstRace.get(4)}};
					//здесь мы удаляем все рассы с значением колличества равным 0.0
					for (int индекс_рассы = 4; индекс_рассы > -1; индекс_рассы--) {
						String колличество = (String) charts.lstRace.get(индекс_рассы);
						if (NumberUtils.isParsable(колличество) && Double.parseDouble(колличество) == 0) {
							рассы = ArrayUtils.remove(рассы, индекс_рассы);
						}
					}
				   return рассы;
				};
				Float колличество_пациентов_с_неизвестнои_рассои = Float.valueOf(charts.lstRace.get(5).toString());
				String название_графика = (паркинсон == 0 ? "race_all" : "race_all_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_рассы, название_графика, обработка_данных_полученных_с_сервера_для_рассы, колличество_пациентов_с_неизвестнои_рассои);

				cd.readEthnicity(charts, параметрыФильтра, overview.getMu(), паркинсон > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_этноса = () -> { return charts.lstEthnicity.size() == 19; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_для_этноса = () -> {
					Object[] етносы = new Object[] {new Object[] {"Askhenazi Jewish", charts.lstEthnicity.get(0)},
							new Object[] {"Arabic", charts.lstEthnicity.get(1)},
							new Object[] {"Avar", charts.lstEthnicity.get(2)},
							new Object[] {"Berber", charts.lstEthnicity.get(3)},
							new Object[] {"Chechen", charts.lstEthnicity.get(4)},
							new Object[] {"Cuban", charts.lstEthnicity.get(5)},
							new Object[] {"Domenican", charts.lstEthnicity.get(6)},
							new Object[] {"Hispanic/Mestizo<br/>Latino", charts.lstEthnicity.get(7)},
							new Object[] {"Jewish", charts.lstEthnicity.get(8)},
							new Object[] {"Kurdish", charts.lstEthnicity.get(9)},
							new Object[] {"Ossetian", charts.lstEthnicity.get(10)},
							new Object[] {"Mixed ancestry", charts.lstEthnicity.get(11)},
							new Object[] {"American Indian", charts.lstEthnicity.get(12)},
							new Object[] {"Asian", charts.lstEthnicity.get(13)},
							new Object[] {"Black or African American", charts.lstEthnicity.get(14)},
							new Object[] {"Pacific Islander<br/> or native Hawaian", charts.lstEthnicity.get(15)},
							new Object[] {"White", charts.lstEthnicity.get(16)},
							new Object[] {"African", charts.lstEthnicity.get(17)},
					};
					//здесь мы удаляем все этносы с значением колличества равным 0.0
					for (int индекс_этноса = 17; индекс_этноса > -1; индекс_этноса--) {
						String колличество = (String) charts.lstEthnicity.get(индекс_этноса);
						if (NumberUtils.isParsable(колличество) && Double.parseDouble(колличество) == 0) {
							етносы = ArrayUtils.remove(етносы, индекс_этноса);
						}
					}
					return етносы;
				};

				название_графика = (паркинсон == 0 ? "ethnicity_all" : "ethnicity_all_healthy");
				Float колличество_пациентов_с_неизвестным_этносом = Float.valueOf(charts.lstEthnicity.get(18).toString());
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_этноса, название_графика, обработка_данных_полученных_с_сервера_для_этноса, колличество_пациентов_с_неизвестным_этносом);
			}

//			cd.readDiagnosedWithPD(charts, fc, overview.getMu());
//			Supplier<Boolean> условия_действительности_данных_для_диагноза_с_пд = () -> { return charts.lstDiagnosedWithPD.size() == 3; };
//			Supplier<Object[]> обработка_данных_полученных_с_сервера_для_диагноза_с_пд = () -> {
//			   return new Object[] {new Object[] {"Yes", charts.lstDiagnosedWithPD.get(0)},
//					   new Object[] {"No", charts.lstDiagnosedWithPD.get(1)}};
//			};
//
//			Float колличество_пациентов_с_для_диагнозом_с_пд = Float.valueOf(charts.lstDiagnosedWithPD.get(2).toString());
//			данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_диагноза_с_пд, "diagnosed_with_pd",
//					обработка_данных_полученных_с_сервера_для_диагноза_с_пд, колличество_пациентов_с_для_диагнозом_с_пд);


			cd.readAAO(charts, параметрыФильтра, overview.getMu(), overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc()); //ввв - возраст возникновения заболевания
			Supplier<Boolean> условия_действительности_данных_для_ввз = () -> { return charts.lstAao != null; };
			Supplier<Object[][]> обработка_данных_полученных_с_сервера_для_ввз = () -> {
//				List<Object> _result = new ArrayList<>();
				int count = 0;
				for (Object el : charts.lstAao) {
					if (!"-99".equals(((List<?>)el).get(0).toString())) {
						count++;
					}
				}
				Object[][] _result = new Object[count][2];
				int index = 0;
				for (Object el : charts.lstAao) {
					if (!"-99".equals(((List<?>)el).get(0).toString())) {
						_result[index][0] = ((List<?>)el).get(0);
						_result[index][1] = ((List<?>)el).get(1);
						index++;
					}
				}
				return _result;
			};
			Float колличество_пациентов_с_неизвестным_ввз = 0f;
			for (Object el : charts.lstAao) {
				if ("-99".equals(((List<?>)el).get(0).toString())) {
					колличество_пациентов_с_неизвестным_ввз = Float.valueOf(((List<?>)el).get(1).toString());
				}
			}
			данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_ввз, "aao",
					обработка_данных_полученных_с_сервера_для_ввз, колличество_пациентов_с_неизвестным_ввз);


			for (int паркинсон1 = 0; паркинсон1 < 2; паркинсон1++) {
				cd.readFamiltyHistory(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_истории_семьи = () -> { return charts.lstFamilyHistory.size() == 3; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_для_истории_семьи = () -> {
					Object[] да_нет = new Object[] {new Object[] {"Yes", charts.lstFamilyHistory.get(0)},
													new Object[] {"No", charts.lstFamilyHistory.get(1)}};
					//здесь мы удаляем все да_нет с значением колличества равным 0.0
					for (int индекс_да_нет = 1; индекс_да_нет > -1; индекс_да_нет--) {
						String колличество = (String) charts.lstFamilyHistory.get(индекс_да_нет);
						if (NumberUtils.isParsable(колличество) && Double.parseDouble(колличество) == 0) {
							да_нет = ArrayUtils.remove(да_нет, индекс_да_нет);
						}
					}
					return да_нет;
				};

				Float колличество_пациентов_с_неизвестной_историей_семьи = Float.valueOf(charts.lstFamilyHistory.get(2).toString());
				String название_графика = (паркинсон1 == 0 ? "family_history" : "family_history_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_истории_семьи, название_графика, обработка_данных_полученных_с_сервера_для_истории_семьи, колличество_пациентов_с_неизвестной_историей_семьи);

				cd.readDataAlreadyBeenPublished(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_данные_уже_были_опубликованны = () -> { return charts.lstDataAlreadyBeenPublished.size() == 3; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_данные_уже_были_опубликованны = () -> {
					   Object[] да_нет = new Object[] {new Object[] {"Yes", charts.lstDataAlreadyBeenPublished.get(0)},
							   new Object[] {"No", charts.lstDataAlreadyBeenPublished.get(1)},
							   new Object[] {"Not specified", charts.lstDataAlreadyBeenPublished.get(2)},
							   };
						//здесь мы удаляем все да_нет с значением колличества равным 0.0
						for (int индекс_да_нет = 1; индекс_да_нет > -1; индекс_да_нет--) {
							String колличество = (String) charts.lstDataAlreadyBeenPublished.get(индекс_да_нет);
							if (NumberUtils.isParsable(колличество) && Double.parseDouble(колличество) == 0) {
								да_нет = ArrayUtils.remove(да_нет, индекс_да_нет);
							}
						}
					    return да_нет;
					};

				название_графика = (паркинсон1 == 0 ? "data_already_been_published" : "data_already_been_published_healthy");
				Float колличество_пациентов_с_неизвестной_информацией_о_том_что_данные_уже_были_опубликованны = 0.0f;//Float.valueOf(charts.lstDataAlreadyBeenPublished.get(2).toString());
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_данные_уже_были_опубликованны, название_графика, обработка_данных_полученных_с_сервера_данные_уже_были_опубликованны, колличество_пациентов_с_неизвестной_информацией_о_том_что_данные_уже_были_опубликованны);

				cd.readTypeOfMutation(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_типа_мутаций = () -> { return charts.lstTypeOfMutations.size() == 6; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_для_типа_мутаций = () -> {
					   Object[] типы_мутаций = new Object[] {
								   new Object[] {"recessive/monoallelic", charts.lstTypeOfMutations.get(0)},
								   new Object[] {"recessive/biallelic", charts.lstTypeOfMutations.get(1)},
								   new Object[] {"dominant/monoallelic", charts.lstTypeOfMutations.get(2)},
								   new Object[] {"dominant/biallelic", charts.lstTypeOfMutations.get(3)},
								   new Object[] {"dominant/digenic", charts.lstTypeOfMutations.get(4)},
								   new Object[] {"Other", charts.lstTypeOfMutations.get(5)},
							   };
						for (int индекс_типа_мутаций = 5; индекс_типа_мутаций > -1; индекс_типа_мутаций--) {
							String колличество = (String) charts.lstTypeOfMutations.get(индекс_типа_мутаций);
							if (NumberUtils.isParsable(колличество) && Double.parseDouble(колличество) == 0) {
								типы_мутаций = ArrayUtils.remove(типы_мутаций, индекс_типа_мутаций);
							}
						}
					   return типы_мутаций;
					};

				int наибольшее_колличество_пациентов_для_типа_мутаций = 0;
				название_графика = (паркинсон1 == 0 ? "type_of_mutation" : "type_of_mutation_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_типа_мутаций,
						название_графика,
						обработка_данных_полученных_с_сервера_для_типа_мутаций, наибольшее_колличество_пациентов_для_типа_мутаций);


				cd.readDigenicCases(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_дигеник_случаев = () -> { return charts.lstDigenicCases.size() == 39; };
				Supplier<Object[]> обработка_данных_полученных_с_сервера_для_дигеник_случаев = () -> {
					   Object[] все_типы_дигеник = new Object[] {
							   new Object[] {"GCH1 (p.Pro69Leu), GBA (p.Glu365Lys)", charts.lstDigenicCases.get(0)},
							   new Object[] {"GCH1 (p.Val204Ile), GBA (p.Thr408Met)", charts.lstDigenicCases.get(1)},
							   new Object[] {"LRRK2 (p.Arg1067Gln), Parkin (p.Arg275Trp)", charts.lstDigenicCases.get(2)},
							   new Object[] {"LRRK2 (p.Arg1441His), GBA (p.Leu483Pro)", charts.lstDigenicCases.get(3)},
							   new Object[] {"LRRK2 (p.Arg1441Ser), GBA (p.Glu365Lys)", charts.lstDigenicCases.get(4)},
							   new Object[] {"LRRK2 (p.Arg1514Gln), ATP13A2 (c.*130C>T)", charts.lstDigenicCases.get(5)},
							   new Object[] {"LRRK2 (p.Arg1514Gln), GBA (p.Asn409Ser)", charts.lstDigenicCases.get(6)},
							   new Object[] {"LRRK2 (p.Arg1514Gln), GBA (p.Glu365Lys)", charts.lstDigenicCases.get(7)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Arg535His)", charts.lstDigenicCases.get(8)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Arg83Cys)", charts.lstDigenicCases.get(9)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Asn409Ser)", charts.lstDigenicCases.get(10)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Glu365Lys)", charts.lstDigenicCases.get(11)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Leu483Pro)", charts.lstDigenicCases.get(12)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Thr408Met)", charts.lstDigenicCases.get(13)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GBA (p.Val499Leu)", charts.lstDigenicCases.get(14)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), GIGYF2 (p.His1192Arg)", charts.lstDigenicCases.get(15)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), Parkin (c.(534+1_535-1)_(734+1_735-1)del)", charts.lstDigenicCases.get(16)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), Parkin (c.(171+1_172-1)_(412+1_413-1)del)", charts.lstDigenicCases.get(17)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), Parkin (c.(7+1_8-1)_(171+1_172-1)[3])", charts.lstDigenicCases.get(18)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), Parkin (p.Ala398Thr)", charts.lstDigenicCases.get(19)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), Parkin (p.Arg402Cys)", charts.lstDigenicCases.get(20)},
							   new Object[] {"LRRK2 (p.Gly2019Ser), POLG (p.Asp122Glu)", charts.lstDigenicCases.get(21)},
							   new Object[] {"LRRK2 (p.Leu1034Val), GCH1 (p.Ile193Thr)", charts.lstDigenicCases.get(22)},
							   new Object[] {"Parkin (c.(7+1_8-1)_(171+1_172-1)del), POLG (p.Gly737Arg)", charts.lstDigenicCases.get(23)},
							   new Object[] {"Parkin (c.(7+1_8-1)_(171+1_172-1)dup), GBA (p.Thr408Met)", charts.lstDigenicCases.get(24)},
							   new Object[] {"Parkin (p.Arg275Trp), GBA (p.Asn409Ser)", charts.lstDigenicCases.get(25)},
							   new Object[] {"Parkin (p.Arg275Trp), GBA (p.Glu365Lys)", charts.lstDigenicCases.get(26)},
							   new Object[] {"Parkin (p.Arg275Trp), GBA (p.Thr408Met)", charts.lstDigenicCases.get(27)},
							   new Object[] {"Parkin (p.Glu310Asp), SPR (p.Ser213Thr)", charts.lstDigenicCases.get(28)},
							   new Object[] {"PINK1 (c.1252-2_1272delGCAGGTGTCCACGGCCCGTCCTG), Parkin (p.Arg402Cys)", charts.lstDigenicCases.get(29)},
							   new Object[] {"PINK1 (c.676-2A>G), GBA (p.Leu307Leu)", charts.lstDigenicCases.get(30)},
							   new Object[] {"PINK1 (p.Ala383Thr), GBA (p.Leu483Pro)", charts.lstDigenicCases.get(31)},
							   new Object[] {"PINK1 (p.Arg276Gln), GBA (p.Thr408Met)", charts.lstDigenicCases.get(32)},
							   new Object[] {"PINK1 (p.Thr538Pro), Parkin (p.Arg366Trp)", charts.lstDigenicCases.get(33)},
							   new Object[] {"PINK1 (p.Val350Leu), SYNJ1 (p.Ala551Val)", charts.lstDigenicCases.get(34)},
							   new Object[] {"TOR1A (p.Leu270Phe), POLG (p.Tyr732Cys)", charts.lstDigenicCases.get(35)},
							   new Object[] {"TOR1A (p.Phe205Ile), GBA (p.Thr408Met)", charts.lstDigenicCases.get(36)},
							   new Object[] {"VPS35 (p.Pro316Ser), GBA (p.Thr408Met)", charts.lstDigenicCases.get(37)}
						   };

					    List[] метки = new List[] {
						    Arrays.asList("GCH1/GBA", new int[] {2,3}),
						    Arrays.asList("LRRK2/ATP13A2", new int[] {7}),
						    Arrays.asList("LRRK2/GBA", new int[] {5,6,8,9,10,11,12,13,14,15,16}),
						    Arrays.asList("LRRK2/GCH1", new int[] {24}),
						    Arrays.asList("LRRK2/GIGYF", new int[] {17}),
						    Arrays.asList("LRRK2/Parkin", new int[] {4,18,19,20,21,22}),
						    Arrays.asList("LRRK2/POLG", new int[] {23}),
						    Arrays.asList("Parkin/GBA", new int[] {26,27,28,29}),
						    Arrays.asList("Parkin/POLG", new int[] {25}),
						    Arrays.asList("Parkin/SPR", new int[] {30}),
						    Arrays.asList("PINK1/GBA", new int[] {32,33,34}),
						    Arrays.asList("PINK1/Parkin", new int[] {31,35}),
						    Arrays.asList("PINK1/SYNJ", new int[] {36}),
						    Arrays.asList("TOR1A/GBA", new int[] {38}),
						    Arrays.asList("TOR1A/POLG", new int[] {37}),
						    Arrays.asList("VPS35/GBA", new int[] {39}),
					    };

					    Object[] типы_меток = new Object[0];

						for (int индекс_типы_меток = 15; индекс_типы_меток > -1; индекс_типы_меток--) {
							List<?> меткa = метки[индекс_типы_меток];

							//эксеолвские_индексы нужно вычесть 2 потому как данные взяты из эксела (то есть нулевая страка начинается с 2-х)
							int[] эксеолвские_индексы = (int[])меткa.get(1);
							String текст_метки = (String) меткa.get(0);
							int значение = IntStream.range(0, эксеолвские_индексы.length).map(_индекс -> Double.valueOf((String) charts.lstDigenicCases.get(эксеолвские_индексы[_индекс]-2)).intValue()).sum();
							String описание = IntStream.range(0, эксеолвские_индексы.length).mapToObj(_индекс -> все_типы_дигеник[эксеолвские_индексы[_индекс]-2]).collect(Collectors.toList()).stream().
									map(_элемент -> (Object[])_элемент).filter(_элемент -> Double.valueOf(_элемент[1].toString()).intValue() > 0).map(_элемент -> _элемент[0] + ": " + Double.valueOf(_элемент[1].toString()).intValue()).collect(Collectors.joining("<br/>"));

							типы_меток = ArrayUtils.add(типы_меток, new Object[] {текст_метки, значение, описание});
						}

						for (int индекс_типы_меток = типы_меток.length - 1; индекс_типы_меток > -1; индекс_типы_меток--) {
							int колличество = (int) ((Object[])типы_меток[индекс_типы_меток])[1];
							if (колличество == 0) {
								типы_меток = ArrayUtils.remove(типы_меток, индекс_типы_меток);
							}
						}
				       return типы_меток;
					};

				int наибольшее_колличество_пациентов_для_дигеник_случаев = 0;
				название_графика = (паркинсон1 == 0 ? "digenic_cases" : "digenic_cases_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_дигеник_случаев,
						название_графика,
						обработка_данных_полученных_с_сервера_для_дигеник_случаев, наибольшее_колличество_пациентов_для_дигеник_случаев);


				cd.readAvailabilityOfClinicalScales(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_наличия_клинических_шкал = () -> { return charts.lstAvailabilityOfClinicalScales.size() == 3; };
				Supplier<List<?>> обработка_данных_полученных_с_сервера_для_наличия_клинических_шкал = () -> {
					   return charts.lstAvailabilityOfClinicalScales;
					};

				int наибольшее_колличество_пациентов_для_наличия_клинических_шкал = 0;
				if (условия_действительности_данных_для_наличия_клинических_шкал.get()) {
					for (Object el : charts.lstAvailabilityOfClinicalScales) {
						//пруи возвращение данных в одном из 3х мапов содержится переменная
						//которя показывает наибольшее колличество симптомов
						Map<String, Object> map = (Map<String,Object>) el;
						if (map.containsKey("_наибольшее_колличество_пациентов_с_симптомом")) {
							наибольшее_колличество_пациентов_для_наличия_клинических_шкал = (int) map.get("_наибольшее_колличество_пациентов_с_симптомом");
							map.remove("_наибольшее_колличество_пациентов_с_симптомом");
							break;
						}
					}
				}
				название_графика = (паркинсон1 == 0 ? "availability_of_clinical_scales" : "availability_of_clinical_scales_healthy");
				данные_для_графика_колонок(model, overview, charts, условия_действительности_данных_для_наличия_клинических_шкал,
						название_графика,
						обработка_данных_полученных_с_сервера_для_наличия_клинических_шкал, наибольшее_колличество_пациентов_для_наличия_клинических_шкал);

				cd.readAvailabilityOfOtherData(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
				Supplier<Boolean> условия_действительности_данных_для_других_данных = () -> { return charts.lstAvailabilityOfOtherData.size() == 3; };
				Supplier<List<?>> обработка_данных_полученных_с_сервера_для_наличия_других_данных = () -> {
					   return charts.lstAvailabilityOfOtherData;
					};

				int наибольшее_колличество_пациентов_с_наличием_других_данных = 0;
				if (условия_действительности_данных_для_других_данных.get()) {
					for (Object el : charts.lstAvailabilityOfOtherData) {
						//пруи возвращение данных в одном из 3х мапов содержится переменная
						//которя показывает наибольшее колличество симптомов
						Map<String, Object> map = (Map<String,Object>) el;
						if (map.containsKey("_наибольшее_колличество_пациентов_с_симптомом")) {
							наибольшее_колличество_пациентов_с_наличием_других_данных = (int) map.get("_наибольшее_колличество_пациентов_с_симптомом");
							map.remove("_наибольшее_колличество_пациентов_с_симптомом");
							break;
						}
					}
				}
				название_графика = (паркинсон1 == 0 ? "availability_of_other_data" : "availability_of_other_data_healthy");
				данные_для_графика_колонок(model, overview, charts, условия_действительности_данных_для_других_данных,
						название_графика,
						обработка_данных_полученных_с_сервера_для_наличия_других_данных, наибольшее_колличество_пациентов_с_наличием_других_данных);

				cd.readFrequencyOfMutations(charts, параметрыФильтра, overview.getMu(), паркинсон1 > 0, overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc()); //ввв - возраст возникновения заболевания
				Supplier<Boolean> условия_действительности_данных_для_частот_мутаций = () -> { return charts.lstFrequencyOfMutations != null; };
				Supplier<Object[][]> обработка_данных_полученных_с_сервера_для_частот_мутаций = () -> {
//					List<Object> _result = new ArrayList<>();
					int count = 0;
					for (Object el : charts.lstFrequencyOfMutations) {
						if (!"-99".equals(((List<?>)el).get(0).toString())) {
							count++;
						}
					}
					Object[][] _result = new Object[count][2];
					int index = 0;
					for (Object el : charts.lstFrequencyOfMutations) {
						if (!"-99".equals(((List<?>)el).get(0).toString())) {
							_result[index][0] = ((List<?>)el).get(0);
							_result[index][1] = ((List<?>)el).get(1);
							index++;
						}
					}
					return _result;
				};
				Float колличество_пациентов_с_неизвестным_частот_мутаций = 0f;
				for (Object el : charts.lstFrequencyOfMutations) {
					if ("-99".equals(((List<?>)el).get(0).toString())) {
						колличество_пациентов_с_неизвестным_частот_мутаций = Float.valueOf(((List<?>)el).get(1).toString());
					}
				}
				название_графика = (паркинсон1 == 0 ? "frequency_of_mutations" : "frequency_of_mutations_healthy");
				данные_для_паи_графика(model, overview, charts, условия_действительности_данных_для_частот_мутаций, название_графика,
						обработка_данных_полученных_с_сервера_для_частот_мутаций, колличество_пациентов_с_неизвестным_частот_мутаций);
			}

			cd.readAvailabilityOfBiospecimen(charts, параметрыФильтра, overview.getMu(), overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());
			Supplier<Boolean> условия_действительности_данных_для_наличием_биоэкземпляра = () -> { return charts.lstAvailabilityOfBiospecimen.size() == 3; };
			Supplier<List<?>> обработка_данных_полученных_с_сервера_для_наличием_биоэкземпляра = () -> {
				   return charts.lstAvailabilityOfBiospecimen;
				};

			int наибольшее_колличество_пациентов_с_наличием_биоэкземпляра = 0;
			if (условия_действительности_данных_для_наличием_биоэкземпляра.get()) {
				for (Object el : charts.lstAvailabilityOfBiospecimen) {
					//пруи возвращение данных в одном из 3х мапов содержится переменная
					//которя показывает наибольшее колличество симптомов
					Map<String, Object> map = (Map<String,Object>) el;
					if (map.containsKey("_наибольшее_колличество_пациентов_с_симптомом")) {
						наибольшее_колличество_пациентов_с_наличием_биоэкземпляра = (int) map.get("_наибольшее_колличество_пациентов_с_симптомом");
						map.remove("_наибольшее_колличество_пациентов_с_симптомом");
						break;
					}
				}
			}
			данные_для_графика_колонок(model, overview, charts, условия_действительности_данных_для_наличием_биоэкземпляра,
					"availability_of_biospecimen",
					обработка_данных_полученных_с_сервера_для_наличием_биоэкземпляра, наибольшее_колличество_пациентов_с_наличием_биоэкземпляра);


			cd.readEthicsApproval(charts, параметрыФильтра, overview.getMu(), overview.getSelectedValues(), overview.getFilterForAAE(), overview.getAae(), overview.getFilterForYLC(), overview.getYlc());

			Supplier<Boolean> условия_действительности_данных_для_подтверждения_этики = () -> { return charts.lstEthicsApproval.size() == 3; };
			Supplier<List<?>> обработка_данных_полученных_с_сервера_для_подтверждения_этики = () -> {
				   return charts.lstEthicsApproval;
				};

			int наибольшее_колличество_пациентов_с_подтверждением_этики = 0;
			if (условия_действительности_данных_для_подтверждения_этики.get()) {
				for (Object el : charts.lstEthicsApproval) {
					//пруи возвращение данных в одном из 3х мапов содержится переменная
					//которя показывает наибольшее колличество симптомов
					Map<String, Object> map = (Map<String,Object>) el;
					if (map.containsKey("_наибольшее_колличество_пациентов_с_симптомом")) {
						наибольшее_колличество_пациентов_с_подтверждением_этики = (int) map.get("_наибольшее_колличество_пациентов_с_симптомом");
						map.remove("_наибольшее_колличество_пациентов_с_симптомом");
						break;
					}
				}
			}
			данные_для_графика_колонок(model, overview, charts, условия_действительности_данных_для_подтверждения_этики,
					"ethics_approval",
					обработка_данных_полученных_с_сервера_для_подтверждения_этики, наибольшее_колличество_пациентов_с_подтверждением_этики);


//			cd.readCranocervicalDystonia(charts, параметрыФильтра, selected_gene_id, selected_disease_id, overview.repeats);
//			if (charts.lstCranocervicalDystonia.size() == 5) {
//				String web_attr = "cranocervical_dystonia";
//				List<?> web_param = charts.lstCranocervicalDystonia;
//				String prefix = "cranocervical_dystonia_";
//				Object[] data = new Object[] {new Object[] {"Craniocervical", web_param.get(0)}, new Object[] {"Leg", web_param.get(1)}, new Object[] {"Arm", web_param.get(2)}, new Object[] {"Trunk", web_param.get(2)}};
//				int missing_data_index = 4;
//
//				if (overview.total_count != 0) {
//					model.addAttribute(web_attr, data);
//					Float missing = Float.valueOf(web_param.get(missing_data_index).toString());
//					model.addAttribute(prefix + "missing", missing);
//					model.addAttribute(prefix + "missing_percent", overview.total_count == 0 ? "0.00" : new DecimalFormat("0.00").format(missing*100/overview.total_count).replace(",", "."));
//				}
//			}

			model.addAttribute("charts", charts);

			if (параметрыФильтра.все_значения()) {
				model.addAttribute("humanized_filter", "All");
			} else {
				model.addAttribute("humanized_filter", параметрыФильтра.составить_фильтр());
			}
        	return "study/overview_plots_unpublished";
        }

//        if (springDatasourceUrl.endsWith("short")) {
//		if ("jdbc:postgresql://localhost:5432/postgres".endsWith("short") && overview.isStepThreeFile == false) {

		//TODO
		overview.setSizeVersion("short");
		overview.isStepThreeFile = true;
  		if (overview.sizeVersion.equals("short") && overview.isStepThreeFile == false) {

            создать_укороченное_представление(overview, p);
            overview.short_version = true;
        }

		return "study/overview";
	}


	/**
	 * @param overview
	 */
	private void создать_укороченное_представление(Overview overview, Integer page) {
		//Эта часть для нового задания по МJFF
		Map<String, List<String>> значения_в_виде_карты = new TreeMap<>();

		//считываем все заначение в карту (мап) где первое значение есть ключ а остальное список (правда в списке остается ключ как первый элемент).
		overview.getWholeData().stream().forEach(_list -> значения_в_виде_карты.put(_list.get(0), _list));

		overview.studies = new ArrayList<>();
		значения_в_виде_карты.entrySet().forEach(_action -> System.out.println(_action.getKey()));

		List<String> id_case = значения_в_виде_карты.get("id*") != null
				? значения_в_виде_карты.get("id*")
				: значения_в_виде_карты.get("id");
		overview.studies.add(id_case);

		соединить_столбцы(overview, значения_в_виде_карты, "gene1", "gene2", "gene3", "gene_comb", "n.a.", null);
		соединить_столбцы(overview, значения_в_виде_карты, "mut_comb", "mut2_p", "mut3_p", "mut_comb", "n.a.", null);
		соединить_столбцы(overview, значения_в_виде_карты, "pathogenicity1", "pathogenicity2", "pathogenicity3", "pathogenicity_comb", "n.a.", null);
//		соединить_столбцы(overview, значения_в_виде_карты, "pathogenicity1", "pathogenicity2", "pathogenicity3", "pathogenicity_comb", "n.a.", null);

		List<String> center = значения_в_виде_карты.get("center*") != null
				? значения_в_виде_карты.get("center*")
				: значения_в_виде_карты.get("center");
		overview.studies.add(center);

		List<String> contact_name = значения_в_виде_карты.get("contact_name*") != null
				? значения_в_виде_карты.get("contact_name*")
				: значения_в_виде_карты.get("contact_name");
		overview.studies.add(contact_name);

		List<String> diagnosed_with_pd = значения_в_виде_карты.get("diagnosed_with_pd*") != null
				? значения_в_виде_карты.get("diagnosed_with_pd*")
				: значения_в_виде_карты.get("diagnosed_with_pd");
		overview.studies.add(diagnosed_with_pd);

		List<String> age_at_onset = значения_в_виде_карты.get("age_at_onset*") != null
				? значения_в_виде_карты.get("age_at_onset*")
				: значения_в_виде_карты.get("age_at_onset");
		overview.studies.add(age_at_onset);

		вычесть_столбцы(overview, значения_в_виде_карты, "age_at_exam", "age_at_onset", "disease_duration_comb", "n.a.");

		List<String> year_of_last_contact = значения_в_виде_карты.get("year_of_last_contact*") != null
				? значения_в_виде_карты.get("year_of_last_contact*")
				: значения_в_виде_карты.get("year_of_last_contact");
		overview.studies.add(year_of_last_contact);

		List<String> sex = значения_в_виде_карты.get("sex*") != null ? значения_в_виде_карты.get("sex*")
				: значения_в_виде_карты.get("sex");
		overview.studies.add(sex);

		List<String> race_all = значения_в_виде_карты.get("race_all*") != null ? значения_в_виде_карты.get("race_all*")
				: значения_в_виде_карты.get("race_all");
		overview.studies.add(race_all);

		List<String> ethnicity = значения_в_виде_карты.get("ethnicity*") != null
				? значения_в_виде_карты.get("ethnicity*")
				: значения_в_виде_карты.get("ethnicity");
		overview.studies.add(ethnicity);

		List<String> hy_stage_comb = значения_в_виде_карты.get("hy_stage_comb*") != null
				? значения_в_виде_карты.get("hy_stage_comb*")
				: значения_в_виде_карты.get("hy_stage_comb");
		overview.studies.add(hy_stage_comb);

		List<String> updrs_comb = значения_в_виде_карты.get("updrs_comb*") != null
				? значения_в_виде_карты.get("updrs_comb*")
				: значения_в_виде_карты.get("updrs_comb");
		updrs_comb.remove(0);
		updrs_comb.add(0, "updrs_comb2*");
		overview.studies.add(updrs_comb);

		List<String> mds_updrs_comb = значения_в_виде_карты.get("mds_updrs_comb*") != null
				? значения_в_виде_карты.get("mds_updrs_comb*")
				: значения_в_виде_карты.get("mds_updrs_comb");
		mds_updrs_comb.remove(0);
		mds_updrs_comb.add(0, "mds_updrs_comb2*");
		overview.studies.add(mds_updrs_comb);

		List<String> cognition_moca = значения_в_виде_карты.get("cognition_moca*") != null
				? значения_в_виде_карты.get("cognition_moca*")
				: значения_в_виде_карты.get("cognition_moca");
				mds_updrs_comb.remove(0);
				mds_updrs_comb.add(0, "cognition_moca*");
		overview.studies.add(cognition_moca);

		//recode - if imaging_mri* "yes" show "MRI";  if imaging_spect* "yes" show "SPECT";  if imaging_tcs* "yes" show "TCS"
		//so, if for one case all three were selected as "yes", this field should display "MRI; SPECT; TCS"

		Function<List<String>, String> recode = (кобинированнов_название) -> {
			List<String> _кобинированнов_название = new ArrayList<>();
			if ("yes".equals(кобинированнов_название.get(0))) _кобинированнов_название.add("MRI");
			if ("yes".equals(кобинированнов_название.get(1))) _кобинированнов_название.add("SPECT");
			if ("yes".equals(кобинированнов_название.get(2))) _кобинированнов_название.add("TCS");
			if (_кобинированнов_название.size() == 0) return "n.a.";
			return _кобинированнов_название.stream().collect(Collectors.joining(";"));
		};
		соединить_столбцы(overview, значения_в_виде_карты, "imaging_mri", "imaging_spect", "imaging_tcs", "imaging_data_available_comb", "n.a.", recode);

		List<String> bi_dna = значения_в_виде_карты.get("bi_dna*") != null
				? значения_в_виде_карты.get("bi_dna*")
				: значения_в_виде_карты.get("bi_dna");
		bi_dna.remove(0);
		bi_dna.add(0, "bi_dna_comb*");
		overview.studies.add(bi_dna);

		List<String> bi_rna = значения_в_виде_карты.get("bi_rna*") != null
				? значения_в_виде_карты.get("bi_rna*")
				: значения_в_виде_карты.get("bi_rna");
		bi_rna.remove(0);
		bi_rna.add(0, "bi_rna_comb*");
		overview.studies.add(bi_rna);

		List<String> bi_serum = значения_в_виде_карты.get("bi_serum*") != null
				? значения_в_виде_карты.get("bi_serum*")
				: значения_в_виде_карты.get("bi_serum");
		bi_serum.remove(0);
		bi_serum.add(0, "bi_serum_comb*");
		overview.studies.add(bi_serum);

		List<String> bi_plasma = значения_в_виде_карты.get("bi_plasma*") != null
				? значения_в_виде_карты.get("bi_plasma*")
				: значения_в_виде_карты.get("bi_plasma");
		bi_plasma.remove(0);
		bi_plasma.add(0, "bi_plasma_comb*");
		overview.studies.add(bi_plasma);

		List<String> bi_whole_blood = значения_в_виде_карты.get("bi_whole_blood*") != null
				? значения_в_виде_карты.get("bi_whole_blood*")
				: значения_в_виде_карты.get("bi_whole_blood");
		bi_whole_blood.remove(0);
		bi_whole_blood.add(0, "bi_whole_blood_comb*");
		overview.studies.add(bi_whole_blood);

		List<String> bi_csf = значения_в_виде_карты.get("bi_csf*") != null
				? значения_в_виде_карты.get("bi_csf*")
				: значения_в_виде_карты.get("bi_csf");
		bi_csf.remove(0);
		bi_csf.add(0, "bi_csf_comb*");
		overview.studies.add(bi_csf);

		List<String> bi_fibroblasts = значения_в_виде_карты.get("bi_fibroblasts*") != null
				? значения_в_виде_карты.get("bi_fibroblasts*")
				: значения_в_виде_карты.get("bi_fibroblasts");
		bi_fibroblasts.remove(0);
		bi_fibroblasts.add(0, "bi_fibroblasts_comb*");
		overview.studies.add(bi_fibroblasts);

		List<String> bi_ipscs = значения_в_виде_карты.get("bi_ipscs*") != null
				? значения_в_виде_карты.get("bi_ipscs*")
				: значения_в_виде_карты.get("bi_ipscs");
		bi_ipscs.remove(0);
		bi_ipscs.add(0, "bi_ipscs_comb*");
		overview.studies.add(bi_ipscs);

		List<String> bi_brain_tissue = значения_в_виде_карты.get("bi_brain_tissue*") != null
				? значения_в_виде_карты.get("bi_brain_tissue*")
				: значения_в_виде_карты.get("bi_brain_tissue");
		bi_brain_tissue.remove(0);
		bi_brain_tissue.add(0, "bi_brain_tissue_comb*");
		overview.studies.add(bi_brain_tissue);

		List<String> other_biospecimens = значения_в_виде_карты.get("other_biospecimens*") != null
				? значения_в_виде_карты.get("other_biospecimens*")
				: значения_в_виде_карты.get("other_biospecimens");
		other_biospecimens.remove(0);
		other_biospecimens.add(0, "other_biospecimens_comb*");
		overview.studies.add(other_biospecimens);

		List<String> availability_for_follow_up_studies = значения_в_виде_карты.get("availability_for_follow_up_studies*") != null
				? значения_в_виде_карты.get("availability_for_follow_up_studies*")
				: значения_в_виде_карты.get("availability_for_follow_up_studies");
		availability_for_follow_up_studies.remove(0);
		availability_for_follow_up_studies.add(0, "availability_for_follow_up_studies_comb*");
		overview.studies.add(availability_for_follow_up_studies);

		List<String> recruitment_center_allowed_to_recontact_the_proband = значения_в_виде_карты.get("recruitment_center_allowed_to_recontact_the_proband*") != null
				? значения_в_виде_карты.get("recruitment_center_allowed_to_recontact_the_proband*")
				: значения_в_виде_карты.get("recruitment_center_allowed_to_recontact_the_proband");
		recruitment_center_allowed_to_recontact_the_proband.remove(0);
		recruitment_center_allowed_to_recontact_the_proband.add(0, "recruitment_center_allowed_to_recontact_the_proband_comb*");
		overview.studies.add(recruitment_center_allowed_to_recontact_the_proband);

		List<String> recruitment_center_allowed_to_share_biomaterials = значения_в_виде_карты.get("recruitment_center_allowed_to_share_biomaterials*") != null
				? значения_в_виде_карты.get("recruitment_center_allowed_to_share_biomaterials*")
				: значения_в_виде_карты.get("recruitment_center_allowed_to_share_biomaterials");
		recruitment_center_allowed_to_share_biomaterials.remove(0);
		recruitment_center_allowed_to_share_biomaterials.add(0, "recruitment_center_allowed_to_share_biomaterials_comb*");
		overview.studies.add(recruitment_center_allowed_to_share_biomaterials);

		List<String> recruitment_center_allowed_to_share_deidentified_patient_data = значения_в_виде_карты.get("recruitment_center_allowed_to_share_deidentified_patient_data*") != null
				? значения_в_виде_карты.get("recruitment_center_allowed_to_share_deidentified_patient_data*")
				: значения_в_виде_карты.get("recruitment_center_allowed_to_share_deidentified_patient_data");
		recruitment_center_allowed_to_share_deidentified_patient_data.remove(0);
		recruitment_center_allowed_to_share_deidentified_patient_data.add(0, "recruitment_center_allowed_to_share_deidentified_patient_data_comb*");
		overview.studies.add(recruitment_center_allowed_to_share_deidentified_patient_data);


		//making strings look like an int(visual)
		for (int i = 0; i < overview.studies.size(); i++){
			if (overview.studies.get(i).get(0).equals("age_at_onset*")
					|| overview.studies.get(i).get(0).equals("disease_duration_comb*")
//					|| overview.studies.get(i).get(0).equals("cognition_moca*")
//					|| overview.studies.get(i).get(0).equals("updrs_comb2*")
					|| overview.studies.get(i).get(0).equals("year_of_last_contact*")
			){
				for (int j = 1; j < overview.studies.get(i).size(); j++){
					if (!overview.studies.get(i).get(j).equals("n.a.")) {

						String value = overview.studies.get(i).get(j);
						String[] arrSplit = value.split("\\.");
						if (arrSplit.length > 1) {
							overview.studies.get(i).set(j, arrSplit[0]);
						}
					}
				}
			}
		}

		// making yes and no look 1 way(capitall letters, and so on)
		for (int i = 0; i < overview.studies.size(); i++){
			for (int j = 1; j < overview.studies.get(i).size(); j++){
				if (overview.studies.get(i).get(j).equals("Yes")
						|| overview.studies.get(i).get(j).equals("No")){
					overview.studies.get(i).set(j, overview.studies.get(i).get(j).toLowerCase());
				}
				if (overview.studies.get(i).get(j).equals("(yes)")){
					overview.studies.get(i).set(j, overview.studies.get(i).get(j).replace("(yes)", "yes"));
				}
			}
		}


		List<TreeSet<String>> listOfSets = new ArrayList<>();
		for (int i = 0; i < overview.studies.size(); i++) {
			TreeSet<String> set = new TreeSet<>();
			for (int j = 1; j < overview.studies.get(i).size(); j++) {
				if (overview.studies.get(i).get(j) == null) {
					set.add("n.a.");
				} else {
					set.add(overview.studies.get(i).get(j));
				}
			}
			listOfSets.add(set);
		}
		overview.setWholeDataListofSets(listOfSets);


		Map<String, ArrayList<String>> mapOfOptions = new HashMap<>();
		for (int i = 1; i < overview.getWholeDataListofSets().size(); i++) {
			mapOfOptions.put(overview.studies.get(i).get(0), new ArrayList<>(overview.getWholeDataListofSets().get(i)));

			if (mapOfOptions.get(overview.studies.get(i).get(0)).contains("n.a.")){
				mapOfOptions.get(overview.studies.get(i).get(0)).remove("n.a.");
				List<Float> listOfFloatNumbers;
				List<Integer> listOfIntegerNumbers;
				if (overview.studies.get(i).get(0).equals("cognition_moca*")
						|| overview.studies.get(i).get(0).equals("updrs_comb2*")){
					listOfFloatNumbers = mapOfOptions.get(overview.studies.get(i).get(0)).stream()
							.map(s -> Float.parseFloat(s))
							.collect(Collectors.toList());
					Collections.sort(listOfFloatNumbers);
					mapOfOptions.put(overview.studies.get(i).get(0), (ArrayList<String>) listOfFloatNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
				}
				else if (overview.studies.get(i).get(0).equals("age_at_onset*")
						|| overview.studies.get(i).get(0).equals("disease_duration_comb*")
						|| overview.studies.get(i).get(0).equals("year_of_last_contact*")){
					listOfIntegerNumbers = mapOfOptions.get(overview.studies.get(i).get(0)).stream()
							.map(s -> Integer.parseInt(s))
							.collect(Collectors.toList());
					Collections.sort(listOfIntegerNumbers);
					mapOfOptions.put(overview.studies.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
				}
				mapOfOptions.get(overview.studies.get(i).get(0)).add("n.a.");
			}
		}
		overview.setMapOfOptionsList(mapOfOptions);

		//getting the indexes, that are needed to be kept when filtering
		overview.getFilterForTableColumns();
		List<Integer> filteredIndexes = new ArrayList<>();
		boolean oneTime = true;
		if (overview.getFilterForTableColumns() != null) {
			for (Map.Entry<String, ArrayList<String>> entry : overview.getFilterForTableColumns().entrySet()) {
				List<Integer> newIndexes = new ArrayList<>();
				for (int i = 0; i < overview.studies.size(); i++) {
					if (overview.studies.get(i).get(0).equals(entry.getKey())) {
						for (int j = 0; j < overview.studies.get(i).size(); j++) {
							if (entry.getValue().contains(overview.studies.get(i).get(j))) {
								newIndexes.add(j);
							}
						}
					}
				}
				if (oneTime) {
					filteredIndexes = new ArrayList<>(newIndexes);
					oneTime = false;
				}
				filteredIndexes.retainAll(newIndexes);
			}

			List<List<String>> temp = new ArrayList<>();
			for (int i = 0; i < overview.studies.size(); i++){
				List<String> list = new ArrayList<>();
				for(int j = 0; j < overview.studies.get(i).size(); j++){
					list.add(overview.studies.get(i).get(j));
				}
				temp.add(list);
			}
			overview.studies.clear();

			//filtering with indexes
			for (int i = 0; i < temp.size(); i++) {
				List<String> list = new ArrayList<>();
				list.add(temp.get(i).get(0));
				for (int j = 0; j < filteredIndexes.size(); j++) {
					list.add(temp.get(i).get(filteredIndexes.get(j)));
				}
				overview.studies.add(list);
			}
		}


		int _page = page == null ? 1 : page;
		for (List<String> list : overview.studies) {
			overview.setTotal_pages(list.size()/10);
			int size = list.size();
			String title = list.remove(0);
			overview.total_count = 0;
			list.removeIf(x -> { boolean a = (overview.total_count/10  != (_page - 1)); overview.total_count++; return _page != -1 && a; });
			list.replaceAll(x -> x == null ? "" : x);
			list.add(0, title);
			overview.total_count = size-1; //потому что мы должны не считать заголовок
		}


//		overview.setStudies(temp);

		overview.setTotal_pages((int)Math.ceil(((double)overview.total_count/10)));
		overview.current_page = _page;
		overview.limit_value = 3;

//		} catch (Exception e) {
//			LOGGER.error(e.getMessage());
//		}


	}


	/**
	 * @param overview
	 * @param значения_в_виде_карты
	 * @param название_первого_столбца
	 * @param название_второго_столбца
	 * @param название_третьего_столбца
	 * @param ключ_заголовка_из_файла
	 * @param N_G
	 * @param особая_обработка TODO
	 */
	private void соединить_столбцы(Overview overview, Map<String, List<String>> значения_в_виде_карты,
			String название_первого_столбца, String название_второго_столбца, String название_третьего_столбца,
			String ключ_заголовка_из_файла, String N_G, Function<List<String>, String> особая_обработка) {
		List<String> _столбец1 = значения_в_виде_карты.get(название_первого_столбца + "*") != null ? значения_в_виде_карты.get(название_первого_столбца + "*") : значения_в_виде_карты.get(название_первого_столбца);
		List<String> _столбец2 = значения_в_виде_карты.get(название_второго_столбца + "*") != null ? значения_в_виде_карты.get(название_второго_столбца + "*") : значения_в_виде_карты.get(название_второго_столбца);
		List<String> _столбец3 = значения_в_виде_карты.get(название_третьего_столбца + "*") != null ? значения_в_виде_карты.get(название_третьего_столбца + "*") : значения_в_виде_карты.get(название_третьего_столбца);

        List<String> столбец1 = _столбец1 != null ? _столбец1 : new ArrayList<String>();
        List<String> столбец2 = _столбец2 != null ? _столбец2 : new ArrayList<String>();
        List<String> столбец3 = _столбец3 != null ? _столбец3 : new ArrayList<String>();

        List<String> кобинация_названий = new ArrayList<>();
        int size = Math.max(столбец1.size(), Math.max(столбец2.size(), столбец3.size()));
        IntStream.range(0, size).forEach(index -> {
        	List<String> кобинированнов_название = new ArrayList<>();
        	if (особая_обработка == null) {
        		if (index < столбец1.size() && !N_G.equals(столбец1.get(index))) кобинированнов_название.add(столбец1.get(index));
        		if (index < столбец2.size() && !N_G.equals(столбец2.get(index))) кобинированнов_название.add(столбец2.get(index));
        		if (index < столбец3.size() && !N_G.equals(столбец3.get(index))) кобинированнов_название.add(столбец3.get(index));
        		кобинация_названий.add(кобинированнов_название.stream().collect(Collectors.joining(";")));
        	} else {
        		if (index < столбец1.size()) кобинированнов_название.add(столбец1.get(index)); else кобинированнов_название.add(N_G);
        		if (index < столбец2.size()) кобинированнов_название.add(столбец2.get(index)); else кобинированнов_название.add(N_G);
        		if (index < столбец3.size()) кобинированнов_название.add(столбец3.get(index)); else кобинированнов_название.add(N_G);
        		кобинация_названий.add(особая_обработка.apply(кобинированнов_название));
        	}
        });

		overview.studies.add(кобинация_названий);
        кобинация_названий.remove(0);
		кобинация_названий.add(0, ключ_заголовка_из_файла + "*");
	}


	/**
	 * @param overview
	 * @param значения_в_виде_карты
	 * @param название_первого_столбца
	 * @param название_второго_столбца
//	 * @param название_третьего_столбца
	 * @param ключ_заголовка_из_файла
	 * @param N_G
	 */
	private void вычесть_столбцы(Overview overview, Map<String, List<String>> значения_в_виде_карты,
			String название_первого_столбца, String название_второго_столбца,
			String ключ_заголовка_из_файла, String N_G) {
		List<String> _столбец1 = значения_в_виде_карты.get(название_первого_столбца + "*") != null ? значения_в_виде_карты.get(название_первого_столбца + "*") : значения_в_виде_карты.get(название_первого_столбца);
		List<String> _столбец2 = значения_в_виде_карты.get(название_второго_столбца + "*") != null ? значения_в_виде_карты.get(название_второго_столбца + "*") : значения_в_виде_карты.get(название_второго_столбца);

        List<String> столбец1 = _столбец1 != null ? _столбец1 : new ArrayList<String>();
        List<String> столбец2 = _столбец2 != null ? _столбец2 : new ArrayList<String>();

        List<String> кобинация_названий = new ArrayList<>();
        int size = Math.max(столбец1.size(), столбец2.size());
        IntStream.range(0, size).forEach(index -> {
        	List<String> значениея = new ArrayList<>();

        	if (index < столбец1.size() && !N_G.equals(столбец1.get(index))) значениея.add(столбец1.get(index));
        	if (index < столбец2.size() && !N_G.equals(столбец2.get(index))) значениея.add(столбец2.get(index));

        	try {
        		кобинация_названий.add(значениея.size() == 2 ? String.valueOf(Double.valueOf(значениея.get(0)) - Double.valueOf(значениея.get(1))) : N_G);
        	} catch (Exception ex) {
        		кобинация_названий.add(N_G);
        	}
        });

		overview.studies.add(кобинация_названий);
        кобинация_названий.remove(0);
		кобинация_названий.add(0, ключ_заголовка_из_файла + "*");
	}

	/**
	 * @param model
	 * @param overview
	 * @param charts
	 */
	private <T> void данные_для_паи_графика(ModelMap model, Overview overview, Charts charts,
			Supplier<Boolean> условия_действительности_данных,
			String название_графика,
			Supplier<T> обработка_данных,
			float missing) {
		if (условия_действительности_данных.get()) {
			//?
			String web_attr = название_графика;
			//данные переменная используется просто для сокращения пространства
			//List<?> web_param = charts.lstRace;
			//?
			String prefix = название_графика + "_";
//			Object[] data = new Object[] {new Object[] {"American Indian", web_param.get(0)},
//										  new Object[] {"Asian", web_param.get(1)},
//										  new Object[] {"Black or African American", web_param.get(2)},
//										  new Object[] {"Pacific Islander or native Hawaian", web_param.get(3)},
//										  new Object[] {"White", web_param.get(4)},
//										  };
			T data = обработка_данных.get();
			//int missing_data_index = 5;

			int total = overview.total_count;
			try {
				if (название_графика.endsWith("_healthy")) {
					total = (Integer)model.get("subjects_per_gene_total_healthy");
				} else {
					total = (Integer)model.get("subjects_per_gene_total");
				}

			} catch (Exception ex) {

			}

			if (total != 0) {
				model.addAttribute(web_attr, data);
				//Float missing = Float.valueOf(web_param.get(missing_data_index).toString());
				model.addAttribute(prefix + "missing", missing);
				model.addAttribute(prefix + "missing_percent", total == 0 ? "0.00" : new DecimalFormat("0.00").format(missing*100.0/total).replace(",", "."));
			}
		}
	}


	/**
	 * @param model
	 * @param overview
	 * @param charts
	 */
	private <T> void данные_для_графика_колонок(ModelMap model, Overview overview, Charts charts,
			Supplier<Boolean> условия_действительности_данных,
			String название_графика,
			Supplier<T> обработка_данных,
			int наибольшее_колличество_пациентов) {
		if (условия_действительности_данных.get()) {
			//?
			String web_attr = название_графика;
			//данные переменная используется просто для сокращения пространства
			//List<?> web_param = charts.lstRace;
			//?
			String prefix = название_графика + "_";
//			Object[] data = new Object[] {new Object[] {"American Indian", web_param.get(0)},
//										  new Object[] {"Asian", web_param.get(1)},
//										  new Object[] {"Black or African American", web_param.get(2)},
//										  new Object[] {"Pacific Islander or native Hawaian", web_param.get(3)},
//										  new Object[] {"White", web_param.get(4)},
//										  };
			T data = обработка_данных.get();

			if (overview.total_count != 0) {
				model.addAttribute(web_attr, data);
				model.addAttribute(prefix + "_rep_sympt", наибольшее_колличество_пациентов);
			}
		}
	}


//	private boolean benign_for_gene_not_available(Integer selected_gene_id) {
//		return !new File(BENIGN_FILES_FOLDER + geneDAO.getOne(selected_gene_id).getName() + ".tsv").exists();
//	}

	private float round(double d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).floatValue();
   }

//   private String toBrowserHexValue(int number) {
//	   // TODO: this part should be changed so the colors will be not random
//	   if (more_colors == null || more_colors.isEmpty()) {
//		   more_colors = new ArrayList() {{ add("#99cc99"); add("#ff9900"); add("#8286a3"); add("#8f3a73"); add("#cc9933"); add("#b33044"); add("#80bcb0"); add("#f0b5bc"); add("#751a4a"); add("#e0939b"); add("#547e80"); add("#548b90"); add("#520557"); add("#d08e1f"); add("#71084f"); add("#115b58"); add("#b33044"); add(
//					"#8c574c"); add("#9c4f65"); add("#74647b"); add("#11526c"); add("#500922"); add("#80bcb0"); add("#7c6050"); add("#a35c5f"); add("#f0b5bc"); add("#8f3a73"); add("#abb99c"); add("#751a4a"); add("#e0939b"); add("#547e80"); add("#7c1d59"); add("#525e46"); add("#9d6756"); add("#d08e1f"); add("#255868"); add(
//					"#8286a3"); add("#5e737c"); add("#6f1d6d"); add("#4c0439"); add("#935756");}};
//	   }
//	    if (more_colors.isEmpty()) {
//	    	StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
//	    	while (builder.length() < 2) {
//	    		builder.append("0");
//	    	}
//	    	return "#" + builder.toString().toUpperCase() + builder.toString().toUpperCase() + builder.toString().toUpperCase();
//	    }
//	    String remove = more_colors.remove(0);
//		return remove;
//	}

//	private List<String> getResourceFiles(String path) throws IOException {
//	    List<String> filenames = new ArrayList<>();
//
//	    try (
//	            InputStream in = getResourceAsStream(path);
//	            BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
//	        String resource;
//
//	        while ((resource = br.readLine()) != null) {
//	            filenames.add(resource);
//	        }
//	    }
//
//	    return filenames;
//	}

	private InputStream getResourceAsStream(String resource) {
	    final InputStream in
	            = getContextClassLoader().getResourceAsStream(resource);

	    return in == null ? getClass().getResourceAsStream(resource) : in;
	}

	private ClassLoader getContextClassLoader() {
	    return Thread.currentThread().getContextClassLoader();
	}



//	private String[] aao_key_name_and_title(int aaos, Gene gene) {
//		if (aaos == 0 || aaoOther == null) return null;
//		String[] aao_properties = aaoOther.split(":");
//		for(int i=0; i < aao_properties.length/3; i++) {
//			String geneName = aao_properties[i*3];
//			if (geneName.equals(gene.getName())) return new String[] {aao_properties[i*3+1], aao_properties[i*3+2]};
//		}
//		return null;
//	}


//	private void buildFilterInfo(ModelMap model, Map _or) {
//		List<String> _hum_filt = new ArrayList<>();
//          if (model.containsAttribute("filt_info")) _hum_filt.add((String) model.get("filt_info"));
//          if (_or != null && _or.containsKey("pathogenicity") || _or.containsKey("cdna_related")) {
//		    	if (_or.containsKey("pathogenicity")) {
//	        		List<String> collect = Arrays.asList(SequenceVariationValidator.pathogenicity.values()).stream().
//	            			filter(x -> ((List<Integer>)_or.get("pathogenicity")).contains(x.getPathogenicity())).map(x -> x.name().replaceAll("_", " ") + " mutations").collect(Collectors.toList());
//					_hum_filt.addAll(collect);
//		    	}
//		    	if (_or.containsKey("cdna_related")) {
//		    		_hum_filt.addAll((List<String>)_or.get("cdna_related"));
//		    	}
//          }
//          model.addAttribute("humanized_filter", _hum_filt.isEmpty() ? "none" : _hum_filt.stream().collect(Collectors.joining(", ")));
//	}



	private Map<String, Integer> read_order_from_file(Map<String, Integer> chart_order_map, String chart_file_name) {
		chart_order_map.clear();

		try {
			File file = new File("C:\\Java\\eclipse-workspace\\mdsgene-admintool\\mdsgene-java\\src\\main\\resources\\chart_order_tmp\\"
					+ chart_file_name);

			Stream<String> lines2 = Files.lines(Paths.get(file.getAbsolutePath()));
			List<String[]> lines = lines2.map(l -> l.split("\t"))
			                                  .collect(Collectors.toList());
			//create list of lines (each of list contains header and value of the line)
			String[] headers = lines.get(0);
			String[] rows = lines.get(1);
			for (int i = 0; i < headers.length; i++) {
				try {
					String _key = headers[i];
					Integer _value = Integer.valueOf(rows[i]);
					chart_order_map.put(_key, _value);
				} catch (Exception e) {

				}
			}
		} catch(Exception e) {
			System.out.println("Error");
		}
		return chart_order_map;
	}

	private Map<String, Integer> chart_dystonia_order() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("dystonia_HP:0001332", 1);
		chart_order.put("generalized_dystonia_HP:0007325", 2);
		chart_order.put("segmental_multifocal_dystonia_sympt", 3);
		chart_order.put("focal_dystonia_HP:0004373", 4);
		chart_order.put("craniofacial_dystonia_HP:0012179", 5);
		chart_order.put("blepharospasm_sympt", 6);
		chart_order.put("dyst_upper_face_sympt", 7);
		chart_order.put("dyst_lower_face_sympt", 8);
		chart_order.put("oromandibular_dystonia_HP:0012048", 9);
		chart_order.put("dyst_tongue_sympt", 10);
		chart_order.put("dyst_jaw_sympt", 11);
		chart_order.put("laryngeal_dystonia_HP:0012049", 12);
		chart_order.put("dysphonia_HP:0001618", 13);
		chart_order.put("dysarthria_HP:0001260", 14);
		chart_order.put("anarthria_HP:0002425", 15);
		chart_order.put("cervical_dystonia_HP:0000473", 16);
		chart_order.put("torticollis_HP:0000473", 17);
		chart_order.put("retrocollis_HP:0002544", 18);
		chart_order.put("axial_dystonia_HP:0002530", 19);
		chart_order.put("limb_dystonia_HP:0002451", 20);
		chart_order.put("dyst_arm_sympt", 21);
		chart_order.put("dyst_hand_sympt", 22);
		chart_order.put("dyst_leg_sympt", 23);
		chart_order.put("dyst_foot_sympt", 24);
		chart_order.put("dyst_action", 25);
		chart_order.put("mirror_sympt", 26);
		chart_order.put("tremor_unspecified_sympt", 27);
		chart_order.put("tremor_HP:0001337", 27);
		chart_order.put("tremor_dystonic_sympt", 28);
		chart_order.put("dystonic_tremor_HP:0030185", 28);
		chart_order.put("tremor_action_sympt", 29);
		chart_order.put("action_tremor_HP:0002345", 29);
		chart_order.put("tremor_postural_sympt", 30);
		chart_order.put("postural_tremor_HP:0002174", 30);
		chart_order.put("head_tremor_HP:0002346", 31);
		chart_order.put("upper_limb_postural_tremor_HP:0007351", 32);
		chart_order.put("limb_tremor_HP:0200085", 33);
		chart_order.put("myoclonus_sympt", 34);
		chart_order.put("myoclonus_HP:0001336", 34);
		chart_order.put("allev_maneuvers_sympt", 35);
		chart_order.put("alc_response_sympt", 36);
		read_order_from_file(chart_order, "chart_dystonia_order.txt");
		return chart_order;
	   /* chart1_order.put("Dystonia (any or unspecified)", 1);
	    chart1_order.put("Generalized dystonia", 2);
	    chart1_order.put("Segmental/Multifocal dystonia", 3);
	    chart1_order.put("Focal dystonia", 4);
	    chart1_order.put("Craniofacial dystonia", 5);
	    chart1_order.put("Blepharospasm", 6);
	    chart1_order.put("Upper face dystonia", 7);
	    chart1_order.put("Lower face dystonia", 8);
	    chart1_order.put("Oromandibular dystonia", 9);
	    chart1_order.put("Tongue dystonia", 10);
	    chart1_order.put("Jaw dystonia", 11);
	    chart1_order.put("Laryngeal dystonia", 12);
	    chart1_order.put("Dysphonia", 13);
	    chart1_order.put("Dysarthria", 14);
	    chart1_order.put("Anarthria", 15);
	    chart1_order.put("Cervical dystonia", 16);
	    chart1_order.put("Torticollis", 17);
	    chart1_order.put("Retrocollis", 18);
	    chart1_order.put("Axial dystonia", 19);
	    chart1_order.put("Limb dystonia", 20);
	    chart1_order.put("Arm dystonia", 21);
	    chart1_order.put("Hand dystonia", 22);
	    chart1_order.put("Leg dystonia", 23);
	    chart1_order.put("Foot dystonia", 24);
	    chart1_order.put("Task-specific dystonia", 25);
	    chart1_order.put("Mirror dystonia", 26);
	    chart1_order.put("Tremor (any or unspecified)", 27);
	    chart1_order.put("Dystonic tremor", 28);
	    chart1_order.put("Action tremor", 29);
	    chart1_order.put("Postural tremor", 30);
	    chart1_order.put("Head tremor", 31);
	    chart1_order.put("Upper limb postural tremor", 32);
	    chart1_order.put("Limb tremor", 33);
	    chart1_order.put("Myoclonus", 34);
	    chart1_order.put("Geste antagoniste", 35);
	    chart1_order.put("Alcohol responsiveness", 36);
	    mapSymptomNamesToImportHeaders(chart1_order, 1, 37);
	    return chart1_order;*/
	}

	private Map<String, Integer> chart_parkinsonism_order() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("parkinsonism_HP:0001300", 1);
		chart_order.put("bradykinesia_sympt", 2);
		chart_order.put("bradykinesia_HP:0002067", 2);
		chart_order.put("rigidity_sympt", 3);
		chart_order.put("rigidity_HP:0002063", 3);
		chart_order.put("postural_instability_sympt", 4);
		chart_order.put("postural instability_HP:0002172", 4);
		chart_order.put("tremor_rest_sympt", 5);
		chart_order.put("resting_tremor_HP:0002322", 5);
		chart_order.put("muscular_hypotonia_HP:0001252", 7);
		chart_order.put("spasticity_HP:0001257", 8);
		chart_order.put("hyperreflexia_sympt", 9);
		chart_order.put("hyperreflexia_HP:0001347", 9);
		chart_order.put("dyskinesia_sympt", 10);
		chart_order.put("dyskinesia_HP:0100660", 10);
		chart_order.put("diurnal_fluctuations_sympt", 11);
		chart_order.put("motor_fluctuations_sympt", 12);
		chart_order.put("dysmorphic_features_sympt", 13);
		chart_order.put("microcephaly_HP:0000252", 14);
		chart_order.put("short_stature_HP:0004322", 15);
		chart_order.put("seizures_HP:0001250", 16);
		chart_order.put("global_developmental_delay_HP:0001263", 17);
		chart_order.put("motor_delay_HP:0001270", 18);
		chart_order.put("cognitive_impairment_HP:0100543", 19);
		chart_order.put("delayed_speech_and_language_development_HP:0000750", 20);
		chart_order.put("autonomic_sympt", 21);
		chart_order.put("sleep_disorder_sympt", 22);
		chart_order.put("sleep_benefit_sympt", 23);
		chart_order.put("depression_sympt", 24);
		chart_order.put("depression_HP:0000716", 24);
		chart_order.put("anxiety_sympt", 25);
		chart_order.put("anxiety_HP:0000739", 25);
		chart_order.put("psychosis_HP:0000709", 26);
		read_order_from_file(chart_order, "chart_parkinsonism_order.txt");
		return chart_order;

/*	    chart2_order.put("Parkinsonism", 1);
	    chart2_order.put("Bradykinesia", 2);
	    chart2_order.put("Rigidity", 3);
	    chart2_order.put("Postural instability", 4);
	    chart2_order.put("Resting tremor", 5);
	    chart2_order.put("Intention tremor", 10000);
	    chart2_order.put("Muscular hypotonia", 7);
	    chart2_order.put("Spasticity", 8);
	    chart2_order.put("Hyperreflexia", 9);
	    chart2_order.put("Dyskinesia", 10);
	    chart2_order.put("Diurnal fluctuations", 11);
	    chart2_order.put("Motor fluctuations", 12);
	    chart2_order.put("Dysmorphic features", 13);
	    chart2_order.put("Microcephaly", 14);
	    chart2_order.put("Short stature", 15);
	    chart2_order.put("Seizures", 16);
	    chart2_order.put("Global developmental delay", 17);
	    chart2_order.put("Motor delay", 18);
	    chart2_order.put("Cognitive impairment", 19);
	    chart2_order.put("Delayed speech and language development", 20);
	    chart2_order.put("Autonomic sign/sympt.", 21);
	    chart2_order.put("Sleep disorder", 22);
	    chart2_order.put("Sleep benefit", 23);
	    chart2_order.put("Depression", 24);
	    chart2_order.put("Anxiety", 25);
	    chart2_order.put("Psychosis", 26);
		return chart2_order;*/
	}

	private Map<String, Integer> chart_dystonia_SLC30A10_order() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("hypermanganesemia_sympt", 0);
		chart_order.put("dystonia_HP:0001332", 1);
		chart_order.put("generalized_dystonia_HP:0007325", 2);
		chart_order.put("segmental_multifocal_dystonia_sympt", 3);
		chart_order.put("focal_dystonia_HP:0004373", 4);
		chart_order.put("craniofacial_dystonia_HP:0012179", 5);
		chart_order.put("blepharospasm_sympt", 6);
		chart_order.put("dyst_upper_face_sympt", 7);
		chart_order.put("dyst_lower_face_sympt", 8);
		chart_order.put("oromandibular_dystonia_HP:0012048", 9);
		chart_order.put("dyst_tongue_sympt", 10);
		chart_order.put("dyst_jaw_sympt", 11);
		chart_order.put("laryngeal_dystonia_HP:0012049", 12);
		chart_order.put("dysphonia_HP:0001618", 13);
		chart_order.put("dysarthria_HP:0001260", 14);
		chart_order.put("anarthria_HP:0002425", 15);
		chart_order.put("cervical_dystonia_HP:0000473", 16);
		chart_order.put("torticollis_HP:0000473", 17);
		chart_order.put("retrocollis_HP:0002544", 18);
		chart_order.put("axial_dystonia_HP:0002530", 19);
		chart_order.put("limb_dystonia_HP:0002451", 20);
		chart_order.put("dyst_arm_sympt", 21);
		chart_order.put("dyst_hand_sympt", 22);
		chart_order.put("dyst_leg_sympt", 23);
		chart_order.put("dyst_foot_sympt", 24);
		chart_order.put("dyst_action", 25);
		chart_order.put("mirror_sympt", 26);
		chart_order.put("tremor_unspecified_sympt", 27);
		chart_order.put("tremor_HP:0001337", 27);
		chart_order.put("tremor_dystonic_sympt", 28);
		chart_order.put("dystonic_tremor_HP:0030185", 28);
		chart_order.put("tremor_action_sympt", 29);
		chart_order.put("action_tremor_HP:0002345", 29);
		chart_order.put("tremor_postural_sympt", 30);
		chart_order.put("postural_tremor_HP:0002174", 30);
		chart_order.put("head_tremor_HP:0002346", 31);
		chart_order.put("upper_limb_postural_tremor_HP:0007351", 32);
		chart_order.put("limb_tremor_HP:0200085", 33);
		chart_order.put("myoclonus_sympt", 34);
		chart_order.put("myoclonus_HP:0001336", 34);
		chart_order.put("allev_maneuvers_sympt", 35);
		chart_order.put("alc_response_sympt", 36);
		read_order_from_file(chart_order, "chart_dystonia_SLC30A10_order.txt");
		return chart_order;
		/*
//	    chart1_order.put("Hypermanganesemia", 0);
//	    chart1_order.put("Dystonia (any or unspecified)", 1);
//	    chart1_order.put("Generalized dystonia", 2);
//	    chart1_order.put("Segmental/Multifocal dystonia", 3);
//	    chart1_order.put("Focal dystonia", 4);
//	    chart1_order.put("Craniofacial dystonia", 5);
//	    chart1_order.put("Blepharospasm", 6);
//	    chart1_order.put("Upper face dystonia", 7);
//	    chart1_order.put("Lower face dystonia", 8);
//	    chart1_order.put("Oromandibular dystonia", 9);
//	    chart1_order.put("Tongue dystonia", 10);
//	    chart1_order.put("Jaw dystonia", 11);
//	    chart1_order.put("Laryngeal dystonia", 12);
//	    chart1_order.put("Dysphonia", 13);
//	    chart1_order.put("Dysarthria", 14);
//	    chart1_order.put("Anarthria", 15);
//	    chart1_order.put("Cervical dystonia", 16);
//	    chart1_order.put("Torticollis", 17);
//	    chart1_order.put("Retrocollis", 18);
//	    chart1_order.put("Axial dystonia", 19);
//	    chart1_order.put("Limb dystonia", 20);
//	    chart1_order.put("Arm dystonia", 21);
//	    chart1_order.put("Hand dystonia", 22);
//	    chart1_order.put("Leg dystonia", 23);
//	    chart1_order.put("Foot dystonia", 24);
//	    chart1_order.put("Task-specific dystonia", 25);
//	    chart1_order.put("Mirror dystonia", 26);
//	    chart1_order.put("Tremor (any or unspecified)", 27);
//	    chart1_order.put("Dystonic tremor", 28);
//	    chart1_order.put("Action tremor", 29);
//	    chart1_order.put("Postural tremor", 30);
//	    chart1_order.put("Head tremor", 31);
//	    chart1_order.put("Upper limb postural tremor", 32);
//	    chart1_order.put("Limb tremor", 33);
//	    chart1_order.put("Myoclonus", 34);
//	    chart1_order.put("Geste antagoniste", 35);
//	    chart1_order.put("Alcohol responsiveness", 36);
//	    return chart1_order;*/
	}

	private Map<String, Integer> chart_parkinsonism_SLC30A10_order() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("parkinsonism_HP:0001300", 1);
		chart_order.put("bradykinesia_sympt", 2);
		chart_order.put("bradykinesia_HP:0002067", 2);
		chart_order.put("rigidity_sympt", 3);
		chart_order.put("rigidity_HP:0002063", 3);
		chart_order.put("postural_instability_sympt", 4);
		chart_order.put("postural instability_HP:0002172", 4);
		chart_order.put("tremor_rest_sympt", 5);
		chart_order.put("resting_tremor_HP:0002322", 5);
		chart_order.put("muscular_hypotonia_HP:0001252", 7);
		chart_order.put("spasticity_HP:0001257", 8);
		chart_order.put("hyperreflexia_sympt", 9);
		chart_order.put("hyperreflexia_HP:0001347", 9);
		chart_order.put("dyskinesia_sympt", 10);
		chart_order.put("dyskinesia_HP:0100660", 10);
		chart_order.put("diurnal_fluctuations_sympt", 11);
		chart_order.put("motor_fluctuations_sympt", 12);
		chart_order.put("dysmorphic_features_sympt", 13);
		chart_order.put("microcephaly_HP:0000252", 14);
		chart_order.put("short_stature_HP:0004322", 15);
		chart_order.put("seizures_HP:0001250", 16);
		chart_order.put("global_developmental_delay_HP:0001263", 17);
		chart_order.put("motor_delay_HP:0001270", 18);
		chart_order.put("cognitive_impairment_HP:0100543", 19);
		chart_order.put("delayed_speech_and_language_development_HP:0000750", 20);
		chart_order.put("autonomic_sympt", 21);
		chart_order.put("sleep_disorder_sympt", 22);
		chart_order.put("sleep_benefit_sympt", 23);
		chart_order.put("depression_sympt", 24);
		chart_order.put("depression_HP:0000716", 24);
		chart_order.put("anxiety_sympt", 25);
		chart_order.put("anxiety_HP:0000739", 25);
		chart_order.put("psychosis_HP:0000709", 26);
		read_order_from_file(chart_order, "chart_parkinsonism_SLC30A10_order.txt");
		return chart_order;
		/*
//	    chart2_order.put("Parkinsonism", 1);
//	    chart2_order.put("Bradykinesia", 2);
//	    chart2_order.put("Rigidity", 3);
//	    chart2_order.put("Postural instability", 4);
//	    chart2_order.put("Resting tremor", 5);
//	    chart2_order.put("Intention tremor", 10000);
//	    chart2_order.put("Muscular hypotonia", 7);
//	    chart2_order.put("Spasticity", 8);
//	    chart2_order.put("Hyperreflexia", 9);
//	    chart2_order.put("Dyskinesia", 10);
//	    chart2_order.put("Diurnal fluctuations", 11);
//	    chart2_order.put("Motor fluctuations", 12);
//	    chart2_order.put("Dysmorphic features", 13);
//	    chart2_order.put("Microcephaly", 14);
//	    chart2_order.put("Short stature", 15);
//	    chart2_order.put("Seizures", 16);
//	    chart2_order.put("Global developmental delay", 17);
//	    chart2_order.put("Motor delay", 18);
//	    chart2_order.put("Cognitive impairment", 19);
//	    chart2_order.put("Delayed speech and language development", 20);
//	    chart2_order.put("Autonomic sign/sympt.", 21);
//	    chart2_order.put("Sleep disorder", 22);
//	    chart2_order.put("Sleep benefit", 23);
//	    chart2_order.put("Depression", 24);
//	    chart2_order.put("Anxiety", 25);
//	    chart2_order.put("Psychosis", 26);
//		return chart2_order;*/
	}

	private Map<String, Integer> chart_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("parkinsonism_HP:0001300", 1);
		chart_order.put("atypical_park_sympt", 2);
		chart_order.put("bradykinesia_sympt", 3);
		chart_order.put("bradykinesia_HP:0002067", 3);
		chart_order.put("hypomimia_sympt", 4);
		chart_order.put("hypophonia_sympt", 5);
		chart_order.put("micrographia_sympt", 6);
		chart_order.put("tremor_rest_sympt", 7);
		chart_order.put("resting_tremor_HP:0002322", 7);
		chart_order.put("tremor_action_sympt", 8);
		chart_order.put("action_tremor_HP:0002345", 8);
		chart_order.put("tremor_postural_sympt", 9);
		chart_order.put("postural_tremor_HP:0002174", 9);
		chart_order.put("tremor_dystonic_sympt", 10);
		chart_order.put("dystonic_tremor_HP:0030185", 10);
		chart_order.put("tremor_unspecified_sympt", 11);
		chart_order.put("tremor_HP:0001337", 11);
		chart_order.put("rigidity_sympt", 12);
		chart_order.put("rigidity_HP:0002063", 12);
		chart_order.put("postural_instability_sympt", 13);
		chart_order.put("postural instability_HP:0002172", 13);
		chart_order.put("gait_difficulties_falls_sympt", 14);
		chart_order.put("levodopa_response_sympt", 15);
		chart_order.put("response_quantification_sympt", 16);
		chart_order.put("dyskinesia_sympt", 17);
		chart_order.put("dyskinesia_HP:0100660", 17);
		chart_order.put("motor_fluctuations_sympt", 18);
		chart_order.put("diurnal_fluctuations_sympt", 19);
		chart_order.put("sleep_benefit_sympt", 20);
		chart_order.put("spasticity_pyramidal_signs_sympt", 21);
		chart_order.put("dystonia_sympt", 22);
		chart_order.put("dystonia _HP:0001332", 22);
		chart_order.put("myoclonus_sympt", 23);
		chart_order.put("myoclonus_HP:0001336", 23);
		chart_order.put("chorea_sympt", 24);
		chart_order.put("chorea_HP:0002072", 24);
		chart_order.put("tics_HP:0100033", 25);
		//WARNING (missing value with the name) : Ataxia dysdiadochokinesia
		chart_order.put("swallowing_disorder_sympt", 27);
		chart_order.put("dysarthria_anarthria_sympt", 28);
		chart_order.put("dysphagia_sympt", 29);
		chart_order.put("tongue_protrusions_sympt", 30);
		chart_order.put("saccadic_abnormalities_sympt", 31);
		chart_order.put("oculogyric_spasms_sympt", 32);
		chart_order.put("gaze_palsy_sympt", 33);
		chart_order.put("apraxia_sympt", 34);
		read_order_from_file(chart_order, "chart_part1.txt");
		return chart_order;

		/*chart3_order.put("Parkinsonism", 1);
	    chart3_order.put("Atypical parkinsonism", 2);
	    chart3_order.put("Bradykinesia", 3);
	    chart3_order.put("Hypomimia", 4);
	    chart3_order.put("Hypophonia", 5);
	    chart3_order.put("Micrographia", 6);
	    chart3_order.put("Resting tremor", 7);
	    chart3_order.put("Action tremor", 8);
	    chart3_order.put("Postural tremor", 9);
	    chart3_order.put("Dystonic tremor", 10);
	    chart3_order.put("Tremor (any or unspecified)", 11);
	    chart3_order.put("Rigidity", 12);
	    chart3_order.put("Postural instability", 13);
	    chart3_order.put("Gait difficulties falls", 14);
	    chart3_order.put("Levodopa response", 15);
	    chart3_order.put("Response quantification", 16);
	    chart3_order.put("Dyskinesia", 17);
	    chart3_order.put("Motor fluctuations", 18);
	    chart3_order.put("Diurnal fluctuations", 19);
	    chart3_order.put("Sleep benefit", 20);
	    chart3_order.put("Spasticity/pyramidal signs", 21);
	    chart3_order.put("Dystonia", 22);
	    chart3_order.put("Myoclonus", 23);
	    chart3_order.put("Chorea", 24);
	    chart3_order.put("Tics", 25);
	    chart3_order.put("Ataxia dysdiadochokinesia", 26);
	    chart3_order.put("Swallowing disorder", 27);
	    chart3_order.put("Dysarthria anarthria", 28);
	    chart3_order.put("Dysphagia", 29);
	    chart3_order.put("Tongue protrusions", 30);
	    chart3_order.put("Saccadic abnormalities", 31);
	    chart3_order.put("Oculogyric spasms", 32);
	    chart3_order.put("Gaze palsy", 33);
	    chart3_order.put("Apraxia", 34);
		return chart3_order;*/
	}

	private Map<String, Integer> chart_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("cerebral_atrophy_sympt", 1);
		chart_order.put("global_developmental_delay_HP:0001263", 2);
		chart_order.put("intellectual_developmental_disorder_sympt", 3);
		chart_order.put("cognitive_decline_sympt", 4);
		chart_order.put("primitive_reflexes_sympt", 5);
		chart_order.put("behavioral_abnormalities_HP:0000708", 6);
		chart_order.put("depression_sympt", 7);
		chart_order.put("depression_HP:0000716", 7);
		chart_order.put("anxiety_sympt", 8);
		chart_order.put("anxiety_HP:0000739", 8);
		chart_order.put("psychotic_sympt", 9);
		chart_order.put("hallucinations_HP:0000738", 10);
		chart_order.put("panic_attacks_sympt", 11);
		chart_order.put("agitation_sympt", 12);
		chart_order.put("impulsive_control_disorder_sympt", 13);
		chart_order.put("sleep_disorder_sympt", 14);
		chart_order.put("RBD_sympt", 15);
		chart_order.put("autonomic_sympt", 16);
		chart_order.put("hypotension_sympt", 17);
		chart_order.put("respiratory_sighs_sympt", 18);
		chart_order.put("incontinence_sympt", 19);
		//WARNING (missing value with the name) : Seizure
		chart_order.put("scoliosis_sympt", 21);
		chart_order.put("pes_cavus_sympt", 22);
		chart_order.put("pes_equinovarus_sympt", 23);
		chart_order.put("cataracts_sympt", 24);
		read_order_from_file(chart_order, "chart_part2.txt");
		return chart_order;
		/*
		chart4_order.put("Cerebral atrophy", 1);
	    chart4_order.put("Global developmental delay", 2);
	    chart4_order.put("Intellectual developmental disorder", 3);
	    chart4_order.put("Cognitive decline", 4);
	    chart4_order.put("Primitive reflexes", 5);
	    chart4_order.put("Behavioral abnormalities", 6);
	    chart4_order.put("Depression", 7);
	    chart4_order.put("Anxiety", 8);
	    chart4_order.put("Psychotic sign/sympt.", 9);
	    chart4_order.put("Hallucinations", 10);
	    chart4_order.put("Panic attacks", 11);
	    chart4_order.put("Agitation", 12);
	    chart4_order.put("Impulsive control disorder", 13);
	    chart4_order.put("Sleep disorder", 14);
	    chart4_order.put("RBD", 15);
	    chart4_order.put("Autonomic sign/sympt.", 16);
	    chart4_order.put("Hypotension", 17);
	    chart4_order.put("Respiratory sighs", 18);
	    chart4_order.put("Incontinence", 19);
	    chart4_order.put("Seizure", 20);
	    chart4_order.put("Scoliosis", 21);
	    chart4_order.put("Pes cavus", 22);
	    chart4_order.put("Pes equinovarus", 23);
	    chart4_order.put("Cataracts", 24);
		return chart4_order;*/
	}

	private Map<String, Integer> chart_xdp() {
		Map<String, Integer> chart_order = new DefaultedMap<>(2);
		chart_order.put("combined_dystonia_sympt", 1);
		chart_order.put("dystonia_HP:0001332", 2);
		chart_order.put("parkinsonism_HP:0001300", 3);
		chart_order.put("focal_dystonia_HP:0004373", 4);
		chart_order.put("segmental_multifocal_dystonia_sympt", 5);
		chart_order.put("generalized_dystonia_HP:0007325", 6);
		chart_order.put("dyst_upper_limb_sympt", 7);
		chart_order.put("dyst_lower_limb_sympt", 8);
		chart_order.put("axial_dystonia_HP:0002530", 9);
		chart_order.put("cervical_dystonia_HP:0000473", 10);
		chart_order.put("blepharospasm_sympt", 11);
		chart_order.put("craniofacial_oromandibular_dystonia_sympt", 12);
		chart_order.put("laryngeal_dystonia_HP:0012049", 13);
		chart_order.put("dysarthria_HP:0001260", 14);
		chart_order.put("bradykinesia_HP:0002067", 15);
		chart_order.put("rigidity_HP:0002063", 16);
		chart_order.put("postural_instability_sympt", 17);
		chart_order.put("tremor_HP:0001337", 18);
		chart_order.put("resting_tremor_HP:0002322", 19);
		chart_order.put("action_tremor_HP:0002345", 20);
		chart_order.put("postural_tremor_HP:0002174", 21);
		chart_order.put("myoclonus_HP:0001336", 22);
		read_order_from_file(chart_order, "chart_xdp.txt");
		return chart_order;
		/*
//		chart5_order.put("Combined dystonia", 1);
//		return chart5_order;*/
	}

	private Map<String, Integer> chart_slc1a3_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("ataxia_sympt", 1);
		chart_order.put("ataxia_ictal_sympt", 2);
		chart_order.put("ataxia_interictal_sympt", 3);
		chart_order.put("limb_ataxia_HP:0002070", 4);
		chart_order.put("limb_ataxia_ictal_sympt", 5);
		chart_order.put("limb_ataxia_interictal_sympt", 6);
		chart_order.put("gait_ataxia_HP:0002066", 7);
		chart_order.put("gait_ataxia_ictal_sympt", 8);
		chart_order.put("gait_ataxia_interictal_sympt", 9);
		chart_order.put("dysarthria_HP:0001260", 10);
		chart_order.put("dysarthria_interictal_sympt", 11);
		chart_order.put("hemiplegia_HP:0002301", 12);
		chart_order.put("hemiplegia_ictal_sympt", 13);
		chart_order.put("nystagmus_HP:0000639", 14);
		chart_order.put("nystagmus_interictal_sympt", 15);
		chart_order.put("myokymia_HP:0002411", 16);
		chart_order.put("visual_blurring_HP:0000622", 17);
		chart_order.put("visual_blurring_ictal_sympt", 18);
		//WARNING (missing value with the name) : Tremor
		chart_order.put("tremor_ictal_sympt", 20);
		chart_order.put("hypermetric_saccade_HP:0007338", 21);
		chart_order.put("hypermetric_saccade_interictal_sympt", 22);
		chart_order.put("jerking_HP:0001336", 23);
		chart_order.put("generalized_hyperreflexia_HP:0007034", 24);
		//WARNING (missing value with the name) : Trigger exercise
		chart_order.put("trigger_physical_stress_sympt", 26);
		chart_order.put("trigger_emotional_stress_sympt", 27);
		chart_order.put("trigger_temperature_stress_sympt", 28);
		chart_order.put("trigger_nicotine_sympt", 29);
		chart_order.put("trigger_febrile_illness_sympt", 30);
		chart_order.put("trigger_fatigue_sympt", 31);
		read_order_from_file(chart_order, "chart_slc1a3_part1.txt");
	    return chart_order;
	/*
//	    chart_order.put("Ataxia", 1);
//	    chart_order.put("Ataxia (ictal)", 2);
//	    chart_order.put("Ataxia (interictal)", 3);
//	    chart_order.put("Limb ataxia", 4);
//	    chart_order.put("Limb ataxia (ictal)", 5);
//	    chart_order.put("Limb ataxia (interictal)", 6);
//	    chart_order.put("Gait ataxia", 7);
//	    chart_order.put("Gait ataxia (ictal)", 8);
//	    chart_order.put("Gait ataxia (interictal)", 9);
//	    chart_order.put("Dysarthria", 10);
//	    chart_order.put("Dysarthria (interictal)", 11);
//	    chart_order.put("Hemiplegia", 12);
//	    chart_order.put("Hemiplegia (ictal)", 13);
//	    chart_order.put("Nystagmus", 14);
//	    chart_order.put("Nystagmus (interictal)", 15);
//	    chart_order.put("Myokymia", 16);
//	    chart_order.put("Visual blurring", 17);
//	    chart_order.put("Visual blurring (ictal)", 18);
//	    chart_order.put("Tremor", 19);
//	    chart_order.put("Tremor (ictal)", 20);
//	    chart_order.put("Hypermetric saccade", 21);
//	    chart_order.put("Hypermetric saccade (interictal)", 22);
//	    chart_order.put("Jerking", 23);
//	    chart_order.put("Generalized hyperreflexia", 24);
//	    chart_order.put("Trigger exercise", 25);
//	    chart_order.put("Trigger: physical stress", 26);
//	    chart_order.put("Trigger: emotional stress", 27);
//	    chart_order.put("Trigger: temperature stress", 28);
//	    chart_order.put("Trigger: nicotine", 29);
//	    chart_order.put("Trigger: febrile illness", 30);
//	    chart_order.put("Trigger: fatigue", 31);
//	    return chart_order;*/
	}

	private Map<String, Integer> chart_slc1a3_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("vertigo_HP:0002321", 1);
		chart_order.put("vertigo_ictal_sympt", 2);
		chart_order.put("nausea_HP:0002018", 3);
		chart_order.put("nausea_ictal_sympt", 4);
		chart_order.put("dysarthria_ictal_sympt", 5);
		chart_order.put("diplopia_HP:0000651", 6);
		chart_order.put("diploplia_ictal_sympt", 7);
		chart_order.put("headache_HP:0002315", 8);
		chart_order.put("headache_ictal_sympt", 9);
//		WARNING (missing value with the name) : Migraine
		chart_order.put("migraine_ictal_sympt", 11);
		chart_order.put("muscle_weakness_HP:0003324", 12);
		chart_order.put("cognitive_impairment_HP:0100543", 13);
		chart_order.put("cognitive_impairment_interictal_sympt", 14);
		chart_order.put("cerebellar_atrophy_HP:0001272", 15);
		chart_order.put("vomiting_HP:0002013", 16);
		chart_order.put("vomiting_ictal_sympt", 17);
		chart_order.put("seizures_HP:0001250", 18);
		chart_order.put("dizziness_HP:0002321", 19);
		chart_order.put("aphasia_HP:0002381", 20);
		chart_order.put("photophobia_HP:0000613", 21);
		chart_order.put("photophobia_ictal_sympt", 22);
		chart_order.put("phonophobia_HP:0002183", 23);
		chart_order.put("phonophobia_ictal_sympt", 24);
		read_order_from_file(chart_order, "chart_slc1a3_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Vertigo", 1);
//	    chart_order.put("Vertigo (ictal)", 2);
//	    chart_order.put("Nausea", 3);
//	    chart_order.put("Nausea (ictal)", 4);
//	    chart_order.put("Dysarthria (ictal)", 5);
//	    chart_order.put("Diplopia", 6);
//	    chart_order.put("Diploplia (ictal)", 7);
//	    chart_order.put("Headache", 8);
//	    chart_order.put("Headache (ictal)", 9);
//	    chart_order.put("Migraine", 10);
//	    chart_order.put("Migraine (ictal)", 11);
//	    chart_order.put("Muscle weakness", 12);
//	    chart_order.put("Cognitive impairment", 13);
//	    chart_order.put("Cognitive impairment (interictal)", 14);
//	    chart_order.put("Cerebellar atrophy", 15);
//	    chart_order.put("Vomiting", 16);
//	    chart_order.put("Vomiting (ictal)", 17);
//	    chart_order.put("Seizures", 18);
//	    chart_order.put("Dizziness", 19);
//	    chart_order.put("Aphasia", 20);
//	    chart_order.put("Photophobia", 21);
//	    chart_order.put("Photophobia (ictal)", 22);
//	    chart_order.put("Phonophobia", 23);
//	    chart_order.put("Phonophobia (ictal)", 24);
//	    mapSymptomNamesToImportHeaders(chart_order, 1, 25);
//		return chart_order;*/
	}

//	private void mapSymptomNamesToImportHeaders(Map<String, Integer> chart_order, int startInclusive,
//			int endExclusive) {
//		IntStream.range(startInclusive, endExclusive).forEach(x -> {
//	    	chart_order.entrySet().stream().forEach(x1 -> {
//		    	if (x1.getValue().intValue() == x) {
//			    	List<String> collect = symptomDAO.findAll().stream().filter(x2-> x2.getName().trim().equals(x1.getKey())).map(x2 -> x2.getImportHeader()).collect(Collectors.toList());
//			    	if (collect.size() > 0) {
//			    		for (String s : collect) {
//				    		System.out.println("chart_order.put(\"" + s + "\", " + x1.getValue().intValue() + ");");
//			    		}
//			    	} else {
//			    		System.out.println("WARNING (missing value with the name) : " + x1.getKey());
//			    	}
//		    	}
//		    });
//	    });
//	}

	private Map<String, Integer> chart_slc6a3_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("dyst_park_other_dyskinesia_sympt", 1);
		chart_order.put("dystonia_sympt", 2);
		chart_order.put("dystonia _HP:0001332", 2);
		//WARNING (missing value with the name) : Limb Dystonia
		chart_order.put("dyst_arm_sympt", 4);
		chart_order.put("dyst_hand_sympt", 5);
		chart_order.put("dyst_leg_sympt", 6);
		chart_order.put("dyst_foot_sympt", 7);
		chart_order.put("axial_dystonia_HP:0002530", 8);
		chart_order.put("focal_dystonia_HP:0004373", 9);
		chart_order.put("generalized_dystonia_HP:0007325", 10);
		chart_order.put("oromandibular_dystonia_HP:0012048", 11);
		chart_order.put("laryngeal_dystonia_HP:0012049", 12);
		chart_order.put("dysarthria_HP:0001260", 13);
		chart_order.put("anarthria_HP:0002425", 14);
		chart_order.put("dysphonia_HP:0001618", 15);
		chart_order.put("craniofacial_dystonia_HP:0012179", 16);
		chart_order.put("dyst_upper_face_sympt", 17);
		chart_order.put("dyst_lower_face_sympt", 18);
		chart_order.put("dyst_jaw_sympt", 19);
		chart_order.put("cervical_dystonia_HP:0000473", 20);
		chart_order.put("torticollis_HP:0000473", 21);
		chart_order.put("retrocollis_HP:0002544", 22);
		chart_order.put("dyst_rest_sympt", 23);
		chart_order.put("dyst_action", 24);
		chart_order.put("dyst_post_sympt", 25);
		chart_order.put("intention_tremor_HP:0002080", 26);
		chart_order.put("tremor_action_sympt", 27);
		chart_order.put("action_tremor_HP:0002345", 27);
		chart_order.put("tremor_postural_sympt", 28);
		chart_order.put("postural_tremor_HP:0002174", 28);
		chart_order.put("tremor_dystonic_sympt", 29);
		chart_order.put("dystonic_tremor_HP:0030185", 29);
		chart_order.put("head_tremor_HP:0002346", 30);
		chart_order.put("hand tremor_HP:0002378", 31);
		//WARNING (missing value with the name) : Upper Limb postural tremor
		chart_order.put("kinetic_tremor_HP:0030186", 33);
		chart_order.put("limb_tremor_HP:0200085", 34);
		chart_order.put("dystonic_crisis_sympt", 35);
		chart_order.put("oculogyric_crisis_HP:010553", 36);
		read_order_from_file(chart_order, "chart_slc6a3_part1.txt");
		return chart_order;
		/*
//		chart_order.put("Dystonia, parkinsonism or dyskinesia symptoms",1);
//		chart_order.put("Dystonia",2);
//		chart_order.put("Limb Dystonia",3);
//		chart_order.put("Arm dystonia",4);
//		chart_order.put("Hand dystonia",5);
//		chart_order.put("Leg dystonia",6);
//		chart_order.put("Foot dystonia",7);
//		chart_order.put("Axial dystonia",8);
//		chart_order.put("Focal dystonia",9);
//		chart_order.put("Generalized dystonia",10);
//		chart_order.put("Oromandibular dystonia",11);
//		chart_order.put("Laryngeal dystonia",12);
//		chart_order.put("Dysarthria",13);
//		chart_order.put("Anarthria",14);
//		chart_order.put("Dysphonia",15);
//		chart_order.put("Craniofacial dystonia",16);
//		chart_order.put("Upper face dystonia",17);
//		chart_order.put("Lower face dystonia",18);
//		chart_order.put("Jaw dystonia",19);
//		chart_order.put("Cervical dystonia",20);
//		chart_order.put("Torticollis",21);
//		chart_order.put("Retrocollis",22);
//		chart_order.put("Dystonia at rest",23);
//		chart_order.put("Task-specific dystonia",24);
//		chart_order.put("Dystonic posturing",25);
//		chart_order.put("Intention tremor",26);
//		chart_order.put("Action tremor",27);
//		chart_order.put("Postural tremor",28);
//		chart_order.put("Dystonic tremor",29);
//		chart_order.put("Head tremor",30);
//		chart_order.put("Hand tremor",31);
//		chart_order.put("Upper Limb postural tremor",32);
//		chart_order.put("Kinetic tremor",33);
//		chart_order.put("Limb tremor",34);
//		chart_order.put("Dystonic crisis",35);
//		chart_order.put("Oculogyric crisis",36);
//	    return chart_order;*/
	}

	private Map<String, Integer> chart_slc6a3_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("parkinsonism_HP:0001300", 1);
		chart_order.put("bradykinesia_sympt", 2);
		chart_order.put("bradykinesia_HP:0002067", 2);
		//WARNING (missing value with the name) : Tremor
		chart_order.put("tremor_rest_sympt", 4);
		chart_order.put("resting_tremor_HP:0002322", 4);
		chart_order.put("rigidity_sympt", 5);
		chart_order.put("rigidity_HP:0002063", 5);
		chart_order.put("postural_instability_sympt", 6);
		chart_order.put("postural instability_HP:0002172", 6);
		chart_order.put("dyskinesia_sympt", 7);
		chart_order.put("dyskinesia_HP:0100660", 7);
		chart_order.put("hyperreflexia_sympt", 8);
		chart_order.put("hyperreflexia_HP:0001347", 8);
		chart_order.put("diurnal_fluctuations_sympt", 9);
		chart_order.put("spasticity_HP:0001257", 10);
		chart_order.put("muscular_hypotonia_HP:0001252", 11);
		chart_order.put("cognitive_impairment_HP:0100543", 12);
		chart_order.put("dev_regression_sympt", 13);
		chart_order.put("developmental_regression_HP:0002376", 13);
		chart_order.put("motor_delay_HP:0001270", 14);
		chart_order.put("DD_ID_sympt", 15);
		chart_order.put("seizures_HP:0001250", 16);
		chart_order.put("orolingual_dyskinesia_sympt", 17);
		chart_order.put("saccade_initiation_failure_sympt", 18);
		chart_order.put("ocular_flutter_sympt", 19);
		chart_order.put("slow_saccades_HP:0000514", 20);
		chart_order.put("chorea_sympt", 21);
		chart_order.put("chorea_HP:0002072", 21);
		chart_order.put("ptosis_HP:0000508", 22);
		read_order_from_file(chart_order, "chart_slc6a3_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Parkinsonism",1);
//		chart_order.put("Bradykinesia",2);
//		chart_order.put("Tremor",3);
//		chart_order.put("Resting tremor",4);
//		chart_order.put("Rigidity",5);
//		chart_order.put("Postural instability",6);
//		chart_order.put("Dyskinesia",7);
//		chart_order.put("Hyperreflexia",8);
//		chart_order.put("Diurnal fluctuations",9);
//		chart_order.put("Spasticity",10);
//		chart_order.put("Muscular hypotonia",11);
//		chart_order.put("Cognitive impairment",12);
//		chart_order.put("Developmental regression",13);
//		chart_order.put("Motor delay",14);
//		chart_order.put("Developmental delay/intellectual disability",15);
//		chart_order.put("Seizures",16);
//		chart_order.put("Orolingual dyskinesia",17);
//		chart_order.put("Saccade initiation failure",18);
//		chart_order.put("Ocular flutter",19);
//		chart_order.put("Slow saccades",20);
//		chart_order.put("Chorea",21);
//		chart_order.put("Ptosis",22);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_gch1_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("dystonia_parkinsonism_sympt", 1);
		chart_order.put("dystonia_HP:0001332", 2);
		chart_order.put("generalized_dystonia_HP:0007325", 3);
		chart_order.put("segmental_multifocal_dystonia_sympt", 4);
		chart_order.put("focal_dystonia_HP:0004373", 5);
		chart_order.put("laryngeal_dystonia_HP:0012049", 6);
		chart_order.put("dyst_upper_face_sympt", 7);
		chart_order.put("dyst_lower_face_sympt", 8);
		chart_order.put("cervical_dystonia_HP:0000473", 9);
		chart_order.put("torticollis_HP:0000473", 10);
		chart_order.put("retrocollis_HP:0002544", 11);
		chart_order.put("limb_dystonia_HP:0002451", 12);
		chart_order.put("dyst_arm_sympt", 13);
		chart_order.put("dyst_hand_sympt", 14);
		chart_order.put("dyst_leg_sympt", 15);
		chart_order.put("dyst_foot_sympt", 16);
		chart_order.put("axial_dystonia_HP:0002530", 17);
		chart_order.put("dyst_action", 18);
		chart_order.put("dysphonia_HP:0001618", 19);
		chart_order.put("dysarthria_HP:0001260", 20);
		chart_order.put("anarthria_HP:0002425", 21);
		chart_order.put("muscular_hypotonia_HP:0001252", 22);
		chart_order.put("dyskinesia_sympt", 23);
		chart_order.put("dyskinesia_HP:0100660", 23);
		chart_order.put("parkinsonism_sympt", 24);
		chart_order.put("parkinsonism_HP:0001300", 24);
		chart_order.put("bradykinesia_sympt", 25);
		chart_order.put("bradykinesia_HP:0002067", 25);
		chart_order.put("tremor_rest_sympt", 26);
		chart_order.put("resting_tremor_HP:0002322", 26);
		chart_order.put("tremor_unspecified_sympt", 27);
		chart_order.put("tremor_HP:0001337", 27);
		chart_order.put("limb_tremor_HP:0200085", 28);
		chart_order.put("tremor_action_sympt", 29);
		chart_order.put("action_tremor_HP:0002345", 29);
		chart_order.put("tremor_postural_sympt", 30);
		chart_order.put("postural_tremor_HP:0002174", 30);
		chart_order.put("rigidity_sympt", 31);
		chart_order.put("rigidity_HP:0002063", 31);
		chart_order.put("spasticity_HP:0001257", 32);
		chart_order.put("hyperreflexia_sympt", 33);
		chart_order.put("hyperreflexia_HP:0001347", 33);
		chart_order.put("diurnal_fluctuations_sympt", 34);
		chart_order.put("motor_fluctuations_sympt", 35);
		read_order_from_file(chart_order, "chart_gch1_part1.txt");
		return chart_order;
		/*
//		chart_order.put("Dystonia/Parkinsonism", 1);
//		chart_order.put("Dystonia (any or unspecified)", 2);
//		chart_order.put("Generalized dystonia", 3);
//		chart_order.put("Segmental/Multifocal dystonia", 4);
//		chart_order.put("Focal dystonia", 5);
//		chart_order.put("Laryngeal dystonia", 6);
//		chart_order.put("Upper face dystonia", 7);
//		chart_order.put("Lower face dystonia", 8);
//		chart_order.put("Cervical dystonia", 9);
//		chart_order.put("Torticollis", 10);
//		chart_order.put("Retrocollis", 11);
//		chart_order.put("Limb dystonia", 12);
//		chart_order.put("Arm dystonia", 13);
//		chart_order.put("Hand dystonia", 14);
//		chart_order.put("Leg dystonia", 15);
//		chart_order.put("Foot dystonia", 16);
//		chart_order.put("Axial dystonia", 17);
//		chart_order.put("Task-specific dystonia", 18);
//		chart_order.put("Dysphonia", 19);
//		chart_order.put("Dysarthria", 20);
//		chart_order.put("Anarthria", 21);
//		chart_order.put("Muscular hypotonia", 22);
//		chart_order.put("Dyskinesia", 23);
//		chart_order.put("Parkinsonism", 24);
//		chart_order.put("Bradykinesia", 25);
//		chart_order.put("Resting tremor", 26);
//		chart_order.put("Tremor (any or unspecified)", 27);
//		chart_order.put("Limb tremor", 28);
//		chart_order.put("Action tremor", 29);
//		chart_order.put("Postural tremor", 30);
//		chart_order.put("Rigidity", 31);
//		chart_order.put("Spasticity", 32);
//		chart_order.put("Hyperreflexia", 33);
//		chart_order.put("Diurnal fluctuations", 34);
//		chart_order.put("Motor fluctuations", 35);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_gch1_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("sleep_benefit_sympt", 1);
		chart_order.put("autonomic_sympt", 2);
		chart_order.put("global_developmental_delay_HP:0001263", 3);
		chart_order.put("dev_regression_sympt", 4);
		chart_order.put("developmental_regression_HP:0002376", 4);
		chart_order.put("delayed_speech_and_language_development_HP:0000750", 5);
		chart_order.put("motor_delay_HP:0001270", 6);
		chart_order.put("depression_sympt", 7);
		chart_order.put("depression_HP:0000716", 7);
		chart_order.put("anxiety_sympt", 8);
		chart_order.put("anxiety_HP:0000739", 8);
		chart_order.put("abnormality_of_the_sense_of_smell_HP:0004408", 9);
		chart_order.put("sleep_disorder_sympt", 10);
		read_order_from_file(chart_order, "chart_gch1_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Sleep benefit", 1);
//		chart_order.put("Autonomic sign/sympt.", 2);
//		chart_order.put("Global developmental delay", 3);
//		chart_order.put("Developmental regression", 4);
//		chart_order.put("Delayed speech and language development", 5);
//		chart_order.put("Motor delay", 6);
//		chart_order.put("Depression", 7);
//		chart_order.put("Anxiety", 8);
//		chart_order.put("Abnormality of the sense of smell", 9);
//		chart_order.put("Sleep disorder", 10);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_parka_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("dystonia_HP:0001332", 1);
		chart_order.put("generalized_dystonia_HP:0007325", 2);
		chart_order.put("segmental_multifocal_dystonia_sympt", 3);
		chart_order.put("focal_dystonia_HP:0004373", 4);
		chart_order.put("laryngeal_dystonia_HP:0012049", 5);
		chart_order.put("dyst_tongue_sympt", 6);
		chart_order.put("oromandibular_dystonia_HP:0012048", 7);
		chart_order.put("craniofacial_dystonia_HP:0012179", 8);
		chart_order.put("cervical_dystonia_HP:0000473", 9);
		chart_order.put("torticollis_HP:0000473", 10);
		chart_order.put("retrocollis_HP:0002544", 11);
		chart_order.put("limb_dystonia_HP:0002451", 12);
		chart_order.put("dyst_arm_sympt", 13);
		chart_order.put("dyst_hand_sympt", 14);
		chart_order.put("dyst_leg_sympt", 15);
		chart_order.put("dyst_foot_sympt", 16);
		chart_order.put("axial_dystonia_HP:0002530", 17);
		chart_order.put("dysphonia_HP:0001618", 18);
		chart_order.put("myoclonus_sympt", 19);
		chart_order.put("myoclonus_HP:0001336", 19);
		chart_order.put("dysarthria_HP:0001260", 20);
		chart_order.put("anarthria_HP:0002425", 21);
		chart_order.put("muscular_hypotonia_HP:0001252", 22);
		chart_order.put("dyskinesia_sympt", 23);
		chart_order.put("dyskinesia_HP:0100660", 23);
		chart_order.put("parkinsonism_sympt", 24);
		chart_order.put("parkinsonism_HP:0001300", 24);
		chart_order.put("bradykinesia_sympt", 25);
		chart_order.put("bradykinesia_HP:0002067", 25);
		chart_order.put("tremor_rest_sympt", 26);
		chart_order.put("resting_tremor_HP:0002322", 26);
		chart_order.put("tremor_unspecified_sympt", 27);
		chart_order.put("tremor_HP:0001337", 27);
		chart_order.put("head_tremor_HP:0002346", 28);
		chart_order.put("tremor_dystonic_sympt", 29);
		chart_order.put("dystonic_tremor_HP:0030185", 29);
		chart_order.put("postural_instability_sympt", 30);
		chart_order.put("postural instability_HP:0002172", 30);
		chart_order.put("limb_tremor_HP:0200085", 31);
		chart_order.put("tremor_action_sympt", 32);
		chart_order.put("action_tremor_HP:0002345", 32);
		chart_order.put("tremor_postural_sympt", 33);
		chart_order.put("postural_tremor_HP:0002174", 33);
		chart_order.put("rigidity_sympt", 34);
		chart_order.put("rigidity_HP:0002063", 34);
		chart_order.put("spasticity_HP:0001257", 35);
		chart_order.put("hyperreflexia_sympt", 36);
		chart_order.put("hyperreflexia_HP:0001347", 36);
		read_order_from_file(chart_order, "chart_parka_part1.txt");
		return chart_order;
		/*
//		chart_order.put("Dystonia (any or unspecified)", 1);
//		chart_order.put("Generalized dystonia", 2);
//		chart_order.put("Segmental/Multifocal dystonia", 3);
//		chart_order.put("Focal dystonia", 4);
//		chart_order.put("Laryngeal dystonia", 5);
//		chart_order.put("Tongue dystonia", 6);
//		chart_order.put("Oromandibular dystonia", 7);
//		chart_order.put("Craniofacial dystonia", 8);
//		chart_order.put("Cervical dystonia", 9);
//		chart_order.put("Torticollis", 10);
//		chart_order.put("Retrocollis", 11);
//		chart_order.put("Limb dystonia", 12);
//		chart_order.put("Arm dystonia", 13);
//		chart_order.put("Hand dystonia", 14);
//		chart_order.put("Leg dystonia", 15);
//		chart_order.put("Foot dystonia", 16);
//		chart_order.put("Axial dystonia", 17);
//		chart_order.put("Dysphonia", 18);
//		chart_order.put("Myoclonus", 19);
//		chart_order.put("Dysarthria", 20);
//		chart_order.put("Anarthria", 21);
//		chart_order.put("Muscular hypotonia", 22);
//		chart_order.put("Dyskinesia", 23);
//		chart_order.put("Parkinsonism", 24);
//		chart_order.put("Bradykinesia", 25);
//		chart_order.put("Resting tremor", 26);
//		chart_order.put("Tremor (any or unspecified)", 27);
//		chart_order.put("Head tremor", 28);
//		chart_order.put("Dystonic tremor", 29);
//		chart_order.put("Postural instability", 30);
//		chart_order.put("Limb tremor", 31);
//		chart_order.put("Action tremor", 32);
//		chart_order.put("Postural tremor", 33);
//		chart_order.put("Rigidity", 34);
//		chart_order.put("Spasticity", 35);
//		chart_order.put("Hyperreflexia", 36);
//		return chart_order;*/
	}


	private Map<String, Integer> chart_parka_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("global_developmental_delay_HP:0001263", 1);
		chart_order.put("mild_global_developmental_delay_HP:0011342", 2);
		chart_order.put("severe_global_developmental_delay_HP:0011344", 3);
		chart_order.put("cognitive_impairment_HP:0100543", 4);
		chart_order.put("motor_delay_HP:0001270", 5);
		read_order_from_file(chart_order, "chart_parka_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Global developmental delay", 1);
//		chart_order.put("Mild global developmental delay", 2);
//		chart_order.put("Severe global developmental delay", 3);
//		chart_order.put("Cognitive impairment", 4);
//		chart_order.put("Motor delay", 5);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_kcna1_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("nystagmus_ictal_sympt", 1);
		chart_order.put("episodic_ataxia_HP:0002131", 2);
		chart_order.put("ataxia_sympt", 3);
		chart_order.put("cerebellar_ataxia_HP:0001251", 4);
		chart_order.put("myokymia_ictal_sympt", 5);
		chart_order.put("neuromyotonia_ictal_sympt", 6);
		chart_order.put("muscular_hypotonia_ictal_sympt", 7);
		chart_order.put("hypertonia_ictal_sympt", 8);
		chart_order.put("muscle_weakness_ictal_sympt", 9);
		chart_order.put("muscle_spasms_HP:0002487", 10);
		chart_order.put("muscle_cramps_sympt", 11);
		chart_order.put("muscle_cramps_ictal_sympt", 12);
		chart_order.put("upper_motor_neuron_dysfunction_ictal_sympt", 13);
		chart_order.put("spasticity_ictal_sympt", 14);
		chart_order.put("dystonia_sympt", 15);
		chart_order.put("dystonia _HP:0001332", 15);
		chart_order.put("dystonia_ictal_sympt", 16);
		chart_order.put("tonic_upgaze_sympt", 17);
		chart_order.put("tonic_upgaze_ictal_sympt", 18);
		chart_order.put("tremor_interictal_sympt", 19);
		chart_order.put("choreoathetosis_HP:0001266", 20);
		chart_order.put("choreoathetosis_ictal_sympt", 21);
		chart_order.put("muscle_stiffness_HP:0003552", 22);
		chart_order.put("rigidity_ictal_sympt", 23);
		chart_order.put("leg_rigidity_sympt", 24);
		chart_order.put("myokymia_interictal_sympt", 25);
		chart_order.put("neuromyotonia_interictal_sympt", 26);
		chart_order.put("muscular_hypotonia_interictal_sympt", 27);
		chart_order.put("hypertonia_interictal_sympt", 28);
		chart_order.put("muscle_weakness_interictal_sympt", 29);
		chart_order.put("muscle_cramps_interictal_sympt", 30);
		chart_order.put("upper_motor_neuron_dysfunction_interictal_sympt", 31);
		chart_order.put("spasticity_interictal_sympt", 32);
		chart_order.put("dystonia_interictal_sympt", 33);
		chart_order.put("hemiplegia_interictal_sympt", 34);
		chart_order.put("tonic_upgaze_interictal_sympt", 35);
		chart_order.put("rigidity_interictal_sympt", 36);
		read_order_from_file(chart_order, "chart_kcna1_part1.txt");
		return chart_order;
		/*
//		chart_order.put("Nystagmus (ictal)", 1);
//		chart_order.put("Episodia ataxia", 2);
//		chart_order.put("Ataxia", 3);
//		chart_order.put("Cerebellar ataxia", 4);
//		chart_order.put("Myokymia (ictal)", 5);
//		chart_order.put("Neuromyotonia (ictal)", 6);
//		chart_order.put("Muscular hypotonia (ictal)", 7);
//		chart_order.put("Hypertonia (ictal)", 8);
//		chart_order.put("Muscle weakness (ictal)", 9);
//		chart_order.put("Muscle spasms", 10);
//		chart_order.put("Muscle cramps", 11);
//		chart_order.put("Muscle cramps (ictal)", 12);
//		chart_order.put("Upper motor neuron dysfunction (ictal)", 13);
//		chart_order.put("Spasticity (ictal)", 14);
//		chart_order.put("Dystonia", 15);
//		chart_order.put("Dystonia (ictal)", 16);
//		chart_order.put("Tonic upgaze", 17);
//		chart_order.put("Tonic upgaze (ictal)", 18);
//		chart_order.put("Tremor (interictal)", 19);
//		chart_order.put("Choreoathetosis", 20);
//		chart_order.put("Choreoathetosis (ictal)", 21);
//		chart_order.put("Muscle stiffness", 22);
//		chart_order.put("Rigidity (ictal)", 23);
//		chart_order.put("Leg rigidity", 24);
//		chart_order.put("Myokymia (interictal)", 25);
//		chart_order.put("Neuromyotonia (interictal)", 26);
//		chart_order.put("Muscular hypotonia (interictal)", 27);
//		chart_order.put("Hypertonia (interictal)", 28);
//		chart_order.put("Muscle weakness (interictal)", 29);
//		chart_order.put("Muscle cramps (interictal)", 30);
//		chart_order.put("Upper motor neuron dysfunction (interictal)", 31);
//		chart_order.put("Spasticity (interictal)", 32);
//		chart_order.put("Dystonia (interictal)", 33);
//		chart_order.put("Hemiplegia (interictal)", 34);
//		chart_order.put("Tonic upgaze (interictal)", 35);
//		chart_order.put("Rigidity (interictal)", 36);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_kcna1_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("nausea_interictal_sympt", 1);
		chart_order.put("dizziness_ictal_sympt", 2);
		chart_order.put("fatigue_ictal_sympt", 3);
		chart_order.put("subdomain_cognitive_impairment_sympt", 4);
//		WARNING (missing value with the name) : Cognitive decline scale
		chart_order.put("cognitive_impairment_ictal_sympt ", 6);
		chart_order.put("depression_ictal_sympt", 7);
		chart_order.put("visual_disturbance_sympt", 8);
		chart_order.put("tinnitus_ictal_sympt", 9);
		chart_order.put("slurred_speech_HP:0001350", 10);
		chart_order.put("respiratory_distress_ictal_sympt", 11);
		chart_order.put("seizures_ictal_sympt", 12);
		chart_order.put("seizures_interictal_sympt", 13);
		chart_order.put("dizziness_interictal_sympt", 14);
		chart_order.put("fatigue_interictal_sympt", 15);
		chart_order.put("depression_interictal_sympt", 16);
		chart_order.put("diploplia_interictal_sympt", 17);
		chart_order.put("headache_interictal_sympt", 18);
		chart_order.put("migraine_interictal_sympt", 19);
		chart_order.put("visual_blurring_interictal_sympt", 20);
		chart_order.put("tinnitus_interictal_sympt ", 21);
		chart_order.put("respiratory_distress_interictal_sympt", 22);
		read_order_from_file(chart_order, "chart_kcna1_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Nausea (interictal)", 1);
//		chart_order.put("Dizziness (ictal)", 2);
//		chart_order.put("Fatigue (ictal)", 3);
//		chart_order.put("Cognitive impairment subdomain", 4);
//		chart_order.put("Cognitive decline scale", 5);
//		chart_order.put("Cognitive impairment (ictal)", 6);
//		chart_order.put("Depression (ictal)", 7);
//		chart_order.put("Visual disturbance", 8);
//		chart_order.put("Tinnitus (ictal)", 9);
//		chart_order.put("Slurred speech", 10);
//		chart_order.put("Respiratory distress (ictal)", 11);
//		chart_order.put("Seizures (ictal)", 12);
//		chart_order.put("Seizures (interictal)", 13);
//		chart_order.put("Dizziness (interictal)", 14);
//		chart_order.put("Fatigue (interictal)", 15);
//		chart_order.put("Depression (interictal)", 16);
//		chart_order.put("Diploplia (interictal)", 17);
//		chart_order.put("Headache (interictal)", 18);
//		chart_order.put("Migraine (interictal)", 19);
//		chart_order.put("Visual blurring (interictal)", 20);
//		chart_order.put("Tinnitus (interictal)", 21);
//		chart_order.put("Respiratory distress (interictal)", 22);
//		return chart_order;*/
	}

	private Map<String, Integer> chart_ADCY5_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("dyskinesia_sympt", 1);
		chart_order.put("dyskinesia_HP:0100660", 1);
		chart_order.put("chorea_sympt", 3);
		chart_order.put("chorea_HP:0002072", 3);
		chart_order.put("gait_impairment_HP:0001288", 4);
		chart_order.put("hyperreflexia_sympt", 5);
		chart_order.put("hyperreflexia_HP:0001347", 5);
		chart_order.put("myoclonus_sympt", 6);
		chart_order.put("myoclonus_HP:0001336", 6);
		chart_order.put("facial_twitches_HP:0011468", 7);
		chart_order.put("motor_delay_HP:0001270", 8);
		chart_order.put("limb_dystonia_HP:0002451", 9);
		chart_order.put("dysarthria_HP:0001260", 10);
		chart_order.put("paroxysmal_dyskinesia_HP:0007166", 11);
		chart_order.put("spasticity_HP:0001257", 12);
		chart_order.put("cerebellar_sympt", 13);
		chart_order.put("myokymia_HP:0002411", 14);
		chart_order.put("tremor_unspecified_sympt", 15);
		chart_order.put("tremor_HP:0001337", 15);
		chart_order.put("delayed_gross_motor_development_HP:0002194", 16);
		chart_order.put("trigger_stress_sympt", 17);
		chart_order.put("generalized_dystonia_HP:0007325", 18);
		chart_order.put("axial_dystonia_HP:0002530", 19);
		chart_order.put("cervical_dystonia_HP:0000473", 20);
		chart_order.put("dyst_arm_sympt", 21);
		chart_order.put("muscular_hypotonia_HP:0001252", 22);
		chart_order.put("trigger_exercise_sympt", 23);
		chart_order.put("dyst_foot_sympt", 24);
		chart_order.put("weakness_sympt", 25);
		chart_order.put("dyst_action", 26);
		chart_order.put("attacks_at_rest_sympt", 27);
		chart_order.put("ballism_sympt", 28);
		chart_order.put("head_tremor_HP:0002346", 29);
		chart_order.put("dyst_hand_sympt", 30);
		chart_order.put("trigger_sleep_deprivation_sympt", 31);
		chart_order.put("torticollis_HP:0000473", 32);
		chart_order.put("trigger_anxiety_sympt", 33);
		chart_order.put("focal_dystonia_HP:0004373", 34);
		chart_order.put("craniofacial_dystonia_HP:0012179", 36);
		chart_order.put("tremor_dystonic_sympt", 37);
		chart_order.put("dystonic_tremor_HP:0030185", 37);
		chart_order.put("tremor_postural_sympt", 38);
		chart_order.put("postural_tremor_HP:0002174", 38);
		chart_order.put("trigger_sudden_movement_sympt", 39);
		chart_order.put("tremor_rest_sympt", 40);
		chart_order.put("resting_tremor_HP:0002322", 40);
		chart_order.put("retrocollis_HP:0002544", 41);
		chart_order.put("laryngeal_dystonia_HP:0012049", 43);
		chart_order.put("oromandibular_dystonia_HP:0012048", 45);
		chart_order.put("limb_tremor_HP:0200085", 46);
		read_order_from_file(chart_order, "chart_ADCY5_part1.txt");
		return chart_order;
/*
		chart_order.put("Dyskinesia", 1);
//		chart_order.put("Motor symptoms", 2);
		chart_order.put("Chorea", 3);
		chart_order.put("Gait impairment", 4);
		chart_order.put("Hyperreflexia", 5);
		chart_order.put("Myoclonus", 6);
		chart_order.put("Facial twitches", 7);
		chart_order.put("Motor delay", 8);
		chart_order.put("Limb dystonia", 9);
		chart_order.put("Dysarthria", 10);
		chart_order.put("Paroxysmal dyskinesia", 11);
		chart_order.put("Spasticity", 12);
		chart_order.put("Cerebellar", 13);
		chart_order.put("Myokymia", 14);
		chart_order.put("Tremor (any or unspecified)", 15);
		chart_order.put("Delayed gross motor development", 16);
		chart_order.put("Trigger: Stress", 17);
		chart_order.put("Generalized dystonia", 18);
		chart_order.put("Axial dystonia", 19);
		chart_order.put("Cervical dystonia", 20);
		chart_order.put("Arm dystonia", 21);
		chart_order.put("Muscular hypotonia", 22);
		chart_order.put("Trigger: Exercise", 23);
		chart_order.put("Foot dystonia", 24);
		chart_order.put("Weakness", 25);
		chart_order.put("Task-specific dystonia", 26);
		chart_order.put("Attacks at rest", 27);
		chart_order.put("Ballism", 28);
		chart_order.put("Head tremor", 29);
		chart_order.put("Hand dystonia", 30);
		chart_order.put("Trigger: Sleep deprivation", 31);
		chart_order.put("Torticollis", 32);
		chart_order.put("Trigger: Anxiety", 33);
		chart_order.put("Focal dystonia", 34);
//		chart_order.put("PKD", 35);
		chart_order.put("Craniofacial dystonia", 36);
		chart_order.put("Dystonic tremor", 37);
		chart_order.put("Postural tremor", 38);
		chart_order.put("Trigger: Sudden movement", 39);
		chart_order.put("Resting tremor", 40);
		chart_order.put("Retrocollis", 41);
//		chart_order.put("Trigger: Alcohol", 42);
		chart_order.put("Laryngeal dystonia", 43);
//		chart_order.put("Hemiplegic spells", 44);
		chart_order.put("Oromandibular dystonia", 45);
		chart_order.put("Limb tremor", 46);
//		chart_order.put("Dysphonia", 47);
//		chart_order.put("Trigger: Caffeine", 48);
//		chart_order.put("Trigger: Prolonged fasting", 49);
//		chart_order.put("Trigger: Intention to move", 50);
		mapSymptomNamesToImportHeaders(chart_order, 1, 47);
		return chart_order;*/
	}

	private Map<String, Integer> chart_ADCY5_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("cognitive_impairment_HP:0100543", 1);
		chart_order.put("delayed_speech_and_language_development_HP:0000750", 2);
		chart_order.put("dev_regression_sympt", 3);
		chart_order.put("developmental_regression_HP:0002376", 3);
		chart_order.put("seizures_HP:0001250", 4);
		chart_order.put("global_developmental_delay_HP:0001263", 5);
		chart_order.put("anarthria_HP:0002425", 6);
		chart_order.put("tics_HP:0100033", 7);
		chart_order.put("mild_global_developmental_delay_HP:0011342", 8);
		read_order_from_file(chart_order, "chart_ADCY5_part2.txt");
		return chart_order;
		/*
//		chart_order.put("Cognitive impairment", 1);
//		chart_order.put("Delayed speech and language development", 2);
//		chart_order.put("Developmental regression", 3);
//		chart_order.put("Seizures", 4);
//		chart_order.put("Global developmental delay", 5);
//		chart_order.put("Anarthria", 6);
//		chart_order.put("Tics", 7);
//		chart_order.put("Mild global developmental delay", 8);
//		return chart_order;*/
	}


	private Map<String, Integer> chart_NKX2_1_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		/*
//		chart_order.put("motor_sympt", 1);*/
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("bradykinesia_sympt", 1);
		chart_order.put("tremor_HP:0001337", 1);
		chart_order.put("tremor_rest_sympt", 1);
		chart_order.put("tremor_action_sympt", 1);
		chart_order.put("tremor_postural_sympt", 1);
		chart_order.put("tremor_dystonic_sympt", 1);
		chart_order.put("rigidity_sympt", 1);
		chart_order.put("postural_instability_sympt", 1);
		chart_order.put("dyskinesia_sympt", 1);
		chart_order.put("dystonia_sympt", 1);
		chart_order.put("hyperreflexia_sympt", 1);
		chart_order.put("diurnal_fluctuations_sympt", 1);
		chart_order.put("sleep_benefit_sympt", 1);
		chart_order.put("motor_fluctuations_sympt", 1);
		chart_order.put("atypical_park_sympt", 1);
		chart_order.put("athetosis_sympt", 1);
		chart_order.put("chorea_sympt", 1);
		chart_order.put("ballism_sympt", 1);
		chart_order.put("myoclonus_sympt", 1);
		chart_order.put("ataxia_sympt", 1);
		chart_order.put("trigger_sudden_movement_sympt", 1);
		chart_order.put("trigger_stress_sympt", 1);
		chart_order.put("trigger_startle_sympt", 1);
		chart_order.put("trigger_intention_move_sympt", 1);
		chart_order.put("trigger_anxiety_sympt", 1);
		chart_order.put("trigger_exercise_sympt", 1);
		chart_order.put("trigger_sleep_deprivation_sympt", 1);
		chart_order.put("trigger_caffeine_sympt", 1);
		chart_order.put("trigger_alcohol_sympt", 1);
		chart_order.put("trigger_prolonged_fasting_sympt", 1);
		chart_order.put("attacks_at_rest_sympt", 1);
		chart_order.put("attacks_bilateral_sympt", 1);
		chart_order.put("attacks_UL_sympt", 1);
		chart_order.put("attacks_LL_sympt", 1);
		chart_order.put("attacks_trunk_sympt", 1);
		chart_order.put("attacks_neck_sympt", 1);
		chart_order.put("attacks_face_sympt", 1);
		chart_order.put("seizure_sympt", 1);
		chart_order.put("PKD_sympt", 1);
		chart_order.put("cerebellar_sympt", 1);
		chart_order.put("dystonia_HP:0001332", 1);
		chart_order.put("limb_dystonia_sympt", 1);
		chart_order.put("Dyst_arm_sympt", 1);
		chart_order.put("dyst_hand_sympt", 1);
		chart_order.put("dyst_leg_sympt", 1);
		chart_order.put("dyst_foot_sympt", 1);
		chart_order.put("cervical_dystonia_HP:0000473", 1);
		chart_order.put("torticollis_HP:0000473", 1);
		chart_order.put("retrocollis_HP:0002544", 1);
		chart_order.put("axial_dystonia_HP:0002530", 1);
		chart_order.put("focal_dystonia_HP:0004373", 1);
		chart_order.put("generalized_dystonia_HP:0007325", 1);
		chart_order.put("oromandibular_dystonia_HP:0012048", 1);
		chart_order.put("laryngeal_dystonia_HP:0012049", 1);
		chart_order.put("craniofacial_dystonia_HP:0012179", 1);
		chart_order.put("dyst_upper_face_sympt", 1);
		chart_order.put("dyst_lower_face_sympt", 1);
		chart_order.put("dyst_jaw_sympt", 1);
		chart_order.put("dyst_rest_sympt", 1);
		chart_order.put("dyst_post_sympt", 1);
		chart_order.put("intention_tremor_HP:0002080", 1);
		chart_order.put("head_tremor_HP:0002346", 1);
		chart_order.put("hand tremor_HP:0002378", 1);
		chart_order.put("limb_tremor_HP:0200085", 1);
		chart_order.put("upper_limb_postural_tremor_HP:0007351", 1);
		chart_order.put("kinetic_tremor_HP:0030186", 1);
		chart_order.put("myoclonus_rest_sympt", 1);
		chart_order.put("myoclonus_activity_sympt", 1);
		chart_order.put("myokymia_HP:0002411", 1);
		chart_order.put("chorea_face_sympt", 1);
		chart_order.put("chorea_neck_sympt", 1);
		chart_order.put("chorea_tongue_sympt", 1);
		chart_order.put("chorea_limbs_sympt", 1);
		chart_order.put("chorea_trunk_sympt", 1);
		chart_order.put("facial_twitches_HP:0011468", 1);
		chart_order.put("paroxysmal_dyskinesia_HP:0007166", 1);
		chart_order.put("paroxysmal_episodes_sympt", 1);
		chart_order.put("pyramidal_signs_HP:007256", 1);
		chart_order.put("gait_impairment_HP:0001288", 1);
		chart_order.put("oculomotor_abnormality_HP:0000496", 1);
		chart_order.put("axial_hypotonia_HP:0008936", 1);
		chart_order.put("muscular_hypotonia_HP:0001252", 1);
		chart_order.put("painful_movements_sympt", 1);
		chart_order.put("spasticity_HP:0001257", 1);
		chart_order.put("seizures_HP:0001250", 1);
		chart_order.put("motor_delay_HP:0001270", 1);
		chart_order.put("delayed_gross_motor_development_HP:0002194", 1);
		chart_order.put("delayed_fine_motor_development_HP:0010862", 1);
		chart_order.put("dysarthria_HP:0001260", 1);
		chart_order.put("anarthria_HP:0002425", 1);
		chart_order.put("dysphonia_HP:0001618", 1);
		chart_order.put("DD_ID_sympt", 1);
		chart_order.put("drop_attack_sympt", 1);
		chart_order.put("falls_HP:0002527", 1);
		read_order_from_file(chart_order, "chart_NKX2_1_part1.txt");
		return chart_order;
	}

	private Map<String, Integer> chart_NKX2_1_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("olfaction_sympt", 0);
		chart_order.put("depression_sympt", 0);
		chart_order.put("anxiety_sympt", 0);
		chart_order.put("psychotic_sympt", 0);
		chart_order.put("sleep_disorder_sympt", 0);
		chart_order.put("autonomic_sympt", 0);
		chart_order.put("speech_disturbance_sympt", 0);
		chart_order.put("aura_sympt", 0);
		chart_order.put("headache_HP:0002315", 0);
		chart_order.put("migraine_sympt", 0);
		chart_order.put("hemiplegic_migraine_sympt", 0);
		chart_order.put("nocturnal_episodes_sympt", 0);
		chart_order.put("sleep_disruption_sympt", 0);
		chart_order.put("cognitive_impairment_HP:0100543", 0);
		chart_order.put("developmental_regression_HP:0002376", 0);
		chart_order.put("develop_delay_sympt", 0);
		chart_order.put("global_developmental_delay_HP:0001263", 0);
		chart_order.put("mild_global_developmental_delay_HP:0011342", 0);
		chart_order.put("moderate_global_developmental_delay_sympt", 0);
		chart_order.put("severe_global_developmental_delay_HP:0011344", 0);
		chart_order.put("profound_global_developmental_delay_HP:0012736", 0);
		chart_order.put("delayed_speech_and_language_development_HP:0000750", 0);
		chart_order.put("psychiatric_features_sympt", 0);
		chart_order.put("hypothyroidism_sympt", 0);
		read_order_from_file(chart_order, "chart_NKX2_1_part2.txt");
		return chart_order;
	}

	private Map<String, Integer> chart_DCTN1_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("parkinsonism_sympt",0);
		chart_order.put("atypical_park_sympt",0);
		chart_order.put("bradykinesia_sympt", 0);
		chart_order.put("rigidity_sympt", 0);
		chart_order.put("tremor_unspecified_sympt", 0);
		chart_order.put("hypomimia_sympt", 0);
		chart_order.put("tremor_rest_sympt", 0);
		chart_order.put("gait_difficulties_falls_sympt", 0);
		chart_order.put("saccadic_abnormalities_sympt", 0);
		chart_order.put("tremor_postural_sympt", 0);
		chart_order.put("gaze_palsy_sympt", 0);
		chart_order.put("postural_instability_sympt", 0);
		chart_order.put("primitive_reflexes_sympt", 0);
		chart_order.put("dysphagia_sympt", 0);
		chart_order.put("dystonia_sympt", 0);
		chart_order.put("tremor_action_sympt", 0);
		chart_order.put("tremor_dystonic_sympt", 0);
		chart_order.put("ataxia_dysdiadochokinesia_sympt", 0);
		chart_order.put("micrographia_sympt", 0);
		chart_order.put("oculogyric_spasms_sympt", 0);
		chart_order.put("spasticity_pyramidal_signs_sympt", 0);
		chart_order.put("respiratory_sighs_sympt", 0);
		chart_order.put("hyperreflexia_sympt", 0);
		chart_order.put("sleep_benefit_sympt", 0);
		chart_order.put("tics_HP:0100033", 0);
		chart_order.put("motor_fluctuations_sympt", 0);
		chart_order.put("dyskinesia_sympt", 0);
		read_order_from_file(chart_order, "chart_DCTN1_part1.txt");
		return chart_order;
	}

	private Map<String, Integer> chart_TH_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("depression_HP:0000716", 0);
		chart_order.put("depression_scale", 0);
		chart_order.put("anxiety_panic attacs_HP:0000739", 0);
		chart_order.put("anxiety_scale", 0);
		chart_order.put("psychosis_HP:0000709", 0);
		chart_order.put("psychotic_scale", 0);
		chart_order.put("sleep_disorder_sympt", 0);
		chart_order.put("cognitive_impairment_HP:0100543", 0);
		chart_order.put("developmental_regression_HP:0002376", 0);
		chart_order.put("develop_delay_sympt", 0);
		chart_order.put("delayed_motor_dev_sympt", 0);
		chart_order.put("intellectual_developmental_disorder_sympt", 0);
		chart_order.put("autonomic_sympt", 0);
		chart_order.put("neuroimaging_MRI abnormalities", 0);
		chart_order.put("metabolite_abnormalities_in CSF", 0);
		chart_order.put("metabolite_abnormalities_in CSF_example", 0);
		chart_order.put("metabolite_abnormalities_in blood", 0);
		chart_order.put("Metabolite_abnormalities_in blood_example", 0);
		chart_order.put("metabolite_abnormalities_in urin", 0);
		chart_order.put("metabolite_abnormalities_in urin_example", 0);
		chart_order.put("hyperphenylalaninemia", 0);
		chart_order.put("Hyperphenylalaninemia_value", 0);
		chart_order.put("operation", 0);
		chart_order.put("operation_procedure", 0);
		chart_order.put("misdiagnosed", 0);
		chart_order.put("missdiagnosis_name", 0);

		read_order_from_file(chart_order, "chart_TH_part2.txt");
		return chart_order;
	}


	private Map<String, Integer> chart_TH_part1() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("gait_difficulties_HP:0001288", 1);
		chart_order.put("dystonia_HP:0001332", 0);
		chart_order.put("limb_dystonia_HP:0002451", 1);
		chart_order.put("upper_limb_dystonia", 1);
		chart_order.put("lower_limb_dystonia", 1);
		chart_order.put("axial_dystonia_HP:0002530", 1);
		chart_order.put("blepharospasm_sympt", 1);
		chart_order.put("dysarthria_HP:0001260", 1);
		chart_order.put("cervical_dystonia_HP:0000473", 1);
		chart_order.put("dyst_action", 1);
		chart_order.put("dyst_onset_body_1", 1);
		chart_order.put("dyst_onset_side", 1);
		chart_order.put("body_distr", 1);
		chart_order.put("patt_dis_course", 1);
		chart_order.put("patt_variab", 1);
		chart_order.put("assoc_feat", 1);
		chart_order.put("alc_response", 1);
		chart_order.put("dyst_instrument1", 1);
		chart_order.put("dyst_score1", 1);
		chart_order.put("dyst_instrument2", 1);
		chart_order.put("dyst_score2", 1);
		chart_order.put("parkinsonism_sympt", 1);
		chart_order.put("bradykinesia_HP:0002067", 1);
		chart_order.put("tremor_HP:0001337", 1);
		chart_order.put("resting_tremor_HP:0002322", 1);
		chart_order.put("action_tremor_HP:0002345", 1);
		chart_order.put("intention_tremor_HP:0002080", 1);
		chart_order.put("rigidity_sympt", 1);
		chart_order.put("postural instability_HP:0002172", 1);
		chart_order.put("levodopa_response", 1);
		chart_order.put("response_quantification", 1);
		chart_order.put("levodopa_dose_mg/day", 1);
		chart_order.put("levodopa_dose_mg/kg/day", 1);
		chart_order.put("other_medication1", 1);
		chart_order.put("other_med1_dose_mg/day", 1);
		chart_order.put("other_med1_dose_mg/kg/day", 1);
		chart_order.put("other_med1_response", 1);
		chart_order.put("other_med1_response_quantification", 1);
		chart_order.put("other_medication2", 1);
		chart_order.put("other_med2_dose_mg/day", 1);
		chart_order.put("other_med2_dose_mg/kg/day", 1);
		chart_order.put("other_med2_response", 1);
		chart_order.put("other_med2_response_quantification", 1);
		chart_order.put("DBS_response", 1);
		chart_order.put("response_quantification", 1);
		chart_order.put("residual motor signs", 1);
		chart_order.put("residual motor signs_specification", 1);
		chart_order.put("oculogyric_crisis_HP:010553", 1);
		chart_order.put("dyskinesia_HP:0100660", 1);
		chart_order.put("hyperreflexia_HP:0001347", 1);
		chart_order.put("diurnal_fluctuations_sympt", 1);
		chart_order.put("sleep_benefit_sympt", 1);
		chart_order.put("myoclonus_HP:0001336", 1);
		chart_order.put("motor_fluctuations_sympt", 1);
		chart_order.put("spasticity_HP:0001257", 1);
		chart_order.put("hypotonia", 1);
		read_order_from_file(chart_order, "chart_TH_part1.txt");
		return chart_order;
	}


	private Map<String, Integer> chart_DCTN1_part2() {
		Map<String, Integer> chart_order = new DefaultedMap<>(10_000);
		chart_order.put("depression_sympt",1);
		chart_order.put("decreased_body_weight_HP:0004325",1);
		chart_order.put("sleep_disorder_sympt",1);
		chart_order.put("cognitive_decline_sympt",1);
		chart_order.put("behavioral_abnormalities_HP:0000708",1);
		chart_order.put("psychotic_sympt",1);
		chart_order.put("autonomic_sympt",1);
		chart_order.put("swallowing_disorder_sympt",1);
		chart_order.put("anxiety_sympt",1);
		chart_order.put("dysarthria_anarthria_sympt",1);
		chart_order.put("impulsive_control_disorder_sympt",1);
		chart_order.put("intellectual_developmental_disorder_sympt",1);
		chart_order.put("hallucinations_HP:0000738",1);
		chart_order.put("incontinence_sympt",1);
		chart_order.put("apraxia_sympt",1);
		chart_order.put("RBD_sympt",1);
		chart_order.put("cataracts_sympt",1);
		chart_order.put("olfaction_sympt",1);
		read_order_from_file(chart_order, "chart_DCTN1_part2.txt");
		return chart_order;
	}

	public static Map<String, String> all_countries_code_to_country() {
		Map<String, String> country = new TreeMap<>();
        Map<String, String> cc3to2 = country_code3to2_mapping();
		country.put(cc3to2.get("AFG"),	"Afghanistan");
		country.put(cc3to2.get("ALB"),	"Albania");
		country.put(cc3to2.get("DZA"),	"Algeria");
		country.put(cc3to2.get("ASM"),	"American Samoa");
		country.put(cc3to2.get("AND"),	"Andorra");
		country.put(cc3to2.get("AGO"),	"Angola");
		country.put(cc3to2.get("AIA"),	"Anguilla");
		country.put(cc3to2.get("ATA"),	"Antarctica");
		country.put(cc3to2.get("ATG"),	"Antigua and Barbuda");
		country.put(cc3to2.get("ARG"),	"Argentina");
		country.put(cc3to2.get("ARM"),	"Armenia");
		country.put(cc3to2.get("ABW"),	"Aruba");
		country.put(cc3to2.get("AUS"),	"Australia");
		country.put(cc3to2.get("AUT"),	"Austria");
		country.put(cc3to2.get("AZE"),	"Azerbaijan");
		country.put(cc3to2.get("BHS"),	"Bahamas");
		country.put(cc3to2.get("BHR"),	"Bahrain");
		country.put(cc3to2.get("BGD"),	"Bangladesh");
		country.put(cc3to2.get("BRB"),	"Barbados");
		country.put(cc3to2.get("BLR"),	"Belarus");
		country.put(cc3to2.get("BEL"),	"Belgium");
		country.put(cc3to2.get("BLZ"),	"Belize");
		country.put(cc3to2.get("BEN"),	"Benin");
		country.put(cc3to2.get("BMU"),	"Bermuda");
		country.put(cc3to2.get("BTN"),	"Bhutan");
		country.put(cc3to2.get("BOL"),	"Bolivia");
		country.put(cc3to2.get("BIH"),	"Bosnia and Herzegovina");
		country.put(cc3to2.get("BWA"),	"Botswana");
		country.put(cc3to2.get("BRA"),	"Brazil");
		country.put(cc3to2.get("IOT"),	"British Indian Ocean Territory");
//		country.put(cc3to2.get("VGB"),	"British Virgin Islands");
		country.put(cc3to2.get("BRN"),	"Brunei");
		country.put(cc3to2.get("BGR"),	"Bulgaria");
		country.put(cc3to2.get("BFA"),	"Burkina Faso");
		country.put(cc3to2.get("MMR"),	"Myanmar");
		country.put(cc3to2.get("BDI"),	"Burundi");
		country.put(cc3to2.get("KHM"),	"Cambodia");
		country.put(cc3to2.get("CMR"),	"Cameroon");
		country.put(cc3to2.get("CAN"),	"Canada");
		country.put(cc3to2.get("CPV"),	"Cape Verde");
		country.put(cc3to2.get("CYM"),	"Cayman Islands");
		country.put(cc3to2.get("CAF"),	"Central African Republic");
		country.put(cc3to2.get("TCD"),	"Chad");
		country.put(cc3to2.get("CHL"),	"Chile");
		country.put(cc3to2.get("CHN"),	"China");
		country.put(cc3to2.get("CXR"),	"Christmas Island");
		country.put(cc3to2.get("CCK"),	"Cocos Islands");
		country.put(cc3to2.get("COL"),	"Colombia");
		country.put(cc3to2.get("COM"),	"Comoros");
		country.put(cc3to2.get("COG"),	"Republic of the Congo");
		country.put(cc3to2.get("COD"),	"Democratic Republic of the Congo");
		country.put(cc3to2.get("COK"),	"Cook Islands");
		country.put(cc3to2.get("CRI"),	"Costa Rica");
		country.put(cc3to2.get("HRV"),	"Croatia");
		country.put(cc3to2.get("CUB"),	"Cuba");
		country.put(cc3to2.get("CUW"),	"Curacao");
		country.put(cc3to2.get("CYP"),	"Cyprus");
		country.put(cc3to2.get("CZE"),	"Czech Republic");
		country.put(cc3to2.get("DNK"),	"Denmark");
		country.put(cc3to2.get("DJI"),	"Djibouti");
		country.put(cc3to2.get("DMA"),	"Dominica");
		country.put(cc3to2.get("DOM"),	"Dominican Republic");
		country.put(cc3to2.get("TLS"),	"East Timor");
		country.put(cc3to2.get("ECU"),	"Ecuador");
		country.put(cc3to2.get("EGY"),	"Egypt");
		country.put(cc3to2.get("SLV"),	"El Salvador");
		country.put(cc3to2.get("GNQ"),	"Equatorial Guinea");
		country.put(cc3to2.get("ERI"),	"Eritrea");
		country.put(cc3to2.get("EST"),	"Estonia");
		country.put(cc3to2.get("ETH"),	"Ethiopia");
		country.put(cc3to2.get("FLK"),	"Falkland Islands");
		country.put(cc3to2.get("FRO"),	"Faroe Islands");
		country.put(cc3to2.get("FJI"),	"Fiji");
		country.put(cc3to2.get("FIN"),	"Finland");
		country.put(cc3to2.get("FRA"),	"France");
		country.put(cc3to2.get("PYF"),	"French Polynesia");
		country.put(cc3to2.get("GAB"),	"Gabon");
		country.put(cc3to2.get("GMB"),	"Gambia");
		country.put(cc3to2.get("GEO"),	"Georgia");
		country.put(cc3to2.get("DEU"),	"Germany");
		country.put(cc3to2.get("GHA"),	"Ghana");
		country.put(cc3to2.get("GIB"),	"Gibraltar");
		country.put(cc3to2.get("GLP"),	"Guadeloupe");
		country.put(cc3to2.get("GRC"),	"Greece");
		country.put(cc3to2.get("GRL"),	"Greenland");
		country.put(cc3to2.get("GRD"),	"Grenada");
		country.put(cc3to2.get("GUM"),	"Guam");
		country.put(cc3to2.get("GTM"),	"Guatemala");
		country.put(cc3to2.get("GGY"),	"Guernsey");
		country.put(cc3to2.get("GIN"),	"Guinea");
		country.put(cc3to2.get("GNB"),	"Guinea-Bissau");
		country.put(cc3to2.get("GUY"),	"Guyana");
		country.put(cc3to2.get("HTI"),	"Haiti");
		country.put(cc3to2.get("HND"),	"Honduras");
		country.put(cc3to2.get("HKG"),	"Hong Kong");
		country.put(cc3to2.get("HUN"),	"Hungary");
		country.put(cc3to2.get("ISL"),	"Iceland");
		country.put(cc3to2.get("IND"),	"India");
		country.put(cc3to2.get("IDN"),	"Indonesia");
		country.put(cc3to2.get("IRN"),	"Iran");
		country.put(cc3to2.get("IRQ"),	"Iraq");
		country.put(cc3to2.get("IRL"),	"Ireland");
		country.put(cc3to2.get("IMN"),	"Isle of Man");
		country.put(cc3to2.get("ISR"),	"Israel");
		country.put(cc3to2.get("ITA"),	"Italy");
		country.put(cc3to2.get("CIV"),	"Ivory Coast");
		country.put(cc3to2.get("JAM"),	"Jamaica");
		country.put(cc3to2.get("JPN"),	"Japan");
		country.put(cc3to2.get("JEY"),	"Jersey");
		country.put(cc3to2.get("JOR"),	"Jordan");
		country.put(cc3to2.get("KAZ"),	"Kazakhstan");
		country.put(cc3to2.get("KEN"),	"Kenya");
		country.put(cc3to2.get("KIR"),	"Kiribati");
//		country.put(cc3to2.get("XKX"),	"Kosovo");
		country.put(cc3to2.get("KWT"),	"Kuwait");
		country.put(cc3to2.get("KGZ"),	"Kyrgyzstan");
		country.put(cc3to2.get("LAO"),	"Laos");
		country.put(cc3to2.get("LVA"),	"Latvia");
		country.put(cc3to2.get("LBN"),	"Lebanon");
		country.put(cc3to2.get("LSO"),	"Lesotho");
		country.put(cc3to2.get("LBR"),	"Liberia");
		country.put(cc3to2.get("LBY"),	"Libya");
		country.put(cc3to2.get("LIE"),	"Liechtenstein");
		country.put(cc3to2.get("LTU"),	"Lithuania");
		country.put(cc3to2.get("LUX"),	"Luxembourg");
		country.put(cc3to2.get("MAC"),	"Macau");
		country.put(cc3to2.get("MKD"),	"Macedonia");
		country.put(cc3to2.get("MDG"),	"Madagascar");
		country.put(cc3to2.get("MWI"),	"Malawi");
		country.put(cc3to2.get("MYS"),	"Malaysia");
		country.put(cc3to2.get("MDV"),	"Maldives");
		country.put(cc3to2.get("MLI"),	"Mali");
		country.put(cc3to2.get("MLT"),	"Malta");
		country.put(cc3to2.get("MHL"),	"Marshall Islands");
		country.put(cc3to2.get("MRT"),	"Mauritania");
		country.put(cc3to2.get("MUS"),	"Mauritius");
//		country.put(cc3to2.get("MYT"),	"Mayotte");
		country.put(cc3to2.get("MEX"),	"Mexico");
		country.put(cc3to2.get("FSM"),	"Micronesia");
		country.put(cc3to2.get("MDA"),	"Moldova");
		country.put(cc3to2.get("MCO"),	"Monaco");
		country.put(cc3to2.get("MNG"),	"Mongolia");
		country.put(cc3to2.get("MNE"),	"Montenegro");
		country.put(cc3to2.get("MSR"),	"Montserrat");
		country.put(cc3to2.get("MAR"),	"Morocco");
		country.put(cc3to2.get("MOZ"),	"Mozambique");
		country.put(cc3to2.get("NAM"),	"Namibia");
		country.put(cc3to2.get("NRU"),	"Nauru");
		country.put(cc3to2.get("NPL"),	"Nepal");
		country.put(cc3to2.get("NLD"),	"Netherlands");
		country.put(cc3to2.get("ANT"),	"Netherlands Antilles");
		country.put(cc3to2.get("NCL"),	"New Caledonia");
		country.put(cc3to2.get("NZL"),	"New Zealand");
		country.put(cc3to2.get("NIC"),	"Nicaragua");
		country.put(cc3to2.get("NER"),	"Niger");
		country.put(cc3to2.get("NGA"),	"Nigeria");
		country.put(cc3to2.get("NIU"),	"Niue");
		country.put(cc3to2.get("MNP"),	"Northern Mariana Islands");
		country.put(cc3to2.get("PRK"),	"North Korea");
		country.put(cc3to2.get("NOR"),	"Norway");
		country.put(cc3to2.get("OMN"),	"Oman");
		country.put(cc3to2.get("PAK"),	"Pakistan");
		country.put(cc3to2.get("PLW"),	"Palau");
		country.put(cc3to2.get("PSE"),	"Palestine");
		country.put(cc3to2.get("PAN"),	"Panama");
		country.put(cc3to2.get("PNG"),	"Papua New Guinea");
		country.put(cc3to2.get("PRY"),	"Paraguay");
		country.put(cc3to2.get("PER"),	"Peru");
		country.put(cc3to2.get("PHL"),	"Philippines");
		country.put(cc3to2.get("PCN"),	"Pitcairn");
		country.put(cc3to2.get("POL"),	"Poland");
		country.put(cc3to2.get("PRT"),	"Portugal");
		country.put(cc3to2.get("PRI"),	"Puerto Rico");
		country.put(cc3to2.get("QAT"),	"Qatar");
		country.put(cc3to2.get("REU"),	"Reunion");
		country.put(cc3to2.get("ROU"),	"Romania");
		country.put(cc3to2.get("RUS"),	"Russia");
		country.put(cc3to2.get("RWA"),	"Rwanda");
		country.put(cc3to2.get("BLM"),	"Saint Barthelemy");
		country.put(cc3to2.get("WSM"),	"Samoa");
		country.put(cc3to2.get("SMR"),	"San Marino");
		country.put(cc3to2.get("STP"),	"Sao Tome and Principe");
		country.put(cc3to2.get("SAU"),	"Saudi Arabia");
		country.put(cc3to2.get("SEN"),	"Senegal");
		country.put(cc3to2.get("SRB"),	"Serbia");
		country.put(cc3to2.get("SYC"),	"Seychelles");
		country.put(cc3to2.get("SLE"),	"Sierra Leone");
		country.put(cc3to2.get("SGP"),	"Singapore");
		country.put(cc3to2.get("SXM"),	"Sint Maarten");
		country.put(cc3to2.get("SVK"),	"Slovakia");
		country.put(cc3to2.get("SVN"),	"Slovenia");
		country.put(cc3to2.get("SLB"),	"Solomon Islands");
		country.put(cc3to2.get("SOM"),	"Somalia");
		country.put(cc3to2.get("ZAF"),	"South Africa");
		country.put(cc3to2.get("KOR"),	"South Korea");
		country.put(cc3to2.get("SSD"),	"South Sudan");
		country.put(cc3to2.get("ESP"),	"Spain");
		country.put(cc3to2.get("LKA"),	"Sri Lanka");
		country.put(cc3to2.get("SHN"),	"Saint Helena");
		country.put(cc3to2.get("KNA"),	"Saint Kitts and Nevis");
		country.put(cc3to2.get("LCA"),	"Saint Lucia");
		country.put(cc3to2.get("MAF"),	"Saint Martin");
		country.put(cc3to2.get("SPM"),	"Saint Pierre and Miquelon");
		country.put(cc3to2.get("VCT"),	"Saint Vincent and the Grenadines");
		country.put(cc3to2.get("SDN"),	"Sudan");
		country.put(cc3to2.get("SUR"),	"Suriname");
		country.put(cc3to2.get("SJM"),	"Svalbard and Jan Mayen");
		country.put(cc3to2.get("SWZ"),	"Swaziland");
		country.put(cc3to2.get("SWE"),	"Sweden");
		country.put(cc3to2.get("CHE"),	"Switzerland");
		country.put(cc3to2.get("SYR"),	"Syria");
		country.put(cc3to2.get("TWN"),	"Taiwan");
		country.put(cc3to2.get("TJK"),	"Tajikistan");
		country.put(cc3to2.get("TZA"),	"Tanzania");
		country.put(cc3to2.get("THA"),	"Thailand");
		country.put(cc3to2.get("TGO"),	"Togo");
		country.put(cc3to2.get("TKL"),	"Tokelau");
		country.put(cc3to2.get("TON"),	"Tonga");
		country.put(cc3to2.get("TTO"),	"Trinidad and Tobago");
		country.put(cc3to2.get("TUN"),	"Tunisia");
		country.put(cc3to2.get("TUR"),	"Turkey");
		country.put(cc3to2.get("TKM"),	"Turkmenistan");
		country.put(cc3to2.get("TCA"),	"Turks and Caicos Islands");
		country.put(cc3to2.get("TUV"),	"Tuvalu");
		country.put(cc3to2.get("ARE"),	"United Arab Emirates");
		country.put(cc3to2.get("UGA"),	"Uganda");
		country.put(cc3to2.get("GBR"),	"United Kingdom");
		country.put(cc3to2.get("UKR"),	"Ukraine");
		country.put(cc3to2.get("URY"),	"Uruguay");
		country.put(cc3to2.get("USA"),	"United States");
		country.put(cc3to2.get("UZB"),	"Uzbekistan");
//		country.put(cc3to2.get("VUT"),	"Vanuatu");
		country.put(cc3to2.get("VAT"),	"Vatican");
		country.put(cc3to2.get("VEN"),	"Venezuela");
		country.put(cc3to2.get("VNM"),	"Vietnam");
//		country.put(cc3to2.get("VIR"),	"U.S. Virgin Islands");
//		country.put(cc3to2.get("WLF"),	"Wallis and Futuna");
		country.put(cc3to2.get("ESH"),	"Western Sahara");
//		country.put(cc3to2.get("YEM"),	"Yemen");
//		country.put(cc3to2.get("ZMB"),	"Zambia");
//		country.put(cc3to2.get("ZWE"),	"Zimbabwe");
		return country;
	}

    public static Map<String, String> all_countries() {
        Map<String, String> country = new TreeMap<>();
        Map<String, String> cc3to2 = country_code3to2_mapping();
		country.put("Afghanistan",cc3to2.get("AFG"));
        country.put("Albania",cc3to2.get("ALB"));
        country.put("Algeria",cc3to2.get("DZA"));
        country.put("American Samoa",cc3to2.get("ASM"));
        country.put("Andorra",cc3to2.get("AND"));
        country.put("Angola",cc3to2.get("AGO"));
        country.put("Anguilla",cc3to2.get("AIA"));
        country.put("Antarctica",cc3to2.get("ATA"));
        country.put("Antigua and Barbuda",cc3to2.get("ATG"));
        country.put("Argentina",cc3to2.get("ARG"));
        country.put("Armenia",cc3to2.get("ARM"));
        country.put("Aruba",cc3to2.get("ABW"));
        country.put("Australia",cc3to2.get("AUS"));
        country.put("Austria",cc3to2.get("AUT"));
        country.put("Azerbaijan",cc3to2.get("AZE"));
        country.put("Bahamas",cc3to2.get("BHS"));
        country.put("Bahrain",cc3to2.get("BHR"));
        country.put("Bangladesh",cc3to2.get("BGD"));
        country.put("Barbados",cc3to2.get("BRB"));
        country.put("Belarus",cc3to2.get("BLR"));
        country.put("Belgium",cc3to2.get("BEL"));
        country.put("Belize",cc3to2.get("BLZ"));
        country.put("Benin",cc3to2.get("BEN"));
        country.put("Bermuda",cc3to2.get("BMU"));
        country.put("Bhutan",cc3to2.get("BTN"));
        country.put("Bolivia",cc3to2.get("BOL"));
        country.put("Bosnia and Herzegovina",cc3to2.get("BIH"));
        country.put("Botswana",cc3to2.get("BWA"));
        country.put("Brazil",cc3to2.get("BRA"));
        country.put("British Indian Ocean Territory",cc3to2.get("IOT"));
        country.put("British Virgin Islands",cc3to2.get("VGB"));
        country.put("Brunei",cc3to2.get("BRN"));
        country.put("Bulgaria",cc3to2.get("BGR"));
        country.put("Burkina Faso",cc3to2.get("BFA"));
        country.put("Myanmar",cc3to2.get("MMR"));
        country.put("Burundi",cc3to2.get("BDI"));
        country.put("Cambodia",cc3to2.get("KHM"));
        country.put("Cameroon",cc3to2.get("CMR"));
        country.put("Canada",cc3to2.get("CAN"));
        country.put("Cape Verde",cc3to2.get("CPV"));
        country.put("Cayman Islands",cc3to2.get("CYM"));
        country.put("Central African Republic",cc3to2.get("CAF"));
        country.put("Chad",cc3to2.get("TCD"));
        country.put("Chile",cc3to2.get("CHL"));
        country.put("China",cc3to2.get("CHN"));
        country.put("Christmas Island",cc3to2.get("CXR"));
        country.put("Cocos Islands",cc3to2.get("CCK"));
        country.put("Colombia",cc3to2.get("COL"));
        country.put("Comoros",cc3to2.get("COM"));
        country.put("Republic of the Congo",cc3to2.get("COG"));
        country.put("Democratic Republic of the Congo",cc3to2.get("COD"));
        country.put("Cook Islands",cc3to2.get("COK"));
        country.put("Costa Rica",cc3to2.get("CRI"));
        country.put("Croatia",cc3to2.get("HRV"));
        country.put("Cuba",cc3to2.get("CUB"));
        country.put("Curacao",cc3to2.get("CUW"));
        country.put("Cyprus",cc3to2.get("CYP"));
        country.put("Czech Republic",cc3to2.get("CZE"));
        country.put("Denmark",cc3to2.get("DNK"));
        country.put("Djibouti",cc3to2.get("DJI"));
        country.put("Dominica",cc3to2.get("DMA"));
        country.put("Dominican Republic",cc3to2.get("DOM"));
        country.put("East Timor",cc3to2.get("TLS"));
        country.put("Ecuador",cc3to2.get("ECU"));
        country.put("Egypt",cc3to2.get("EGY"));
        country.put("El Salvador",cc3to2.get("SLV"));
        country.put("Equatorial Guinea",cc3to2.get("GNQ"));
        country.put("Eritrea",cc3to2.get("ERI"));
        country.put("Estonia",cc3to2.get("EST"));
        country.put("Ethiopia",cc3to2.get("ETH"));
        country.put("Falkland Islands",cc3to2.get("FLK"));
        country.put("Faroe Islands",cc3to2.get("FRO"));
        country.put("Fiji",cc3to2.get("FJI"));
        country.put("Finland",cc3to2.get("FIN"));
        country.put("France",cc3to2.get("FRA"));
        country.put("French Polynesia",cc3to2.get("PYF"));
        country.put("Gabon",cc3to2.get("GAB"));
        country.put("Gambia",cc3to2.get("GMB"));
        country.put("Georgia",cc3to2.get("GEO"));
        country.put("Germany",cc3to2.get("DEU"));
        country.put("Ghana",cc3to2.get("GHA"));
        country.put("Gibraltar",cc3to2.get("GIB"));
        country.put("Greece",cc3to2.get("GRC"));
        country.put("Greenland",cc3to2.get("GRL"));
        country.put("Grenada",cc3to2.get("GRD"));
        country.put("Guadeloupe",cc3to2.get("GLP"));
        country.put("Guam",cc3to2.get("GUM"));
        country.put("Guatemala",cc3to2.get("GTM"));
        country.put("Guernsey",cc3to2.get("GGY"));
        country.put("Guinea",cc3to2.get("GIN"));
        country.put("Guinea-Bissau",cc3to2.get("GNB"));
        country.put("Guyana",cc3to2.get("GUY"));
        country.put("Haiti",cc3to2.get("HTI"));
        country.put("Honduras",cc3to2.get("HND"));
        country.put("Hong Kong",cc3to2.get("HKG"));
        country.put("Hungary",cc3to2.get("HUN"));
        country.put("Iceland",cc3to2.get("ISL"));
        country.put("India",cc3to2.get("IND"));
        country.put("Indonesia",cc3to2.get("IDN"));
        country.put("Iran",cc3to2.get("IRN"));
        country.put("Iraq",cc3to2.get("IRQ"));
        country.put("Ireland",cc3to2.get("IRL"));
        country.put("Isle of Man",cc3to2.get("IMN"));
        country.put("Israel",cc3to2.get("ISR"));
        country.put("Italy",cc3to2.get("ITA"));
        country.put("Ivory Coast",cc3to2.get("CIV"));
        country.put("Jamaica",cc3to2.get("JAM"));
        country.put("Japan",cc3to2.get("JPN"));
        country.put("Jersey",cc3to2.get("JEY"));
        country.put("Jordan",cc3to2.get("JOR"));
        country.put("Kazakhstan",cc3to2.get("KAZ"));
        country.put("Kenya",cc3to2.get("KEN"));
        country.put("Kiribati",cc3to2.get("KIR"));
        country.put("Kosovo",cc3to2.get("XKX"));
        country.put("Kuwait",cc3to2.get("KWT"));
        country.put("Kyrgyzstan",cc3to2.get("KGZ"));
        country.put("Laos",cc3to2.get("LAO"));
        country.put("Latvia",cc3to2.get("LVA"));
        country.put("Lebanon",cc3to2.get("LBN"));
        country.put("Lesotho",cc3to2.get("LSO"));
        country.put("Liberia",cc3to2.get("LBR"));
        country.put("Libya",cc3to2.get("LBY"));
        country.put("Liechtenstein",cc3to2.get("LIE"));
        country.put("Lithuania",cc3to2.get("LTU"));
        country.put("Luxembourg",cc3to2.get("LUX"));
        country.put("Macau",cc3to2.get("MAC"));
        country.put("Macedonia",cc3to2.get("MKD"));
        country.put("Madagascar",cc3to2.get("MDG"));
        country.put("Malawi",cc3to2.get("MWI"));
        country.put("Malaysia",cc3to2.get("MYS"));
        country.put("Maldives",cc3to2.get("MDV"));
        country.put("Mali",cc3to2.get("MLI"));
        country.put("Malta",cc3to2.get("MLT"));
        country.put("Marshall Islands",cc3to2.get("MHL"));
        country.put("Mauritania",cc3to2.get("MRT"));
        country.put("Mauritius",cc3to2.get("MUS"));
        country.put("Mayotte",cc3to2.get("MYT"));
        country.put("Mexico",cc3to2.get("MEX"));
        country.put("Micronesia",cc3to2.get("FSM"));
        country.put("Moldova",cc3to2.get("MDA"));
        country.put("Monaco",cc3to2.get("MCO"));
        country.put("Mongolia",cc3to2.get("MNG"));
        country.put("Montenegro",cc3to2.get("MNE"));
        country.put("Montserrat",cc3to2.get("MSR"));
        country.put("Morocco",cc3to2.get("MAR"));
        country.put("Mozambique",cc3to2.get("MOZ"));
        country.put("Namibia",cc3to2.get("NAM"));
        country.put("Nauru",cc3to2.get("NRU"));
        country.put("Nepal",cc3to2.get("NPL"));
        country.put("Netherlands",cc3to2.get("NLD"));
        country.put("Netherlands Antilles",cc3to2.get("ANT"));
        country.put("New Caledonia",cc3to2.get("NCL"));
        country.put("New Zealand",cc3to2.get("NZL"));
        country.put("Nicaragua",cc3to2.get("NIC"));
        country.put("Niger",cc3to2.get("NER"));
        country.put("Nigeria",cc3to2.get("NGA"));
        country.put("Niue",cc3to2.get("NIU"));
        country.put("Northern Mariana Islands",cc3to2.get("MNP"));
        country.put("North Korea",cc3to2.get("PRK"));
        country.put("Norway",cc3to2.get("NOR"));
        country.put("Oman",cc3to2.get("OMN"));
        country.put("Pakistan",cc3to2.get("PAK"));
        country.put("Palau",cc3to2.get("PLW"));
        country.put("Palestine",cc3to2.get("PSE"));
        country.put("Panama",cc3to2.get("PAN"));
        country.put("Papua New Guinea",cc3to2.get("PNG"));
        country.put("Paraguay",cc3to2.get("PRY"));
        country.put("Peru",cc3to2.get("PER"));
        country.put("Philippines",cc3to2.get("PHL"));
        country.put("Pitcairn",cc3to2.get("PCN"));
        country.put("Poland",cc3to2.get("POL"));
        country.put("Portugal",cc3to2.get("PRT"));
        country.put("Puerto Rico",cc3to2.get("PRI"));
        country.put("Qatar",cc3to2.get("QAT"));
        country.put("Reunion",cc3to2.get("REU"));
        country.put("Romania",cc3to2.get("ROU"));
        country.put("Russia",cc3to2.get("RUS"));
        country.put("Rwanda",cc3to2.get("RWA"));
        country.put("Saint Barthelemy",cc3to2.get("BLM"));
        country.put("Samoa",cc3to2.get("WSM"));
        country.put("San Marino",cc3to2.get("SMR"));
        country.put("Sao Tome and Principe",cc3to2.get("STP"));
        country.put("Saudi Arabia",cc3to2.get("SAU"));
        country.put("Senegal",cc3to2.get("SEN"));
        country.put("Serbia",cc3to2.get("SRB"));
        country.put("Seychelles",cc3to2.get("SYC"));
        country.put("Sierra Leone",cc3to2.get("SLE"));
        country.put("Singapore",cc3to2.get("SGP"));
        country.put("Sint Maarten",cc3to2.get("SXM"));
        country.put("Slovakia",cc3to2.get("SVK"));
        country.put("Slovenia",cc3to2.get("SVN"));
        country.put("Solomon Islands",cc3to2.get("SLB"));
        country.put("Somalia",cc3to2.get("SOM"));
        country.put("South Africa",cc3to2.get("ZAF"));
        country.put("South Korea",cc3to2.get("KOR"));
        country.put("South Sudan",cc3to2.get("SSD"));
        country.put("Spain",cc3to2.get("ESP"));
        country.put("Sri Lanka",cc3to2.get("LKA"));
        country.put("Saint Helena",cc3to2.get("SHN"));
        country.put("Saint Kitts and Nevis",cc3to2.get("KNA"));
        country.put("Saint Lucia",cc3to2.get("LCA"));
        country.put("Saint Martin",cc3to2.get("MAF"));
        country.put("Saint Pierre and Miquelon",cc3to2.get("SPM"));
        country.put("Saint Vincent and the Grenadines",cc3to2.get("VCT"));
        country.put("Sudan",cc3to2.get("SDN"));
        country.put("Suriname",cc3to2.get("SUR"));
        country.put("Svalbard and Jan Mayen",cc3to2.get("SJM"));
        country.put("Swaziland",cc3to2.get("SWZ"));
        country.put("Sweden",cc3to2.get("SWE"));
        country.put("Switzerland",cc3to2.get("CHE"));
        country.put("Syria",cc3to2.get("SYR"));
        country.put("Taiwan",cc3to2.get("TWN"));
        country.put("Tajikistan",cc3to2.get("TJK"));
        country.put("Tanzania",cc3to2.get("TZA"));
        country.put("Thailand",cc3to2.get("THA"));
        country.put("Togo",cc3to2.get("TGO"));
        country.put("Tokelau",cc3to2.get("TKL"));
        country.put("Tonga",cc3to2.get("TON"));
        country.put("Trinidad and Tobago",cc3to2.get("TTO"));
        country.put("Tunisia",cc3to2.get("TUN"));
        country.put("Turkey",cc3to2.get("TUR"));
        country.put("Turkmenistan",cc3to2.get("TKM"));
        country.put("Turks and Caicos Islands",cc3to2.get("TCA"));
        country.put("Tuvalu",cc3to2.get("TUV"));
        country.put("United Arab Emirates",cc3to2.get("ARE"));
        country.put("Uganda",cc3to2.get("UGA"));
        country.put("United Kingdom",cc3to2.get("GBR"));
        country.put("Ukraine",cc3to2.get("UKR"));
        country.put("Uruguay",cc3to2.get("URY"));
        country.put("United States",cc3to2.get("USA"));
        country.put("Uzbekistan",cc3to2.get("UZB"));
        country.put("Vanuatu",cc3to2.get("VUT"));
        country.put("Vatican",cc3to2.get("VAT"));
        country.put("Venezuela",cc3to2.get("VEN"));
        country.put("Vietnam",cc3to2.get("VNM"));
        country.put("U.S. Virgin Islands",cc3to2.get("VIR"));
        country.put("Wallis and Futuna",cc3to2.get("WLF"));
        country.put("Western Sahara",cc3to2.get("ESH"));
        country.put("Yemen",cc3to2.get("YEM"));
        country.put("Zambia",cc3to2.get("ZMB"));
        country.put("Zimbabwe",cc3to2.get("ZWE"));
        country.entrySet().removeIf(v -> v.getValue() == null);
        return country;
    }


	public static Map<String, String> country_code3to2_mapping() {
		Map<String, String> country = new HashMap<>();
		country.put("AND","AD");  // Andorra, Principality of
		country.put("ARE","AE");  // United Arab Emirates
		country.put("AFG","AF");  // Afghanistan
		country.put("ATG","AG");  // Antigua and Barbuda
		country.put("AIA","AI");  // Anguilla
		country.put("ALB","AL");  // Albania, People's Socialist Republic of
		country.put("ARM","AM");  // Armenia
		country.put("ANT","AN");  // Netherlands Antilles
		country.put("AGO","AO");  // Angola, Republic of
		country.put("ATA","AQ");  // Antarctica (the territory South of 60 deg S)
		country.put("ARG","AR");  // Argentina, Argentine Republic
		country.put("ASM","AS");  // American Samoa
		country.put("AUT","AT");  // Austria, Republic of
		country.put("AUS","AU");  // Australia, Commonwealth of
		country.put("ABW","AW");  // Aruba
		country.put("ALA","AX");  // \u00c5land Islands
		country.put("AZE","AZ");  // Azerbaijan, Republic of
		country.put("BIH","BA");  // Bosnia and Herzegovina
		country.put("BRB","BB");  // Barbados
		country.put("BGD","BD");  // Bangladesh, People's Republic of
		country.put("BEL","BE");  // Belgium, Kingdom of
		country.put("BFA","BF");  // Burkina Faso
		country.put("BGR","BG");  // Bulgaria, People's Republic of
		country.put("BHR","BH");  // Bahrain, Kingdom of
		country.put("BDI","BI");  // Burundi, Republic of
		country.put("BEN","BJ");  // Benin, People's Republic of
		country.put("BLM","BL");  // Saint Barth\u00e9lemy
		country.put("BMU","BM");  // Bermuda
		country.put("BRN","BN");  // Brunei Darussalam
		country.put("BOL","BO");  // Bolivia, Republic of
		country.put("BES","BQ");  // Bonaire, Sint Eustatius and Saba
		country.put("BRA","BR");  // Brazil, Federative Republic of
		country.put("BHS","BS");  // Bahamas, Commonwealth of the
		country.put("BTN","BT");  // Bhutan, Kingdom of
		country.put("BVT","BV");  // Bouvet Island (Bouvetoya)
		country.put("BWA","BW");  // Botswana, Republic of
		country.put("BLR","BY");  // Belarus
		country.put("BLZ","BZ");  // Belize
		country.put("CAN","CA");  // Canada
		country.put("CCK","CC");  // Cocos (Keeling) Islands
		country.put("COD","CD");  // Congo, Democratic Republic of
		country.put("CAF","CF");  // Central African Republic
		country.put("COG","CG");  // Congo, People's Republic of
		country.put("CHE","CH");  // Switzerland, Swiss Confederation
		country.put("CIV","CI");  // Cote D'Ivoire, Ivory Coast, Republic of the
		country.put("COK","CK");  // Cook Islands
		country.put("CHL","CL");  // Chile, Republic of
		country.put("CMR","CM");  // Cameroon, United Republic of
		country.put("CHN","CN");  // China, People's Republic of
		country.put("COL","CO");  // Colombia, Republic of
		country.put("CRI","CR");  // Costa Rica, Republic of
		country.put("SCG","CS");  // Serbia and Montenegro
		country.put("CUB","CU");  // Cuba, Republic of
		country.put("CPV","CV");  // Cape Verde, Republic of
		country.put("CUW","CW");  // Cura\u00e7ao
		country.put("CXR","CX");  // Christmas Island
		country.put("CYP","CY");  // Cyprus, Republic of
		country.put("CZE","CZ");  // Czech Republic
		country.put("DEU","DE");  // Germany
		country.put("DJI","DJ");  // Djibouti, Republic of
		country.put("DNK","DK");  // Denmark, Kingdom of
		country.put("DMA","DM");  // Dominica, Commonwealth of
		country.put("DOM","DO");  // Dominican Republic
		country.put("DZA","DZ");  // Algeria, People's Democratic Republic of
		country.put("ECU","EC");  // Ecuador, Republic of
		country.put("EST","EE");  // Estonia
		country.put("EGY","EG");  // Egypt, Arab Republic of
		country.put("ESH","EH");  // Western Sahara
		country.put("ERI","ER");  // Eritrea
		country.put("ESP","ES");  // Spain, Spanish State
		country.put("ETH","ET");  // Ethiopia
		country.put("FIN","FI");  // Finland, Republic of
		country.put("FJI","FJ");  // Fiji, Republic of the Fiji Islands
		country.put("FLK","FK");  // Falkland Islands (Malvinas)
		country.put("FSM","FM");  // Micronesia, Federated States of
		country.put("FRO","FO");  // Faeroe Islands
		country.put("FRA","FR");  // France, French Republic
		country.put("GAB","GA");  // Gabon, Gabonese Republic
		country.put("GBR","GB");  // United Kingdom of Great Britain & N. Ireland
		country.put("GRD","GD");  // Grenada
		country.put("GEO","GE");  // Georgia
		country.put("GUF","GF");  // French Guiana
		country.put("GGY","GG");  // Guernsey
		country.put("GHA","GH");  // Ghana, Republic of
		country.put("GIB","GI");  // Gibraltar
		country.put("GRL","GL");  // Greenland
		country.put("GMB","GM");  // Gambia, Republic of the
		country.put("GIN","GN");  // Guinea, Revolutionary People's Rep'c of
		country.put("GLP","GP");  // Guadaloupe
		country.put("GNQ","GQ");  // Equatorial Guinea, Republic of
		country.put("GRC","GR");  // Greece, Hellenic Republic
		country.put("SGS","GS");  // South Georgia and the South Sandwich Islands
		country.put("GTM","GT");  // Guatemala, Republic of
		country.put("GUM","GU");  // Guam
		country.put("GNB","GW");  // Guinea-Bissau, Republic of
		country.put("GUY","GY");  // Guyana, Republic of
		country.put("HKG","HK");  // Hong Kong, Special Administrative Region of C
		country.put("HMD","HM");  // Heard and McDonald Islands
		country.put("HND","HN");  // Honduras, Republic of
		country.put("HRV","HR");  // Hrvatska (Croatia)
		country.put("HTI","HT");  // Haiti, Republic of
		country.put("HUN","HU");  // Hungary, Hungarian People's Republic
		country.put("IDN","ID");  // Indonesia, Republic of
		country.put("IRL","IE");  // Ireland
		country.put("ISR","IL");  // Israel, State of
		country.put("IMN","IM");  // Isle of Man
		country.put("IND","IN");  // India, Republic of
		country.put("IOT","IO");  // British Indian Ocean Territory (Chagos Archip
		country.put("IRQ","IQ");  // Iraq, Republic of
		country.put("IRN","IR");  // Iran, Islamic Republic of
		country.put("ISL","IS");  // Iceland, Republic of
		country.put("ITA","IT");  // Italy, Italian Republic
		country.put("JEY","JE");  // Jersey
		country.put("JAM","JM");  // Jamaica
		country.put("JOR","JO");  // Jordan, Hashemite Kingdom of
		country.put("JPN","JP");  // Japan
		country.put("KEN","KE");  // Kenya, Republic of
		country.put("KGZ","KG");  // Kyrgyz Republic
		country.put("KHM","KH");  // Cambodia, Kingdom of
		country.put("KIR","KI");  // Kiribati, Republic of
		country.put("COM","KM");  // Comoros, Union of the
		country.put("KNA","KN");  // St. Kitts and Nevis
		country.put("PRK","KP");  // Korea, Democratic People's Republic of
		country.put("KOR","KR");  // Korea, Republic of
		country.put("KWT","KW");  // Kuwait, State of
		country.put("CYM","KY");  // Cayman Islands
		country.put("KAZ","KZ");  // Kazakhstan, Republic of
		country.put("LAO","LA");  // Lao People's Democratic Republic
		country.put("LBN","LB");  // Lebanon, Lebanese Republic
		country.put("LCA","LC");  // St. Lucia
		country.put("LIE","LI");  // Liechtenstein, Principality of
		country.put("LKA","LK");  // Sri Lanka, Democratic Socialist Republic of
		country.put("LBR","LR");  // Liberia, Republic of
		country.put("LSO","LS");  // Lesotho, Kingdom of
		country.put("LTU","LT");  // Lithuania
		country.put("LUX","LU");  // Luxembourg, Grand Duchy of
		country.put("LVA","LV");  // Latvia
		country.put("LBY","LY");  // Libyan Arab Jamahiriya
		country.put("MAR","MA");  // Morocco, Kingdom of
		country.put("MCO","MC");  // Monaco, Principality of
		country.put("MDA","MD");  // Moldova, Republic of
		country.put("MNE","ME");  // Montenegro, Republic of
		country.put("MAF","MF");  // Saint Martin
		country.put("MDG","MG");  // Madagascar, Republic of
		country.put("MHL","MH");  // Marshall Islands
		country.put("MKD","MK");  // Macedonia, the former Yugoslav Republic of
		country.put("MLI","ML");  // Mali, Republic of
		country.put("MMR","MM");  // Myanmar
		country.put("MNG","MN");  // Mongolia, Mongolian People's Republic
		country.put("MAC","MO");  // Macao, Special Administrative Region of China
		country.put("MNP","MP");  // Northern Mariana Islands
		country.put("MTQ","MQ");  // Martinique
		country.put("MRT","MR");  // Mauritania, Islamic Republic of
		country.put("MSR","MS");  // Montserrat
		country.put("MLT","MT");  // Malta, Republic of
		country.put("MUS","MU");  // Mauritius
		country.put("MDV","MV");  // Maldives, Republic of
		country.put("MWI","MW");  // Malawi, Republic of
		country.put("MEX","MX");  // Mexico, United Mexican States
		country.put("MYS","MY");  // Malaysia
		country.put("MOZ","MZ");  // Mozambique, People's Republic of
		country.put("NAM","NA");  // Namibia
		country.put("NCL","NC");  // New Caledonia
		country.put("NER","NE");  // Niger, Republic of the
		country.put("NFK","NF");  // Norfolk Island
		country.put("NGA","NG");  // Nigeria, Federal Republic of
		country.put("NIC","NI");  // Nicaragua, Republic of
		country.put("NLD","NL");  // Netherlands, Kingdom of the
		country.put("NOR","NO");  // Norway, Kingdom of
		country.put("NPL","NP");  // Nepal, Kingdom of
		country.put("NRU","NR");  // Nauru, Republic of
		country.put("NIU","NU");  // Niue, Republic of
		country.put("NZL","NZ");  // New Zealand
		country.put("OMN","OM");  // Oman, Sultanate of
		country.put("PAN","PA");  // Panama, Republic of
		country.put("PER","PE");  // Peru, Republic of
		country.put("PYF","PF");  // French Polynesia
		country.put("PNG","PG");  // Papua New Guinea
		country.put("PHL","PH");  // Philippines, Republic of the
		country.put("PAK","PK");  // Pakistan, Islamic Republic of
		country.put("POL","PL");  // Poland, Republic of Poland
		country.put("SPM","PM");  // St. Pierre and Miquelon
		country.put("PCN","PN");  // Pitcairn Island
		country.put("PRI","PR");  // Puerto Rico
		country.put("PSE","PS");  // Palestinian Territory, Occupied
		country.put("PRT","PT");  // Portugal, Portuguese Republic
		country.put("PLW","PW");  // Palau
		country.put("PRY","PY");  // Paraguay, Republic of
		country.put("QAT","QA");  // Qatar, State of
		country.put("REU","RE");  // Reunion
		country.put("ROU","RO");  // Romania, Socialist Republic of
		country.put("SRB","RS");  // Serbia, Republic of
		country.put("RUS","RU");  // Russian Federation
		country.put("RWA","RW");  // Rwanda, Rwandese Republic
		country.put("SAU","SA");  // Saudi Arabia, Kingdom of
		country.put("SLB","SB");  // Solomon Islands
		country.put("SYC","SC");  // Seychelles, Republic of
		country.put("SDN","SD");  // Sudan, Democratic Republic of the
		country.put("SWE","SE");  // Sweden, Kingdom of
		country.put("SGP","SG");  // Singapore, Republic of
		country.put("SHN","SH");  // St. Helena
		country.put("SVN","SI");  // Slovenia
		country.put("SJM","SJ");  // Svalbard & Jan Mayen Islands
		country.put("SVK","SK");  // Slovakia (Slovak Republic)
		country.put("SLE","SL");  // Sierra Leone, Republic of
		country.put("SMR","SM");  // San Marino, Republic of
		country.put("SEN","SN");  // Senegal, Republic of
		country.put("SOM","SO");  // Somalia, Somali Republic
		country.put("SUR","SR");  // Suriname, Republic of
		country.put("SSD","SS");  // South Sudan
		country.put("STP","ST");  // Sao Tome and Principe, Democratic Republic of
		country.put("SLV","SV");  // El Salvador, Republic of
		country.put("SXM","SX");  // Sint Maarten (Dutch part)
		country.put("SYR","SY");  // Syrian Arab Republic
		country.put("SWZ","SZ");  // Swaziland, Kingdom of
		country.put("TCA","TC");  // Turks and Caicos Islands
		country.put("TCD","TD");  // Chad, Republic of
		country.put("ATF","TF");  // French Southern Territories
		country.put("TGO","TG");  // Togo, Togolese Republic
		country.put("THA","TH");  // Thailand, Kingdom of
		country.put("TJK","TJ");  // Tajikistan
		country.put("TKL","TK");  // Tokelau (Tokelau Islands)
		country.put("TLS","TL");  // Timor-Leste, Democratic Republic of
		country.put("TKM","TM");  // Turkmenistan
		country.put("TUN","TN");  // Tunisia, Republic of
		country.put("TON","TO");  // Tonga, Kingdom of
		country.put("TUR","TR");  // Turkey, Republic of
		country.put("TTO","TT");  // Trinidad and Tobago, Republic of
		country.put("TUV","TV");  // Tuvalu
		country.put("TWN","TW");  // Taiwan, Province of China
		country.put("TZA","TZ");  // Tanzania, United Republic of
		country.put("UKR","UA");  // Ukraine
		country.put("UGA","UG");  // Uganda, Republic of
		country.put("UMI","UM");  // United States Minor Outlying Islands
		country.put("USA","US");  // United States of America
		country.put("URY","UY");  // Uruguay, Eastern Republic of
		country.put("UZB","UZ");  // Uzbekistan
		country.put("VAT","VA");  // Holy See (Vatican City State)
		country.put("VCT","VC");  // St. Vincent and the Grenadines
		country.put("VEN","VE");  // Venezuela, Bolivarian Republic of
		country.put("VNM","VN");  // Vietnam
		country.put("WSM","WS");  // Samoa
		country.put("ZAF","ZA");  // South, Africa Republic of
		return country;
	}

	/**
	 * map name of aminoacid to the name started with the one character in a state of 3 characters
//	 * @param amino_acid_name
	 * @return
	 */
	public String map3_1(Object obj) {
		if (obj == null) return null;
		String amino_acid_name = obj.toString();
		if(amino_acid_name.contains("Ala")) amino_acid_name=amino_acid_name.replace("Ala", "A");
		if(amino_acid_name.contains("Arg")) amino_acid_name=amino_acid_name.replace("Arg", "R");
		if(amino_acid_name.contains("Asn")) amino_acid_name=amino_acid_name.replace("Asn", "N");
		if(amino_acid_name.contains("Asp")) amino_acid_name=amino_acid_name.replace("Asp", "D");
		if(amino_acid_name.contains("Cys")) amino_acid_name=amino_acid_name.replace("Cys", "C");
		if(amino_acid_name.contains("Gln")) amino_acid_name=amino_acid_name.replace("Gln", "E");
		if(amino_acid_name.contains("Glu")) amino_acid_name=amino_acid_name.replace("Glu", "Q");
		if(amino_acid_name.contains("Gly")) amino_acid_name=amino_acid_name.replace("Gly", "G");
		if(amino_acid_name.contains("His")) amino_acid_name=amino_acid_name.replace("His", "H");
		if(amino_acid_name.contains("Ile")) amino_acid_name=amino_acid_name.replace("Ile", "I");
		if(amino_acid_name.contains("Leu")) amino_acid_name=amino_acid_name.replace("Leu", "L");
		if(amino_acid_name.contains("Lys")) amino_acid_name=amino_acid_name.replace("Lys", "K");
		if(amino_acid_name.contains("Met")) amino_acid_name=amino_acid_name.replace("Met", "M");
		if(amino_acid_name.contains("Phe")) amino_acid_name=amino_acid_name.replace("Phe", "F");
		if(amino_acid_name.contains("Pro")) amino_acid_name=amino_acid_name.replace("Pro", "P");
		if(amino_acid_name.contains("Ser")) amino_acid_name=amino_acid_name.replace("Ser", "S");
		if(amino_acid_name.contains("Thr")) amino_acid_name=amino_acid_name.replace("Thr", "T");
		if(amino_acid_name.contains("Trp")) amino_acid_name=amino_acid_name.replace("Trp", "W");
		if(amino_acid_name.contains("Tyr")) amino_acid_name=amino_acid_name.replace("Tyr", "Y");
		if(amino_acid_name.contains("Val")) amino_acid_name.replace("Val", "V");
		amino_acid_name = amino_acid_name.replaceAll("\\:.*", "");
		return amino_acid_name;
	}


//	@Component
//	public class CachingSetup implements JCacheManagerCustomizer
//	{
//
//		@Override
//		public void customize(CacheManager cacheManager) {
//		    cacheManager.createCache("people", new MutableConfiguration<>()
//		    	      .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new javax.cache.expiry.Duration(java.util.concurrent.TimeUnit.HOURS, 10)))
//		    	      .setStoreByValue(false)
//		    	      .setStatisticsEnabled(true));
//		}
//	}

//    @RequestMapping("/api/{profile}")
//    public ResponseEntity<?> readCSV(@PathVariable String profile, Integer page) throws IOException {
//    	List<String> readAllLines = Files.readAllLines(pathToProfile(profile), StandardCharsets.ISO_8859_1);
//    	String content = IntStream.range(0, readAllLines.size()).filter(i -> i == 0 || page == -1 || (i > page*10 && i <= (page+1)*10) ).mapToObj(i -> readAllLines.get(i)).collect(Collectors.joining("\n"));
//        return ResponseEntity.ok()
//        .contentType(MediaType.TEXT_PLAIN)
//        .body(content);
//    }

//	private Path pathToProfile(String profile) {
//		return Paths.get("c:\\ffmpeg\\csv\\" + profile + ".csv");
//	}

}
