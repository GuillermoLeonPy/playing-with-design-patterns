package py.com.patterns.api.abstractfactory.manufactory.behaviour;

import java.util.Map;
/**
 * Abstract factory definition for Loan and FundingSource
 * 
 * @author test-user
 *
 * @param <T>
 */
public interface AbstractFactory<T> {
	
	public enum LoanType{
		FIRST_HOME,
		OKM_VEHICLE,
		USED_VEHICLE,
		SMALL_MEDIUM_BUSINESS_INVESTMEN
	}
	
	public final String LOAN_TYPE_DATA_ID = "LOAN_TYPE";
	
	public enum FundingSourceType{
		AFD,
		OWN
	}
	
	public final String FUNDING_SOURCE_TYPE_DATA_ID = "FUNDING_SOURCE_TYPE";
		
	T create(Map<String,Object> data);
}
