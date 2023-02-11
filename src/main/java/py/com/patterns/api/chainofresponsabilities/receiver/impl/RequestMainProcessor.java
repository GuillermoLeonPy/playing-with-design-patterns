package py.com.patterns.api.chainofresponsabilities.receiver.impl;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.receiver.RequestProcessorBehaviour;

public class RequestMainProcessor implements RequestProcessorBehaviour {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	protected final RequestProcessorBehaviour nextProcessor;
	
	public RequestMainProcessor(RequestProcessorBehaviour nextProcessor) {
		this.nextProcessor = nextProcessor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processRequest(CommonSearchOfferRequest request) {
		// TODO Auto-generated method stub
		/**
		 * maybe some common validations logic...
		 */
		
		return nextProcessor.processRequest(request);
	}

}
