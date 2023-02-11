package py.com.patterns.api.chainofresponsabilities.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest.ClientType;
import py.com.patterns.api.chainofresponsabilities.bean.CommonSearchOfferRequest.OfferType;
import py.com.patterns.api.chainofresponsabilities.bean.CommonTransportSearchOfferRequest.TransportType;
import py.com.patterns.api.chainofresponsabilities.bean.impl.FlightSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.impl.FlightSearchOfferRequest.SeatType;
import py.com.patterns.api.chainofresponsabilities.bean.impl.LodgmentSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.impl.LodgmentSearchOfferRequest.LodgmentStars;
import py.com.patterns.api.chainofresponsabilities.bean.impl.OverLandAndLodgmentSearchOfferRequest;
import py.com.patterns.api.chainofresponsabilities.bean.impl.OverLandSearchOfferRequest.Speed;
import py.com.patterns.api.chainofresponsabilities.receiver.impl.FlightSearchOfferRequestProcessor;
import py.com.patterns.api.chainofresponsabilities.receiver.impl.OverLandAndLodgmentSearchOfferRequestProcessor;
import py.com.patterns.api.chainofresponsabilities.receiver.impl.RequestMainProcessor;

public class ChainOfResponsabilitiesApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("\n ##################################"
				+"\n ChainOfResponsabilitiesApplication"
				+"\n ###############################");
		
		OverLandAndLodgmentSearchOfferRequestProcessor landAndLodgmentPeocessor = new OverLandAndLodgmentSearchOfferRequestProcessor(null);
		FlightSearchOfferRequestProcessor flightProcessor = new FlightSearchOfferRequestProcessor(landAndLodgmentPeocessor);
		RequestMainProcessor mainProcessor = new RequestMainProcessor(flightProcessor);
		Map<String,Object> data = new HashMap<>();
		data.put("CUSTOMER_ID", "123456789");
		FlightSearchOfferRequest request1 = new FlightSearchOfferRequest(OfferType.FLIGHT, ClientType.RETAIL_VIP, data, TransportType.NON_STOP, SeatType.ORDINARY);
		OverLandAndLodgmentSearchOfferRequest request2 = new OverLandAndLodgmentSearchOfferRequest(OfferType.OVERLAND_LODGMENT_PACKAGE, ClientType.WHOLESALER_VIP, data, TransportType.LAYOVER, Speed.FAST, LodgmentStars.THREE);
		LodgmentSearchOfferRequest request3 = new LodgmentSearchOfferRequest(OfferType.LODGMENT, ClientType.WHOLESALER, data, LodgmentStars.TWO);
	
		List<CommonSearchOfferRequest> requestList = new ArrayList<>();
		requestList.add(request1);
		requestList.add(request2);
		requestList.add(request3);
		boolean requestProcessed = false;
		for(CommonSearchOfferRequest request: requestList) {
			requestProcessed = mainProcessor.processRequest(request);
			log.info("\n .................................."
					+"\n request processed: " + requestProcessed
					+"\n request data: " + request.getData()
					+"\n ..................................");
		}
		
	}

}
