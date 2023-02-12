package py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.impl;

import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation;
import py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.OutsourcedTransactionProcessor;

public class ProcardTransactionProcessor extends OutsourcedTransactionProcessor {

	public ProcardTransactionProcessor(CardOperation cardOperation) {
		super(cardOperation);
		// TODO Auto-generated constructor stub
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

}
