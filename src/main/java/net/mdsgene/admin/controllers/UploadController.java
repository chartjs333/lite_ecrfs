//package net.mdsgene.admin.controllers;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.function.BiFunction;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//import java.util.regex.Pattern;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//import javax.persistence.EntityManagerFactory;
//import javax.transaction.Transactional;
//
//import net.mdsgene.admin.admintool.business.PatientValidator;
//import net.mdsgene.admin.admintool.business.SequenceVariationValidator;
//import net.mdsgene.admin.admintool.dal.*;
//import org.apache.commons.beanutils.BeanUtilsBean2;
//import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.Pair;
//import org.apache.commons.validator.routines.IntegerValidator;
//import org.apache.commons.validator.routines.ShortValidator;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.DataBinder;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
//
//import com.sun.net.httpserver.Headers;
//import com.univocity.parsers.common.AbstractParser;
//import com.univocity.parsers.common.processor.RowListProcessor;
//import com.univocity.parsers.csv.CsvParser;
//import com.univocity.parsers.csv.CsvParserSettings;
//import com.univocity.parsers.csv.CsvWriter;
//import com.univocity.parsers.csv.CsvWriterSettings;
//import com.univocity.parsers.tsv.TsvParser;
//import com.univocity.parsers.tsv.TsvParserSettings;
//import com.univocity.parsers.tsv.TsvWriter;
//import com.univocity.parsers.tsv.TsvWriterSettings;
//
//import net.mdsgene.admin.admintool.business.HibernateValidatorEventListener;
//import net.mdsgene.admin.admintool.business.StudyLookUpUtils;
//import net.mdsgene.admin.admintool.business.UploadMappers;
//import net.mdsgene.admin.admintool.entities.Disease;
//import net.mdsgene.admin.admintool.entities.Family;
//import net.mdsgene.admin.admintool.entities.FileUpload;
//import net.mdsgene.admin.admintool.entities.Gene;
//import net.mdsgene.admin.admintool.entities.Patient;
//import net.mdsgene.admin.admintool.entities.PatientsSymptom;
//import net.mdsgene.admin.admintool.entities.SequenceVariation;
//import net.mdsgene.admin.admintool.entities.Study;
//import net.mdsgene.admin.admintool.entities.Symptom;
//import net.mdsgene.admin.controllers.UploadController.FileUploadUtils;
//
//@Controller
//public class UploadController extends BaseController {
//	private static final String lineSeparator = "\n";
//	private static final Logger LOGGER = Logger.getLogger( UploadController.class.getName() );
//	private static UploadMappers mappers;
//
//	@Autowired IFileUploadDAO fileUploadDAO;
//	@Autowired IStudyDAO studyDAO;
//	@Autowired IStudyDAO2 studyDAO2;
//	@Autowired ISymptomDAO symptomDAO;
//	@Autowired IFamilyDAO familyDAO;
//	@Autowired IDiseaseDAO diseaseDAO;
//	@Autowired IGeneAliasDAO geneAliasDAO;
//	@Autowired IGeneDAO geneDAO;
//	@Autowired ISequenceVariationDAO sequenceVariationDAO;
//	@Autowired IPatientsSymptomDAO patientsSymptomDAO;
//	@Autowired IAuthorDAO authorDAO;
//	@Autowired IAuthorGroupDAO authorGroupDAO;
//	@Autowired IPatientDAO patientDAO;
//	@Autowired HibernateValidatorEventListener entityValidator;
//
//	//Save the uploaded file to this folder
//	public static String UPLOADED_FOLDER = "C://published//";
//	//	@GetMapping("/")
//	public String index() {
//		return "upload";
//	}
//
//	public static class Row {
//
//	}
//
//	/**
//	 * This class was created for the back compatibility with MultipartFile, and possibility to use File as a parameter
//	 * @author admin
//	 */
//	public static class MultipartFile extends File {
//
//		private FileInputStream is;
//
//		public MultipartFile(String pathname) {
//			super(pathname);
//		}
//
//		public String getOriginalFilename() {
//			return super.getName();
//		}
//
//		public String getContentType() {
//			return "text/plain";
//		}
//
//		public long getSize() {
//			return super.length();
//		}
//
//		public InputStream getInputStream() throws FileNotFoundException {
//			if (is == null) {
//				is = new FileInputStream(super.getPath());
//			}
//			return is;
//		}
//
//	}
//
//	public static class FileUploadUtils {
//		private static final Logger LOGGER = Logger.getLogger( FileUploadUtils.class.getName() );
//		RedirectAttributes redirectAttributes;
//		String encoding = "";
//		UploadResult result = new UploadResult();
//
//		public FileUploadUtils(RedirectAttributes redirectAttributes) {
//			this.redirectAttributes = redirectAttributes;
//
//		}
//		Function<MultipartFile, FileUpload> initialize = (file) -> {
//			String pathname = file.getOriginalFilename();
//			String new_pathname = UPLOADED_FOLDER + FilenameUtils.getBaseName(pathname) + "." + FilenameUtils.getExtension(pathname);
//
//			int postfix = 0;
//			while (new File(new_pathname).exists()) {
//				postfix++;
//				new_pathname = UPLOADED_FOLDER + FilenameUtils.getBaseName(pathname) + "_" + postfix + "." + FilenameUtils.getExtension(pathname);
//			}
//			String tsvFileFileName = (postfix == 0) ? FilenameUtils.getBaseName(pathname) + "." + FilenameUtils.getExtension(pathname)
//													: FilenameUtils.getBaseName(pathname) + "_" + postfix + "." + FilenameUtils.getExtension(pathname);
//
//			FileUpload fileUpload = new FileUpload();
//			fileUpload.setTsvFileContentType(file.getContentType());
//			fileUpload.setTsvFileFileName(tsvFileFileName);
//			fileUpload.setTsvFileFileSize((int) file.getSize());
//			fileUpload.setCreatedAt(new Date());
//			fileUpload.setUpdatedAt(new Date());
//			fileUpload.setPatients(new HashSet<>());
//			return fileUpload;
//		};
//		Predicate<MultipartFile> valid = (file) -> {
//			if (file == null) result.issues.add("Upload file is missing");
//			if (!Arrays.asList("text/plain", "text/csv").contains(file.getContentType())) result.issues.add("Invalid content type : " + file.getContentType());
//			if (file.getSize() > 4194304) result.issues.add("File can't be bigger then 4Mb");
//			redirectAttributes.addFlashAttribute("message", result.issues.stream().collect(Collectors.joining(";")));
//			return result.issues.isEmpty();
//		};
//		Predicate<MultipartFile> check_encoding = (file) -> {
//			try {
//				encoding = new InputStreamReader(file.getInputStream()).getEncoding();
//				if (!Arrays.asList("UTF8", "ISO-8859-1").contains(encoding)) {
//					result.issues.add("The given file's encoding (" + encoding + ") is not supported.");
//					redirectAttributes.addFlashAttribute("message", result.issues.stream().collect(Collectors.joining(";")));
//					return false;
//				}
//			} catch (Exception e) {
//				if (!Objects.isNull(e)) LOGGER.error(e.getMessage());
//				result.issues.add("Can't read the file.");
//				redirectAttributes.addFlashAttribute("message", result.issues.stream().collect(Collectors.joining(";")));
//				return false;
//			}
//			return true;
//		};
//		Function<MultipartFile, org.apache.commons.lang3.tuple.ImmutablePair<CsvParser, RowListProcessor>> csv_open = (x) -> {
//			// The settings object provides many configuration options
//			CsvParserSettings parserSettings = new CsvParserSettings();
//			//You can configure the parser to automatically detect what line separator sequence is in the input
//			parserSettings.setDelimiterDetectionEnabled(true, '\t');
//			parserSettings.setQuoteDetectionEnabled(false);
//			// A RowListProcessor stores each parsed row in a List.
//			RowListProcessor rowProcessor = new RowListProcessor();
//			// You can configure the parser to use a RowProcessor to process the values of each parsed row.
//			// You will find more RowProcessors in the 'com.univocity.parsers.common.processor' package, but you can also create your own.
//			parserSettings.setProcessor(rowProcessor);
//			// Let's consider the first parsed row as the headers of each column in the file.
//			parserSettings.setHeaderExtractionEnabled(true);
//			// creates a parser instance with the given settings
//			CsvParser parser = new CsvParser(parserSettings);
//			// the 'parse' method will parse the file and delegate each parsed row to the RowProcessor you defined
//			return org.apache.commons.lang3.tuple.ImmutablePair.of(parser, rowProcessor);
//		};
//		Function<MultipartFile, org.apache.commons.lang3.tuple.ImmutablePair<TsvParser, RowListProcessor>> tsv_open = (x) -> {
//			// The settings object provides many configuration options
//			TsvParserSettings parserSettings = new TsvParserSettings();
//			parserSettings.setLineJoiningEnabled(true);
//			//You can configure the parser to automatically detect what line separator sequence is in the input
//			// A RowListProcessor stores each parsed row in a List.
//			RowListProcessor rowProcessor = new RowListProcessor();
//			// You can configure the parser to use a RowProcessor to process the values of each parsed row.
//			// You will find more RowProcessors in the 'com.univocity.parsers.common.processor' package, but you can also create your own.
//			parserSettings.setProcessor(rowProcessor);
//			// Let's consider the first parsed row as the headers of each column in the file.
//			parserSettings.setHeaderExtractionEnabled(true);
//			// creates a parser instance with the given settings
//			TsvParser parser = new TsvParser(parserSettings);
//			// the 'parse' method will parse the file and delegate each parsed row to the RowProcessor you defined
//			return org.apache.commons.lang3.tuple.ImmutablePair.of(parser, rowProcessor);
//		};
//		Function<MultipartFile, List<String>> raw_headers = (file) -> {
//			LOGGER.debug(encoding);
//			ImmutablePair<TsvParser,RowListProcessor> t = tsv_open.apply(file);
//			try {
//				TsvParser parser = t.left;
//				RowListProcessor rowProcessor = t.right;
//				parser.parse(file.getInputStream());
//				// get the parsed records from the RowListProcessor here.
//				// Note that different implementations of RowProcessor will provide different sets of functionalities.
//				List<String> headers = Arrays.<String>asList(rowProcessor.getHeaders()).stream().map(x -> StringUtils.lowerCase(x)).collect(Collectors.toList());
//				return headers;
//			} catch (Exception e) {
//				if (!Objects.isNull(e)) LOGGER.error(e.getMessage());
//				redirectAttributes.addFlashAttribute("message", "Can't read the file.");
//			}
//			return Arrays.asList();
//		};
//		Function<MultipartFile, Stream<List<DefaultMapEntry<String,String>>>> csv_foreach = (file) -> {
//			ImmutablePair<TsvParser,RowListProcessor> t = tsv_open.apply(file);
//			try {
//				TsvParser parser = t.left;
//				RowListProcessor rowProcessor = t.right;
//				parser.parse(file.getInputStream());
//				// get the parsed records from the RowListProcessor here.
//				// Note that different implementations of RowProcessor will provide different sets of functionalities.
//				//
//				String[] headers = rowProcessor.getHeaders();
//				return rowProcessor.getRows().stream().map(row -> IntStream.range(0, row.length).mapToObj(i -> { return new DefaultMapEntry<String,String>(StringUtils.lowerCase(headers[i]), row[i]); }).collect(Collectors.toList()));
//			} catch (Exception e) {
//				if (!Objects.isNull(e)) LOGGER.error(e.getMessage());
//				redirectAttributes.addFlashAttribute("message", "Can't read the file.");
//			}
//			return new ArrayList<List<DefaultMapEntry<String,String>>>().stream();
//		};
//		public void debug(Object ...objects) {
//			Arrays.asList(objects).stream().forEach(obj -> System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE)));
//		}
//		private static List<String> required = Arrays.asList("pmid", "disease_abbrev", "individual_id", "mdsgene_decision", "family_id", "index_pat");
//	}
//
//	public static class MU {
//		static Function<String, Short> null_or_short = (s) -> {return StringUtils.isEmpty(s) || !NumberUtils.isDigits(s) ? null : Short.valueOf(s);};
//		static Function<String, BigDecimal> bd_or_null = (s) -> {return StringUtils.isEmpty(s) || !NumberUtils.isParsable(s.replaceAll(",", ".")) ? null : BigDecimal.valueOf(Double.valueOf(s.replaceAll(",", ".")));};
////		static Function<String, Integer> integer_or_null = (s) -> {return StringUtils.isEmpty(s) ? null : Integer.valueOf(s);};
////		static Function<String, Boolean> boolean_or_null = (s) -> {return StringUtils.isEmpty(s) ? null : Boolean.valueOf(s);};
////		static Function<String, String> lower_case = (s) -> {return s == null ? null : StringUtils.lowerCase(s.trim());};
//	}
//
//	public static class StudyUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//		private IAuthorDAO authorDAO;
//		private IAuthorGroupDAO authorGroupDAO;
//		private Map<Integer, BindingResult> errors;
//
//		public StudyUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped, IAuthorDAO authorDAO, IAuthorGroupDAO authorGroupDAO) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//			this.authorDAO = authorDAO;
//			this.authorGroupDAO = authorGroupDAO;
//			errors = new HashMap<>();
//		}
//
//		public static Study st = null;
//		Supplier<Study> get_study = () -> {
//			if (st != null) return st;
//			Study study = cacheble();
//			st = study;
//			return study;
//		};
//
//		@Cacheable(cacheNames= {"overview"}, key="#root.method.name")
//		private Study cacheble() {
//			long timeInMillis = Calendar.getInstance().getTimeInMillis();
//			Study s=new Study(); s.setPubmedId(Integer.valueOf(line.get("pmid")));
//			// this mock is only for quick it up later you have to uncomment lines bellow
//			Study study = uploadController.studyDAO.findByPubmedId(Integer.valueOf(line.get("pmid")));
//
//			if (study != null) {
//				//System.out.println("Existing study " + study.getId() + "  patients count: " + study.getPatients().size());
////				study.getPatients().forEach(x -> System.out.println(study.getId() + "=" + x.getId() + "=" + x.getFamily()));
//				return study;
//			} else study = s;
//			skipped.removeAll(Arrays.asList("study_design", "genet_methods", "comments_study", "lower_age_limit", "upper_age_limit"));
//			study.setCreatedAt(new Date());
//			study.setPubmedId(Integer.valueOf(line.get("pmid")));
//			study.setDesign((short) Arrays.asList("case report/case series","mutational screen", "family study","sib pair study","other/mixed").indexOf(line.get("study_design").toLowerCase())); study.setDesign((short) (study.getDesign() + 1));
//			study.setGeneticMethods(line.get("genet_methods"));
//			study.setComment(line.get("comments_study"));
//			study.setLowerAgeLimit(MU.null_or_short.apply(line.get("lower_age_limit")));
//			study.setUpperAgeLimit(MU.null_or_short.apply(line.get("upper_age_limit")));
//			StudyLookUpUtils studyLookUpUtils = new StudyLookUpUtils(authorDAO, authorGroupDAO);
//			try {
//				studyLookUpUtils.fetch_study_details(study);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			studyLookUpUtils.save_study_authors();
//			study.setUpdatedAt(new Date());
//			return study;
//		}
//
//		public boolean save(Study study, boolean validate) {
//			/*  has_many :author_groups, as: :article, dependent: :destroy
//			  has_many :authors, through: :author_groups
//			  has_many :patients, dependent: :destroy
//			  has_many :sequence_variations, through: :patients
//			*/
//			if (validate) {
//				BindingResult errors = uploadController.entityValidator.errors(study);
//				study.getPatients().stream().forEach(x -> {
//					errors.addAllErrors(uploadController.entityValidator.errors(x));
//					x.getSequenceVariations().forEach(x1 -> {
//						errors.addAllErrors(uploadController.entityValidator.errors(x1));
//					});
//				});
//			}
//
////			study.getPatients().stream().forEach(x -> {
////				Patient patient = x;
////				Disease disease = patient.getDisease();
////				Family family = patient.getFamily();
////				FileUpload fileUpload = patient.getFileUpload();
////
////				disease.getPatients().addAll(study.getPatients());
////				patient.getFamily().getPatients().addAll(study.getPatients());
////				fileUpload.getPatients().addAll(study.getPatients());
////				patient.getSequenceVariations().stream().forEach(sv -> sv.setPatient(patient););
////			});
//			return true;//return errors.getAllErrors().isEmpty();
//		}
//
//		public void add_errors(int line_no, Study study) {
//			errors.put(line_no, uploadController.entityValidator.errors(study));
//		}
//
//		public void add_errors(int line_no, Patient patient) {
//			errors.put(line_no, uploadController.entityValidator.errors(patient));
//		}
//
//		public void add_errors(int line_no, Family family) {
//			errors.put(line_no, uploadController.entityValidator.errors(family));
//		}
//
//		public void add_errors(int line_no, Disease disease) {
//			errors.put(line_no, uploadController.entityValidator.errors(disease));
//		}
//
//		public void add_errors(int line_no, PatientsSymptom ps) {
//			errors.put(line_no, uploadController.entityValidator.errors(ps));
//		}
//
//		public void add_errors(int line_no, Gene gene) {
//			errors.put(line_no, uploadController.entityValidator.errors(gene));
//		}
//
//		public void add_errors(int line_no, SequenceVariation sv) {
//			errors.put(line_no, uploadController.entityValidator.errors(sv));
//		}
//	}
//
//	public static class FamilyUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public FamilyUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		Supplier<Boolean> get_history = () -> {
//			if (uploadController.yes_no_mapper().containsKey(line.get("famhx"))) {
//				line.remove("famhx");
//				return uploadController.yes_no_mapper().get(line.get("famhx"));
//			}
//			return false;
//		};
//
//		Function<Integer, Family> get_family = (line_no) -> {
//			/*Family family = this.uploadController.familyDAO.findAll().stream().filter(x -> x.getName().equals(line.get("family_id"))).findFirst().orElse(((Supplier<Family>)(() -> {Family f=new Family(); f.setName(line.get("family_id")); return f;})).get());
//			if (family.getId() != 0) return family;*/
//			Family family = new Family(); family.setCreatedAt(new Date()); family.setName("fid_" + new Date().getTime() + "_" + line_no);
//			family.setHistory(get_history.get());
//
//			Arrays.asList("num_het_mut_affected", "num_hom_mut_affected", "num_het_mut_unaffected", "num_hom_mut_unaffected",
//					"num_wildtype_affected", "num_wildtype_unaffected").stream().forEach(nfield -> {
//				if(line.containsKey(nfield)) {
//					skipped.remove(nfield);
//					family.setNumHetMutAffected(NumberUtils.toInt(line.get(nfield)));
//					family.setNumHomMutAffected(NumberUtils.toInt(line.get(nfield)));
//					family.setNumHetMutUnaffected(NumberUtils.toInt(line.get(nfield)));
//					family.setNumHomMutUnaffected(NumberUtils.toInt(line.get(nfield)));
//					family.setNumWildtypeAffected(NumberUtils.toInt(line.get(nfield)));
//					family.setNumWildtypeUnaffected(NumberUtils.toInt(line.get(nfield)));
//				}
//			});
//			return family;
//		};
//	}
//
//	public static class DiseaseUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public DiseaseUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		Function<String, Disease> find_or_initialize_by = (abbreviation) -> {
//			Disease disease = this.uploadController.diseaseDAO.findAll().stream().filter(x -> x.getAbbreviation().equals(abbreviation)).findFirst().orElse(((Supplier<Disease>)(() -> {Disease d=new Disease(); d.setAbbreviation(abbreviation); d.setName(abbreviation); d.setCreatedAt(new Date()); return d;})).get());
//			return disease;
//		};
//
//	}
//
//	public static class PatientUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public PatientUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		BiFunction<FileUpload, Integer, Patient> new_patient = (_file_upload, _line_no) -> {
//			 Patient patient = new Patient();
//			 patient.setFileUpload(_file_upload);
//			 patient.setLineOfFile(_line_no);
//			 _file_upload.getPatients().add(patient);
//			 patient.setCreatedAt(new Date());
//			 patient.setUpdatedAt(new Date());
//			 return patient;
//		};
//
//		Function<String, Short> get_sex = (sex) -> {
//			// sex_unknown is database default
//			String a = Arrays.asList("male", "female").stream().filter(x -> x.equalsIgnoreCase(sex)).findFirst().orElse("sex_unknown");
//			return (short) Arrays.asList("sex_unknown", "male", "female").indexOf(a);
//		};
//
//		Function<String, Boolean> clinical_info = (ci) -> {
//			// false is database-default
//			return "yes".equals(ci);
//		};
//
//		Function<String, Short> status_parac = (sp) -> {
//			if (uploadController.status_parac_mapper().containsKey(sp)) {
//				return (short) Arrays.asList("paraclinical_status_unknown", "paraclinical_status_affected", "paraclinical_status_unaffected", "paraclinical_status_uncertain").indexOf(uploadController.status_parac_mapper().get(sp));
//			} else {
//				return (short) 0;
//			}
//		};
//
//		Function<String, Short> status_clinical = (sc) -> {
//			if (uploadController.status_clinical_mapper().containsKey(sc)) {
//				return (short) Arrays.asList("clinical_status_unknown", "clinical_status_affected", "clinical_status_unaffected", "clinical_status_uncertain").indexOf(uploadController.status_clinical_mapper().get(sc));
//			} else {
//				return (short) 0;
//			}
//		};
//
//		Function<String, Short> get_ethnicity = (ethn) -> {
//			if (UploadMappers.ethnicity_mapper().containsKey(ethn)) {
//				Optional<PatientValidator.ethnicity> v = Arrays.asList(PatientValidator.ethnicity.values()).stream().filter(x -> x.name().equals(UploadMappers.ethnicity_mapper().get(ethn))).findFirst();
//				return v.isPresent() ? (short)v.get().getEthnicity() : (short) 0;
//			} else {
//				//return ethn == null ? null : (short) 0;
//				return null;
//			}
//		};
//
//		Function<Map<String, String>, Short> get_levodopa = (line) -> {
//			String lr = StringUtils.lowerCase(line.get("levodopa_response"));
//			if (uploadController.lr_mapper().containsKey(lr)) {
//				return (short) Arrays.asList("not_treated_with_levodopa", "no_levodopa_response").indexOf(uploadController.lr_mapper().get(lr));
//			} else if ("yes".equals(lr)){
//				if (line.containsKey("response_quantification")) return this.get_levodopa_by_rq.apply(uploadController, StringUtils.lowerCase(line.get("response_quantification"))) ;
//				return (short) PatientValidator.levodopa_response.undefined_levodopa_response.ordinal();
//			}
//			return null;
//		};
//
//		BiFunction<UploadController, String, Short> get_levodopa_by_rq = (uc, rq) -> (short)Arrays.asList(PatientValidator.levodopa_response.values()).stream().filter(x -> x.name().equals(uc.rq_mapper().get(rq))).findFirst().orElse(PatientValidator.levodopa_response.undefined_levodopa_response).ordinal();
//
//
//		Function<String, Short> other_pxmd = (op) -> {
//			if (uploadController.other_pxmd_mapper().containsKey(op)) {
//				return (short) Arrays.asList("","none", "pkd", "pkd/ic", "pnkd", "ped").indexOf(uploadController.other_pxmd_mapper().get(op));
//			} else {
//				return (short) 0;
//			}
//		};
//
//		Function<ImmutablePair<Patient, Map<String, String>>, Object> skip_exceptions = (u) -> {
//			if (u.left.getSex() != 0) skipped.remove("sex"); //unless patient.sex_unknown
//			if (uploadController.yes_no_mapper().containsKey(StringUtils.lowerCase(line.get(clinical_info)))) skipped.remove("clinical_info");
//			if (u.left.getStatusClinical() != 0) skipped.remove("status_clinical"); //unless patient.clinical_status_unknown?
//			if (u.left.getStatusParaclinical() != 0) skipped.remove("status_paraclinical"); //unless patient.paraclinical_status_unknown?
//			return null;
//		};
//
//		Function<ImmutablePair<Patient, Map<String, String>>, Set<String>> get_skipped = (s) -> {
//			List<String> patient_attributes = Arrays.asList("id", "disease_id", "levodopa_response", "sex", "ethnicity", "age_at_onset", "age_at_exam", "clinical_info", "comment", "created_at", "updated_at", "study_id", "individual_identity", "family_id", "country", "index_pat", "status_clinical", "status_paraclinical", "aao_clinical", "aao_paraclinical", "disease_duration", "age_at_rem", "age_at_diagnosis", "age_at_death", "other_pxmd", "line_of_file", "file_upload_id"
//			);//todo may be those attributes should be dynamically given?
//			patient_attributes.forEach((done) -> {
//				skipped.remove(patient_to_header().get(done));
//			});
//			skip_exceptions.apply(ImmutablePair.of(s.left, line));
//
//			int[] sqc = new int[1];
//			s.left.getSequenceVariations().forEach(sq -> {
//				List<String> sq_attributes = Arrays.asList("id", "patient_id", "gene_id", "sporadic", "gdna_related", "cdna_related", "protein_related", "genotype", "impact", "chromosome", "hgrb", "created_at", "updated_at", "num_within_spg", "observed", "reference", "position", "alias", "genome_build", "pathogenicity", "cadd_score", "positive_evidence", "negative_evidence", "exac_link");
//				sqc[0] += 1;
//				sq_attributes.forEach((done) -> {
//					skipped.remove(sv_to_header(sqc[0]).get(done));
//				});
//			});
//
//			skipped.removeAll(Arrays.asList("hg_version", "genome_build")); // Attributes of SequenceVariation, skip always
//
//			return skipped;
//		};
//		Short countries(String c) {
//			short result =
//					(short) Arrays.asList( "ABW", "AFG", "AGO", "AIA", "ALA", "ALB", "AND", "ARE", "ARG", "ARM", "ASM", "ATA", "ATF", "ATG",
//							"AUS", "AUT", "AZE", "BDI", "BEL", "BEN", "BES", "BFA", "BGD", "BGR", "BHR", "BHS", "BIH", "BLM",
//							"BLR", "BLZ", "BMU", "BOL", "BRA", "BRB", "BRN", "BTN", "BVT", "BWA", "CAF", "CAN", "CCK", "CHE",
//							"CHL", "CHN", "CIV", "CMR", "COD", "COG", "COK", "COL", "COM", "CPV", "CRI", "CUB", "CUW", "CXR",
//							"CYM", "CYP", "CZE", "DEU", "DJI", "DMA", "DNK", "DOM", "DZA", "ECU", "EGY", "ERI", "ESH", "ESP",
//							"EST", "ETH", "FIN", "FJI", "FLK", "FRA", "FRO", "FSM", "GAB", "GBR", "GEO", "GGY", "GHA", "GIB",
//							"GIN", "GLP", "GMB", "GNB", "GNQ", "GRC", "GRD", "GRL", "GTM", "GUF", "GUM", "GUY", "HKG", "HMD",
//							"HND", "HRV", "HTI", "HUN", "IDN", "IMN", "IND", "IOT", "IRL", "IRN", "IRQ", "ISL", "ISR", "ITA",
//							"JAM", "JEY", "JOR", "JPN", "KAZ", "KEN", "KGZ", "KHM", "KIR", "KNA", "KOR", "KWT", "LAO", "LBN",
//							"LBR", "LBY", "LCA", "LIE", "LKA", "LSO", "LTU", "LUX", "LVA", "MAC", "MAF", "MAR", "MCO", "MDA",
//							"MDG", "MDV", "MEX", "MHL", "MKD", "MLI", "MLT", "MMR", "MNE", "MNG", "MNP", "MOZ", "MRT", "MSR",
//							"MQT", "MUS", "MWI", "MYS", "MYT", "NAM", "NCL", "NER", "NFK", "NGA", "NIC", "NIU", "NLD", "NOR",
//							"NPL", "NRU", "NZL", "OMN", "PAK", "PAN", "PCN", "PER", "PHL", "PLW", "PNG", "POL", "PRI", "PRK",
//							"PRT", "PRY", "PSE", "PYF", "QAT", "REU", "ROU", "RUS", "RWA", "SAU", "SDN", "SEN", "SGP", "SGS",
//							"SHN", "SJM", "SLB", "SLE", "SLV", "SMR", "SOM", "SPM", "SRB", "SSD", "STP", "SUR", "SVK", "SVN",
//							"SWE", "SWZ", "SXM", "SYC", "SYR", "TCA", "TCD", "TGO", "THA", "TJK", "TKL", "TKM", "TLS", "TON",
//							"TTO", "TUN", "TUR", "TUV", "TWN", "TZA", "UGA", "UKR", "UMI", "URY", "USA", "UZB", "VAT", "VCT",
//							"VEN", "VGB", "VIR", "VNM", "VUT", "WLF", "WSM", "YEM", "ZAF", "ZMB", "ZWE" ).indexOf(c);
//			return result != -1 ? result : null;
//		}
//
//		Map<String, String> patient_to_header() {
//			Map<String, String> pth = new HashMap<>();
//			pth.put("levodopa_response", "levodopa_response");
//			pth.put("ethnicity", "ethnicity");
//			pth.put("age_at_onset", "aao");
//			pth.put("age_at_exam", "aae");
//			pth.put("comment", "comments_pat");
//			pth.put("country", "country");
//			pth.put("aao_clinical", "aao_clinical");
//			pth.put("aao_paraclinical", "aao_paraclinical");
//			pth.put("disease_duration", "duration");
//			pth.put("age_at_rem", "age_rem");
//			pth.put("age_at_diagnosis", "age_dx");
//			pth.put("age_at_death", "age_death");
//			pth.put("other_pxmd", "presence_of_other_pxmd");
//			return pth;
//		}
//
//		Map<String, String> sv_to_header(int count) {
//			Map<String, String> m = new HashMap<>();
//			m.put("sporadic", "mut" + count + "_sporadic");
//			m.put("gdna_related", "mut" + count + "_g");
//			m.put("cdna_related", "mut" + count + "_c");
//			m.put("protein_related", "mut" + count + "_p");
//			m.put("genotype", "mut" + count + "_genotype");
//			m.put("impact", "mut" + count + "_type");
//			m.put("observed", "observed_allele" + count);
//			m.put("reference", "reference_allele" + count);
//			m.put("alias", "mut" + count + "_alias");
//			m.put("pathogenicity", "pathogenicity" + count);
//			m.put("cadd_score", "cadd_" + count);
//			m.put("positive_evidence", "fun_evidence_pos_" + count);
//			m.put("negative_evidence", "fun_evidence_neg_" + count);
//			m.put("exac_link", "exac_" + count);
//			return m;
//		}
//
//	}
//
//	public static class GeneUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public GeneUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		Function<String, Gene> find_or_initialize_by = (name) -> {
//			Gene gene = this.uploadController.geneDAO.findAll().stream().filter(x -> x.getName().equals(name)).findFirst().orElse(((Supplier<Gene>)(() -> {Gene g=new Gene(); g.setCreatedAt(new Date()); g.setUpdatedAt(new Date()); g.setName(name); return g;})).get());
//			return gene;
//		};
//
//	}
//
//	public static class SequenceVariationUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public SequenceVariationUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		Supplier<Map<String, Integer>> chromosomes = () -> {
//			Map<String, Integer> result = new HashMap<>();
//			IntStream.range(1, 23).forEach(x -> result.put("chr" + String.valueOf(x), x));
//			result.put("chrX", 23);result.put("chrY", 24);result.put("chrM", 25);
//			return result;
//		};
//		Supplier<Map<String, Integer>> pathogenicities = () -> {
//			Map<String, Integer> result = new HashMap<>();
//			result.put("benign", 1);
//			result.put("possibly_pathogenic", 2);
//			result.put("probably_pathogenic", 3);
//			result.put("definitely_pathogenic", 4);
//			return result;
//		};
//		Function<String, Short> sv_property = (svp) -> {
//			if (uploadController.sv_property_mapper().containsKey(svp)) {
//				return (short) Arrays.asList("unknown_effect", "missense", "nonsense", "in_frame_indel", "repeat_expansion", "frameshift",
//						"splice_site", "structural_variation", "silent").indexOf(uploadController.sv_property_mapper().get(svp));
//			}
//			return null;
//		};
//		Function<ImmutablePair<String, Integer>, Integer> patho = (p) -> {
//			if (uploadController.patho_mapper().containsKey(p.left)) {
//				skipped.remove("pathogenicity" + p.right);
//				return pathogenicities.get().get(uploadController.patho_mapper().get(p.left));
//			}
//			return null;
//		};
//		public Supplier<Map<String, Integer>> genotypes = () -> {
//			Map<String, Integer> result = new HashMap<>();
//			result.put("hom", 1);
//			result.put("het", 2);
//			result.put("comp_het", 3);
//			return result;
//		};
//		BiFunction<Map<String, Object>, Patient, SequenceVariation> new_sequence_variation = (sv_props, patient) -> {
//			ShortValidator shortV = ShortValidator.getInstance();
//			IntegerValidator integerV = IntegerValidator.getInstance();
//			SequenceVariation s = new SequenceVariation();
//			s.setCreatedAt(new Date());
//			s.setPatient(patient);
//			s.setExacLink(sv_props.get("exac_link") != null ? (Boolean) sv_props.get("exac_link") : false);
//			s.setSporadic((Boolean) sv_props.get("sporadic"));
//			s.setGene((Gene) sv_props.get("gene"));
//			s.setChromosome(shortV.validate(Objects.toString(sv_props.get("chromosome"), null)));
//			s.setImpact(shortV.validate(Objects.toString(sv_props.get("impact"), "0")));
//			s.setGdnaRelated((String) sv_props.get("gdna_related"));
//			s.setCaddScore(MU.bd_or_null.apply((String) sv_props.get("cadd_score")));
//			s.setPositiveEvidence((String) sv_props.get("positive_evidence"));
//			s.setProteinRelated((String) sv_props.get("protein_related"));
//			s.setObserved((String) sv_props.get("observed"));
//			s.setGenotype(shortV.validate(Objects.toString( sv_props.get("genotype"))));
//			s.setReference((String) sv_props.get("reference"));
//			s.setPathogenicity(shortV.validate(Objects.toString( sv_props.get("pathogenicity"), "0"))); //required value 0 - means value is invalid
//			s.setNegativeEvidence((String) sv_props.get("negative_evidence"));
//			s.setNumWithinSpg(shortV.validate(Objects.toString( sv_props.get("num_within_spg"), "1"))); /*default value 1*/
//			s.setCdnaRelated((String) sv_props.get("cdna_related"));
//			s.setAlias((String) sv_props.get("alias"));
//			s.setGenomeBuild((String) sv_props.get("genome_build"));
//			s.setPosition(integerV.validate(Objects.toString(  sv_props.get("position"), null)));
//			s.setHgrb(shortV.validate(Objects.toString( sv_props.get("hgrb"), null)));
//
//			//this part is added for supporting benign variables, and not included into the database
//			s.setNum_index_pat_het_mut(shortV.validate(Objects.toString( sv_props.get("num_index_pat_het_mut"), null))); //required value 0 - means value is invalid
//			s.setNum_index_pat_two_mut(shortV.validate(Objects.toString( sv_props.get("num_index_pat_two_mut"), null))); //required value 0 - means value is invalid
//			s.setNum_fam_with_segregation(shortV.validate(Objects.toString( sv_props.get("num_fam_with_segregation"), null))); //required value 0 - means value is invalid
//			s.setFinal_score(shortV.validate(Objects.toString( sv_props.get("final_score"), null)));
//			return s;
//		};
//
//	}
//
//	public static class SymptomUtils {
//		UploadController uploadController;
//		private Map<String, String> line;
//		private Set<String> skipped;
//
//		public SymptomUtils(UploadController uploadController, Map<String, String> line, Set<String> skipped) {
//			this.uploadController = uploadController;
//			this.line = line;
//			this.skipped = skipped;
//		}
//
//		public PatientsSymptom new_simptom(Map<String, Object> ps_props, Patient patient) {
//			PatientsSymptom patientsSymptom = new PatientsSymptom();
//			patientsSymptom.setCreatedAt(new Date());
//			try {patientsSymptom.setInitial((Boolean)ps_props.get("initial"));} catch (Exception e) {}
//			patientsSymptom.setPatient(patient);
//			try {patientsSymptom.setPresent((Boolean)ps_props.get("present"));} catch (Exception e) {}
//			try {patientsSymptom.setSymptom(uploadController.symptomDAO.findOne((Integer)ps_props.get("symptom_id")));} catch (Exception e) {}
//			return patientsSymptom;
//		}
//	}
//
//	public Map<String, String> other_pxmd_mapper() {
//		Map<String, String> opm = new HashMap<>();
//		opm.put("none", "no_other_pxmd");
//		opm.put("pkd", "pkd");
//		opm.put("pkd/ic", "pkd_ic");
//		opm.put("pnkd", "pnkd");
//		opm.put("ped", "ped");
//		return opm;
//	}
//
//	public Map<String, Boolean> yes_no_mapper() {
//		Map<String, Boolean> yn = new HashMap<>();
//		yn.put("yes", true);
//		yn.put("no", false);
//		return yn;
//	}
//
//	public Map<String, String> lr_mapper() {
//		Map<String, String> mapper = new HashMap<>();
//		mapper.put("not treated", "not_treated_with_levodopa");
//		mapper.put("no", "no_levodopa_response");
//		return mapper;
//	}
//
//	public Map<String, String> rq_mapper() {
//		Map<String, String> mapper = new HashMap<>();
//		mapper.put("minimal/intermittent", "minimal_levodopa_response");
//		mapper.put("moderate", "moderate_levodopa_response");
//		mapper.put("good/excellent", "good_levodopa_response");
//		return mapper;
//	}
//
//	public Map<String, String> status_clinical_mapper() {
//		Map<String, String> sc = new HashMap<>();
//		sc.put("clinically affected", "clinical_status_affected");
//		sc.put("clinically unaffected", "clinical_status_unaffected");
//		sc.put("clinically uncertain", "clinical_status_uncertain");
//		return sc;
//	}
//
//	public Map<String, String> status_parac_mapper() {
//		Map<String, String> sp = new HashMap<>();
//		sp.put("paraclinically affected", "paraclinical_status_affected");
//		sp.put("paraclinically unaffected", "paraclinical_status_unaffected");
//		sp.put("paraclinically uncertain", "paraclinical_status_uncertain");
//		return sp;
//	}
//
//	public Map<String, String> sv_property_mapper() {
//		Map<String, String> svp = new HashMap<>();
//		svp.put("missense", "missense");
//		svp.put("nonsense", "nonsense");
//		svp.put("in-frame indel", "in_frame_indel");
//		svp.put("repeat expansion", "repeat_expansion");
//		svp.put("frameshift", "frameshift");
//		svp.put("splice site", "splice_site");
//		svp.put("structural variation", "structural_variation");
//		svp.put("silent", "silent");
//		svp.put("unknown effect", "unknown_effect");
//		return svp;
//	}
//
//	public Map<String, String> patho_mapper() {
//		Map<String, String> patho = new HashMap<>();
//		patho.put("benign", "benign");
//		patho.put("possibly pathogenic", "possibly_pathogenic");
//		patho.put("probably pathogenic", "probably_pathogenic");
//		patho.put("definitely pathogenic", "definitely_pathogenic");
//		return patho;
//	}
//
//	public static class UploadResult {
//		boolean success = true;
//		Set<String> skipped_cells = new HashSet<>();
//		List<String> issues = new ArrayList<>();
//		List<String> required = new ArrayList<>();
//		public String conclusion;
//	}
//
//	class RollbackDBChangesException extends Exception
//	{
//		// Parameterless Constructor
//		public RollbackDBChangesException() {}
//
//		// Constructor that accepts a message
//		public RollbackDBChangesException(String message)
//		{
//			super(message);
//		}
//	}
//
//	public static class MyHashMap<K,V> extends HashMap<K,V> {
//
////		@Override
////		public V get(Object key) {
////			return super.getOrDefault(key, (V)"");
////		}
//
//	}
//
//	@PostMapping("/upload") // //new annotation since 4.3
//	public String file_import(@RequestParam("file") MultipartFile file,
//							  RedirectAttributes redirectAttributes) {
//		try {
//			return file_import_in_transaction(file, redirectAttributes);
//		} catch (RollbackDBChangesException e) {
//			return "redirect:uploadStatus";
//		}
//	}
//
//	@Transactional
//	String file_import_in_transaction(MultipartFile file, RedirectAttributes redirectAttributes) throws RollbackDBChangesException {
//
//		FileUploadUtils file_upload_utils = new FileUploadUtils(redirectAttributes);
//		if (!file_upload_utils.valid.test(file)) return "redirect:uploadStatus"; FileUpload file_upload = file_upload_utils.initialize.apply(file);
//		if (!file_upload_utils.check_encoding.test(file)) return "redirect:uploadStatus";
//
//		List<String> headers = file_upload_utils.raw_headers.apply(file);
//		List<String> check_headers = FileUploadUtils.required.stream().filter(x -> !headers.contains(x)).collect(Collectors.toList());
//		if (!check_headers.isEmpty()) {
//			file_upload_utils.result.conclusion = "At least one required column is missing, the missing columns are : " +
//					check_headers.stream().collect(Collectors.joining(", "));
//			file_upload_utils.result.required = FileUploadUtils.required; redirectAttributes.addFlashAttribute("message", file_upload_utils.result.conclusion);
//			return "redirect:uploadStatus";
//		}
//
//		Iterable<Symptom> available_symptoms = symptomDAO.findAll();
//		int[] line_no = new int[1]; line_no[0] = 0;
//		int[] inserted_patients_no = new int[1];
//
//		file_upload_utils.csv_foreach.apply(file).forEach(row -> { //if (!file_upload_utils.result.success) return;
//			try {
//			long timeInMillis = Calendar.getInstance().getTimeInMillis();
//
//			line_no[0] += 1;
//			boolean fields_compact_empty = row.stream().filter(x -> x.getValue() != null).map(x -> x.getValue().trim()).collect(Collectors.joining("")).isEmpty(); if (fields_compact_empty) return;
//
//			row = row.stream().filter(x -> !(StringUtils.isBlank(x.getValue()) || StringUtils.isBlank(x.getKey()) || Pattern.compile("(?i)^\\s*(n\\.a\\.|-99(\\.0+)?)\\s*$").matcher(x.getValue()).matches())).collect(Collectors.toList()); //# matches N.A. and -99)
//
//			Map<String, String> line = new MyHashMap(); row.stream().forEach(x -> line.put(x.getKey(), x.getValue() != null ?  x.getValue().trim() : x.getValue()));
//			if (!line.get("mdsgene_decision").equalsIgnoreCase("in")) return; // required field
//			System.out.println("####################################line " + line_no[0]);
//
//			//iz, sobald Patienten nicht mehr mehrfach gespeichert werden, kann hier einfach die Zeile geskippt werden
//			if (!FileUploadUtils.required.stream().filter(x -> !line.keySet().contains(x)).collect(Collectors.toList()).isEmpty()) {
//				file_upload_utils.result.success = false;
//				file_upload_utils.result.conclusion += "At least one required values(\"pmid\", \"disease_abbrev\", \"individual_id\", \"mdsgene_decision\", \"family_id\", \"index_pat\") is missing in Line " + line_no[0] + ". Missing : " + FileUploadUtils.required.stream().filter(x -> !line.keySet().contains(x)).collect(Collectors.joining(",")) + lineSeparator;
//				file_upload_utils.result.required.add(FileUploadUtils.required.stream().collect(Collectors.joining(","))); redirectAttributes.addFlashAttribute("message", file_upload_utils.result.conclusion);
//				return;
//			}
//			Set<String> skipped = line.keySet().stream().collect(Collectors.toSet());
//			skipped.remove("mdsgene_decision");
//			skipped.remove("individual_id");
//			skipped.remove("disease_abbrev");
//			skipped.remove("pmid");
//			skipped.remove("family_id");
//			skipped.remove("index_pat");
//
//			StudyUtils study_utils = new StudyUtils(this, line, skipped, authorDAO, authorGroupDAO);
//			Study study = study_utils.get_study.get();
//
//			PatientUtils patient_utils = new PatientUtils(this, line, skipped); Patient patient = patient_utils.new_patient.apply(file_upload, line_no[0]);
//			patient.setStudy(study); Patient last_patient = patient;
//
//			FamilyUtils family_utils = new FamilyUtils(this, line, skipped);  patient.setFamily(family_utils.get_family.apply(line_no[0]));
//			retrieve_info_from_excel_file(line, skipped, study, patient_utils, patient, true);
//			boolean no_initial_left = false;
//			int[] sc_count = new int[1];  sc_count[0] = 1;
//			Map<Integer, Object >initials = new MyHashMap<>();
//
//			while (line.containsKey("initial_sympt" + sc_count[0])) {
//				// get id of the symptom, if it is HP symptom, then will be gotten full name otherwise, will be added '_sympt' after the name of the symptom
//				int sympt_id = symptomDAO.findAll().stream().filter(x -> StringUtils.startsWithIgnoreCase(x.getImportHeader(), line.get("initial_sympt" + sc_count[0]) + "_hp:") /*this part should be changed so you need to put exact the name tremor_HP:12345*/ || x.getImportHeader().equalsIgnoreCase(line.get("initial_sympt" + sc_count[0]) + "_sympt")).map(x -> x.getId()).findFirst().orElse(0);
//				initials.put(sympt_id, sc_count[0]);
//				sc_count[0] += 1;
//			}
//
//			available_symptoms.forEach((sympt) -> {
//				String lowerCaseHeader = StringUtils.lowerCase(sympt.getImportHeader()); if (line.containsKey(lowerCaseHeader)) { //because all headers are converted to the lower case
//					Map<String, Object> ps_props = new MyHashMap<>(); ps_props.put("symptom_id", sympt.getId() );
//					String val = StringUtils.lowerCase(line.get(lowerCaseHeader));
//					if (this.yes_no_mapper().containsKey(val)) {
//						skipped.remove(lowerCaseHeader);
//						ps_props.put("present", this.yes_no_mapper().get(val));
//					}
//					if ("yes".equals(val) && initials.keySet().contains(sympt.getId())) {
//						skipped.remove("initial_sympt" + initials.get(sympt.getId()));
//						ps_props.put("initial", true);
//					} SymptomUtils simptom_utils = new SymptomUtils(this, line, skipped);
//					patient.getPatientsSymptoms().add(simptom_utils.new_simptom(ps_props, patient));
//				}
//			});
//
//			inserted_patients_no[0] += 1; // only correct without rollback
//			boolean validate = false;
//			if (study_utils.save(study, false)) {
//				try {
//					patient.getFamily().setUpdatedAt(new Date()); familyDAO.save(patient.getFamily());
//					patient.getDisease().setUpdatedAt(new Date()); diseaseDAO.save(patient.getDisease());
//					file_upload.setUpdatedAt(new Date()); fileUploadDAO.save(file_upload);
//					study.setUpdatedAt(new Date()); studyDAO.save(study);
//					patient.setUpdatedAt(new Date()); patientDAO.save(patient);
//					patient.getPatientsSymptoms().forEach((ps) -> { ps.setUpdatedAt(new Date()); patientsSymptomDAO.save(ps);});
//					last_patient.getSequenceVariations().forEach((sv) -> { sv.setUpdatedAt(new Date()); geneDAO.save(sv.getGene()); });
//					patient.getSequenceVariations().forEach((sv) -> { sv.setUpdatedAt(new Date()); sequenceVariationDAO.save(sv); });
//				} catch (Exception ex) {
//					validate = true;
//				}
//			}
//			if (!validate) {
//				file_upload_utils.result.skipped_cells.addAll(patient_utils.get_skipped.apply(ImmutablePair.of(patient, line)));
//			} else {
//				study_utils.save(study, true);
//				file_upload_utils.result.success = false;
//				file_upload_utils.result.conclusion = "These issues prevented the data from being saved:";
//				study_utils.add_errors(line_no[0], study);file_upload_utils.result.conclusion += ("Study: " + study_utils.errors.toString()) + lineSeparator;
//				study_utils.add_errors(line_no[0], patient);file_upload_utils.result.conclusion += ("Patient: " + study_utils.errors.toString()) + lineSeparator;
//				study_utils.add_errors(line_no[0], patient.getFamily());file_upload_utils.result.conclusion += ("Family: " + study_utils.errors.toString()) + lineSeparator;
//				study_utils.add_errors(line_no[0], patient.getDisease());file_upload_utils.result.conclusion += ("Disease: " + study_utils.errors.toString()) + lineSeparator;
//				patient.getPatientsSymptoms().forEach((ps) -> {study_utils.add_errors(line_no[0], ps);});file_upload_utils.result.conclusion += ("PatientsSymptoms : " + study_utils.errors.toString()) + lineSeparator;
//				patient.getSequenceVariations().forEach((sv) -> {study_utils.add_errors(line_no[0], sv);});file_upload_utils.result.conclusion += ("SequenceVariations : " + study_utils.errors.toString()) + lineSeparator;
//				last_patient.getSequenceVariations().forEach((sv) -> {
//					study_utils.add_errors(line_no[0], sv.getGene());file_upload_utils.result.conclusion += ("Gene : " + study_utils.errors.toString()) + lineSeparator;
//				});
//			}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				file_upload_utils.result.conclusion += "May be invalid line : " + line_no[0];
//				//System.out.println("Can't import line : " + line_no[0]);
//			}
//		});
//
//		if (!file_upload_utils.result.success) {
//			redirectAttributes.addFlashAttribute("message", file_upload_utils.result.conclusion.split(lineSeparator));
//			return "redirect:/uploadStatus";
//			//throw new RollbackDBChangesException(file_upload_utils.result.conclusion);
//		}
//
//		if (!file_upload_utils.result.success) {
//
//		}
//		fileUploadDAO.save(file_upload);
//		file_upload_utils.result.success = true;
//		file_upload_utils.result.conclusion = "Success! Number of imported patients: #{inserted_patients_no}";
///*
//		if (file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//			return "redirect:uploadStatus";
//		}
//
//		try {
//
//			// Get the file and save it somewhere
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getName());
//			Files.write(path, bytes);
//
//			redirectAttributes.addFlashAttribute("message",
//					"You successfully uploaded '" + file.getName() + "'");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//*/
//		return "redirect:/uploadStatus";
//	}
//
//	private void retrieve_info_from_excel_file(Map<String, String> line, Set<String> skipped, Study study,
//			PatientUtils patient_utils, Patient patient, boolean check_required_fields) {
//		patient.setSex(patient_utils.get_sex.apply(line.get("sex")));
//
//		patient.setClinicalInfo(patient_utils.clinical_info.apply(StringUtils.lowerCase(line.get("clinical_info")))); //this method should be added = clinical_info(line[:clinical_info]&.downcase)
//		patient.setStatusParaclinical(patient_utils.status_parac.apply(StringUtils.lowerCase(line.get("status_paraclinical")))); //status_paraclinical = status_parac(line[:status_paraclinical]&.downcase)
//		patient.setStatusClinical(patient_utils.status_clinical.apply(StringUtils.lowerCase(line.get("status_clinical"))));
//		patient.setEthnicity(patient_utils.get_ethnicity.apply(StringUtils.lowerCase(line.get("ethnicity"))));
//		if (line.containsKey("levodopa_response")) patient.setLevodopaResponse(patient_utils.get_levodopa.apply(line));
//		patient.setOtherPxmd(patient_utils.other_pxmd.apply(StringUtils.lowerCase(line.get("presence_of_other_pxmd")))); DiseaseUtils disease_utils = new DiseaseUtils(this, line, skipped);
//		patient.setDisease(disease_utils.find_or_initialize_by.apply(line.get("disease_abbrev"))); //required field
//		patient.setIndividualIdentity(line.get("individual_id")); //# required field
//		patient.setAgeAtOnset(MU.bd_or_null.apply(line.get("aao")));
//		patient.setAgeAtExam(MU.bd_or_null.apply(line.get("aae")));
//		patient.setComment(line.get("comments_pat"));
//		patient.setAgeAtRem(MU.bd_or_null.apply(line.get("age_rem")));
//		patient.setAaoClinical(MU.bd_or_null.apply(line.get("aao_clinical")));
//		patient.setAaoParaclinical(MU.bd_or_null.apply(line.get("aao_paraclinical")));
//		patient.setDiseaseDuration(MU.bd_or_null.apply(line.get("duration")));
//		patient.setAgeAtDiagnosis(MU.bd_or_null.apply(line.get("age_dx")));
//		patient.setAgeAtDeath(MU.bd_or_null.apply(line.get("age_death")));
//
//		patient.setGnomAD(line.get("exac, dbsnp"));
//
//		patient.setCountry(patient_utils.countries(StringUtils.upperCase(line.get("country"))));
//		try {
//			patient.setIndexPatient(yes_no_mapper().get(StringUtils.lowerCase(line.get("index_pat")))); //#required field
//		} catch (Exception e) {
//			if(check_required_fields) throw e;
//		}
//		//file_upload_utils.debug(patient.getDisease(), patient.getFamily(), patient);
//		study.getPatients().add(patient);
//		boolean no_sv_left = false;
//		int[] sv_count = new int[1];
//		while(!no_sv_left) {
//			sv_count[0] += 1;
//			Map<String, Object> sv_props = new MyHashMap<>();
//
//			if (line.containsKey("hg_version")) sv_props.put("hgrb", NumberUtils.toInt(line.get("hg_version")));
//			sv_props.put("genome_build", line.get("genome_build"));
//
//			if (line.containsKey("gene" + sv_count[0])) {
//				skipped.remove("gene" + sv_count[0]);
//				Stream relation = geneAliasDAO.findAll().stream().filter(x -> line.get("gene" + sv_count[0]).equals(x.getSynonym()));
//				GeneUtils gene_utils = new GeneUtils(this, line, skipped);
//				sv_props.put("gene", relation.count() > 0 ? relation.findFirst().get() : gene_utils.find_or_initialize_by.apply(line.get("gene" + sv_count[0])));
//			}
//			SequenceVariationUtils sequence_variation_utils = new SequenceVariationUtils(this, line, skipped);
//
//			if (line.containsKey("physical_location" + sv_count[0])) {
//				String[] _temp = line.get("physical_location" + sv_count[0]).toLowerCase().split(":");
//				if (_temp.length == 2 && ((Supplier<Boolean>) (() -> {
//					List<String> sv = sequence_variation_utils.chromosomes.get().values().stream().map(x -> String.valueOf(x)).collect(Collectors.toList());
//					sv.addAll(Arrays.asList("x", "y", "m", "mt"));
//					return sv.contains(_temp[0]);
//				})).get()) {
//					skipped.remove("physical_location" + sv_count[0]);
//					sv_props.put("position", _temp[1]);
//					switch (_temp[0]) {
//						case "x":
//							sv_props.put("chromosome", sequence_variation_utils.chromosomes.get().get("chrX"));
//							break;
//						case "y":
//							sv_props.put("chromosome", sequence_variation_utils.chromosomes.get().get("chrY"));
//							break;
//						case "m":
//						case "mt":
//							sv_props.put("chromosome", sequence_variation_utils.chromosomes.get().get("chrM"));
//							break;
//						default:
//							sv_props.put("chromosome", _temp[0]);
//					}
//				}
//			}
//
//			try {
//				sv_props.put("impact", sequence_variation_utils.sv_property.apply(StringUtils.lowerCase(line.get("mut" + sv_count[0] + "_type")))); // required field in SequenceVariation
//				sv_props.put("pathogenicity", sequence_variation_utils.patho.apply(ImmutablePair.of(StringUtils.lowerCase(line.get("pathogenicity"+sv_count[0])), sv_count[0]))); // required field in SequenceVariation
//			} catch (Exception e) {
//				if(check_required_fields) throw e;
//			}
//			sv_props.put("exac_link", this.yes_no_mapper().get(StringUtils.lowerCase(line.get("exac_" + sv_count[0]))));
//			sv_props.put("reference", line.get("reference_allele" + sv_count[0]));
//			sv_props.put("observed", line.get("observed_allele" + sv_count[0]));
//			sv_props.put("gdna_related", line.get("mut" + sv_count[0] + "_g"));
//			sv_props.put("cdna_related", line.get("mut" + sv_count[0] + "_c"));
//			sv_props.put("protein_related", line.get("mut" + sv_count[0] + "_p"));
//			sv_props.put("alias", line.get("mut" + sv_count[0] + "_alias"));
//			sv_props.put("sporadic", this.yes_no_mapper().get(StringUtils.lowerCase(line.get("mut" + sv_count[0] + "_sporadic"))));
//			sv_props.put("cadd_score", line.get("cadd_" + sv_count[0]));
//			sv_props.put("positive_evidence", line.get("fun_evidence_pos_" + sv_count[0]));
//			sv_props.put("negative_evidence", line.get("fun_evidence_neg_" + sv_count[0]));
//
//			//added 27.03.2019 by request from Katja Lohman
//			sv_props.put("num_fam_with_segregation", line.get("num_fam_with_segregation" + sv_count[0]));
//			sv_props.put("num_index_pat_het_mut", line.get("num_index_pat_het_mut" + sv_count[0]));
//			sv_props.put("num_index_pat_two_mut", line.get("num_index_pat_two_mut" + sv_count[0]));
//			sv_props.put("final_score", line.get("final_score" + sv_count[0]));
//
//			String genotype = StringUtils.lowerCase(line.get("mut" + sv_count[0] + "_genotype"));
//			if (Arrays.asList("hom", "het").contains(genotype)) {
//				sv_props.put("genotype", sequence_variation_utils.genotypes.get().get(genotype));
//			}
//
//			// Do not process a variant for which only pathogenicity and exac_link specified.
//			List<String> test = sv_props.entrySet().stream().filter(x -> x.getValue() != null).map(x -> x.getKey()).collect(Collectors.toList());
//			if (Arrays.asList("hgrb", "genome_build", "pathogenicity", "exac_link").containsAll(test)) {
//				no_sv_left = true;
//				sv_count[0] -= 1;
//			} else {
//				sv_props.put("num_within_spg", sv_count[0]);
//				patient.getSequenceVariations().add(sequence_variation_utils.new_sequence_variation.apply(sv_props, patient));
//			}
//		}
//
//		// If a patient has more than one het-mutation on the same gene,then they all become compound heterozygous. See issue #43.
//		patient.getSequenceVariations().stream().filter((sv) -> sv.getGenotype() == SequenceVariationValidator.genotype.het.getGenotype()).
//				sorted((sv_pair_0,sv_pair_1) -> { //sorted used here only to get a combination of genes
//					if (sv_pair_0.getGene() != null && sv_pair_0.getGene().getId() == sv_pair_1.getGene().getId()) {
//						sv_pair_0.setGenotype((short)SequenceVariationValidator.genotype.comp_het.getGenotype());
//					}
//					return 0;
//					//return sv_pair_0.getGenotype().compareTo(sv_pair_1.getGenotype());
//				});
//	}
//
//	/**
//	 *
//	 * @param merge_to - merge to parameter, which is containing in the left part fields which should be merged, in the right part fields to which should be written merge result
//	 * @param processName TODO
//	 * @param file - file to merge
//	 * @return
//	 */
//	public List<String> process_tsv(File folder_or_file, Pair<String[], String[]> merge_to, String command, int mode, String processName) {
//		File[] filesList = null;
//		List<String> _errors = new ArrayList<String>();
//		if (mode == 1) { //db
//			List<FileUpload> findAll = fileUploadDAO.findAll();
//			filesList = findAll.stream().map(_f -> new File(EXCEL_FILES_FOLDER + _f.getTsvFileFileName())).collect(Collectors.toList()).toArray(new File[0]);
//		} if (mode == 0) { //test
//			// for tests
//			filesList = folder_or_file.listFiles();
//		} if (mode == 2) { //protect move
//			filesList = new File[] {folder_or_file};
//		}
//		for (File file : filesList) {
////			if (!"C:\\db_backup\\csv_test folder\\merge_csv\\SLC6A3_2018_09_18_SS.txt".equals(file.getAbsolutePath())) {
////				System.out.println("here");
////				continue;
////			}
//			if (!file.exists()) {
//				System.out.println("Missing file: " + file.getAbsolutePath());
//			}
//			ImmutablePair<TsvParser,RowListProcessor> t = new FileUploadUtils(new RedirectAttributesModelMap()).tsv_open.apply(null);
//			try {
//				//parse CSV file
//				TsvParser parser = t.left;
//				RowListProcessor rowProcessor = t.right;
//				parser.parse(new FileInputStream(file));
//
//				//create list of lines (each of list contains header and value of the line)
//				String[] headers = rowProcessor.getHeaders();
//				Stream<List<DefaultMapEntry<String,String>>> map = rowProcessor.getRows().stream().map(row -> IntStream.range(0, row.length).filter(i -> !StringUtils.isEmpty(row[0])).mapToObj(i -> {
//					return new DefaultMapEntry<String,String>(StringUtils.lowerCase(headers[i]), row[i]);
//
//				}).collect(Collectors.toList()));
//
//				Consumer<? super List<DefaultMapEntry<String, String>>> parisng_action = null;
//
//				if ("s2de".equals(processName)) {
//					TsvWriterSettings settings = new TsvWriterSettings(); //many options here. Check the documentation
//					//settings.getFormat().setDelimiter('\t');
//					TsvWriter writer = new TsvWriter(new FileWriter(file), settings);
//					map.forEach(merge_excel_files(merge_to, command, writer));
//					writer.flush();
//					writer.close();
//				} else if ("benign list".equals(processName)) {
//					HashMap<String, TsvWriter> gene_files_map = new HashMap<String, TsvWriter>();
//					map.forEach(benign_list(new MultipartFile(file.getAbsolutePath()), gene_files_map));
//					//close files
//					gene_files_map.values().stream().forEach(_writer -> {_writer.flush();_writer.close();});
//				} else if ("protect move data".equals(processName)) {
//					TsvWriterSettings settings = new TsvWriterSettings(); //many options here. Check the documentation
//					//settings.getFormat().setDelimiter('\t');
//					TsvWriter writer = new TsvWriter(new FileWriter(file), settings);
//					map.forEach(merge_protect_move_data_file(writer));
//					writer.flush();
//					writer.close();
//				}
//
//			} catch (FileNotFoundException e) {
//				_errors.add("Can't " + command + " excel file " + file.getName());
//			} catch (NullPointerException e) {
////				e.printStackTrace();
//			//	if (!Objects.isNull(e)) LOGGER.error(e.getMessage());
//			} catch (Exception e) {
//				System.out.println(file.getAbsolutePath() + " can't parse.");
//				e.printStackTrace();
//			}
//		}
//		return _errors;
//	}
//
//	private Stream<List<DefaultMapEntry<String, String>>> readSampleTsvFile() throws Exception {
//		try {
//			FileInputStream fileInputStream = new FileInputStream(new File(sampleTsvFilePath));
//			ImmutablePair<TsvParser,RowListProcessor> t = new FileUploadUtils(new RedirectAttributesModelMap()).tsv_open.apply(null);
//			//parse CSV file
//			TsvParser parser = t.left;
//			RowListProcessor rowProcessor = t.right;
//			parser.parse(fileInputStream);
//
//			//create list of lines (each of list contains header and value of the line)
//			String[] headers = rowProcessor.getHeaders();
//			Stream<List<DefaultMapEntry<String,String>>> map = rowProcessor.getRows().stream().map(row -> IntStream.range(0, row.length).filter(i -> !StringUtils.isEmpty(row[0])).mapToObj(i -> {
//				return new DefaultMapEntry<String,String>(StringUtils.lowerCase(headers[i]), row[i]);
//
//			}).collect(Collectors.toList()));
//			return map;
//		} catch(Exception ex) {
//			throw ex;
//		}
//	}
//
//	private Consumer<? super List<DefaultMapEntry<String, String>>> merge_protect_move_data_file(TsvWriter writer) throws Exception {
//
//		// first of all read the information from the sample file and get line which is acceptable
//		// by mdsngene for import.
//		List<String> _headers_template = new ArrayList<String>();
//		List<String> _rows_template = new ArrayList<String>();
//		Set<String> _pm_variables = new HashSet<>();
//		_pm_variables.addAll(list_of_protected_move_variables());
//		readSampleTsvFile().findFirst().get().forEach(_sample_line -> {
//			//exclude the mandatory fields of the protect move data
//			_headers_template.add(_sample_line.getKey());
//			_rows_template.add(_sample_line.getValue());
//		});
//
//		// use this
//		boolean[] _write_headers = new boolean[1]; _write_headers[0] = true;
//		Consumer<? super List<DefaultMapEntry<String, String>>> parisng_action = _line -> {
//			if (_line == null) return;
//			try {
//				List<String> _headers = new ArrayList<String>();
//				List<String> _row = new ArrayList<String>();
//
//				_line.stream().forEach(_l -> {
//					if (_l == null || _l.getKey() == null) return;
//					_headers.add(_l.getKey());
//					_row.add(_l.getValue());
//				});
//
//				for (int i = 0; i < _headers_template.size(); i++) {
//					if(_headers.contains(_headers_template.get(i))) continue;
//					_headers.add(_headers_template.get(i));
//					_row.add(_rows_template.get(i));
//				}
//				if(_write_headers[0]) {
//					writer.writeHeaders(_headers);
//					_write_headers[0] = false;
//				}
//				writer.writeRow(_row);
//			} catch (Exception e) {
//				throw e;
//			}
//		};
//		return parisng_action;
//	}
//
//	/**
//	 * @return
//	 */
//	private List<String> list_of_protected_move_variables() {
//		return Arrays.asList(
//				"hg_version1",
//				"transcriptid1_ensembl",
//				"transcriptid1_ncbi",
//				"gene1",
//				"physical_location1",
//				"reference_allele1",
//				"observed_allele1",
//				"mut1_g",
//				"mut1_c",
//				"mut1_p",
//				"mut1_alias_original",
//				"mut1_alias",
//				"patient_genotype",
//				"mut1_genotype",
//				"mut1_type",
//				"mut1_de novo",
//				"gnomad1",
//				"rs_no1",
//				"pathoscore1",
//				"hg_version2",
//				"transcriptid2_ensembl",
//				"transcriptid2_ncbi",
//				"gene2",
//				"physical_location2",
//				"reference_allele2",
//				"observed_allele2",
//				"mut2_g",
//				"mut2_c",
//				"mut2_p",
//				"mut2_alias_original",
//				"mut2_alias",
//				"mut2_genotype",
//				"mut2_type",
//				"mut2_de_novo",
//				"gnomad2",
//				"rs_no2",
//				"pathoscore2",
//				"hg_version3",
//				"transcriptid3_ensembl",
//				"transcriptid3_ncbi",
//				"gene3",
//				"physical_location3",
//				"reference_allele3",
//				"observed_allele3",
//				"mut3_g",
//				"mut3_c",
//				"mut3_p",
//				"mut3_alias",
//				"mut3_genotype",
//				"mut3_type",
//				"mut3_de_novo",
//				"gnomad2",
//				"rs_no3",
//				"pathoscore3",
//				"comments_genetics",
//				"family_history",
//				"family_members_previously_collected",
//				"affected_family_members_with_mutation",
//				"affected_family_members_without_mutation",
//				"unaffected_family_members_with_mutation",
//				"unaffected_family_members_without_mutation",
//				"re-contact_to_family_possible",
//				"last_contact_to_family"
//				);
//	}
//
//	public Consumer<? super List<DefaultMapEntry<String, String>>> merge_excel_files(Pair<String[], String[]> merge_to,
//			String command, TsvWriter writer) {
//		//write updated headers to file
//		List<String> _headers = new ArrayList<String>();
//		boolean[] _write_headers = new boolean[1]; _write_headers[0] = true;
//
//		Consumer<? super List<DefaultMapEntry<String, String>>> parisng_action = _line -> {
//			if (_line == null) return;
//			String[] presents = new String[1];
//			boolean[] merge_to_column_exists = new boolean[1];
//			List<String> _row = new ArrayList<String>();
//
//			if ("merge".equals(command) || "delete".equals(command)) {
//				_line.stream().forEach(_l -> {
//					if (_l.getKey() == null) return;
//					//find initial symptoms
//					if(_l.getKey().startsWith("initial_sympt")) {
//						for(String s : merge_to.getLeft()) {
//							if (s == null) continue;
//							//replace with the symptom for merge
//							Predicate<String> _is_symptom_for_merge = x -> x.equalsIgnoreCase(_l.getValue() + "_sympt") || StringUtils.startsWithIgnoreCase(x, _l.getValue() + "_hp:") /*this part should be changed so you need to put exact the name tremor_HP:12345*/ || x.equalsIgnoreCase(_l.getValue());
//							if (_is_symptom_for_merge.test(s)) {
//								_l.setValue(Optional.ofNullable(merge_to.getRight()[0]).orElse(""));
//								break;
//							}
//						}
//					}
//					//merge values for the columns to the single one
//					if ("merge".equals(command) && merge_to.getLeft() != null && Arrays.asList(merge_to.getLeft()).stream().filter(x -> x.equalsIgnoreCase(_l.getKey())).findFirst().isPresent()) {
//						String _a = _l.getValue();
//						presents[0] = presents[0] == null ? _a : ("no".equals(presents[0]) && "yes".equals(_a) ? _a : presents[0]);
//					}
//
//					if ("merge".equals(command) && merge_to.getRight() != null && Arrays.asList(merge_to.getRight()).stream().filter(x -> x.equalsIgnoreCase(_l.getKey())).findFirst().isPresent()) {
//						String _a = _l.getValue();
//						presents[0] = presents[0] == null ? _a : ("no".equals(presents[0]) && "yes".equals(_a) ? _a : presents[0]);
//						merge_to_column_exists[0] = true;
//					}
//				});
//				_line.stream().forEach(_l -> {
//					if (_l == null || _l.getKey() == null) return;
//					//merge columns to single one
//					if("merge".equals(command) && _l.getKey().startsWith(merge_to.getRight()[0])) {
//						_l.setValue(presents[0] == null ? "-99" : presents[0]);
//					}
//
//					//delete merged columns
//					if (merge_to.getLeft() != null && !Arrays.asList(merge_to.getLeft()).stream().filter(x -> x.equalsIgnoreCase(_l.getKey())).findFirst().isPresent()) {
//						if(_write_headers[0]) _headers.add(_l.getKey());
//						_row.add(Optional.ofNullable(_l.getValue()).orElse(""));
//					} else if (merge_to.getLeft() != null && !merge_to_column_exists[0] &&
//							   Arrays.asList(merge_to.getLeft()).stream().filter(x -> x.equalsIgnoreCase(_l.getKey())).findFirst().isPresent()) {
//						//replace the first column if target column is not exist it will be created
//						if(_write_headers[0]) _headers.add(merge_to.getRight()[0]);
//						_row.add(presents[0] == null ? "-99" : presents[0]);
//						merge_to_column_exists[0] = true;
//					}
//				});
//			} else if("rename".equals(command)) {
//				_line.stream().forEach(_l -> {
//					if (_l == null || _l.getKey() == null) return;
//
//					//find initial symptoms and rename
//					if(_l.getKey().startsWith("initial_sympt")) {
//						String[] left = merge_to.getLeft();
//						String[] right = merge_to.getRight();
//
//						for (int i = 0; i < left.length; i++) {
//							String s = left[i];
//							if (s == null) continue;
//							//replace with the symptom for merge
//							Predicate<String> _is_symptom_for_merge = x -> x.equalsIgnoreCase(_l.getValue() + "_sympt") || StringUtils.startsWithIgnoreCase(x, _l.getValue() + "_hp:") /*this part should be changed so you need to put exact the name tremor_HP:12345*/ || x.equalsIgnoreCase(_l.getValue());
//							if (_is_symptom_for_merge.test(s)) {
//								_l.setValue(Optional.ofNullable(right[i]).orElse(""));
//								break;
//							}
//						}
//					}
//
//					//rename this part will keep the values unchanged
//					if(_write_headers[0]) {
//						String[] left = merge_to.getLeft();
//						String[] right = merge_to.getRight();
//						String rename_to  = null;
//						for (int i = 0; i < left.length; i++) {
//							rename_to = _l.getKey().equalsIgnoreCase(left[i]) ? right[i] : null;
//							if (rename_to != null) break;
//						}
//						_headers.add(rename_to == null ? _l.getKey() : rename_to);
//					}
//
//					_row.add(Optional.ofNullable(_l.getValue()).orElse(""));
//				});
//			}
//			if(_write_headers[0]) {
//				writer.writeHeaders(_headers);
//				_write_headers[0] = false;
//			}
//			writer.writeRow(_row);
//		};
//		return parisng_action;
//	}
//
//	static IntStream revRange(int from, int to) {
//	    return IntStream.range(from, to).map(i -> to - i + from - 1);
//	}
//
//	private Consumer<? super List<DefaultMapEntry<String, String>>> benign_list(MultipartFile file, Map<String, TsvWriter> gene_files_map) {
//		RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
//		FileUploadUtils file_upload_utils = new FileUploadUtils(redirectAttributes);
//		if (!file_upload_utils.valid.test(file)) return null; FileUpload file_upload = file_upload_utils.initialize.apply(file);
//		if (!file_upload_utils.check_encoding.test(file)) return null;
//
//		List<String> headers = file_upload_utils.raw_headers.apply(file);
//		List<String> check_headers = FileUploadUtils.required.stream().filter(x -> !headers.contains(x)).collect(Collectors.toList());
//		if (!check_headers.isEmpty()) {
//			file_upload_utils.result.conclusion = "At least one required column is missing, the missing columns are : " +
//					check_headers.stream().collect(Collectors.joining(", "));
//			file_upload_utils.result.required = FileUploadUtils.required; redirectAttributes.addFlashAttribute("message", file_upload_utils.result.conclusion);
//			return null;
//		}
//
//		Iterable<Symptom> available_symptoms = symptomDAO.findAll();
//		int[] line_no = new int[1]; line_no[0] = 0;
//		int[] inserted_patients_no = new int[1];
//		List<?>[] _last_row = new List<?>[1];
//
//		Consumer<? super List<DefaultMapEntry<String, String>>> parisng_action = row -> {
//			if (row == null) return;
//			long timeInMillis = Calendar.getInstance().getTimeInMillis();
//
//			line_no[0] += 1;
//			boolean fields_compact_empty = row.stream().filter(x -> x.getValue() != null).map(x -> x.getValue().trim()).collect(Collectors.joining("")).isEmpty(); if (fields_compact_empty) return;
//
//			//row = row.stream().filter(x -> !(StringUtils.isBlank(x.getValue()) || StringUtils.isBlank(x.getKey()) || Pattern.compile("(?i)^\\s*(n\\.a\\.|-99(\\.0+)?)\\s*$").matcher(x.getValue()).matches())).collect(Collectors.toList()); //# matches N.A. and -99)
//			Map<String, String> line = new MyHashMap<>();
//			//this changed to support the case if some column name will be repeated the first one will have a priority
//			revRange(0, row.size()).forEach(_index -> {
//				DefaultMapEntry<String, String> x = row.get(_index);
//				line.put(x.getKey(), x.getValue() != null ?  x.getValue().trim() : x.getValue());
//			});
//
////			row.stream().forEach(x -> {
////				line.put(x.getKey(), x.getValue() != null ?  x.getValue().trim() : x.getValue());
////			});
//			if ("in".equalsIgnoreCase(line.get("mdsgene_decision"))) return; // exclude lines imported to the database
////			System.out.println("####################################line " + line_no[0]);
//			//iz, sobald Patienten nicht mehr mehrfach gespeichert werden, kann hier einfach die Zeile geskippt werden
//			if (!FileUploadUtils.required.stream().filter(x -> !line.keySet().contains(x)).collect(Collectors.toList()).isEmpty()) {
//				file_upload_utils.result.success = false;
//				file_upload_utils.result.conclusion += "At least one required values(\"pmid\", \"disease_abbrev\", \"individual_id\", \"mdsgene_decision\", \"family_id\", \"index_pat\") is missing in Line " + line_no[0] + ". Missing : " + FileUploadUtils.required.stream().filter(x -> !line.keySet().contains(x)).collect(Collectors.joining(",")) + lineSeparator;
//				file_upload_utils.result.required.add(FileUploadUtils.required.stream().collect(Collectors.joining(","))); redirectAttributes.addFlashAttribute("message", file_upload_utils.result.conclusion);
//				return;
//			}
//			Set<String> skipped = line.keySet().stream().collect(Collectors.toSet());
//			skipped.remove("mdsgene_decision");
//			skipped.remove("individual_id");
//			skipped.remove("disease_abbrev");
//			skipped.remove("pmid");
//			skipped.remove("family_id");
//			skipped.remove("index_pat");
//
////			StudyUtils study_utils = new StudyUtils(this, line, skipped, authorDAO, authorGroupDAO);
////			Study study = study_utils.get_study.get();
//			Study study = new Study(); //dummy study is not used here
//
//			PatientUtils patient_utils = new PatientUtils(this, line, skipped); Patient patient = patient_utils.new_patient.apply(file_upload, line_no[0]);
//			patient.setStudy(study); Patient last_patient = patient;
//
//			FamilyUtils family_utils = new FamilyUtils(this, line, skipped);  patient.setFamily(family_utils.get_family.apply(line_no[0]));
//
//			try {
//				retrieve_info_from_excel_file(line, skipped, study, patient_utils, patient, false);
//			} catch (Exception ex) {
//				System.out.println("ERROR: " +  file.getAbsoluteFile() + " line no: " + line_no[0] + " skepped.");
//			}
//			List<String> _row = new ArrayList<String>();
//			patient.getSequenceVariations().forEach(sv -> {
//
////				folgende Spalten sollten für die Auswahl der benign Varianten berücksichtigt werden:
////
////					mdsgene_decision - soll sein EX
////					final_score - soll sein <5
////					status_clinical - soll nicht sein  clinically unaffected
////					physical_location - soll nicht sein  -99
//				if (sv.getFinal_score() != null && sv.getFinal_score() > 4) return;
//				if (patient.getStatusClinical() == 2) return;
//				if (sv.getPosition() == null) return;
//
//				TsvWriter _writer;
//				try {
//					_writer = gene_files_map.get(sv.getGene().getName()); if(_writer == null) gene_files_map.put(sv.getGene().getName(), _writer = new TsvWriter(new FileWriter(new File(BENIGN_FILES_FOLDER + sv.getGene().getName() + ".tsv"), true), new TsvWriterSettings()));
//				} catch (IOException e) {
//					return;
//				}
//
//
//				_row.add(file.getName());//0
//				_row.add(String.valueOf(line_no[0]));//1
//				//Author, year//2
//				_row.add(line.entrySet().stream().filter(x -> x.getKey().toLowerCase().trim().startsWith("author")).findAny().map(x -> x.getValue()).orElse(""));
//				//_row.add(patient.getEthnicity());
//
//				//physical location//3
//				_row.add(String.valueOf(sv.getPosition() != null && sv.getChromosome() != null ? (sv.getChromosome() + ":" + sv.getPosition()) : "n.a."));
//				//allele
//				_row.add(sv.getReference());//4
//				_row.add(sv.getObserved());//5
//
//
//				_row.add(sv.getCdnaRelated());//6
//				_row.add(sv.getProteinRelated());//7
//				_row.add(sv.getAlias());//8
//
//				boolean[] found_genotype = new boolean[1];
//				SequenceVariationUtils sequence_variation_utils = new SequenceVariationUtils(this, line, skipped);
//				sequence_variation_utils.genotypes.get().entrySet().forEach(x -> {
//					if (x.getValue().equals(sv.getGenotype())) {
//						_row.add(String.valueOf(sv.getGenotype()));
//						found_genotype[0] = true;
//					}
//				});
//				if(!found_genotype[0]) _row.add("n.a.");//9
//
//				short nhm = sv.getNum_index_pat_het_mut() != null ? sv.getNum_index_pat_het_mut() : 0;
//				short ntm = sv.getNum_index_pat_two_mut() != null ? sv.getNum_index_pat_two_mut() : 0;
//				_row.add(sv.getNum_index_pat_het_mut() == null && sv.getNum_index_pat_two_mut() == null ? "n.a." : String.valueOf(nhm + ntm));//10
//
//				_row.add(sv.getNum_fam_with_segregation() == null ? "n.a." : String.valueOf(sv.getNum_fam_with_segregation()));//11
//				_row.add(sv.getPatient().getGnomAD() == null || "-99".equals(sv.getPatient().getGnomAD()) ? "n.a." : sv.getPatient().getGnomAD());//12
//
//				_row.add(sv.getCaddScore() == null ? "n.a." : sv.getCaddScore().toString());//13
//				List<String> _row1 = _row.stream().map(x -> x == null || x.startsWith("-99") ? "n.a." : x).collect(Collectors.toList());
//				if(_last_row[0] == null || IntStream.range(0, _row1.size()).filter(x -> Arrays.asList(2,3,6,7,8,10,12,13).contains(x) && !_row1.get(x).equals(_last_row[0].get(x))).count() > 0) { _writer.writeRow(_row1); _last_row[0] = _row1; }
//			});
//
//		};
//		return parisng_action;
//	}
//
//	/**
//	 * @throws IOException
//	 */
//	public void update_excel_files_from_log(String folderPath) throws IOException {
//		List<Pair<String, Pair<String[], String[]>>> result = new ArrayList<>();
//		try (Stream<String> stream = Files.lines(Paths.get("C:/db_backup/commands_for_excel_7171.log"))) {
//	        stream.forEach(x -> {
//	        	char[] split = x.toCharArray();
//
//	        	// read the command of the operation
//	        	StringBuffer command = new StringBuffer();
//	        	int i = 0;
//	        	while (split[i] != ' ' && split[i] != '\t') { command.append(split[i]); ++i; }
////	        	System.out.println("Command : " + command);
//
//	        	// read the values
//	        	String x2 = x.substring(i);
//	        	if (x2.contains("left")) {
//	        		String values = x2.split("left")[1];
//	        		String[] left = values.split("right")[0].trim().split("\\|\\|\\|");
////		        	System.out.println("Values(left) : " + left[0]);
//	        		String[] right = values.split("right")[1].trim().split("\\|\\|\\|");
////		        	System.out.println("Command(right) : " + right[0]);
//		        	result.add( Pair.of(command.toString(), Pair.of(left, right)) );
////		        	result.add( Pair.of("merge", Pair.of(new String[] {"parkinsonism_sympt"}, new String[] {"parkinsonism_HP:0001300"})) );
//
//	        	}
//	        });
//		}
//
//		File folder = new File(folderPath);
//
//		for (Pair<String, Pair<String[], String[]>> pair : result) {
//			Pair<String[], String[]> merge_to = pair.getRight();
//			String command = pair.getLeft();
//			int db = 0;
//			String processName = "s2de";
//			process_tsv(folder, merge_to, command, db, processName );
//		}
//	}
//
//	@GetMapping("/uploadStatus")
//	public String uploadStatus() {
//		return "uploadStatus";
//	};
//
//}