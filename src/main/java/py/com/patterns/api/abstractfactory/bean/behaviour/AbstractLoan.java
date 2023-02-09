package py.com.patterns.api.abstractfactory.bean.behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLoan implements Loan {

	private final Map<String,Object> data;
	
	public AbstractLoan() {
		data = new HashMap<String,Object>();
	}

	@Override
	public Map<String, Object> getData() {
		// TODO Auto-generated method stub
		return data;
	}
	
	@Override
	public void addData(String dataId, Object dataContent) {
		data.put(dataId, dataContent);		
	}
}
