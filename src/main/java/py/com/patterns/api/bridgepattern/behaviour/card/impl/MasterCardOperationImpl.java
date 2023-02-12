package py.com.patterns.api.bridgepattern.behaviour.card.impl;

import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation;
import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation.CardProvider;

public class MasterCardOperationImpl implements CardOperation {

	public MasterCardOperationImpl() {
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
		return CardProvider.MASTER_CARD;
	}

}
