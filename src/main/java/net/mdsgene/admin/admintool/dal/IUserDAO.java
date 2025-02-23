
package net.mdsgene.admin.admintool.dal;

import org.springframework.data.repository.CrudRepository;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.User;

/**
 * Home object for domain model class User.
 * 
 * @see User
 */
public interface IUserDAO extends CrudRepository<User, Integer> {
	User findOneByUsername(String username);
}