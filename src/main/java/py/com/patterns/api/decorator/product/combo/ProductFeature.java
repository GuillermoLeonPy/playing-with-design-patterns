package py.com.patterns.api.decorator.product.combo;

import java.util.List;

public interface ProductFeature {

	String getName();
	List<ProductFeature> decorate();
}
