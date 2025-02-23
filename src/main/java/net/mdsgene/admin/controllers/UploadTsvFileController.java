//package net.mdsgene.admin.controllers;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//
//import org.apache.commons.lang3.tuple.Pair;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.google.common.io.Files;
//
//import net.mdsgene.admin.admintool.business.GeneDecorator;
//import net.mdsgene.admin.admintool.dal.IPatientDAO;
//import net.mdsgene.admin.admintool.dal.ISequenceVariationDAO;
//import net.mdsgene.admin.admintool.entities.Aao;
//import net.mdsgene.admin.admintool.entities.ChartsSymptom;
//import net.mdsgene.admin.admintool.entities.FileUpload;
//import net.mdsgene.admin.admintool.entities.Gene;
//import net.mdsgene.admin.admintool.entities.Patient;
//import net.mdsgene.admin.admintool.entities.PatientsSymptom;
//import net.mdsgene.admin.admintool.entities.SequenceVariation;
//
//@Controller
//public class UploadTsvFileController extends BaseController {
//	@Autowired EntityManager em;
//	@Autowired ISequenceVariationDAO sequenceVariationDAO;
//	@Autowired IPatientDAO patientDAO;
//
//
//	@GetMapping("/uploadTsvFile")
//	public String check_excel_file(ModelMap model) {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		model.addAttribute("upload_result", "In this wizard, you can simulate the upload of your genes to the server.<br/>" +
//				"1. Type the name of the gene you will upload. <br/>" +
//				"2. Choose your tsv file and start the process.<br/>" +
//				"3. In case of an issue, you will get a message.<br/>" +
//				"4. Upload can take several minutes.");
//
//		List<Pair> versions = new ArrayList<>();
//		versions.add(Pair.of("old",    "1.00"));
//		versions.add(Pair.of("new",    "1.2"));
//
//		model.addAttribute("versions", versions);
//		model.addAttribute("upload_to_db", false);
//
//		return "uploadTsvFile";
//	}
//
//	@CacheEvict(cacheNames= {"overview"}, key="{#root.method.name, #p0}")
//	@PostMapping("/uploadTsvFile")
//	@Transactional
//	public String deleteGeneFromMDSGene(ModelMap model, @RequestParam("file") MultipartFile file, @RequestParam("geneName") String geneName,  @RequestParam(name="vers",defaultValue="1.0") String vers,
//			@RequestParam(name="upload_to_db", defaultValue="false") Boolean upload_to_db) {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		if (geneName == null) {
//			model.addAttribute("message", "please add the name of the gene");
//			return "uploadTsvFile";
//		}
//
//		if (file == null) {
//			model.addAttribute("message", "please select tsv file for upload.");
//			return "uploadTsvFile";
//		}
//
//		Set<String> fileNames = retrieveUploadFileFromGeneName(geneName);
//		if (!fileNames.isEmpty()) {
//			final List<FileUpload> list = listOfFiles(em);
//			for (Iterator it = fileNames.iterator(); it.hasNext();) {
//				String fileName = (String) it.next();
//				for (int i = 0; i < list.size(); i++) {
//					final FileUpload fileUpload = list.get(i);
//					if (fileName.equals(fileUpload.getTsvFileFileName())) {
//						final Set<Patient> patients = fileUpload.getPatients();
//						for (final Iterator iterator = patients.iterator(); iterator.hasNext();) {
//							final Patient patient = (Patient) iterator.next();
//
//							final List<Aao> listOfAaos = listOfAaos(em, patient);
//							for (final Aao aao : listOfAaos) {
//								em.remove(aao);
//							}
//
//							final Set<SequenceVariation> sequenceVariations = patient.getSequenceVariations();
//							for (final Iterator iterator2 = sequenceVariations.iterator(); iterator2.hasNext();) {
//								final SequenceVariation sequenceVariation = (SequenceVariation) iterator2.next();
//
//								final Gene gene = sequenceVariation.getGene();
//								final List<ChartsSymptom> listOfChartSymptoms = listOfChartSymptoms(em, gene);
//								for (final ChartsSymptom cs : listOfChartSymptoms) {
//									em.remove(cs);
//								}
//
//								em.remove(sequenceVariation);
//							}
//
//							final Set<PatientsSymptom> patientsSymptoms = patient.getPatientsSymptoms();
//							for (final Iterator iterator2 = patientsSymptoms.iterator(); iterator2.hasNext();) {
//								final PatientsSymptom patientsSymptom = (PatientsSymptom) iterator2.next();
//								em.remove(patientsSymptom);
//							}
//							em.remove(patient);
//						}
//						em.remove(fileUpload);
//					}
//				}
//			}
//			em.close();
//		}
//
//		String filename = Calendar.getInstance().getTime().getTime() + "_" + ((int)(Math.random()*100));
//		String pathname = "C:\\db_backup\\upload_test\\" + filename + ".txt";
//		String logname = "C:\\db_backup\\upload_test\\" + filename + ".log";
//		String errname = "C:\\db_backup\\upload_test\\" + filename + ".err";
//		try {
//			// write file to the disk
//			Files.write(file.getBytes(), new File(pathname));
//			if ("yes".equals(neeleSymptomChangeApply)) {
//				// create temp directory
//				File tempDir = new File("C:\\db_backup\\upload_test\\tmp\\" + Calendar.getInstance().getTime().getTime() + "_" + ((int)(Math.random()*100)));
//				tempDir.mkdirs();
//				// copy file to the temp directory
//				Files.copy(new File(pathname), new File(tempDir.getAbsolutePath() + "\\" + filename + ".txt"));
//				// delete original file
//				new File(pathname).delete();
//				UploadController uploadedController = new UploadController();
//				// process changes for symptoms mapping on the original file
//				uploadedController.update_excel_files_from_log(tempDir.getAbsolutePath());
//				// copy updated file to its previous location
//				Files.copy(new File(tempDir.getAbsolutePath() + "\\" + filename + ".txt"), new File(pathname));
//				// delete temp file
//				new File(tempDir.getAbsolutePath() + "\\" + filename + ".txt").delete();
//				// delete temp dir
//				new File(tempDir.getAbsolutePath()).delete();
//			}
//		} catch (IOException e) {
//			model.addAttribute("message", "Some issue on the server, try again or refer to the administrator.");
//			return "uploadTsvFile";
//		}
//
//		try {
//			String uploadTsvFile = uploadTsvFile(pathname, logname, errname, upload_to_db, vers);
//	    	Pattern pattern = Pattern.compile("\\$\\(\"#global_modal_dialog\"\\)\\.html\\(\"(.*)\"\\)");
//	    	Matcher matcher = pattern.matcher(uploadTsvFile);
//	    	if (matcher.find()) {
//	    		String group = matcher.group(1).replace("\\/", "/");
//				model.addAttribute("upload_result",group);
//				GeneDecorator.lstDisease = null;
//	    	} else {
//	    		throw new IllegalArgumentException();
//	    	}
//
//	    	if (uploadTsvFile.contains("Success")) {
//	    		Map<String, Integer> index_gene = new HashMap<>();
//	    		Map<String, Integer> index_study = new HashMap<>();
//	    		sequenceVariationDAO.findAll().forEach(x -> {
//	    			String id = x.getGene().getName() + "_" + x.getPatient().getStudy().getId();
//	    			if (!index_study.containsKey(id)) {
//	    				if (!index_gene.containsKey(x.getGene().getName())) {
//	    					index_gene.put(x.getGene().getName(), 0);
//	    				}
//	    				index_gene.put(x.getGene().getName(), index_gene.get(x.getGene().getName())+1);
//	    				index_study.put(id, index_gene.get(x.getGene().getName()));
//	    			}
//	    		});
//	    		sequenceVariationDAO.findAll().forEach(x -> {
//	    			String id = x.getGene().getName() + "_" + x.getPatient().getStudy().getId();
//	    			Integer count_total_by_gene = index_gene.get(x.getGene().getName());
//	    			Integer randomIndex = index_study.get(id)*100 / (count_total_by_gene < 3 ? 3 : count_total_by_gene);
//	    			if ("HPCA".equals(x.getGene().getName())) {
//	    				System.out.println(randomIndex);
//	    			}
//	    			System.out.println(randomIndex);
//	    			x.setRandomIndex(randomIndex);
//	    			x.getPatient().setRandomIndex(randomIndex);
//	    			x.getPatient().getStudy().setRandomIndex(randomIndex);
//	    			sequenceVariationDAO.save(x);
//	    			patientDAO.save(x.getPatient());
////	    			studyDAO.save(x.getPatient().getStudy());
//	    		});
//	    	}
//    		model.addAttribute("uploadTsvFile", uploadTsvFile);
//		} catch (Exception e) {
//			model.addAttribute("message", "Can't upload file refer to the administrator.");
//		}
//		List<Pair> versions = new ArrayList<>();
//		versions.add(Pair.of("old",    "1.00"));
//		versions.add(Pair.of("new",    "1.2"));
//
//		model.addAttribute("versions", versions);
//		model.addAttribute("upload_to_db", upload_to_db);
//
//		return "uploadTsvFile";
//	}
//
//	@CacheEvict(cacheNames= {"overview"}, key="{#root.method.name, #p0}")
//	@PostMapping("/uploadTsvFile2")
//	@Transactional
//	public ResponseEntity<byte[]> deleteGeneFromMDSGene2(ModelMap model, @RequestParam("file") MultipartFile file, @RequestParam("geneName") String geneName,  @RequestParam(name="vers",defaultValue="1.0") String vers,
//			@RequestParam(name="upload_to_db", defaultValue="false") Boolean upload_to_db) throws IOException {
//		deleteGeneFromMDSGene(model, file, geneName,  vers,upload_to_db);
//		String object = (String)model.get("uploadTsvFile");
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getOriginalFilename() + ".txt").contentType(MediaType.MULTIPART_FORM_DATA).body(object.getBytes());
//	}
//
//
//	private Set<String> retrieveUploadFileFromGeneName(String geneName) {
//		//final Integer fileId = Integer.valueOf(this.comboBoxFile.getValue().toString().split("\\.")[0]);
//		Set<String> fileNames = new HashSet<>();
//		final List<FileUpload> list = listOfFiles(em);
//
//		for (int i = 0; i < list.size(); i++) {
//			final FileUpload fileUpload = list.get(i);
//			if (true) {
//				final Set<Patient> patients = fileUpload.getPatients();
//				for (final Iterator iterator = patients.iterator(); iterator.hasNext();) {
//					final Patient patient = (Patient) iterator.next();
//					final Set<SequenceVariation> sequenceVariations = patient.getSequenceVariations();
//
//					boolean found = false;
//					for (final Iterator iterator2 = sequenceVariations.iterator(); iterator2.hasNext();) {
//						final SequenceVariation sequenceVariation = (SequenceVariation) iterator2.next();
//						found = sequenceVariation.getGene().getName().equals(geneName);
//						if (found) {
//							break;
//						}
//					}
//					if (found) {
//						fileNames.add(fileUpload.getTsvFileFileName());
//					}
//				}
//			}
//		}
//		em.close();
//		return fileNames;
//	}
//
//	private List<FileUpload> listOfFiles(final EntityManager em) {
//		TypedQuery<FileUpload> query;
//		List<FileUpload> list;
//
//		query = em.createQuery("select u from FileUpload u", FileUpload.class);
//		list = query.getResultList();
//		return list;
//	}
//
//	private List<Aao> listOfAaos(final EntityManager em, final Patient patient) {
//		TypedQuery<Aao> query;
//
//		query = em.createQuery("select u from Aao u where u.patientId = :patientId", Aao.class);
//		query.setParameter("patientId", patient.getId());
//        return query.getResultList();
//	}
//
//	private List<ChartsSymptom> listOfChartSymptoms(final EntityManager em, final Gene gene) {
//		TypedQuery<ChartsSymptom> query;
//
//		query = em.createQuery("select u from ChartsSymptom u where u.gene.id = :geneId", ChartsSymptom.class);
//		query.setParameter("geneId", gene.getId());
//        return query.getResultList();
//	}
//}
