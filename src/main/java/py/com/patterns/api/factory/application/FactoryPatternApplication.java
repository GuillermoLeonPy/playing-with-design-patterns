package py.com.patterns.api.factory.application;

import py.com.patterns.api.factory.WholeSaleSupplierFlightOperator;
import py.com.patterns.api.factory.manufactory.FlightOperatorFactory;
import py.com.patterns.api.factory.manufactory.FlightOperatorFactory.FlightOperator;
import py.com.patterns.api.factory.manufactory.impl.SpringFlightOperatorFactory;

public class FactoryPatternApplication {

	public static void main(String[] args) {
		FlightOperatorFactory flightOperatorFactory = new SpringFlightOperatorFactory();
		WholeSaleSupplierFlightOperator amadeustOperator = flightOperatorFactory.getWholeSaleSupplier(FlightOperator.AMADEUS);
		amadeustOperator.getFlightOffers(null);
	}

}
