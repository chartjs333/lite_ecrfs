package net.mdsgene.admin.controllers;

import net.mdsgene.admin.controllers.ChartsData.ПараметрыФильтра;
import net.mdsgene.admin.controllers.StudiesController.Charts;

import java.util.List;

public interface IChartsData {
	void readRepeatsCount(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readAAOCount(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readDYTorPARKatOneSet(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readBodyPartAffectedByDYT(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readCranocervicalDystonia(Charts charts, ПараметрыФильтра параметры_фильтра, Integer selected_gene_id, Integer selected_disease_id, int repeats, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readRace(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutation, boolean healthies, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readAAO(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readEthnicity(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean healthies, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readDiagnosedWithPD(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readFamiltyHistory(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readDataAlreadyBeenPublished(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readAvailabilityOfClinicalScales(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readAvailabilityOfOtherData(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readAvailabilityOfBiospecimen(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readEthicsApproval(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readSubjectsPerGene(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readFrequencyOfMutations(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readTypeOfMutation(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
	void readDigenicCases(Charts charts, ПараметрыФильтра параметры_фильтра, List<String> mutations, boolean считывать_здоровых, List<String> selectedValues, String filterForAAE, String aae, String filterForYLC, String ylc);
}
