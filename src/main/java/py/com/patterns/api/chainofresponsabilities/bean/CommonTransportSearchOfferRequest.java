package py.com.patterns.api.chainofresponsabilities.bean;

import java.util.Map;

public abstract class CommonTransportSearchOfferRequest extends CommonSearchOfferRequest {

	public enum TransportType{
		NON_STOP,
		LAYOVER
	}	
	
	protected final TransportType transportType;
	
	public CommonTransportSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data, TransportType transportType) {
		super(offerType, clientType, data);
		this.transportType = transportType;
		// TODO Auto-generated constructor stub
	}

	public TransportType getFlightType() {
		return transportType;
	}
}
