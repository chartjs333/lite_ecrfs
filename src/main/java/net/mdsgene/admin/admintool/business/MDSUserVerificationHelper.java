package net.mdsgene.admin.admintool.business;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import net.mdsgene.admin.admintool.business.UserService.ParameterStringBuilder;

@Service
public class MDSUserVerificationHelper {
	@Value("${mds.domain}") String mdsDomain;


	public Long readClientId(InputStream stocks) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("anyType").item(0).getChildNodes();
			Node node = (Node) nodes.item(0);
			return Long.parseLong(node.getNodeValue());
		} catch (Exception ex) {
			return null;
		}
	}	
	
	private static Cache<String, Integer> loginCache = CacheBuilder.newBuilder()
		    .maximumSize(10000)
		    .expireAfterWrite(30, TimeUnit.MINUTES).build();

	/**
	 * @param loginToken
	 * @return Code 200 - this user exist, other codes verification failed.
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public int getObjectAccessorValue(String loginToken)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		if (loginCache.getIfPresent(loginToken) != null) return loginCache.getIfPresent(loginToken);
		
		SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();	    			
		
		URL url = new URL("https://"+ mdsDomain + "/edibo/Login/IntegratedLoginWebService.asmx/GetObjectAccessorValue");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setSSLSocketFactory(sslsocketfactory);
		con.setDoOutput(true);
		con.setDoInput( true );
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Host", mdsDomain);
		con.setRequestMethod("POST");
			
		Map<String, String> parameters = new HashMap<>();
		parameters.put("loginToken", loginToken);
		parameters.put("objectName","AuthenticatedContact");
		parameters.put("accessorName","ContactId");
			 
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(new ParameterStringBuilder().getParamsString(parameters));
		out.flush();
		
		InputStream stream = con.getInputStream();
		Long clientId = readClientId(stream);
		stream.close();
		
		out.close();
		
		int status = con.getResponseCode();
		if (clientId == null) status = 404; 
		
//		  InputStream stream = con.getInputStream();
//		  BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//		  for (String line; (line = reader.readLine()) != null;) {
//		      System.out.println(line);
//		  }
//		  
//		  stream.close();

		
		if(status == 200) {
			url = new URL("https://"+ mdsDomain + "/edibo/Login/IntegratedLoginWebService.asmx/GetUserGroups");
			con = (HttpsURLConnection) url.openConnection();
			con.setSSLSocketFactory(sslsocketfactory);
			con.setDoOutput(true);
			con.setDoInput( true );
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Host", mdsDomain);
			con.setRequestMethod("POST");
			
			parameters = new HashMap<>();
			parameters.put("loginToken", loginToken);
			parameters.put("groupName","activeUsers");
				 
			out = new DataOutputStream(con.getOutputStream());
			out.writeBytes(new ParameterStringBuilder().getParamsString(parameters));
			out.flush();
//
//			InputStream stream = con.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//			for (String line; (line = reader.readLine()) != null;) {
//			    System.out.println(line);
//			}
//			stream.close();
			
			out.close();
			status = con.getResponseCode();
		}
		loginCache.put(loginToken, status);
		return status;
	}

	/**
	 * @param integratedLoginToken TODO
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
//	public void deleteToken(String integratedLoginToken) throws MalformedURLException, IOException, UnsupportedEncodingException {
//		SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//
//		URL url = new URL("https://"+ mdsDomain + "/edibo/Login/IntegratedLoginWebService.asmx/DeleteToken");
//		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//		con.setSSLSocketFactory(sslsocketfactory);
//		con.setDoOutput(true);
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		con.setRequestProperty("Host", mdsDomain);
//
//		Map<String, String> parameters = new HashMap<>();
//		parameters.put("loginToken", integratedLoginToken);
//
//		DataOutputStream out = new DataOutputStream(con.getOutputStream());
//		out.writeBytes(new net.mdsgene.admin.SOAPClientSAAJ.ParameterStringBuilder().getParamsString(parameters));
//		out.flush();
//		out.close();
//
//		int status = con.getResponseCode();
//		if (status == 200) {
//			loginCache.put(integratedLoginToken, 404);
//		}
//	}

}
