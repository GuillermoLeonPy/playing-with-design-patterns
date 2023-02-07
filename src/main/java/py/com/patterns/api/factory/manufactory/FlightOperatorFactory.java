package py.com.patterns.api.factory.manufactory;

import py.com.patterns.api.factory.WholeSaleSupplierFlightOperator;

public interface FlightOperatorFactory {

	enum FlightOperator{
		AMADEUS,
		TRAVELPORT
	}
	
	WholeSaleSupplierFlightOperator getWholeSaleSupplier(FlightOperator flightOperator);
}
