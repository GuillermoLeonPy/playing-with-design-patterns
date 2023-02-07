package py.com.patterns.api.factory.manufactory;

import py.com.patterns.api.factory.manufactory.FlightOperatorFactory.FlightOperator;

public interface AbstractFlightOperatorFactory<T> {
	T getWholeSaleSupplier(FlightOperator flightOperator);
}
