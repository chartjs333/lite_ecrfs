
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Family;

/**
 * Home object for domain model class Family.
 * 
 * @see Family
 */
public class FamilyDAO extends JPADAO<Family, Integer> {
	public FamilyDAO() {
		super(Family.class);
	}
}