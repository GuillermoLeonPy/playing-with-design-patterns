package py.com.patterns.api.chainofresponsabilities.bean.impl;

import java.util.Map;

import py.com.patterns.api.chainofresponsabilities.bean.impl.LodgmentSearchOfferRequest.LodgmentStars;

public class OverLandAndLodgmentSearchOfferRequest extends OverLandSearchOfferRequest {

	protected final LodgmentStars lodgmentStars;
	
	public OverLandAndLodgmentSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data,
			TransportType transportType, Speed speed, LodgmentStars lodgmentStars) {
		super(offerType, clientType, data, transportType, speed);
		this.lodgmentStars = lodgmentStars;
		// TODO Auto-generated constructor stub
	}

	public LodgmentStars getLodgmentStars() {
		return lodgmentStars;
	}

	@Override
	public String toString() {
		return "OverLandAndLodgmentSearchOfferRequest [lodgmentStars=" + lodgmentStars + ", speed=" + speed
				+ ", transportType=" + transportType + ", offerType=" + offerType + ", clientType=" + clientType
				+ ", data=" + data + "]";
	}	
}
