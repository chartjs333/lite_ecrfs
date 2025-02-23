package net.mdsgene.admin.admintool.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.mdsgene.admin.admintool.entities.Disease;
import net.mdsgene.admin.admintool.entities.Gene;
import net.mdsgene.admin.admintool.entities.SequenceVariation;

public class GeneDecorator {
	static List<String> lstSubCategoryPxMD = Arrays.asList("SLC1A3", "KCNA1");
	public static List<Disease> lstDisease = null;
	
	public static String subCategory(Gene gene) {
		if (gene == null || gene.getName() == null) return "";
		if (lstSubCategoryPxMD.contains(gene.getName())) {
			return "PxMD";
		}
		return "";
	}
	
	public static Integer diseaseId(Integer diseaseId, Gene gene) {
		if (lstSubCategoryPxMD.contains(gene.getName())) {
			for (Disease _disease : lstDisease) {
				if (_disease.getAbbreviation().equals("EA")) {
					return _disease.getId();	
				}
			}
		}
		return diseaseId;

	}
}
