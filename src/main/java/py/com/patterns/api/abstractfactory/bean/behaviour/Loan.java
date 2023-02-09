package py.com.patterns.api.abstractfactory.bean.behaviour;

import java.util.Map;

public interface Loan {
	Map<String,Object> getData();
	void addData(String dataId, Object dataContent);
	void proceedToNextStage();
}
