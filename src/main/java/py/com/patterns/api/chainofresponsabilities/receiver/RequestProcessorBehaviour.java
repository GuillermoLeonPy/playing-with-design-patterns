package py.com.patterns.api.chainofresponsabilities.receiver;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;

public interface RequestProcessorBehaviour {
	
	boolean processRequest(CommonSearchOfferRequest request);
}
