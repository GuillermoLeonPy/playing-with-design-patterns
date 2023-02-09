package py.com.patterns.api.abstractfactory.manufactory.impl;

import java.util.Map;

import py.com.patterns.api.abstractfactory.bean.behaviour.Loan;
import py.com.patterns.api.abstractfactory.bean.loan.impl.FirstHomeLoan;
import py.com.patterns.api.abstractfactory.bean.loan.impl.OkmVehicleLoan;
import py.com.patterns.api.abstractfactory.bean.loan.impl.SmallMediumBusinessInvestmentLoan;
import py.com.patterns.api.abstractfactory.bean.loan.impl.UsedVehicleLoan;
import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory;
/**
 * Factory implementation for Loan
 * 
 * @author test-user
 *
 */
public class LoanAbstractFactoryImpl implements AbstractFactory<Loan> {

	public LoanAbstractFactoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Loan create(Map<String, Object> data) {
		// TODO Auto-generated method stub
		LoanType loanType = (LoanType) data.get(LOAN_TYPE_DATA_ID);
		switch(loanType) {
			case FIRST_HOME:
				return new FirstHomeLoan();
			case SMALL_MEDIUM_BUSINESS_INVESTMEN:
				return new SmallMediumBusinessInvestmentLoan();
			case OKM_VEHICLE:
				return new OkmVehicleLoan();
			default:
				return new UsedVehicleLoan();
		}
	}

}
