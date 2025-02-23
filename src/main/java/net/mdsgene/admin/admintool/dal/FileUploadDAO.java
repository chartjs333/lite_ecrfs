
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.FileUpload;

/**
 * Home object for domain model class FileUpload.
 * 
 * @see FileUpload
 */
public class FileUploadDAO extends JPADAO<FileUpload, Integer> {
	public FileUploadDAO() {
		super(FileUpload.class);
	}
}