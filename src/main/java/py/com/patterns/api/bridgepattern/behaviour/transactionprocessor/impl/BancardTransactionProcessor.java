package py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.impl;

import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation;
import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation.CardProvider;
import py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.OutsourcedTransactionProcessor;

public class BancardTransactionProcessor extends OutsourcedTransactionProcessor {

	public BancardTransactionProcessor(CardOperation cardOperation) {
		super(cardOperation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> doTransaction(Map<String, Object> data) {
		// TODO Auto-generated method stub		
		return cardOperation.doTransaction(getDataKeysAndValuesForProcessorAndCardProvider(data));
	}

	@Override
	public Map<String, Object> unDoTransaction(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return cardOperation.doTransaction(getDataKeysAndValuesForProcessorAndCardProvider(data));
	}
	
	private Map<String, Object> getDataKeysAndValuesForProcessorAndCardProvider(Map<String, Object> data){
		/**
		 * prepare de data structure according the card processor and card provider
		 */
		CardProvider cardProvider = cardOperation.getCardProvider();
		switch(cardProvider) {
			case DINERS_CLUB:
				/*map transformation*/
			case AMERICAN_EXPRESS:
				/*map transformation*/
			default:
				/*map transformation*/
		}
		return data;
	}

}
