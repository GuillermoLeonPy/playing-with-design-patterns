package py.com.patterns.api.abstractfactory.bean.behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFundingSource implements FundingSource {

	private final Map<String,Object> data;
	
	public AbstractFundingSource() {
		data = new HashMap<String,Object>();
	}

	@Override
	public Map<String, Object> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void addData(String dataId, Object dataContent) {
		// TODO Auto-generated method stub
		data.put(dataId, dataContent);		
	}

}
