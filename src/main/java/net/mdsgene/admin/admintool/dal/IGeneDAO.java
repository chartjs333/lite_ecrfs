
package net.mdsgene.admin.admintool.dal;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.mdsgene.admin.admintool.entities.Gene;

/**
 * Home object for domain model class Gene.
 * 
 * @see Gene
 */
@Repository
public interface IGeneDAO extends JpaRepository<Gene, Integer> {
	@Query(value="SELECT DISTINCT \"genes\".* FROM \"genes\" INNER JOIN \"systematic_reviews\" ON \"genes\".\"id\" = \"systematic_reviews\".\"gene_id\" WHERE \"systematic_reviews\".\"disease_id\" = ?1",
			nativeQuery=true)
	@Cacheable(cacheNames= {"overview"}, key="{#root.method.name, #p0}")
	List<Gene> reviewed_gene(int disease_id);
	
	@Query(value="SELECT DISTINCT \"genes\".* FROM \"sequence_variations\" INNER JOIN \"patients\" ON \"patients\".\"id\" = \"sequence_variations\".\"patient_id\" INNER JOIN \"genes\" ON \"genes\".\"id\" = \"sequence_variations\".\"gene_id\" WHERE (\"sequence_variations\".\"pathogenicity\" != 1) AND \"patients\".\"disease_id\" = ?1 AND (\"patients\".\"status_clinical\" != 3)",
			nativeQuery=true)
	@Cacheable(cacheNames= {"overview"}, key="{#root.method.name, #p0}")
	List<Gene> _included_patients_genes(int disease_id);
	
	@Query(value="SELECT  \"genes\".* FROM \"genes\" WHERE \"genes\".\"id\" = ?1 LIMIT 1",
			nativeQuery=true)
	@Cacheable(cacheNames= {"overview"}, key="{#root.method.name, #p0}")
	Gene load_gene(int gene_id);
}