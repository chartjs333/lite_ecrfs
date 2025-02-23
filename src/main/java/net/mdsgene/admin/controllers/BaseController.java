//package net.mdsgene.admin.controllers;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Stream;
//
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//
//import net.lingala.zip4j.exception.ZipException;
//import net.mdsgene.admin.admintool.business.UserDecorator;
//import net.mdsgene.admin.admintool.business.Zipper;
//import net.mdsgene.admin.admintool.dal.IFileUploadDAO;
//import net.mdsgene.admin.admintool.dal.IRestorePointDAO;
//import net.mdsgene.admin.admintool.dal.IUserDAO;
//import net.mdsgene.admin.admintool.entities.RestorePoint;
//import net.mdsgene.admin.admintool.entities.User;
//
//@Controller
//public class BaseController {
//	protected static final List<String> TWO_CHART_GENES = Arrays.asList("TOR1A", "KMT2B", "THAP1", "GNAL", "ANO3", "SLC30A10", "ATP13A2", "DNAJC6", "FBXO7", "SYNJ1","SLC6A3","GCH1","PRKRA","KCNA1","ADCY5","NKX2-1","DCTN1", "HPCA", "TH");
//	protected static final List<String> ONE_CHART_GENES_FOR_EDIT = Arrays.asList("MYORG", "PDGFB", "PDGFRB", "SLC20A2", "XPR1");
//	protected static final List<String> SKEEP_EMPTIES = Arrays.asList("MYORG", "PDGFB", "PDGFRB", "SLC20A2", "XPR1");
//
//	public static String EXCEL_FILES_FOLDER = "C:/db_backup/tsv_files/";
//	public static String BENIGN_FILES_FOLDER = "C:/db_backup/benign_files/";
//	public static String PROTECT_MOVE_FILES_FOLDER = "C:/db_backup/protect_move_files/";
//
//	@Value("${show.unpublished.data}")
//	private String showUnpublishedData;
//
//	@Value("${spring.datasource.url}")
//	private String datasourceUrl;
//
//	@Value("${spring.datasource.username}")
//	private String datasourceUsername;
//
//	@Value("${spring.datasource.password}")
//	private String datasourcePassword;
//
//	@Value("${user.defined.db.base.path}")
//	private String userDefinedDbBasePath;
//
//	@Value("${user.defined.db.backup.path}")
//	protected String userDefinedDbBackupPath;
//
//	@Value("${user.defined.db.backup.password}")
//	private String userDefinedDbBackupPassword;
//
//	@Value("${signs.symptoms.enabled}")
//	protected String signsSymptomsEnabled;
//
//	@Value("${benigns.allowed}")
//	protected String benignsAllowed;
//
//	@Value("${server.port}")
//	protected String serverPort;
//
//	@Value("${aao.other}")
//	protected String aaoOther;
//
//	@Value("${check.for.membership}")
//	protected String checkForMembership;
//
//	@Value("${check.gene.upload}")
//	protected String checkGeneUpload;
//
//	@Value("${java.port.nr}")
//	protected String javaPortNr;
//
//	@Value("${ruby.url}")
//	protected String rubyUrl;
//
//	//@Value("${sample.tsv.file.path}")
//	protected String sampleTsvFilePath;
//
//	@Value("${neele.symptom.change.apply}")
//	protected String neeleSymptomChangeApply;
//
//
//
//	@Autowired
//	private IRestorePointDAO restorePointDAO;
//	@Autowired
//	private IFileUploadDAO fileUploadDAO;
//	@Autowired
//	private IUserDAO userDAO;
//
//	public String getShowUnpublishedData() {
//		return showUnpublishedData;
//	}
//
//	public void setShowUnpublishedData(String showUnpublishedData) {
//		this.showUnpublishedData = showUnpublishedData;
//	}
//
//	protected String backupDB(String restore_point_name) throws IOException, InterruptedException {
//		return backupDB(restore_point_name, null);
//	}
//
//	protected String backupDB(String restore_point_name, String file_name) throws IOException, InterruptedException {
//	    Process p;
//	    ProcessBuilder pb;
//	    String[] dbNameSplit = StringUtils.split(datasourceUrl, "/");
//	    file_name = file_name == null ? userDefinedDbBackupPath + "\\" + dbNameSplit[dbNameSplit.length - 1] + "_" + Calendar.getInstance().getTimeInMillis() + "_" + serverPort + ".backup" : file_name;
//		pb = new ProcessBuilder(
//	    		userDefinedDbBasePath + "\\pg_dump.exe",
//	    		"-d", dbNameSplit[dbNameSplit.length - 1],
////	            "--host", "localhost",
////	            "--port", "5432",
//	            "--username", datasourceUsername,
//	            "--no-password",
////	            "--format", "custom",
////	            "--blobs",
////	            "--verbose",
//	            "--file", file_name);
//	    try {
//	    	final Map<String, String> env = pb.environment();
//	        env.put("PGPASSWORD", datasourcePassword);
//	        p = pb.start();
//	        final BufferedReader r = new BufferedReader(
//	                new InputStreamReader(p.getErrorStream()));
//	        String line = r.readLine();
//	        while (line != null) {
//	            System.err.println(line);
//	            line = r.readLine();
//	        }
//	        r.close();
//	        p.waitFor();
//
//	        int exit_value = p.exitValue();
//	        if (exit_value != 0) throw new IllegalThreadStateException("Process terminated with exit code" + exit_value);
//
//	        //create restore point
//	        RestorePoint _rp = null;
//	        if (restore_point_name != null) {
//	        	_rp = new RestorePoint();
//	        	_rp.setFileName(file_name);
//	        	_rp.setName(restore_point_name);
//	        	_rp.setCreatedAt(Calendar.getInstance().getTime());
//	        }
//
//        	Zipper zipper = new Zipper(userDefinedDbBackupPassword);
//        	zipper.pack(file_name, userDefinedDbBackupPath + "\\" + "commands_for_excel_" + serverPort + ".log", userDefinedDbBackupPath + "\\" + "log_" + serverPort + ".txt");
//
//	        if (restore_point_name != null) {
//	        	restorePointDAO.save(_rp);
//	        }
//	    } catch (IOException | InterruptedException | IllegalThreadStateException | ZipException e) {
//	    	e.printStackTrace();
//	    	return e.getMessage();
//	    } finally {
//	    	if (restore_point_name != null) {
//	    		new File(file_name).delete();
//	    	}
//	    }
//	    return null;
//	}
//
//	public String uploadTsvFile(String file_path, String log_path, String error_path, boolean upload_to_db, String vers) throws Exception {
//		try {
//		    URL url = new URL("http://" + rubyUrl);
//		    URLConnection conn = url.openConnection();
//		    conn.connect();
//		} catch (Exception e) {
//			throw e;
//		}
//
//	    Process p;
//	    ProcessBuilder pb;
////	    c:\curl\cURL -F "patient[tsv_file]=@C:\Java\eclipse-workspace\mdsgene-admintool\mdsgene-java\src\test\java\net\mdsgene\admin\admintool\business\MultipartUploaderTest.java" "http://141.83.25.66:3000/dba/patients/import"
//		System.out.println("\"http://" + rubyUrl + "/dba/patients/import?file_version=" + vers + (upload_to_db ? "" : "&ignore_errors=true") + "&java_port_nr=" + (javaPortNr == null ? "8181" : javaPortNr) + "\"");
//		pb = new ProcessBuilder("c:\\curl\\curl.exe",
//				"-F", "\"patient[tsv_file]=@" + file_path + "\"",
//				"\"http://" + rubyUrl + "/dba/patients/import?file_version=" + vers + (upload_to_db ? "" : "&ignore_errors=true") + "&java_port_nr=" + (javaPortNr == null ? "8181" : javaPortNr) + "\"");
//		pb.redirectOutput(new File(log_path));
//		pb.redirectError(new File(error_path));
//
//	    try {
//	        p = pb.start();
////	        final BufferedReader r = new BufferedReader(
////	                new InputStreamReader(p.getErrorStream()));
////	        String line = r.readLine();
////	        while (line != null) {
////	            System.out.println(line);
////	        }
////	        r.close();
//	        p.waitFor();
//
//	        int exit_value = p.exitValue();
//	        if (exit_value != 0) throw new IllegalThreadStateException("Process terminated with exit code" + exit_value);
//	        Stream<String> lines = Files.lines(Paths.get(log_path));
//	        String[] array = lines.toArray(String[]::new);
//	        return array[0];
//
//	    } catch (Exception e) {
//	    	e.printStackTrace();
//	    	throw e;
//	    }
//	}
//
//	public String restoreDB(Integer restore_point_id) {
//		RestorePoint _rp = restorePointDAO.findOne(restore_point_id);
//		if (_rp == null) {
//			return "can't find restore point";
//		}
//
//		long time = Calendar.getInstance().getTime().getTime();
//
//		try {
//	        //make a copy of the current database with the name last point + date and time
//			String error = backupDB(null, userDefinedDbBackupPath + "\\reserved_copy_before_restore_db_" + time);
//			if (error != null) return error;
//
//			//# -U mdsgene -d mdsgene_production_v305 < mdsgene_production_v305
//
//			//extract file from zip
//	        Zipper zipper = new Zipper(userDefinedDbBackupPassword);
//	        String sourceZipFilePath = _rp.getFileName();
//			String extractedZipFilePath = userDefinedDbBackupPath + "\\";
//			zipper.unpack(sourceZipFilePath, extractedZipFilePath);
//
//		    String[] dbNameSplit = StringUtils.split(datasourceUrl, "/");
//
//		    // terminate database connections
//		    // drop database
//		    // restore database
//		    Map<Integer, String> commands = new HashMap<>();
//		    commands.put(0, userDefinedDbBasePath + "\\psql.exe -U postgres -c \"SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = '"   + dbNameSplit[dbNameSplit.length - 1] + "' AND pid <> pg_backend_pid();");
//		    commands.put(1, userDefinedDbBasePath + "\\psql.exe -U postgres -c \"drop database "   + dbNameSplit[dbNameSplit.length - 1] + "\"");
//		    commands.put(2, userDefinedDbBasePath + "\\psql.exe -U " + datasourceUsername + " -d " + dbNameSplit[dbNameSplit.length - 1] + " < " + _rp.getFileName());
//
//		    for(int i=0; i < 3; i++) {
//			    Process p;
//			    ProcessBuilder pb;
//		    	pb = new ProcessBuilder(commands.get(i));
//
//		    	final Map<String, String> env = pb.environment();
//		    	env.put("PGPASSWORD", datasourcePassword);
//		    	p = pb.start();
//		    	final BufferedReader r = new BufferedReader(
//		    			new InputStreamReader(p.getErrorStream()));
//		    	String line = r.readLine();
//		    	while (line != null) {
//		    		System.err.println(line);
//		    		line = r.readLine();
//		    	}
//		    	r.close();
//		    	p.waitFor();
//
//		    	int exit_value = p.exitValue();
//		    	if (exit_value != 0) throw new IllegalThreadStateException("Process terminated with exit code" + exit_value);
//		    }
//
//	    } catch (IOException | InterruptedException | IllegalThreadStateException | ZipException e) {
//	    	e.printStackTrace();
//	    	return e.getMessage();
//	    } finally {
//	    	new File(_rp.getFileName()).delete();
//	    }
//	    return null;
//	}
//
//	protected User loggedInUser(Authentication authentication) {
//		if ("no".equals(checkForMembership)) return new User();
//		if (authentication == null) return null;
//		if (UserDecorator.is_user_logged_in()) return new User();
//		return null;
//		// this part was removed af
////		try {
////			String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
////			User user = userDAO.findOneByUsername(username);
////			return user;
////		} catch (java.lang.ClassCastException ex) {
////		}
//	}
//
//}
