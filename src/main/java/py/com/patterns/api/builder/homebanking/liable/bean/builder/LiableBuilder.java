package py.com.patterns.api.builder.homebanking.liable.bean.builder;

import java.util.HashMap;
import java.util.Map;

public abstract class LiableBuilder<T> {

	protected Map<String,String> identifyingData;
	protected Map<String,String> residenceData;
	protected Map<String,String> commercialReferenceData;
	
	public LiableBuilder() {
		super();
		// TODO Auto-generated constructor stub
		identifyingData = new HashMap<>();
		residenceData = new HashMap<>();
		commercialReferenceData = new HashMap<>();
	}
	
	public LiableBuilder<T> addIdentifyingData(String key, String value){
		this.identifyingData.put(key, value);
		return this;
	}
	
	public LiableBuilder<T> addResidenceData(String key, String value){
		this.residenceData.put(key, value);
		return this;
	}
	
	public LiableBuilder<T> addComercialReferenceData(String key, String value){
		this.commercialReferenceData.put(key, value);
		return this;
	}		
	
	public abstract T build();
}
