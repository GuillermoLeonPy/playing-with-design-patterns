package py.com.patterns.api.chainofresponsabilities.bean;

import java.util.Map;

public abstract class CommonSearchOfferRequest {

	public enum OfferType{
		FLIGHT,
		LODGMENT,
		FLIGHT_LODGMENT_PACKAGE,
		OVERLAND,
		OVERLAND_LODGMENT_PACKAGE		
	}
	
	public enum ClientType{
		RETAIL,
		RETAIL_VIP,
		WHOLESALER,
		WHOLESALER_VIP
	}
	
	public final String REQUEST_PROCESSOR_DATA_ID = "REQUEST_PROCESSOR_ID";
	
	protected final OfferType offerType;
	protected final ClientType clientType;
	protected final Map<String,Object> data;
	
	public CommonSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String,Object> data) {
		// TODO Auto-generated constructor stub
		this.offerType = offerType;
		this.clientType = clientType;
		this.data = data;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public Map<String, Object> getData() {
		return data;
	}
	
	public Object addData(String dataId, Object dataValue) {
		return data.put(dataId, dataValue);
	}
	
	public Object getDataById(String dataId) {
		return data.get(dataId);
	}

	public ClientType getClientType() {
		return clientType;
	}
}
