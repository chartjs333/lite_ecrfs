package net.mdsgene.admin.controllers;

import net.mdsgene.admin.admintool.business.CityCoordinate;
import net.mdsgene.admin.admintool.entities.Disease;
import net.mdsgene.admin.admintool.entities.Gene;
import net.mdsgene.admin.controllers.ChartsData.ПараметрыФильтра;
import net.mdsgene.admin.controllers.StudiesController.Overview;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnpublishedData implements IOverview {
	private static final Logger LOGGER = Logger.getLogger( UnpublishedData.class.getName() );


	List<?> _data;
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public void readGeneDiseaseNames(Overview overview, Integer fc, String aao, Integer selected_gene_id, Integer selected_disease_id) {
		String _filter = "&fc=" + (fc == null ? 0 : fc) + "&repeats=0&fn=" + selected_gene_id;
 	    _filter = addAaoToFilter(aao, _filter, overview);
        _data = restTemplate.getForObject("http://"
        		+ ChartsData.UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=10000"+_filter, List.class);

        overview.gene = new Gene();
        overview.gene.setId(selected_gene_id);
        overview.gene.setName((String) ((List<?>)_data.get(2)).get(0)+"*");

        overview.disease = new Disease();
        overview.disease.setName((String) ((List<?>)_data.get(0)).get(0));
        overview.disease.setAbbreviation((String) ((List<?>)_data.get(1)).get(0));
        overview.disease.setLaunched(true);
        overview.disease.setId(selected_disease_id);
    }

	@SuppressWarnings("unchecked")
	@Override
	public void readFilters(Overview overview, Integer selected_gene_id, Integer fc, Integer fc1, Integer fc2, String aao, List<String> mut_restrict, List<String> country) {
		// set the current position of the filter selected
		overview.setFc(fc);
		overview.setFc1(fc1);
		overview.setFc2(fc2);
		overview.setCountry(country);

		fillFilterData(selected_gene_id, fc, aao, overview);

        // fill list of the filters with the values
        //overview.filter_criterion = _data.size() > 0 ? (List<String>) _data.get(0) : new ArrayList<String>(); //Arrays.<String>asList(new String[]{"(CCCTCT)n  <  40", "(CCCTCT)n  40-49", "(CCCTCT)n  >50", "(CCCTCT)n  >51"});
        overview.filter_criterion = _data.size() > 0 ? ((List<String>) _data.get(0)).stream().filter(x -> !StringUtils.endsWith(x, "*")).collect(Collectors.toList()) : new ArrayList<String>();
        overview.filter_criterion1 = Arrays.asList("All","LRRK2","SNCA","VPS35","PINK1","Parkin","DJ1","GBA","Other");
        // replace the name of the selected filter with another one (if it is defined in the excel file)
        IntStream.range(0, overview.filter_criterion.size()).
        filter(x -> fc != null && fc == x && _data.size() > 3 && !StringUtils.isEmpty(((List<String>)_data.get(3)).get(fc))).
        forEach(x -> {
        	overview.filter_criterion.remove(x);
        	overview.filter_criterion.add(x, ((List<String>)_data.get(3)).get(fc));
        });

        // fill list of the filter with the parameters which can be multiple selected
//        overview.filtered_mutations = _data.size() > 0 ? ((List<String>) _data.get(0)).stream().filter(x -> StringUtils.endsWith(x, "*")).map(x -> x.replaceAll("\\*", "")).collect(Collectors.toList()) : new ArrayList<String>();//Arrays.<String>asList(new String[]{"(CCCTCT)n  <  40", "(CCCTCT)n  40-49", "(CCCTCT)n  >50"});

        String _filter = "&fc=" + (fc == null ? 0 : fc) + "&repeats="+overview.getRepeats() +"&fn=" + selected_gene_id;
 	    _filter = addAaoToFilter(overview.getAao(), _filter, overview);
		List<String> список_мутации = (List)restTemplate.getForObject("http://"
				+ ChartsData.UNPUBLISHED_DATA_URL
				+ "/tfi1?todo=16"+_filter, List.class);
        overview.filtered_mutations = список_мутации;
        //Arrays.<String>asList(new String[]{"g.9020A>G", "g.9611T>C", "g.18495C>T"});

        // assign the name of the selected filter to the variable
	    List<String> humanized_filters = _data.size() > 0 ? (List<String>) _data.get(0) : new ArrayList<String>();
	    if (fc != null) {
		    overview.setHumanized_filter(humanized_filters.get(fc));
		    // check if this filter has a range
		    overview.filter_by_aao = (_data.size() >= 3 && ((List)_data.get(2)).get(fc) != null);
	    }
//	    // check if the range is selected for this filter
		if (overview.filter_by_aao) {// Neglect AAO when it is not chosen for filtering.
			Map<String, Object> aao_result = range(((List)_data.get(2)).get(fc).toString());
			overview.setAao((aao != null ? aao : (String) aao_result.get("default")));
			overview.setAaoRange((List<String>) aao_result.get("range"));
		}
		// set the title of the multiple selected filter in the web
		overview.setFilter_mutations_placeholder("any repeats");
		// selected filters
		overview.setRepeats(0);
 	    if (mut_restrict != null) {
 	 	    overview.setMu(mut_restrict.stream().map(x -> StringUtils.strip(x)).filter(x -> !x.equals("benign")).collect(Collectors.toList()));
 	 	    mut_restrict.stream().forEach(m -> {
 	 	    	if (NumberUtils.isDigits(m)) overview.setRepeats(overview.getRepeats() | ((int)Math.pow(2, Integer.valueOf(m))));
 	 	    });
 	    } else {
 	    	overview.setMu(new ArrayList<String>());
 	    }
 	}

	protected void fillFilterData(Integer selected_gene_id, Integer fc, String aao, Overview overview) {
		// do the request to the backend to get available filters
		String _filter = "&fc=" + (fc == null ? 0 : fc) + "&repeats=0&fn=" + selected_gene_id;
 	    _filter = addAaoToFilter(aao, _filter, overview);
        _data = (List<?>)restTemplate.getForObject("http://"
        		+ ChartsData.UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=10001"+_filter, List.class);
	}

	private String addAaoToFilter(String aao, String _filter, Overview overview) {
		if (aao != null) {
			try {
				_filter = _filter + "&aao=" + URLEncoder.encode(aao, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				LOGGER.warn(e.getMessage());
			}
		}
		if (overview.getMu() != null && !overview.getMu().isEmpty()) {
			_filter = добавитьМутацииКФилтру(overview.getMu(), _filter);
		}
		return _filter;
	}
	/**
	 *
	 * @param rangeFormula - SpEX formula which is represented formula to define range of variables
	 * @return return Map which contains two key
	 * First key 'range' - which contains array of variables for range
	 * Second key 'default' - which contains default key (for the case if no variables is set)
	 */
	private Map<String, Object> range(String rangeFormula) {
		Map<String, Object> _result = new HashMap();

		// init predefined as fail this value will be replaced in a case of success
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Invalid:" + rangeFormula);
		_result.put("range", arrayList);
		_result.put("default", "");

		try {
			ExpressionParser parser = new SpelExpressionParser();
			List<String> value = parser.parseExpression(rangeFormula).getValue(List.class);
			boolean[] list = new boolean[] {true};
			// for the range of the elements the following expression is valid
			// for ex.: new String[]{'p1','p2','p3','default:p2'}
			value.stream().filter(x -> x != null).forEach(x -> {
				if (x.startsWith("start:")) list[0] = false;
				if (x.startsWith("default:") && x.split(":").length == 2) _result.put("default", x.split(":")[1]);
			});
			if (list[0]) {
				_result.put("range", value.stream().filter(x -> x != null && !x.trim().startsWith("default:")).collect(Collectors.toList()));
			} else {
				try {
					Map<String, Double> range = new HashMap<String, Double>();
					range.put("decimal", 0d);
					value.stream().map(x -> x.trim()).filter(x -> x.split(":").length == 2 && NumberUtils.isParsable(x.split(":")[1])).forEach(x -> {
						String[] split = x.split(":");
						if (x.startsWith("start:")) range.put("start", Double.valueOf(split[1]));
						if (x.startsWith("end:")) range.put("end", Double.valueOf(split[1]));
						if (x.startsWith("step:")) range.put("step", Double.valueOf(split[1]));
						if (x.startsWith("default:")) range.put("default", Double.valueOf(split[1]));
						if (x.startsWith("decimal:")) range.put("decimal", Double.valueOf(split[1]));
					});
					Set<String> result = new HashSet<String>();
					boolean default_not_set = true;
					for (double num=range.get("start"); num <= range.get("end") && range.get("start") < range.get("end") && range.get("step") > 0; num+=range.get("step")) {
						if (range.get("decimal") > 0) {
					    	result.add(String.format ("%." + Math.round(range.get("decimal")) + "f", num).replaceAll(",", "."));
					    	if (default_not_set) _result.put("default", String.format ("%." + Math.round(range.get("decimal")) + "f", range.get("default")));
						} else {
					    	result.add(String.format ("%d", Math.round(num)));
					    	if (default_not_set) _result.put("default", String.format ("%d", Math.round(range.get("default"))));
						}
						default_not_set = false;
					}
					List<String> collect = result.stream().sorted(((o1, o2)->Double.valueOf(o1).compareTo(Double.valueOf(o2)))).collect(Collectors.toList());
					_result.put("range", collect);
				} catch (Exception ex) {
					LOGGER.error(ex.getMessage());
				}
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return _result;
	}

	public static class SortAttr{
		boolean asc;
		int priority;
		boolean number;
		String title;

		public SortAttr(String title, boolean asc, int priority, boolean number) {
			this.title = title;
			this.asc = asc;
			this.priority = priority;
			this.number = number;
		}
		/**
		 * compare content of two elements(i,j) in the data array.
		 *
		 * The following logic is created:
		 * To sort the data, data header should have the following optional parameters implemented.
		 *
		 * Example: aaa*+1n
		 * It means sort the column aaa, ascending,with the priority 1 and column contains only the numbers.
		 *
		 * +/- means ascending/descending order
		 * 1 - is the priority
		 * n - values in the column are the numbers (if it is not presented values in the column are strings)
		 *
		 * @param data - excel file data
		 * @param sortOrder - list of sort attributes, sorted by the priority of it
		 * @param i - element to compare
		 * @param j - element to compare
		 * @return - -1/0/1 based on the comparison (see compare method for more information).
		 */
		public static int compareTo(List<List<String>> data, List<SortAttr> sortOrder, int i, int j) {
			int result = 0;
			for (int ii = 0; ii < sortOrder.size(); ii++) {
				SortAttr sortAttr = sortOrder.get(ii);
			    for (List<String> list : data) {
			    	if (list.size() == 0) continue;

			    	if (list.get(0).equals(sortAttr.title)) {
			    		if (sortAttr.number && NumberUtils.isParsable(list.get(i)) && NumberUtils.isParsable(list.get(j))) {
			    			result = sortAttr.asc ? Double.valueOf(list.get(i)).compareTo(Double.valueOf(list.get(j)))
					    			              : Double.valueOf(list.get(j)).compareTo(Double.valueOf(list.get(i)));
			    		} else if (sortAttr.number && (NumberUtils.isParsable(list.get(i)) || NumberUtils.isParsable(list.get(j)))) {
			    			return sortAttr.asc ? (!NumberUtils.isParsable(list.get(i)) ? -1 : 1)
			    								: (!NumberUtils.isParsable(list.get(j)) ? -1 : 1);
			    		}
			    		if (!sortAttr.number && list.get(i) != null && list.get(j) != null) {
			    			result = sortAttr.asc ? StringUtils.compare(list.get(i), list.get(j))
			    								  : StringUtils.compare(list.get(j), list.get(i));
			    		} else if (!sortAttr.number && (list.get(i) != null || list.get(j) != null)) {
			    			return sortAttr.asc ? (list.get(i) == null ? -1 : 1)
    											: (list.get(j) == null ? -1 : 1);
			    		}
					    if (result != 0) {
					    	return result < 0 ? -1 : 1;
					    }
			    	}
			    }
			}
			return result;
		}
	}


	public String popupBuilder(String cityName, List<List<String>> data){

		Map<String, List<String>> dataMap = new HashMap<>();
		for (List<String> list : data){
			dataMap.put(list.get(0), list);
		}
		int indexOfTheCity = 0;
//		for (int i = 0; i <  dataMap.get("city*").size(); i++){
//			if (dataMap.get("city*").get(i).equals(cityName)){
//				indexOfTheCity = i;
//			}
//		}
		for (int i = 0; i <  dataMap.get("name_of_the_site*").size(); i++){
			if (dataMap.get("name_of_the_site*").get(i).trim().equals(cityName)){
				indexOfTheCity = i;
			}
		}

//		int imageNumber = 0;
//		if (imageNumbers.get(indexOfTheCity) != null && !imageNumbers.get(indexOfTheCity).equals("") && !imageNumbers.get(indexOfTheCity).equals("n.a.")) {
//			imageNumber = Integer.parseInt(imageNumbers.get(indexOfTheCity));
//		}


		StringBuilder text = new StringBuilder();

		text.append("<div style=\"background-color: #ece6e5; border-style: solid; border-color: #FF972B; border-width: 4px; border-radius: 16px;\">\r\n");

		text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">" + dataMap.get("name_of_the_site*").get(indexOfTheCity) + "</p>");
		//new
		if (!dataMap.get("number_of_new_patients_year*").get(indexOfTheCity).trim().equals("n.a.") && !dataMap.get("number_of_new_patients_year*").get(indexOfTheCity).trim().equals("")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left\">• New PD patients/year: " + dataMap.get("number_of_new_patients_year*").get(indexOfTheCity) + "</p>");
		}
		if (dataMap.get("genetic_testing_regulary_performed*").get(indexOfTheCity).trim().equals("regularly performed")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left\">• Genetic testing " + dataMap.get("genetic_testing_regulary_performed*").get(indexOfTheCity) +"</p>");
		}
		if (dataMap.get("qualified_genetic_counseling*").get(indexOfTheCity).trim().equals("available")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left\">• Qualified genetic counseling " + dataMap.get("qualified_genetic_counseling*").get(indexOfTheCity) + "</p>");
		}
		if (!dataMap.get("clinical_trial_site*").get(indexOfTheCity).trim().equals("-") && !dataMap.get("clinical_trial_site*").get(indexOfTheCity).trim().equals("n.a.")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left\">• " + dataMap.get("clinical_trial_site*").get(indexOfTheCity) + "</p>");
		}


		if(dataMap.get("sex*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
				|| !dataMap.get("age*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")){

			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Demographic data available</p>\n" +
					"<p style=\"margin-bottom: 0px; text-align: left\">• ");
//					if (!dataMap.get("sex*").get(indexOfTheCity).trim().equals("not available") && !dataMap.get("sex*").get(indexOfTheCity).trim().equals("n.a.") && !dataMap.get("sex*").get(indexOfTheCity).trim().equals("-")){
//						text.append("Sex, ");
//					}
//					if (!dataMap.get("age*").get(indexOfTheCity).trim().equals("not available") && !dataMap.get("age*").get(indexOfTheCity).trim().equals("n.a.") && !dataMap.get("age*").get(indexOfTheCity).trim().equals("-")){
//						text.append("Age");
//					}
			//NEW SEX AND AGE,   ^^^^^^ old sex and age
			if (dataMap.get("sex*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")){
				text.append("Sex, ");
			}
			if (dataMap.get("age*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")){
				text.append("Age");
			}
			text.append(
					"</p>");
		}

		if (dataMap.get("age_at_onset*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
//						|| dataMap.get("age_at_onset*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")
				|| dataMap.get("updrs*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
//						|| dataMap.get("updrs*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")
				|| dataMap.get("hoehn_and_yahr_scale*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
//						|| dataMap.get("hoehn_and_yahr_scale*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")
				|| dataMap.get("nonmotor_scales*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
//						|| dataMap.get("nonmotor_scales*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")
				|| dataMap.get("olfactory_tests*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")
//						|| dataMap.get("olfactory_tests*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")
				|| !dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("")
				|| !dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("-")
				|| !dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("n.a.")
		) {

			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Clinical data available</p>\n" +
					"<p style=\"margin-bottom: 0px; text-align: left\">• ");
//					if (dataMap.get("age_at_onset*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)") || dataMap.get("age_at_onset*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")) {
			if (dataMap.get("age_at_onset*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")) {
				text.append("Age at onset, ");
			}
//					if (dataMap.get("updrs*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)") || dataMap.get("updrs*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")) {
			if (dataMap.get("updrs*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")) {
				text.append("UPDRS, ");
			}
//					if (dataMap.get("hoehn_and_yahr_scale*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)") || dataMap.get("hoehn_and_yahr_scale*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")) {
			if (dataMap.get("hoehn_and_yahr_scale*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")) {
				text.append("Hoehn and Yahr scale, ");
			}
//					if (dataMap.get("nonmotor_scales*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)") || dataMap.get("nonmotor_scales*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")) {
			if (dataMap.get("nonmotor_scales*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")) {
				text.append("Nonmotor scales, ");
			}
//					if (dataMap.get("olfactory_tests*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)") || dataMap.get("olfactory_tests*").get(indexOfTheCity).trim().equals("not standardly recorded (or not available for most cases)")) {
			if (dataMap.get("olfactory_tests*").get(indexOfTheCity).trim().equals("standardly recorded (and available for most cases)")) {
				text.append("Olfactory testing");
			}
			if	(!dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("") && !dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("-") && !dataMap.get("demographic_data_other*").get(indexOfTheCity).trim().equals("n.a.")){

			}

			text.append("</p>");

		}

		if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("dna*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("can be obtained")
		) {


			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Biomaterial</p>\n");


			if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for most cases")
			) {
				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Available for most cases: </b>");
				if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("DNA, ");
				}
				if (dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("RNA, ");
				}
				if (dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Serum, ");
				}
				if (dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Plasma, ");
				}
				if (dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Whole blood, ");
				}
				if (dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("CSF, ");
				}
				if (dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Fibroblasts, ");
				}
				if (dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("iPSCs, ");
				}
				if (dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Brain tissue");
				}
				text.append("</p>");
			}

			if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for a subset")
			) {
				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Available for a subset: </b>");
				if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("DNA, ");
				}
				if (dataMap.get("rna*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("RNA, ");
				}
				if (dataMap.get("serum*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Serum, ");
				}
				if (dataMap.get("plasma*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Plasma, ");
				}
				if (dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Whole blood, ");
				}
				if (dataMap.get("csf*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("CSF, ");
				}
				if (dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Fibroblasts, ");
				}
				if (dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("iPSCs, ");
				}
				if (dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Brain tissue");
				}
				text.append("</p>");
			}

			if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("rna*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("serum*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("plasma*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("csf*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("can be obtained")
			) {
				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Can be obtained: </b>");
				if (dataMap.get("dna*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("DNA, ");
				}
				if (dataMap.get("rna*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("RNA, ");
				}
				if (dataMap.get("serum*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Serum, ");
				}
				if (dataMap.get("plasma*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Plasma, ");
				}
				if (dataMap.get("whole_blood*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Whole blood, ");
				}
				if (dataMap.get("csf*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("CSF, ");
				}
				if (dataMap.get("fibroblasts*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Fibroblasts, ");
				}
				if (dataMap.get("ipscs*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("iPSCs, ");
				}
				if (dataMap.get("brain_tissue*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Brain tissue");
				}
				text.append("</p>");
			}
		}

		if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for most cases")
				|| dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for a subset")
				|| dataMap.get("genomics*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("can be obtained")
				|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("can be obtained")
		) {

			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">OMICS</p>\n");


			if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for most cases")
					|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for most cases")) {

				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Available for most cases: </b>");

				if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Genomics, ");
				}
				if (dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Transcriptomics, ");
				}
				if (dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Proteomics, ");
				}
				if (dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for most cases")) {
					text.append("Metabolomics");
				}
				text.append("</p>");
			}

			if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for a subset")
					|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for a subset")) {


				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Available for a subset: </b>");
				if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Genomics, ");
				}
				if (dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Transcriptomics, ");
				}
				if (dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Proteomics, ");
				}
				if (dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("available for a subset")) {
					text.append("Metabolomics");
				}
				text.append("</p>");
			}

			if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("can be obtained")
					|| dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("can be obtained")) {


				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Can be obtained: </b>");

				if (dataMap.get("genomics*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Genomics, ");
				}
				if (dataMap.get("transcriptomics*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Transcriptomics, ");
				}
				if (dataMap.get("proteomics*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Proteomics, ");
				}
				if (dataMap.get("metabolomics*").get(indexOfTheCity).trim().equals("can be obtained")) {
					text.append("Metabolomics");
				}
				text.append("</p>");
			}
		}


		if (dataMap.get("csf_handling*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("serum_plasma_handling*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("culturing_of_fibroblasts*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("isolation_of_cells_from_whole_blood*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("generation_of_ipscs*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("neuropathology*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("mri_device_field_strength*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("spect_pet*").get(indexOfTheCity).trim().equals("available")
				|| dataMap.get("tcs*").get(indexOfTheCity).trim().equals("available")
		) {

			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Facilities available\n");

			if (dataMap.get("csf_handling*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("serum_plasma_handling*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("culturing_of_fibroblasts*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("isolation_of_cells_from_whole_blood*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("generation_of_ipscs*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("neuropathology*").get(indexOfTheCity).trim().equals("available")
			) {


				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Laboratory facilities: </b>");

				if (dataMap.get("csf_handling*").get(indexOfTheCity).trim().equals("available")) {
					text.append("CSF handling, ");
				}
				if (dataMap.get("serum_plasma_handling*").get(indexOfTheCity).trim().equals("available")) {
					text.append("Serum Plasma handling, ");
				}
				if (dataMap.get("culturing_of_fibroblasts*").get(indexOfTheCity).trim().equals("available")) {
					text.append("Culturing of fibroblasts, ");
				}
				if (dataMap.get("isolation_of_cells_from_whole_blood*").get(indexOfTheCity).trim().equals("available")) {
					text.append("Isolation of cells from whole blood, ");
				}
				if (dataMap.get("generation_of_ipscs*").get(indexOfTheCity).trim().equals("available")) {
					text.append("Generation of iPSCs, ");
				}
				if (dataMap.get("neuropathology*").get(indexOfTheCity).trim().equals("available")) {
					text.append("Neuropathology");
				}
				text.append("</p>");
			}

			if (dataMap.get("mri_device_field_strength*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("spect_pet*").get(indexOfTheCity).trim().equals("available")
					|| dataMap.get("tcs*").get(indexOfTheCity).trim().equals("available")
			) {

				text.append("<p style=\"margin-bottom: 0px; text-align: left\">• <b>Imaging facilities: </b>");
				if (dataMap.get("mri_device_field_strength*").get(indexOfTheCity).trim().equals("available")) {
					text.append("MRI, ");
				}
				if (dataMap.get("spect_pet*").get(indexOfTheCity).trim().equals("available")) {
					text.append("SPECT/PET, ");
				}
				if (dataMap.get("tcs*").get(indexOfTheCity).trim().equals("available")) {
					text.append("TCS");
				}
				text.append("</p>");
			}
		}

//		text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n");

		if (dataMap.get("projects").get(indexOfTheCity).equals("1")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 100px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_1.jpg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("2")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 135px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_2.png\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("3")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 180px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_3.jpeg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("4")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 125px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_4.jpeg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("5")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 140px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_5.jpg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("6")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 260px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_6.jpeg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("7")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 260px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_7.jpeg\">");
		}
		else if (dataMap.get("projects").get(indexOfTheCity).equals("8")){
			text.append("<p style=\"margin-bottom: 0px; text-align: left; color: #FF972B\">Other consortia</p>\n <img style=\"max-width: 340px; margin-top: 20px; margin-bottom: 20px; margin-left: 10px; margin-bottom\" src=\"\\assets\\image_8.jpeg\">");
		}


		text.append("</div>");


		return text.toString();
	}


	@Override
	public void readPublications(Overview overview, Integer page, ПараметрыФильтра параметрыФильтра, Integer selected_gene_id, Function<List<String>, List<String>> обработка_данных) {
		List<SortAttr> sortOrder = new ArrayList<>();
    	try {
			String _filter = "&fc=" + (параметрыФильтра.fc == null ? 0 : параметрыФильтра.fc) + "&repeats="+overview.getRepeats() +"&fn=" + selected_gene_id;
	 	    _filter = addAaoToFilter(overview.getAao(), _filter, overview);
	 	   _filter = добавитьМутацииКФилтру(overview.getMu(), _filter);
	 	  _filter = параметрыФильтра.добавить(_filter);

			_data = (List)restTemplate.getForObject("http://"
					+ ChartsData.UNPUBLISHED_DATA_URL
					+ "/tfi1?todo=10002"+_filter, List.class);
	        // parse parameters
		    List<List<String>> data1 = (List<List<String>>) _data;
		    List<List<String>> data = data1.stream().filter(_list -> _list.get(0) != null).map((_данные) -> { if(обработка_данных != null) return обработка_данных.apply(_данные); else return _данные; }).collect(Collectors.toList());

		    for (List<String> list : data) {
		    	if (list.size() < 2) break;
		    	String title = list.get(0);
		    	//get information about sorting criteria
		    	if (title.contains("*") && title.split("\\*").length > 1) {
		    		boolean asc = title.split("\\*")[1].replaceAll("[^\\+,\\-]", "").equals("-");
		    		String _priority = title.split("\\*")[1].replaceAll("[^0-9]", "");
		    		int priority = NumberUtils.isParsable(_priority) ? Integer.valueOf(_priority) : 100000;
		    		boolean number = title.split("\\*")[1].replaceAll("[^n]", "").equals("n");
		    		sortOrder.add(new SortAttr(title, asc, priority, number));
		    	}
		    }
		    // sort data if it is needed
		    if (!sortOrder.isEmpty()) {
			    // sort rows based on there priorities
			    sortOrder.sort((o1, o2) -> Integer.valueOf(o1.priority).compareTo(o2.priority));
			    // sorted elements indexes in the unsorted array
		    	int[] sortedIndices = IntStream.range(1, data.get(0).size())
		                .boxed().sorted((i, j) -> SortAttr.compareTo(data, sortOrder, i, j) )
		                .mapToInt(ele -> ele).toArray();
		    	// title will remain on the same position
		    	ArrayUtils.insert(0, sortedIndices, 0);
		    	// deep copy data array to a new one
			    List<List<String>> data_unsorted = new ArrayList<List<String>>();
		    	data.stream().forEach(x -> {
		    		List<String> _list = new ArrayList<String>();
		    		data_unsorted.add(_list);
		    		if (x != null) x.stream().forEach(x1 -> _list.add(x1));
		    	});
		    	// sort data
		    	IntStream.range(0, data.size()).forEach(ii -> {
		    		data.get(ii).clear();
		    		data.get(ii).add(data_unsorted.get(ii).get(0)); // add title
		    		IntStream.range(0, sortedIndices.length).forEach(index -> data.get(ii).add(data_unsorted.get(ii).get(sortedIndices[index])));
		    	});

		    }


//				this for finds the list with projects, deletes the .0 part
			if (data.get(0).get(0).equals("name_of_the_site*")){
				overview.isStepThreeFile = true;
//				int indexOfImageNumberListForDeletingLater = 0;
				for (int j = 0; j < data.size(); j++){
//					if (data.get(j).get(0).equals("image_number*")){
					if (data.get(j).get(0).equals("projects")){
						for (int i = 0; i < data.get(j).size(); i++){
//							if (!data.get(j).get(i).equals("n.a.") && !data.get(j).get(i).equals("image_number*")) {
							if (!data.get(j).get(i).equals("n.a.") && !data.get(j).get(i).equals("projects")) {
								String value = data.get(j).get(i);
								if (value != null && !value.equals("")) {
									String[] arrSplit = value.split("\\.");
									if (arrSplit.length > 1) {
										data.get(j).set(i, arrSplit[0]);
									}
								}
							}
						}
//						indexOfImageNumberListForDeletingLater = j;
					}
				}
//				data.remove(indexOfImageNumberListForDeletingLater);
			}







		    //checking if the numbers come with E, and '.' and ignoring them
		    for (List<String> listOfColumn : data){
		    	if (listOfColumn.get(0).equals("family id*")){
					for (int i = 0; i < listOfColumn.size(); i++){
						if (Character.isDigit(listOfColumn.get(i).charAt(0)) && listOfColumn.get(i).contains("E")) {
							String[] array = listOfColumn.get(i).split("\\.");
							if (array.length == 2){
								if (array[0].toCharArray().length == 1){
									if (Character.isDigit(listOfColumn.get(i).charAt(listOfColumn.get(i).length()-1))){
										String[] array1 = listOfColumn.get(i).split("E");
										listOfColumn.set(i, array1[0]);
										String[] array2 = listOfColumn.get(i).split("\\.");
										listOfColumn.set(i, array2[0] + array2[1]);
									}
								}
							}
						}
					}
				}
			}



			// making yes and no look 1 way(capitall letters, and so on)
			for (int i = 0; i < data.size(); i++){
				for (int j = 1; j < data.get(i).size(); j++){
					if(data.get(i).get(j) == null){
						data.get(i).set(j, "n.a.");
					}
					data.get(i).set(j, data.get(i).get(j).trim());

					if (data.get(i).get(j).equals("Yes")
							|| data.get(i).get(j).equals("No")){
						data.get(i).set(j, data.get(i).get(j).toLowerCase());
					}
					if (data.get(i).get(j).equals("(yes)")){
						data.get(i).set(j, data.get(i).get(j).replace("(yes)", "yes"));
					}
				}
			}



		    //making strings look like an int(visual)
			for (int i = 0; i < data.size(); i++){
				if (data.get(i).get(0).equals("age_at_onset*")
						|| data.get(i).get(0).equals("age_at_exam*")
						|| data.get(i).get(0).equals("year_of_last_contact*")
						|| data.get(i).get(0).equals("age_at_last_contact*")
						|| data.get(i).get(0).equals("no_hom_affected*")
						|| data.get(i).get(0).equals("no_het_affected*")
						|| data.get(i).get(0).equals("no_wt_affected*")
						|| data.get(i).get(0).equals("no_hom_unaffected*")
						|| data.get(i).get(0).equals("no_het_unaffected*")
						|| data.get(i).get(0).equals("no_wt_unaffected*")
						|| data.get(i).get(0).equals("num_fam_with_segregation1*")
						|| data.get(i).get(0).equals("functional_studies1*")
						|| data.get(i).get(0).equals("points_segregation1*")
						|| data.get(i).get(0).equals("points_frequency_controls1*")
						|| data.get(i).get(0).equals("points_CADD_score1*")
						|| data.get(i).get(0).equals("points_functional_studies1*")
						|| data.get(i).get(0).equals("final_score1*")
						|| data.get(i).get(0).equals("num_fam_with_segregation2*")
						|| data.get(i).get(0).equals("functional_studies2*")
						|| data.get(i).get(0).equals("points_segregation2*")
						|| data.get(i).get(0).equals("points_frequency_controls2*")
						|| data.get(i).get(0).equals("points_CADD_score2*")
						|| data.get(i).get(0).equals("points_functional_studies2*")
						|| data.get(i).get(0).equals("final_score2*")
						|| data.get(i).get(0).equals("num_fam_with_segregation3*")
						|| data.get(i).get(0).equals("CADD_score3*")
						|| data.get(i).get(0).equals("functional_studies3*")
						|| data.get(i).get(0).equals("points_segregation3*")
						|| data.get(i).get(0).equals("points_frequency_controls3*")
						|| data.get(i).get(0).equals("points_CADD_score3*")
						|| data.get(i).get(0).equals("points_functional_studies3*")
						|| data.get(i).get(0).equals("final_score3*")
						|| data.get(i).get(0).equals("CADD_score2*")
						|| data.get(i).get(0).equals("CADD_score1*")
						|| data.get(i).get(0).equals("mds_updrs_comb*")
						||data.get(i).get(0).equals("updrs_comb*")
						||data.get(i).get(0).equals("number_of_new_patients_year*")
						|| data.get(i).get(0).contains("index")){
					for (int j = 1; j < data.get(i).size(); j++){

						if (!data.get(i).get(j).equals("n.a.")) {
							String value = data.get(i).get(j);
							String[] arrSplit = value.split("\\.");
							if (arrSplit.length > 1) {
								data.get(i).set(j, arrSplit[0]);
							}
						}
					}
				}
			}










			//filtering by AAE
			if (overview.getFilterForAAE() != null && !overview.getFilterForAAE().equals("All")) {
//				if (overview.getFilterForAAE().equals("AAE &lt; 50(Adjustable)")) {
				if (overview.getFilterForAAE().equals("minus")) {
					overview.filter_by_aae = true;
					if (overview.getAae() == null) {
						overview.setAae("49");
					}

//				} else if (overview.getFilterForAAE().equals("AAE &gt;= 50(Adjustable)")) {
				} else if (overview.getFilterForAAE().equals("plus")) {
					overview.filter_by_aae = true;
					if (overview.getAae() == null) {
						overview.setAae("50");
					}
				}

				//This for loop finds all the indexes of data, that must stay in data, the rest part will be removed(AAE filter)
				List<Integer> listOfInts = new ArrayList<>();
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i).get(0).equals("age_at_exam*")) {
						for (int j = 1; j < data.get(i).size(); j++) {
//							if (overview.getFilterForAAE().equals("AAE &gt;= 50(Adjustable)")) {
							if (overview.getFilterForAAE().equals("plus")) {
								if (data.get(i).get(j).equals("n.a.")) {
									//if statement is written just to skip the n.a. values
								}
								else {
									try {
										Integer dataInt = Integer.parseInt(data.get(i).get(j));
										Integer aaeInt = Integer.parseInt(overview.getAae());
										if (dataInt >= aaeInt) {
											listOfInts.add(j);
										}
									} catch (Exception e) {
										System.out.println("text in Age at Exam");
									}
								}
//							} else if (overview.getFilterForAAE().equals("AAE &lt; 50(Adjustable)")) {
							} else if (overview.getFilterForAAE().equals("minus")) {
								if (data.get(i).get(j).equals("n.a.")) {
//								listOfInts.add(j);
								} else {
									try {
										Integer dataInt = Integer.parseInt(data.get(i).get(j));
										Integer aaeInt = Integer.parseInt(overview.getAae());
										if (dataInt < aaeInt) {
											listOfInts.add(j);
										}
									} catch (Exception e) {
										System.out.println("text in Age at Exam");
									}
								}
							}
						}
					}
				}
				//now removing the filtered part, and only listOfInts indexes will be left
				List<List<String>> filteredByAAEData = new ArrayList<>();

				for (int i = 0; i < data.size(); i++){
					List<String> stringList = new ArrayList<>();
					stringList.add(data.get(i).get(0));
					for (int j = 0; j < listOfInts.size(); j++){
						stringList.add(data.get(i).get(listOfInts.get(j)));
					}
					filteredByAAEData.add(stringList);
				}
				data.clear();
				for (List list : filteredByAAEData){
					data.add(list);
				}
				filteredByAAEData.clear();
			}
			//AAE filtering finished

			//filtering BY YLC
			if (overview.getFilterForYLC() != null && !overview.getFilterForYLC().equals("All")) {
//				if (overview.getFilterForYLC().equals("YLC &lt; 2006(Adjustable)")) {
				if (overview.getFilterForYLC().equals("minus")) {
					overview.filter_by_ylc = true;
					if (overview.getYlc() == null) {
						overview.setYlc("2005");
					}

//				} else if (overview.getFilterForYLC().equals("YLC &gt;= 2006(Adjustable)")) {
				} else if (overview.getFilterForYLC().equals("plus")) {
					overview.filter_by_ylc = true;
					if (overview.getYlc() == null) {
						overview.setYlc("2006");
					}
				}

				//This for loop finds all the indexes of data, that must stay in data, the rest part will be removed(YLC filter)
				List<Integer> listOfInts = new ArrayList<>();
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i).get(0).equals("year_of_last_contact*")) {
						for (int j = 1; j < data.get(i).size(); j++) {
//							if (overview.getFilterForYLC().equals("YLC &gt;= 50(Adjustable)")) {
							if (overview.getFilterForYLC().equals("plus")) {
								if (data.get(i).get(j).equals("n.a.")) {
								} else {
									try {
										Integer dataInt = Integer.parseInt(data.get(i).get(j));
										Integer ylcInt = Integer.parseInt(overview.getYlc());
										if (dataInt >= ylcInt) {
											listOfInts.add(j);
										}
									} catch (Exception e) {
										System.out.println("text in Year of Last Contract");
									}
								}
//							} else if (overview.getFilterForYLC().equals("YLC &lt; 50(Adjustable)")) {
							} else if (overview.getFilterForYLC().equals("minus")) {
								if (data.get(i).get(j).equals("n.a.")) {
//								listOfInts.add(j);
								} else {
									try {
										Integer dataInt = Integer.parseInt(data.get(i).get(j));
										Integer ylcInt = Integer.parseInt(overview.getYlc());
										if (dataInt < ylcInt) {
											listOfInts.add(j);
										}
									} catch (Exception e) {
										System.out.println("text in Year of Last Contract");
									}
								}
							}
						}
					}
				}
				//now removing the filtered part, and only listOfInts indexes will be left
				List<List<String>> filteredByYLCData = new ArrayList<>();

				for (int i = 0; i < data.size(); i++){
					List<String> stringList = new ArrayList<>();
					stringList.add(data.get(i).get(0));
					for (int j = 0; j < listOfInts.size(); j++){
						stringList.add(data.get(i).get(listOfInts.get(j)));
					}
					filteredByYLCData.add(stringList);
				}
				data.clear();
				for (List list : filteredByYLCData){
					data.add(list);
				}
				filteredByYLCData.clear();
			}
			//YLC filtering finished



//			overview.setSizeVersion(ColumnsDecorator.humanize("sizeVersion"));
			overview.setSizeVersion("long");

			overview.setWholeData(new ArrayList<>());
			for (int i = 0; i < data.size(); i++){
				List<String> list = new ArrayList<>();
				for(int j = 0; j < data.get(i).size(); j++){
					list.add(data.get(i).get(j));
				}
				overview.wholeData.add(list);
			}

			if (overview.wholeData.get(0).get(0).equals("name_of_the_site*")){
				overview.isStepThreeFile = true;


			}


			//filtering the cities for Google Map





			if (overview.short_version != true){
			//creating sets for select options
			List<TreeSet<String>> listOfSets = new ArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				TreeSet<String> set = new TreeSet<>();
				for (int j = 1; j < data.get(i).size(); j++) {
					if (data.get(i).get(j) == null) {
						set.add("n.a.");
					} else {
						set.add(data.get(i).get(j));
					}
				}
				listOfSets.add(set);
			}
			overview.setWholeDataListofSets(listOfSets);

			Map<String, ArrayList<String>> mapOfOptions = new HashMap<>();


				// this if/else sorts the select values, also converts from set to list, also puts "n.a.", "n/a" and "na" as last elements of the list
			if (overview.isStepThreeFile){
				//TODO STEP3 IS NOT DONE YET!!!!!!!!!!!!!!!!!!!!
				for (int i = 0; i < overview.getWholeDataListofSets().size(); i++) {
					mapOfOptions.put(data.get(i).get(0), new ArrayList<>(overview.getWholeDataListofSets().get(i)));
					if (mapOfOptions.get(data.get(i).get(0)).contains("n.a.")){
						mapOfOptions.get(data.get(i).get(0)).remove("n.a.");
						List<Integer> listOfIntegerNumbers;
						//converts from String list into Integer list, sorts, and converts back into String list
						if (data.get(i).get(0).equals("number_of_new_patients_year*")){
							listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Integer.parseInt(s))
									.collect(Collectors.toList());
							Collections.sort(listOfIntegerNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						mapOfOptions.get(data.get(i).get(0)).add("n.a.");
					}
//					if (mapOfOptions.get(data.get(i).get(0)).contains("n.g.")){
//						mapOfOptions.get(data.get(i).get(0)).remove("n.g.");
//						mapOfOptions.get(data.get(i).get(0)).add("n.g.");
//					}
//					if (mapOfOptions.get(data.get(i).get(0)).contains("n/a")){
//						mapOfOptions.get(data.get(i).get(0)).remove("n/a");
//						mapOfOptions.get(data.get(i).get(0)).add("n/a");
//					}
//					if (mapOfOptions.get(data.get(i).get(0)).contains("na")){
//						mapOfOptions.get(data.get(i).get(0)).remove("na");
//						mapOfOptions.get(data.get(i).get(0)).add("na");
//					}
				}

			}
			else{
				for (int i = 1; i < overview.getWholeDataListofSets().size(); i++) {
					mapOfOptions.put(data.get(i).get(0), new ArrayList<>(overview.getWholeDataListofSets().get(i)));
					if (!mapOfOptions.get(data.get(i).get(0)).contains("n.a.")) {
						List<Integer> listOfIntegerNumber;
						if (data.get(i).get(0).equals("age_at_onset*")) {
							listOfIntegerNumber = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Integer.parseInt(s))
									.collect(Collectors.toList());
							Collections.sort(listOfIntegerNumber);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumber.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
					}
					if (mapOfOptions.get(data.get(i).get(0)).contains("n.a.")){
						mapOfOptions.get(data.get(i).get(0)).remove("n.a.");
						List<Float> listOfFloatNumbers;
						List<Integer> listOfIntegerNumbers;
						//converts from String list into Float list, sorts, and converts back into String list
						if (data.get(i).get(0).equals("hy_stage_comb*")){
							listOfFloatNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Float.parseFloat(s))
									.collect(Collectors.toList());
							Collections.sort(listOfFloatNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfFloatNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						//converts from String list into Integer list, sorts, and converts back into String list
						else if (data.get(i).get(0).equals("age_at_onset*")
								|| data.get(i).get(0).equals("age_at_exam*")
								|| data.get(i).get(0).equals("no_hom_affected*")
								|| data.get(i).get(0).equals("no_het_affected*")
								|| data.get(i).get(0).equals("no_wt_affected*")
								|| data.get(i).get(0).equals("no_hom_unaffected*")
								|| data.get(i).get(0).equals("no_het_unaffected*")
								|| data.get(i).get(0).equals("no_wt_unaffected*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut1*")
								|| data.get(i).get(0).equals("num_fam_with_segregation1*")
								|| data.get(i).get(0).equals("points_segregation1*")
								|| data.get(i).get(0).equals("points_frequency_controls1*")
								|| data.get(i).get(0).equals("points_CADD_score1*")
								|| data.get(i).get(0).equals("points_functional_studies1*")
								|| data.get(i).get(0).equals("final_score1*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut2*")
								|| data.get(i).get(0).equals("num_index_pat_het_mut2*")
								|| data.get(i).get(0).equals("num_fam_with_segregation2*")
								|| data.get(i).get(0).equals("functional_studies2*")
								|| data.get(i).get(0).equals("points_segregation2*")
								|| data.get(i).get(0).equals("points_frequency_controls2*")
								|| data.get(i).get(0).equals("points_CADD_score2*")
								|| data.get(i).get(0).equals("points_functional_studies2*")
								|| data.get(i).get(0).equals("final_score2*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut3*")
								|| data.get(i).get(0).equals("num_index_pat_het_mut3*")
								|| data.get(i).get(0).equals("num_fam_with_segregation3*")
								|| data.get(i).get(0).equals("CADD_score3*")
								|| data.get(i).get(0).equals("functional_studies3*")
								|| data.get(i).get(0).equals("points_segregation3*")
								|| data.get(i).get(0).equals("points_frequency_controls3*")
								|| data.get(i).get(0).equals("points_CADD_score3*")
								|| data.get(i).get(0).equals("points_functional_studies3*")
								|| data.get(i).get(0).equals("final_score3*")
								|| data.get(i).get(0).equals("CADD_score2*")
								|| data.get(i).get(0).equals("CADD_score1*")
								|| data.get(i).get(0).equals("mds_updrs_comb*")
								|| data.get(i).get(0).equals("updrs_comb*")
								|| data.get(i).get(0).equals("age_at_last_contact*")
								|| data.get(i).get(0).equals("year_of_last_contact*")){
							listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Integer.parseInt(s))
									.collect(Collectors.toList());
							Collections.sort(listOfIntegerNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						mapOfOptions.get(data.get(i).get(0)).add("n.a.");
					}
//					if (mapOfOptions.get(data.get(i).get(0)).contains("n.g.")){
//						mapOfOptions.get(data.get(i).get(0)).remove("n.g.");
//						List<Float> listOfFloatNumbers;
//						List<Integer> listOfIntegerNumbers;
//						if (data.get(i).get(0).equals("hy_stage_comb*")){
//							listOfFloatNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
//									.map(s -> Float.parseFloat(s))
//									.collect(Collectors.toList());
//							Collections.sort(listOfFloatNumbers);
//							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfFloatNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
//						}
//						else if (data.get(i).get(0).equals("age_at_onset*")
//								|| data.get(i).get(0).equals("age_at_exam*")
//								|| data.get(i).get(0).equals("no_hom_affected*")
//								|| data.get(i).get(0).equals("no_het_affected*")
//								|| data.get(i).get(0).equals("no_wt_affected*")
//								|| data.get(i).get(0).equals("no_hom_unaffected*")
//								|| data.get(i).get(0).equals("no_het_unaffected*")
//								|| data.get(i).get(0).equals("no_wt_unaffected*")
//								|| data.get(i).get(0).equals("num_index_pat_two_mut1*")
//								|| data.get(i).get(0).equals("num_fam_with_segregation1*")
//								|| data.get(i).get(0).equals("points_segregation1*")
//								|| data.get(i).get(0).equals("points_frequency_controls1*")
//								|| data.get(i).get(0).equals("points_CADD_score1*")
//								|| data.get(i).get(0).equals("points_functional_studies1*")
//								|| data.get(i).get(0).equals("final_score1*")
//								|| data.get(i).get(0).equals("num_index_pat_two_mut2*")
//								|| data.get(i).get(0).equals("num_index_pat_het_mut2*")
//								|| data.get(i).get(0).equals("num_fam_with_segregation2*")
//								|| data.get(i).get(0).equals("functional_studies2*")
//								|| data.get(i).get(0).equals("points_segregation2*")
//								|| data.get(i).get(0).equals("points_frequency_controls2*")
//								|| data.get(i).get(0).equals("points_CADD_score2*")
//								|| data.get(i).get(0).equals("points_functional_studies2*")
//								|| data.get(i).get(0).equals("final_score2*")
//								|| data.get(i).get(0).equals("num_index_pat_two_mut3*")
//								|| data.get(i).get(0).equals("num_index_pat_het_mut3*")
//								|| data.get(i).get(0).equals("num_fam_with_segregation3*")
//								|| data.get(i).get(0).equals("CADD_score3*")
//								|| data.get(i).get(0).equals("functional_studies3*")
//								|| data.get(i).get(0).equals("points_segregation3*")
//								|| data.get(i).get(0).equals("points_frequency_controls3*")
//								|| data.get(i).get(0).equals("points_CADD_score3*")
//								|| data.get(i).get(0).equals("points_functional_studies3*")
//								|| data.get(i).get(0).equals("final_score3*")
//								|| data.get(i).get(0).equals("CADD_score2*")
//								|| data.get(i).get(0).equals("CADD_score1*")
//								|| data.get(i).get(0).equals("mds_updrs_comb*")
//								|| data.get(i).get(0).equals("updrs_comb*")
//								|| data.get(i).get(0).equals("age_at_last_contact*")
//								|| data.get(i).get(0).equals("year_of_last_contact*")){
//							listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
//									.map(s -> Integer.parseInt(s))
//									.collect(Collectors.toList());
//							Collections.sort(listOfIntegerNumbers);
//							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
//						}
//						mapOfOptions.get(data.get(i).get(0)).add("n.g.");
//					}
					if (mapOfOptions.get(data.get(i).get(0)).contains("n/a")){
						mapOfOptions.get(data.get(i).get(0)).remove("n/a");
						List<Float> listOfFloatNumbers;
						List<Integer> listOfIntegerNumbers;
						if (data.get(i).get(0).equals("hy_stage_comb*")){
							listOfFloatNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Float.parseFloat(s))
									.collect(Collectors.toList());
							Collections.sort(listOfFloatNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfFloatNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						else if (data.get(i).get(0).equals("age_at_onset*")
								|| data.get(i).get(0).equals("age_at_exam*")
								|| data.get(i).get(0).equals("no_hom_affected*")
								|| data.get(i).get(0).equals("no_het_affected*")
								|| data.get(i).get(0).equals("no_wt_affected*")
								|| data.get(i).get(0).equals("no_hom_unaffected*")
								|| data.get(i).get(0).equals("no_het_unaffected*")
								|| data.get(i).get(0).equals("no_wt_unaffected*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut1*")
								|| data.get(i).get(0).equals("num_fam_with_segregation1*")
								|| data.get(i).get(0).equals("points_segregation1*")
								|| data.get(i).get(0).equals("points_frequency_controls1*")
								|| data.get(i).get(0).equals("points_CADD_score1*")
								|| data.get(i).get(0).equals("points_functional_studies1*")
								|| data.get(i).get(0).equals("final_score1*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut2*")
								|| data.get(i).get(0).equals("num_index_pat_het_mut2*")
								|| data.get(i).get(0).equals("num_fam_with_segregation2*")
								|| data.get(i).get(0).equals("functional_studies2*")
								|| data.get(i).get(0).equals("points_segregation2*")
								|| data.get(i).get(0).equals("points_frequency_controls2*")
								|| data.get(i).get(0).equals("points_CADD_score2*")
								|| data.get(i).get(0).equals("points_functional_studies2*")
								|| data.get(i).get(0).equals("final_score2*")
								|| data.get(i).get(0).equals("num_index_pat_two_mut3*")
								|| data.get(i).get(0).equals("num_index_pat_het_mut3*")
								|| data.get(i).get(0).equals("num_fam_with_segregation3*")
								|| data.get(i).get(0).equals("CADD_score3*")
								|| data.get(i).get(0).equals("functional_studies3*")
								|| data.get(i).get(0).equals("points_segregation3*")
								|| data.get(i).get(0).equals("points_frequency_controls3*")
								|| data.get(i).get(0).equals("points_CADD_score3*")
								|| data.get(i).get(0).equals("points_functional_studies3*")
								|| data.get(i).get(0).equals("final_score3*")
								|| data.get(i).get(0).equals("CADD_score2*")
								|| data.get(i).get(0).equals("CADD_score1*")
								|| data.get(i).get(0).equals("mds_updrs_comb*")
								|| data.get(i).get(0).equals("updrs_comb*")
								|| data.get(i).get(0).equals("age_at_last_contact*")
								|| data.get(i).get(0).equals("year_of_last_contact*")){
							listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Integer.parseInt(s))
									.collect(Collectors.toList());
							Collections.sort(listOfIntegerNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						mapOfOptions.get(data.get(i).get(0)).add("n/a");
					}
					if (mapOfOptions.get(data.get(i).get(0)).contains("na")){
						mapOfOptions.get(data.get(i).get(0)).remove("na");
						List<Float> listOfFloatNumbers;
						if (data.get(i).get(0).equals("CADD_score1*")
								|| data.get(i).get(0).equals("points_CADD_score1*")
								|| data.get(i).get(0).equals("CADD_score2*")
								|| data.get(i).get(0).equals("CADD_score3*")
								|| data.get(i).get(0).equals("points_CADD_score2*")
								|| data.get(i).get(0).equals("points_CADD_score3*")
								|| data.get(i).get(0).equals("mds_updrs_comb*")
								|| data.get(i).get(0).equals("updrs_comb*")
								|| data.get(i).get(0).equals("final_score3*")
								|| data.get(i).get(0).equals("final_score2*")
								|| data.get(i).get(0).equals("final_score1*")){
							listOfFloatNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
									.map(s -> Float.parseFloat(s))
									.collect(Collectors.toList());
							Collections.sort(listOfFloatNumbers);
							mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfFloatNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						}
						mapOfOptions.get(data.get(i).get(0)).add("na");
					}
					//As there are uncommon elements, some columns need special treatment like these 3 below
					if (data.get(i).get(0).equals("consumption_of_caffeine*")){
						List<Integer> listOfIntegerNumbers;
						mapOfOptions.get(data.get(i).get(0)).remove("n/a");
						mapOfOptions.get(data.get(i).get(0)).remove("yes");
						mapOfOptions.get(data.get(i).get(0)).remove("no");
						mapOfOptions.get(data.get(i).get(0)).remove("n.a.");
						listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
								.map(s -> Integer.parseInt(s))
								.collect(Collectors.toList());
						Collections.sort(listOfIntegerNumbers);
						mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						mapOfOptions.get(data.get(i).get(0)).add("yes");
						mapOfOptions.get(data.get(i).get(0)).add("no");
						mapOfOptions.get(data.get(i).get(0)).add("n/a");
						mapOfOptions.get(data.get(i).get(0)).add("n.a.");
					}
					if (data.get(i).get(0).equals("num_index_pat_het_mut1*")){
						List<Integer> listOfIntegerNumbers;
						mapOfOptions.get(data.get(i).get(0)).remove("7+");
						mapOfOptions.get(data.get(i).get(0)).remove("n.a.");
						listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
								.map(s -> Integer.parseInt(s))
								.collect(Collectors.toList());
						Collections.sort(listOfIntegerNumbers);
						mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						mapOfOptions.get(data.get(i).get(0)).add("7+");
						mapOfOptions.get(data.get(i).get(0)).add("n.a.");
					}
					if (data.get(i).get(0).equals("functional_studies1*")){
						List<Integer> listOfIntegerNumbers;
						mapOfOptions.get(data.get(i).get(0)).remove(">20");
						mapOfOptions.get(data.get(i).get(0)).remove("n.a.");
						listOfIntegerNumbers = mapOfOptions.get(data.get(i).get(0)).stream()
								.map(s -> Integer.parseInt(s))
								.collect(Collectors.toList());
						Collections.sort(listOfIntegerNumbers);
						mapOfOptions.put(data.get(i).get(0), (ArrayList<String>) listOfIntegerNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
						mapOfOptions.get(data.get(i).get(0)).add(">20");
						mapOfOptions.get(data.get(i).get(0)).add("n.a.");
					}
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
					for (int i = 0; i < overview.getWholeData().size(); i++) {
						if (overview.getWholeData().get(i).get(0).equals(entry.getKey())) {
							for (int j = 0; j < overview.getWholeData().get(i).size(); j++) {
								if (entry.getValue().contains(overview.getWholeData().get(i).get(j))) {
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

				data.clear();

				//filtering with indexes
				for (int i = 0; i < overview.getWholeData().size(); i++) {
					List<String> list = new ArrayList<>();
					list.add(overview.getWholeData().get(i).get(0));
					for (int j = 0; j < filteredIndexes.size(); j++) {
						list.add(overview.getWholeData().get(i).get(filteredIndexes.get(j)));
					}
					data.add(list);
				}
			}
			//this is done with cities
//				if (overview.isStepThreeFile){
//					List<CityCoordinate> listOfCoordinates = new ArrayList<>();
//					listOfCoordinates.add(new CityCoordinate("Antwerp", 51.219448, 4.402464, 1, popupBuilder("Antwerp", data)));
//					listOfCoordinates.add(new CityCoordinate("Athens", 37.983810, 23.727539, 2, popupBuilder("Athens", data)));
//					listOfCoordinates.add(new CityCoordinate("Bangkok", 13.743719, 100.516722, 3, popupBuilder("Bangkok", data)));
//					listOfCoordinates.add(new CityCoordinate("Barcelona", 41.386298, 2.178075, 4, popupBuilder("Barcelona", data)));
//					listOfCoordinates.add(new CityCoordinate("Belgrade", 44.786568, 20.448921, 5, popupBuilder("Belgrade", data)));
//					listOfCoordinates.add(new CityCoordinate("Berlin", 52.520008, 13.404954, 6, popupBuilder("Berlin", data)));
//					listOfCoordinates.add(new CityCoordinate("Brisbane", -27.493063, 153.037457, 7, popupBuilder("Brisbane", data)));
//					listOfCoordinates.add(new CityCoordinate("Buenos Aires1", -34.600544756278154, -58.45115332332391, 8, popupBuilder("Buenos Aires1", data)));
//					listOfCoordinates.add(new CityCoordinate("Buenos Aires2", -34.734388873916025, -58.76896246751697, 9, popupBuilder("Buenos Aires2", data)));
//					listOfCoordinates.add(new CityCoordinate("Bunkyo", 35.72253140378528, 139.75139117801672, 10, popupBuilder("Bunkyo", data)));
//					listOfCoordinates.add(new CityCoordinate("Cambridge", 52.1994208, 0.1194821, 11, popupBuilder("Cambridge", data)));
//					listOfCoordinates.add(new CityCoordinate("Cape Town", -33.7611168,17.9114754, 12, popupBuilder("Cape Town", data)));
//					listOfCoordinates.add(new CityCoordinate("Cosenza", 39.31010782867239, 16.250248159456167, 13, popupBuilder("Cosenza", data)));
//					listOfCoordinates.add(new CityCoordinate("Dundee", 56.4746755,-3.0368727, 14, popupBuilder("Dundee", data)));
//					listOfCoordinates.add(new CityCoordinate("Edmonton", 53.5558749,-113.772901, 15, popupBuilder("Edmonton", data)));
//					listOfCoordinates.add(new CityCoordinate("Hangzhou", 30.281947692628236, 120.15534568385083, 16, popupBuilder("Hangzhou", data)));
//					listOfCoordinates.add(new CityCoordinate("Houston", 29.79543329251191, -95.34777226904994, 17, popupBuilder("Houston", data)));
//					listOfCoordinates.add(new CityCoordinate("Istanbul1", 41.0055005,28.7319939, 18, popupBuilder("Istanbul1", data)));
//					listOfCoordinates.add(new CityCoordinate("Istanbul2", 41.02322285500102, 29.479333217022702, 19, popupBuilder("Istanbul2", data)));
//					listOfCoordinates.add(new CityCoordinate("Jerusalem", 31.77369039584099, 35.177965162417635, 20, popupBuilder("Jerusalem", data)));
//					listOfCoordinates.add(new CityCoordinate("Kiel", 54.3419319,9.9855945, 21, popupBuilder("Kiel", data)));
//					listOfCoordinates.add(new CityCoordinate("Kosice", 48.7231563619855, 21.24193146450945, 22, popupBuilder("Kosice", data)));
//					listOfCoordinates.add(new CityCoordinate("Kuala Lumpur",3.138675,101.616949, 23, popupBuilder("Kuala Lumpur", data)));
//					listOfCoordinates.add(new CityCoordinate("Lima", -11.968694959677945, -77.04802956843798, 24, popupBuilder("Lima", data)));
//					listOfCoordinates.add(new CityCoordinate("Lisboa", 38.7437396,-9.2302433, 25, popupBuilder("Lisboa", data)));
//					listOfCoordinates.add(new CityCoordinate("Lübeck", 53.8811215,10.621293, 26, popupBuilder("Lübeck", data)));
//					listOfCoordinates.add(new CityCoordinate("Lund", 55.7068782,13.1279565, 27, popupBuilder("Lund", data)));
//					listOfCoordinates.add(new CityCoordinate("Montevideo", -34.818190583807784, -56.18158448636666, 28, popupBuilder("Montevideo", data)));
//					listOfCoordinates.add(new CityCoordinate("Monza", 45.579717,9.2409673, 29, popupBuilder("Monza", data)));
//					listOfCoordinates.add(new CityCoordinate("Moscow", 55.7434214169504, 37.55845943183355, 30, popupBuilder("Moscow", data)));
//					listOfCoordinates.add(new CityCoordinate("Naples", 40.8938999090721, 14.187822277864036, 31, popupBuilder("Naples", data)));
//					listOfCoordinates.add(new CityCoordinate("New York City", 40.6976701,-74.2598667, 32, popupBuilder("New York City", data)));
//					listOfCoordinates.add(new CityCoordinate("Nijmegen", 51.8429473,5.7631171, 33, popupBuilder("Nijmegen", data)));
//					listOfCoordinates.add(new CityCoordinate("Oviedo", 43.36641964686802, -5.857287786547917, 34, popupBuilder("Oviedo", data)));
//					listOfCoordinates.add(new CityCoordinate("Paris", 48.8589507,2.2770202, 35, popupBuilder("Paris", data)));
//					listOfCoordinates.add(new CityCoordinate("Pavia", 45.09072095343176, 8.932580939272802, 36, popupBuilder("Pavia", data)));
//					listOfCoordinates.add(new CityCoordinate("Porto", 41.1622023,-8.6569731, 37, popupBuilder("Porto", data)));
//					listOfCoordinates.add(new CityCoordinate("Potchefstroom", -26.69519482051882, 27.05122702772967, 38, popupBuilder("Potchefstroom", data)));
//					listOfCoordinates.add(new CityCoordinate("Poznan", 52.4006553,16.7615831, 39, popupBuilder("Poznan", data)));
//					listOfCoordinates.add(new CityCoordinate("Pozzilli", 41.51216476188521, 14.059770861671048, 40, popupBuilder("Pozzilli", data)));
//					listOfCoordinates.add(new CityCoordinate("Rio de Janeiro1", -22.9132525,-43.7261722, 41, popupBuilder("Rio de Janeiro1", data)));
//					listOfCoordinates.add(new CityCoordinate("Rio de Janeiro2", -20.973120879978723, -43.318983904944716, 42, popupBuilder("Rio de Janeiro2", data)));
//					listOfCoordinates.add(new CityCoordinate("Riyadh", 24.76359492380717, 46.71537122628421, 43, popupBuilder("Riyadh", data)));
//					listOfCoordinates.add(new CityCoordinate("Rotterdam", 51.9280712,4.4207885, 44, popupBuilder("Rotterdam", data)));
//					listOfCoordinates.add(new CityCoordinate("Sao Paolo1", -22.5255001,-50.8797227, 45, popupBuilder("Sao Paolo1", data)));
//					listOfCoordinates.add(new CityCoordinate("Sao Paolo2", -23.001734400806537, -52.45209717989855, 46, popupBuilder("Sao Paolo2", data)));
//					listOfCoordinates.add(new CityCoordinate("Seville", 37.3754865,-6.0250983, 47, popupBuilder("Seville", data)));
//					listOfCoordinates.add(new CityCoordinate("Stockholm", 59.326242,17.8419708, 48, popupBuilder("Stockholm", data)));
//					listOfCoordinates.add(new CityCoordinate("Szeged", 46.232941,20.0003849, 49, popupBuilder("Szeged", data)));
//					listOfCoordinates.add(new CityCoordinate("Taipei", 25.090937150010564, 121.51891904785116, 50, popupBuilder("Taipei", data)));
//					listOfCoordinates.add(new CityCoordinate("Teipei", 24.938253227888207, 121.62119369688692, 51, popupBuilder("Teipei", data)));
//					listOfCoordinates.add(new CityCoordinate("Tel Aviv", 32.0880577,34.7272058, 52, popupBuilder("Tel Aviv", data)));
//					listOfCoordinates.add(new CityCoordinate("Toronto", 43.7184038,-79.518142, 53, popupBuilder("Toronto", data)));
//					listOfCoordinates.add(new CityCoordinate("Tórshavn", 62.0111156540375, -6.789202151578735, 54, popupBuilder("Tórshavn", data)));
//					listOfCoordinates.add(new CityCoordinate("Trondheim", 63.4187959,10.3687229, 55, popupBuilder("Trondheim", data)));
//					listOfCoordinates.add(new CityCoordinate("Tübingen", 48.5222366,8.9777436, 56, popupBuilder("Tübingen", data)));
//					listOfCoordinates.add(new CityCoordinate("Tunis", 36.826057708976535, 10.154009242756967, 57, popupBuilder("Tunis", data)));
//					listOfCoordinates.add(new CityCoordinate("Turku", 60.4321284,22.0841276, 58, popupBuilder("Turku", data)));
//					listOfCoordinates.add(new CityCoordinate("Varanasi", 25.329745600630513, 82.9832100025126, 59, popupBuilder("Varanasi", data)));
//					listOfCoordinates.add(new CityCoordinate("Vienna", 48.2208286,16.2399766, 60, popupBuilder("Vienna", data)));
//					listOfCoordinates.add(new CityCoordinate("Warsaw", 52.2330653,20.9211113, 61, popupBuilder("Warsaw", data)));
//
//					List <CityCoordinate> listOfFilteredCities = new ArrayList<>();
//					for (int i = 0; i < data.size(); i++){
//						if (data.get(i).get(0).equals("city*")){
//							for (int j = 0; j < listOfCoordinates.size(); j++){
//								for (int k = 1; k < data.get(i).size(); k++){
//									if (data.get(i).get(k).equals(listOfCoordinates.get(j).getName())){
//										listOfFilteredCities.add(listOfCoordinates.get(j));
//									}
//								}
//							}
//						}
//					}
//					List <Object[]> listOfCityObjects = new ArrayList<>();
//					for (CityCoordinate city : listOfFilteredCities){
//						listOfCityObjects.add(new Object[]{city.getName(), city.getLatitude(), city.getLongitude(), city.getIndex(), city.getInfoAboutCity()});
//					}
//
//					overview.setListOfCityObjects(listOfCityObjects);
//				}


//				this is done with institute names
				if (overview.isStepThreeFile){
					List<CityCoordinate> listOfCoordinates = new ArrayList<>();
					listOfCoordinates.add(new CityCoordinate("Antwerp University Hospital, University of Antwerp", 51.219448, 4.402464, 1, popupBuilder("Antwerp University Hospital, University of Antwerp", data)));
					listOfCoordinates.add(new CityCoordinate("National and Kapodistrian University of Athens", 37.983810, 23.727539, 2, popupBuilder("National and Kapodistrian University of Athens", data)));
					listOfCoordinates.add(new CityCoordinate("Ramathibodi Hospital, Mahidol University", 13.743719, 100.516722, 3, popupBuilder("Ramathibodi Hospital, Mahidol University", data)));
					listOfCoordinates.add(new CityCoordinate("Hospital de la Santa Creu i Sant Pau", 41.386298, 2.178075, 4, popupBuilder("Hospital de la Santa Creu i Sant Pau", data)));
					listOfCoordinates.add(new CityCoordinate("Neurology Clinic University Clinical Centre of Serbia, Belgrade", 44.786568, 20.448921, 5, popupBuilder("Neurology Clinic University Clinical Centre of Serbia, Belgrade", data)));
					listOfCoordinates.add(new CityCoordinate("Charite- Universitätsmedizin Berlin", 52.520008, 13.404954, 6, popupBuilder("Charite- Universitätsmedizin Berlin", data)));
					listOfCoordinates.add(new CityCoordinate("Griffith University", -27.493063, 153.037457, 7, popupBuilder("Griffith University", data)));
					listOfCoordinates.add(new CityCoordinate("Ineba", -34.600544756278154, -58.45115332332391, 8, popupBuilder("Ineba", data)));
					listOfCoordinates.add(new CityCoordinate("Fleni", -34.734388873916025, -58.76896246751697, 9, popupBuilder("Fleni", data)));
					listOfCoordinates.add(new CityCoordinate("Juntendo University", 35.72253140378528, 139.75139117801672, 10, popupBuilder("Juntendo University", data)));
					listOfCoordinates.add(new CityCoordinate("Cambridge Parkinson's Disease Research Clinic, John Van Geest Centre for Brain Repair, University of Cambridge", 52.1994208, 0.1194821, 11, popupBuilder("Cambridge Parkinson's Disease Research Clinic, John Van Geest Centre for Brain Repair, University of Cambridge", data)));
					listOfCoordinates.add(new CityCoordinate("Stellenbosch University, Cape Town, South Africa", -33.7611168,17.9114754, 12, popupBuilder("Stellenbosch University, Cape Town, South Africa", data)));
					listOfCoordinates.add(new CityCoordinate("IRIB-CNR", 39.31010782867239, 16.250248159456167, 13, popupBuilder("IRIB-CNR", data)));
					listOfCoordinates.add(new CityCoordinate("Ninewells Hospital and Medical School; University of Dundee", 56.4746755,-3.0368727, 14, popupBuilder("Ninewells Hospital and Medical School; University of Dundee", data)));
					listOfCoordinates.add(new CityCoordinate("University of Alberta, Edmonton Alberta", 53.5558749,-113.772901, 15, popupBuilder("University of Alberta, Edmonton Alberta", data)));
					listOfCoordinates.add(new CityCoordinate("Zhejiang University", 30.281947692628236, 120.15534568385083, 16, popupBuilder("Zhejiang University", data)));
					listOfCoordinates.add(new CityCoordinate("Baylor College of Medicine", 29.79543329251191, -95.34777226904994, 17, popupBuilder("Baylor College of Medicine", data)));
					listOfCoordinates.add(new CityCoordinate("Koc University, School of Medicine", 41.0055005,28.7319939, 18, popupBuilder("Koc University, School of Medicine", data)));
					listOfCoordinates.add(new CityCoordinate("Istanbul University", 41.02322285500102, 29.479333217022702, 19, popupBuilder("Istanbul University", data)));
					listOfCoordinates.add(new CityCoordinate("Hebrew University Hadassah Medical School", 31.77369039584099, 35.177965162417635, 20, popupBuilder("Hebrew University Hadassah Medical School", data)));
					listOfCoordinates.add(new CityCoordinate("Department of Neurology, Kiel University", 54.3419319,9.9855945, 21, popupBuilder("Department of Neurology, Kiel University", data)));
					listOfCoordinates.add(new CityCoordinate("P. J. Safarik University in Kosice", 48.7231563619855, 21.24193146450945, 22, popupBuilder("P. J. Safarik University in Kosice", data)));
					listOfCoordinates.add(new CityCoordinate("University of Malaya, Kuala Lumpur",3.138675,101.616949, 23, popupBuilder("University of Malaya, Kuala Lumpur", data)));
					listOfCoordinates.add(new CityCoordinate("Instituto Nacional de Ciencias Neurologicas ", -11.968694959677945, -77.04802956843798, 24, popupBuilder("Instituto Nacional de Ciencias Neurologicas ", data)));
					listOfCoordinates.add(new CityCoordinate("Instituto de Medicina Molecular Joao Lobo Antunes - Centro Academico Medicina de Lisboa (IMM-CAML)", 38.7437396,-9.2302433, 25, popupBuilder("Instituto de Medicina Molecular Joao Lobo Antunes - Centro Academico Medicina de Lisboa (IMM-CAML)", data)));
					listOfCoordinates.add(new CityCoordinate("University of Luebeck", 53.8811215,10.621293, 26, popupBuilder("University of Luebeck", data)));
					listOfCoordinates.add(new CityCoordinate("Lund University", 55.7068782,13.1279565, 27, popupBuilder("Lund University", data)));
					listOfCoordinates.add(new CityCoordinate("Universidad de la Republica Uruguay", -34.818190583807784, -56.18158448636666, 28, popupBuilder("Universidad de la Republica Uruguay", data)));
					listOfCoordinates.add(new CityCoordinate("Monza", 45.579717,9.2409673, 29, popupBuilder("Monza", data)));
					listOfCoordinates.add(new CityCoordinate("Research Center of Neurology", 55.7434214169504, 37.55845943183355, 30, popupBuilder("Research Center of Neurology", data)));
					listOfCoordinates.add(new CityCoordinate("Department of Neurosciences and Reproductive and Odontostomatological Sciences Federico II University", 40.8938999090721, 14.187822277864036, 31, popupBuilder("Department of Neurosciences and Reproductive and Odontostomatological Sciences Federico II University", data)));
					listOfCoordinates.add(new CityCoordinate("Columbia University", 40.6976701,-74.2598667, 32, popupBuilder("Columbia University", data)));
					listOfCoordinates.add(new CityCoordinate("Radboud University Medical Centre", 51.8429473,5.7631171, 33, popupBuilder("Radboud University Medical Centre", data)));
					listOfCoordinates.add(new CityCoordinate("Hospital Universitario Central de Asturias", 43.36641964686802, -5.857287786547917, 34, popupBuilder("Hospital Universitario Central de Asturias", data)));
					listOfCoordinates.add(new CityCoordinate("Pitié-Salpétrière Hospital - ICM", 48.8589507,2.2770202, 35, popupBuilder("Pitié-Salpétrière Hospital - ICM", data)));
					listOfCoordinates.add(new CityCoordinate("IRCCS Mondino Fondation", 45.09072095343176, 8.932580939272802, 36, popupBuilder("IRCCS Mondino Fondation", data)));
					listOfCoordinates.add(new CityCoordinate("Hospital de Santo Antonio (Centro Hospitalar do Porto)", 41.1622023,-8.6569731, 37, popupBuilder("Hospital de Santo Antonio (Centro Hospitalar do Porto)", data)));
					listOfCoordinates.add(new CityCoordinate("North-West University (South Africa)", -26.69519482051882, 27.05122702772967, 38, popupBuilder("North-West University (South Africa)", data)));
					listOfCoordinates.add(new CityCoordinate("Laboratory of Neurobiology, Department of Neurology, Poznan University of Medical Sciences", 52.4006553,16.7615831, 39, popupBuilder("Laboratory of Neurobiology, Department of Neurology, Poznan University of Medical Sciences", data)));
					listOfCoordinates.add(new CityCoordinate("IRCCS Neuromed Institute, INM", 41.51216476188521, 14.059770861671048, 40, popupBuilder("IRCCS Neuromed Institute, INM", data)));
					listOfCoordinates.add(new CityCoordinate("State University of Rio de Janeiro", -22.9132525,-43.7261722, 41, popupBuilder("State University of Rio de Janeiro", data)));
					listOfCoordinates.add(new CityCoordinate("State University of Rio de Janeiro (UERJ)", -20.973120879978723, -43.318983904944716, 42, popupBuilder("State University of Rio de Janeiro (UERJ)", data)));
					listOfCoordinates.add(new CityCoordinate("King Faisal Specialist Hospital", 24.76359492380717, 46.71537122628421, 43, popupBuilder("King Faisal Specialist Hospital", data)));
					listOfCoordinates.add(new CityCoordinate("Erasmus MC Rotterdam", 51.9280712,4.4207885, 44, popupBuilder("Erasmus MC Rotterdam", data)));
					listOfCoordinates.add(new CityCoordinate("Ribeirao Preto Medical School", -22.5255001,-50.8797227, 45, popupBuilder("Ribeirao Preto Medical School", data)));
					listOfCoordinates.add(new CityCoordinate("Hospital Israelita Albert Einstein and Universidade Federal de Sao Paulo", -23.001734400806537, -52.45209717989855, 46, popupBuilder("Hospital Israelita Albert Einstein and Universidade Federal de Sao Paulo", data)));
					listOfCoordinates.add(new CityCoordinate("Institute of Biomedicine of Seville (IBIS) - Movement Disorders Laboratory", 37.3754865,-6.0250983, 47, popupBuilder("Institute of Biomedicine of Seville (IBIS) - Movement Disorders Laboratory", data)));
					listOfCoordinates.add(new CityCoordinate("Karolinska Institutet", 59.326242,17.8419708, 48, popupBuilder("Karolinska Institutet", data)));
					listOfCoordinates.add(new CityCoordinate("University of Szeged", 46.232941,20.0003849, 49, popupBuilder("University of Szeged", data)));
					listOfCoordinates.add(new CityCoordinate("National Taiwan University Hospital; National Taiwan University College of Medicine", 25.090937150010564, 121.51891904785116, 50, popupBuilder("National Taiwan University Hospital; National Taiwan University College of Medicine", data)));
					listOfCoordinates.add(new CityCoordinate("National Taiwan University Hospital", 24.938253227888207, 121.62119369688692, 51, popupBuilder("National Taiwan University Hospital", data)));
					listOfCoordinates.add(new CityCoordinate("Tel Aviv Sourasky Medical Center", 32.0880577,34.7272058, 52, popupBuilder("Tel Aviv Sourasky Medical Center", data)));
					listOfCoordinates.add(new CityCoordinate("Toronto Western Hospital", 43.7184038,-79.518142, 53, popupBuilder("Toronto Western Hospital", data)));
					listOfCoordinates.add(new CityCoordinate("Faroe Islands", 62.0111156540375, -6.789202151578735, 54, popupBuilder("Faroe Islands", data)));
					listOfCoordinates.add(new CityCoordinate("Trondheim", 63.4187959,10.3687229, 55, popupBuilder("Trondheim", data)));
					listOfCoordinates.add(new CityCoordinate("University of Tuebingen", 48.5222366,8.9777436, 56, popupBuilder("University of Tuebingen", data)));
					listOfCoordinates.add(new CityCoordinate("Institut National Mongi Ben Hamida De Neurologie", 36.826057708976535, 10.154009242756967, 57, popupBuilder("Institut National Mongi Ben Hamida De Neurologie", data)));
					listOfCoordinates.add(new CityCoordinate("Department of Clinical Neurosciences, University of Turku and Neurocenter, Turku University Hospital, Turku", 60.4321284,22.0841276, 58, popupBuilder("Department of Clinical Neurosciences, University of Turku and Neurocenter, Turku University Hospital, Turku", data)));
					listOfCoordinates.add(new CityCoordinate("Banaras Hindu University", 25.329745600630513, 82.9832100025126, 59, popupBuilder("Banaras Hindu University", data)));
					listOfCoordinates.add(new CityCoordinate("Department of Neurology, Medical University Vienna", 48.2208286,16.2399766, 60, popupBuilder("Department of Neurology, Medical University Vienna", data)));
					listOfCoordinates.add(new CityCoordinate("Medical University in Warsaw", 52.2330653,20.9211113, 61, popupBuilder("Medical University in Warsaw", data)));

					List <CityCoordinate> listOfFilteredCities = new ArrayList<>();
					for (int i = 0; i < data.size(); i++){
//						if (data.get(i).get(0).equals("city*")){
						if (data.get(i).get(0).equals("name_of_the_site*")){
							for (int j = 0; j < listOfCoordinates.size(); j++){
								for (int k = 1; k < data.get(i).size(); k++){
									if (data.get(i).get(k).equals(listOfCoordinates.get(j).getName())){
										listOfFilteredCities.add(listOfCoordinates.get(j));
									}
								}
							}
						}
					}
					List <Object[]> listOfCityObjects = new ArrayList<>();
					for (CityCoordinate city : listOfFilteredCities){
						listOfCityObjects.add(new Object[]{city.getName(), city.getLatitude(), city.getLongitude(), city.getIndex(), city.getInfoAboutCity()});
					}

					overview.setListOfCityObjects(listOfCityObjects);
				}



		    // prepare data for output
	        int _page = page == null ? 1 : page;
		    for (List<String> list : data) {
		    	overview.setTotal_pages(list.size()/10);
		    	int size = list.size();
		    	String title = list.remove(0);
		    	overview.total_count = 0;
		    	list.removeIf(x -> { boolean a = (overview.total_count/10  != (_page - 1)); overview.total_count++; return _page != -1 && a; });
		    	list.replaceAll(x -> x == null ? "" : x);
		    	list.add(0, title);
		    	overview.total_count = size-1; //потому что мы должны не считать заголовок
		    }


	        overview.setStudies(data);

			overview.setTotal_pages((int)Math.ceil(((double)overview.total_count/10)));
			overview.current_page = _page;
			overview.limit_value = 3;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	private String добавитьФильтрАттрибутов(Integer fc1, String _filter, Overview overview) {
		if (fc1 != null) {
			return  _filter + "&fc1=" + fc1;
		}
		return _filter;
	}

	private String добавитьФильтрГенов(Integer fc2, String _filter, Overview overview) {
		if (fc2 != null) {
			return  _filter + "&fc2=" + fc2;
		}
		return _filter;
	}

	private String добавитьСтран(List<String> country, String _filter, Overview overview) {
		if (country != null && country.size() > 0) {
			return _filter + "&_country=1&country=" + StringUtils.join(country.toArray(new String[0]), "&country=");
		}
		return _filter;
	}

	private String добавитьМутацииКФилтру(List<String> mu, String _filter) {
		if (mu != null && mu.size() > 0) {
			_filter = _filter + "&_mu=1&mu=" + mu.stream().collect(Collectors.joining("&mu="));
		}
		return _filter;
	}

	@Override
	public void buildPaginationAppender(Overview overview, Integer fc, String aao, List<String> mut_restrict, List<String> country) {
    	try {
			overview.setPaginationAppender("");
			if (country != null) {
				overview.setPaginationAppender("&_country=1&country=" + StringUtils.join(country.toArray(new String[0]), "&country="));
			}
			if (mut_restrict != null) {
				overview.setPaginationAppender(overview.getPaginationAppender() + "&_mu=1&mu=" + StringUtils.join(mut_restrict.toArray(new String[0]), "&mu="));
			}
	 	    if (fc != null) {
	 	    	overview.setPaginationAppender(overview.getPaginationAppender() + "&fc=" + fc);
	 	    }
	 	    if (overview.getFc1() != null) {
	 	    	overview.setPaginationAppender(overview.getPaginationAppender() + "&fc1=" + overview.getFc1());
	 	    }
	 	    if (overview.getFc2() != null) {
	 	    	overview.setPaginationAppender(overview.getPaginationAppender() + "&fc2=" + overview.getFc2());
	 	    }
	 	    if (aao != null) {
					overview.setPaginationAppender(overview.getPaginationAppender() + "&aao=" + URLEncoder.encode(aao, "UTF-8"));
	 	    }
			if (overview.getSelectedValues() != null && !overview.getSelectedValues().isEmpty()) {
				String paginationAppender = overview.getPaginationAppender();
				for (String value : overview.getSelectedValues()) {
					paginationAppender = paginationAppender + "&selectedValues=" + value.replace("#", "%23");
				}
				overview.setPaginationAppender(paginationAppender);
			}
			if (overview.getFilterForAAE() != null && !overview.getFilterForAAE().isEmpty()){
				overview.setPaginationAppender(overview.getPaginationAppender() + "&filterForAAE=" + overview.getFilterForAAE());
			}
			if (overview.getAae() != null && !overview.getAae().isEmpty()){
				overview.setPaginationAppender(overview.getPaginationAppender() + "&aae=" + overview.getAae());
			}
			if (overview.getFilterForYLC() != null && !overview.getFilterForYLC().isEmpty()){
				overview.setPaginationAppender(overview.getPaginationAppender() + "&filterForYLC=" + overview.getFilterForYLC());
			}
			if (overview.getYlc() != null && !overview.getYlc().isEmpty()){
				overview.setPaginationAppender(overview.getPaginationAppender() + "&ylc=" + overview.getYlc());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

}
