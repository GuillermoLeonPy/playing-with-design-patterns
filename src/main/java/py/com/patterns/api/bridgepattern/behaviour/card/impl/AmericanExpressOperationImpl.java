package py.com.patterns.api.bridgepattern.behaviour.card.impl;

import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation;

public class AmericanExpressOperationImpl implements CardOperation {

	public AmericanExpressOperationImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> getCardData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> doTransaction(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> unDoTransaction(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardProvider getCardProvider() {
		// TODO Auto-generated method stub
		return CardProvider.AMERICAN_EXPRESS;
	}

}
