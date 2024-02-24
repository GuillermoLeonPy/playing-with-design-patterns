package py.com.patterns.api.decorator.product.combo;

import java.util.ArrayList;
import java.util.List;

public class Product implements ProductFeature {

	protected final String name;	
	protected final ProductFeature decoratedFeature;	
	
	public Product(String name, ProductFeature decoratedFeature) {
		super();
		this.name = name;
		this.decoratedFeature = decoratedFeature;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public List<ProductFeature> decorate() {
		// TODO Auto-generated method stub
		List<ProductFeature> features = new ArrayList<>();
		features.add(this);
		if(decoratedFeature != null) {
			features.addAll(decoratedFeature.decorate());
		}		
		return features;
	}
	
	

}
