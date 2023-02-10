package py.com.patterns.api.mediator.behaviour.mediator.impl;


import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.mediator.behaviour.FormVehaviour;
import py.com.patterns.api.mediator.behaviour.Mediator;
import py.com.patterns.api.mediator.behaviour.form.impl.ConfirmLoanRequestForm;
import py.com.patterns.api.mediator.behaviour.form.impl.RequestLoanForm;
import py.com.patterns.api.mediator.behaviour.form.impl.SelectLoanFundingSourceForm;
import py.com.patterns.api.mediator.behaviour.form.impl.SelectLoanTermAndRateForm;

public class LoanProcessMediator implements Mediator {

	public enum PROCESS_FORM{
		CREATE_REQUEST,
		SELECT_FUNDING_SOURCE,
		SELECT_TERM_AND_RATES,
		CONFIRM_REQUEST
	}

	private final List<String> processSequenceFormList;
	
	{
		processSequenceFormList = new ArrayList<>();
		processSequenceFormList.add(PROCESS_FORM.CREATE_REQUEST.toString());
		processSequenceFormList.add(PROCESS_FORM.SELECT_FUNDING_SOURCE.toString());
		processSequenceFormList.add(PROCESS_FORM.SELECT_TERM_AND_RATES.toString());
		processSequenceFormList.add(PROCESS_FORM.CONFIRM_REQUEST.toString());
	}
	
	private static final Logger log = getLogger(lookup().lookupClass());
	
	public LoanProcessMediator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FormVehaviour resumeProcess(Map<String, Object> data) {
		// TODO Auto-generated method stub
		if(!data.containsKey(CURRENT_FORM_STEP_DATA_ID)) {
			data.put(CURRENT_FORM_STEP_DATA_ID, PROCESS_FORM.CREATE_REQUEST.toString());
			return new RequestLoanForm(this, data);
		}else if(data.get(CURRENT_FORM_STEP_DATA_ID).equals(PROCESS_FORM.CREATE_REQUEST.toString())) {
			data.put(CURRENT_FORM_STEP_DATA_ID, PROCESS_FORM.SELECT_FUNDING_SOURCE.toString());
			return new SelectLoanFundingSourceForm(this, data);
		}else if(data.get(CURRENT_FORM_STEP_DATA_ID).equals(PROCESS_FORM.SELECT_FUNDING_SOURCE.toString())) {
			data.put(CURRENT_FORM_STEP_DATA_ID, PROCESS_FORM.SELECT_TERM_AND_RATES.toString());
			return new SelectLoanTermAndRateForm(this, data);
		}else {
			data.put(CURRENT_FORM_STEP_DATA_ID, PROCESS_FORM.CONFIRM_REQUEST.toString());
			return new ConfirmLoanRequestForm(this, data);
		}
	}

	@Override
	public FormVehaviour proceedToNextStepForm(FormVehaviour currentForm) {
		// TODO Auto-generated method stub
		/*some logic according to the current step form
		 * calculations..
		 * maybe persistence layer related..
		 * */
		return resumeProcess(currentForm.getData());
	}

	@Override
	public FormVehaviour goBackToPreviousStepForm(FormVehaviour currentForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveParcialProcess() {
		// TODO Auto-generated method stub
		/*some logic according to the current step form
		 * calculations..
		 * maybe persistence layer related..
		 * */
	}

	@Override
	public List<String> getProcessSequenceFormList() {
		// TODO Auto-generated method stub
		return processSequenceFormList;
	}

	@Override
	public boolean thereIsNextStep(Map<String,Object> data) {
		// TODO Auto-generated method stub

		return processSequenceFormList.indexOf(data.get(CURRENT_FORM_STEP_DATA_ID)) != processSequenceFormList.size() - 1;
	}

}
