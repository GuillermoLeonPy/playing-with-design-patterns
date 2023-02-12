package py.com.patterns.api.bridgepattern.behaviour.transactionprocessor;

import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.CardOperation;

public abstract class OutsourcedTransactionProcessor {

	protected final CardOperation cardOperation;
	
	
	public static final String TRANSACTION_CARD_NUMBER_DATA_ID = "TRANSACTION_CARD_NUMBER_ID";
	
	public static final String TRANSACTION_TYPE_DATA_ID = "TRANSACTION_TYPE_ID";
	public static final String TRANSACTION_TYPE_PAYMENT = "PAYMENT";
	public static final String TRANSACTION_TYPE_UNDO_PAYMENT = "UNDO_PAYMENT";	
	public static final String TRANSACTION_TYPE_GET_TRANSACTION_INFO = "GET_TRANSACTION_INFO";	
	
	public static final String TRANSACTION_AMOUNT_DATA_ID = "TRANSACTION_AMOUNT_ID";
	public static final String TRANSACTION_INSTALLMENTS_NUMBER_DATA_ID = "TRANSACTION_INSTALLMENTS_NUMBER_ID";
	public static final String TRANSACTION_CURRENCY_DATA_ID = "TRANSACTION_CURRENCY_ID";
	
	public static final String TRANSACTION_PROCESSOR_CREDENTIAL_USER_DATA_ID = "USER";
	public static final String TRANSACTION_PROCESSOR_CREDENTIAL_PASSWORD_DATA_ID = "PASSWORD";
	
	
	public OutsourcedTransactionProcessor(CardOperation cardOperation) {
		// TODO Auto-generated constructor stub
		this.cardOperation = cardOperation;
	}
	
	public abstract Map<String,Object> doTransaction(Map<String,Object> data);
	public abstract Map<String,Object> unDoTransaction(Map<String,Object> data);

}
