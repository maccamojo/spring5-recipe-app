package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

/**
 * Spring Data will construct this Repository by using Reflection and Java Generics
 * 
 * @author matt.mcfarlane
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
