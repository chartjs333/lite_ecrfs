
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.GeneAlias;

/**
 * Home object for domain model class GeneAlias.
 * 
 * @see GeneAlias
 */
public class GeneAliasDAO extends JPADAO<GeneAlias, Integer> {
	public GeneAliasDAO() {
		super(GeneAlias.class);
	}
}