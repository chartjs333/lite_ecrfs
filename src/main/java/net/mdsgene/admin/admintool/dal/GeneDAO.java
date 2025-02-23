
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Gene;

/**
 * Home object for domain model class Gene.
 * 
 * @see Gene
 */
public class GeneDAO extends JPADAO<Gene, Integer> {
	public GeneDAO() {
		super(Gene.class);
	}
}