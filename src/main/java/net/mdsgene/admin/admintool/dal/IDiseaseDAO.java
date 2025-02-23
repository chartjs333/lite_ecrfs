
package net.mdsgene.admin.admintool.dal;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xdev.dal.JPADAO;

import net.mdsgene.admin.admintool.entities.Disease;
import net.mdsgene.admin.admintool.entities.Study;

/**
 * Home object for domain model class Disease.
 * 
 * @see Disease
 */
@Repository
public interface IDiseaseDAO extends JpaRepository<Disease, Integer> {
//	@Query(value = "SELECT \"diseases\".* FROM \"diseases\" WHERE \"diseases\".\"launched\" = true ORDER BY \"diseases\".\"name\" ASC, \"diseases\".\"id\" ASC",
//			nativeQuery = true)
	@Query(value = "SELECT d FROM Disease As d WHERE d.launched = true ORDER BY d.name ASC, d.id ASC")
	@Cacheable(cacheNames= {"overview"}, key="#root.method.name")
	List<Disease> select_launched_disease();
	
//	@Query(value = "SELECT  \"diseases\".* FROM \"diseases\" WHERE \"diseases\".\"launched\" = true AND \"diseases\".\"id\" = ?1 ORDER BY \"diseases\".\"name\" ASC LIMIT 1", nativeQuery = true)
//	Disease load_disease(int disease_id);
	
}