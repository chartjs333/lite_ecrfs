//package net.mdsgene.admin.controllers;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
//
//import com.univocity.parsers.common.processor.RowListProcessor;
//import com.univocity.parsers.csv.CsvParser;
//
//import net.mdsgene.admin.admintool.entities.Symptom;
//import net.mdsgene.admin.controllers.UploadController.FileUploadUtils;
//
//@Controller
//public class UploadAdditionalAAO {
//	private static final String lineSeparator = "\n";
//
//	@GetMapping("/uploadAAO")
//	public String check_excel_file() {
//		return "uploadAAO";
//	}
//
//	@PostMapping("/uploadAAOFile") // //new annotation since 4.3
//	public String file_import(ModelMap model, @RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) throws IOException {
////		ImmutablePair<CsvParser,RowListProcessor> t = new FileUploadUtils(new RedirectAttributesModelMap()).csv_open.apply(null);
////		// this function will return the list of the headers which are not presented in the database
////		// but exist in the Original symptoms text area.
////		final XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
////		final XSSFSheet ws = wb.getSheetAt(0);
////		final StringBuffer text = new StringBuffer();
////		try {
////			checkSymptomFile(ws, model);
////		} catch (Exception e) {
////			e.printStackTrace();
////			String hint =
////					"Something is wrong: " +
////					lineSeparator +
////					"1. Check that you send the csv file." +
////					lineSeparator +
////					"2. Check that your csv file has a right format for AAO upload.";
////			model.addAttribute("message", hint);
////		}
////		model.addAttribute("message", model.get("message").toString().split(lineSeparator));
////		model.addAttribute("chart", model.get("chart").toString().split(lineSeparator));
////		wb.close();
//		return "uploadAAOStatus";
//	}
////
////	/**
////	 * Event handler delegate method for the {@link XdevButton} {@link #button2}.
////	 * @param startRow
////	 * @throws IOException
////	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
////	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
////	 */
////	private void checkSymptomFile(XSSFSheet ws, ModelMap model) {
////		int endRow = 2000;
////		// this function will check if the symptom exist in  the database
////		// if the symptom has some issue in his valuse range.
////		try {
////			final StringBuffer text = new StringBuffer();
////
////
////			final List<Symptom> list = symptomDAO.findAll();
////			model.addAttribute("message", "");
////			model.addAttribute("chart", "");
////			Set<String> names = new HashSet<>();
////			boolean fileChanged = false;
////
////				for (int jj = 0; jj < Math.min(getLastRowIndex(ws), endRow); jj++) {
////					boolean found = false;
////					for (final Symptom symptom : list) {
////						String import_header = readValue(ws, 0, jj);
////						String import_name = readValue(ws, 2, jj);
////						if (symptom.getName().trim().equalsIgnoreCase(import_name.trim()) && symptom.getImportHeader().equalsIgnoreCase(import_header)) {
////							found = true;
////							model.addAttribute("chart", model.get("chart") + import_name + "|" + lineSeparator);
////						} else if (symptom.getName().equals(import_name.trim()) || symptom.getImportHeader().equals(import_header)) {
////							found = true;
////							model.addAttribute("chart", model.get("chart") + import_name + "|" + lineSeparator);
////							model.addAttribute("message", model.get("message") + import_header + "/" + import_name + " overlapped with " + symptom.getImportHeader()  + "/" + symptom.getName() + " in db " + lineSeparator);
////							break;
////						}
////					}
////					if (!found) model.addAttribute("chart", model.get("chart") + "-" + readValue(ws, 0, jj) + "|" + lineSeparator);
////				}
////
////		} catch(Exception e) {
////			throw e;
////		}
////	}
//}
