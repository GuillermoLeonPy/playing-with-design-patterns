package py.com.patterns.api.mediator.behaviour.form.impl;

import java.util.Map;

import py.com.patterns.api.mediator.behaviour.AbstractForm;
import py.com.patterns.api.mediator.behaviour.FormVehaviour;
import py.com.patterns.api.mediator.behaviour.Mediator;

public class RequestLoanForm extends AbstractForm {

	public RequestLoanForm(Mediator mediator, Map<String,Object> data) {
		super(mediator, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public FormVehaviour submitAndStepForward(Map<String, Object> data) {
		// TODO Auto-generated method stub
		/*maybe some business logic implementation...*/
		return this.getMediator().proceedToNextStepForm(this);
	}

	@Override
	public Map<String, Object> saveCurrentProgress(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}
}
