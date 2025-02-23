
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Symptom;

/**
 * Home object for domain model class Symptom.
 * 
 * @see Symptom
 */
public class SymptomDAO extends JPADAO<Symptom, Integer> {
	public SymptomDAO() {
		super(Symptom.class);
	}
}