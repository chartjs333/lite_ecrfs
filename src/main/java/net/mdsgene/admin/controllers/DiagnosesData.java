//package net.mdsgene.admin.controllers;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.ImmutableTriple;
//import org.thymeleaf.util.StringUtils;
//
//import net.mdsgene.admin.admintool.business.CommonFunctionsHelper;
//import net.mdsgene.admin.admintool.dal.IDiseaseDAO;
//import net.mdsgene.admin.admintool.dal.IGeneAliasDAO;
//import net.mdsgene.admin.admintool.dal.IGeneDAO;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.dal.IStudyDAO;
//import net.mdsgene.admin.admintool.dal.ISymptomDAO;
//import net.mdsgene.admin.admintool.dal.ISystematicReviewDAO;
//import net.mdsgene.admin.admintool.entities.Patient;
//import net.mdsgene.admin.tags.ArrayLinksTag;
//import net.mdsgene.admin.tags.LinkToTag;
//
//public class DiagnosesData extends UnpublishedData {
//	int INACCURACY_OF_AAO = 5;
//	private CrossroadController crc;
//	private String _possible_diagnoses;
//	private String _impossible_diagnoses;
//	private CommonFunctionsHelper cfh;
//
//	public class PossibleDiagnosesView {
//		LinkToTag diagnosis;
//		Integer n_cases;
//		ImmutableTriple<String, String, String> aao;
//		ArrayLinksTag<LinkToTag> ss_selected_and_previously_reported;
//		ArrayLinksTag<LinkToTag> ss_previously_reported_but_not_selected;
//		ArrayLinksTag<LinkToTag> ss_selected_but_not_previously_reported;
//		ArrayLinksTag<LinkToTag> reported_mutations;
//
//		public LinkToTag getDiagnosis() {
//			return diagnosis;
//		}
//		public Integer getN_cases() {
//			return n_cases;
//		}
//		public ImmutableTriple<String, String, String> getAao() {
//			return aao;
//		}
//		public ArrayLinksTag<LinkToTag> getSs_selected_and_previously_reported() {
//			return ss_selected_and_previously_reported;
//		}
//		public ArrayLinksTag<LinkToTag> getSs_previously_reported_but_not_selected() {
//			return ss_previously_reported_but_not_selected;
//		}
//		public ArrayLinksTag<LinkToTag> getSs_selected_but_not_previously_reported() {
//			return ss_selected_but_not_previously_reported;
//		}
//		public ArrayLinksTag<LinkToTag> getReported_mutations() {
//			return reported_mutations;
//		}
//	}
//
//	public DiagnosesData(CrossroadController crc, List<Integer> selectedSymptomsIds, Integer aao, CommonFunctionsHelper cfh) {
//		this.crc = crc;
//		this.cfh = cfh;
//		String selected_symptoms_ids = selectedSymptomsIds.stream().map(x -> x.toString())
//				.collect(Collectors.joining(","));
//		String __raw_pd = cfh.replaceAll("SELECT COUNT(DISTINCT patients.id) AS nof_patients, ARRAY_AGG(DISTINCT patients.id) AS who, (ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) "
//				+ "&& ARRAY[__selected_symptoms_ids__]) AS sympt_intersect, MIN(patients.age_at_onset) as min_aao, MAX(patients.age_at_onset) as max_aao, "
//				+ "diseases.id AS di_id, diseases.abbreviation AS di_name, genes.id AS ge_id, genes.name AS ge_name, "
//				+ "ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) AS sym_ids " + "FROM \"patients\" "
//				+ "INNER JOIN \"diseases\" ON \"diseases\".\"id\" = \"patients\".\"disease_id\" "
//				+ "INNER JOIN \"sequence_variations\" ON \"sequence_variations\".\"patient_id\" = \"patients\".\"id\" "
//				+ "INNER JOIN \"genes\" ON \"genes\".\"id\" = \"sequence_variations\".\"gene_id\" "
//				+ "INNER JOIN \"patients_symptoms\" ON \"patients_symptoms\".\"patient_id\" = \"patients\".\"id\" "
//				+ "WHERE (\"patients\".\"status_clinical\" != 3) AND \"diseases\".\"launched\" = true AND \"patients_symptoms\".\"present\" = true AND "
//				+ "(\"sequence_variations\".\"pathogenicity\" != 1) "
//				+ "GROUP BY genes.id, diseases.id HAVING (ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) && ARRAY[__selected_symptoms_ids__])"
//						,"__selected_symptoms_ids__", selected_symptoms_ids);
//		String _aao_ordering = "(" + aao + " BETWEEN (COALESCE(min_aao,0)-" + INACCURACY_OF_AAO
//				+ ") AND (COALESCE(max_aao,150)+" + INACCURACY_OF_AAO + ")) DESC NULLS LAST, ";
//		_possible_diagnoses = cfh.replaceAll(cfh.replaceAll(cfh.replaceAll("SELECT nof_patients, cast (who as text), min_aao, max_aao, cast (intersec as text), cast (rcot_patient as text), cast (rcot_database as text), di_id, di_name, ge_id, ge_name "
//				+ "FROM (SELECT us.nof_patients, us.who, us.min_aao, us.max_aao, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(us.sym_ids) "
//				+ "INTERSECT SELECT UNNEST(ARRAY[__selected_symptoms_ids__])) t (elem)) AS intersec, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(us.sym_ids) "
//				+ "EXCEPT SELECT UNNEST(ARRAY[__selected_symptoms_ids__])) t (elem)) AS rcot_patient, (SELECT ARRAY_AGG(elem) FROM (SELECT UNNEST(ARRAY[__selected_symptoms_ids__]) "
//				+ "EXCEPT SELECT UNNEST(us.sym_ids)) t (elem)) AS rcot_database, us.di_id, us.di_name, us.ge_id, us.ge_name FROM (__raw_pd__) us) g "
//				+ "ORDER BY __aao_ordering__ CAST((SELECT COUNT(patients_symptoms.*) FROM patients_symptoms "
//				+ "WHERE patients_symptoms.present = 'true' AND patients_symptoms.symptom_id IN (SELECT UNNEST(g.intersec)) AND patients_symptoms.patient_id "
//				+ "IN (SELECT UNNEST(g.who))) AS float)/CAST(nof_patients AS float) DESC, ARRAY_LENGTH(intersec,1) DESC, ARRAY_LENGTH(rcot_patient,1) ASC, "
//				+ "ARRAY_LENGTH(rcot_database,1) ASC","__selected_symptoms_ids__", selected_symptoms_ids)
//						,"__raw_pd__", __raw_pd),"__aao_ordering__", _aao_ordering);
//		_impossible_diagnoses = cfh.replaceAll("SELECT diseases.id AS di_id, diseases.abbreviation AS di_name, genes.id AS ge_id, genes.name AS ge_name FROM \"patients\" "
//				+ "INNER JOIN \"diseases\" ON \"diseases\".\"id\" = \"patients\".\"disease_id\" "
//				+ "INNER JOIN \"sequence_variations\" ON \"sequence_variations\".\"patient_id\" = \"patients\".\"id\" "
//				+ "INNER JOIN \"genes\" ON \"genes\".\"id\" = \"sequence_variations\".\"gene_id\" "
//				+ "INNER JOIN \"patients_symptoms\" ON \"patients_symptoms\".\"patient_id\" = \"patients\".\"id\" "
//				+ "WHERE (\"patients\".\"status_clinical\" != 3) AND \"diseases\".\"launched\" = true AND \"patients_symptoms\".\"present\" = true AND (\"sequence_variations\".\"pathogenicity\" != 1) "
//				+ "GROUP BY genes.id, diseases.id HAVING (NOT (ARRAY_AGG(DISTINCT patients_symptoms.symptom_id) && ARRAY[__selected_symptoms_ids__]))"
//						,"__selected_symptoms_ids__", selected_symptoms_ids);
//
//
//	}
//
//	public List<PossibleDiagnosesView> possible_diagnoses() {
//		List<PossibleDiagnosesView> _result = new ArrayList<>();
//		Query query = crc.em.createNativeQuery(_possible_diagnoses);
//		List<Object[]> _t = query.getResultList();
//
//		_t.stream().forEach(x -> {
//			PossibleDiagnosesView viewLine = new PossibleDiagnosesView();
//			viewLine.diagnosis = new LinkToTag().body(((String)x[8]) + "-" + (String)x[10]).href("d/" + x[7] + "/g/" + x[9]);
//			viewLine.n_cases = ((BigInteger) x[0]).intValue();
//			DecimalFormat df = new DecimalFormat("0.00##");
//			ImmutableTriple<Double, BigDecimal, BigDecimal> aao = ImmutableTriple.of(s2a((String)x[1]).stream().
//					map(x1 -> crc.patientDAO.findOne(Integer.valueOf(x1)).getAgeAtOnset()).filter(x1 -> x1 != null).collect(
//					Collectors.averagingDouble(x1 -> {return x1.doubleValue();})),
//					(BigDecimal)x[2], (BigDecimal)x[3]);
//			viewLine.aao = ImmutableTriple.of(aao.left > 0 ? df.format(aao.left) : "", aao.middle != null ? df.format(aao.middle.doubleValue()) : "",
//																   aao.right != null ? df.format(aao.right.doubleValue()) : "");
//			Integer d_id = ((Integer) x[7]).intValue();
//			Integer g_id = ((Integer) x[9]).intValue();
//			Integer total = ((BigInteger) x[0]).intValue();
//			viewLine.ss_selected_and_previously_reported = diagnosis_sympt_persentage(s2a((String)x[4]), d_id, g_id, total);
//			viewLine.ss_previously_reported_but_not_selected = diagnosis_sympt_persentage(s2a((String)x[5]), d_id, g_id, total);
//			viewLine.ss_selected_but_not_previously_reported = diagnosis_sympt_persentage(s2a((String)x[6]), d_id, g_id, total);
//			Stream<Patient> streamPatients = crc.patientDAO.findAll(s2a((String)x[1])).stream();
//
//			List item = new ArrayList();
//			cfh.create_mutation_links(item, streamPatients);
//			viewLine.reported_mutations = item != null && item.size() > 0 ? (ArrayLinksTag<LinkToTag>) item.get(0) : new ArrayLinksTag<LinkToTag>();
//			_result.add(viewLine);
//		});
//		return _result;
//	}
//
//	private List<Integer> s2a(String x) {
//		if (x == null) return Arrays.asList();
//		return Arrays.asList(x.replace("{", "").replace("}", "").split(",")).stream().filter(x1 -> NumberUtils.isDigits(x1)).
//				map(x1 -> Integer.valueOf(x1)).collect(Collectors.toList());
//	}
//
//	private ArrayLinksTag<LinkToTag> diagnosis_sympt_persentage(List<Integer> sympt_from_db, Integer d_id, Integer g_id, Integer total) {
//	    if (sympt_from_db != null && !sympt_from_db.isEmpty() && d_id != null && g_id != null && total > 0) {
//	    	List<Object[]> _a = new ArrayList<Object[]>();
//	    	sympt_from_db.stream().forEach(_s -> {
//	    		String _t = cfh.replaceAll(cfh.replaceAll(cfh.replaceAll("SELECT COUNT(DISTINCT patients_symptoms.patient_id) AS observed FROM \"patients\" "
//	    				+ "INNER JOIN \"sequence_variations\" ON \"sequence_variations\".\"patient_id\" = \"patients\".\"id\" "
//	    				+ "LEFT OUTER JOIN patients_symptoms ON patients.id = patients_symptoms.patient_id "
//	    				+ "WHERE (\"patients\".\"status_clinical\" != 3) AND (\"sequence_variations\".\"pathogenicity\" != 1) AND \"patients\".\"disease_id\" = __disease_id__ "
//	    				+ "AND \"sequence_variations\".\"gene_id\" = __gene_id__ AND \"patients_symptoms\".\"symptom_id\" = __symptom_id__ AND \"patients_symptoms\".\"present\" = true "
//	    				+ "GROUP BY patients.disease_id", "__disease_id__", d_id.toString()), "__gene_id__", g_id.toString()), "__symptom_id__", _s.toString());
//	    		System.out.println(_t);
//	    		Query query = crc.em.createNativeQuery(_t);
//	    		List __t = query.getResultList();
//	    		if (__t.isEmpty()) return;
//	    		_a.add(new Object[] {crc.symptomDAO.findOne(_s).getName(), Math.round(100.0f * ((BigInteger)__t.get(0)).intValue() / total)});
//	    	});
//	    	ArrayLinksTag<LinkToTag> _result = new ArrayLinksTag<LinkToTag>();
//	    	int index[] = new int[1]; int linkGroupsCount = _a == null ? 0 : _a.size();
//	    	_a.stream().sorted((o1, o2) -> ((Integer)o1[1]).compareTo((Integer)o2[1])).forEach(x -> _result.add(new LinkToTag().body(x[0]+"").postfix("(" + x[1]+"%)").myIndex(++index[0]).linkGroupsCount(linkGroupsCount)));
//
//	    	return _result;
//	    } else return null;
//	}
//
//	private List<String> diagnosis_sympt(List<Integer> sympt_from_db, Integer d_id, Integer g_id, Integer _sh_id) {
//		if (sympt_from_db != null && !sympt_from_db.isEmpty() && d_id != null && g_id != null && _sh_id != null) {
//	    	List<String> _a = new ArrayList<>();
//	    	sympt_from_db.stream().forEach(_s -> {
//	    		_a.add(crc.symptomDAO.findOne(_s).getName());
//	    	});
//	    	return _a.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
//	    } else return null;
//	}
//
//	public List<LinkToTag> impossible_diagnoses() {
//		Query query = crc.em.createNativeQuery(_impossible_diagnoses);
//		List<Object[]> _t = query.getResultList();
//		List<LinkToTag> _result = new ArrayList<LinkToTag>();
//		_t.stream().forEach(x -> {
//			_result.add(new LinkToTag().body(x[1] + "-" + x[3]).href("/d/" + x[0] + "/g/" + x[2]));
//		});
//		return _result;
//	}
//
//}
