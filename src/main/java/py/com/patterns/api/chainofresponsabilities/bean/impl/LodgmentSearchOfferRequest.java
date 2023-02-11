package py.com.patterns.api.chainofresponsabilities.bean.impl;

import java.util.Map;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;

public class LodgmentSearchOfferRequest extends CommonSearchOfferRequest {

	public enum LodgmentStars{
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE
	}
	
	protected final LodgmentStars lodgmentStars;
	
	public LodgmentSearchOfferRequest(OfferType offerType, ClientType clientType, Map<String, Object> data, LodgmentStars lodgmentStars) {
		super(offerType, clientType, data);
		this.lodgmentStars = lodgmentStars;
		// TODO Auto-generated constructor stub
	}

	public LodgmentStars getLodgmentStars() {
		return lodgmentStars;
	}	
}
