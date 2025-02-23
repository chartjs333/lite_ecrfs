
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.SystematicReview;

/**
 * Home object for domain model class SystematicReview.
 * 
 * @see SystematicReview
 */
public class SystematicReviewDAO extends JPADAO<SystematicReview, Integer> {
	public SystematicReviewDAO() {
		super(SystematicReview.class);
	}
}