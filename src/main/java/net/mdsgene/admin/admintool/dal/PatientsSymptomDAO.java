
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.PatientsSymptom;

/**
 * Home object for domain model class PatientsSymptom.
 * 
 * @see PatientsSymptom
 */
public class PatientsSymptomDAO extends JPADAO<PatientsSymptom, Integer> {
	public PatientsSymptomDAO() {
		super(PatientsSymptom.class);
	}
}