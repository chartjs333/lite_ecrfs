
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Study;

/**
 * Home object for domain model class MetaAnalyAsis.
 * 
 * @see MetaAnalyAsis_old
 */
public class StudyDAO extends JPADAO<Study, Integer> {
	public StudyDAO() {
		super(Study.class);
	}
}