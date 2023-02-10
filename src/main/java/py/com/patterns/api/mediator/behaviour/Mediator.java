package py.com.patterns.api.mediator.behaviour;

import java.util.List;
import java.util.Map;

public interface Mediator {

	public enum Process{
		LOAN_REQUEST,
		CREDIT_CARD_REQUEST,
		FIXED_TERM_SAVINGS_ACCOUNT_REQUEST,
		DEMAND_SAVINGS_ACCOUNT_REQUEST
	}
	
	final String CURRENT_FORM_STEP_DATA_ID = "CURRENT_FORM_STEP";
	
	FormVehaviour resumeProcess(Map<String,Object> data);
	FormVehaviour proceedToNextStepForm(FormVehaviour currentForm);
	FormVehaviour goBackToPreviousStepForm(FormVehaviour currentForm);
	void saveParcialProcess();
	List<String> getProcessSequenceFormList();
	boolean thereIsNextStep(Map<String,Object> data);
	
}
