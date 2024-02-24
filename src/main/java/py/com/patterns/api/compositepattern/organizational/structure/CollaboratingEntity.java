package py.com.patterns.api.compositepattern.organizational.structure;

import java.util.ArrayList;
import java.util.List;

public class CollaboratingEntity {
	
		
	public CollaboratingEntity(String name, EntityType type) {
		super();
		this.name = name;
		this.type = type;
		dependantEntities = new ArrayList<>();
	}
	
	protected final EntityType type;
	protected final String name;
	protected List<CollaboratingEntity> dependantEntities;
	
	public void addDependantEntity(CollaboratingEntity entity) {
		if(this.type.equals(EntityType.INDIVIDUAL) && !this.type.equals(entity.type))throw new RuntimeException("Entity " + this.type + " requires " + this.type + " as dependant entity type");
		dependantEntities.add(entity);
	}

	public String getName() {
		return name;
	}

	public List<CollaboratingEntity> getDependantEntities() {
		return dependantEntities;
	}

	public void setDependantEntities(List<CollaboratingEntity> dependantEntities) {
		this.dependantEntities = dependantEntities;
	}	
}
