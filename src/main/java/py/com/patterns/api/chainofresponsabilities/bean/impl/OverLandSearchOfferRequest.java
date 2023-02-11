package py.com.patterns.api.chainofresponsabilities.bean.impl;

import java.util.Map;

import py.com.patterns.api.chainofresponsabilities.bean.CommonTransportSearchOfferRequest;

public class OverLandSearchOfferRequest extends CommonTransportSearchOfferRequest {

	public enum Speed{
		ORDINARY,
		FAST
	}
	
	protected final Speed speed;
	
	public OverLandSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data,
			TransportType transportType, Speed speed) {
		super(offerType, clientType, data, transportType);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	public Speed getSpeed() {
		return speed;
	}
}
