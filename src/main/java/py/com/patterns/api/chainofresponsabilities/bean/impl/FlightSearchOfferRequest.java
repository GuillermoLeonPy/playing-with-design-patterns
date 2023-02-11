package py.com.patterns.api.chainofresponsabilities.bean.impl;

import java.util.Map;
import py.com.patterns.api.chainofresponsabilities.bean.CommonTransportSearchOfferRequest;

public class FlightSearchOfferRequest extends CommonTransportSearchOfferRequest {

	public enum SeatType{
		FIRST_CLASS,
		SECOND_CLASS,
		ORDINARY
	}
	
	protected final SeatType seatType;
	
	public FlightSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data,
			TransportType transportType, SeatType seatType) {
		super(offerType, clientType, data, transportType);
		this.seatType = seatType;
		// TODO Auto-generated constructor stub
	}

	public SeatType getSeatType() {
		return seatType;
	}

	@Override
	public String toString() {
		return "FlightSearchOfferRequest [seatType=" + seatType + ", transportType=" + transportType + ", offerType="
				+ offerType + ", clientType=" + clientType + ", data=" + data + "]";
	}	
}
