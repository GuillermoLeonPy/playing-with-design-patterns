package py.com.patterns.api.prototype;

import java.util.HashMap;
import java.util.Map;

public abstract class ProductRequestPreLoadedTemplate implements Cloneable {

	public enum ProductType{
		LOAN,
		CREDIT_CARD,
		SIGHT_SAVINGS_ACCOUNT,
		FIXED_TERM_SAVINGS_ACCOUNT
	}
	
	protected final String STATUS_DATA_ID = "STARTED";
	
	protected final ProductType productType;
	protected Map<String,Object> data;

	/**
	 * 
	 * more constants declarations for product types
	 * 
	 * */
	
	
	public ProductRequestPreLoadedTemplate(ProductType productType) {
		// TODO Auto-generated constructor stub
		this.productType = productType;
		this.data = new HashMap<String,Object>();
		preLoadProductRequest();
	}
	
	private void preLoadProductRequest() {
		this.data.put(STATUS_DATA_ID, "REQUESTED");
	}

	/**
	 * Clone method declares return this class type also add a cast in the return statement 
	 */
	@Override
	protected ProductRequestPreLoadedTemplate clone() throws CloneNotSupportedException {
		return (ProductRequestPreLoadedTemplate)super.clone();
	}

}
