package py.com.patterns.api.factory.manufactory.impl;

import py.com.patterns.api.factory.WholeSaleSupplierFlightOperator;
import py.com.patterns.api.factory.impl.AmadeusFlightOperatorImpl;
import py.com.patterns.api.factory.impl.TravelPortFlightOperatorImpl;
import py.com.patterns.api.factory.manufactory.FlightOperatorFactory;

public class SpringFlightOperatorFactory implements FlightOperatorFactory {

	public SpringFlightOperatorFactory() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Spring library managed WholeSaleSupplierFlightOperator pool
	 * 
	 */
	@Override
	public WholeSaleSupplierFlightOperator getWholeSaleSupplier(FlightOperator flightOperator) {
		switch(flightOperator) {
			case AMADEUS:
				return new AmadeusFlightOperatorImpl();
			default:
				return new TravelPortFlightOperatorImpl();
		}		
	}

}
