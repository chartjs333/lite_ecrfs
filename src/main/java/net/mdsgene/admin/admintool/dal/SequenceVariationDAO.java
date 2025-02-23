
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.SequenceVariation;

/**
 * Home object for domain model class SequenceVariation.
 * 
 * @see SequenceVariation
 */
public class SequenceVariationDAO extends JPADAO<SequenceVariation, Integer> {
	public SequenceVariationDAO() {
		super(SequenceVariation.class);
	}
}