
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Patient;

/**
 * Home object for domain model class Patient.
 * 
 * @see Patient
 */
public class PatientDAO extends JPADAO<Patient, Integer> {
	public PatientDAO() {
		super(Patient.class);
	}
}