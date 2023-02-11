package py.com.patterns.api.chainofresponsabilities.receiver.impl;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.impl.FlightSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.receiver.RequestProcessorBehaviour;

public class FlightSearchOfferRequestProcessor implements RequestProcessorBehaviour {
	
	private static final Logger log = getLogger(lookup().lookupClass());
	
	protected final RequestProcessorBehaviour nextProcessor;
	
	public FlightSearchOfferRequestProcessor(RequestProcessorBehaviour nextProcessor) {
		this.nextProcessor = nextProcessor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processRequest(CommonSearchOfferRequest request) {
		//log.info("\n request instance of: " + request.getClass());		
		if(request instanceof FlightSearchOfferRequest) {
			FlightSearchOfferRequest flightRequest = (FlightSearchOfferRequest) request;
			/**
			 * is there any data lost as a consequence of the cast ? 
			 */
			request.addData(request.REQUEST_PROCESSOR_DATA_ID, "FlightSearchOfferRequestProcessor");
			log.info("\n ==================="
					+"\n FlightSearchOfferRequestProcessor"
					+"\n flight request"
					+"\n --------------"
					+"\n" + flightRequest.toString()
					+"\n ===================");
			
			return true;
		}else if( nextProcessor == null) {
			return false;
		}else {
			return nextProcessor.processRequest(request);	
		}
		
	}
}
