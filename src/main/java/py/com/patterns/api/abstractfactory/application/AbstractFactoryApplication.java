package py.com.patterns.api.abstractfactory.application;


import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.abstractfactory.bean.behaviour.FundingSource;
import py.com.patterns.api.abstractfactory.bean.behaviour.Loan;
import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory;
import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory.FundingSourceType;
import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory.LoanType;
import py.com.patterns.api.abstractfactory.manufactory.provider.FactoryProvider;
import py.com.patterns.api.abstractfactory.manufactory.provider.FactoryProvider.FactoryType;

public class AbstractFactoryApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("\n =========================="
				+"\n AbstractFactoryApplication"
				+"\n ==========================");
		FactoryProvider factoryProvider = new FactoryProvider();
		/** 
		 * this warning
		 * Type safety: Unchecked cast from AbstractFactory<capture#2-of ?> to AbstractFactory<Loan> 
		 * is the price of not defining two factory classes
		 * LoanFactory and FundingSourceFactory
		 *  */
		AbstractFactory<Loan> loanSourceFactory = (AbstractFactory<Loan>) factoryProvider.getFactory(FactoryType.LOAN);
		Map<String,Object> loanData = new HashMap<String,Object>();
		loanData.put(loanSourceFactory.LOAN_TYPE_DATA_ID, LoanType.FIRST_HOME);
		Loan loan = loanSourceFactory.create(loanData);

		log.info("\n --------------------------"
				+"\n Loan created: " + loan.getClass().getName()
				+"\n --------------------------");

		/** 
		 * this warning
		 * Type safety: Unchecked cast from AbstractFactory<capture#4-of ?> to AbstractFactory<FundingSource> 
		 * is the price of not defining two factory classes 
		 * LoanFactory and FundingSourceFactory
		 * */
		AbstractFactory<FundingSource> fundingSourceFactory = (AbstractFactory<FundingSource>) factoryProvider.getFactory(FactoryType.FUNDING_SOURCE);
		Map<String,Object> fundingSourceData = new HashMap<String,Object>();
		fundingSourceData.put(fundingSourceFactory.FUNDING_SOURCE_TYPE_DATA_ID, FundingSourceType.AFD);
		FundingSource fundingSource = fundingSourceFactory.create(fundingSourceData);
		log.info("\n --------------------------"
				+"\n FundingSource created: " + fundingSource.getClass().getName()
				+"\n --------------------------");
		fundingSource.authorize(loan);
	}

}
