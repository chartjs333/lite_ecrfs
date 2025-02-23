
package net.mdsgene.admin.admintool.dal;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.User;

/**
 * Home object for domain model class User.
 * 
 * @see User
 */
public class UserDAO extends JPADAO<User, Integer> {
	public UserDAO() {
		super(User.class);
	}
}