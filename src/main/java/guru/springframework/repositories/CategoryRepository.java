package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Category;


/**
 * Spring Data will construct this Repository by using Reflection and Java Generics
 * 
 * @author matt.mcfarlane
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	Optional<Category> findByDescription(String description);

}
