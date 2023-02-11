package py.com.patterns.api.chainofresponsabilities.bean.impl;

import java.util.Map;

import py.com.patterns.api.chainofresponsabilities.bean.impl.LodgmentSearchOfferRequest.LodgmentStars;

public class FlightAndLodgmentSearchOfferRequest extends FlightSearchOfferRequest {	
	
	protected final LodgmentStars lodgmentStars;
	
	public FlightAndLodgmentSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data,
			TransportType transportType, SeatType seatType, LodgmentStars lodgmentStars) {
		super(offerType, clientType, data, transportType, seatType);
		this.lodgmentStars = lodgmentStars;
		// TODO Auto-generated constructor stub
	}

	public LodgmentStars getLodgmentStars() {
		return lodgmentStars;
	}	
}
