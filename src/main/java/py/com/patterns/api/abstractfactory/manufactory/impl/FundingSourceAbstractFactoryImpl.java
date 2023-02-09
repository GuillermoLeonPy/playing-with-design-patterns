package py.com.patterns.api.abstractfactory.manufactory.impl;

import java.util.Map;

import py.com.patterns.api.abstractfactory.bean.behaviour.FundingSource;
import py.com.patterns.api.abstractfactory.bean.fundingsource.impl.AfdFundingSource;
import py.com.patterns.api.abstractfactory.bean.fundingsource.impl.OwnFoundFundingSource;
import py.com.patterns.api.abstractfactory.manufactory.behaviour.AbstractFactory;
/**
 * Factory implementation for FundingSource
 * 
 * @author test-user
 *
 */
public class FundingSourceAbstractFactoryImpl implements AbstractFactory<FundingSource> {

	public FundingSourceAbstractFactoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FundingSource create(Map<String, Object> data) {
		// TODO Auto-generated method stub
		FundingSourceType fundingSourceType = (FundingSourceType) data.get(FUNDING_SOURCE_TYPE_DATA_ID);
		switch (fundingSourceType) {
			case AFD:
				return new AfdFundingSource();
			default:
				return new OwnFoundFundingSource();
		}
	}

}
