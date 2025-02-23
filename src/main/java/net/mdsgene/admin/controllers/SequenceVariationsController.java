//package net.mdsgene.admin.controllers;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.apache.commons.collections4.map.DefaultedMap;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import net.mdsgene.admin.admintool.business.CommonFunctionsHelper;
//import net.mdsgene.admin.admintool.dal.IDiseaseDAO;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.entities.Disease;
//import net.mdsgene.admin.admintool.entities.Gene;
//import net.mdsgene.admin.admintool.entities.SequenceVariation;
//import net.mdsgene.admin.tags.ArrayLinksTag;
//import net.mdsgene.admin.tags.LinkToTag;
//
//@Controller
//public class SequenceVariationsController extends BaseController{
//	@Autowired ISequenceVariationDAO sequenceVariationDAO;
//	@Autowired IPatientDAO patientDAO;
//	@Autowired IDiseaseDAO diseaseDAO;
//	@Autowired CommonFunctionsHelper cfh;
//	@Autowired EntityManager em;
//
//
//	@GetMapping("/sequence_variations/{sequence_variation_id}")
//	public String show(ModelMap model, @PathVariable("sequence_variation_id") int sequence_variation_id) {
//		SequenceVariation mutation = sequenceVariationDAO.findOne(sequence_variation_id);
//		model.addAttribute("mutation", mutation);
//		java.util.function.BiFunction<List<List<String>>, Gene, Object> supply_with_links = (_diseases, _gene) -> {
//			if (_gene == null) {
//				return _diseases.stream().map(_d -> _d.stream().collect(Collectors.joining(", "))).collect(Collectors.joining(", "));
//			} else {
//				List<String> _diseases_flat = new ArrayList<String>();
//				_diseases.stream().forEach(_d -> _diseases_flat.addAll(_d.stream().collect(Collectors.toList())));
//				List<Disease> allDisease = diseaseDAO.findAll();
//				ArrayLinksTag<LinkToTag> _result = new ArrayLinksTag<LinkToTag>();
//				LinkToTag[] last_link_to = new LinkToTag[1];
//				_diseases_flat.stream().forEach(x -> {
//					System.out.println(x);
//					Disease _temp = allDisease.stream().filter(_d -> x.equals(_d.getAbbreviation())).findFirst().orElse(null);
//					if (_temp == null) return;
//					last_link_to[0] = new LinkToTag().body(x + "-" + _gene.getName()).href("/d/" + _temp.getId() + "/g/" + _gene.getId()).target("_blank").postfix(", )");
//					_result.add(last_link_to[0]);
//				});
//				if (last_link_to[0] != null) last_link_to[0].postfix(")");
//				return _result;
//			}
//		};
//		Object apply = supply_with_links.apply(linked_disease(mutation.getGdnaRelated(), mutation.getCdnaRelated(), mutation.getProteinRelated()), mutation.getGene());
//		model.addAttribute("supply_with_links", apply);
//		List<Integer> launched_diseases_ids = diseaseDAO.select_launched_disease().stream().map(x -> x.getId()).collect(Collectors.toList());
//		List number_of_cases = number_of_cases(launched_diseases_ids, mutation.getGdnaRelated(), mutation.getCdnaRelated(), mutation.getProteinRelated());
//		model.addAttribute("genotype_specific", genotype_specific(number_of_cases));
//		model.addAttribute("cdna_identifier", cdna_identifier(mutation.getGene()));
//		model.addAttribute("protein_identifier", protein_identifier(mutation.getGene()));
//
//		katja_lohman_manual_fix(mutation, model);
//		return "sequence_variations/show";
//	}
//
//
//	private void katja_lohman_manual_fix(SequenceVariation mutation, ModelMap model) {
//		if("g.1-1011670_20859+1910322del".equals(mutation.getGdnaRelated())) {
//			mutation.setGdnaRelated(null);
//			mutation.setAlias("deletion of exons 1-37");
//			mutation.setReference("");
//			mutation.setChromosome(null);
//			mutation.setPosition(null);
//			mutation.setImpact((short) 7); //structural_variation
//			model.addAttribute("genotype_specific", "10 heterozygous (10 in total).");
//		}
//		if("g.(302+1_3945-1)_(6652+1_?)del".equals(mutation.getGdnaRelated())) {
//			mutation.setGdnaRelated(null);
//			mutation.setReference("");
//			mutation.setAlias("deletion of exons 2-3");
//			mutation.setImpact((short) 7); //structural_variation
//			model.addAttribute("genotype_specific", "10 heterozygous (10 in total).");
//		}
//
//	}
//
//
//	private List number_of_cases(List<Integer> launched_diseases_ids, String gdna_related, String cdna_related,
//			String protein_related) {
//		Query query = em.createNativeQuery(cfh.replaceAll(cfh.replaceAll(cfh.replaceAll(patientDAO.number_of_cases,
//				"__gdna_related__", gdna_related != null ? "AND \"sequence_variations\".\"gdna_related\" = '" + gdna_related + "'" : ""),
//				"__cdna_related__", cdna_related != null ? "AND \"sequence_variations\".\"cdna_related\" = '" + cdna_related + "'" : "" ),
//				"__protein_related__", protein_related != null ? "AND \"sequence_variations\".\"protein_related\" = '" + protein_related + "'" : "" ));
//		query.setParameter("launched_diseases", launched_diseases_ids);
//		return query.getResultList();
//	}
//
//
//	public List<List<String>> linked_disease(String gdna_related, String cdna_related, String protein_related) {
//		Query query = em.createNativeQuery(cfh.replaceAll(cfh.replaceAll(cfh.replaceAll(patientDAO.linked_disease,
//				"__gdna_related__", gdna_related != null ? "AND \"sequence_variations\".\"gdna_related\" = '" + gdna_related + "'" : ""),
//				"__cdna_related__", cdna_related != null ? "AND \"sequence_variations\".\"cdna_related\" = '" + cdna_related + "'" : ""),
//				"__protein_related__", protein_related != null ? "AND \"sequence_variations\".\"protein_related\" = '" + protein_related + "'" : ""));
//		List<String> _linked_disease = query.getResultList();
//		Function<String, List<String>> retrieveDiseaseAbbr = (in) -> {
//			List<String> _abbr = new ArrayList<>();
//			String parse = StringUtils.remove(in, "{)");
//			parse = StringUtils.remove((String) parse, "})");
//			Arrays.asList(parse.split(",")).forEach(x1 -> {
//				if (!x1.trim().isEmpty()) {
//					_abbr.add(x1.trim());
//				}
//			});
//			return _abbr;
//		};
//
//		List<List<String>> _result = _linked_disease.stream().map(x -> retrieveDiseaseAbbr.apply(x)).collect(Collectors.toList());
//		return _result;
//	}
//
//
//	private String genotype_specific(List<Object[]> _number_of_cases) {
//		if (_number_of_cases != null && !_number_of_cases.isEmpty()) {
//			List<Integer> x = new ArrayList<Integer>();
//
//			String _temp = _number_of_cases.stream().map(_entry -> {
//				Short v = (Short) _entry[1];
//				Integer n = ((BigInteger) _entry[0]).intValue();
//				String _designation = "n.a.";
//				if (v != null) {
//					switch(v) {
//						case 1: _designation = "homozygous";
//						break;
//						case 2: _designation = "heterozygous";
//						break;
//						case 3: _designation = "compound heterozygous";
//						break;
//					}
//				}
//				return n + " " + _designation;
//			}).collect(Collectors.joining(", "));
//			return _temp + " (" + _number_of_cases.stream().map(_entry -> ((BigInteger) _entry[0]).intValue()).reduce((left, right) -> left + right).orElse(0) + " in total).";
//		}
//		return null;
//	}
//
//	private String cdna_identifier(Gene _gene) {
//		Map<String, String> map = new DefaultedMap<>("(n.a.)");
//	      map.put("ANO3","(NM_031418)");
//	      map.put("GNAL","(NM_001142339)");
//	      map.put("KMT2B","(NM_014727)");
//	      map.put("TOR1A","(NM_000113)");
//	      map.put("THAP1","(NM_018105)");
//	      map.put("SLC30A10","(NM_018713)");
//	      map.put("ATP13A2","(NM_022089)");
//	      map.put("DJ1","(NM_007262)");
//	      map.put("DNAJC6","(NM_001256864)");
//	      map.put("FBXO7","(NM_012179)");
//	      map.put("LRRK2","(NM_198578)");
//	      map.put("PINK1","(NM_032409)");
//	      map.put("PARKIN","(NM_004562)");
//	      map.put("SNCA","(NM_000345)");
//	      map.put("SYNJ1","(NM_203446)");
//	      map.put("VPS35","(NM_018206)");
//	      map.put("PNKD","(NM_015488)");
//	      map.put("PRRT1","(NM_145239)");
//	      map.put("SLC2A1","(NM_006516)");
//	      map.put("PDGFB","(NM_002608)");
//	      map.put("PDGFRB","(NM_002609)");
//	      map.put("SLC20A2","(NM_006749)");
//	      map.put("XPR1","(NM_004736)");
//	      map.put("PRKRA", "(NM_003690)");
//	      map.put("DCTN1", "(NM_004082)");
//	      map.put("KCNA1", "(NM_000217)");
//	      map.put("MYORG", "(NM_020702)");
//
//	      map.put("ADCY5", "(NM_183357)");
//   	      map.put("NKX2-1", "(NM_001079668)");
//	      map.put("PDE10A", "(NM_001130690)");
//	      map.put("HPCA", "(NM_002143)");
//	      map.put("GCH1", "(NM_000161)");
//  	      map.put("QDPR", "(NM_000320)");
//  	      map.put("SLC6A3", "(NM_001044)");
//  	      map.put("SLC1A3", "(NM_004172)");
//  	      map.put("REEP1", "(NM_022912)");
//  	      map.put("PRRT2", "(NM_001256442)");
//	      return map.get(_gene.getName());
//	}
//
//	String protein_identifier(Gene _gene) {
//		Map<String, String> map = new DefaultedMap<>("(n.a.)");
//      map.put("ANO3","(NP_113606)");
//      map.put("GNAL","(NP_001135811)");
//      map.put("KMT2B","(NP_055542)");
//      map.put("TOR1A","(NP_000104)");
//      map.put("THAP1","(NP_060575)");
//      map.put("SLC30A10","(NP_061183)");
//      map.put("ATP13A2","(NP_071372)");
//      map.put("DJ1","(NP_009193)");
//      map.put("DNAJC6","(NP_001243793)");
//      map.put("FBXO7","(NP_036311)");
//      map.put("LRRK2","(NP_940980)");
//      map.put("PINK1","(NP_115785)");
//      map.put("PARKIN","(NP_004553)");
//      map.put("SNCA","(NP_000336)");
//      map.put("SYNJ1","(NP_982271)");
//      map.put("VPS35","(NP_060676)");
//      map.put("PNKD","(NP_056303)");
//      map.put("PRRT1","(NP_145239)");
//      map.put("SLC2A1","(NP_006507)");
//      map.put("PDGFB","(NP_002599)");
//      map.put("PDGFRB","(NP_002600)");
//      map.put("SLC20A2","(NP_006740)");
//      map.put("XPR1","(NP_004727)");
//      map.put("PRKRA", "(NP_003681)");
//      map.put("DCTN1", "(NP_004073)");
//      map.put("KCNA1", "(NP_000208)");
//      map.put("MYORG", "(NP_065753)");
//
//      map.put("ADCY5", "(NP_899200)");
//      map.put("NKX2-1", "(NP_001073136)");
//      map.put("PDE10A", "(NP_001124162)");
//      map.put("HPCA", "(NP_002134)");
//      map.put("GCH1", "(NP_000152)");
//	  map.put("QDPR", "(NP_000311)");
//	  map.put("SLC6A3", "(NP_001035)");
//	  map.put("SLC1A3", "(NP_004163)");
//	  map.put("REEP1", "(NP_075063)");
//	  map.put("PRRT2", "(NP_001243371)");
//      return map.get(_gene.getName());
//	}
//}
