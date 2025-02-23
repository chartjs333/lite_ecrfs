package net.mdsgene.admin.controllers;

import java.util.List;
import java.util.function.Function;

import net.mdsgene.admin.controllers.ChartsData.ПараметрыФильтра;
import net.mdsgene.admin.controllers.StudiesController.Overview;

public interface IOverview {
	/**
	 * This method will read information about name of the Disease and Gene and update with it the correspondent gene object
	 * @param overview - pojo object for overview page which should be initialized with the correspondent parameters to be shown in the view
	 * @param fc - value of the index selected from the drop down box
	 * @param aao - value of the aao selected from the aao filter drop box
	 * @param selected_gene_id - id of the selected gene
	 * @param selected_disease_id - id of the selected disease_id
	 */
	void readGeneDiseaseNames(Overview overview, Integer fc,  String aao, Integer selected_gene_id, Integer selected_disease_id);
	/**
	 * This method will read filters information and update overview bean with it
	 * @param overview - pojo object for overview page which should be initialized with the correspondent parameters to be shown in the view
	 * @param selected_gene_id - id of the selected gene
	 * @param fc - value of the index selected from the drop down box
	 * @param fc2 TODO
	 * @param fc3 TODO
	 * @param aao - value of the aao selected from the aao filter drop box
	 * @param mut_restrict - list of the mutation restrictions selected from the filter
	 */
	void readFilters(Overview overview, Integer selected_gene_id, Integer fc,  Integer fc1, Integer fc2, String aao, List<String> mut_restrict, List<String> country);
	
	/**
	 * This method will read list of the publications and update overview with the correspondent information 
	 * @param overview - pojo object for overview page which should be initialized with the correspondent parameters to be shown in the view
	 * @param page - index of the page should be written
	 * @param fc - value of the index selected from the drop down box
	 * @param fc1 TODO
	 * @param fc2 TODO
	 * @param fc3 TODO
	 * @param selected_gene_id - id of the selected gene
	 */
	void readPublications(Overview overview, Integer page, ПараметрыФильтра параметрыФильтра,  Integer selected_gene_id, Function<List<String>, List<String>> обработка_данных);
	
	/**
	 * This function should update overview object with the information which should be used for the pagination
	 * @param fc - value of the index selected from the drop down box
	 * @param aao - value of the aao selected from the aao filter drop box
	 * @param mut_restrict - list of the mutation restrictions selected from the filter
	 * @return part of the string which should be added for the pagination
	 */
	void buildPaginationAppender(Overview overview, Integer fc, String aao, List<String> mut_restrict, List<String> country);
}
