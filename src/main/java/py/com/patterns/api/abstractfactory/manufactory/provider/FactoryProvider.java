package py.com.patterns.api.abstractfactory.manufactory.provider;

import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory;
import py.com.patterns.api.abstractfactory.manufactory.impl.FundingSourceAbstractFactoryImpl;
import py.com.patterns.api.abstractfactory.manufactory.impl.LoanAbstractFactoryImpl;

public class FactoryProvider {

	public enum FactoryType{
		LOAN,
		FUNDING_SOURCE
	}
	
	public FactoryProvider() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this is the price of not defining to factory classes
	 *  
	 * @param factoryType
	 * @return
	 */
	public AbstractFactory<?> getFactory(FactoryType factoryType) {
		switch (factoryType) {
			case LOAN:
				return new LoanAbstractFactoryImpl();
			default:
				return new FundingSourceAbstractFactoryImpl();
		}
	}
	
}

