package net.mdsgene.admin.controllers;

import net.mdsgene.admin.controllers.StudiesController.Charts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChartsData implements IChartsData {
	public static String UNPUBLISHED_DATA_URL = "127.0.0.1:59177";
	public static String SIZE_VERSION = "127.0.0.1:59177";
	List<?> _data;
	public List<String> selectedValues = new ArrayList<>();
	public String filterForAAE = "";
	public String aae = "";

	RestTemplate restTemplate = new RestTemplate();
	
	public static class ПараметрыФильтра {
		Integer fc;
		Integer fc1;
		String aao;
		private List<String> country;
		
		public ПараметрыФильтра(Integer fc, Integer fc1, String aao, List<String> country) {
			this.fc = fc;
			this.fc1 = fc1;
			this.aao = aao;
			this.country = country;
		}
		
		public String добавить(String _filter) {
			if (fc1 != null && !_filter.contains("fc1")) {
				_filter += "&fc1=" + fc1;
			}
			if (!StringUtils.isBlank(aao) && !_filter.contains("aao")) {
				_filter += "&aao=" + aao;
			}
			if (country != null && country.size() > 0) {
				_filter += "&_country=1&country=" + StringUtils.join(country.toArray(new String[0]), "&country=");
			}

			return _filter;
		}
		
	    boolean все_значения() {
	    	boolean первый_фильтр = (fc == null || fc == 0);
	    	boolean второй_фильтр = (fc1 == null || fc1 == 0);
	    	boolean фильтр_стран = (country == null || country.size() == 0);
			return первый_фильтр && второй_фильтр && фильтр_стран;	    	
	    }

		public String составить_фильтр() {
			 StringBuilder sb = new StringBuilder();
	    	 boolean первый_фильтр_все = (fc == null || fc == 0);
	    	 if (!первый_фильтр_все) {
	    		 String название_первого_фильтра = "";
	    		 if (fc == 1) sb.append("(filter: AAO < " + aao + ") "); 
	    		 if (fc == 2) sb.append("(filter: AAO >= " + aao + ") "); 
	    		 if (fc == 3) sb.append("(filter: females only) "); 
	    		 if (fc == 4) sb.append("(filter: males only) "); 
	    		 if (fc == 5) sb.append("(filter: biallelic only) "); 
	    		 if (fc == 6) sb.append("(filter: monoallelic only) "); 
	    	 }
			 
  	    	 boolean второй_фильтр_все = (fc1 == null || fc1 == 0);
	    	 if (!второй_фильтр_все) {
	    		 if (fc1 == 1) sb.append("(Genes: LRRK2) ");
	    		 if (fc1 == 2) sb.append("(Genes: SNCA) ");
	    		 if (fc1 == 3) sb.append("(Genes: VPS35) ");
	    		 if (fc1 == 4) sb.append("(Genes: PINK1) ");
	    		 if (fc1 == 5) sb.append("(Genes: Parkin) ");
	    		 if (fc1 == 6) sb.append("(Genes: DJ1) ");
	    		 if (fc1 == 7) sb.append("(Genes: GBA) ");
	    		 if (fc1 == 8) sb.append("(Genes оther thаn: LRRK2, SNCA, VPS35, PINK1, Parkin, DJ1 and GBA ) ");
	    	 }
	    	 
	    	 boolean фильтр_стран_все = (country == null || country.size() == 0);
	    	 if (!фильтр_стран_все) {
	    		 sb.append("Country of origin: (" + 
	    				 	   StudiesController.all_countries().entrySet().stream().filter((v) -> country.contains(v.getValue())).map(v -> v.getKey()).collect(Collectors.joining(",")) +
	    				 	") ");
	    	 }
			return sb.toString();
		}

	}
	
	@Override
	public void readRepeatsCount(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		_filter = параметры_фильтра.добавить(_filter);
		if(selectedValues != null && !selectedValues.isEmpty()){
			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}

        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=4"+_filter, List.class);
        charts.setLstRepeatsCount(_data);
	}

	@Override
	public void readAAOCount(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		_filter = параметры_фильтра.добавить(_filter);
		if(selectedValues != null && !selectedValues.isEmpty()){
			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}
        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=5"+_filter, List.class);
        charts.setLstAAOCount(_data);
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readRace(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean healthies, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstRace(читать_данные_для_графика(параметры_фильтра, healthies ? -6 : 6, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readEthnicity(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean healthies, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstEthnicity(читать_данные_для_графика(параметры_фильтра,  healthies ? -7 : 7, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}	
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readAAO(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstAao(читать_данные_для_графика(параметры_фильтра, 5, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readDiagnosedWithPD(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstDiagnosedWithPD(читать_данные_для_графика(параметры_фильтра, 8, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readFamiltyHistory(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstFamilyHistory(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -9 : 9, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readDataAlreadyBeenPublished(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstDataAlreadyBeenPublished(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -10 : 10, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readAvailabilityOfClinicalScales(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstAvailabilityOfClinicalScales(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -11 : 11, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}

	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readAvailabilityOfOtherData(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstAvailabilityOfOtherData(читать_данные_для_графика(параметры_фильтра,  считывать_здоровых ? -12 : 12, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readAvailabilityOfBiospecimen(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstAvailabilityOfBiospecimen(читать_данные_для_графика(параметры_фильтра, 14, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readEthicsApproval(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstEthicsApproval(читать_данные_для_графика(параметры_фильтра, 15, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readSubjectsPerGene(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstSubjectsPerGene(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -17 : 17, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	@Override
	/**
	 * Читает содержимое гена, на основание предложенного фильтра
	 * @param charts - обект который будет содержать фильтер
	 * @param fc
	 * @param mutation
	 */
	public void readFrequencyOfMutations(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstFrequencyOfMutations(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -18 : 18, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}
	
	
	@Override
	public void readTypeOfMutation(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstTypeOfMutations(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -19 : 19, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}

	@Override
	public void readDigenicCases(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		charts.setLstDigenicCases(читать_данные_для_графика(параметры_фильтра, считывать_здоровых ? -20 : 20, mutations, selectedValues, filterForAAE, aae, filterForYLC, ylc));
	}

	/**
//	 * @param fc
//	 * @param mutations TODO
//	 * @param charts
	 * @return 
	 */
	private List<?> читать_данные_для_графика(ПараметрыФильтра параметры_фильтра, int номер_графика, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		Integer selected_gene_id = 0;
		Integer selected_disease_id = 0;
		int repeats = 0;
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		if (mutations != null && !mutations.isEmpty()) {
			_filter = _filter + "&_mu=1&mu=" + mutations.stream().collect(Collectors.joining("&mu="));
		}
		_filter = параметры_фильтра.добавить(_filter);
		if(selectedValues != null && !selectedValues.isEmpty()){
			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}
        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ ("/tfi1?todo=" + номер_графика)+_filter, List.class);
        //данная часть будет исправленна после соединения данных по рассе.
        return _data;
	}
	
//	/**
//	 * @param charts
//	 * @param fc
//	 * @return 
//	 */
//	private Map читать_данные_для_ввз_графика(ПараметрыФильтра параметры_фильтра, int номер_графика) {
//		Integer selected_gene_id = 0;
//		Integer selected_disease_id = 0;
//		int repeats = 0;
//		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
//		
//		List<?> list = restTemplate.getForObject("http://"
//        		+ UNPUBLISHED_DATA_URL
//        		+ ("/tfi1?todo=" + номер_графика)+_filter, List.class);
//        return null;
//	}
//	
	@Override
	public void readDYTorPARKatOneSet(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id,
                                      Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		if(selectedValues != null && !selectedValues.isEmpty()){
			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}
        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=1"+_filter, List.class);
        charts.setLstDYTorPARKatOneSet(_data);
	}

	@Override
	public void readBodyPartAffectedByDYT(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id,
                                          Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		if(selectedValues != null && !selectedValues.isEmpty()){

			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}
        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=3"+_filter, List.class);
        charts.setLstBodyPartAffectedByDYT(_data);
	}

	@Override
	public void readCranocervicalDystonia(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id,
                                          Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc) {
		String _filter = "&fc=" + (параметры_фильтра.fc == null ? 0 : параметры_фильтра.fc) + "&repeats=" + repeats + "&fn=" + selected_gene_id;
		if(selectedValues != null && !selectedValues.isEmpty()){
			for (String value : selectedValues){
				_filter = _filter + "&selectedValues=" + value.replace("#", "%23");
			}
		}
		if(filterForAAE != null && !filterForAAE.isEmpty()){
			_filter = _filter + "&filterForAAE=" + filterForAAE;
		}
		if (aae != null && !aae.isEmpty()){
			_filter = _filter + "&aae=" + aae;
		}
		if(filterForYLC != null && !filterForYLC.isEmpty()){
			_filter = _filter + "&filterForYLC=" + filterForYLC;
		}
		if (ylc != null && !ylc.isEmpty()){
			_filter = _filter + "&ylc=" + ylc;
		}
        _data = restTemplate.getForObject("http://"
        		+ UNPUBLISHED_DATA_URL
        		+ "/tfi1?todo=2"+_filter, List.class);
        charts.setLstCranocervicalDystonia(_data);
	}


}
