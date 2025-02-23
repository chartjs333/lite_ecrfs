//package net.mdsgene.admin.controllers;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import javax.persistence.EntityManager;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import antlr.collections.impl.IntRange;
//import net.mdsgene.admin.admintool.dal.ICategoryDAO;
//import net.mdsgene.admin.admintool.dal.IFileUploadDAO;
//import net.mdsgene.admin.admintool.dal.ISymptomDAO;
//import net.mdsgene.admin.admintool.entities.Category;
//import net.mdsgene.admin.admintool.entities.FileUpload;
//import net.mdsgene.admin.admintool.entities.Patient;
//import net.mdsgene.admin.admintool.entities.PatientsSymptom;
//import net.mdsgene.admin.admintool.entities.SequenceVariation;
//import net.mdsgene.admin.admintool.entities.Symptom;
//
//@Controller
//public class CheckExcelFileController extends BaseController{
//	private static final String lineSeparator = "\n";
//	@Autowired EntityManager em;
//	@Autowired ISymptomDAO symptomDAO;
//	@Autowired ICategoryDAO categoryDAO;
//	@Autowired IFileUploadDAO fileUploadDAO;
//
//	@GetMapping("/checkExcelFile")
//	public String check_excel_file() {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		return "checkExcelFile";
//	}
//
//	@GetMapping("/add_symptom")
//	public ResponseEntity<String> add_symptom(@RequestParam("header") String import_header, @RequestParam("name") String name,
//			@RequestParam("definition") String definition, @RequestParam("category") String category_name) {
//		if (!"yes".equals(signsSymptomsEnabled)) return ResponseEntity.ok("Disabled");
//		Symptom _s = symptomDAO.find_symptom_by_import_header(import_header);
//		Date now = Calendar.getInstance().getTime();
//		if (_s == null) {
//			_s = new Symptom();
//			_s.setCreatedAt(now);
//		}
//		_s.setImportHeader(import_header);
//		_s.setName(name);
//		_s.setUpdatedAt(now);
//		_s.setDefinition(definition);
//		Category category = categoryDAO.findAll().stream().filter(_c -> category_name.equals(_c.getName())).findFirst().orElse(null);
//		if (category != null) {
//			_s.setCategory((short) _s.getId());
//		}
//		symptomDAO.save(_s);
//		return ResponseEntity.ok("Success");
//	}
//
//	@GetMapping("/download/{download_gene_name}")
//	public ResponseEntity<byte[]> download_tsv_file(@PathVariable("download_gene_name") String download_gene_name) throws IOException {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//
//		try {
//			List<FileUpload> findAll = fileUploadDAO.findAll();
//			for (Iterator<FileUpload> it = findAll.iterator(); it.hasNext();) {
//				FileUpload fileUpload2 = (FileUpload) it.next();
//				final Set<Patient> patients = fileUpload2.getPatients();
//				for (final Iterator<Patient> iterator = patients.iterator(); iterator.hasNext();) {
//					final Patient patient = (Patient) iterator.next();
//					final Set<SequenceVariation> sequenceVariations = patient.getSequenceVariations();
//
//					boolean found = false;
//					for (final Iterator<SequenceVariation> iterator2 = sequenceVariations.iterator(); iterator2.hasNext();) {
//						final SequenceVariation sequenceVariation = (SequenceVariation) iterator2.next();
//						found = sequenceVariation.getGene().getName().equals(download_gene_name);
//						if (found) {
//							break;
//						}
//					}
//					if (found) {
//						return read_file_from_url(fileUpload2.getTsvFileFileName(), download_gene_name);
//					}
//				}
//			}
//	    }
//	    catch (IOException e)
//	    {
//	        throw e;
//	    }
//		throw new FileNotFoundException();
//	}
///**
// * @param download_file_name
// * @return
// * @throws MalformedURLException
// * @throws IOException
// */
//private ResponseEntity<byte[]> read_file_from_url(String download_file_name, String download_gene_name) throws MalformedURLException, IOException {
//	URL url = new URL("http://" + rubyUrl + "/tsv_files/" + download_file_name);
//	URLConnection conn = url .openConnection();
//	conn.setConnectTimeout(5000);
//	conn.setReadTimeout(5000);
//	conn.connect();
//
//	ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	IOUtils.copy(conn.getInputStream(), baos);
//	SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
//	String time = formatter.format(Calendar.getInstance().getTime());
//	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + download_gene_name + "_" + time + ".txt").contentType(MediaType.MULTIPART_FORM_DATA).body(baos.toByteArray());
//}
//
//	@GetMapping("/checkSymptomNames")
//	public String check_symptom_names() {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		return "checkSymptomNames";
//	}
//
//	@PostMapping("/convertPMtoMDSGene")
//	public String create_importable_file_pm(ModelMap model, @RequestParam("file") MultipartFile file) {
//		return "convertPMtoMDSGene";
//	}
//
//
//	@PostMapping("/uploadSymptomExcelFile") // //new annotation since 4.3
//	public String file_import(ModelMap model, @RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) throws IOException {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		// this function will return the list of the headers which are not presented in the database
//		// but exist in the Original symptoms text area.
//		final XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
//		final XSSFSheet ws = wb.getSheetAt(0);
//		try {
//			checkSymptomFile(ws, model);
//		} catch (Exception e) {
//			e.printStackTrace();
//			String hint =
//					"Something is wrong: " +
//					lineSeparator +
//					"1. Check that you send the excel file." +
//					lineSeparator +
//					"2. Check that your file as an excel file in the \"XLSX\" format." +
//					lineSeparator +
//					"3. Check that your import headers are on the first row(A) and symptom names on the third(C), and this all is on the first tab of the excel file.";
//			model.addAttribute("message", hint);
//		}
//		model.addAttribute("message", model.get("message").toString().split(lineSeparator));
//		model.addAttribute("chart", model.get("chart").toString().split(lineSeparator));
//		wb.close();
//		return "checkStatus";
//	}
//
//	@PostMapping("/uploadExcelFile") // //new annotation since 4.3
//	public String file_import(ModelMap model, @RequestParam("file") MultipartFile file, @RequestParam("startRow") Integer startRow,
//			RedirectAttributes redirectAttributes) throws IOException {
//		if (!"yes".equals(checkGeneUpload)) throw new IllegalArgumentException();
//		// this function will return the list of the headers which are not presented in the database
//		// but exist in the Original symptoms text area.
//		final XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
//		final XSSFSheet ws = wb.getSheetAt(0);
//		final StringBuffer text = new StringBuffer();
//		try {
//			List<Symptom> symptoms = symptomDAO.findAll().stream().sorted((o1,o2) -> o1.getImportHeader().compareTo(o2.getImportHeader())).collect(Collectors.toList());
//			checkFile(ws, model, startRow == null ? 0 : startRow);
//			model.addAttribute("symptoms", symptoms);
//			List<Category> categories = categoryDAO.findAll().stream().sorted((o1,o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
//			model.addAttribute("categories", categories);
//		} catch (Exception e) {
//			e.printStackTrace();
//			String hint =
//					"Something is wrong: " +
//					lineSeparator +
//					"1. Check that you send the excel file." +
//					lineSeparator +
//					"2. Check that your file as an excel file in the \"XLSX\" format." +
//					lineSeparator +
//					"3. Check that your data are on the first tab of the excel file.";
//			model.addAttribute("message", hint);
//		}
//		model.addAttribute("message", model.get("message").toString().split(lineSeparator));
//		wb.close();
//		return "checkStatus";
//	}
//
//	/**
//	 * Event handler delegate method for the {@link XdevButton} {@link #button2}.
//	 * @param startRow
//	 * @throws IOException
//	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
//	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
//	 */
//	private void checkSymptomFile(XSSFSheet ws, ModelMap model) {
//		int endRow = 2000;
//		// this function will check if the symptom exist in  the database
//		// if the symptom has some issue in his valuse range.
//		try {
//			final List<String> errors = new ArrayList<>();
//			model.addAttribute("message", "");
//			model.addAttribute("chart", "");
//			for (int jj = 0; jj <= Math.min(getLastRowIndex(ws), endRow); jj++) {
//				String new_import_header_name = readValue(ws, 2, jj);
//				String new_symptom_name = readValue(ws, 0, jj);
//				String category_name = readValue(ws, 1, jj);
//
//				Predicate<? super Category> check_category_name = x -> x.getName().equalsIgnoreCase(category_name);
//				boolean category_found = categoryDAO.findAll().stream().anyMatch(check_category_name);
//				if (!category_found) {
//					errors.addAll(Arrays.asList(new String[] {"Line :" + (jj + 1) + " skepped.\n"}));
//					continue;
//				}
//
//				//check if the parameters are valid
//				if (new_symptom_name != null && !new_symptom_name.trim().equals("")) {
//					// check if the symptom with this name already exist
//					boolean anyMatch = symptomDAO.findAll().stream().anyMatch(x -> x.getName().equals(new_symptom_name.trim()));
//					// check if the symptom with this import header already exist
//					boolean anyImportHeader = symptomDAO.findAll().stream().anyMatch(x -> x.getImportHeader().equals(new_import_header_name.trim()));
//					if (anyMatch || anyImportHeader) {
//						errors.addAll(Arrays.asList(new String[] {"Line :" + (jj + 1) + " skepped.\n"}));
//						if (anyMatch) errors.addAll(Arrays.asList(new String[] {"Symptom with the name (" + new_symptom_name + ") already exists.\n"}));
//						if (anyImportHeader) errors.addAll(Arrays.asList(new String[] {"Import header with the name (" + new_import_header_name + ") already exists.\n"}));
//					} else {
//						// create symptom copy
//						Symptom symptom = new Symptom();
//						symptom.setName(new_symptom_name);
//						symptom.setSignName(new_symptom_name);
//						symptom.setImportHeader(new_import_header_name);
//						symptom.setId(0);
//						symptom.setPatientsSymptoms(new HashSet<PatientsSymptom>());
//						symptom.setCategory((short) categoryDAO.findAll().stream().filter(check_category_name).findFirst().get().getId());
//						symptom.setUpdatedAt(Calendar.getInstance().getTime());
//						symptom.setCreatedAt(Calendar.getInstance().getTime());
//						symptomDAO.save(symptom);
//					}
//				} else {
//					errors.addAll(Arrays.asList(new String[] {"Line :" + (jj + 1) + " skepped.\n"}));
//				}
//			}
//			model.addAttribute("chart", errors);
//		} catch(Exception e) {
//			throw e;
//		}
//	}
//
//	/**
//	 * Event handler delegate method for the {@link XdevButton} {@link #button2}.
//	 * @param startRow
//	 * @throws IOException
//	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
//	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
//	 */
//	@SuppressWarnings("deprecation")
//	private void checkFile(XSSFSheet ws, ModelMap model, int startRow) {
//		int endRow = 4000;
//		// this function will check if the symptom exist in  the database
//		// if the symptom has some issue in his valuse range.
//		try {
//			final StringBuffer text = new StringBuffer();
//
//
//			final List<Symptom> list = symptomDAO.findAll();
//			model.addAttribute("message", "");
//			Set<String> names = new HashSet<>();
//			boolean fileChanged = false;
//
//			Set<Integer> skip_lines = new HashSet<Integer>();
//
//			for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
//				final String value = ws.getRow(0).getCell(j).getStringCellValue();
//				if (value.trim().equals("mdsgene_decision")) {
//					for (int jj = startRow; jj < Math.min(getLastRowIndex(ws), endRow); jj++) {
//						String value1 = readValue(ws, j, jj);
//						if (!value1.equals("IN")) {
//							skip_lines.add(jj);
//						}
//					}
//				}
//			}
//
//			final List<Symptom> listSymptoms = symptomDAO.findAll();
//			Set<String> skip_initial_symptoms = new HashSet<String>();
//			Map<String, Set<Integer>> lines = new TreeMap<String, Set<Integer>>();
//			for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
//				final String value = ws.getRow(0).getCell(j).getStringCellValue();
//				final String name = value;
//				if (value.equals("initial_sympt1") || value.equals("initial_sympt2") || value.equals("initial_sympt3")) {
//					for (int jj = startRow; jj < Math.min(getLastRowIndex(ws), endRow); jj++) {
//						if (skip_lines.contains(jj)) continue;
//						String value1 = readValue(ws, j, jj);
//						if (value1.equals("-99.0") || value1.equals("-99")) continue;
//						if (skip_initial_symptoms.contains(value1)) continue;
//						if (listSymptoms.stream().filter(x -> (!value1.contains("_HP:") ? value1 + "_sympt" : value1).equals(x.getImportHeader()) || (value1).equals(x.getImportHeader())).count() == 0) {
//							skip_initial_symptoms.add(value1);
//							model.addAttribute("message", model.get("message") + " intial symptoms : " + value1 + " missing in db " + lineSeparator);
//						} else {
//							final int line_no = jj;
//							listSymptoms.stream().filter(x -> (!value1.contains("_HP:") ? value1 + "_sympt" : value1).equals(x.getImportHeader()) || (value1).equals(x.getImportHeader())).forEach(x -> {
//								if (lines.get(x.getImportHeader()) == null) lines.put(x.getImportHeader(), new HashSet<Integer>());
//								lines.get(x.getImportHeader()).add(line_no);
//							});
////							listSymptoms.stream().filter(x -> (!value1.contains("_HP:") ? value1 + "_sympt" : value1).equals(x.getImportHeader())).forEach(x -> {model.addAttribute("message", model.get("message") + "symptom : " + x.getId() + " presented in db " + lineSeparator);});
//						}
//					}
//				}
//			}
//
//			if (!lines.isEmpty()) {
//				lines.forEach((k,v) -> {
//					int count = (int) v.stream().filter(_x -> {
//						for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
//							if (ws.getRow(0).getCell(j).getStringCellValue().equals(k)) {
//								for (int jj = startRow; jj < Math.min(getLastRowIndex(ws), endRow); jj++) {
//									if (skip_lines.contains(jj)) continue;
//									if(_x == jj) {
//										String value1 = readValue(ws, j, jj);
//										if (!"yes".equals(value1)) {
//											model.addAttribute("message", model.get("message") + " intial symptom wrong value : " + k + " line " + jj + " is (" + value1 + ")" + lineSeparator);
//										}
//										return value1.equals("yes");
//									}
//								}
//							}
//						}
//						return false;
//					}).count();
//					model.addAttribute("message", model.get("message") + " intial symptoms count : " + k + " ("+count+") " + lineSeparator);
//				});
//			}
//
//
//			for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
//				final String value = ws.getRow(0).getCell(j).getStringCellValue();
//				if (NumberUtils.isDigits(value.split("_")[value.split("_").length-1])) {
//					if (value.split("_")[value.split("_").length-1].length() > 4) {
//						StringBuilder sb = new StringBuilder();
//						IntStream.range(0, value.split("_").length - 1).forEach(x -> {
//							sb.append(value.split("_")[x]).append("_");
//						});
//						sb.append("HP:").append(value.split("_")[value.split("_").length-1]);
//						model.addAttribute("message", model.get("message") + value + " seems to be HP number, but HP is missing (ex. " + sb.toString() + ")"  + lineSeparator);
//					}
//				}
//			}
//
//			for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
//				final String value = ws.getRow(0).getCell(j).getStringCellValue();
//				final String name = value;
//				if (value.endsWith("_sympt") || value.contains("_HP:")) {
//					boolean addname = true;
//					int yes = 0;
//					int no  = 0;
//					int missing = 0;
//					boolean process = false;
//					if ("subdomain_cognitive_impairment_sympt".equals(value)) {
//						System.out.println(value);
//					}
//					for (int jj = startRow; jj < Math.min(getLastRowIndex(ws), endRow); jj++) {
//						if (skip_lines.contains(jj)) continue;
//						String value1 = readValue(ws, j, jj);
//						process = process || (!value1.equals("-99.0") && !value1.equals("-99"));
//						//if (!value1.equals("-99.0") && !value1.equals("-99")) continue;
//						// this part will check if the symptom values are (-99, yes, no)
//						if (!value1.equals("-99.0") && !value1.equals("-99") && !value1.equalsIgnoreCase("yes") && !value1.equalsIgnoreCase("no")) {
//							if (addname) {
//								model.addAttribute("message", model.get("message") + value + " Wrong line(s):");
//								addname = false;
//							}
//							// this part will add the line with the name if there is some issue in the symptom is
//							// with the comma separated part with the numbers of the lines in the excel file.
//							model.addAttribute("message", model.get("message").toString() + (jj+1) + ",");
//							//this.textAreaResult.setValue(this.textAreaResult.getValue() + (jj+1) + ",");
//						}
//						yes = value1.equalsIgnoreCase("yes") ? yes + 1 : yes;
//						no  = value1.equalsIgnoreCase("no")  ? no + 1  : no;
//						missing = !value1.equals("-99.0") && !value1.equals("-99") ? missing  : missing + 1;
//					}
//
////					if (!process) continue;
//					if (!addname) {
//						model.addAttribute("message", model.get("message").toString() + lineSeparator);
//					}
//					String suggestion = "";
//					boolean found = false;
//					double lastDist = 0;
//					double lastDist1 = 0;
//
//
//
//					for(int iii=0; iii < 2; iii++) {
//						for (final Symptom symptom : list) {
//							final String importHeader = symptom.getImportHeader();
//							if ((iii == 0 && org.apache.commons.lang3.StringUtils.getJaroWinklerDistance(value, importHeader) > lastDist)) {
//								lastDist = org.apache.commons.lang3.StringUtils.getJaroWinklerDistance(value, importHeader);
//								suggestion = importHeader;
//							}
//							if (iii == 1 && org.apache.commons.lang3.StringUtils.getJaroWinklerDistance(value.split("_sympt")[0].split("_HP")[0],
//											importHeader.split("_sympt")[0].split("_HP")[0]) > lastDist)	{
//								lastDist = org.apache.commons.lang3.StringUtils.getJaroWinklerDistance(value.split("_sympt")[0].split("_HP")[0],
//														importHeader.split("_sympt")[0].split("_HP")[0]);
//								suggestion = importHeader;
//							}
//							if (importHeader.equals(value)) {
//								found = true;
//								break;
//							}
//						}
//						if (found) break;
//						if (iii == 0) { lastDist1 = lastDist; lastDist = 0; }
//						if (iii == 1) { lastDist = Math.max(lastDist, lastDist1); }
//					}
//					names.add(name);
//					if (!found) {
//						if (lastDist > 0.9) {
//							model.addAttribute("message", model.get("message") + name + " missing in db, may be ? (" + suggestion + ")" + lineSeparator);
//						}
//						if (lastDist < 0.9) {
//							model.addAttribute("message", model.get("message") + name + " missing in db " + lineSeparator);
//						}
//					} else {
//						System.out.println(value);
//					}
//
//
//				}
//			}
//			em.close();
//			// files will be backupped if some changes will be needed.
//		} catch (final Exception e) {
//			throw e;
//		}
//	}
//
//	protected String readValue(XSSFSheet ws, int j, int jj) {
//		String value1 = "";
//		try {
//			value1 = ws.getRow(jj).getCell(j).getStringCellValue().trim();
//		} catch (final Exception ex) {
//			try {
//				value1 = String.valueOf(ws.getRow(jj).getCell(j).getNumericCellValue());
//			} catch (final Exception ex1) {
//
//			}
//		}
//		return value1;
//	}
//
//	protected int getLastRowIndex(final XSSFSheet ws) {
//		return ws.getLastRowNum();
//	}
//
//}
