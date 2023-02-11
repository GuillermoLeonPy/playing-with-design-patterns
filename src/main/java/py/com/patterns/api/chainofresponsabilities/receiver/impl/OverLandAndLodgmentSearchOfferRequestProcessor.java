package py.com.patterns.api.chainofresponsabilities.receiver.impl;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.impl.OverLandAndLodgmentSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.receiver.RequestProcessorBehaviour;

public class OverLandAndLodgmentSearchOfferRequestProcessor implements RequestProcessorBehaviour {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	protected final RequestProcessorBehaviour nextProcessor;
	
	public OverLandAndLodgmentSearchOfferRequestProcessor(RequestProcessorBehaviour nextProcessor) {
		this.nextProcessor = nextProcessor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processRequest(CommonSearchOfferRequest request) {
		// TODO Auto-generated method stub
		if(request instanceof OverLandAndLodgmentSearchOfferRequest) {
			OverLandAndLodgmentSearchOfferRequest landLodgmentRequest = (OverLandAndLodgmentSearchOfferRequest) request;
			/**
			 * is there any data lost as a consequence of the cast ? 
			 */
			request.addData(request.REQUEST_PROCESSOR_DATA_ID, "OverLandAndLodgmentSearchOfferRequestProcessor");
			log.info("\n ==================="
					+"\n OverLandAndLodgmentSearchOfferRequestProcessor"
					+"\n land lodgment request"
					+"\n ---------------------"
					+"\n" + landLodgmentRequest.toString()
					+"\n ===================");
			
			return true;
		}else if( nextProcessor == null) {
			return false;
		}else {
			return nextProcessor.processRequest(request);	
		}
	}

}
