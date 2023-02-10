package py.com.patterns.api.mediator.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.mediator.behaviour.FormVehaviour;
import py.com.patterns.api.mediator.behaviour.Mediator;
import py.com.patterns.api.mediator.behaviour.mediator.impl.LoanProcessMediator;

public class MediatorApplication {

	private static final Logger log = getLogger(lookup().lookupClass());	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n MediatorApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		
		Mediator mediator = new LoanProcessMediator();
		Map<String, Object> loanData = new HashMap<>();
		FormVehaviour form = mediator.resumeProcess(loanData);
		while (form.thereIsNextStep(form.getData())) {
			log.info("\n -------------------"
					+"\n before form submit"
					+"\n form class: " + form.getClass().getName()
					+"\n form data: " + form.getData()					
					+"\n -------------------");
			form = form.submitAndStepForward(form.getData());
			log.info("\n ->->->->->->->->->---"
					+"\n after form submit"
					+"\n form class: " + form.getClass().getName()
					+"\n form data: " + form.getData()
					+"\n" + (form.thereIsNextStep(form.getData()) ? "further steps ahead" : "no further steps ahead")
					+"\n ->->->->->->->->->---");
		}
		
	}

}
