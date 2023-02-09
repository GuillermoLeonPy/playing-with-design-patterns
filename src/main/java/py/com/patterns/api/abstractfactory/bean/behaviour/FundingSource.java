package py.com.patterns.api.abstractfactory.bean.behaviour;

import java.util.Map;

public interface FundingSource {
	Map<String,Object> getData();
	void addData(String dataId, Object dataContent);
	void authorize(Loan loan);
	
}
