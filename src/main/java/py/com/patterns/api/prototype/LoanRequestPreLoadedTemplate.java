package py.com.patterns.api.prototype;

import java.math.BigDecimal;
import java.util.Map;

public class LoanRequestPreLoadedTemplate extends ProductRequestPreLoadedTemplate {

	public enum LoanType{
		CONSUMPTION,
		FIRST_HOME,
		OKM_VEHICLE,
		USED_VEHICLE
	}
	
	protected final String LOAN_TYPE_DATA_ID = "LOAN_TYPE_DATA_ID";
	protected final String LOAN_AMOUNT_DATA_ID = "LOAN_AMOUNT_DATA_ID";
	protected final LoanType loanType;
	
	public LoanRequestPreLoadedTemplate() {
		super(ProductType.LOAN);
		this.loanType = LoanType.CONSUMPTION;
		preLoadProductRequest();
		// TODO Auto-generated constructor stub
	}
	
	public LoanRequestPreLoadedTemplate(LoanType loanType) {
		super(ProductType.LOAN);
		this.loanType = loanType;
		preLoadProductRequest();
		// TODO Auto-generated constructor stub
	}
	
	public LoanRequestPreLoadedTemplate(LoanType loanType, Map<String,Object> data) {
		super(ProductType.LOAN);
		this.loanType = loanType;
		this.data = data;
		/**
		 * apply received parameters properties values instead of pre load data
		 */
	}
	
	
	
	private void preLoadProductRequest() {
		this.data.put(LOAN_TYPE_DATA_ID, this.loanType.toString());
		this.data.put(LOAN_AMOUNT_DATA_ID, BigDecimal.TEN);
	}

	/**
	 * returns a SHALLOW copy
	 * 
	 * https://www.digitalocean.com/community/tutorials/java-clone-object-cloning-java
	 */
	@Override
	protected LoanRequestPreLoadedTemplate clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new LoanRequestPreLoadedTemplate(this.loanType, this.data);
	}

	@Override
	public String toString() {
		return "LoanRequestPreLoadedTemplate [loanType=" + loanType + ", productType=" + productType + ", data=" + data
				+ "]";
	}	
}
