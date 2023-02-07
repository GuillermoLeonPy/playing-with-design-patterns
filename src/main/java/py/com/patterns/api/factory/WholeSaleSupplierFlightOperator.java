package py.com.patterns.api.factory;

import java.util.Map;

public interface WholeSaleSupplierFlightOperator {

	Map<String,Object> getFlightOffers(Map<String,Object> searchCriteria);
	Map<String,Object> doBooking(Map<String,Object> searchCriteria);
	Map<String,Object> unDoBooking(Map<String,Object> searchCriteria);
}
