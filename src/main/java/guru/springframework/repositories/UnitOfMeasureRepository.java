package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeasure;

/**
 * Spring Data will construct this Repository by using Reflection and Java Generics
 * 
 * @author matt.mcfarlane
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	
	Optional<UnitOfMeasure> findByDescription(String description);

}
