package py.com.patterns.api.mediator.behaviour;

import java.util.Map;

public abstract class AbstractForm implements FormVehaviour {

	private final Mediator mediator;
	private final Map<String,Object> data;
	
	public AbstractForm(Mediator mediator, Map<String,Object> data) {
		// TODO Auto-generated constructor stub
		this.mediator = mediator;
		this.data = data;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public Map<String, Object> getData() {
		return data;
	}
	
	@Override
	public boolean thereIsNextStep(Map<String,Object> data) {
		// TODO Auto-generated method stub
		return mediator.thereIsNextStep(data);
	}
}
