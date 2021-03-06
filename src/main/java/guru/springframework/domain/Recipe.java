package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// these all appear as a columns in the 'RECIPE' table
	private String description;
    private Integer prepTime;
    private Integer cookTime;	 
    private Integer servings;
    private String source;
    private String url;
    
    @Lob
    private String directions;   // appears as a column in the 'RECIPE' table
        
    // This defines the Recipe side of the one-to-many relationship.
    // If we delete a particular recipe, we will cascade down and delete ALL the related Ingredient records aswell.
    // Each Ingredient will be stored in the Child object in the 'recipe' property/field (ie. the Target property in the Ingredient class).
    // This 'ingredients' field does NOT appear as a column in the 'RECIPE' table  (why is this?)   *********************************************************************
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();    // best practice to initialise upfront
    
    @Lob
    private Byte[] image;   // appears as a column in the 'RECIPE' table
    
    @Enumerated(value = EnumType.STRING)   // appears as a column in the 'RECIPE' table
    private Difficulty difficulty;
    
    // This defines the Recipe as the owner of this one-to-one relationship.
    // If we delete a particular recipe, we will cascade down and delete the related Note aswell.
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // Recipe is the owner side of this relationship
    @ManyToMany
    @JoinTable(name = "recipe_category",
    		joinColumns = @JoinColumn(name = "recipe_id"),
    		inverseJoinColumns = @JoinColumn(name = "category_id"))     // probably one of the more complex things to do in JPA Mapping
    private Set<Category> categories = new HashSet<>();    // best practice to initialise upfront
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
    public void setDescription(String description) {
		this.description = description;
	}
	
    public Integer getPrepTime() {
		return prepTime;
	}
	
    public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	
    public Integer getCookTime() {
		return cookTime;
	}
	
    public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	
    public Integer getServings() {
		return servings;
	}
	
    public void setServings(Integer servings) {
		this.servings = servings;
	}
	
    public String getSource() {
		return source;
	}
	
    public void setSource(String source) {
		this.source = source;
	}
	
    public String getUrl() {
		return url;
	}
	
    public void setUrl(String url) {
		this.url = url;
	}
	
    public String getDirections() {
		return directions;
	}
	
    public void setDirections(String directions) {
		this.directions = directions;
	}
	
    public Byte[] getImage() {
		return image;
	}
	
    public void setImage(Byte[] image) {
		this.image = image;
	}
	
    public Notes getNotes() {
		return notes;
	}
	
    public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
