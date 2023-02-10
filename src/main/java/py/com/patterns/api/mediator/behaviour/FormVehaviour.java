package py.com.patterns.api.mediator.behaviour;

import java.util.Map;

public interface FormVehaviour {

	FormVehaviour submitAndStepForward(Map<String,Object> data);
	Map<String,Object> saveCurrentProgress(Map<String,Object> data);
	public Map<String, Object> getData();
	boolean thereIsNextStep(Map<String,Object> data);
}
