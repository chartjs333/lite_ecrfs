//package net.mdsgene.admin.controllers;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//import java.net.MalformedURLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpression;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.xerces.parsers.DOMParser;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.w3c.dom.ls.DOMImplementationLS;
//import org.w3c.dom.ls.LSSerializer;
//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;
//
//import net.mdsgene.admin.admintool.entities.Study;
//
//public class StudyLookUp {
//
//	private Document doc;
//	private int pid;
//
//	public StudyLookUp retrievePMed(int pid) throws Exception {
//		if (doc == null || this.pid != pid) {
//			this.pid = pid;
//			String https_url = "https://www.ncbi.nlm.nih.gov/pubmed/" + pid + "?report=xml&format=text";
//			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//		    HttpGet httpGet = new HttpGet(https_url);
//			HttpResponse response = httpClient.execute(httpGet);
//			InputStream content = response.getEntity().getContent();
//			BufferedReader rd = new BufferedReader(
//					new InputStreamReader(response.getEntity().getContent()));
//
//			StringBuffer result = new StringBuffer();
//			String line = "";
//			while ((line = rd.readLine()) != null) {
//				result.append(line);
//			}
//			String[] split = StringEscapeUtils.unescapeXml(result.toString()).split("<pre>");
//			String cleanUp = "";
//			for(int i=0; i < split.length; i++) {
//				cleanUp += i == 0 ? "" :  "<pre>" + split[i];
//			}
//
//			doc = null;
//
//			// Create a DOM Parser
//			DOMParser parser = new DOMParser();
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//
//			doc = builder.parse(new InputSource(new StringReader("<xml>" + cleanUp + "</xml>")));
//		}
//		return this;
//	}
//
//	public List<String> xpath(String xpath_expression) throws XPathExpressionException {
//		XPathFactory xPathfactory = XPathFactory.newInstance();
//		XPath xpath = xPathfactory.newXPath();
//		XPathExpression expr = xpath.compile(xpath_expression + "/text()");
//		Object evaluate = expr.evaluate(doc, XPathConstants.NODE);
//
//		NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//		List<String> result =  new ArrayList<String>();
//		for (int i = 0; i < nl.getLength(); i++) {
//			if (nl.item(i).getNodeType() != Node.TEXT_NODE) continue;
//			Node item2 = nl.item(i);
//			result.add(item2.getTextContent());
//		}
//		return result;
//	}
//
//	private String getStringFromDoc(Document doc)    {
//	    DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
//	    LSSerializer lsSerializer = domImplementation.createLSSerializer();
//	    return lsSerializer.writeToString(doc);
//	}
//
//}
